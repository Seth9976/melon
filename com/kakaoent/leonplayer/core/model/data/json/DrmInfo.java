package com.kakaoent.leonplayer.core.model.data.json;

import A7.d;
import Vd.i;
import Vd.l;
import androidx.appcompat.app.o;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\u000E\b\u0001\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001A\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J-\u0010\u0011\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\u000E\b\u0003\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0007\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/DrmInfo;", "", "fairplayCertUrl", "", "protections", "", "Lcom/kakaoent/leonplayer/core/model/data/json/DrmProtection;", "token", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getFairplayCertUrl", "()Ljava/lang/String;", "getProtections", "()Ljava/util/List;", "getToken", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DrmInfo {
    @NotNull
    private final String fairplayCertUrl;
    @NotNull
    private final List protections;
    @NotNull
    private final String token;

    public DrmInfo(@i(name = "fairplay_cert_url") @NotNull String s, @i(name = "protections") @NotNull List list0, @i(name = "token") @NotNull String s1) {
        q.g(s, "fairplayCertUrl");
        q.g(list0, "protections");
        q.g(s1, "token");
        super();
        this.fairplayCertUrl = s;
        this.protections = list0;
        this.token = s1;
    }

    @NotNull
    public final String component1() {
        return this.fairplayCertUrl;
    }

    @NotNull
    public final List component2() {
        return this.protections;
    }

    @NotNull
    public final String component3() {
        return this.token;
    }

    @NotNull
    public final DrmInfo copy(@i(name = "fairplay_cert_url") @NotNull String s, @i(name = "protections") @NotNull List list0, @i(name = "token") @NotNull String s1) {
        q.g(s, "fairplayCertUrl");
        q.g(list0, "protections");
        q.g(s1, "token");
        return new DrmInfo(s, list0, s1);
    }

    public static DrmInfo copy$default(DrmInfo drmInfo0, String s, List list0, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = drmInfo0.fairplayCertUrl;
        }
        if((v & 2) != 0) {
            list0 = drmInfo0.protections;
        }
        if((v & 4) != 0) {
            s1 = drmInfo0.token;
        }
        return drmInfo0.copy(s, list0, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DrmInfo)) {
            return false;
        }
        if(!q.b(this.fairplayCertUrl, ((DrmInfo)object0).fairplayCertUrl)) {
            return false;
        }
        return q.b(this.protections, ((DrmInfo)object0).protections) ? q.b(this.token, ((DrmInfo)object0).token) : false;
    }

    @NotNull
    public final String getFairplayCertUrl() {
        return this.fairplayCertUrl;
    }

    @NotNull
    public final List getProtections() {
        return this.protections;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    @Override
    public int hashCode() {
        return this.token.hashCode() + d.d(this.fairplayCertUrl.hashCode() * 0x1F, 0x1F, this.protections);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DrmInfo(fairplayCertUrl=");
        stringBuilder0.append(this.fairplayCertUrl);
        stringBuilder0.append(", protections=");
        stringBuilder0.append(this.protections);
        stringBuilder0.append(", token=");
        return o.r(stringBuilder0, this.token, ')');
    }
}

