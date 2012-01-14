(ns lean-challenge.core)

(defn cost
  [fruit] ({"b" 150 "a" 100 "p" 100 "m" 100 "c" 75} fruit))
(defn csv-to-col [s]
  (seq (.split s ",")))
(defn discount [fruits]
  (+ 
    (* 20 (quot (count (filter #{"c"} fruits)) 2))
    (* (cost "b") (quot (count (filter #{"b"} fruits)) 2)))
  )
(defn basket-price
  [fruits]
  (- (reduce + (map cost fruits)) 
     (discount fruits)))