package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J:\u0010\u000B\u001A\u00020\n2\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\t\u001A\u00020\bH¦@¢\u0006\u0004\b\u000B\u0010\fJ\u0080\u0001\u0010\u0018\u001A\u00020\n2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\r\u001A\u00020\u00062\b\b\u0002\u0010\u000E\u001A\u00020\b2\b\b\u0002\u0010\u000F\u001A\u00020\u00042\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001A\u00020\u00042\b\b\u0002\u0010\u0013\u001A\u00020\b2\b\b\u0002\u0010\u0015\u001A\u00020\u00142\b\b\u0002\u0010\u0016\u001A\u00020\b2\b\b\u0002\u0010\u0017\u001A\u00020\bH¦@¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/airbnb/lottie/compose/LottieAnimatable;", "Lcom/airbnb/lottie/compose/LottieAnimationState;", "Lcom/airbnb/lottie/LottieComposition;", "composition", "", "progress", "", "iteration", "", "resetLastFrameNanos", "Lie/H;", "snapTo", "(Lcom/airbnb/lottie/LottieComposition;FIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iterations", "reverseOnRepeat", "speed", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "clipSpec", "initialProgress", "continueFromPreviousAnimate", "Lcom/airbnb/lottie/compose/LottieCancellationBehavior;", "cancellationBehavior", "ignoreSystemAnimationsDisabled", "useCompositionFrameRate", "animate", "(Lcom/airbnb/lottie/LottieComposition;IIZFLcom/airbnb/lottie/compose/LottieClipSpec;FZLcom/airbnb/lottie/compose/LottieCancellationBehavior;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface LottieAnimatable extends LottieAnimationState {
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 0x30)
    public static final class DefaultImpls {
        public static Object animate$default(LottieAnimatable lottieAnimatable0, LottieComposition lottieComposition0, int v, int v1, boolean z, float f, LottieClipSpec lottieClipSpec0, float f1, boolean z1, LottieCancellationBehavior lottieCancellationBehavior0, boolean z2, boolean z3, Continuation continuation0, int v2, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animate");
            }
            int v3 = (v2 & 2) == 0 ? v : lottieAnimatable0.getIteration();
            int v4 = (v2 & 4) == 0 ? v1 : lottieAnimatable0.getIterations();
            boolean z4 = (v2 & 8) == 0 ? z : lottieAnimatable0.getReverseOnRepeat();
            float f2 = (v2 & 16) == 0 ? f : lottieAnimatable0.getSpeed();
            LottieClipSpec lottieClipSpec1 = (v2 & 0x20) == 0 ? lottieClipSpec0 : lottieAnimatable0.getClipSpec();
            float f3 = (v2 & 0x40) == 0 ? f1 : LottieAnimatableKt.access$defaultProgress(lottieComposition0, lottieClipSpec1, f2);
            boolean z5 = (v2 & 0x80) == 0 ? z1 : false;
            LottieCancellationBehavior lottieCancellationBehavior1 = (v2 & 0x100) == 0 ? lottieCancellationBehavior0 : LottieCancellationBehavior.Immediately;
            boolean z6 = (v2 & 0x200) == 0 ? z2 : false;
            return (v2 & 0x400) == 0 ? lottieAnimatable0.animate(lottieComposition0, v3, v4, z4, f2, lottieClipSpec1, f3, z5, lottieCancellationBehavior1, z6, z3, continuation0) : lottieAnimatable0.animate(lottieComposition0, v3, v4, z4, f2, lottieClipSpec1, f3, z5, lottieCancellationBehavior1, z6, false, continuation0);
        }

        public static long getLastFrameNanos(@NotNull LottieAnimatable lottieAnimatable0) {
            return 0x8000000000000000L;
        }

        public static Object snapTo$default(LottieAnimatable lottieAnimatable0, LottieComposition lottieComposition0, float f, int v, boolean z, Continuation continuation0, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: snapTo");
            }
            if((v1 & 1) != 0) {
                lottieComposition0 = lottieAnimatable0.getComposition();
            }
            if((v1 & 2) != 0) {
                f = lottieAnimatable0.getProgress();
            }
            if((v1 & 4) != 0) {
                v = lottieAnimatable0.getIteration();
            }
            if((v1 & 8) != 0) {
                z = (Float.compare(f, lottieAnimatable0.getProgress()) == 0 ? 1 : 0) ^ 1;
            }
            return lottieAnimatable0.snapTo(lottieComposition0, f, v, z, continuation0);
        }
    }

    @Nullable
    Object animate(@Nullable LottieComposition arg1, int arg2, int arg3, boolean arg4, float arg5, @Nullable LottieClipSpec arg6, float arg7, boolean arg8, @NotNull LottieCancellationBehavior arg9, boolean arg10, boolean arg11, @NotNull Continuation arg12);

    @Override  // com.airbnb.lottie.compose.LottieAnimationState
    Object getValue();

    @Nullable
    Object snapTo(@Nullable LottieComposition arg1, float arg2, int arg3, boolean arg4, @NotNull Continuation arg5);
}

