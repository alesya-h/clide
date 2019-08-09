(ns clide.server
  (:require
   [compojure.api.sweet :as c]
   [ring.util.http-response :as resp]
   ))

(def handler
  (c/api
   (c/GET "/" []
     :query-params [name :- String]
     (resp/ok {:message (str "Hi " name)}))))
