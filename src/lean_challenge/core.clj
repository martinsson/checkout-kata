(ns lean-challenge.core)

(defn cost [fruit] 
  ({"b" 150 "a" 100 "p" 100 "m" 100 "c" 75} fruit))

(defn csv-to-col [s]
  (seq (.split s ",")))

(defn lots-of [lot-size basket & fruits]
  (quot (count (filter (set fruits) basket)) lot-size))

(defn discount [basket]
  (+ 
    (* 20 (lots-of 2 basket "c"))
    (* 50 (lots-of 2 basket "m"))
    (* 100 (lots-of 3 basket "p"))
    (* 150 (lots-of 2 basket "b"))
    (* 100 (lots-of 4 basket "p" "a" "m"))
    (* 200 (quot (count basket) 5))))

(defn basket-price
  [fruits]
  (- (reduce + (map cost fruits)) 
     (discount fruits)))