module Euler1 where

import Prelude

import Data.List (range, filter)
import Data.Foldable (sum)

multiples = filter (\n -> mod n 3 == 0 || mod n 5 == 0) (range 0 999)

answer = sum multiples
