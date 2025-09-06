package com.melon.data.database.entity;

import A7.d;
import H0.b;
import U4.x;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001D\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\b\b\u0002\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fB\t\b\u0016¢\u0006\u0004\b\u000B\u0010\rJ\t\u0010 \u001A\u00020\u0003HÆ\u0003J\t\u0010!\u001A\u00020\u0005HÆ\u0003J\t\u0010\"\u001A\u00020\u0005HÆ\u0003J\t\u0010#\u001A\u00020\u0005HÆ\u0003J\t\u0010$\u001A\u00020\u0005HÆ\u0003J\t\u0010%\u001A\u00020\nHÆ\u0003JE\u0010&\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\nHÆ\u0001J\u0013\u0010\'\u001A\u00020(2\b\u0010)\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001A\u00020\u0003HÖ\u0001J\t\u0010+\u001A\u00020\u0005HÖ\u0001R\u001E\u0010\u0002\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001E\u0010\u0006\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001E\u0010\u0007\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001E\u0010\b\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0013\"\u0004\b\u001B\u0010\u0015R\u001E\u0010\t\u001A\u00020\n8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001F¨\u0006,"}, d2 = {"Lcom/melon/data/database/entity/LocalPlaybackLogEntity;", "", "uid", "", "data", "", "cId", "cType", "lCode", "timestamp", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "()V", "getUid", "()I", "setUid", "(I)V", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "getCId", "setCId", "getCType", "setCType", "getLCode", "setLCode", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LocalPlaybackLogEntity {
    public static final int $stable = 8;
    @NotNull
    private String cId;
    @NotNull
    private String cType;
    @NotNull
    private String data;
    @NotNull
    private String lCode;
    private long timestamp;
    private int uid;

    public LocalPlaybackLogEntity() {
        this(0, "", "", "", "", 0L);
    }

    public LocalPlaybackLogEntity(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v1) {
        q.g(s, "data");
        q.g(s1, "cId");
        q.g(s2, "cType");
        q.g(s3, "lCode");
        super();
        this.uid = v;
        this.data = s;
        this.cId = s1;
        this.cType = s2;
        this.lCode = s3;
        this.timestamp = v1;
    }

    public LocalPlaybackLogEntity(int v, String s, String s1, String s2, String s3, long v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v, s, s1, s2, s3, ((v2 & 0x20) == 0 ? v1 : 0L));
    }

    public final int component1() {
        return this.uid;
    }

    @NotNull
    public final String component2() {
        return this.data;
    }

    @NotNull
    public final String component3() {
        return this.cId;
    }

    @NotNull
    public final String component4() {
        return this.cType;
    }

    @NotNull
    public final String component5() {
        return this.lCode;
    }

    public final long component6() {
        return this.timestamp;
    }

    @NotNull
    public final LocalPlaybackLogEntity copy(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, long v1) {
        q.g(s, "data");
        q.g(s1, "cId");
        q.g(s2, "cType");
        q.g(s3, "lCode");
        return new LocalPlaybackLogEntity(v, s, s1, s2, s3, v1);
    }

    public static LocalPlaybackLogEntity copy$default(LocalPlaybackLogEntity localPlaybackLogEntity0, int v, String s, String s1, String s2, String s3, long v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = localPlaybackLogEntity0.uid;
        }
        if((v2 & 2) != 0) {
            s = localPlaybackLogEntity0.data;
        }
        if((v2 & 4) != 0) {
            s1 = localPlaybackLogEntity0.cId;
        }
        if((v2 & 8) != 0) {
            s2 = localPlaybackLogEntity0.cType;
        }
        if((v2 & 16) != 0) {
            s3 = localPlaybackLogEntity0.lCode;
        }
        if((v2 & 0x20) != 0) {
            v1 = localPlaybackLogEntity0.timestamp;
        }
        return localPlaybackLogEntity0.copy(v, s, s1, s2, s3, v1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LocalPlaybackLogEntity)) {
            return false;
        }
        if(this.uid != ((LocalPlaybackLogEntity)object0).uid) {
            return false;
        }
        if(!q.b(this.data, ((LocalPlaybackLogEntity)object0).data)) {
            return false;
        }
        if(!q.b(this.cId, ((LocalPlaybackLogEntity)object0).cId)) {
            return false;
        }
        if(!q.b(this.cType, ((LocalPlaybackLogEntity)object0).cType)) {
            return false;
        }
        return q.b(this.lCode, ((LocalPlaybackLogEntity)object0).lCode) ? this.timestamp == ((LocalPlaybackLogEntity)object0).timestamp : false;
    }

    @NotNull
    public final String getCId() [...] // 潜在的解密器

    @NotNull
    public final String getCType() [...] // 潜在的解密器

    @NotNull
    public final String getData() [...] // 潜在的解密器

    @NotNull
    public final String getLCode() [...] // 潜在的解密器

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getUid() {
        return this.uid;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.timestamp) + x.b(x.b(x.b(x.b(this.uid * 0x1F, 0x1F, this.data), 0x1F, this.cId), 0x1F, this.cType), 0x1F, this.lCode);
    }

    public final void setCId(@NotNull String s) {
        q.g(s, "<set-?>");
        this.cId = s;
    }

    public final void setCType(@NotNull String s) {
        q.g(s, "<set-?>");
        this.cType = s;
    }

    public final void setData(@NotNull String s) {
        q.g(s, "<set-?>");
        this.data = s;
    }

    public final void setLCode(@NotNull String s) {
        q.g(s, "<set-?>");
        this.lCode = s;
    }

    public final void setTimestamp(long v) {
        this.timestamp = v;
    }

    public final void setUid(int v) {
        this.uid = v;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.cId;
        String s1 = this.cType;
        String s2 = this.lCode;
        long v = this.timestamp;
        StringBuilder stringBuilder0 = x.o(this.uid, "LocalPlaybackLogEntity(uid=", ", data=", this.data, ", cId=");
        d.u(stringBuilder0, s, ", cType=", s1, ", lCode=");
        b.t(v, s2, ", timestamp=", stringBuilder0);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

