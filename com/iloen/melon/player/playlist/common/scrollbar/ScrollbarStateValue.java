package com.iloen.melon.player.playlist.common.scrollbar;

import H0.b;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001A\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u001A\u0010\u0012\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarStateValue;", "", "", "packedValue", "constructor-impl", "(J)J", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "", "hashCode-impl", "(J)I", "hashCode", "other", "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ScrollbarStateValue {
    public final long a;

    public ScrollbarStateValue(long v) {
        this.a = v;
    }

    public static final ScrollbarStateValue box-impl(long v) {
        return new ScrollbarStateValue(v);
    }

    public static long constructor-impl(long v) [...] // Inlined contents

    @Override
    public boolean equals(Object object0) {
        return ScrollbarStateValue.equals-impl(this.a, object0);
    }

    public static boolean equals-impl(long v, Object object0) {
        return object0 instanceof ScrollbarStateValue ? v == ((ScrollbarStateValue)object0).unbox-impl() : false;
    }

    public static final boolean equals-impl0(long v, long v1) {
        return v == v1;
    }

    @Override
    public int hashCode() {
        return ScrollbarStateValue.hashCode-impl(this.a);
    }

    public static int hashCode-impl(long v) {
        return Long.hashCode(v);
    }

    @Override
    public String toString() {
        return ScrollbarStateValue.toString-impl(this.a);
    }

    public static String toString-impl(long v) {
        return b.g(v, "ScrollbarStateValue(packedValue=", ")");
    }

    public final long unbox-impl() {
        return this.a;
    }
}

