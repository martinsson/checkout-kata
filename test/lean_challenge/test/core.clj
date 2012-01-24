(ns lean-challenge.test.core
  (:use [lean-challenge.core] :reload)
  (:use [lean-challenge.main] :reload)
  (:use [midje.sweet]))

(fact
  (cost "b" ) => 150
  (cost "a" ) => 100
  (cost "c" ) => 75)

(fact "adds up the cost of all fruits in the basket"
      (basket-price "a" "c" "b") => 325)

(fact "discount for every two lots of cherries"
      (basket-price "c" "c") => (- 150 20)
      (basket-price "c" "c" "c" "c") => (- 300 40))
(fact "buy two bananas get one for free"
      (basket-price "b" "b") => (cost "b"))
(fact "3 pommes are 200"
      (basket-price "p" "p" "p") => 200
      (basket-price "m" "m") => 150)
(fact "global discounts"
      (basket-price "a" "a" "b" "c" "b" "b") => 375
      (basket-price "a" "a" "m" "p" ) => 300)
(fact 
  (csv-to-col "a,b,c") => '("a" "b" "c"))

(fact "accepts empty fruit baskets"
  (basket-price ) => 0)

(facts "it exits when we enter an empty line"
      (buy) => anything                    ;; il n'est pas important ce que renvoie la fonction buy
      (provided 
        (read-line) => "")                 ;; étant donnée que read-line renvoie chaîne vide // fin du premier test 
      (buy) => anything
      (provided 
        (read-line) =streams=> ["b" ""]))  ;; étant donnée que read-line renvoie successivement "b" puis chaîne vide

(fact "it prints the total for every line of input"
      (buy) => anything                                ;; still not important what buy returns
      (provided 
        (read-line) =streams=> ["a" "c" ""]           
        (println "total: " 100) => anything :times 1   ;; after adding the "a" (apple) that cost 100 println should be called with "total: 100"
        (println "total: " 175) => anything :times 1)) ;; after adding "c" (cherries) that cost 75 println should be called with "total: 175"

(fact  "it accepts both a single item and comma separated items as input"
      (let [total (basket-price "p" "c" "b")] 
        (buy) => anything
	      (provided 
	        (read-line) =streams=> ["p,c" "b" ""]
	        (println "total: " total) => anything  )))
