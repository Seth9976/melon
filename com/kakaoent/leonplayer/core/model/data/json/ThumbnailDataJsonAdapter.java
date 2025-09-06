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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001C\u0010\u001B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001A0\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u0019R \u0010\u001E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001D0\u001C0\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u0019¨\u0006\u001F"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailDataJsonAdapter;", "LVd/k;", "Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailData;", "LVd/D;", "moshi", "<init>", "(LVd/D;)V", "", "toString", "()Ljava/lang/String;", "LVd/p;", "reader", "fromJson", "(LVd/p;)Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailData;", "LVd/v;", "writer", "value_", "Lie/H;", "toJson", "(LVd/v;Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailData;)V", "LVd/n;", "options", "LVd/n;", "", "doubleAdapter", "LVd/k;", "", "nullableIntAdapter", "", "Lcom/kakaoent/leonplayer/core/model/data/json/Thumbnail;", "listOfThumbnailAdapter", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ThumbnailDataJsonAdapter extends k {
    @NotNull
    private final k doubleAdapter;
    @NotNull
    private final k listOfThumbnailAdapter;
    @NotNull
    private final k nullableIntAdapter;
    @NotNull
    private final n options;

    public ThumbnailDataJsonAdapter(@NotNull D d0) {
        q.g(d0, "moshi");
        super();
        this.options = n.a(new String[]{"interval", "thumbnail_count", "thumbnails"});
        this.doubleAdapter = d0.b(Double.TYPE, y.a, "interval");
        this.nullableIntAdapter = d0.b(Integer.class, y.a, "thumbnailCount");
        this.listOfThumbnailAdapter = d0.b(I.f(new Type[]{Thumbnail.class}), y.a, "thumbnails");
    }

    @NotNull
    public ThumbnailData fromJson(@NotNull p p0) {
        q.g(p0, "reader");
        p0.m();
        Double double0 = null;
        Integer integer0 = null;
        List list0 = null;
        while(p0.r()) {
            switch(p0.M(this.options)) {
                case -1: {
                    p0.P();
                    p0.Q();
                    continue;
                }
                case 0: {
                    double0 = (Double)this.doubleAdapter.fromJson(p0);
                    if(double0 == null) {
                        throw f.j("interval", "interval", p0);
                    }
                    continue;
                }
                case 1: {
                    integer0 = (Integer)this.nullableIntAdapter.fromJson(p0);
                    continue;
                }
                case 2: {
                    list0 = (List)this.listOfThumbnailAdapter.fromJson(p0);
                    if(list0 == null) {
                        throw f.j("thumbnails", "thumbnails", p0);
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
        if(double0 == null) {
            throw f.e("interval", "interval", p0);
        }
        double f = (double)double0;
        if(list0 == null) {
            throw f.e("thumbnails", "thumbnails", p0);
        }
        return new ThumbnailData(f, integer0, list0);
    }

    @Override  // Vd.k
    public Object fromJson(p p0) {
        return this.fromJson(p0);
    }

    public void toJson(@NotNull v v0, @Nullable ThumbnailData thumbnailData0) {
        q.g(v0, "writer");
        if(thumbnailData0 == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        v0.m();
        v0.s("interval");
        this.doubleAdapter.toJson(v0, thumbnailData0.getInterval());
        v0.s("thumbnail_count");
        this.nullableIntAdapter.toJson(v0, thumbnailData0.getThumbnailCount());
        v0.s("thumbnails");
        this.listOfThumbnailAdapter.toJson(v0, thumbnailData0.getThumbnails());
        v0.q();
    }

    @Override  // Vd.k
    public void toJson(v v0, Object object0) {
        this.toJson(v0, ((ThumbnailData)object0));
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return "GeneratedJsonAdapter(ThumbnailData)";
    }
}

