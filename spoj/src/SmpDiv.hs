module SmpDiv where

import Data.List
import Control.Applicative
import Control.Monad

printCases :: [[Int]] -> IO ()
printCases = mapM_ printCase

printCase :: [Int] -> IO ()
printCase ls = do mapM_ (putStr . (\s -> s ++ " ") . show) (smpDiv n x y) ; putStrLn ""
                where   n = ls !! 0
                        x = ls !! 1
                        y = ls !! 2

smpDiv :: Int -> Int -> Int -> [Int]
smpDiv n x y = [i | i <- [1..(n - 1)], i `mod` x == 0, i `mod` y /= 0]

splitOn :: Eq a => [a] -> [a] -> [[a]]
splitOn []    _  = error "splitOn: empty delimiter"
splitOn delim xs = loop xs
    where loop [] = [[]]
          loop xs | delim `isPrefixOf` xs = [] : splitOn delim (drop len xs)
          loop (x:xs) = let (y:ys) = splitOn delim xs
                         in (x:y) : ys
          len = length delim

getInts :: IO [Int]
getInts = map read . splitOn " " <$> getLine

main = do
    numCases <- readLn
    cases <- replicateM numCases getInts
    printCases cases