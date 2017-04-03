(ns echoserver.core
  (:require [aleph.tcp :as tcp]
            [clojure.string :as string]
            [clojure.tools.cli :refer [parse-opts]]
            [manifold.stream :as s])
  (:gen-class))

(def cli-options
  [["-p" "--port PORT" "Port to listen on"
    :default 5000
    :parse-fn #(Integer/parseInt %)]
   ["-h" "--help" "Show help"]])

(defn usage
  "show usage"
  [options-summary]
  (->>
    ["Echo server"
     ""
     "usage: echoserver [options]"
     ""
     "options:"
     options-summary
     ""]
    (string/join \newline)))

(defn error-msg
  "return an error"
  [errors]
  (str "error:\n\n"
       (string/join \newline errors)))

(defn validate-args
  "validate the command line"
  [args]
  (let [{:keys [options arguments errors summary]} 
        (parse-opts args cli-options)]
    (cond
      (:help options)
      {:exit-message (usage summary) :ok? true}
      errors
      {:exit-message (error-msg errors)}
      (> (count arguments) 0)
      {:exit-message (usage summary)}
      :else
      {:server options})))

(defn exit [status msg]
  (println msg)
  (System/exit status))      

(defn echo-handler
  "echo handler"
  [s info]
  (s/connect s s))

(defn -main
  "echo server."
  [& args]
  (let [{:keys [server exit-message ok?]}
        (validate-args args)]
    (if exit-message
      (exit (if ok? 0 1) exit-message)
      (let [s (tcp/start-server echo-handler server)]
        (loop []
          (print "$ ")
          (flush)
          (if-not (= "exit" (read-line))
            (recur)))
        (.close s)))))
