(ns game-of-life.core-test
  (:require [clojure.test :refer :all]
            [game-of-life.core :refer :all]))

(deftest empty-world-is-represented-in-2d
  (is (= [[""]] (create-empty-world 1 1))))
