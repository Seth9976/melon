package com.iloen.melon.userstore.entity;

import H0.b;
import U4.x;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nB\t\b\u0016¢\u0006\u0004\b\t\u0010\u000BJ\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001D\u001A\u00020\bHÆ\u0003J1\u0010\u001E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001A\u00020\u0003HÖ\u0001J\t\u0010#\u001A\u00020\u0005HÖ\u0001R\u001E\u0010\u0002\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001E\u0010\u0006\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001E\u0010\u0007\u001A\u00020\b8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/iloen/melon/userstore/entity/TabMenuShortcutEntity;", "", "uid", "", "menuSeq", "", "memberKey", "timestamp", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;J)V", "()V", "getUid", "()I", "setUid", "(I)V", "getMenuSeq", "()Ljava/lang/String;", "setMenuSeq", "(Ljava/lang/String;)V", "getMemberKey", "setMemberKey", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TabMenuShortcutEntity {
    public static final int $stable = 8;
    @NotNull
    private String memberKey;
    @NotNull
    private String menuSeq;
    private long timestamp;
    private int uid;

    public TabMenuShortcutEntity() {
        this(0, "", "", 0L);
    }

    public TabMenuShortcutEntity(int v, @NotNull String s, @NotNull String s1, long v1) {
        q.g(s, "menuSeq");
        q.g(s1, "memberKey");
        super();
        this.uid = v;
        this.menuSeq = s;
        this.memberKey = s1;
        this.timestamp = v1;
    }

    public TabMenuShortcutEntity(int v, String s, String s1, long v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v2 & 8) != 0) {
            v1 = 0L;
        }
        this(v, s, s1, v1);
    }

    public final int component1() {
        return this.uid;
    }

    @NotNull
    public final String component2() {
        return this.menuSeq;
    }

    @NotNull
    public final String component3() {
        return this.memberKey;
    }

    public final long component4() {
        return this.timestamp;
    }

    @NotNull
    public final TabMenuShortcutEntity copy(int v, @NotNull String s, @NotNull String s1, long v1) {
        q.g(s, "menuSeq");
        q.g(s1, "memberKey");
        return new TabMenuShortcutEntity(v, s, s1, v1);
    }

    public static TabMenuShortcutEntity copy$default(TabMenuShortcutEntity tabMenuShortcutEntity0, int v, String s, String s1, long v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = tabMenuShortcutEntity0.uid;
        }
        if((v2 & 2) != 0) {
            s = tabMenuShortcutEntity0.menuSeq;
        }
        if((v2 & 4) != 0) {
            s1 = tabMenuShortcutEntity0.memberKey;
        }
        if((v2 & 8) != 0) {
            v1 = tabMenuShortcutEntity0.timestamp;
        }
        return tabMenuShortcutEntity0.copy(v, s, s1, v1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TabMenuShortcutEntity)) {
            return false;
        }
        if(this.uid != ((TabMenuShortcutEntity)object0).uid) {
            return false;
        }
        if(!q.b(this.menuSeq, ((TabMenuShortcutEntity)object0).menuSeq)) {
            return false;
        }
        return q.b(this.memberKey, ((TabMenuShortcutEntity)object0).memberKey) ? this.timestamp == ((TabMenuShortcutEntity)object0).timestamp : false;
    }

    @NotNull
    public final String getMemberKey() [...] // 潜在的解密器

    @NotNull
    public final String getMenuSeq() [...] // 潜在的解密器

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getUid() {
        return this.uid;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.timestamp) + x.b(x.b(this.uid * 0x1F, 0x1F, this.menuSeq), 0x1F, this.memberKey);
    }

    public final void setMemberKey(@NotNull String s) {
        q.g(s, "<set-?>");
        this.memberKey = s;
    }

    public final void setMenuSeq(@NotNull String s) {
        q.g(s, "<set-?>");
        this.menuSeq = s;
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
        String s = this.memberKey;
        long v = this.timestamp;
        StringBuilder stringBuilder0 = x.o(this.uid, "TabMenuShortcutEntity(uid=", ", menuSeq=", this.menuSeq, ", memberKey=");
        b.t(v, s, ", timestamp=", stringBuilder0);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

