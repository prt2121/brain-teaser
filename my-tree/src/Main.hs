module Main where

import Data.Maybe

last' xs = head (drop (length xs - 1) xs)

last'' xs = xs !! (length xs - 1)


data Tree a = Empty | Branch a (Tree a) (Tree a)
              deriving (Show, Eq)

data Direction = L | R deriving (Show)
type Directions = [Direction]

elemAt :: Directions -> Tree a -> Maybe a
elemAt (L:ds) (Branch _ l _) = elemAt ds l
elemAt (R:ds) (Branch _ _ r) = elemAt ds r
elemAt [] (Branch x _ _) = Just x
elemAt _ Empty = Nothing

value :: Tree a -> Maybe a
value Empty = Nothing
value (Branch x _ _) = Just x

right :: Tree a -> Tree a
right Empty          = Empty
right (Branch _ _ r) = r

left :: Tree a -> Tree a
left Empty          = Empty
left (Branch _ l _) = l

leaf :: a -> Tree a
leaf x = Branch x Empty Empty

isValidBst :: Ord a => Tree a -> Bool
isValidBst Empty      = True
isValidBst t          = isSubtreeLessThan (left t) (fromJust (value t))
                            && isSubtreeGreaterThan (right t) (fromJust (value t))
                            && isValidBst(left t) && isValidBst(right t)

isSubtreeLessThan :: Ord a => Tree a -> a -> Bool
isSubtreeLessThan Empty _ = True
isSubtreeLessThan t v     = (fromJust(value t) < v) && isSubtreeLessThan (left t) v && isSubtreeLessThan (right t) v

isSubtreeGreaterThan :: Ord a => Tree a -> a -> Bool
isSubtreeGreaterThan Empty _ = True
isSubtreeGreaterThan t v     = (fromJust(value t) > v) && isSubtreeGreaterThan (left t) v && isSubtreeGreaterThan (right t) v

tree1 :: Tree Char
tree1 = Branch 'a' (Branch 'b' (leaf 'd')
                                (leaf 'e'))
                    (Branch 'c' Empty
                                (Branch 'f' (leaf 'g')
                                            Empty))

t1 :: Tree Int
t1 = Branch 5
      (Branch 2 (leaf 1) (leaf 4))
      (Branch 9 (leaf 7) (Branch 12 (leaf 10) (leaf 15)))

t2 :: Tree Int
t2 = Branch 5
      (Branch 2 (leaf 1) (leaf 4))
      (Branch 9 (leaf 3) (leaf 12))

maxDepth :: Tree a -> Int
maxDepth Empty  = 0
maxDepth t      = 1 + max (maxDepth(left t)) (maxDepth(right t))

minDepth :: Tree a -> Int
minDepth Empty  = 0
minDepth t      = 1 + min (minDepth(left t)) (minDepth(right t))

isBalanced :: Tree a -> Bool
isBalanced Empty  = True
isBalanced t      = isBalanced(left t) && isBalanced(right t) && abs(maxDepth(left t) - maxDepth(right t)) <= 1

main :: IO ()
main = do
  putStrLn "hello world"
