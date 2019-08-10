(ns clide.specs.trait
  (:require
   [clide.specs.text :as cs-text]
   [clojure.spec.alpha :as s]))

(s/def ::id string?)
(s/def ::content ::cs-text/c-markdown)

(s/def ::type #{:Pro :Con})

(s/def ::c-trait (s/keys :req-un [::id ::content]))

(s/def ::c-create-trait (s/keys :req-un [::type ::content]))
