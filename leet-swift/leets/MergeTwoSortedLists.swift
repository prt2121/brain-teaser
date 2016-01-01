//
//  MergeTwoSortedLists.swift
//  leets
//
//  Created by Prat Tanapaisankit on 1/1/16.
//  Copyright © 2016 Prat Tanapaisankit. All rights reserved.
//
// https://leetcode.com/problems/merge-two-sorted-lists/
//
// #21 Merge Two Sorted Lists

import Swiftz

class MergeTwoSortedLists {
    class func merge<T : Comparable>(ls1 : List<T>, ls2 : List<T>) -> List<T> {
        switch ls1.match {
        case .Nil:
            return ls2
        case let .Cons(x, xs):
            switch ls2.match {
            case .Nil:
                return ls1
            case let .Cons(y, ys):
                if x < y {
                    return List.cons(x, tail: merge(xs, ls2: ls2))
                } else {
                    return List.cons(y, tail: merge(ls1, ls2: ys))
                }
            }
        }
    }
}
