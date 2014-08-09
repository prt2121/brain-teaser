package com.pt2121.algo

import scala.collection.mutable.HashMap

object WordLadder {

  val words = List("cool", "foil", "fool", "foul", "pool", "poll", "pole", "pall", "pope", "pale", "page", "sale", "sage")

  def buildGraph(words: List[String]) {
    

  }

  def buildBucket(words: List[String]) = {
    words.foldLeft(HashMap(): HashMap[String, Set[String]])((map, w) => {
      val map2 = w.zipWithIndex.foldLeft(HashMap(): HashMap[String, Set[String]])((m, p) => {
        val k = w.updated(p._2, '_')
        if (m.contains(k)) {
          m.get(k).get + w
        } else {
          m.put(k, Set(w))
        }
        m
      })
      if (map.isEmpty)
        map ++ map2
      else
        map ++ map2.map { case (k, v) => k -> (v ++ map.getOrElse(k, Set[String]())) }
    })
  }

  def main(args: Array[String]): Unit = {
    println(buildBucket(words))
  }

}

//val wordSet = words.map(w => {
//      w.zipWithIndex.foldLeft(Set(): Set[String])((s: Set[String], p: (Char, Int)) => {
//    	  s + w.updated(p._2, '_')
//      })
//    }).flatten.toSet

//def buildBucket2(words: List[String]): Set[String] = {
//    words.map(w => {
//      w.zipWithIndex.foldLeft(Set(): Set[String])((s, p) => {
//        s + w.updated(p._2, '_')
//      })
//    }).flatten.toSet
//  }


  //  Map(p_pe -> Set(pope), 
  //  f_ul -> Set(foul), 
  //  sa_e -> Set(sage, sale), 
  //  p_ol -> Set(pool), 
  //  co_l -> Set(cool), 
  //  _oul -> Set(foul), 
  //  pol_ -> Set(pole, poll), 
  //  f_ol -> Set(fool), 
  //  _all -> Set(pall), 
  //  foo_ -> Set(fool), 
  //  sag_ -> Set(sage), 
  //  p_ll -> Set(pall, poll), 
  //  foi_ -> Set(foil), 
  //  sal_ -> Set(sale), 
  //  _ope -> Set(pope), pa_l -> Set(pall), _age -> Set(sage, page), f_il -> Set(foil), _ool -> Set(pool, fool, cool), _ale -> Set(sale, pale), p_ge -> Set(page), _oll -> Set(poll), p_le -> Set(pale, pole), pa_e -> Set(page, pale), _oil -> Set(foil), fo_l -> Set(foul, fool, foil), po_l -> Set(poll, pool), pop_ -> Set(pope), coo_ -> Set(cool), _ole -> Set(pole), pag_ -> Set(page), pal_ -> Set(pale, pall), c_ol -> Set(cool), po_e -> Set(pope, pole), s_ge -> Set(sage), fou_ -> Set(foul), s_le -> Set(sale), poo_ -> Set(pool))



  // Set(_ale, sa_e, s_le, fou_, _oll, p_ll, _age, pa_e, foi_, pal_, _ool, coo_, c_ol, 
  // foo_, _ope, poo_, p_le, pol_, _ole, f_ul, po_e, sag_, _all, p_ol, pop_, f_il, s_ge, 
  // pa_l, fo_l, sal_, f_ol, p_pe, po_l, co_l, pag_, _oul, p_ge, _oil)
//  def buildBucket_(words: List[String]): Set[String] = {
//    (0 until 4).toList.foldLeft(Set(): Set[String])((s, i) => {
//      s ++ words.map { w =>
//        w.updated(i, '_')
//      }.toSet
//    })
//  }