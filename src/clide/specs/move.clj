(ns clide.specs.move
  (:require
   [clojure.spec.alpha :as s]))

(s/def ::direction #{:up :down})

(s/def ::c-move (s/keys :req-un [::direction]))
