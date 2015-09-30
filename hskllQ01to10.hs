myLast [x] = x
myLast (x:xs) = myLast xs

myButLast [] = error "Can't all myButLast on an empty list"
myButLast [x] = error "Can't all myButLast on a list with 1 element"
myButLast (x:_:[]) = x
myButLast (x:xs) = myButLast xs

elementAt l n = l !! (n-1)

elementAt' l n = head (take n l)

elementAt'' (x:xs) 1 = x
elementAt'' (x:xs) n = elementAt'' xs n-1

elementAt''' = flip $ (last .) . take . (+1)

myLength l = foldr (\_ -> (+1)) 0 l
myLength' = foldr (\_ -> (+1)) 0
myLength'' = foldl (\x _ -> (x+1)) 0

-- length returns the length of a finite list as an Int. 
-- -- length  :: [a] -> Int 
-- -- length [] = 0 
-- -- length (_:l) = 1 + length l
--
-- -- cool stuff from the solution
mLen' xs = snd $ last $ zip xs [1..]
mLen''   = snd . last . (flip zip [1..])

myReverse (x:xs) = xs ++ [x]
-- well, the prelude version
theirReverse =  foldl (flip (:)) []

isPalindrome xs = xs == reverse xs

data NestedList a = Elem a | List [NestedList a]
flatten :: NestedList a -> [a]
flatten (Elem x) = [x]
flatten (List [])     = []
flatten (List (x:xs))  = flatten(x)++flatten(List(xs))  

compress' [] = []
compress' (x:xs) = if xs /= [] && x == (head xs)                    
                    then compress'(x:(tail xs))
																				else x:compress' xs
																					compress'' [] = []
																					compress'' (x:xs) = x: compress'' (drop (length $ takeWhile (== x) xs) xs)

--let chopHead l = span (==head l) l
--fst (chopHead l)
--chopHead l = span (==head l) l
--pack [] = []
--pack l = fst (packHead l): pack (snd (packHead l))
--	where packHead l = span (==head l) l
pack [] = []
pack l = fst (packHead l): pack (snd (packHead l))
	where packHead l = span (==head l) l
	
encode :: Eq a => [a] -> [(Int, a)]
encode l = map (\x ->(length x, head x)) (pack(l))

encode' :: Eq a => [a] -> [(Int, a)]
encode' = map (\x ->(length x, head x)) . pack
