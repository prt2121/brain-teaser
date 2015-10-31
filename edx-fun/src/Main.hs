-- DelftX: FP101x

module Main where

import Data.Char
import Prelude hiding ((&&))

nlowers = length ['a'..'z']
nuppers = nlowers

let2int :: Char -> Int
let2int c | (c >= 'a') && (c <= 'z') = ord c - ord 'a'
          | (c >= 'A') && (c <= 'Z') = ord c - ord 'A'
          | otherwise = error "Character must be an alphabet character"

int2llet :: Int -> Char
int2llet n = chr (ord 'a' + n)

int2ulet :: Int -> Char
int2ulet n = chr (ord 'A' + n)

-- shift
shift :: Int -> Char -> Char
shift n c | (c >= 'a') && (c <= 'z') = int2llet ((let2int c + n) `mod` nlowers)
          | (c >= 'A') && (c <= 'Z') = int2ulet ((let2int c + n) `mod` nuppers)
          | otherwise      = c

encode :: Int -> String -> String
encode n cs = [shift n c | c <- cs]

mult :: Integer -> Integer -> Integer -> Integer
mult = \x -> (\y -> (\z -> x * y * z))

remove :: Int -> [a] -> [a]
remove n xs = take n xs ++ drop (n+1) xs

halve' :: [a] -> ([a], [a])
halve' xs = splitAt (length xs `div` 2) xs

halve'' :: [a] -> ([a], [a])
halve'' xs = (take n xs, drop n xs)
  where n = length xs `div` 2

safetail :: [a] -> [a]
safetail [] = []
safetail xs = drop 1 xs

safetail' :: [a] -> [a]
safetail' xs = if null xs then [] else tail xs

safetail'' :: [a] -> [a]
safetail'' [] = []
safetail'' (_ : xs) = xs

safetail3 :: [a] -> [a]
safetail3 xs
  | null xs = []
  | otherwise = tail xs

safetail4 :: [a] -> [a]
safetail4  = \ xs ->
    case xs of
      [] -> []
      (_ : ls) -> ls

a && b = if a then b else False

main :: IO ()
main = do
  putStrLn "hello world"
