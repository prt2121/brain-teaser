module Main where
import System.Environment
import Text.ParserCombinators.Parsec hiding (spaces)
import Control.Monad

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

bigPrime :: Integer -> Integer
bigPrime n =
  if isPrime n
    then n
    else maximum x
        where x = do
              i <- [2 .. n]
              guard (n `mod` i == 0 && isPrime i)
              return i

isPrime x = not $ any divisible $ takeWhile notTooBig [2..] where
              divisible y = x `mod`y == 0
              notTooBig y = y*y <= x

main :: IO ()
main = do
  putStrLn ("insert your string")
