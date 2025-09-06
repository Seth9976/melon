package com.iloen.melon.userstore.entity;

import U4.x;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;
import y9.c;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0011\b\u0087\b\u0018\u0000 \'2\u00020\u0001:\u0001(B1\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0001\u0010\u0006\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0002¢\u0006\u0004\b\b\u0010\tB\t\b\u0016¢\u0006\u0004\b\b\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000F\u0010\u000EJ\u0010\u0010\u0010\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJ8\u0010\u0011\u001A\u00020\u00002\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0003\u0010\u0005\u001A\u00020\u00042\b\b\u0003\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u000EJ\u0010\u0010\u0015\u001A\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001A\u0010\u0019\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001AR\"\u0010\u0003\u001A\u00020\u00028\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0003\u0010\u001B\u001A\u0004\b\u001C\u0010\f\"\u0004\b\u001D\u0010\u001ER\"\u0010\u0005\u001A\u00020\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0005\u0010\u001F\u001A\u0004\b \u0010\u000E\"\u0004\b!\u0010\"R\"\u0010\u0006\u001A\u00020\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0006\u0010\u001F\u001A\u0004\b#\u0010\u000E\"\u0004\b$\u0010\"R\"\u0010\u0007\u001A\u00020\u00028\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0007\u0010\u001B\u001A\u0004\b%\u0010\f\"\u0004\b&\u0010\u001E¨\u0006)"}, d2 = {"Lcom/iloen/melon/userstore/entity/RestoreDataEntity;", "", "", "uid", "", "restore_id", "data", "timestamp", "<init>", "(JLjava/lang/String;Ljava/lang/String;J)V", "()V", "component1", "()J", "component2", "()Ljava/lang/String;", "component3", "component4", "copy", "(JLjava/lang/String;Ljava/lang/String;J)Lcom/iloen/melon/userstore/entity/RestoreDataEntity;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getUid", "setUid", "(J)V", "Ljava/lang/String;", "getRestore_id", "setRestore_id", "(Ljava/lang/String;)V", "getData", "setData", "getTimestamp", "setTimestamp", "Companion", "y9/c", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RestoreDataEntity {
    public static final int $stable = 8;
    @NotNull
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `restore_data` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `restore_id` TEXT NOT NULL, `data` TEXT NOT NULL, `timestamp` INTEGER NOT NULL)";
    @NotNull
    public static final c Companion = null;
    @NotNull
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS `restore_data`";
    @NotNull
    private String data;
    @NotNull
    private String restore_id;
    private long timestamp;
    private long uid;

    static {
        RestoreDataEntity.Companion = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public RestoreDataEntity() {
        this(0L, "", "", 0L, 8, null);
    }

    public RestoreDataEntity(long v, @NotNull String s, @NotNull String s1, long v1) {
        q.g(s, "restore_id");
        q.g(s1, "data");
        super();
        this.uid = v;
        this.restore_id = s;
        this.data = s1;
        this.timestamp = v1;
    }

    public RestoreDataEntity(long v, String s, String s1, long v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v2 & 8) != 0) {
            v1 = System.currentTimeMillis();
        }
        this(v, s, s1, v1);
    }

    public final long component1() {
        return this.uid;
    }

    @NotNull
    public final String component2() {
        return this.restore_id;
    }

    @NotNull
    public final String component3() {
        return this.data;
    }

    public final long component4() {
        return this.timestamp;
    }

    @NotNull
    public final RestoreDataEntity copy(long v, @NotNull String s, @NotNull String s1, long v1) {
        q.g(s, "restore_id");
        q.g(s1, "data");
        return new RestoreDataEntity(v, s, s1, v1);
    }

    public static RestoreDataEntity copy$default(RestoreDataEntity restoreDataEntity0, long v, String s, String s1, long v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = restoreDataEntity0.uid;
        }
        if((v2 & 2) != 0) {
            s = restoreDataEntity0.restore_id;
        }
        if((v2 & 4) != 0) {
            s1 = restoreDataEntity0.data;
        }
        if((v2 & 8) != 0) {
            v1 = restoreDataEntity0.timestamp;
        }
        return restoreDataEntity0.copy(v, s, s1, v1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof RestoreDataEntity)) {
            return false;
        }
        if(this.uid != ((RestoreDataEntity)object0).uid) {
            return false;
        }
        if(!q.b(this.restore_id, ((RestoreDataEntity)object0).restore_id)) {
            return false;
        }
        return q.b(this.data, ((RestoreDataEntity)object0).data) ? this.timestamp == ((RestoreDataEntity)object0).timestamp : false;
    }

    @NotNull
    public final String getData() [...] // 潜在的解密器

    @NotNull
    public final String getRestore_id() [...] // 潜在的解密器

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final long getUid() {
        return this.uid;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.timestamp) + x.b(x.b(Long.hashCode(this.uid) * 0x1F, 0x1F, this.restore_id), 0x1F, this.data);
    }

    public final void setData(@NotNull String s) {
        q.g(s, "<set-?>");
        this.data = s;
    }

    public final void setRestore_id(@NotNull String s) {
        q.g(s, "<set-?>");
        this.restore_id = s;
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
        String s = this.restore_id;
        String s1 = this.data;
        long v1 = this.timestamp;
        StringBuilder stringBuilder0 = new StringBuilder("RestoreDataEntity(uid=");
        stringBuilder0.append(v);
        stringBuilder0.append(", restore_id=");
        stringBuilder0.append(s);
        e.g(stringBuilder0, ", data=", s1, ", timestamp=");
        return x.h(v1, ")", stringBuilder0);
    }
}

