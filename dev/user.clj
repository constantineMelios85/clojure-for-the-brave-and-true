(ns user
  (:require [clojure.tools.namespace.repl :refer [refresh]]
            [hawk.core :as hawk]))

(defn start-watcher []
  (hawk/watch! [{:paths ["src"]
                 :handler (fn [_ _]
                            (try
                              (refresh)
                              (catch Exception e
                                ;; Suppress output
                                )))}]))

;; Start the watcher when the namespace is loaded
(start-watcher)