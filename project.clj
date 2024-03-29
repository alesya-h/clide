(defproject clide "0.1.0-SNAPSHOT"
  :description "Clojure reimplementation of Aelve Guide"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [
                 [org.clojure/clojure "1.10.1"]
                 [functionalbytes/mount-lite "2.1.1"]
                 [metosin/spec-tools "0.10.0"]
                 [metosin/compojure-api "2.0.0-alpha30"]
                 [clj-time "0.15.2"]
                 [ring "1.7.1"]
                 [ring/ring-json "0.5.0"]
                 [cheshire "5.9.0"]
                 ]
  :main ^:skip-aot clide.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
