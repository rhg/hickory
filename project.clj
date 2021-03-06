(defproject hickory "0.5.4-SNAPSHOT"
  :description "HTML as Data"
  :url "http://github.com/rhg/hickory"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src"  "target/generated-src"]
  :test-paths ["target/generated-test"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1934"]
                 [quoin "0.1.0"]
                 [org.jsoup/jsoup "1.7.1"]
                 [rhg135/node-hickory "0.0.1" :exclusions [org.clojure/clojurescript]]]
  :plugins [[codox "0.6.4"]
            [lein-cljsbuild "0.3.4"]
            [com.keminglabs/cljx "0.3.0"]
            [org.bodil/lein-noderepl "0.1.11"]
            [com.cemerick/clojurescript.test "0.1.0"]]
  :hooks [cljx.hooks]
  :codox {:sources ["src" "target/generated-src"]
          :output-dir "codox-out"
          :src-dir-uri "http://github.com/rhg/hickory/blob/master"
          :src-linenum-anchor-prefix "L"}
  :cljx {:builds [{:source-paths ["src"]
                   :output-path "target/generated-src"
                   :rules :clj}
                  {:source-paths ["src"]
                   :output-path "target/generated-src"
                   :rules :cljs}
                  {:source-paths ["test"]
                   :output-path "target/generated-test"
                   :rules :clj}
                  {:source-paths ["test"]
                   :output-path "target/generated-test"
                   :rules :cljs}]}
  :cljsbuild {:builds [{:source-paths ["target/generated-src" "target/generated-test"]
                        :compiler {:output-to "target/cljs/testable.js"}
                        :optimizations :whitespace
                        :pretty-print true}]
              :test-commands {"unit-tests" ["phantomjs" :runner "target/cljs/testable.js"]}})
