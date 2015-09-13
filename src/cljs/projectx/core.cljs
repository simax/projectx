(ns projectx.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [projectx.handlers]
              [projectx.subs]
              [projectx.routes :as routes]
              [projectx.views :as views]))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] 
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
