(ns lean-challenge.test.core
  (:use [lean-challenge.core] :reload)
  (:use [midje.sweet]))

(fact
  (cost "b" ) => 150
  (cost "a" ) => 100
  (cost "c" ) => 75
  )

(fact "adds up the cost of all fruits in the basket"
      (basket-price '("a" "c" "b")) => 325)

(fact "discount for every two lots of cherries"
      (basket-price '("c" "c")) => (- 150 20)
      (basket-price '("c" "c" "c" "c")) => (- 300 40)
      )
(fact "buy two bananas get one for free"
      (basket-price '("b" "b")) => (cost "b"))

(fact 
  (csv-to-col "a,b,c") => '("a" "b" "c"))