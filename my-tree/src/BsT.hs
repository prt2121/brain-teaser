module BsT where

import Control.Applicative (Applicative(..), (<$>))
import Control.Monad
import Data.Monoid (Monoid(..))
import Data.Char

data BsT a = Node { v :: a
                   , l :: (BsT a)
                   , r :: (BsT a) }
                | Empty
                deriving (Eq, Show)

instance Functor BsT where
    fmap f Empty        = Empty
    fmap f (Node v l r) = Node (f v) (fmap f l) (fmap f r)

instance Applicative BsT where
    pure x                          = Node x Empty Empty
    (Node f l r) <*> (Node v l' r') = Node (f v) (l <*> l') (r <*> r')
    _ <*> _                         = Empty

insert :: Ord a => BsT a -> a -> BsT a
insert Empty v         =  leaf v
insert (Node v l r) v'
    | v' < v    =  Node v (insert l v') r
    | v' > v    =  Node v l (insert r v')
    | otherwise =  Node v l r  -- do nothing

leaf :: a -> BsT a
leaf n = Node n Empty Empty

traverseDepth :: BsT a -> [a]
traverseDepth Empty                 = []
traverseDepth (Node v l r)          = v : traverseDepth l ++ traverseDepth r

traverseBreadth :: BsT a -> [a]
traverseBreadth t                   = go [t]
    where
        go []               =  []
        go ts               =  concat(map val ts) ++ (go $ children ts)
        children ls         =  foldr (\x acc -> (branch x) ++ acc) [] ls

-- list of direct children
branch :: BsT t -> [BsT t]
branch Empty              =  []
branch (Node _ l Empty)   =  [l]
branch (Node _ Empty r)   =  [r]
branch (Node _ l r)       =  [l, r]

drawTree :: BsT String -> String
drawTree  = unlines . draw

draw :: BsT String -> [String]
draw Empty                  =  []
draw (Node v Empty Empty)   =  [v]
draw (Node v Empty r)       =  v : "|" : shift "`- " "   " (draw r)
draw (Node v l Empty)       =  v : "|" : shift "`- " "   " (draw l)
draw (Node v l r)           =  v : ((drawL l) ++ (drawR r))
    where
          drawL Empty       =  []
          drawL l           =  "|" : shift "+- " "|  " (draw l)
          drawR Empty       =  []
          drawR r           =  "|" : shift "`- " "   " (draw r)
shift :: [a] -> [a] -> [[a]] -> [[a]]
shift first other =  zipWith (++) (first : repeat other)

contain :: Ord a => BsT a -> a -> Bool
contain Empty v = False
contain (Node v l r) v'
    | v' < v = contain l v'
    | v' > v = contain r v'
    | otherwise = True

-- value of the root
value :: BsT a -> Maybe a
value Empty        = Nothing
value (Node v l r) = Just v

val :: BsT a -> [a]
val Empty           =  []
val (Node v _ _)    =  [v]

isLeaf :: BsT a -> Bool
isLeaf (Node v Empty Empty) = True
isLeaf _ = False

valid :: Ord a => BsT a -> Bool
valid Empty = True
valid (Node v l r) = (maybe True (<v) $ value l) && (maybe True (>v) $ value r) && valid l && valid r

t1 :: BsT Integer
t1 = Node 5
          (Node 2 (leaf 1)
                  (leaf 3))
          (Node 8
                  Empty
                  (Node 10 (leaf 9) (leaf 13)))

invalidT :: BsT Integer
invalidT = Node 5
          (Node 2 (leaf 1)
                  (leaf 3))
          (Node 8
                  (Node 10 (leaf 9) (leaf 13))
                  Empty)

t2 :: BsT Integer
t2 = Node 7
          (Node 4 (leaf 2)
                  (leaf 5))
          (leaf 9)

-- *BsT Data.Char> (+) <$> t1 <*> t2
-- Node {v = 12, l = Node {v = 6, l = Node {v = 3, l = Empty, r = Empty}, r = Node {v = 8, l = Empty, r = Empty}}, r = Node {v = 17, l = Empty, r = Empty}}

t3 :: BsT Char
t3 =
    Node 'P'
        (Node 'O'
            (Node 'L'
                (Node 'N' Empty Empty)
                (Node 'T' Empty Empty)
            )
            (Node 'Y'
                (Node 'S' Empty Empty)
                (Node 'A' Empty Empty)
            )
        )
        (Node 'L'
            (Node 'W'
                (Node 'C' Empty Empty)
                (Node 'R' Empty Empty)
            )
            (Node 'A'
                (Node 'A' Empty Empty)
                (Node 'C' Empty Empty)
            )
        )

--     *BsT> putStrLn $ drawTree (fmap show t1)
--     5
--     |
--     +- 2
--     |  |
--     |  +- 1
--     |  |
--     |  `- 3
--     |
--     `- 8
--        |
--        `- 10
--           |
--           +- 9
--           |
--           `- 13

--     *BsT> let newT1 = insert t2 10
--     *BsT> putStrLn $ drawTree $ fmap show $ newT1
--     7
--     |
--     +- 4
--     |  |
--     |  +- 2
--     |  |
--     |  `- 5
--     |
--     `- 9
--        |
--        `- 10
--
--     *BsT> putStrLn $ drawTree $ fmap show $ insert newT1 8
--     7
--     |
--     +- 4
--     |  |
--     |  +- 2
--     |  |
--     |  `- 5
--     |
--     `- 9
--        |
--        +- 8
--        |
--        `- 10
