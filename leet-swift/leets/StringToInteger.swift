//
//  StringToInteger.swift
//  leets
//
//  Created by Prat Tanapaisankit on 12/29/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//
//  https://leetcode.com/problems/string-to-integer-atoi/
//  
//  NOT consider all possible input cases

import Swiftz
import struct Swiftz.List

extension Character {
    func isDigit() -> Bool {
        return self >= "0" && self <= "9"
    }
    var intVal:Int {
        return Int(String(self)) ?? 0
    }
}

class StringToInteger {
    // lol
    class func atoi00(str: String) -> Int {
        return Int(str) ?? 0
    }
    // lol 2
    class func atoi(str: String) -> Int {
        return List(fromArray: Array(str.characters))
            .reduce(0) {
                $0 * 10 + $1.intVal
            }
    }
}
