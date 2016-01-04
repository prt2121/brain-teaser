//
//  RemoveDuplicatesTest.swift
//  leets
//
//  Created by Prat Tanapaisankit on 1/1/16.
//  Copyright © 2016 Prat Tanapaisankit. All rights reserved.
//

import XCTest
@testable import leets

class RemoveDuplicatesTest: XCTestCase {
    
    func testCase001() {
        let ls : [Int] = RemoveDuplicates.removeDuplicates([1, 1, 2, 3, 4])
        let expected = [1, 2, 3, 4]
        assert(expected == ls)
    }
    
    func testCase002() {
        let ls : [String] = RemoveDuplicates.removeDuplicates([])
        let expected = []
        assert(expected == ls)
    }
    
    func testCase003() {
        let ls : [String] = RemoveDuplicates.removeDuplicates(["abc"])
        let expected = ["abc"]
        assert(expected == ls)
    }
    
    func testCase004() {
        let ls : [String] = RemoveDuplicates.removeDuplicates(["abc", "abc", "xy", "z", "z", "zzzz"])
        let expected = ["abc", "xy", "z", "zzzz"]
        assert(expected == ls)
    }

    // unsorted version
    func testCase005() {
        let ls : [String] = RemoveDuplicates.removeDuplicates2(["a", "b", "a", "a", "a", "b", "a"])
        let expected = ["a", "b"]
        assert(expected == ls)
    }
    
}