package com.kakaoent.trevi.ad.domain;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000B\u0010\u0007\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001A\u00020\rHÖ\u0001J\t\u0010\u000E\u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000F"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/TreviApply;", "", "ask", "", "(Ljava/lang/String;)V", "getAsk", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviApply {
    @Nullable
    private final String ask;

    public TreviApply() {
        this(null, 1, null);
    }

    public TreviApply(@Nullable String s) {
        this.ask = s;
    }

    public TreviApply(String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        this(s);
    }

    @Nullable
    public final String component1() {
        return this.ask;
    }

    @NotNull
    public final TreviApply copy(@Nullable String s) {
        return new TreviApply(s);
    }

    public static TreviApply copy$default(TreviApply treviApply0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = treviApply0.ask;
        }
        return treviApply0.copy(s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof TreviApply ? q.b(this.ask, ((TreviApply)object0).ask) : false;
    }

    @Nullable
    public final String getAsk() {
        return this.ask;
    }

    @Override
    public int hashCode() {
        return this.ask == null ? 0 : this.ask.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return o.r(new StringBuilder("TreviApply(ask="), this.ask, ')');
    }
}

