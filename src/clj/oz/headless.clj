;;ns for rendering plots direct to file.
;;bulk plotting etc.
(ns oz.headless
  (:require [oz.core :as oz]
            [batik.rasterize :as b]
            [applied-science.darkstar :as darkstar]))



#_
(->> (slurp "vega-example.json")
     darkstar/vega-spec->svg
     (spit "vg-example.svg"))

;;simple demo....
#_
(->>  "vega-example.json"
      oz/load
      darkstar/vega-spec->svg
      (spit "vg-example.svg"))

;; write an SVG from a Vega-lite spec
#_
(->> (slurp "vega-lite-example.json")
     darkstar/vega-lite-spec->svg
     (spit "vl-example.svg"))

