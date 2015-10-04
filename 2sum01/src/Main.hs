module Main where

import Data.List
import Data.Array
import Data.Char
-- import Control.Monad
-- import qualified Data.IntMap as IntMap

-- https://leetcode.com/problems/reverse-words-in-a-string/
-- a two-pass solution
reverseWords :: String -> String
reverseWords = intercalate " " . reverse . words

-- reverse char in each words
-- a two-pass solution
reverseChars :: String -> String
reverseChars = intercalate " " . map reverse . words

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

-- palindrome "a man, a plan, a canal: panama"
-- ignore non-alpha
palindrome :: [Char] -> Bool
palindrome ls
  | length ls <= 1            = True
  | not (isAlpha (head ls))   = palindrome (tail ls)
  | not (isAlpha (last ls))   = palindrome (init ls)
  | (head ls) /= (last ls)    = False
  | (head ls) == (last ls)    = palindrome (init (tail ls))


-- Returns the index of the first occurrence of needle in haystack
strStr :: String -> String -> Int
strStr [] _   = 0
strStr needle h    = loop h 1
  where
    loop [] _  = -1
    loop s i =
      let (prefix, _) = splitAt n s
      in
        if needle == prefix
        then i
        else loop (tail s) (i+1)
    n = length needle

  -- *Main> replaceStr "abcde" "bc" "x"
  -- "axde"
replaceStr :: String -> String -> String -> String
replaceStr [] _ _ = []
replaceStr str old new = loop str
  where
    loop [] = []
    loop s =
      let (prefix, rest) = splitAt n s
      in
        if old == prefix                -- found an occurrence?
        then new ++ loop rest           -- yes: replace it
        else head s : loop (tail s) -- no: keep looking
    n = length old

main :: IO ()
main = do
  putStrLn "twoSum"
