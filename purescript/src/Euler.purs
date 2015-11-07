module Euler1 where

import Prelude

import Data.List
import Data.Foldable
-- import Data.List.Lazy

multiples = filter (\n -> mod n 3 == 0 || mod n 5 == 0) (range 0 999)

answer = sum multiples

fib :: Int -> Int
fib 0 = 1
fib 1 = 1
fib n = fib (n - 1) + fib (n - 2)

fibs :: Int -> List Int
fibs 0 = fib 0 : Nil
fibs 1 = fib 1 : Nil
fibs n = Cons (fib n) (fibs (n - 1))
