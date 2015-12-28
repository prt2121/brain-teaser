module Basics01 where

import Data.List
import Control.Applicative
import Control.Monad

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

printElements :: [Int] -> IO ()
printElements = mapM_ print

printListElements :: [[Int]] -> IO ()
printListElements = mapM_ print

printCases :: [[Int]] -> IO ()
printCases = mapM_ printCase

printCase :: [Int] -> IO ()
printCase ls = putStr (createCase r c ++ "\n")
                where   r = ls !! 0
                        c = ls !! 1

createCase :: Int -> Int -> String
createCase 0 _ = ""
createCase r c = if odd r
                    then    createCase (r - 1) c ++ createStarRow c ++ "\n"
                    else    createCase (r - 1) c ++ createDotRow c ++ "\n"

createStarRow :: Int -> String
createStarRow c = (createRow True c)

createDotRow :: Int -> String
createDotRow c = (createRow False c)

createRow :: Bool -> Int -> String
createRow star 1 = if star then "*" else "."
createRow star c = case odd c of
        True    -> (createRow star (c - 1)) ++ (if star then "*" else ".")
        False   -> (createRow star (c - 1)) ++ (if star then "." else "*")

main :: IO ()
main = do
    numCases <- readLn
    cases <- replicateM numCases getInts
    printCases cases

-- print $ (read num :: Int)
-- Input:
-- 3
-- 3 1
-- 4 4
-- 2 5
--
-- Output:
-- *
-- .
-- *
--
-- *.*.
-- .*.*
-- *.*.
-- .*.*
--
-- *.*.*
-- .*.*.