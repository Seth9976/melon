package com.facebook.internal.gatekeeper;

import H0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\t\u0010\f\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/gatekeeper/GateKeeper;", "", "name", "", "value", "", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getValue", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GateKeeper {
    @NotNull
    private final String name;
    private final boolean value;

    public GateKeeper(@NotNull String s, boolean z) {
        q.g(s, "name");
        super();
        this.name = s;
        this.value = z;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.value;
    }

    @NotNull
    public final GateKeeper copy(@NotNull String s, boolean z) {
        q.g(s, "name");
        return new GateKeeper(s, z);
    }

    public static GateKeeper copy$default(GateKeeper gateKeeper0, String s, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            s = gateKeeper0.name;
        }
        if((v & 2) != 0) {
            z = gateKeeper0.value;
        }
        return gateKeeper0.copy(s, z);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof GateKeeper)) {
            return false;
        }
        return q.b(this.name, ((GateKeeper)object0).name) ? this.value == ((GateKeeper)object0).value : false;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        int v = this.name.hashCode();
        int v1 = this.value;
        if(v1) {
            v1 = 1;
        }
        return v * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("GateKeeper(name=");
        stringBuilder0.append(this.name);
        stringBuilder0.append(", value=");
        return b.k(stringBuilder0, this.value, ')');
    }
}

