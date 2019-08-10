(ns clide.time
  (:require
   [clj-time.format :as f]))

(def utc-time-formatter (f/formatters :date-time-no-ms))

(defn try-parse-time [time-str]
  (try
    (f/parse utc-time-formatter time-str)
    (catch Exception e nil)))
