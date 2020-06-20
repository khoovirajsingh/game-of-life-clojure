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

(defn overcrowded?
  [cell neighbours]
  (and (live-cell? cell) (> neighbours 3)))

(defn surrounding-cells
  [x y world]
  (let [north-west (get-in world [(- x 1) (- y 1)])
        north (get-in world [(- x 1) y])
        north-east (get-in world [(- x 1) (+ y 1)])
        east (get-in world [x (+ y 1)])
        south-east (get-in world [(+ x 1) (+ y 1)])
        south (get-in world [(+ x 1) y])
        south-west (get-in world [(+ x 1) (- y 1)])
        west (get-in world [x (- y 1)])]
   (vector north-west north north-east east south-east south south-west west)))

(defn live-neighbours-count
  [x y world]
  (let [cells (surrounding-cells x y world)]
    (get (frequencies cells) alive 0)))


