(ns clide.data.categories)

(def init-data
  {:categories {}
   :next-category-id-counter 1
   :last-category-id nil})

(defonce data (atom init-data))

;; (reset! data init-data)

(defn get-all []
  (->> @data
       :categories
       (mapv val)))

(defn get-category [category-id]
  (-> @data :categories category-id))

(defn create-category [{:keys [next-category-id-counter categories] :as all-data}
                       category-data]
  (let [category-id (-> next-category-id-counter str)]
    (-> all-data
        (assoc-in [:categories category-id] (assoc category-data :id category-id))
        (assoc :last-category-id category-id)
        (update :next-category-id-counter inc))))

(defn create-category! [category-data]
  (-> (swap! data create-category category-data)
      :last-category-id))

(defn delete-category! [category-id]
  (when (get-category category-id)
    (swap! data update :categories dissoc category-id)
    true))
