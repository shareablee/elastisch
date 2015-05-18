(ns clojurewerkz.elastisch.rest.bulk
  (:refer-clojure :exclude [get replace count sort])
  (:require [clojurewerkz.elastisch.rest :as rest]
            [cheshire.core :as json]
            [clojure.string :as string]
            [clojure.set :refer :all]
            [clojurewerkz.elastisch.common.bulk :as common-bulk]))

(defn ^:private bulk-with-url
  [url operations & {:as params}]
  (let [bulk-json (map json/encode operations)
        bulk-json (-> bulk-json
                      (interleave (repeat "\n"))
                      (string/join))]
    (rest/post-string url
                      :body bulk-json
                      :query-params params)))
(defn bulk
  "Performs a bulk operation"
  [operations & params]
  (when (not-empty operations)
    (apply bulk-with-url (rest/bulk-url) operations params)))

(defn bulk-with-index
  "Performs a bulk operation defaulting to the index specified"
  [index operations & params]
  (apply bulk-with-url (rest/bulk-url index) operations params))

(defn bulk-with-index-and-type
  "Performs a bulk operation defaulting to the index and type specified"
  [index mapping-type operations & params]
  (apply bulk-with-url (rest/bulk-url index mapping-type) operations params))

(def index-operation common-bulk/index-operation)

(def delete-operation common-bulk/delete-operation)

(def bulk-index common-bulk/bulk-index)

(def bulk-delete common-bulk/bulk-delete)
