(ns lean-challenge.main
  (:use [lean-challenge.core] :reload))

; runs in repl : just enter an empty line and you're ready for the next customer
(loop [item (read-line) items []]
  (println (basket-price (concat (csv-to-col item) items)))
  (if (empty? item)
    item
    (recur (read-line) (concat (csv-to-col item) items))))