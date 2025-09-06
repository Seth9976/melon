package com.iloen.melon.custom;

import android.content.Context;
import android.net.ConnectivityManager;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.ui.playermusic.PlayerViewCalculator;
import java.io.File;
import kotlin.jvm.internal.q;
import we.a;

public final class h0 implements a {
    public final int a;
    public final Context b;

    public h0(Context context0, int v) {
        this.a = v;
        this.b = context0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        Context context0 = this.b;
        switch(this.a) {
            case 0: {
                return ScreenUtils.dipToPixel(context0, 8.0f);
            }
            case 1: {
                Object object0 = context0.getSystemService("connectivity");
                q.e(object0, "null cannot be cast to non-null type android.net.ConnectivityManager");
                return (ConnectivityManager)object0;
            }
            case 2: {
                File file0 = context0.getCacheDir();
                if(file0 == null) {
                    throw new IllegalStateException("cacheDir == null");
                }
                file0.mkdirs();
                return file0;
            }
            case 3: {
                File file1 = context0.getCacheDir();
                if(file1 == null) {
                    throw new IllegalStateException("cacheDir == null");
                }
                file1.mkdirs();
                return file1;
            }
            default: {
                return new PlayerViewCalculator(context0);
            }
        }
    }
}

