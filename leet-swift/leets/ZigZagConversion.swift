//
//  ZigZagConversion.swift
//  leets
//
//  Created by Prat Tanapaisankit on 12/29/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//
// https://leetcode.com/problems/zigzag-conversion/

import Foundation
import Swiftz
import struct Swiftz.List

class ZigZagConversion {
    class func convert(text: String, nRows: Int) -> String {
        if(nRows == 1) { return text }
        let lineLabel = (nRows == 2) ? [1,2] : [Int](1...nRows) + [Int](2...(nRows - 1)).reverse()
        let chars = List(fromArray: lineLabel)
            .cycle()
            .take(UInt(text.characters.count))
            .map {Int($0)}
            .mzip(Array(text.characters))
            .sort { $0.0 < $1.0 }
            .map { $0.1 }
        return String(chars)
    }
}