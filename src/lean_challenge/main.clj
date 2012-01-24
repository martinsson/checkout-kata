(ns lean-challenge.main
  (:use [lean-challenge.core] :reload))

; runs in repl : just enter an empty line and you're ready for the next customer
(defn buy [] 
  (loop [item (read-line) items []]
    (let [basket (concat (csv-to-col item) items)
          price (apply basket-price basket)]
		  (if-not (empty? item)
		    (recur 
          (do (println "total: " price) (read-line)) 
          basket)))))
