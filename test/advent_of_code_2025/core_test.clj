(ns advent-of-code-2025.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2025.core :refer :all]))



;; day01
(deftest test-turnRight
 (testing "Turn right wraps around at 100"
     (is (= 0 (turnRight 99 1)))
     (is (= 0 (turnRight 95 5)))
 )
)
(deftest test-turnLeft
 (testing "Turn left wraps around at 0"
     (is (= 99 (turnLeft 0 1)))
     (is (= 95 (turnLeft 5 10)))
)
)

(deftest test-rotate-dials
 (testing "Counts zero crossings"
     (is (= 3 (rotate-dials 50 ["L68" "L30" "R48" "L5" "R60" "L55" "L1" "L99" "R14" "L82"])))
     )
  )

(deftest test-rotate-dials-part-b
 (testing "Counts zero crossings"
     (is (= 6 (rotate-dials-part-b 50 ["L68" "L30" "R48" "L5" "R60" "L55" "L1" "L99" "R14" "L82"])))
     (is (= 10 (rotate-dials-part-b 50 ["R1000"])))
     )
  )
