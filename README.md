# Introduction

This repository contains a Java Micro Benchmark test for the 
[Event Router](https://github.com/danskemarkets/event-router) library which compares
it to Google Guava's EventBus.

To run the benchmark yourself, clone this repository and run

    mvn clean verify

Then run `Main.java`.

## Project Lifecycle

If Danske Bank stops developing this project, it will be stated in this readme.
While this project is actively developed, reported bugs, that are verified, will be fixed.
Feature requests/pull requests will be accepted/rejected at Danske Bank's sole discretion without guarantees for any explanation.

# Results

Below are the results when run on a server with Red Hat 4.8, Intel Xeon Gold 6254 processor and OpenJdk 14.0.2.
The Event Router library uses low two-digit micro seconds per dispatch with very little jitter.
It's roughly 6 times faster than Google Guava's EventBus that also has more jitter.

Lower is better:

    Benchmark                                           (cpuConsumption)  Mode  Cnt     Score    Error  Units
    EventBusVsEventRouter10Events.testEventBusOneEvent                 0  avgt   25   221,564 ± 10,773  ns/op
    EventBusVsEventRouter10Events.testEventBusOneEvent                 1  avgt   25   220,243 ±  4,264  ns/op
    EventBusVsEventRouter10Events.testEventBusOneEvent                64  avgt   25   535,465 ±  5,516  ns/op
    EventBusVsEventRouter10Events.testEventBusTenEvents                0  avgt   25  2322,245 ± 64,294  ns/op
    EventBusVsEventRouter10Events.testEventBusTenEvents                1  avgt   25  2387,852 ± 56,613  ns/op
    EventBusVsEventRouter10Events.testEventBusTenEvents               64  avgt   25  4189,821 ± 51,130  ns/op
    EventBusVsEventRouter10Events.testEventBusThreeEvents              0  avgt   25   744,738 ± 29,301  ns/op
    EventBusVsEventRouter10Events.testEventBusThreeEvents              1  avgt   25   754,439 ± 19,878  ns/op
    EventBusVsEventRouter10Events.testEventBusThreeEvents             64  avgt   25  1562,330 ± 23,382  ns/op
    EventBusVsEventRouter10Events.testEventRouterOneEvent              0  avgt   25    36,068 ±  1,240  ns/op
    EventBusVsEventRouter10Events.testEventRouterOneEvent              1  avgt   25    36,763 ±  0,594  ns/op
    EventBusVsEventRouter10Events.testEventRouterOneEvent             64  avgt   25   247,794 ±  0,902  ns/op
    EventBusVsEventRouter10Events.testEventRouterTenEvents             0  avgt   25   301,472 ± 10,379  ns/op
    EventBusVsEventRouter10Events.testEventRouterTenEvents             1  avgt   25   311,047 ±  5,974  ns/op
    EventBusVsEventRouter10Events.testEventRouterTenEvents            64  avgt   25  1778,731 ±  6,521  ns/op
    EventBusVsEventRouter10Events.testEventRouterThreeEvents           0  avgt   25   112,158 ±  9,690  ns/op
    EventBusVsEventRouter10Events.testEventRouterThreeEvents           1  avgt   25   107,751 ±  2,852  ns/op
    EventBusVsEventRouter10Events.testEventRouterThreeEvents          64  avgt   25   745,729 ±  3,018  ns/op
    EventBusVsEventRouter3Events.testEventBusOneEvent                  1  avgt   25   200,353 ±  8,354  ns/op
    EventBusVsEventRouter3Events.testEventBusOneEvent                 64  avgt   25   414,834 ±  8,188  ns/op
    EventBusVsEventRouter3Events.testEventBusThreeEvents               1  avgt   25   649,827 ± 14,540  ns/op
    EventBusVsEventRouter3Events.testEventBusThreeEvents              64  avgt   25  1328,526 ± 99,277  ns/op
    EventBusVsEventRouter3Events.testEventRouterOneEvent               1  avgt   25    38,115 ±  0,909  ns/op
    EventBusVsEventRouter3Events.testEventRouterOneEvent              64  avgt   25   246,857 ±  2,745  ns/op
    EventBusVsEventRouter3Events.testEventRouterThreeEvents            1  avgt   25   110,811 ±  3,528  ns/op
    EventBusVsEventRouter3Events.testEventRouterThreeEvents           64  avgt   25   741,038 ±  3,145  ns/op