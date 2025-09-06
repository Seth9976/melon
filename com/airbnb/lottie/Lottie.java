package com.airbnb.lottie;

public class Lottie {
    public static void initialize(LottieConfig lottieConfig0) {
        L.setFetcher(lottieConfig0.networkFetcher);
        L.setCacheProvider(lottieConfig0.cacheProvider);
        L.setTraceEnabled(lottieConfig0.enableSystraceMarkers);
        L.setNetworkCacheEnabled(lottieConfig0.enableNetworkCache);
        L.setDisablePathInterpolatorCache(lottieConfig0.disablePathInterpolatorCache);
        L.setDefaultAsyncUpdates(lottieConfig0.defaultAsyncUpdates);
        L.setReducedMotionOption(lottieConfig0.reducedMotionOption);
    }
}

