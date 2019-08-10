(ns clide.specs.time
  (:require
   [clide.time :as clide-time]
   [clojure.spec.alpha :as s]))

(s/def ::utc-time (s/and string? clide-time/try-parse-time))
