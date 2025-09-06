package com.iloen.melon.player.playlist.common.scrollbar;

import H0.b;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\b\b\u0083@\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u000F\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\r\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u0011\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u001A\u0010\u0016\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001A\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A\u0088\u0001\b\u0092\u0001\u00020\u0007¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarTrack;", "", "", "max", "min", "constructor-impl", "(FF)J", "", "packedValue", "(J)J", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "", "hashCode-impl", "(J)I", "hashCode", "other", "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "a", "J", "getPackedValue", "()J", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
final class ScrollbarTrack {
    public final long a;

    public ScrollbarTrack(long v) {
        this.a = v;
    }

    public static final ScrollbarTrack box-impl(long v) {
        return new ScrollbarTrack(v);
    }

    public static long constructor-impl(float f, float f1) {
        return ((long)Float.floatToRawIntBits(f1)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f)) << 0x20;
    }

    public static long constructor-impl(long v) [...] // Inlined contents

    @Override
    public boolean equals(Object object0) {
        return ScrollbarTrack.equals-impl(this.a, object0);
    }

    public static boolean equals-impl(long v, Object object0) {
        return object0 instanceof ScrollbarTrack ? v == ((ScrollbarTrack)object0).unbox-impl() : false;
    }

    public static final boolean equals-impl0(long v, long v1) {
        return v == v1;
    }

    public final long getPackedValue() {
        return this.a;
    }

    @Override
    public int hashCode() {
        return ScrollbarTrack.hashCode-impl(this.a);
    }

    public static int hashCode-impl(long v) {
        return Long.hashCode(v);
    }

    @Override
    public String toString() {
        return ScrollbarTrack.toString-impl(this.a);
    }

    public static String toString-impl(long v) {
        return b.g(v, "ScrollbarTrack(packedValue=", ")");
    }

    public final long unbox-impl() {
        return this.a;
    }
}

