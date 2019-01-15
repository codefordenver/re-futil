
# re-futil

This is a collection of utilities serving to extend the [re-frame framework](https://github.com/Day8/re-frame) for building single-page web applications in the [ClojureScript](https://clojurescript.org) language. There are also utilities to make working with some aspects of JavaScript easier. Currently, the following capabilities are offered:

- **`re-futil.promise`** and **`re-futil.promise-macros`**<br/>
  Assistance for employing [JavaScript Promises](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Using_promises) in a Clojure-idiomatic way.

- **`re-futil.getter-setter-pipeline`**<br/>
  Makes it easy to construct re-frame handlers in the most common use cases, while facilitating a [separation of concerns](https://en.wikipedia.org/wiki/Separation_of_concerns) for your definitions.

- Coming soon! **`re-futil.firebase`**<br/>
  Utilities for integrating the [Firebase](https://firebase.google.com) [backend-as-a-service](https://en.wikipedia.org/wiki/Mobile_backend_as_a_service) platform into your re-frame app. Services include [Realtime Database](https://firebase.google.com/products/database) and [Firebase Firestore](https://firebase.google.com/products/firestore/).

## Installation

At this early stage, re-futil is available only from [its GitHub repo](https://github.com/codefordenver/re-futil), not [Clojars](https://clojars.org). So the easiest way to add it as a dependency in your project is via a [`deps.edn`](https://clojure.org/reference/deps_and_cli#_deps_edn) file in the root of your project directory. If you're using [Leiningen](https://leiningen.org), consider adding the plugin [lein-tools-deps](https://github.com/RickMoynihan/lein-tools-deps#usage). Then you can define any or all your dependencies in the deps.edn file as described below.

The `deps.edn` file in your project should look something like this:

    {:paths
     [
      ; ...
     ]

     :deps
     {
      ; ...

      ; Have tested re-futil with these versions:
      ;
      org.clojure/clojure {:mvn/version "1.10.0"}
      org.clojure/clojurescript {:mvn/version "1.10.439" :scope "provided"}
      re-frame {:mvn/version "0.10.6"}
      reagent {:mvn/version "0.7.0"}

      ; ...
      
      ; Here's where we define our dependency on re-futil:
      ;
      codefordenver/re-futil
      {:git/url "https://github.com/codefordenver/re-futil.git"
       :sha     "d46e170c4ea3b6b984ac24e1d0483fda4af61a5d"}
    
      ; ...
     }
     ; ...
    }

You can obtain the `:sha` value from the [codefordenver/re-futil Github page](https://github.com/codefordenver/re-futil). In the first item of the [commits](https://github.com/codefordenver/re-futil/commits/master) list (or in the item for desired commit), just click the _copy-to-clipboard_ icon,
<span><svg viewBox="0 0 14 16" width="14" height="16"><path fill="blue" fill-rule="evenodd" d="M2 13h4v1H2v-1zm5-6H2v1h5V7zm2 3V8l-3 3 3 3v-2h5v-2H9zM4.5 9H2v1h2.5V9zM2 12h2.5v-1H2v1zm9 1h1v2c-.02.28-.11.52-.3.7-.19.18-.42.28-.7.3H1c-.55 0-1-.45-1-1V4c0-.55.45-1 1-1h3c0-1.11.89-2 2-2 1.11 0 2 .89 2 2h3c.55 0 1 .45 1 1v5h-1V6H1v9h10v-2zM2 5h8c0-.55-.45-1-1-1H8c-.55 0-1-.45-1-1s-.45-1-1-1-1 .45-1 1-.45 1-1 1H3c-.55 0-1 .45-1 1z"></path></svg></span>
. Then just paste the SHA into your `deps.edn` file.