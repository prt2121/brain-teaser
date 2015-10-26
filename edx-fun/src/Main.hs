-- DelftX: FP101x

module Main where

import Prelude hiding ((&&))

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
