module SmpSum where

import Data.List
import Control.Applicative
import Control.Monad

-- sum: a*a + (a+1)*(a+1) + ... + (b-1)*(b-1) + b*b
smpSum :: Int -> Int -> Int
smpSum n m = sum [i * i | i <- [n..m]]

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
        inputs <- getInts
        print (smpSum (inputs !! 0) (inputs !! 1))