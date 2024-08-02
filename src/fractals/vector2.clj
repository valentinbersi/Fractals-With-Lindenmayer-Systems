(ns fractals.vector2)

(defn create
  "[_x _y]: Returns a vector with the coordinates (x y)"
  ([_x _y] {:x _x :y _y}))

(defn x
  "[v]: Returns the x coordinate of the given vector2
  [v n]: Returns a vector2 based on the given vector2 with its x coordinate set to the given one"
  ([v] (get v :x))
  ([v n] (create n (get :y v))))

(defn y
  "[v]: Returns the y coordinate of the given vector2
  [v n]: Returns a vector2 based on the given vector2 with its y coordinate set to the given one"
  ([v] (get v :y))
  ([v n] (create (x v) n)))

(defn add
  "[]: Returns the vector (0 0)
  [v]: Returns v
  [v1 v2]: Returns the addition of the two vectors
  [v1 v2 & more]: Returns the sum of the given vectors2"
  ([] (create 0 0))
  ([v] v)
  ([v1 v2] (create (+ (x v1) (x v2))
                   (+ (y v1) (y v2))))
  ([v1 v2 & more] (reduce add (add v1 v2) more)))

(defn norm
  "[v]: Returns the norm of the given vector2"
  ([v] (Math/sqrt (+ (* (x v) (x v))
                     (* (y v) (y v))))))

(defn rotate
  "[v angle]: Returns the rotation from the origin of coordinates by the given angle of the given vector-2"
  ([v angle] (create (+ (* (Math/cos (Math/toRadians angle)) (x v)) (* (Math/sin (Math/toRadians angle)) (y v)))
                     (+ (- (* (Math/sin (Math/toRadians angle)) (x v))) (* (Math/cos (Math/toRadians angle)) (y v))))))

(defn equal?
  "[]: Returns false
  [v]: Returns true
  [v1 v2]: Returns true if both vectors2 have the same coordinates.In another case, false.
  [v1 v2 & more]: Returns true if all the vectors2 have the same coordinates"
  ([] false)
  ([v] true)
  ([v1 v2] (and (= (x v1) (x v2))
                (= (y v1) (y v2))))
  ([v1 v2 & more] (and (equal? v1 v2)
                       (and (for [v more] (equal? v1 v))))))

(defn min-vector-list
  "Returns a vector with the min x coordinate and the y min coordinate of the given vectors list"
  [lv] (create (apply min (for [v lv] (x v))) (apply min (for [v lv] (y v)))))

(defn max-vector-list
  "Returns a vector with the max x coordinate and the y max coordinate of the given vectors list"
  [lv] (create (apply max (for [v lv] (x v))) (apply max (for [v lv] (y v)))))