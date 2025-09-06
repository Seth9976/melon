package com.airbnb.lottie;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.InputStream;
import java.util.concurrent.Callable;
import okio.Source;
import org.json.JSONObject;

public final class b implements Callable {
    public final int a;
    public final String b;
    public final Object c;

    public b(int v, Object object0, String s) {
        this.a = v;
        this.c = object0;
        this.b = s;
        super();
    }

    public b(String s, String s1) {
        this.a = 2;
        super();
        this.b = s;
        this.c = s1;
    }

    @Override
    public final Object call() {
        switch(this.a) {
            case 0: {
                return ((LottieAnimationView)this.c).lambda$fromAssets$2(this.b);
            }
            case 1: {
                return LottieCompositionFactory.fromJsonSourceSync(((Source)this.c), this.b);
            }
            case 2: {
                return LottieCompositionFactory.fromJsonStringSync(this.b, ((String)this.c));
            }
            case 3: {
                return LottieCompositionFactory.fromJsonReaderSync(((JsonReader)this.c), this.b);
            }
            case 4: {
                return LottieCompositionFactory.fromJsonInputStreamSync(((InputStream)this.c), this.b);
            }
            default: {
                return LottieCompositionFactory.t(this.b, ((JSONObject)this.c));
            }
        }
    }
}

