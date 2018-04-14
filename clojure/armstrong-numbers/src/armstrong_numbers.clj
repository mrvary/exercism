(ns armstrong-numbers)

(defn ** [x n]
  (reduce * (repeat n x)))

(defn armstrong? [n]
  (let [digit-count (count (str n))
        digit-list (map #(Integer/parseInt (str %)) (str n))
        result (reduce + (map #(** % digit-count) digit-list))]
    (= n result)))
       

