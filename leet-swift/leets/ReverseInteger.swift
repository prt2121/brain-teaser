//
//  ReverseInteger.swift
//  leets
//
//  Created by Prat Tanapaisankit on 12/29/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//
//  https://oj.leetcode.com/problems/reverse-integer/
//  Reverse digits of an integer.
//  x = 123, return 321
//  no overflow check

class ReverseInteger {
    class func reverse(x: Int) -> Int {
        if(x < 0) {
            return -1 * f(abs(x), acc: 0)
        } else {
            return f(x, acc: 0)
        }
    }
    
    class func f(x: Int, acc:Int) -> Int {
        if(x < 10) {
            return x + acc * 10
        }
        let rem = x % 10
        let div = (x - rem) / 10
        return f(div, acc: acc * 10 + rem)
    }
    
    func digits(x: Int) -> [Int] {
        if(x == 0) {
            return []
        } else {
            let rem = x % 10
            return digits ((x - rem) / 10) + [rem]
        }
    }
}
