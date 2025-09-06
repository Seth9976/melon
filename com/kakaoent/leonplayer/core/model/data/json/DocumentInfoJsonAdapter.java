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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/DocumentInfoJsonAdapter;", "LVd/k;", "Lcom/kakaoent/leonplayer/core/model/data/json/DocumentInfo;", "LVd/D;", "moshi", "<init>", "(LVd/D;)V", "", "toString", "()Ljava/lang/String;", "LVd/p;", "reader", "fromJson", "(LVd/p;)Lcom/kakaoent/leonplayer/core/model/data/json/DocumentInfo;", "LVd/v;", "writer", "value_", "Lie/H;", "toJson", "(LVd/v;Lcom/kakaoent/leonplayer/core/model/data/json/DocumentInfo;)V", "LVd/n;", "options", "LVd/n;", "stringAdapter", "LVd/k;", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DocumentInfoJsonAdapter extends k {
    @NotNull
    private final n options;
    @NotNull
    private final k stringAdapter;

    public DocumentInfoJsonAdapter(@NotNull D d0) {
        q.g(d0, "moshi");
        super();
        this.options = n.a(new String[]{"creation_datetime", "generator", "id", "version"});
        this.stringAdapter = d0.b(String.class, y.a, "creationTime");
    }

    @NotNull
    public DocumentInfo fromJson(@NotNull p p0) {
        q.g(p0, "reader");
        p0.m();
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        while(p0.r()) {
            switch(p0.M(this.options)) {
                case -1: {
                    p0.P();
                    p0.Q();
                    continue;
                }
                case 0: {
                    s = (String)this.stringAdapter.fromJson(p0);
                    if(s == null) {
                        throw f.j("creationTime", "creation_datetime", p0);
                    }
                    continue;
                }
                case 1: {
                    s1 = (String)this.stringAdapter.fromJson(p0);
                    if(s1 == null) {
                        throw f.j("generator", "generator", p0);
                    }
                    continue;
                }
                case 2: {
                    s2 = (String)this.stringAdapter.fromJson(p0);
                    if(s2 == null) {
                        throw f.j("id", "id", p0);
                    }
                    continue;
                }
                case 3: {
                    s3 = (String)this.stringAdapter.fromJson(p0);
                    if(s3 == null) {
                        throw f.j("version", "version", p0);
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
        if(s == null) {
            throw f.e("creationTime", "creation_datetime", p0);
        }
        if(s1 == null) {
            throw f.e("generator", "generator", p0);
        }
        if(s2 == null) {
            throw f.e("id", "id", p0);
        }
        if(s3 == null) {
            throw f.e("version", "version", p0);
        }
        return new DocumentInfo(s, s1, s2, s3);
    }

    @Override  // Vd.k
    public Object fromJson(p p0) {
        return this.fromJson(p0);
    }

    public void toJson(@NotNull v v0, @Nullable DocumentInfo documentInfo0) {
        q.g(v0, "writer");
        if(documentInfo0 == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        v0.m();
        v0.s("creation_datetime");
        this.stringAdapter.toJson(v0, documentInfo0.getCreationTime());
        v0.s("generator");
        this.stringAdapter.toJson(v0, documentInfo0.getGenerator());
        v0.s("id");
        this.stringAdapter.toJson(v0, documentInfo0.getId());
        v0.s("version");
        this.stringAdapter.toJson(v0, documentInfo0.getVersion());
        v0.q();
    }

    @Override  // Vd.k
    public void toJson(v v0, Object object0) {
        this.toJson(v0, ((DocumentInfo)object0));
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return "GeneratedJsonAdapter(DocumentInfo)";
    }
}

