doubleMe x = 2 * x

doubleSmallNumber x = if x > 100 then x else x * 2

-- Last "Int" is the return type:
addThree :: Int -> Int -> Int -> Int
addThree x1 x2 x3 = x1 + x2 + x3

-- Write a function that produces the word version of a number
sayMe :: Int -> String
sayMe 1 = "One!"
sayMe 2 = "Two!"
sayMe 3 = "Three!"
sayMe 4 = "Four!"
sayMe 5 = "Five!"
-- catch-all pattern, use a variable because a variable could be anything
sayMe x = "Not between 1 and 5"

factorial :: Int -> Int
-- base case:
factorial 0 = 1
-- recursive case, multiple our current n by the factorial of the previous number
factorial n = n * factorial (n - 1)

-- Write a function, given a list, tell whether all elements in the list are equal
-- Type-class is an interface that defines some behavior
-- In this case, we're stipulating that a can be checked for equality
checkAllEqual :: (Eq a) => [a] -> Bool
-- base cases
checkAllEqual [] = True
checkAllEqual [a] = True -- a list with one element must be true
checkAllEqual [a,b] = a == b -- a list with 2 elements must be true if a is equal to b
-- We want a recursive way to define the other cases
-- breaking down the list into the head x and the tail xs
checkAllEqual(x : xs) = (x == head xs) && (checkAllEqual xs)
-- example, if we pass in [1,1,1,2]
-- x = 1, xs = [1,1,2]
-- x = 1, xs = [1,2]
-- x = 1, xs = [2] False
