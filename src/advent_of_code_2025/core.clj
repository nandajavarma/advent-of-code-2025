(ns advent-of-code-2025.core
  (:require [clojure.test :refer :all]
            [clojure.string :as str])
  (:gen-class))

(load "core_day01")

(defn read-input [filename]
  (str/split-lines (slurp filename))
 )

(defn -main
  "Run advent of code puzzle solution of each day of the month"
  [& args]
  (if (not= (count args) 1)
    (println "You must tell me AoC challenge we are solving you silly!")
    (day01 (read-input "resources/day01.txt"))
  ))

