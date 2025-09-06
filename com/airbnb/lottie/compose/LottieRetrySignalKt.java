package com.airbnb.lottie.compose;

import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u000F\u0010\u0001\u001A\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/airbnb/lottie/compose/LottieRetrySignal;", "rememberLottieRetrySignal", "(Landroidx/compose/runtime/l;I)Lcom/airbnb/lottie/compose/LottieRetrySignal;", "lottie-compose_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class LottieRetrySignalKt {
    @NotNull
    public static final LottieRetrySignal rememberLottieRetrySignal(@Nullable l l0, int v) {
        ((p)l0).b0(0xB48108EA);
        ((p)l0).b0(1025108850);
        LottieRetrySignal lottieRetrySignal0 = ((p)l0).N();
        if(lottieRetrySignal0 == k.a) {
            lottieRetrySignal0 = new LottieRetrySignal();
            ((p)l0).l0(lottieRetrySignal0);
        }
        ((p)l0).p(false);
        ((p)l0).p(false);
        return lottieRetrySignal0;
    }
}

