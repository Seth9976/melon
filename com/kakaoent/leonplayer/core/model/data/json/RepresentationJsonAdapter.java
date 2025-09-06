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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001C\u0010\u001A\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u0019R\u001A\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u0019R\u001C\u0010\u001C\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u0019¨\u0006\u001D"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/RepresentationJsonAdapter;", "LVd/k;", "Lcom/kakaoent/leonplayer/core/model/data/json/Representation;", "LVd/D;", "moshi", "<init>", "(LVd/D;)V", "", "toString", "()Ljava/lang/String;", "LVd/p;", "reader", "fromJson", "(LVd/p;)Lcom/kakaoent/leonplayer/core/model/data/json/Representation;", "LVd/v;", "writer", "value_", "Lie/H;", "toJson", "(LVd/v;Lcom/kakaoent/leonplayer/core/model/data/json/Representation;)V", "LVd/n;", "options", "LVd/n;", "", "intAdapter", "LVd/k;", "nullableStringAdapter", "stringAdapter", "nullableIntAdapter", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class RepresentationJsonAdapter extends k {
    @NotNull
    private final k intAdapter;
    @NotNull
    private final k nullableIntAdapter;
    @NotNull
    private final k nullableStringAdapter;
    @NotNull
    private final n options;
    @NotNull
    private final k stringAdapter;

    public RepresentationJsonAdapter(@NotNull D d0) {
        q.g(d0, "moshi");
        super();
        this.options = n.a(new String[]{"bitrate", "channels", "codec", "disp_name", "id", "resolution", "sample_rate"});
        this.intAdapter = d0.b(Integer.TYPE, y.a, "bitrate");
        this.nullableStringAdapter = d0.b(String.class, y.a, "channels");
        this.stringAdapter = d0.b(String.class, y.a, "codec");
        this.nullableIntAdapter = d0.b(Integer.class, y.a, "sampleRate");
    }

    @NotNull
    public Representation fromJson(@NotNull p p0) {
        q.g(p0, "reader");
        p0.m();
        Integer integer0 = null;
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        Integer integer1 = null;
        while(p0.r()) {
            switch(p0.M(this.options)) {
                case -1: {
                    p0.P();
                    p0.Q();
                    break;
                }
                case 0: {
                    integer0 = (Integer)this.intAdapter.fromJson(p0);
                    if(integer0 == null) {
                        throw f.j("bitrate", "bitrate", p0);
                    }
                    continue;
                }
                case 1: {
                    s = (String)this.nullableStringAdapter.fromJson(p0);
                    break;
                }
                case 2: {
                    s1 = (String)this.stringAdapter.fromJson(p0);
                    if(s1 == null) {
                        throw f.j("codec", "codec", p0);
                    }
                    continue;
                }
                case 3: {
                    s2 = (String)this.stringAdapter.fromJson(p0);
                    if(s2 == null) {
                        throw f.j("dispName", "disp_name", p0);
                    }
                    continue;
                }
                case 4: {
                    s3 = (String)this.stringAdapter.fromJson(p0);
                    if(s3 == null) {
                        throw f.j("id", "id", p0);
                    }
                    continue;
                }
                case 5: {
                    s4 = (String)this.nullableStringAdapter.fromJson(p0);
                    break;
                }
                case 6: {
                    integer1 = (Integer)this.nullableIntAdapter.fromJson(p0);
                }
            }
        }
        p0.p();
        if(integer0 == null) {
            throw f.e("bitrate", "bitrate", p0);
        }
        int v = (int)integer0;
        if(s1 == null) {
            throw f.e("codec", "codec", p0);
        }
        if(s2 == null) {
            throw f.e("dispName", "disp_name", p0);
        }
        if(s3 == null) {
            throw f.e("id", "id", p0);
        }
        return new Representation(v, s, s1, s2, s3, s4, integer1);
    }

    @Override  // Vd.k
    public Object fromJson(p p0) {
        return this.fromJson(p0);
    }

    public void toJson(@NotNull v v0, @Nullable Representation representation0) {
        q.g(v0, "writer");
        if(representation0 == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        v0.m();
        v0.s("bitrate");
        this.intAdapter.toJson(v0, representation0.getBitrate());
        v0.s("channels");
        this.nullableStringAdapter.toJson(v0, representation0.getChannels());
        v0.s("codec");
        this.stringAdapter.toJson(v0, representation0.getCodec());
        v0.s("disp_name");
        this.stringAdapter.toJson(v0, representation0.getDispName());
        v0.s("id");
        this.stringAdapter.toJson(v0, representation0.getId());
        v0.s("resolution");
        this.nullableStringAdapter.toJson(v0, representation0.getResolution());
        v0.s("sample_rate");
        this.nullableIntAdapter.toJson(v0, representation0.getSampleRate());
        v0.q();
    }

    @Override  // Vd.k
    public void toJson(v v0, Object object0) {
        this.toJson(v0, ((Representation)object0));
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return "GeneratedJsonAdapter(Representation)";
    }
}

