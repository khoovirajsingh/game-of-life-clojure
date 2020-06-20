(ns game-of-life.core-test
  (:require [clojure.test :refer :all]
            [game-of-life.core :refer :all]))

(deftest new-world-is-represented-in-2d-with-dead-cells
  (is (= [[dead]] (create-world 1 1)))
  (is (= [[dead dead] [dead dead]] (create-world 2 2))))


(deftest cell-is-alive
  (is (= true (live-cell? alive)))
  (is (= false (live-cell? dead))))
  


