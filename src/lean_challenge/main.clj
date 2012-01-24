(ns lean-challenge.main
  (:use [lean-challenge.core] :reload))

; runs in repl : just enter an empty line and you're ready for the next customer
(defn buy [] 
  (loop [items []]
    (let [item (read-line)
          basket (concat (csv-to-col item) items)
          total (apply basket-price basket)]
      (if-not (empty? item)
        (do 
          (println "total: " total) 
          (recur basket))))))
