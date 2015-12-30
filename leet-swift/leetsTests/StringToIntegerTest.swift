//
//  StringToInteger.swift
//  leets
//
//  Created by Prat Tanapaisankit on 12/29/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//

import XCTest
@testable import leets

class StringToIntegerTest: XCTestCase {
    
    func testCase001() {
        let i : Int = StringToInteger.atoi("123")
        let expected = 123
        assert(expected == i)
    }
    
}