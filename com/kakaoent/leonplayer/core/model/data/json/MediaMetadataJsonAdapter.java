package com.kakaoent.leonplayer.core.model.data.json;

import Vd.D;
import Vd.I;
import Vd.k;
import Vd.n;
import Vd.p;
import Vd.v;
import Wd.f;
import java.lang.reflect.Type;
import java.util.List;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u0019\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/MediaMetadataJsonAdapter;", "LVd/k;", "Lcom/kakaoent/leonplayer/core/model/data/json/MediaMetadata;", "LVd/D;", "moshi", "<init>", "(LVd/D;)V", "", "toString", "()Ljava/lang/String;", "LVd/p;", "reader", "fromJson", "(LVd/p;)Lcom/kakaoent/leonplayer/core/model/data/json/MediaMetadata;", "LVd/v;", "writer", "value_", "Lie/H;", "toJson", "(LVd/v;Lcom/kakaoent/leonplayer/core/model/data/json/MediaMetadata;)V", "LVd/n;", "options", "LVd/n;", "", "Lcom/kakaoent/leonplayer/core/model/data/json/MediaMetadataSkip;", "listOfMediaMetadataSkipAdapter", "LVd/k;", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MediaMetadataJsonAdapter extends k {
    @NotNull
    private final k listOfMediaMetadataSkipAdapter;
    @NotNull
    private final n options;

    public MediaMetadataJsonAdapter(@NotNull D d0) {
        q.g(d0, "moshi");
        super();
        this.options = n.a(new String[]{"skips"});
        this.listOfMediaMetadataSkipAdapter = d0.b(I.f(new Type[]{MediaMetadataSkip.class}), y.a, "skips");
    }

    @NotNull
    public MediaMetadata fromJson(@NotNull p p0) {
        q.g(p0, "reader");
        p0.m();
        List list0 = null;
        while(p0.r()) {
            switch(p0.M(this.options)) {
                case -1: {
                    p0.P();
                    p0.Q();
                    continue;
                }
                case 0: {
                    list0 = (List)this.listOfMediaMetadataSkipAdapter.fromJson(p0);
                    if(list0 == null) {
                        throw f.j("skips", "skips", p0);
                    }
                    break;
                }
                default: {
                    continue;
                }
            }
            if(false) {
                break;
            }
        }
        p0.p();
        if(list0 == null) {
            throw f.e("skips", "skips", p0);
        }
        return new MediaMetadata(list0);
    }

    @Override  // Vd.k
    public Object fromJson(p p0) {
        return this.fromJson(p0);
    }

    public void toJson(@NotNull v v0, @Nullable MediaMetadata mediaMetadata0) {
        q.g(v0, "writer");
        if(mediaMetadata0 == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        v0.m();
        v0.s("skips");
        this.listOfMediaMetadataSkipAdapter.toJson(v0, mediaMetadata0.getSkips());
        v0.q();
    }

    @Override  // Vd.k
    public void toJson(v v0, Object object0) {
        this.toJson(v0, ((MediaMetadata)object0));
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return "GeneratedJsonAdapter(MediaMetadata)";
    }
}

