package com.kakaoent.leonplayer.core.model.data.json;

import Vd.D;
import Vd.k;
import Vd.n;
import Vd.p;
import Vd.v;
import Wd.f;
import java.lang.reflect.Constructor;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001C\u0010\u001A\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u0018R\u001C\u0010\u001C\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001B0\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u0018R\u001C\u0010\u001D\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001D\u0010\u0018R\u001E\u0010\u001F\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 ¨\u0006!"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/MediaPropertiesJsonAdapter;", "LVd/k;", "Lcom/kakaoent/leonplayer/core/model/data/json/MediaProperties;", "LVd/D;", "moshi", "<init>", "(LVd/D;)V", "", "toString", "()Ljava/lang/String;", "LVd/p;", "reader", "fromJson", "(LVd/p;)Lcom/kakaoent/leonplayer/core/model/data/json/MediaProperties;", "LVd/v;", "writer", "value_", "Lie/H;", "toJson", "(LVd/v;Lcom/kakaoent/leonplayer/core/model/data/json/MediaProperties;)V", "LVd/n;", "options", "LVd/n;", "stringAdapter", "LVd/k;", "", "nullableDoubleAdapter", "", "nullableIntAdapter", "nullableStringAdapter", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MediaPropertiesJsonAdapter extends k {
    @Nullable
    private volatile Constructor constructorRef;
    @NotNull
    private final k nullableDoubleAdapter;
    @NotNull
    private final k nullableIntAdapter;
    @NotNull
    private final k nullableStringAdapter;
    @NotNull
    private final n options;
    @NotNull
    private final k stringAdapter;

    public MediaPropertiesJsonAdapter(@NotNull D d0) {
        q.g(d0, "moshi");
        super();
        this.options = n.a(new String[]{"type", "duration", "ndvr_window_size", "live_start_time", "live_end_time"});
        this.stringAdapter = d0.b(String.class, y.a, "type");
        this.nullableDoubleAdapter = d0.b(Double.class, y.a, "duration");
        this.nullableIntAdapter = d0.b(Integer.class, y.a, "ndvrWindowSize");
        this.nullableStringAdapter = d0.b(String.class, y.a, "liveStartTime");
    }

    @NotNull
    public MediaProperties fromJson(@NotNull p p0) {
        q.g(p0, "reader");
        p0.m();
        String s = null;
        Double double0 = null;
        Integer integer0 = null;
        String s1 = null;
        String s2 = null;
        int v = -1;
        while(p0.r()) {
            switch(p0.M(this.options)) {
                case -1: {
                    p0.P();
                    p0.Q();
                    break;
                }
                case 0: {
                    s = (String)this.stringAdapter.fromJson(p0);
                    if(s == null) {
                        throw f.j("type", "type", p0);
                    }
                    continue;
                }
                case 1: {
                    double0 = (Double)this.nullableDoubleAdapter.fromJson(p0);
                    v = -3;
                    break;
                }
                case 2: {
                    integer0 = (Integer)this.nullableIntAdapter.fromJson(p0);
                    break;
                }
                case 3: {
                    s1 = (String)this.nullableStringAdapter.fromJson(p0);
                    break;
                }
                case 4: {
                    s2 = (String)this.nullableStringAdapter.fromJson(p0);
                }
            }
        }
        p0.p();
        if(v == -3) {
            if(s == null) {
                throw f.e("type", "type", p0);
            }
            return new MediaProperties(s, double0, integer0, s1, s2);
        }
        Constructor constructor0 = this.constructorRef;
        if(constructor0 == null) {
            constructor0 = MediaProperties.class.getDeclaredConstructor(String.class, Double.class, Integer.class, String.class, String.class, Integer.TYPE, f.c);
            this.constructorRef = constructor0;
            q.f(constructor0, "MediaProperties::class.j…his.constructorRef = it }");
        }
        if(s == null) {
            throw f.e("type", "type", p0);
        }
        Object object0 = constructor0.newInstance(s, double0, integer0, s1, s2, v, 0);
        q.f(object0, "localConstructor.newInst…torMarker */ null\n      )");
        return (MediaProperties)object0;
    }

    @Override  // Vd.k
    public Object fromJson(p p0) {
        return this.fromJson(p0);
    }

    public void toJson(@NotNull v v0, @Nullable MediaProperties mediaProperties0) {
        q.g(v0, "writer");
        if(mediaProperties0 == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        v0.m();
        v0.s("type");
        this.stringAdapter.toJson(v0, mediaProperties0.getType());
        v0.s("duration");
        this.nullableDoubleAdapter.toJson(v0, mediaProperties0.getDuration());
        v0.s("ndvr_window_size");
        this.nullableIntAdapter.toJson(v0, mediaProperties0.getNdvrWindowSize());
        v0.s("live_start_time");
        this.nullableStringAdapter.toJson(v0, mediaProperties0.getLiveStartTime());
        v0.s("live_end_time");
        this.nullableStringAdapter.toJson(v0, mediaProperties0.getLiveEndTime());
        v0.q();
    }

    @Override  // Vd.k
    public void toJson(v v0, Object object0) {
        this.toJson(v0, ((MediaProperties)object0));
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return "GeneratedJsonAdapter(MediaProperties)";
    }
}

