package com.melon.data.database.entity;

import A7.d;
import U4.x;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001D\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fB\t\b\u0016¢\u0006\u0004\b\u000B\u0010\rJ\t\u0010 \u001A\u00020\u0003HÆ\u0003J\t\u0010!\u001A\u00020\u0005HÆ\u0003J\t\u0010\"\u001A\u00020\u0003HÆ\u0003J\t\u0010#\u001A\u00020\u0005HÆ\u0003J\t\u0010$\u001A\u00020\u0003HÆ\u0003J\t\u0010%\u001A\u00020\nHÆ\u0003JE\u0010&\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\nHÆ\u0001J\u0013\u0010\'\u001A\u00020(2\b\u0010)\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001A\u00020\u0003HÖ\u0001J\t\u0010+\u001A\u00020\u0005HÖ\u0001R\u001E\u0010\u0002\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001E\u0010\u0006\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u000F\"\u0004\b\u0017\u0010\u0011R\u001E\u0010\u0007\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001E\u0010\b\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u000F\"\u0004\b\u001B\u0010\u0011R\u001E\u0010\t\u001A\u00020\n8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001F¨\u0006,"}, d2 = {"Lcom/melon/data/database/entity/ResponseCacheEntity;", "", "uid", "", "key", "", "type", "contents", "hasMore", "timestamp", "", "<init>", "(ILjava/lang/String;ILjava/lang/String;IJ)V", "()V", "getUid", "()I", "setUid", "(I)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getType", "setType", "getContents", "setContents", "getHasMore", "setHasMore", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ResponseCacheEntity {
    public static final int $stable = 8;
    @NotNull
    private String contents;
    private int hasMore;
    @NotNull
    private String key;
    private long timestamp;
    private int type;
    private int uid;

    public ResponseCacheEntity() {
        this(0, "", 0, "", 0, 0L);
    }

    public ResponseCacheEntity(int v, @NotNull String s, int v1, @NotNull String s1, int v2, long v3) {
        q.g(s, "key");
        q.g(s1, "contents");
        super();
        this.uid = v;
        this.key = s;
        this.type = v1;
        this.contents = s1;
        this.hasMore = v2;
        this.timestamp = v3;
    }

    public ResponseCacheEntity(int v, String s, int v1, String s1, int v2, long v3, int v4, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v, s, v1, s1, v2, ((v4 & 0x20) == 0 ? v3 : 0L));
    }

    public final int component1() {
        return this.uid;
    }

    @NotNull
    public final String component2() {
        return this.key;
    }

    public final int component3() {
        return this.type;
    }

    @NotNull
    public final String component4() {
        return this.contents;
    }

    public final int component5() {
        return this.hasMore;
    }

    public final long component6() {
        return this.timestamp;
    }

    @NotNull
    public final ResponseCacheEntity copy(int v, @NotNull String s, int v1, @NotNull String s1, int v2, long v3) {
        q.g(s, "key");
        q.g(s1, "contents");
        return new ResponseCacheEntity(v, s, v1, s1, v2, v3);
    }

    public static ResponseCacheEntity copy$default(ResponseCacheEntity responseCacheEntity0, int v, String s, int v1, String s1, int v2, long v3, int v4, Object object0) {
        if((v4 & 1) != 0) {
            v = responseCacheEntity0.uid;
        }
        if((v4 & 2) != 0) {
            s = responseCacheEntity0.key;
        }
        if((v4 & 4) != 0) {
            v1 = responseCacheEntity0.type;
        }
        if((v4 & 8) != 0) {
            s1 = responseCacheEntity0.contents;
        }
        if((v4 & 16) != 0) {
            v2 = responseCacheEntity0.hasMore;
        }
        if((v4 & 0x20) != 0) {
            v3 = responseCacheEntity0.timestamp;
        }
        return responseCacheEntity0.copy(v, s, v1, s1, v2, v3);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ResponseCacheEntity)) {
            return false;
        }
        if(this.uid != ((ResponseCacheEntity)object0).uid) {
            return false;
        }
        if(!q.b(this.key, ((ResponseCacheEntity)object0).key)) {
            return false;
        }
        if(this.type != ((ResponseCacheEntity)object0).type) {
            return false;
        }
        if(!q.b(this.contents, ((ResponseCacheEntity)object0).contents)) {
            return false;
        }
        return this.hasMore == ((ResponseCacheEntity)object0).hasMore ? this.timestamp == ((ResponseCacheEntity)object0).timestamp : false;
    }

    @NotNull
    public final String getContents() {
        return this.contents;
    }

    public final int getHasMore() {
        return this.hasMore;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUid() {
        return this.uid;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.timestamp) + d.b(this.hasMore, x.b(d.b(this.type, x.b(this.uid * 0x1F, 0x1F, this.key), 0x1F), 0x1F, this.contents), 0x1F);
    }

    public final void setContents(@NotNull String s) {
        q.g(s, "<set-?>");
        this.contents = s;
    }

    public final void setHasMore(int v) {
        this.hasMore = v;
    }

    public final void setKey(@NotNull String s) {
        q.g(s, "<set-?>");
        this.key = s;
    }

    public final void setTimestamp(long v) {
        this.timestamp = v;
    }

    public final void setType(int v) {
        this.type = v;
    }

    public final void setUid(int v) {
        this.uid = v;
    }

    @Override
    @NotNull
    public String toString() {
        int v = this.type;
        String s = this.contents;
        int v1 = this.hasMore;
        long v2 = this.timestamp;
        StringBuilder stringBuilder0 = x.o(this.uid, "ResponseCacheEntity(uid=", ", key=", this.key, ", type=");
        stringBuilder0.append(v);
        stringBuilder0.append(", contents=");
        stringBuilder0.append(s);
        stringBuilder0.append(", hasMore=");
        stringBuilder0.append(v1);
        stringBuilder0.append(", timestamp=");
        stringBuilder0.append(v2);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

