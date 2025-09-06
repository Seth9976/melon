package com.airbnb.lottie.compose;

import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.airbnb.lottie.LottieComposition;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001A\u000F\u0010\u0001\u001A\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001A\r\u0010\u0003\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u0014\u0010\u0006\u001A\u00020\u0005*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001A+\u0010\u000E\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/airbnb/lottie/compose/LottieAnimatable;", "rememberLottieAnimatable", "(Landroidx/compose/runtime/l;I)Lcom/airbnb/lottie/compose/LottieAnimatable;", "LottieAnimatable", "()Lcom/airbnb/lottie/compose/LottieAnimatable;", "Lie/H;", "resetToBeginning", "(Lcom/airbnb/lottie/compose/LottieAnimatable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/airbnb/lottie/LottieComposition;", "composition", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "clipSpec", "", "speed", "defaultProgress", "(Lcom/airbnb/lottie/LottieComposition;Lcom/airbnb/lottie/compose/LottieClipSpec;F)F", "lottie-compose_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class LottieAnimatableKt {
    @NotNull
    public static final LottieAnimatable LottieAnimatable() {
        return new LottieAnimatableImpl();
    }

    public static final float access$defaultProgress(LottieComposition lottieComposition0, LottieClipSpec lottieClipSpec0, float f) {
        return LottieAnimatableKt.defaultProgress(lottieComposition0, lottieClipSpec0, f);
    }

    private static final float defaultProgress(LottieComposition lottieComposition0, LottieClipSpec lottieClipSpec0, float f) {
        int v = Float.compare(f, 0.0f);
        if(v < 0 && lottieComposition0 == null) {
            return 1.0f;
        }
        if(lottieComposition0 == null) {
            return 0.0f;
        }
        if(v < 0) {
            return lottieClipSpec0 == null ? 1.0f : lottieClipSpec0.getMaxProgress$lottie_compose_release(lottieComposition0);
        }
        return lottieClipSpec0 == null ? 0.0f : lottieClipSpec0.getMinProgress$lottie_compose_release(lottieComposition0);
    }

    @NotNull
    public static final LottieAnimatable rememberLottieAnimatable(@Nullable l l0, int v) {
        ((p)l0).b0(0x78AB5FDA);
        ((p)l0).b0(-610207850);
        LottieAnimatable lottieAnimatable0 = ((p)l0).N();
        if(lottieAnimatable0 == k.a) {
            lottieAnimatable0 = LottieAnimatableKt.LottieAnimatable();
            ((p)l0).l0(lottieAnimatable0);
        }
        ((p)l0).p(false);
        ((p)l0).p(false);
        return lottieAnimatable0;
    }

    @Nullable
    public static final Object resetToBeginning(@NotNull LottieAnimatable lottieAnimatable0, @NotNull Continuation continuation0) {
        Object object0 = DefaultImpls.snapTo$default(lottieAnimatable0, null, LottieAnimatableKt.defaultProgress(lottieAnimatable0.getComposition(), lottieAnimatable0.getClipSpec(), lottieAnimatable0.getSpeed()), 1, false, continuation0, 9, null);
        return object0 == a.a ? object0 : H.a;
    }
}

