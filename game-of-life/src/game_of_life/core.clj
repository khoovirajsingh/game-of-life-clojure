(ns game-of-life.core
  (:gen-class))

(defn create-empty-world
  [row column]
  (vec (repeat row (vec (repeat column "")))))

