package com.bumptech.glide.integration.okhttp3;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.iloen.melon.utils.image.ImageCacheManager;
import com.iloen.melon.utils.log.LogU;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Call.Factory;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MelonOkHttpStreamFetcher implements DataFetcher {
    private static final String TAG = "MelonOkHttpStreamFetcher";
    private volatile Call call;
    private final Factory client;
    private ResponseBody responseBody;
    private InputStream stream;
    private final GlideUrl url;

    public MelonOkHttpStreamFetcher(Factory call$Factory0, GlideUrl glideUrl0) {
        this.client = call$Factory0;
        this.url = glideUrl0;
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        Call call0 = this.call;
        if(call0 != null) {
            call0.cancel();
        }
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        try {
            InputStream inputStream0 = this.stream;
            if(inputStream0 != null) {
                inputStream0.close();
            }
        }
        catch(IOException unused_ex) {
        }
        ResponseBody responseBody0 = this.responseBody;
        if(responseBody0 != null) {
            responseBody0.close();
        }
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return InputStream.class;
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public static Request getImageDownloadRequest(String s) {
        Builder request$Builder0 = new Builder().url(s);
        request$Builder0.header("User-Agent", "");
        request$Builder0.addHeader("Referer", "http://app.melon.com/");
        request$Builder0.cacheControl(new okhttp3.CacheControl.Builder().maxAge(0, TimeUnit.MILLISECONDS).build());
        return request$Builder0.build();
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
        Request request0;
        URI uRI0;
        Cache cache0 = ImageCacheManager.INSTANCE.getGlideDiskCache();
        OkHttpClient okHttpClient0 = (OkHttpClient)this.client;
        if(cache0 != okHttpClient0.cache()) {
            okHttpClient0 = okHttpClient0.newBuilder().cache(cache0).build();
        }
        String s = this.url.toStringUrl();
        try {
            uRI0 = URI.create(s);
        }
        catch(IllegalArgumentException unused_ex) {
            uRI0 = URI.create(s.replaceAll("\\>", "%3E").replaceAll("\\+", "%2B"));
        }
        try {
            request0 = MelonOkHttpStreamFetcher.getImageDownloadRequest(uRI0.toURL().toString());
        }
        catch(MalformedURLException malformedURLException0) {
            LogU.w("MelonOkHttpStreamFetcher", "loadData() " + malformedURLException0);
            request0 = null;
        }
        this.call = okHttpClient0.newCall(request0);
        this.call.enqueue(new Callback() {
            @Override  // okhttp3.Callback
            public void onFailure(Call call0, IOException iOException0) {
                LogU.w("MelonOkHttpStreamFetcher", "onFailure() " + iOException0);
                dataFetcher$DataCallback0.onLoadFailed(iOException0);
            }

            @Override  // okhttp3.Callback
            public void onResponse(Call call0, Response response0) {
                MelonOkHttpStreamFetcher.this.responseBody = response0.body();
                if(response0.isSuccessful()) {
                    InputStream inputStream0 = MelonOkHttpStreamFetcher.this.responseBody.byteStream();
                    MelonOkHttpStreamFetcher.this.stream = inputStream0;
                    dataFetcher$DataCallback0.onDataReady(MelonOkHttpStreamFetcher.this.stream);
                    return;
                }
                IOException iOException0 = new IOException("Request failed with code: " + response0.code());
                dataFetcher$DataCallback0.onLoadFailed(iOException0);
            }
        });
    }
}

