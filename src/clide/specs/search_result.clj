(ns clide.specs.search-result
  (:require
   [clide.specs.search-result.category :as cssr-category]
   [clide.specs.search-result.item :as cssr-item]
   [clojure.spec.alpha :as s]))

(s/def ::c-search-result
  (s/or
   :category-result ::cssr-category/search-result
   :item-result ::cssr-item/search-result))
