(ns lean-challenge.core
  (:use [midje.sweet]))
(defn pname [product]
  ({"banana" "banana"
    "cherries" "cherries"
    "apple" "apple"
    "pommes" "apple"
    "mele" "apple"} 
    product)
    )
(def products {"banana" 1.5 "apple" 1 "mela" 1 "pommes" 1 "cherries" 0.75 })
(defn fruits 
  [fruit]
  (products fruit))
(defn priceof [fruit]
  (fruits fruit ))
(fact 
  (priceof "apple") => 1
  (priceof "banana") => 1.5
  (priceof "cherries") => 0.75
  )
(defn numberof [needle haystack]
  (count (filter #{needle} haystack)))
(defn reduction [items]
  (+ (* (priceof "banana") (quot (numberof "banana" items) 2))
     (* 0.2 (quot (numberof "cherries" items) 2))
     (* 1 (quot (numberof "pommes" items) 3))
     (* 0.5 (quot (numberof "mela" items) 2))
     (* 1 (quot (count (filter #{"apple" "mela" "pommes"} items)) 4))
     (* 2 (quot (count items) 5))
         
  ))
(defn basket-price [items]
  (-  (apply + (map fruits items)) (reduction items)))

(fact
  "discount for two cherries"
  (basket-price '("cherries")) => 0.75
  (basket-price '("cherries" "cherries")) => 1.3
  (basket-price '("cherries" "cherries" "cherries" "cherries")) => 2.6
  (basket-price '("banana" "banana")) => (priceof "banana")
  (basket-price '("pommes" "pommes" "pommes")) => 2.0
  (basket-price '("mela" "mela" )) => 1.5
  (basket-price '("mela" "pommes" "pommes" "mela" )) => 2.5
  (basket-price '("banana" "banana" "banana" "banana" "banana" )) => (+ (priceof "banana") -2 (* 2 (priceof "banana")))
  )
(defn csv-to-list [csv]
  (seq (.split csv ",")))
(fact
  (csv-to-list "apples,cherries,bananas") => '("apples" "cherries" "bananas")
  (csv-to-list "bananas") => '( "bananas")
  )
(defn add [items item]
  (swap! items  #(concat item %)))

(defn buy []
  (def e (atom '()))
  (loop [price 0]
	  (println (basket-price @e) )
	  (let [item (read-line)]
     (if (= item "")
       (basket-price @e)
       (recur (add e (csv-to-list item)))))))

;;(println (loop [line (read-line)]
;;          (case line
;;             ("apple") ((println 1) (recur (read-line)))
;;             ("banana") ((println 1.5) (recur (read-line)))
;;             (println "finished shopping"))))
