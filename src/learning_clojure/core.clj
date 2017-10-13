(ns learning-clojure.core
  (:gen-class))

(require '[clojure.string :as string])
(use '[clojure.string :only (join)])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "First Clojure Program!"))

;;===============================Chapter II===============================
;; 一个函数多种参数
(defn greeting
  "Say Hello to Somebody."
  ([]
   (greeting "World"))
  ([username]
   (greeting username "Welcome to Emacs."))
  ([username content]
   (str (format "Hello %s! %s" username content))))

;; & 使用 注意结果是放到一个list中
(defn show-cast-list
  [actor-1 actor-2 & others]
  (println actor-1 "and" actor-2 "and other" (count others) "actors."))

;; 匿名函数的使用
(defn indexable-words
  [text]
  (let [indexable-word? #(> (count %) 2)]
    (filter indexable-word? (string/split text #"\W+"))))

;; 用参数动态构造新函数
(defn create-person
  [person-category]
  (fn [name] (str name " is a(n) " person-category)))

;; let 绑定
(defn square-coners
  [left bottom size]
  (let [top (+ bottom size)
        right (+ left size)]
    [[left top] [right top] [left bottom] [right bottom]]))

;; 参数解构
(defn only-get-age（）
  [{fname :name fage :age}]
  (println (format "Author %s is %s year(s) old." fname fage)))

;; if do
(defn less-than-hundred
  [number]
  (if (< number 100)
    (do
      (println "This is the result")
      (str (format "The Number %s is Less Than 100" number)))
    (do
      (str (format "The Number %s is more Than 100" number)))))

;; loop
;; recur 可以回到函数起始处再执行
(defn count-down
  [time]
  (loop [result [] x time]
    (if (zero? x)
      result
      (recur (conj result x)
             (dec x)))))

(defn simple-count-down
  [result time]
  ;; recur 会回到这里继续调用
  (if (zero? time)
    result
    (recur (conj result time)
           (dec time))))

;; Port For Loop
(defn index-collection
  [coll]
  (map-indexed vector coll))

(defn index-filter
  [pred coll]
  (when pred
    (for [[idx elt] (index-collection coll)
          :when (pred elt)]
      idx)))

(defn index-of-any
  [pred coll]
  (first (index-filter pred coll)))

;;===============================Chapter III===============================

;; conj & into
;; 对于列表 在最前面插入
;; 对于矢量 在最后面插入

;; 创建Sequence
;; range repeat iterate take cycle
;; interleave interpose
(defn give-me-five-even
  []
  (range 2 10 2))

(defn repeat-input-five-times
  [input]
  (take 5 (repeat input)))

(defn whole-numbers
  []
  (iterate inc 1))

(defn whole-character
  []
  (map char (range (int \a) (inc (int \z)))))

(defn number-character
  []
  (interleave (whole-numbers) (whole-character)))

;; join
(defn insert-comma
  [aseq]
  (apply str (interpose \, aseq)))

(defn insert-comma-simple
  [aseq]
  (join \, aseq))

;; Filter

;; take-while 只返回为true的元素
;; drop-while 返回最后为true以后的元素

;; Sequence Predicates
;; every? seq 中每一个都为true
;; some 返回第一个为 pred = true 的值

;; Transform
;; Map 可以多参数
;; Reduce 特别适合求和
