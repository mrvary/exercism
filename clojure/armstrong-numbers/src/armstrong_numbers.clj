(ns armstrong-numbers)

(defn ** [x n]
  (reduce * (repeat n x)))

(defn armstrong? [n]
  (let [digits (count (str n))
        result (reduce + (map #(** (Integer/parseInt (str %)) digits) (str n)))]
    (= n result)))
       

