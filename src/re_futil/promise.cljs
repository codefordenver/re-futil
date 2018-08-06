(ns re-futil.promise
  (:require [re-frame.core :as rf]))


(defn dispatch-value
  "Helper function to package the given value into an event vector that
  looks like [:the-event-id value :arg1 :arg2] (where more-args here is
  [:arg1 arg2]). Then the vector is dispatched.
  "
  [value event-id more-args]
  (-> [event-id value]
    (into more-args)                      ; Appends each arg onto event vector.
    rf/dispatch))


(defn then-dispatch
  "May be called as (then-dispatch a-promise :an-event-id ...) or as
  (then-dispatch a-promise [:an-event-id ...]). Given a js/Promise or
  firebase.Promise object, returns it or, if there is a second (non-falsey)
  argument, returns a new Promise that will dispatch a re-frame event when the
  given Promise has completed. That is, it calls something like
  (dispatch [:an-event-id rslt-map ...]), for example.

  Here, :an-event-id is the given value of event-id. The rslt-map will have
  value {:ok-value v} or {:error-reason r}. Finally, the '...' in this example
  represents any extra data values you may provide to fill out the dispatched
  event vector, i.e, starting with the third element of the vector. The value v
  in rslt-map {:ok-value v} will be the result from the given promise when it
  is fulfilled. If instead the promise rejected, then the dispatched event will
  have rslt-map {:error-reason r}, where r is an instance of
  firebase.FirebaseError, giving the reason for rejection provided by the
  promise.

  See https://firebase.google.com/docs/reference/js/firebase.Promise
  and https://firebase.google.com/docs/reference/js/firebase.FirebaseError
  "
  [promise & [event-id :as id-and-args]]
  (let [[id & args] (if (sequential? event-id)
                      event-id
                      id-and-args)]
    (if id
      (let [callback (fn [kw] #(dispatch-value {kw %} id args))]
        (.then promise (callback :ok-value) (callback :error-reason)))
      promise)))

