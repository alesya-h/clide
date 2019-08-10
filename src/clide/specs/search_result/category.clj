(ns clide.specs.search-result.category
  (:require
   [clide.specs.category :as cs-category]
   [clide.specs.text :as cs-text]
   [clojure.spec.alpha :as s]))

(s/def ::description ::cs-text/c-markdown)

(s/def ::tag #{:Category})
(s/def ::content (s/keys :req-un [::cs-category/info ::description]))

(s/def ::search-result
  (s/keys :req-un [::tag ::content]))

(def example
  {:tag :Category
   :content {:info {:id "foo" :title "title" :created "2016-07-22T00:00:00Z"
                    :group "name" :status :CategoryStub}
             :description {:text "" :html ""}}})
