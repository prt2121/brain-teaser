module Main where

import System.Random
import Control.Monad
import Data.List
import Control.Applicative

-- Problem 26
-- Generate the combinations of K distinct objects
combinations :: Int -> [a] -> [[a]]
combinations 0 _    = [[]]
combinations n xs = [ l:ls | l:xs' <- tails xs
                           , ls <- combinations (n - 1) xs' ]

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

-- Problem 23
-- Extract a given number of randomly selected elements from a list.
-- *Main Data.List System.Random> g <- newStdGen
-- *Main Data.List System.Random> rndSelect "taetasdfasdfljsdklf" 3 g
-- "lfs"
rndSelect :: (RandomGen g, Random a) => [a] -> Int -> g -> [a]
rndSelect ls n g = getList ls (randomSelect (length ls) n g)
                    where
                        getList ls [] = []
                        getList ls (x:xs) = (ls !! (x - 1)) : getList ls xs

rndSelect' :: (RandomGen g, Random a) => [a] -> Int -> g -> [a]
rndSelect' ls n g = getList ls (randomSelect (length ls) n g)
                    where
                        getList ls pos = [ls!!(p - 1) | p <- pos]

-- deleteElems xs zs = foldr1 intersect $ map ($ zs) $ map deleteElem xs

-- Prelude Data.List> import System.Random
-- Prelude Data.List System.Random> g <- newStdGen
-- Prelude Data.List System.Random> take 5 $ nub $ randomRs (1, 20) g
-- [16,15,11,6,10]
-- *Main Data.List System.Random> g <- newStdGen
-- *Main Data.List System.Random> randomSelect 10 3 g
-- [10,9,5]
-- Problem 24
-- Lotto: Draw N different random numbers from the set 1..M.
randomSelect :: RandomGen g => Int -> Int -> g -> [Int]
randomSelect max n g = take n $ nub $ randomRs (1, max) g

diffSelect :: Int -> Int -> StdGen -> [Int]
diffSelect n m = take n . nub . randomRs (1, m)

diffSelect' :: Int -> Int -> IO [Int]
diffSelect' n m = take n . nub . randomRs (1, m) <$> getStdGen

-- Problem 25
rndPermu :: Random a => [a] -> IO [a]
rndPermu ls = rndSelect' ls (length ls) <$> getStdGen

main :: IO ()
main = do
  putStrLn "hello world"
