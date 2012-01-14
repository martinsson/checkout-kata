(ns lean-challenge.test.core
  (:use [lean-challenge.core] :reload)
  (:use [midje.sweet]))

(fact
  (cost "b" ) => 150
  (cost "a" ) => 100
  (cost "c" ) => 75)

(fact "adds up the cost of all fruits in the basket"
      (basket-price '("a" "c" "b")) => 325)

(fact "discount for every two lots of cherries"
      (basket-price '("c" "c")) => 130)

(fact 
  (csv-to-col "a,b,c") => '("a" "b" "c"))