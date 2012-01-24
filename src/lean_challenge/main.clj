(ns lean-challenge.main
  (:use [lean-challenge.core] :reload))

; just enter an empty line and you're ready for the next customer
(defn buy [] 
  (loop [items []]
    (let [item (read-line)                          ;; reads from console
          basket (concat (csv-to-col item) items)   ;; add item (can be several items separated by comma) to existing items
          total (apply basket-price basket)]        ;; total basket price
      (if-not (empty? item)
        (do                                         ;; only one instruction can follow if-not, and since we need to both print the total
          (println "total: " total)                 ;; and recur back to the loop point we wrap in a do statement
          (recur basket))))))
