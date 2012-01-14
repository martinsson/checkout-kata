(ns lean-challenge.main
  (:use [lean-challenge.core] :reload))

(loop [item (read-line) items []]
  (println (basket-price (cons item items)))
  (if (empty? item)
    item
    (recur (read-line) (cons item items))))