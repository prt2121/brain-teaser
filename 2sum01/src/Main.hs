module Main where

import Data.List
-- import Control.Monad
-- import qualified Data.IntMap as IntMap

twoSum :: [Integer] -> Integer -> Maybe (Integer, Integer)
twoSum [] t     = Nothing
twoSum (l:ls) t = case (find (\x -> x + l == t) ls) of
                    Just y -> Just (l, y)
                    Nothing -> twoSum ls t

main :: IO ()
main = do
  putStrLn "twoSum"
