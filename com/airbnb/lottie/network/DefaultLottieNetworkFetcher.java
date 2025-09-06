package com.airbnb.lottie.network;

import java.net.HttpURLConnection;
import java.net.URL;

public class DefaultLottieNetworkFetcher implements LottieNetworkFetcher {
    @Override  // com.airbnb.lottie.network.LottieNetworkFetcher
    public LottieFetchResult fetchSync(String s) {
        HttpURLConnection httpURLConnection0 = (HttpURLConnection)new URL(s).openConnection();
        httpURLConnection0.setRequestMethod("GET");
        httpURLConnection0.connect();
        return new DefaultLottieFetchResult(httpURLConnection0);
    }
}

