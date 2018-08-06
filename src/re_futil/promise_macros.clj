(ns re-futil.promise-macros
  (:require [clojure.string :as str]))


(defn- threading-symbol
  [prefix sym]
  (-> prefix
    (str sym)
    (str/replace #"-+" "-")
    symbol))


(defmacro ^:private define-macros-based-on
  [& symbols]
  `(do
     ~@(for [a-> symbols]
         (let [fn-a-> (threading-symbol "fn-" a->)
               qual-fn-a-> (symbol (str (ns-name *ns*) "/" fn-a->))]
           `(do

              (defmacro ~fn-a->
                [& forms#]
                `(fn [~'x#] (~'~a-> ~'x# ~@forms#)))

              (defmacro ~(threading-symbol "then-" a->)
                [prom# & forms#]
                `(.then ~prom# (~'~qual-fn-a-> ~@forms#))))))))


(define-macros-based-on -> ->> as-> some-> some->> cond-> cond->>)

;; TODO  Define catch- macros in addition to fn- and then-

