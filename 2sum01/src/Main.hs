module Main where

import Data.List
import Data.Array
-- import Control.Monad
-- import qualified Data.IntMap as IntMap

twoSum :: [Integer] -> Integer -> Maybe (Integer, Integer)
twoSum [] _     = Nothing
twoSum (l:ls) t = case (find (\x -> x + l == t) ls) of
                    Just y -> Just (l, y)
                    Nothing -> twoSum ls t

-- *Main> let arr = array (1,3) [(1,42),(2,87),(3,95)]
-- *Main> binarySearch  arr 87 1 3
-- Just 2
binarySearch :: (Integral a, Ord a1, Ix a) => Array a a1 -> a1 -> a -> a -> Maybe a
binarySearch haystack needle l h
  | l > h     = Nothing
  | pivot > needle = binarySearch haystack needle l (m-1)
  | pivot < needle = binarySearch haystack needle (m+1) h
  | otherwise = Just m
  where
    m = l + (h-l) `div` 2
    pivot = haystack!m


main :: IO ()
main = do
  putStrLn "twoSum"
