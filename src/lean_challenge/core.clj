(ns lean-challenge.core)


(loop [line (read-line)]
  (println line)
  (if (empty? line)
    line
    (recur (read-line))))