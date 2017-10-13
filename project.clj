(defproject learning-clojure "0.1.0-SNAPSHOT"
  :description "Unbelievable9 Clojure Learning Note."
  :url "https://unbelievable9.info"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot learning-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
