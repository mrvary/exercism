(ns bob
  (:use [clojure.string :only [blank? upper-case]]))

(defn question?
  [x]
  (.endsWith x "?"))

(defn yelling?
  [x]
  (and (re-find #"[A-Z]" x)
       (= (upper-case x) x)))

(defn response-for
  ([] "Fine. Be that way!")
  ([input]
   (cond
     (blank? input) (response-for)
     (yelling? input) "Whoa, chill out!"
     (question? input) "Sure."
     :else "Whatever.")))
