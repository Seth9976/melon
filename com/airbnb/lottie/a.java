package com.airbnb.lottie;

import android.content.Context;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import java.io.File;

public final class a implements LottieNetworkCacheProvider {
    public final Context a;

    public a(Context context0) {
        this.a = context0;
    }

    @Override  // com.airbnb.lottie.network.LottieNetworkCacheProvider
    public final File getCacheDir() {
        return L.lambda$networkCache$0(this.a);
    }
}

