package com.kakaoent.leonplayer.core.model.data.json;

import Vd.D;
import Vd.k;
import Vd.n;
import Vd.p;
import Vd.v;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001C\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/QoeInfoJsonAdapter;", "LVd/k;", "Lcom/kakaoent/leonplayer/core/model/data/json/QoeInfo;", "LVd/D;", "moshi", "<init>", "(LVd/D;)V", "", "toString", "()Ljava/lang/String;", "LVd/p;", "reader", "fromJson", "(LVd/p;)Lcom/kakaoent/leonplayer/core/model/data/json/QoeInfo;", "LVd/v;", "writer", "value_", "Lie/H;", "toJson", "(LVd/v;Lcom/kakaoent/leonplayer/core/model/data/json/QoeInfo;)V", "LVd/n;", "options", "LVd/n;", "", "nullableAnyAdapter", "LVd/k;", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class QoeInfoJsonAdapter extends k {
    @NotNull
    private final k nullableAnyAdapter;
    @NotNull
    private final n options;

    public QoeInfoJsonAdapter(@NotNull D d0) {
        q.g(d0, "moshi");
        super();
        this.options = n.a(new String[]{"temp"});
        this.nullableAnyAdapter = d0.b(Object.class, y.a, "temp");
    }

    @NotNull
    public QoeInfo fromJson(@NotNull p p0) {
        q.g(p0, "reader");
        p0.m();
        Object object0 = null;
        while(p0.r()) {
            switch(p0.M(this.options)) {
                case -1: {
                    p0.P();
                    p0.Q();
                    break;
                }
                case 0: {
                    object0 = this.nullableAnyAdapter.fromJson(p0);
                }
            }
        }
        p0.p();
        return new QoeInfo(object0);
    }

    @Override  // Vd.k
    public Object fromJson(p p0) {
        return this.fromJson(p0);
    }

    public void toJson(@NotNull v v0, @Nullable QoeInfo qoeInfo0) {
        q.g(v0, "writer");
        if(qoeInfo0 == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        v0.m();
        v0.s("temp");
        this.nullableAnyAdapter.toJson(v0, qoeInfo0.getTemp());
        v0.q();
    }

    @Override  // Vd.k
    public void toJson(v v0, Object object0) {
        this.toJson(v0, ((QoeInfo)object0));
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return "GeneratedJsonAdapter(QoeInfo)";
    }
}

