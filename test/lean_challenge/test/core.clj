(ns lean-challenge.test.core
  (:use [lean-challenge.core] :reload)
  (:use [midje.sweet]))

(fact
  (cost "B" ) => 150
  (cost "A" ) => 100
  (cost "C" ) => 75)

(fact "adds up the cost of all fruits in the basket"
      (cost "A" "C" "C") => 250)