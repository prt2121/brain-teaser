module Main where
import System.Environment
import Text.ParserCombinators.Parsec hiding (spaces)
import Control.Monad
import Data.List

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

allPrimeFactors n =
  case factors of
    [] -> [n]
    _  -> factors ++ allPrimeFactors (n `div` (head factors))
  where factors = take 1 $ filter (\x -> (n `mod` x) == 0) [2 .. n-1]

-- common prime factors
cpf :: Integer -> [Integer]
cpf m = foldr union [] xss
  where xss = map allPrimeFactors [2 .. m]

-- all common prime factors
acpf :: Integer -> [Integer]
acpf m = foldr (++) [] xss
  where xss = map allPrimeFactors [2 .. m]

e4 :: Integer -> Integer
e4 = last . sort . filter isPalinNum . prodList

prodList :: Integer -> [Integer]
prodList n = [ x * y | x <- ls, y <- ls] where ls = [n, n-1 .. 0]

isPalinNum :: Integral x => x -> Bool
isPalinNum n
  | n < 0     = error "seriously?"
  | n < 10    = True
  | otherwise = digs n == reverse (digs n)

digs :: Integral x => x -> [x]
digs 0 = []
digs x = digs (x `div` 10) ++ [x `mod` 10]

primeFactors :: Integer -> [Integer]
primeFactors n =
  if isPrime n
    then [n]
    else x
        where x = do
              i <- [2 .. (sqrt' n)]
              guard (n `mod` i == 0 && isPrime i)
              return i

-- e3
bigPrime :: Integer -> Integer
bigPrime n =
  if isPrime n
    then n
    else maximum x
        where x = do
              i <- [2 .. (sqrt' n)]
              guard (n `mod` i == 0 && isPrime i)
              return i

sqrt' :: Integer -> Integer
sqrt' = toInteger . ceiling . sqrt . fromIntegral

isPrime x = not $ any divisible $ takeWhile notTooBig [2..] where
              divisible y = x `mod`y == 0
              notTooBig y = y*y <= x

main :: IO ()
main = do
  putStrLn ("insert your string")
