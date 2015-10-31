module Main where

euler1 = sum [n | n <- [0..999], (mod n 3) == 0 || (mod n 5) == 0]

main :: IO ()
main = do
  putStrLn "hello world"
