//
//  RemoveDuplicates.swift
//  leets
//
//  Created by Prat Tanapaisankit on 1/1/16.
//  Copyright © 2016 Prat Tanapaisankit. All rights reserved.
//
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//
//#26 Remove Duplicates from Sorted Array return the new length.
import Swiftz

class RemoveDuplicates {
    
    class func removeDuplicates<T : Equatable>(arr: [T]) -> [T] {
        return arr.group.flatMap { $0.first }
    }

    // O(n^2) arr can be unsorted
    class func removeDuplicates2<T : Equatable>(arr: [T]) -> [T] {
        switch arr.match {
        case .Nil:
            return [T]()
        case let .Cons(head, tail):
            return removeDuplicates(tail.filter{ head != $0 }).cons(head)
        }
    }
}
