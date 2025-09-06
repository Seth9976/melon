package com.iloen.melon.userstore.entity;

import U4.x;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0017\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\b\u0010\tB\t\b\u0016¢\u0006\u0004\b\b\u0010\nJ\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J1\u0010\u001B\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00052\b\b\u0003\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020 HÖ\u0001J\t\u0010!\u001A\u00020\u0005HÖ\u0001R\u001E\u0010\u0002\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001E\u0010\u0006\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001E\u0010\u0007\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000E¨\u0006\""}, d2 = {"Lcom/iloen/melon/userstore/entity/TagEntity;", "", "uid", "", "tagSeq", "", "tagName", "timestamp", "<init>", "(JLjava/lang/String;Ljava/lang/String;J)V", "()V", "getUid", "()J", "setUid", "(J)V", "getTagSeq", "()Ljava/lang/String;", "setTagSeq", "(Ljava/lang/String;)V", "getTagName", "setTagName", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TagEntity {
    public static final int $stable = 8;
    @NotNull
    private String tagName;
    @NotNull
    private String tagSeq;
    private long timestamp;
    private long uid;

    public TagEntity() {
        this(0L, "", "", 0L);
    }

    public TagEntity(long v, @NotNull String s, @NotNull String s1, long v1) {
        q.g(s, "tagSeq");
        q.g(s1, "tagName");
        super();
        this.uid = v;
        this.tagSeq = s;
        this.tagName = s1;
        this.timestamp = v1;
    }

    public TagEntity(long v, String s, String s1, long v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v2 & 8) != 0) {
            v1 = 0L;
        }
        this(v, s, s1, v1);
    }

    public final long component1() {
        return this.uid;
    }

    @NotNull
    public final String component2() {
        return this.tagSeq;
    }

    @NotNull
    public final String component3() {
        return this.tagName;
    }

    public final long component4() {
        return this.timestamp;
    }

    @NotNull
    public final TagEntity copy(long v, @NotNull String s, @NotNull String s1, long v1) {
        q.g(s, "tagSeq");
        q.g(s1, "tagName");
        return new TagEntity(v, s, s1, v1);
    }

    public static TagEntity copy$default(TagEntity tagEntity0, long v, String s, String s1, long v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = tagEntity0.uid;
        }
        if((v2 & 2) != 0) {
            s = tagEntity0.tagSeq;
        }
        if((v2 & 4) != 0) {
            s1 = tagEntity0.tagName;
        }
        if((v2 & 8) != 0) {
            v1 = tagEntity0.timestamp;
        }
        return tagEntity0.copy(v, s, s1, v1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TagEntity)) {
            return false;
        }
        if(this.uid != ((TagEntity)object0).uid) {
            return false;
        }
        if(!q.b(this.tagSeq, ((TagEntity)object0).tagSeq)) {
            return false;
        }
        return q.b(this.tagName, ((TagEntity)object0).tagName) ? this.timestamp == ((TagEntity)object0).timestamp : false;
    }

    @NotNull
    public final String getTagName() [...] // 潜在的解密器

    @NotNull
    public final String getTagSeq() [...] // 潜在的解密器

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final long getUid() {
        return this.uid;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.timestamp) + x.b(x.b(Long.hashCode(this.uid) * 0x1F, 0x1F, this.tagSeq), 0x1F, this.tagName);
    }

    public final void setTagName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.tagName = s;
    }

    public final void setTagSeq(@NotNull String s) {
        q.g(s, "<set-?>");
        this.tagSeq = s;
    }

    public final void setTimestamp(long v) {
        this.timestamp = v;
    }

    public final void setUid(long v) {
        this.uid = v;
    }

    @Override
    @NotNull
    public String toString() {
        long v = this.uid;
        String s = this.tagSeq;
        String s1 = this.tagName;
        long v1 = this.timestamp;
        StringBuilder stringBuilder0 = new StringBuilder("TagEntity(uid=");
        stringBuilder0.append(v);
        stringBuilder0.append(", tagSeq=");
        stringBuilder0.append(s);
        e.g(stringBuilder0, ", tagName=", s1, ", timestamp=");
        return x.h(v1, ")", stringBuilder0);
    }
}

