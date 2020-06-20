(ns game-of-life.core-test
  (:require [clojure.test :refer :all]
            [game-of-life.core :refer :all]))

(deftest new-world-is-represented-in-2d-with-dead-cells
  (is (= [[dead]] (create-world 1 1)))
  (is (= [[dead dead] [dead dead]] (create-world 2 2))))


(deftest cell-is-alive
  (is (= true (live-cell? alive)))
  (is (= false (live-cell? dead))))


(deftest cell-is-dead
  (is (= true (dead-cell? dead)))
  (is (= false (dead-cell? alive))))

(deftest regenerate-dead-cell
  (is (= false (regenerate-cell? dead 2)))
  (is (= true (regenerate-cell? dead 3))))

(deftest alive-cell-survives
  (is (= true (keep-cell-alive? alive 2)))
  (is (= true (keep-cell-alive? alive 3)))
  (is (= false (keep-cell-alive? alive 1))))

(deftest alive-cell-dies-because-of-underpopulation
  (is (= true (underpopulation? alive 1)))
  (is (= false (underpopulation? alive 2))))


