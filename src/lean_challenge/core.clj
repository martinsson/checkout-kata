(ns lean-challenge.core)

(defn cost 
  ([fruit] ({"B" 150 "A" 100 "C" 75} fruit))
  ([fruit1 & more] (let [fruits (cons fruit1 more)] 
                     (reduce + (map cost fruits )))))
