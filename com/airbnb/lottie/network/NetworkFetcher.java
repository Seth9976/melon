package com.airbnb.lottie.network;

import android.content.Context;
import android.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

public class NetworkFetcher {
    private final LottieNetworkFetcher fetcher;
    private final NetworkCache networkCache;

    public NetworkFetcher(NetworkCache networkCache0, LottieNetworkFetcher lottieNetworkFetcher0) {
        this.networkCache = networkCache0;
        this.fetcher = lottieNetworkFetcher0;
    }

    private LottieComposition fetchFromCache(Context context0, String s, String s1) {
        LottieResult lottieResult0;
        if(s1 != null) {
            NetworkCache networkCache0 = this.networkCache;
            if(networkCache0 != null) {
                Pair pair0 = networkCache0.fetch(s);
                if(pair0 == null) {
                    return null;
                }
                FileExtension fileExtension0 = (FileExtension)pair0.first;
                InputStream inputStream0 = (InputStream)pair0.second;
                switch(com.airbnb.lottie.network.NetworkFetcher.1.$SwitchMap$com$airbnb$lottie$network$FileExtension[fileExtension0.ordinal()]) {
                    case 1: {
                        lottieResult0 = LottieCompositionFactory.fromZipStreamSync(context0, new ZipInputStream(inputStream0), s1);
                        return lottieResult0.getValue() == null ? null : ((LottieComposition)lottieResult0.getValue());
                    }
                    case 2: {
                        try {
                            lottieResult0 = LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(inputStream0), s1);
                            return lottieResult0.getValue() == null ? null : ((LottieComposition)lottieResult0.getValue());
                        }
                        catch(IOException iOException0) {
                            lottieResult0 = new LottieResult(iOException0);
                            return lottieResult0.getValue() == null ? null : ((LottieComposition)lottieResult0.getValue());
                        }
                    }
                    default: {
                        lottieResult0 = LottieCompositionFactory.fromJsonInputStreamSync(inputStream0, s1);
                        return lottieResult0.getValue() == null ? null : ((LottieComposition)lottieResult0.getValue());
                    }
                }
            }
        }
        return null;
    }

    private LottieResult fetchFromNetwork(Context context0, String s, String s1) {
        LottieResult lottieResult1;
        LottieResult lottieResult0;
        Logger.debug(("Fetching " + s));
        LottieFetchResult lottieFetchResult0 = null;
        try {
            try {
                lottieFetchResult0 = this.fetcher.fetchSync(s);
                if(lottieFetchResult0.isSuccessful()) {
                    lottieResult0 = this.fromInputStream(context0, s, lottieFetchResult0.bodyByteStream(), lottieFetchResult0.contentType(), s1);
                    Logger.debug(("Completed fetch from network. Success: " + (lottieResult0.getValue() != null)));
                }
                else {
                    lottieResult0 = new LottieResult(new IllegalArgumentException(lottieFetchResult0.error()));
                }
                goto label_24;
            }
            catch(Exception exception0) {
            }
            lottieResult1 = new LottieResult(exception0);
            if(lottieFetchResult0 != null) {
                goto label_12;
            }
            return lottieResult1;
        }
        catch(Throwable throwable0) {
            goto label_18;
        }
        try {
        label_12:
            lottieFetchResult0.close();
            return lottieResult1;
        }
        catch(IOException iOException0) {
            Logger.warning("LottieFetchResult close failed ", iOException0);
        }
        return lottieResult1;
    label_18:
        if(lottieFetchResult0 != null) {
            try {
                lottieFetchResult0.close();
            }
            catch(IOException iOException1) {
                Logger.warning("LottieFetchResult close failed ", iOException1);
            }
        }
        throw throwable0;
        try {
        label_24:
            lottieFetchResult0.close();
        }
        catch(IOException iOException2) {
            Logger.warning("LottieFetchResult close failed ", iOException2);
        }
        return lottieResult0;
    }

    public LottieResult fetchSync(Context context0, String s, String s1) {
        LottieComposition lottieComposition0 = this.fetchFromCache(context0, s, s1);
        if(lottieComposition0 != null) {
            return new LottieResult(lottieComposition0);
        }
        Logger.debug(("Animation for " + s + " not found in cache. Fetching from network."));
        return this.fetchFromNetwork(context0, s, s1);
    }

    private LottieResult fromGzipStream(String s, InputStream inputStream0, String s1) {
        if(s1 != null) {
            return this.networkCache == null ? LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(inputStream0), null) : LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(s, inputStream0, FileExtension.GZIP))), s);
        }
        return LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(inputStream0), null);
    }

    private LottieResult fromInputStream(Context context0, String s, InputStream inputStream0, String s1, String s2) {
        LottieResult lottieResult0;
        FileExtension fileExtension0;
        if(s1 == null) {
            s1 = "application/json";
        }
        if(s1.contains("application/zip") || s1.contains("application/x-zip") || s1.contains("application/x-zip-compressed") || s.split("\\?")[0].endsWith(".lottie")) {
            Logger.debug("Handling zip response.");
            lottieResult0 = this.fromZipStream(context0, s, inputStream0, s2);
            fileExtension0 = FileExtension.ZIP;
        }
        else if(!s1.contains("application/gzip") && !s1.contains("application/x-gzip") && !s.split("\\?")[0].endsWith(".tgs")) {
            Logger.debug("Received json response.");
            fileExtension0 = FileExtension.JSON;
            lottieResult0 = this.fromJsonStream(s, inputStream0, s2);
        }
        else {
            Logger.debug("Handling gzip response.");
            fileExtension0 = FileExtension.GZIP;
            lottieResult0 = this.fromGzipStream(s, inputStream0, s2);
        }
        if(s2 != null && lottieResult0.getValue() != null) {
            NetworkCache networkCache0 = this.networkCache;
            if(networkCache0 != null) {
                networkCache0.renameTempFile(s, fileExtension0);
            }
        }
        return lottieResult0;
    }

    private LottieResult fromJsonStream(String s, InputStream inputStream0, String s1) {
        if(s1 != null) {
            return this.networkCache == null ? LottieCompositionFactory.fromJsonInputStreamSync(inputStream0, null) : LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(this.networkCache.writeTempCacheFile(s, inputStream0, FileExtension.JSON).getAbsolutePath()), s);
        }
        return LottieCompositionFactory.fromJsonInputStreamSync(inputStream0, null);
    }

    private LottieResult fromZipStream(Context context0, String s, InputStream inputStream0, String s1) {
        if(s1 != null) {
            return this.networkCache == null ? LottieCompositionFactory.fromZipStreamSync(context0, new ZipInputStream(inputStream0), null) : LottieCompositionFactory.fromZipStreamSync(context0, new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(s, inputStream0, FileExtension.ZIP))), s);
        }
        return LottieCompositionFactory.fromZipStreamSync(context0, new ZipInputStream(inputStream0), null);
    }
}

