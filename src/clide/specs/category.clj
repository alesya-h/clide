(ns clide.specs.category
  (:require
   [clide.specs.time :as cs-time]
   [clide.specs.item :as cs-item]
   [clide.specs.text :as cs-text]
   [clojure.spec.alpha :as s]))

(s/def ::id string?)
(s/def ::title string?)
(s/def ::group string?)
(s/def ::description ::cs-text/c-markdown)
(s/def ::created ::cs-time/utc-time)
(s/def ::status #{:CategoryStub :CategoryWIP :CategoryFinished})

(s/def ::sections (s/* ::cs-item/section))
(s/def ::items    (s/* ::cs-item/c-item-full))

(s/def ::c-category-info
  (s/keys :req-un [::id ::title ::created ::group ::status]))

(s/def ::info ::c-category-info)

(s/def ::c-category-full
  (s/keys :req-un [::id ::title ::group ::status
                   ::description ::sections ::items]))

(s/def ::c-category-info-edit
  (s/keys :req-un [::title ::group ::status ::sections]))
