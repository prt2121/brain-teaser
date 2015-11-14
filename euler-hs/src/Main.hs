module Main where
import System.Environment
import Text.ParserCombinators.Parsec hiding (spaces)

e1 = sum [n | n <- [0..999], (mod n 3) == 0 || (mod n 5) == 0]

fib :: [Integer]
fib = f 0 1
        where f a b = a : f b (a + b)

e2 :: Integer
e2 = sum(takeWhile (<4000000) [n | n <- fib, n `mod` 2 == 0])

fib' :: Integer -> Integer
fib' 0 = 1
fib' 1 = 1
fib' n = fib'(n - 1) + fib'(n -2)

fibs' :: [Integer]
fibs' = 1 : 1 : zipWith (+) fibs' (tail fibs')

main :: IO ()
main = do
  putStrLn ("insert your string")
