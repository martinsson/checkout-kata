(ns lean-challenge.core)

(defn cost 
  ([fruit] ({"B" 150 "A" 100 "C" 75} fruit))
  ([fruit1 fruit2] (+ (cost fruit1) (cost fruit2)))
  ([fruit1 fruit2 & fruits] (+ (cost fruit1 fruit2) 
                               (reduce cost 0 fruits ))))
