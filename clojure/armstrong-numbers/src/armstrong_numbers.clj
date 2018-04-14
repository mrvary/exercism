(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn digit-sum [num exponent]
  ;; sums digits each raised to the power of exp
  (loop [current-num num
         sum 0]
    (if (= 0 current-num)
      sum
      (recur (quot current-num 10)
             (+ sum (exp (mod current-num 10) exponent))))))

(defn num-of-digits [n]
  (if (< n 10)
      1
      (inc (num-of-digits (quot n 10)))))

(defn armstrong? [n]
  (= (digit-sum n (num-of-digits n)) n))


