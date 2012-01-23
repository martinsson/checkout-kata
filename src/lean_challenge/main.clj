(ns lean-challenge.main
  (:use [lean-challenge.core] :reload))

; runs in repl : just enter an empty line and you're ready for the next customer
(defn buy [] 
  (loop [item (read-line) items []]
    (let [basket (concat (csv-to-col item) items)]
		  (println (basket-price basket))
		  (if (empty? item)
		    (basket-price basket)
		    (recur (read-line) basket)))))
