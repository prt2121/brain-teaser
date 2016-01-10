module ADTs where

-- http://www.seas.upenn.edu/~cis194/spring13/lectures/02-ADTs.html

data FailableDouble = Failure
                    | OK Double
    deriving Show

ex01 :: FailableDouble
ex01 = Failure

ex02 :: FailableDouble
ex02 = OK 3.14

--     *ADTs> :t OK
--     OK :: Double -> FailableDouble

safeDiv :: Double -> Double -> FailableDouble
safeDiv _ 0 = Failure
safeDiv m n = OK (m / n)

data TypeConstr = DataConstr1 Type11 Type12
                | DataConstr2 Type21
                | DataConstr3 Type31 Type32 Type33
                | DataConstr4
