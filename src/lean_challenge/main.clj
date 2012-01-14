(ns lean-challenge.main
  (:use [lean-challenge.core] :reload))

(loop [item (read-line) items []]
  (println (basket-price (concat (csv-to-col item) items)))
  (if (empty? item)
    item
    (recur (read-line) (concat (csv-to-col item) items))))