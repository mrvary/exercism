(ns run-length-encoding)

(defn- repeat-char
  [pair]
  (let [[n c] pair]
    (apply str (repeat (Integer/parseInt (str n)) (str c)))))

(defn num?
  [x]
  (re-matches #"\d" (str x)))

(defn- reduce-chars
  "takes a seq of chars and returns a list of (length value)"
  [chars]
  (let [length (count chars)
        char (first chars)]
    (if (> length 1)
      (list length char)
      char)))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s]
  (->> s
       (partition-by identity)
       (map reduce-chars)
       (flatten)
       (clojure.string/join)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  (cond
    (empty? s) ""
    (num? (first s)) (str (repeat-char (take 2 s)) (run-length-decode (nnext s)))
    :else (str (first s) (run-length-decode (next s)))))
