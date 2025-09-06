package com.kakaoent.trevi.ad.util;

import android.content.res.Resources;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0007\u001A\u0013\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A\u0013\u0010\u0004\u001A\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001A\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "", "dpToPxFloat", "(I)F", "dpToPx", "(I)I", "density", "F", "trevi-ad-android-sdk_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public abstract class NumberExtKt {
    private static final float density;

    static {
        NumberExtKt.density = Resources.getSystem().getDisplayMetrics().density;
    }

    public static final int dpToPx(int v) {
        return (int)NumberExtKt.dpToPxFloat(v);
    }

    public static final float dpToPxFloat(int v) {
        return ((float)v) * NumberExtKt.density;
    }
}

