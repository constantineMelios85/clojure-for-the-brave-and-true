(ns chapter-3.core)

(defn add-100 
  ([] 100)
  ([x] (+ x 100)))

(defn dec-maker [n]
  (fn [x] (- x n)))

(defn mapset [f coll]
  (reduce (fn [s x] (conj s (f x))) #{} coll))


(defn body-part-expander [part matching-parts-count]
  (map (fn [i] {
    :name (str (:name part) "-" i)
    :size (:size part)
  }) (range 0 matching-parts-count)))

(defn- symmetrize-body-parts-range
  "Expects a seq of maps with :name and :size keys and a number of matching parts."
  [asym-body-parts matching-parts-count]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set (map #(merge part %) (body-part-expander part matching-parts-count))))) [] asym-body-parts))