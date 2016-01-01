//
//  MergeTwoSortedListsTest.swift
//  leets
//
//  Created by Prat Tanapaisankit on 1/1/16.
//  Copyright © 2016 Prat Tanapaisankit. All rights reserved.
//

import XCTest
import Swiftz
@testable import leets

class MergeTwoSortedListsTest: XCTestCase {
    
    func testCase001() {
        let ls1 = List(fromArray: [1, 3, 9])
        let ls2 = List(fromArray: [2, 4])
        let i : List<Int> = MergeTwoSortedLists.merge(ls1, ls2: ls2)
        let expected = List(fromArray: [1, 2, 3, 4, 9])
        assert(expected == i)
    }
    
    func testCase002() {
        let ls1 = List(fromArray: [Int]())
        let ls2 = List(fromArray: [2, 4])
        let i : List<Int> = MergeTwoSortedLists.merge(ls1, ls2: ls2)
        let expected = List(fromArray: [2, 4])
        assert(expected == i)
    }
    
    func testCase003() {
        let ls1 = List(fromArray: [2, 4])
        let ls2 = List(fromArray: [Int]())
        let i : List<Int> = MergeTwoSortedLists.merge(ls1, ls2: ls2)
        let expected = List(fromArray: [2, 4])
        assert(expected == i)
    }
    
    func testCase004() {
        let ls1 = List(fromArray: [Int]())
        let ls2 = List(fromArray: [Int]())
        let i : List<Int> = MergeTwoSortedLists.merge(ls1, ls2: ls2)
        let expected = List(fromArray: [Int]())
        assert(expected == i)
    }
    
    func testCase005() {
        let ls1 = List(fromArray: [1])
        let ls2 = List(fromArray: [2])
        let i : List<Int> = MergeTwoSortedLists.merge(ls1, ls2: ls2)
        let expected = List(fromArray: [1, 2])
        assert(expected == i)
    }

    func testCase006() {
        let ls1 = List(fromArray: [1, 5])
        let ls2 = List(fromArray: [2, 5, 6])
        let i : List<Int> = MergeTwoSortedLists.merge(ls1, ls2: ls2)
        let expected = List(fromArray: [1, 2, 5, 5, 6])
        assert(expected == i)
    }
}