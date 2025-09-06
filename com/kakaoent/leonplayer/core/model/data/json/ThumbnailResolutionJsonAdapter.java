package com.kakaoent.leonplayer.core.model.data.json;

import Vd.D;
import Vd.k;
import Vd.n;
import Vd.p;
import Vd.v;
import Wd.f;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailResolutionJsonAdapter;", "LVd/k;", "Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailResolution;", "LVd/D;", "moshi", "<init>", "(LVd/D;)V", "", "toString", "()Ljava/lang/String;", "LVd/p;", "reader", "fromJson", "(LVd/p;)Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailResolution;", "LVd/v;", "writer", "value_", "Lie/H;", "toJson", "(LVd/v;Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailResolution;)V", "LVd/n;", "options", "LVd/n;", "", "intAdapter", "LVd/k;", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ThumbnailResolutionJsonAdapter extends k {
    @NotNull
    private final k intAdapter;
    @NotNull
    private final n options;

    public ThumbnailResolutionJsonAdapter(@NotNull D d0) {
        q.g(d0, "moshi");
        super();
        this.options = n.a(new String[]{"width", "height"});
        this.intAdapter = d0.b(Integer.TYPE, y.a, "width");
    }

    @NotNull
    public ThumbnailResolution fromJson(@NotNull p p0) {
        q.g(p0, "reader");
        p0.m();
        Integer integer0 = null;
        Integer integer1 = null;
        while(p0.r()) {
            int v = p0.M(this.options);
            switch(v) {
                case -1: {
                    p0.P();
                    p0.Q();
                    continue;
                }
                case 0: {
                    integer0 = (Integer)this.intAdapter.fromJson(p0);
                    if(integer0 == null) {
                        throw f.j("width", "width", p0);
                    }
                    break;
                }
                default: {
                    if(v != 1) {
                        continue;
                    }
                    integer1 = (Integer)this.intAdapter.fromJson(p0);
                    if(integer1 == null) {
                        throw f.j("height", "height", p0);
                    }
                    continue;
                }
            }
            if(false) {
                break;
            }
        }
        p0.p();
        if(integer0 == null) {
            throw f.e("width", "width", p0);
        }
        int v1 = (int)integer0;
        if(integer1 == null) {
            throw f.e("height", "height", p0);
        }
        return new ThumbnailResolution(v1, ((int)integer1));
    }

    @Override  // Vd.k
    public Object fromJson(p p0) {
        return this.fromJson(p0);
    }

    public void toJson(@NotNull v v0, @Nullable ThumbnailResolution thumbnailResolution0) {
        q.g(v0, "writer");
        if(thumbnailResolution0 == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        v0.m();
        v0.s("width");
        this.intAdapter.toJson(v0, thumbnailResolution0.getWidth());
        v0.s("height");
        this.intAdapter.toJson(v0, thumbnailResolution0.getHeight());
        v0.q();
    }

    @Override  // Vd.k
    public void toJson(v v0, Object object0) {
        this.toJson(v0, ((ThumbnailResolution)object0));
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return "GeneratedJsonAdapter(ThumbnailResolution)";
    }
}

