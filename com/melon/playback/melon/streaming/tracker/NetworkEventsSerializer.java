package com.melon.playback.melon.streaming.tracker;

import androidx.lifecycle.b;
import com.google.gson.t;
import com.google.gson.w;
import dc.a;
import java.lang.reflect.Type;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/melon/playback/melon/streaming/tracker/NetworkEventsSerializer;", "Lcom/google/gson/w;", "Lcom/melon/playback/melon/streaming/tracker/NetworkEvents;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class NetworkEventsSerializer implements w {
    @Override  // com.google.gson.w
    public final t a(Object object0, Type type0, b b0) {
        q.g(((NetworkEvents)object0), "src");
        q.g(type0, "typeOfSrc");
        q.g(b0, "context");
        t t0 = new t();
        if(((NetworkEvents)object0).getConnection() != null) {
            t0.d("connection", b0.z(((NetworkEvents)object0).getConnection()));
        }
        if(((NetworkEvents)object0).getRequest() != null) {
            t0.d("request", b0.z(((NetworkEvents)object0).getRequest()));
        }
        if(((NetworkEvents)object0).getResponse() != null) {
            t0.d("response", b0.z(((NetworkEvents)object0).getResponse()));
        }
        if(((NetworkEvents)object0).getError() != null) {
            t0.e("error", ((NetworkEvents)object0).getError().toString());
        }
        if(!((NetworkEvents)object0).getEvents().isEmpty()) {
            t0.e("eventsElapsedTime", ((a)p.s0(((NetworkEvents)object0).getEvents())).b - ((a)p.k0(((NetworkEvents)object0).getEvents())).b + " ms");
        }
        t0.d("events", b0.z(((NetworkEvents)object0).getEvents()));
        return t0;
    }
}

