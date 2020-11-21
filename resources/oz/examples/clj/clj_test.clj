(ns oz.examples.clj.clj-test)

[:h1 "yo dawgs"]

[:markdown "what it _be_ like?"]

[:pprint {:some :wild
          :data (range 4)}]

[:vega-lite {:data {:values [{:a 1 :b 2} {:a 3 :b 1} {:a 8 :b 3}]}
             :mark :point
             :encoding {:x {:field :a :type :quantitative}
                        :y {:field :b :type :quantitative}}}]

 
