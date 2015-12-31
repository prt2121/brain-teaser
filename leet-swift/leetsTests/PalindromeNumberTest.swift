//
//  PalindromeNumber.swift
//  leets
//
//  Created by Prat Tanapaisankit on 12/31/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//
import XCTest
@testable import leets

class PalindromeNumberTest: XCTestCase {
    
    func testCase001() {
        assert(!PalindromeNumber.isPalindrome(1234))
    }
    
    func testCase002() {
        assert(PalindromeNumber.isPalindrome(0))
    }
    
    func testCase003() {
        assert(PalindromeNumber.isPalindrome(1234321))
    }
    
    func testCase004() {
        assert(PalindromeNumber.isPalindrome(12344321))
    }
    
    func testCase005() {
        assert(!PalindromeNumber.isPalindrome(-666))
    }
    
    func testCase006() {
        assert(!PalindromeNumber.isPalindrome(Int.max))
    }
    
    func testCase007() {
        assert(!PalindromeNumber.isPalindrome(Int.min))
    }
    
    func testCase008() {
        assert(!PalindromeNumber.isPalindrome(1999999999999999999))
    }
    
    func testCase009() {
        assert(!PalindromeNumber.isPalindrome(-1999999999999999999))
    }
}