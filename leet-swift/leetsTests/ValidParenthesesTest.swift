//
//  ValidParenthesesTest.swift
//  leets
//
//  Created by Prat Tanapaisankit on 1/1/16.
//  Copyright © 2016 Prat Tanapaisankit. All rights reserved.
//

import XCTest
@testable import leets

class ValidParenthesesTest: XCTestCase {
    
    func testCase001() {
        assert(ValidParentheses.isValid("{}[]()"))
    }
    
    func testCase002() {
        assert(ValidParentheses.isValid(""))
    }
    
    func testCase003() {
        assert(!ValidParentheses.isValid("[)(]"))
    }
    
    func testCase004() {
        assert(!ValidParentheses.isValid("]["))
    }
    
    func testCase005() {
        assert(!ValidParentheses.isValid("(]"))
    }
    
    func testCase006() {
        assert(!ValidParentheses.isValid("([)]"))
    }

}
