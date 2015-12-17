module Main where

import System.Random
import Control.Monad

-- P21> insertAt 'X' "abcd" 2
-- "aXbcd"
insertAt :: (Eq a, Num a) => a1 -> [a1] -> a -> [a1]
insertAt x ls 0     = x : ls
insertAt _ [] _     = error "index out of bounds..."
insertAt x (y:ys) p = y : insertAt x ys (p - 1)

-- Problem 22
-- Prelude> range 4 9
-- [4,5,6,7,8,9]
range :: Int -> Int -> [Int]
range x y
    | x == y    = [x]
    | otherwise = x : range (x + 1) y

rollDiceIO :: IO (Int, Int)
rollDiceIO = liftM2 (,) (randomRIO (1,6)) (randomRIO (1,6))

main :: IO ()
main = do
  putStrLn "hello world"
