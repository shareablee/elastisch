(defproject com.shareablee/elastisch "1.4.0-native-bulk"
  :url "http://clojureelasticsearch.info"
  :description "Minimalistic fully featured well documented Clojure ElasticSearch client"
  :license {:name "Eclipse Public License"}
  :dependencies [[org.clojure/clojure   "1.5.1"]
                 [cheshire              "5.3.1"]
                 [clj-http              "0.7.8" :exclusions [org.clojure/clojure]]
                 [clojurewerkz/support  "0.20.0"]
                 ;; used by the native client
                 ;[org.elasticsearch/elasticsearch "0.90.8"]
                 ;; TODO
                 [org.elasticsearch/elasticsearch "0.90.13"]
                 ]
  :min-lein-version "2.0.0"
  :profiles     {:dev {:resource-paths ["test/resources"]
                       :dependencies [[clj-time            "0.4.4" :exclusions [org.clojure/clojure]]]
                       :plugins [[codox "0.6.1"]]}
                 :1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
                 :1.6 {:dependencies [[org.clojure/clojure "1.6.0-master-SNAPSHOT"]]}
                 :master {:dependencies [[org.clojure/clojure "1.6.0-master-SNAPSHOT"]]}
                 :es10   {:dependencies [[org.elasticsearch/elasticsearch "1.0.0.Beta2"]]}}
  :aliases      {"all" ["with-profile" "dev:dev,1.4:dev,1.6"]}
  #_:repositories #_{"sonatype"         {:url "http://oss.sonatype.org/content/repositories/releases"
                                     :snapshots false
                                     :releases {:checksum :fail :update :always}}
                 "sonatype-snapshots" {:url "http://oss.sonatype.org/content/repositories/snapshots"
                                       :snapshots true
                                       :releases {:checksum :fail :update :always}}}
  :global-vars {*warn-on-reflection* true}
  :test-selectors {:focus       :focus
                   :indexing    :indexing
                   :query       :query
                   :facets      :facets
                   :percolation :percolation
                   :native      :native
                   :all         (constantly true)
                   :default     (constantly true)
                   :ci          (fn [m] (not (:native m)))}
  :mailing-list {:name "clojure-elasticsearch"
                 :archive "https://groups.google.com/group/clojure-elasticsearch"
                 :post "clojure-elasticsearch@googlegroups.com"}
  :plugins [[codox "0.6.4"]
            [s3-wagon-private "1.1.2"]]
  :codox {:sources ["src"]
          :output-dir "doc/api"}

  :repositories
  [["releases"
    {:url "s3p://shareablee-jar-repo/releases"
     :username :env/shareablee_aws_access_key
     :passphrase :env/shareablee_aws_secret_access_key
     :sign-releases false
     :snapshots false}]
   ["snapshots"
    {:url "s3p://shareablee-jar-repo/snapshots"
     :username :env/shareablee_aws_access_key
     :passphrase :env/shareablee_aws_secret_access_key}]])
