//
//  ZigZagConversionTest.swift
//  leets
//
//  Created by Prat Tanapaisankit on 12/29/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//

import XCTest
@testable import leets

class ZigZagConversionTest: XCTestCase {
    
    let ProbleName: String = "ZigZag_Conversion"
    
    func testCase001() {
        let expected: String = "PAHNAPLSIIGYIR"
        let result = ZigZagConversion.convert("PAYPALISHIRING", nRows: 3)
        assert(expected == result)
    }
    
    func testCase002() {
        let expected: String = "PINALSIGYAHRPI"
        let result = ZigZagConversion.convert("PAYPALISHIRING", nRows: 4)
        assert(expected == result)
    }
    
    func testCase003() {
        let expected: String = "ACBD"
        let result = ZigZagConversion.convert("ABCD", nRows: 2)
        assert(expected == result)
    }
}
