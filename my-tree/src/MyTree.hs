module MyTree where

data MyTree a = Node { v :: a
                   , l :: (MyTree a)
                   , r :: (MyTree a) }
                | Leaf
                deriving Show
