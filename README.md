# Introduction

This repository contains a Java Micro Benchmark test for the 
[Event Router](https://github.com/danskemarkets/event-router) library which compares
it to Google Guava's EventBus.

To run the benchmark yourself, clone this repository and run

    mvn clean verify

Then run `Main.java`.

# Results

Below are the results when run on a server with Red Hat 4.8, Intel Xeon Gold 6254 processor and OpenJdk 14.0.2.
The Event Router library uses low two-digit micro seconds per dispatch with very little jitter.
It's roughly 6 times faster than Google Guava's EventBus that also has more jitter.

Lower is better:

    Benchmark                                           (cpuConsumption)  Mode  Cnt     Score     Error  Units
    EventBusVsEventRouter10Events.testEventBusOneEvent                 0  avgt   25   399.212 ±  23.728  ns/op
    EventBusVsEventRouter10Events.testEventBusOneEvent                 1  avgt   25   409.911 ±  23.426  ns/op
    EventBusVsEventRouter10Events.testEventBusOneEvent                64  avgt   25   893.436 ±  63.677  ns/op
    EventBusVsEventRouter10Events.testEventBusTenEvents                0  avgt   25  3921.423 ± 201.513  ns/op
    EventBusVsEventRouter10Events.testEventBusTenEvents                1  avgt   25  3860.776 ± 151.005  ns/op
    EventBusVsEventRouter10Events.testEventBusTenEvents               64  avgt   25  6685.643 ± 397.382  ns/op
    EventBusVsEventRouter10Events.testEventBusThreeEvents              0  avgt   25  1240.096 ±  52.018  ns/op
    EventBusVsEventRouter10Events.testEventBusThreeEvents              1  avgt   25  1267.164 ±  58.207  ns/op
    EventBusVsEventRouter10Events.testEventBusThreeEvents             64  avgt   25  2569.645 ± 164.050  ns/op
    EventBusVsEventRouter10Events.testEventRouterOneEvent              0  avgt   25    62.565 ±   3.699  ns/op
    EventBusVsEventRouter10Events.testEventRouterOneEvent              1  avgt   25    68.430 ±   3.360  ns/op
    EventBusVsEventRouter10Events.testEventRouterOneEvent             64  avgt   25   379.454 ±  23.287  ns/op
    EventBusVsEventRouter10Events.testEventRouterTenEvents             0  avgt   25   597.980 ±  33.717  ns/op
    EventBusVsEventRouter10Events.testEventRouterTenEvents             1  avgt   25   612.713 ±  24.754  ns/op
    EventBusVsEventRouter10Events.testEventRouterTenEvents            64  avgt   25  2814.015 ± 130.773  ns/op
    EventBusVsEventRouter10Events.testEventRouterThreeEvents           0  avgt   25   200.930 ±   9.919  ns/op
    EventBusVsEventRouter10Events.testEventRouterThreeEvents           1  avgt   25   212.017 ±  10.066  ns/op
    EventBusVsEventRouter10Events.testEventRouterThreeEvents          64  avgt   25  1114.913 ±  77.195  ns/op
    EventBusVsEventRouter3Events.testEventBusOneEvent                  1  avgt   25   362.365 ±  17.909  ns/op
    EventBusVsEventRouter3Events.testEventBusOneEvent                 64  avgt   25   713.632 ±  38.251  ns/op
    EventBusVsEventRouter3Events.testEventBusThreeEvents               1  avgt   25  1154.882 ±  55.211  ns/op
    EventBusVsEventRouter3Events.testEventBusThreeEvents              64  avgt   25  2114.264 ± 139.619  ns/op
    EventBusVsEventRouter3Events.testEventRouterOneEvent               1  avgt   25    68.563 ±   2.819  ns/op
    EventBusVsEventRouter3Events.testEventRouterOneEvent              64  avgt   25   379.839 ±  19.440  ns/op
    EventBusVsEventRouter3Events.testEventRouterThreeEvents            1  avgt   25   210.791 ±  10.617  ns/op
    EventBusVsEventRouter3Events.testEventRouterThreeEvents           64  avgt   25  1145.427 ±  48.404  ns/op