(ns lean-challenge.core)

(defn cost
  [fruit] ({"B" 150 "A" 100 "C" 75} fruit))
(defn basket-price
  [fruits]
  (reduce + (map cost fruits)))