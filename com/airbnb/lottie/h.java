package com.airbnb.lottie;

import com.airbnb.lottie.utils.Utils;
import java.util.zip.ZipInputStream;

public final class h implements Runnable {
    public final int a;
    public final ZipInputStream b;

    public h(ZipInputStream zipInputStream0, int v) {
        this.a = v;
        this.b = zipInputStream0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            Utils.closeQuietly(this.b);
            return;
        }
        Utils.closeQuietly(this.b);
    }
}

