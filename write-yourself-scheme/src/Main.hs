module Main where
import Text.ParserCombinators.Parsec hiding (spaces)
import Control.Monad

data LispVal =  Atom String
              | List [LispVal]
              | DottedList [LispVal] LispVal
              | Number Integer
              | String String
              | Bool Bool

symbol :: Parser Char
symbol = oneOf "!$%&|*+-/:<=?>@^_~#"

spaces :: Parser ()
spaces = skipMany1 space

-- class Monad m => Stream s m t | s -> t where
-- An instance of Stream has stream type s, underlying monad m and token type t determined by the stream

-- ParsecT s u m a is a parser with stream type s, user state type u, underlying monad m and return type a.

parseString :: Parser LispVal
parseString = do  char '"' -- Stream s m Char => ParsecT s u m ()
                  x <- many (noneOf "\"")
                  char '"'
                  return $ String x

parseAtom :: Parser LispVal
parseAtom = do  first <- letter <|> symbol
                rest <- many (letter <|> digit <|> symbol)
                let atom = [first] ++ rest
                return $ case atom of
                          "#t" -> Bool True
                          "#f" -> Bool False
                          otherwise -> Atom atom

-- liftM :: Monad m => (a1 -> r) -> m a1 -> m r
-- fmap :: Functor f => (a -> b) -> f a -> f b

parseNumber :: Parser LispVal
parseNumber = liftM (Number . read) $ many1 digit

readExpr :: String -> String
readExpr input = case parse (spaces >> symbol) "lisp" input of
  Left err -> "No match: " ++ show err
  Right val -> "Found value!"

main :: IO ()
main = do
  putStrLn ("insert your string")
  str <- getLine
  putStrLn (readExpr str)
