(ns run-length-encoding)

;; ENCODE

(defn- reduce-chars
  "takes a seq of chars and returns '(length value) for duplicates"
  [chars]
  (let [length (count chars)
        char (first chars)]
    (if (> length 1) (list length char) char)))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s]
  (->> s
       (partition-by identity)
       (map reduce-chars)
       (flatten)
       (clojure.string/join)))

;; DECODE

(defn- repeat-char
  "repeats char c n times, the output is a seq of single digit strings"
  [[n c]]
  (repeat (Integer/parseInt (str n)) (str c)))

(defn- num?
  "returns true if input char is a number"
  [x]
  (re-matches #"\d+" (str x)))

(defn- split-input
  "splits '3a35bsd' into '(\"3\" \"a\" \"35\" \"b\" \"s\" \"d\") "
  [s]
  (re-seq #"[a-zA-Z ]|\d+" s))

(defn- transform-input
  "transforms a list of numbers and chars into a list of only chars"
  [coll]
  (let [item (first coll)]
    (cond
      (empty? coll) '()
      (num? item) (conj (transform-input (nnext coll))
                        (repeat-char (take 2 coll)))
      :else (conj (transform-input (next coll)) item))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  (->> s
       (split-input)
       (transform-input)
       (flatten)
       (clojure.string/join)))
