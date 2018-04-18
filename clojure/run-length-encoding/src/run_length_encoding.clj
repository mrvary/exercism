(ns run-length-encoding)

(defn repeat-char
  [pair]
  (let [[n c] pair]
    (apply str (repeat (Integer/parseInt (str n)) (str c)))))

(defn num?
  [x]
  (re-matches #"\d" (str x)))

(defn parse
  [s]
  (loop [result []
         coll s]))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s])



(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  (cond
    (empty? s) ""
    (num? (first s)) (str (repeat-char (take 2 s)) (run-length-decode (nnext s)))
    :else (str (first s) (run-length-decode (next s)))))
