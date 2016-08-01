(ns chromatophore.markdown
  (:require [markdown.core #?@(:cljs [:refer [md->html]]
                               :clj  [:refer [md-to-html-string]])]))

;; TODO: style first-child only
(def markdown-css-class
  "A CSS class for HTML automatically generated by markdown"
  [:.markdown [:> [:p {:display "inline"}]]])

(defn
  ^{:style markdown-css-class}
  md
  "A component for rendering markdown"
  ([text] (md {} text))
  ([props text]
   [:span.markdown
    #?(:cljs (assoc-in props [:dangerouslySetInnerHTML :__html] (md->html text))
       :clj  props)
    #?(:clj (md-to-html-string test))]))
