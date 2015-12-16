module Main where

-- P21> insertAt 'X' "abcd" 2
-- "aXbcd"
insertAt :: (Eq a, Num a) => a1 -> [a1] -> a -> [a1]
insertAt x ls 0     = x : ls
insertAt _ [] _     = error "index out of bounds..."
insertAt x (y:ys) p = y : insertAt x ys (p - 1)

main :: IO ()
main = do
  putStrLn "hello world"
