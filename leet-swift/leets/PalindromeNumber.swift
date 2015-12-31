//
//  PalindromeNumber.swift
//  leets
//
//  Created by Prat Tanapaisankit on 12/31/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//

/*
https://oj.leetcode.com/problems/palindrome-number/

#9 Palindrome Number
Determine whether an integer is a palindrome.
*/
import Swiftz

class PalindromeNumber {
    class func isPalindrome(x : Int) -> Bool {
        func safeTime10(n : Int?) -> Int? {
            if n > Int.max / 10 {
                return nil
            } else {
                return n.fmap(*10)
            }
        }
        
        if x < 0 || x > Int.max {
            return false
        } else {
            return x == Stream<Int>
                .unfold(x) {
                    let (d, m) = $0.divMod(10)
                    return (m, d)
                }
                .take(UInt(String(x).characters.count))
                .foldRight(Optional(0)) { $1 >>- safeTime10 >>- curry(+)($0) }
                .getOrElse(-1)
        }
    }
}
