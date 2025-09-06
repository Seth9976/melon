package com.airbnb.lottie.compose;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import r0.q;
import x0.e;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A#\u0010\u0004\u001A\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u001F\u0010\f\u001A\u00020\t*\u00020\u00062\u0006\u0010\b\u001A\u00020\u0007H\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000B\u0082\u0002\u0007\n\u0005\b¡\u001E0\u0001¨\u0006\r"}, d2 = {"Lr0/q;", "", "width", "height", "lottieSize", "(Lr0/q;II)Lr0/q;", "Lx0/e;", "LN0/e0;", "scale", "Lr1/l;", "times-UQTWf7w", "(JJ)J", "times", "lottie-compose_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class LottieAnimationSizeNodeKt {
    @NotNull
    public static final q lottieSize(@NotNull q q0, int v, int v1) {
        kotlin.jvm.internal.q.g(q0, "<this>");
        return q0.then(new LottieAnimationSizeElement(v, v1));
    }

    private static final long times-UQTWf7w(long v, long v1) {
        return ((long)(((int)(Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))) * e.b(v))))) & 0xFFFFFFFFL | ((long)(((int)(Float.intBitsToFloat(((int)(v1 >> 0x20))) * e.d(v))))) << 0x20;
    }
}

