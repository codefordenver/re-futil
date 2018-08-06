(ns re-futil.js-help)


(defn apply-constructor [ctor & args]
  "Just like cljs.core/apply, but its first argument must be a JS constructor.
  Evaluates the constructor with argument list formed by prepending intervening
  arguments to the final argument, and returns the resulting instance.
  "
  (let [js-args (apply array (apply apply list args))
        inst (js/Object.create (.-prototype ctor))]
    (.apply ctor inst js-args)
    inst))

