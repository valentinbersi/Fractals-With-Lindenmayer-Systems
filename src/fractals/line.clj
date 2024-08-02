(ns fractals.line)

(defn create
  "[start end width]: Returns a line with the given start, end and width"
  ([start end width] {:start start :end end :width width}))

(defn start
  "[l]: Returns the start of the given line
  [l v]: Returns a line based on the given one, but with its start set to the given one"
  ([l] (get l :start))
  ([l v] (create v (get l :end) (get l :width))))

(defn end
  "[l]: Returns the end of the given line
  [l v]: Returns a line based on the given one, but with its end set to the given one"
  ([l] (get l :end))
  ([l v] (create (start l) v (get l :width))))

(defn width
  "[l]: Returns the width of the given line
  [l w]: Returns a line based on the given one, but with its width set to the given one"
  ([l] (get l :end))
  ([l w] (create (start l) (end l) w)))
