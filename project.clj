(defproject echoserver "0.1.0-SNAPSHOT"
  :description "sample echo server"
  :url "http://example.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[aleph "0.4.3"]
                 [manifold "0.1.6"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.cli "0.3.5"]]
  :main ^:skip-aot echoserver.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
