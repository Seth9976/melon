package com.airbnb.lottie;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.InputStream;
import okio.Source;

public final class e implements Runnable {
    public final int a;
    public final Object b;

    public e(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                Utils.closeQuietly(((JsonReader)this.b));
                return;
            }
            case 1: {
                Utils.closeQuietly(((Source)this.b));
                return;
            }
            case 2: {
                Utils.closeQuietly(((InputStream)this.b));
                return;
            }
            default: {
                ((LottieTask)this.b).notifyListenersInternal();
            }
        }
    }
}

