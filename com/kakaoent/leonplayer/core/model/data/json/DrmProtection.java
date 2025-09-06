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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\'\u0010\u000E\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00032\b\b\u0003\u0010\u0005\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/DrmProtection;", "", "id", "", "scheme", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getScheme", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DrmProtection {
    @NotNull
    private final String id;
    @NotNull
    private final String scheme;
    @NotNull
    private final String url;

    public DrmProtection(@i(name = "id") @NotNull String s, @i(name = "scheme") @NotNull String s1, @i(name = "url") @NotNull String s2) {
        q.g(s, "id");
        q.g(s1, "scheme");
        q.g(s2, "url");
        super();
        this.id = s;
        this.scheme = s1;
        this.url = s2;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.scheme;
    }

    @NotNull
    public final String component3() {
        return this.url;
    }

    @NotNull
    public final DrmProtection copy(@i(name = "id") @NotNull String s, @i(name = "scheme") @NotNull String s1, @i(name = "url") @NotNull String s2) {
        q.g(s, "id");
        q.g(s1, "scheme");
        q.g(s2, "url");
        return new DrmProtection(s, s1, s2);
    }

    public static DrmProtection copy$default(DrmProtection drmProtection0, String s, String s1, String s2, int v, Object object0) {
        if((v & 1) != 0) {
            s = drmProtection0.id;
        }
        if((v & 2) != 0) {
            s1 = drmProtection0.scheme;
        }
        if((v & 4) != 0) {
            s2 = drmProtection0.url;
        }
        return drmProtection0.copy(s, s1, s2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DrmProtection)) {
            return false;
        }
        if(!q.b(this.id, ((DrmProtection)object0).id)) {
            return false;
        }
        return q.b(this.scheme, ((DrmProtection)object0).scheme) ? q.b(this.url, ((DrmProtection)object0).url) : false;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getScheme() {
        return this.scheme;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Override
    public int hashCode() {
        return this.url.hashCode() + x.b(this.id.hashCode() * 0x1F, 0x1F, this.scheme);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DrmProtection(id=");
        stringBuilder0.append(this.id);
        stringBuilder0.append(", scheme=");
        stringBuilder0.append(this.scheme);
        stringBuilder0.append(", url=");
        return o.r(stringBuilder0, this.url, ')');
    }
}

