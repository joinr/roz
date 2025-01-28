;;ns for rendering plots direct to file.
;;bulk plotting etc.
(ns oz.headless
  (:require [oz.core :as oz]
            [cheshire.core :as json]
            [batik.rasterize :as b]
            [applied-science.darkstar :as darkstar]))

(def line-plot
  {:data
   {:values
    [{:time 0, :item "monkey", :quantity 1.0}
     {:time 1, :item "monkey", :quantity 6.192962712629476}
     {:time 2, :item "monkey", :quantity 12.30037210271847}
     {:time 3, :item "monkey", :quantity 15.097596309015797}
     {:time 4, :item "monkey", :quantity 12.71068609258575}
     {:time 5, :item "monkey", :quantity 19.194870523363548}
     {:time 6, :item "monkey", :quantity 20.580936309501134}
     {:time 7, :item "monkey", :quantity 23.888381054913122}
     {:time 8, :item "monkey", :quantity 25.13058987556147}
     {:time 9, :item "monkey", :quantity 27.317280693371046}
     {:time 10, :item "monkey", :quantity 30.45580618665162}
     {:time 11, :item "monkey", :quantity 31.55190884598056}
     {:time 12, :item "monkey", :quantity 33.610188015018984}
     {:time 13, :item "monkey", :quantity 34.63440373999379}
     {:time 14, :item "monkey", :quantity 39.62768266080517}
     {:time 15, :item "monkey", :quantity 39.59266228400805}
     {:time 16, :item "monkey", :quantity 40.53159496449108}
     {:time 17, :item "monkey", :quantity 44.44642466614132}
     {:time 18, :item "monkey", :quantity 42.338844810888254}
     {:time 19, :item "monkey", :quantity 47.21034266761982}
     {:time 0, :item "slipper", :quantity 2.0}
     {:time 1, :item "slipper", :quantity 8.743276393803367}
     {:time 2, :item "slipper", :quantity 10.258523872989459}
     {:time 3, :item "slipper", :quantity 16.422875300666448}
     {:time 4, :item "slipper", :quantity 20.378925219250924}
     {:time 5, :item "slipper", :quantity 17.189151347155786}
     {:time 6, :item "slipper", :quantity 20.888381054913122}
     {:time 7, :item "slipper", :quantity 26.498670948012276}
     {:time 8, :item "slipper", :quantity 29.03516289842348}
     {:time 9, :item "slipper", :quantity 27.508850275948053}
     {:time 10, :item "slipper", :quantity 31.928050775697603}
     {:time 11, :item "slipper", :quantity 36.299260572778856}
     {:time 12, :item "slipper", :quantity 38.62768266080517}
     {:time 13, :item "slipper", :quantity 39.9175705807045}
     {:time 14, :item "slipper", :quantity 43.17246133441246}
     {:time 15, :item "slipper", :quantity 46.39533859324643}
     {:time 16, :item "slipper", :quantity 47.58875032686557}
     {:time 17, :item "slipper", :quantity 48.75489563854074}
     {:time 18, :item "slipper", :quantity 48.89569020671064}
     {:time 19, :item "slipper", :quantity 51.012816499808885}
     {:time 0, :item "broom", :quantity 0.0}
     {:time 1, :item "broom", :quantity 5.623898318388478}
     {:time 2, :item "broom", :quantity 8.309573444801934}
     {:time 3, :item "broom", :quantity 10.727161387290321}
     {:time 4, :item "broom", :quantity 10.98560543306118}
     {:time 5, :item "broom", :quantity 14.132639022018838}
     {:time 6, :item "broom", :quantity 16.194870523363548}
     {:time 7, :item "broom", :quantity 18.189151347155786}
     {:time 8, :item "broom", :quantity 23.127049995800743}
     {:time 9, :item "broom", :quantity 22.016965485301043}
     {:time 10, :item "broom", :quantity 22.86525259636632}
     {:time 11, :item "broom", :quantity 26.676874454922782}
     {:time 12, :item "broom", :quantity 27.45580618665162}
     {:time 13, :item "broom", :quantity 32.20529752834578}
     {:time 14, :item "broom", :quantity 31.928050775697603}
     {:time 15, :item "broom", :quantity 31.626345475706252}
     {:time 16, :item "broom", :quantity 33.30212829607493}
     {:time 17, :item "broom", :quantity 35.95707936800063}
     {:time 18, :item "broom", :quantity 37.59266228400805}
     {:time 19, :item "broom", :quantity 38.210162462449645}]},
   :encoding
   {:x {:field "time", :type "quantitative"},
    :y {:field "quantity", :type "quantitative"},
    :color {:field "item", :type "nominal"}},
   :mark "line"})

(defn render [from to]
  (let [spec (if (map? from) (json/encode from) (oz/load from))]
    (->  spec
         str
         darkstar/vega-lite-spec->svg
         b/parse-svg-string
         (b/render-svg-document to))))

;; write an SVG from a Vega-lite spec
#_
(->> (slurp "vega-lite-example.json")
     darkstar/vega-lite-spec->svg
     (spit "vl-example.svg"))


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
