//
//  ValidParentheses.swift
//  leets
//
//  Created by Prat Tanapaisankit on 1/1/16.
//  Copyright © 2016 Prat Tanapaisankit. All rights reserved.
//
//https://leetcode.com/problems/valid-parentheses/
//
//#20 Valid_Parentheses
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']'

import Swiftz

private extension String {
    subscript (index: Int) -> Character {
        return self[self.startIndex.advancedBy(index)]
    }
}

class ValidParentheses {
    class func isValid(s : String) -> Bool {
        var dict: Dictionary<Character, Character> = Dictionary()
        dict["]"] = "["
        dict[")"] = "("
        dict["}"] = "{"
        
        return s.reduce({
            stack, char in
                if "({[".containsString(String(char)) {
                    return stack.cons(char)
                } else if ")}]".containsString(String(char)) {
                    if stack.count == 0 || stack.first != dict[char] {
                        return stack.cons(char)
                    } else {
                        return Array(stack.dropFirst(1))
                    }
                }
                return stack
            },
            initial: [Character]()).isEmpty
    }
}
