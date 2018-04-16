(ns rna-transcription)

(defn rna-complement
  [x]
  (cond
    (= x \G) "C"
    (= x \C) "G"
    (= x \A) "U"
    (= x \T) "A"
    :else (throw (AssertionError. "Wrong input."))))

(defn to-rna
  [input]
  (apply str (map rna-complement input)))
