package com.melon.data.database.entity;

import A7.d;
import U4.x;
import androidx.annotation.Keep;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u001A\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nB\t\b\u0016¢\u0006\u0004\b\t\u0010\u000BJ\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0006HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0006HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0006HÆ\u0003J;\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\u0006HÆ\u0001J\u0013\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001A\u00020\u0003HÖ\u0001J\t\u0010$\u001A\u00020\u0006HÖ\u0001R\u001E\u0010\u0002\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001E\u0010\u0004\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000FR\u001E\u0010\u0005\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001E\u0010\u0007\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001E\u0010\b\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015¨\u0006%"}, d2 = {"Lcom/melon/data/database/entity/UserEqualizerEntity;", "", "uid", "", "eqType", "name", "", "eqValues", "range", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "getUid", "()I", "setUid", "(I)V", "getEqType", "setEqType", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getEqValues", "setEqValues", "getRange", "setRange", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class UserEqualizerEntity {
    public static final int $stable = 8;
    private int eqType;
    @NotNull
    private String eqValues;
    @NotNull
    private String name;
    @NotNull
    private String range;
    private int uid;

    public UserEqualizerEntity() {
        this(0, 0, "", "", "");
    }

    public UserEqualizerEntity(int v, int v1, @NotNull String s, @NotNull String s1, @NotNull String s2) {
        q.g(s, "name");
        q.g(s1, "eqValues");
        q.g(s2, "range");
        super();
        this.uid = v;
        this.eqType = v1;
        this.name = s;
        this.eqValues = s1;
        this.range = s2;
    }

    public final int component1() {
        return this.uid;
    }

    public final int component2() {
        return this.eqType;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final String component4() {
        return this.eqValues;
    }

    @NotNull
    public final String component5() {
        return this.range;
    }

    @NotNull
    public final UserEqualizerEntity copy(int v, int v1, @NotNull String s, @NotNull String s1, @NotNull String s2) {
        q.g(s, "name");
        q.g(s1, "eqValues");
        q.g(s2, "range");
        return new UserEqualizerEntity(v, v1, s, s1, s2);
    }

    public static UserEqualizerEntity copy$default(UserEqualizerEntity userEqualizerEntity0, int v, int v1, String s, String s1, String s2, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = userEqualizerEntity0.uid;
        }
        if((v2 & 2) != 0) {
            v1 = userEqualizerEntity0.eqType;
        }
        if((v2 & 4) != 0) {
            s = userEqualizerEntity0.name;
        }
        if((v2 & 8) != 0) {
            s1 = userEqualizerEntity0.eqValues;
        }
        if((v2 & 16) != 0) {
            s2 = userEqualizerEntity0.range;
        }
        return userEqualizerEntity0.copy(v, v1, s, s1, s2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof UserEqualizerEntity)) {
            return false;
        }
        if(this.uid != ((UserEqualizerEntity)object0).uid) {
            return false;
        }
        if(this.eqType != ((UserEqualizerEntity)object0).eqType) {
            return false;
        }
        if(!q.b(this.name, ((UserEqualizerEntity)object0).name)) {
            return false;
        }
        return q.b(this.eqValues, ((UserEqualizerEntity)object0).eqValues) ? q.b(this.range, ((UserEqualizerEntity)object0).range) : false;
    }

    public final int getEqType() {
        return this.eqType;
    }

    @NotNull
    public final String getEqValues() {
        return this.eqValues;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getRange() {
        return this.range;
    }

    public final int getUid() {
        return this.uid;
    }

    @Override
    public int hashCode() {
        return this.range.hashCode() + x.b(x.b(d.b(this.eqType, this.uid * 0x1F, 0x1F), 0x1F, this.name), 0x1F, this.eqValues);
    }

    public final void setEqType(int v) {
        this.eqType = v;
    }

    public final void setEqValues(@NotNull String s) {
        q.g(s, "<set-?>");
        this.eqValues = s;
    }

    public final void setName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.name = s;
    }

    public final void setRange(@NotNull String s) {
        q.g(s, "<set-?>");
        this.range = s;
    }

    public final void setUid(int v) {
        this.uid = v;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.name;
        String s1 = this.eqValues;
        String s2 = this.range;
        StringBuilder stringBuilder0 = o.t(this.uid, this.eqType, "UserEqualizerEntity(uid=", ", eqType=", ", name=");
        d.u(stringBuilder0, s, ", eqValues=", s1, ", range=");
        return x.m(stringBuilder0, s2, ")");
    }
}

