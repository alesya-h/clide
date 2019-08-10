(ns clide.specs.search-result.item
  (:require
   [clide.specs.category :as cs-category]
   [clide.specs.item :as cs-item]
   [clide.specs.text :as cs-text]
   [clojure.spec.alpha :as s]))

(s/def ::category ::cs-category/info)
(s/def ::description ::cs-text/c-markdown)
(s/def ::summary     ::cs-text/c-markdown)
(s/def ::ecosystem   ::cs-text/c-markdown)

(s/def ::tag #{:Item})
(s/def ::content
  (s/keys :req-un [::category ::cs-item/info]
          :opt-un [::description ::summary ::ecosystem]))

(s/def ::search-result
  (s/keys :req-un [::tag ::content]))
