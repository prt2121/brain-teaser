module Hw8 where

-- liftM :: Monad m => (a1 -> r) -> m a1 -> m r
-- Promote a function to a monad: lets a non-monadic function f operate on the contents of monad m
liftM :: Monad m => (a -> b) -> m a -> m b
liftM f m = do x <- m
               return (f x)

liftM' :: Monad m => (a -> b) -> m a -> m b
liftM' f m = m >>= \x -> return (f x)


-- https://hackage.haskell.org/package/base-4.8.1.0/docs/Control-Monad.html#v:filterM
-- filterM :: Monad m => (a -> m Bool) -> [a] -> m [a]
-- This generalizes the list-based filter function.
-- http://members.chello.nl/hjgtuyl/tourdemonad.html
--     *Hw8> filterM' (\x -> Just (x > 0)) [2, 1, 0, -1]
--     Just [2,1]

filterM' :: Monad m => (a -> m Bool) -> [a] -> m [a]
filterM' _ [] = return []
filterM' p (x : xs)
    = do flag <- p x
         ys <- filterM' p xs
         if flag then return (x : ys) else return ys

-- Control-Monad.html#v:mapM
-- mapM' :: Monad m => (a -> m b) -> [a] -> m [b]
-- Map each element of a structure to a monadic action, evaluate these actions from left to right, and collect the results
--     *Hw8> mapM (\x -> [x]) [0, 1, 2]
--     [[0,1,2]]
--     *Hw8> mapM Just [0, 1, 2]
--     Just [0,1,2]
--     *Hw8> mapM print [0, 1, 2]
--     0
--     1
--     2
--     [(),(),()]

mapM' f as = sequence (map f as)

mapM'' f [] = return []
mapM'' f (a : as) = f a >>= \ b -> mapM'' f as >>= \ bs -> return (b : bs)

mapM''' f [] = return []
mapM''' f (a : as) =
    do
        b <- f a
        bs <- mapM''' f as
        return (b : bs)

mapM'''' f [] = return []
mapM'''' f (a : as)
    = f a >>=
        \ b ->
        do bs <- mapM'''' f as
           return (b : bs)

-- Control-Monad.html#v:sequence
-- Evaluate each monadic action in the structure from left to right, and collect the results.

--     *Hw8> sequence [Just 5, Nothing, Just 3]
--     Nothing
--     *Hw8> sequence [Just 5, Just 3]
--     Just [5,3]
--     *Hw8> sequence [[1], [2,3]]
--     [[1,2],[1,3]]
--     *Hw8> sequence [[1], []]
--     []

seq1' :: Monad m => [m t] -> m [t]
seq1' [] = return []
seq1' (m : ms)
    = m >>=
        \ a ->
          do  as <- seq1' ms
              return (a : as)

seq2' :: Monad m => [m t] -> m [t]
seq2' ms = foldr func (return []) ms
    where
        func :: (Monad m) => m a -> m [a] -> m [a]
        func m acc
            = do x  <- m
                 xs <- acc
                 return (x : xs)

seq3' [] = return []
seq3' (m : ms) = do a <- m
                    as <- seq3' ms
                    return (a : as)

foldLeftM :: Monad m => (a -> b -> m a) -> a -> [b] -> m a
foldLeftM acc a [] = return a
foldLeftM acc a (b : bs) = do a' <- acc a b
                              foldLeftM acc a' bs

foldRightM :: Monad m => (a -> b -> m b) -> b -> [a] -> m b
foldRightM acc b [] = return b
foldRightM acc b (a : as) = do b' <- foldRightM acc b as
                               acc a b'