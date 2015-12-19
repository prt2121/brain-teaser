-- http://learnyouahaskell.com/for-a-few-monads-more
-- Tasteful stateful computations
module Stack where

import Control.Monad.State

-- s -> (a,s)

type Stack = [Int]

pop' :: Stack -> (Int, Stack)
pop' (x:xs) = (x, xs)

push' :: Int -> Stack -> ((),Stack)
push' n s = ((), n:s)


-- Control.Monad.State
-- newtype State s a = State { runState :: s -> (a,s) }

pop :: State Stack Int
pop = state $ \(x:xs) -> (x, xs)

push :: Int -> State Stack ()
push a = state $ \xs -> ((), a:xs)

popPop :: State Stack [Int]
popPop = do
    a <- pop
    b <- pop
    return [a, b]