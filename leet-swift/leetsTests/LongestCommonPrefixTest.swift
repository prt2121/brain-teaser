//
//  LongestCommonPrefixTest.swift
//  leets
//
//  Created by Prat Tanapaisankit on 12/31/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//

import XCTest
@testable import leets

class LongestCommonPrefixTest: XCTestCase {
    
    func testCase001() {
        let prefix : String = LongestCommonPrefix.longestCommonPrefix01(["abcdef", "abc123", "abccba"])
        let expected = "abc"
        assert(expected == prefix)
    }
    
    func testCase002() {
        let prefix : String = LongestCommonPrefix.longestCommonPrefix01(["", "", "", ""])
        let expected = ""
        assert(expected == prefix)
    }
    
    func testCase003() {
        let prefix : String = LongestCommonPrefix.longestCommonPrefix01([])
        let expected = ""
        assert(expected == prefix)
    }
    
    func testCase004() {
        let prefix : String = LongestCommonPrefix.longestCommonPrefix01(["a1234", "a12", "a12xjz"])
        let expected = "a12"
        assert(expected == prefix)
    }
    
    func testCase005() {
        let prefix : String = LongestCommonPrefix.longestCommonPrefix01(["a"])
        let expected = "a"
        assert(expected == prefix)
    }
    
    func testCase006() {
        let prefix : String = LongestCommonPrefix.longestCommonPrefix01(["a", "b"])
        let expected = ""
        assert(expected == prefix)
    }
    
    func testCase007() {
        let prefix : String = LongestCommonPrefix.longestCommonPrefix01(["a", "ab"])
        let expected = "a"
        assert(expected == prefix)
    }
    
    func testCase008() {
        let prefix : String = LongestCommonPrefix.longestCommonPrefix01(["a", "ab", ""])
        let expected = ""
        assert(expected == prefix)
    }
    
    func testCase009() {
        let prefix : String = LongestCommonPrefix.longestCommonPrefix01(["a", "ab", "c"])
        let expected = ""
        assert(expected == prefix)
    }
    
    func testCase010() {
        let prefix : String = LongestCommonPrefix.longestCommonPrefix01(["ab", "ab", "ab"])
        let expected = "ab"
        assert(expected == prefix)
    }
    
    func testCase011() {
        let prefix : String = LongestCommonPrefix.longestCommonPrefix01(["abc", "ab", "ab"])
        let expected = "ab"
        assert(expected == prefix)
    }
    
    func testCase012() {
        let prefix : String = LongestCommonPrefix.longestCommonPrefix01(["ab", "ab", "abc"])
        let expected = "ab"
        assert(expected == prefix)
    }
}