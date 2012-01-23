(ns lean-challenge.core)

(defn cost [fruit] 
  ({"b" 150 "a" 100 "p" 100 "m" 100 "c" 75} fruit))

(defn csv-to-col [s]
  (seq (.split s ",")))

(defn lots-of [lot-size fruits & discounted-fruits]
  (quot (count (filter (set discounted-fruits) fruits)) lot-size))

(defn discount [fruits]
  (+ 
    (* 20 (lots-of 2 fruits "c"))
    (* 50 (lots-of 2 fruits "m"))
    (* 100 (lots-of 3 fruits "p"))
    (* 150 (lots-of 2 fruits "b"))
    (* 100 (lots-of 4 fruits "p" "a" "m"))
    (* 200 (quot (count fruits) 5))))

(defn basket-price
  [fruits]
  (- (reduce + (map cost fruits)) 
     (discount fruits)))