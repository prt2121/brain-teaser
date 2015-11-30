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

leaf :: a -> BsT a
leaf n = Node n Empty Empty

drawTree :: BsT String -> String
drawTree  = unlines . draw

draw :: BsT String -> [String]
draw Empty           =  []
draw (Node v l r)    =  v : ((drawL l) ++ (drawR r))
    where
          drawL Empty       =  []
          drawL l           =  "|" : shift "+- " "|  " (draw l)
          drawR Empty       =  []
          drawR r           =  "|" : shift "`- " "   " (draw r)
          shift :: [a] -> [a] -> [[a]] -> [[a]]
          shift first other =  zipWith (++) (first : repeat other)

t1 :: BsT Integer
t1 = Node 5
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
--        +- 10
--        |  |
--        |  +- 9
--        |  |
--        |  `- 13