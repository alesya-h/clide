(ns clide.specs.item
  (:require
   [clide.specs.trait :as cs-trait]
   [clide.specs.text :as cs-text]
   [clide.specs.time :as cs-time]
   [clide.specs.toc :as cs-toc]
   [clojure.spec.alpha :as s]))

(s/def ::id string?)
(s/def ::name string?)
(s/def ::created ::cs-time/utc-time)
(s/def ::hackage string?)
(s/def ::link string?)
(s/def ::summary ::cs-text/c-markdown)
(s/def ::ecosystem ::cs-text/c-markdown)
(s/def ::notes ::cs-text/c-markdown)

(s/def ::section #{:ItemProsConsSection :ItemEcosystemSection :ItemNotesSection})

(s/def ::traits (s/* ::cs-trait/c-trait))
(s/def ::pros ::traits)
(s/def ::cons ::traits)

(s/def ::c-create-item
  (s/keys :req-un [::name] :opt-un [::hackage ::link]))

(s/def ::c-item-info
  (s/keys :req-un [::id ::created ::name] :opt-un [::hackage ::link]))
(s/def ::info ::c-item-info)

(s/def ::c-item-info-edit
  (s/keys :opt-un [::name ::hackage ::link]))

(s/def ::toc (s/* ::cs-toc/toc-heading))

(s/def ::c-item-full
  (s/keys :req-un [::id ::name ::created ::summary
                   ::pros ::cons
                   ::ecosystem ::notes ::toc]
          :opt-un [::hackage ::link]))
