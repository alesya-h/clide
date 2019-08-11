(ns clide.server
  (:require
   [clide.data.categories :as categories]
   [compojure.api.sweet :as c]
   [ring.util.http-response :as resp]
   [ring.middleware.json :as ring-json]
   [clide.specs.category :as spec-category]
   [clide.specs.text :as spec-text]
   [clojure.spec.alpha :as s]
   ))

(def app
  (c/api
   {:coercion :spec
    :swagger
     {:ui "/api-docs"
      :spec "/swagger.json"
      :data {:info {:title "Sample API"
                    :description "Compojure Api example"}
             :tags [{:name "api", :description "some apis"}]
             :consumes ["application/json"]
             :produces ["application/json"]}}}
   (c/GET "/categories" []
     :return (s/* ::spec-category/c-category-info)
     (resp/ok (categories/get-all)))
   (c/context "/category" []
     (c/POST "/" request
       :query-params [title :- ::spec-category/title, group :- ::spec-category/group]
       :return ::spec-category/id
       (-> (categories/create-category! {:title title :group group})
           str))
     (c/context "/:category-id" []
       :path-params [category-id :- ::spec-category/id]
       (c/GET "/" []
           :return (s/* ::spec-category/c-category-full)
           (if-some [c (categories/get-category category-id)]
             (resp/ok c)
             (resp/not-found)))
       (c/DELETE "/" []
         (if (categories/delete-category! category-id)
           (resp/ok)
           (resp/not-found)))
       (c/PUT "/notes" []
         :body [body ::spec-text/c-text-edit]
         (resp/not-implemented))
       (c/PUT "/info" []
         :body [body ::spec-category/c-category-info-edit]
         (resp/not-implemented))
     ))))

(def handler
  (-> #'app
      (ring-json/wrap-json-body {:keywords? true
                                 :bigdecimals? true})
      (ring-json/wrap-json-response)))
