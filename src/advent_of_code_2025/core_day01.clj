(in-ns 'advent-of-code-2025.core)

(require '[clojure.test :refer :all])

(defn turnRight
  [current turn-by]
  (mod (+ current (int turn-by)) 100)
)

(defn turnLeft
  [current turn-by]
  (mod (- current (int turn-by)) 100)
)

(defn rotate-dials
  "Find the next rotation of the dial"
  ([dial instructions]
   (rotate-dials dial instructions 0)
  )
  ([dial [next & others] password]
   (if (nil? next)
     password
     (let [amount (Integer/parseInt (subs next 1))
           new-dial (if (.startsWith next "R")
                    (turnRight dial amount)
                    (turnLeft dial amount))
           new-password (if (zero? new-dial)
                       (inc password)
                       password)]
       (rotate-dials new-dial others new-password)
     )
   )
  )
)

(defn rotate-dials-part-b
  "Find the next rotation of the dial"
  ([dial instructions]
   (rotate-dials-part-b dial instructions 0)
  )
  ([dial [next & others] password]
   (if (nil? next)
     password
     (let [amount (Integer/parseInt (subs next 1))
           is-right (.startsWith next "R")
            crossings (if is-right
                        (quot (+ dial amount) 100)
                        (cond
                            (zero? dial) (quot amount 100)
                            (>= amount dial) (+ 1 (quot (- amount dial) 100))
                            :else 0))
           new-dial (if is-right
                    (turnRight dial amount)
                    (turnLeft dial amount))
            new-password (+ password crossings)]
       (rotate-dials-part-b new-dial others new-password)
     )
   )
  )
)


(defn day01
  "Find the password to the north pole gate"
  [input]
  (println (rotate-dials 50 input))
  (println (rotate-dials-part-b 50 input))
)




