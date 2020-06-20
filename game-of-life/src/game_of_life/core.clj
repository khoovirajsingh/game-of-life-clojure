(ns game-of-life.core
  (:gen-class))

(def alive "*")

(def dead ".")

(defn live-cell? [cell] (= cell alive))

(defn dead-cell? [cell] (= cell dead))

(defn create-world
  [row column]
  (vec (repeat row (vec (repeat column dead)))))

(defn regenerate-cell?
  [cell neighbours]
  (and (dead-cell? cell) (= neighbours 3)))

(defn keep-cell-alive?
  [cell neighbours]
  (let [suistanable? (or (= neighbours 2) (= neighbours 3))]
    (and (live-cell? cell) suistanable?)))

(defn underpopulation?
  [cell neighbours]
  (and (live-cell? cell) (< neighbours 2)))

