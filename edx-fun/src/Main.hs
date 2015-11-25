-- DelftX: FP101x

module Main where

import Data.Char
import Prelude hiding ((&&))

nlowers = length ['a'..'z']
nuppers = nlowers

dropWhile' _ [] = []
dropWhile' p (x : xs)
  | p x = dropWhile' p xs
  | otherwise = x : xs

chop8 :: [Bit] -> [[Bit]]
chop8 = unfold null (take 8) (drop 8)

map' :: (a -> b) -> [a] -> [b]
map' f = unfold null (f . head) tail

iterate :: (a -> a) -> a -> [a]
iterate f = unfold (const False) id f

encode :: String -> [Bit]
encode = concat . map' (make9 . int2bin . ord)

make8 :: [Bit] -> [Bit]
make8 bits = take 8 (bits ++ repeat 0)

make9 :: [Bit] -> [Bit]
make9 bits = bits' ++ [parity]
             where bits'  = make8 bits
                   parity = if even (sum bits') then 0 else 1

decode :: [Bit] -> String
decode = map' (chr . bin2int) . chop8

transmit :: String -> String
transmit = decode . id . encode

let2int :: Char -> Int
let2int c | (c >= 'a') && (c <= 'z') = ord c - ord 'a'
          | (c >= 'A') && (c <= 'Z') = ord c - ord 'A'
          | otherwise = error "Character must be an alphabet character"

int2llet :: Int -> Char
int2llet n = chr (ord 'a' + n)

int2ulet :: Int -> Char
int2ulet n = chr (ord 'A' + n)

int2bin :: Int -> [Int]
int2bin = unfold (== 0) (`mod` 2) (`div` 2)

type Bit = Int

bin2int :: [Bit] -> Int
bin2int = foldr (\x y -> x + 2 * y) 0

unfold :: (t -> Bool) -> (t -> a) -> (t -> t) -> t -> [a]
unfold p h t x | p x       = []
               | otherwise = h x : unfold p h t (t x)

-- shift
shift :: Int -> Char -> Char
shift n c | (c >= 'a') && (c <= 'z') = int2llet ((let2int c + n) `mod` nlowers)
          | (c >= 'A') && (c <= 'Z') = int2ulet ((let2int c + n) `mod` nuppers)
          | otherwise      = c

encode' :: Int -> String -> String
encode' n cs = [shift n c | c <- cs]

mult :: Integer -> Integer -> Integer -> Integer
mult = \x -> (\y -> (\z -> x * y * z))

remove :: Int -> [a] -> [a]
remove n xs = take n xs ++ drop (n+1) xs

halve' :: [a] -> ([a], [a])
halve' xs = splitAt (length xs `div` 2) xs

halve'' :: [a] -> ([a], [a])
halve'' xs = (take n xs, drop n xs)
  where n = length xs `div` 2

safetail :: [a] -> [a]
safetail [] = []
safetail xs = drop 1 xs

safetail' :: [a] -> [a]
safetail' xs = if null xs then [] else tail xs

safetail'' :: [a] -> [a]
safetail'' [] = []
safetail'' (_ : xs) = xs

safetail3 :: [a] -> [a]
safetail3 xs
  | null xs = []
  | otherwise = tail xs

safetail4 :: [a] -> [a]
safetail4  = \ xs ->
    case xs of
      [] -> []
      (_ : ls) -> ls

a && b = if a then b else False

getLine' = get []

get :: String -> IO String
get xs = do x <- getChar
            case x of
              '\n' -> return xs
              _ -> get (xs ++ [x])

main :: IO ()
main = do
  putStrLn "hello world"
