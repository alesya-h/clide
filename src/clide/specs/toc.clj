(ns clide.specs.toc
  (:require
   [clide.specs.text :as cs-text]
   [clojure.spec.alpha :as s]))

(s/def ::content ::cs-text/c-markdown)
(s/def ::slug string?)

(s/def ::subheadings (s/* ::toc-heading))

(s/def ::toc-heading
  (s/keys :req-un [::content ::slug ::subheadings]))
