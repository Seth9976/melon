package com.kakaoent.leonplayer.core.model.data.json;

import U4.x;
import Vd.i;
import Vd.l;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001A\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J1\u0010\u0011\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00032\b\b\u0003\u0010\u0005\u001A\u00020\u00032\b\b\u0003\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\tR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/DocumentInfo;", "", "creationTime", "", "generator", "id", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreationTime", "()Ljava/lang/String;", "getGenerator", "getId", "getVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DocumentInfo {
    @NotNull
    private final String creationTime;
    @NotNull
    private final String generator;
    @NotNull
    private final String id;
    @NotNull
    private final String version;

    public DocumentInfo(@i(name = "creation_datetime") @NotNull String s, @i(name = "generator") @NotNull String s1, @i(name = "id") @NotNull String s2, @i(name = "version") @NotNull String s3) {
        q.g(s, "creationTime");
        q.g(s1, "generator");
        q.g(s2, "id");
        q.g(s3, "version");
        super();
        this.creationTime = s;
        this.generator = s1;
        this.id = s2;
        this.version = s3;
    }

    @NotNull
    public final String component1() {
        return this.creationTime;
    }

    @NotNull
    public final String component2() {
        return this.generator;
    }

    @NotNull
    public final String component3() {
        return this.id;
    }

    @NotNull
    public final String component4() {
        return this.version;
    }

    @NotNull
    public final DocumentInfo copy(@i(name = "creation_datetime") @NotNull String s, @i(name = "generator") @NotNull String s1, @i(name = "id") @NotNull String s2, @i(name = "version") @NotNull String s3) {
        q.g(s, "creationTime");
        q.g(s1, "generator");
        q.g(s2, "id");
        q.g(s3, "version");
        return new DocumentInfo(s, s1, s2, s3);
    }

    public static DocumentInfo copy$default(DocumentInfo documentInfo0, String s, String s1, String s2, String s3, int v, Object object0) {
        if((v & 1) != 0) {
            s = documentInfo0.creationTime;
        }
        if((v & 2) != 0) {
            s1 = documentInfo0.generator;
        }
        if((v & 4) != 0) {
            s2 = documentInfo0.id;
        }
        if((v & 8) != 0) {
            s3 = documentInfo0.version;
        }
        return documentInfo0.copy(s, s1, s2, s3);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DocumentInfo)) {
            return false;
        }
        if(!q.b(this.creationTime, ((DocumentInfo)object0).creationTime)) {
            return false;
        }
        if(!q.b(this.generator, ((DocumentInfo)object0).generator)) {
            return false;
        }
        return q.b(this.id, ((DocumentInfo)object0).id) ? q.b(this.version, ((DocumentInfo)object0).version) : false;
    }

    @NotNull
    public final String getCreationTime() {
        return this.creationTime;
    }

    @NotNull
    public final String getGenerator() {
        return this.generator;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    @Override
    public int hashCode() {
        return this.version.hashCode() + x.b(x.b(this.creationTime.hashCode() * 0x1F, 0x1F, this.generator), 0x1F, this.id);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DocumentInfo(creationTime=");
        stringBuilder0.append(this.creationTime);
        stringBuilder0.append(", generator=");
        stringBuilder0.append(this.generator);
        stringBuilder0.append(", id=");
        stringBuilder0.append(this.id);
        stringBuilder0.append(", version=");
        return o.r(stringBuilder0, this.version, ')');
    }
}

