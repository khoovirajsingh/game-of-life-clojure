(ns game-of-life.core-test
  (:require [clojure.test :refer :all]
            [game-of-life.core :refer :all]))

(def world-1-by-1 [[dead]])
(def next-world-1-by-1 [[dead]])

(def world-2-by-2 [[alive dead] [dead dead]])
(def next-world-2-by-2 [[dead dead] [dead dead]])

(def world-3-by-3 [[dead alive dead] [alive alive alive] [dead alive dead]])
(def next-world-3-by-3 [[alive alive alive] [alive dead alive] [alive alive dead]])

(deftest compute-next-generation-acceptance-tests
  (is (= world-1-by-1 (next-generation next-world-1-by-1)))
  (is (= world-2-by-2 (next-generation next-world-2-by-2)))
  (is (= world-3-by-3 (next-generation next-world-3-by-3))))

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

(deftest live-cell-survives
  (is (= true (keep-cell-alive? alive 2)))
  (is (= true (keep-cell-alive? alive 3)))
  (is (= false (keep-cell-alive? alive 1))))

(deftest live-cell-dies-because-of-underpopulation
  (is (= true (underpopulation? alive 1)))
  (is (= false (underpopulation? alive 2))))

(deftest live-cell-dies-because-of-overcrowding
  (is (= true (overcrowded? alive 4)))
  (is (= false (overcrowded? alive 3))))

(deftest live-neighbours-count-for-each-cell
  (is (= 0 (live-neighbours-count 0 0 world-1-by-1)))
  (is (= 0 (live-neighbours-count 0 0 world-2-by-2)))
  (is (= 1 (live-neighbours-count 0 1 world-2-by-2)))
  (is (= 4 (live-neighbours-count 1 1 world-3-by-3))))


