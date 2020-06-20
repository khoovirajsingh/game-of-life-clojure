(ns game-of-life.core
  (:gen-class))

(def alive "*")
(def dead ".")

(defn create-world
  [row column]
  (vec (repeat row (vec (repeat column dead)))))

