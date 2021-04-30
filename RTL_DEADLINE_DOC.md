We added a victim cache module located in generators/boom/src/main/scala/ifu/victimCache.scala
We modified icache.scala to integrate victim cache with it.

We ran benchmark tests to verify both the correctness and the performance.

Benchmarks/tests that we ran include:
- median
- multiply
- qsort
- towers
- vvadd
- dhrystone (mainc benchmark)
- mt-matmul
- mm
- sqmv
- mt-vvadd

All these tests ran successfully with our modified hardware.

Here is the performance comparison between original and modified hardware in dhrystone benchmark:

Configuration #1 (original): 1kB 2-way L1 instruction cache
                             8kB 4-way L2 instruction cache
                             1 issue core (referred to as 1-wide)
                             No victim cache
                          
        Dhrystones per second: 1924
     Relative to the original: 1

Configuration #2 (modified): 1kB 2-way L1 instruction cache
                             8kB 4-way L2 instruction cache
                             1 issue core (referred to as 1-wide)
                             2-way victim cache
                          
        Dhrystones per second: 1955
     Relative to the original: 1.016

Configuration #3 (modified): 1kB 2-way L1 instruction cache
                             8kB 4-way L2 instruction cache
                             1 issue core (referred to as 1-wide)
                             4-way victim cache
                          
        Dhrystones per second: 2033
     Relative to the original: 1.057

Configuration #4 (modified): 1kB 2-way L1 instruction cache
                             8kB 4-way L2 instruction cache
                             1 issue core (referred to as 1-wide)
                             8-way victim cache
                          
        Dhrystones per second: 2030
     Relative to the original: 1.055

Configuration #5 (original): 1kB 2-way L1 instruction cache
                             8kB 4-way L2 instruction cache
                             2 issue core (referred to as 2-wide)
                             No victim cache
                          
        Dhrystones per second: 2536
     Relative to the original: 1

Configuration #6 (original): 1kB 2-way L1 instruction cache
                             8kB 4-way L2 instruction cache
                             2 issue core (referred to as 2-wide)
                             4-way victim cache
                          
        Dhrystones per second: 2840
     Relative to the original: 1.12

Configuration #7 (original): 1kB 2-way L1 instruction cache
                             8kB 4-way L2 instruction cache
                             2 issue core (referred to as 2-wide)
                             8-way victim cache
                          
        Dhrystones per second: 2853
     Relative to the original: 1.125






To run the tests:

cd vcs/sims

# To run configuration 1
make CONFIG=MinimalSmallBoom1kB2Wi8kB4Wd32kBL20WConfig
make run-bmark-tests CONFIG=MinimalSmallBoom1kB2Wi8kB4Wd32kBL20WConfig

# To run configuration 3
make CONFIG=MinimalSmallBoom1kB2Wi8kB4Wd32kBL24WConfig
make run-bmark-tests CONFIG=MinimalSmallBoom1kB2Wi8kB4Wd32kBL24WConfig

# To run configuration 5
make CONFIG=MinimalMediumBoom1kB2Wi8kB4Wd32kBL20WConfig
make run-bmark-tests CONFIG=MinimalMediumBoom1kB2Wi8kB4Wd32kBL20WConfig

# To run configuration 6
make CONFIG=MinimalMediumBoom1kB2Wi8kB4Wd32kBL24WConfig
make run-bmark-tests CONFIG=MinimalMediumBoom1kB2Wi8kB4Wd32kBL24WConfig




Summery of the key design metrics:

- Our goal was to see a 5-10% performance improvement in standard benchmarks such as dhrystones.
- For a single issue BOOM core with 1kB L1 instruction cache we obsereved about 5.5% improvement 
  in performance by adding a 4-way victim cache
- For a dual issue BOOM core we with 1kB L1 instruction cache observed about 12% improvement 
  in performance by adding a 4-way victim cache


     
     
     
     
