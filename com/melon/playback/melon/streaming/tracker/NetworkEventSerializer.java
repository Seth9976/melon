package com.melon.playback.melon.streaming.tracker;

import De.I;
import androidx.lifecycle.b;
import com.google.gson.t;
import com.google.gson.w;
import dc.a;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/melon/playback/melon/streaming/tracker/NetworkEventSerializer;", "Lcom/google/gson/w;", "Ldc/a;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class NetworkEventSerializer implements w {
    @Override  // com.google.gson.w
    public final t a(Object object0, Type type0, b b0) {
        q.g(((a)object0), "src");
        q.g(type0, "typeOfSrc");
        q.g(b0, "context");
        t t0 = new t();
        t0.e("name", ((a)object0).a);
        t0.e("time", I.b0(((a)object0).b));
        return t0;
    }
}

