//
//  ReverseIntegerTest.swift
//  leets
//
//  Created by Prat Tanapaisankit on 12/29/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//

import XCTest
@testable import leets

class ReverseIntegerTest: XCTestCase {

    func testCase001() {
        let reversed : Int = ReverseInteger.reverse(1234)
        let expected = 4321
        assert(expected == reversed)
    }
    
    func testCase002() {
        let reversed : Int = ReverseInteger.reverse(7650)
        let expected = 567
        assert(expected == reversed)
    }
    
    func testCase003() {
        let reversed : Int = ReverseInteger.reverse(100000)
        let expected = 1
        assert(expected == reversed)
    }
}