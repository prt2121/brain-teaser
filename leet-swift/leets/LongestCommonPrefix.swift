//
//  LongestCommonPrefix.swift
//  leets
//
//  Created by Prat Tanapaisankit on 12/31/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//
// https://leetcode.com/problems/longest-common-prefix/

import Swiftz

class LongestCommonPrefix {
    class func longestCommonPrefix01(arr : [String]) -> String {
        if arr.first == nil || arr.first!.characters.count == 0 {
            return ""
        } else {
            let chars = arr.first!.characters
            return Array(1...Int(chars.count))
                .takeWhile {
                    let prefix = Array(chars).take($0)
                    return arr.map { Array($0.characters) }
                        .all { prefix.isPrefixOf($0) }
                }.last
                .fmap { String(Array(chars).take($0)) }
                .getOrElse("")
        }
    }
}
