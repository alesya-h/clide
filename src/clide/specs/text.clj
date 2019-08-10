(ns clide.specs.text
  (:require
   [clojure.spec.alpha :as s]))

(s/def ::text string?)
(s/def ::html string?)
(s/def ::original string?)
(s/def ::modified string?)

(s/def ::c-markdown
  (s/keys :req-un [::text ::html]))

(s/def ::c-text-edit
  (s/keys :req-un [::original ::modified]))
