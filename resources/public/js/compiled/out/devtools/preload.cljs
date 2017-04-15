(ns devtools.preload
  (:require-macros [devtools.preload :refer [gen-config]])
  (:require [devtools.prefs :as prefs]
            [devtools.core :as core]))

; this namespace is intended to be included in cljs compiler :preloads
; overrides for default configuration can be specified in :external-config > :devtools/config
; see https://github.com/binaryage/cljs-devtools/blob/master/docs/installation.md#install-it-via-preloads
;     https://github.com/binaryage/cljs-devtools/blob/master/docs/configuration.md#configuration-via-preloads

(def config (gen-config))

(prefs/merge-prefs! config)

(if-not (prefs/pref :suppress-preload-install)
  (core/install!))
