(ns clide.core
  (:require
   [clide.server :as server]
   [ring.adapter.jetty :as ring-jetty]
   [mount.lite :as mnt])
  (:gen-class))

(mnt/defstate http-server
  :start (ring-jetty/run-jetty #'server/handler {:port 3000 :join? false})
  :stop (.stop @http-server))

(defn restart []
  (mnt/stop)
  (mnt/start))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
