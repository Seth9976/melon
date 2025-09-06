package com.airbnb.lottie.compose;

import android.content.Context;
import androidx.compose.runtime.J;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001Au\u0010\u0011\u001A\u00020\u00102\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00022\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\n2\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u00022\b\b\u0002\u0010\u000F\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014²\u0006\u000E\u0010\u0013\u001A\u00020\u00028\n@\nX\u008A\u008E\u0002"}, d2 = {"Lcom/airbnb/lottie/LottieComposition;", "composition", "", "isPlaying", "restartOnPlay", "reverseOnRepeat", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "clipSpec", "", "speed", "", "iterations", "Lcom/airbnb/lottie/compose/LottieCancellationBehavior;", "cancellationBehavior", "ignoreSystemAnimatorScale", "useCompositionFrameRate", "Lcom/airbnb/lottie/compose/LottieAnimationState;", "animateLottieCompositionAsState", "(Lcom/airbnb/lottie/LottieComposition;ZZZLcom/airbnb/lottie/compose/LottieClipSpec;FILcom/airbnb/lottie/compose/LottieCancellationBehavior;ZZLandroidx/compose/runtime/l;II)Lcom/airbnb/lottie/compose/LottieAnimationState;", "wasPlaying", "lottie-compose_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class AnimateLottieCompositionAsStateKt {
    @NotNull
    public static final LottieAnimationState animateLottieCompositionAsState(@Nullable LottieComposition lottieComposition0, boolean z, boolean z1, boolean z2, @Nullable LottieClipSpec lottieClipSpec0, float f, int v, @Nullable LottieCancellationBehavior lottieCancellationBehavior0, boolean z3, boolean z4, @Nullable l l0, int v1, int v2) {
        ((p)l0).b0(0x28BFD0F4);
        boolean z5 = (v2 & 2) == 0 ? z : true;
        LottieClipSpec lottieClipSpec1 = (v2 & 16) == 0 ? lottieClipSpec0 : null;
        float f1 = (v2 & 0x20) == 0 ? f : 1.0f;
        int v3 = (v2 & 0x40) == 0 ? v : 1;
        LottieCancellationBehavior lottieCancellationBehavior1 = (v2 & 0x80) == 0 ? lottieCancellationBehavior0 : LottieCancellationBehavior.Immediately;
        if(v3 <= 0) {
            throw new IllegalArgumentException(("Iterations must be a positive number (" + v3 + ").").toString());
        }
        if(Float.isInfinite(f1) || Float.isNaN(f1)) {
            throw new IllegalArgumentException(("Speed must be a finite number. It is " + f1 + ".").toString());
        }
        LottieAnimationState lottieAnimationState0 = LottieAnimatableKt.rememberLottieAnimatable(((p)l0), 0);
        ((p)l0).b0(-180606964);
        b0 b00 = ((p)l0).N();
        if(b00 == k.a) {
            b00 = w.s(Boolean.valueOf(z5));
            ((p)l0).l0(b00);
        }
        ((p)l0).p(false);
        ((p)l0).b0(-180606834);
        if(!((v2 & 0x100) == 0 ? z3 : false)) {
            f1 /= Utils.getAnimationScale(((Context)((p)l0).k(AndroidCompositionLocals_androidKt.b)));
        }
        ((p)l0).p(false);
        com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState.3 animateLottieCompositionAsStateKt$animateLottieCompositionAsState$30 = new n(z5, ((v2 & 4) == 0 ? z1 : true), ((LottieAnimatable)lottieAnimationState0), lottieComposition0, v3, ((v2 & 8) == 0 ? z2 : false), f1, lottieClipSpec1, lottieCancellationBehavior1, ((v2 & 0x200) == 0 ? z4 : false), b00, null) {
            final float $actualSpeed;
            final LottieAnimatable $animatable;
            final LottieCancellationBehavior $cancellationBehavior;
            final LottieClipSpec $clipSpec;
            final LottieComposition $composition;
            final boolean $isPlaying;
            final int $iterations;
            final boolean $restartOnPlay;
            final boolean $reverseOnRepeat;
            final boolean $useCompositionFrameRate;
            final b0 $wasPlaying$delegate;
            int label;

            {
                this.$isPlaying = z;
                this.$restartOnPlay = z1;
                this.$animatable = lottieAnimatable0;
                this.$composition = lottieComposition0;
                this.$iterations = v;
                this.$reverseOnRepeat = z2;
                this.$actualSpeed = f;
                this.$clipSpec = lottieClipSpec0;
                this.$cancellationBehavior = lottieCancellationBehavior0;
                this.$useCompositionFrameRate = z3;
                this.$wasPlaying$delegate = b00;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState.3(this.$isPlaying, this.$restartOnPlay, this.$animatable, this.$composition, this.$iterations, this.$reverseOnRepeat, this.$actualSpeed, this.$clipSpec, this.$cancellationBehavior, this.$useCompositionFrameRate, this.$wasPlaying$delegate, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope0, @Nullable Continuation continuation0) {
                return ((com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                a a0 = a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        if(this.$isPlaying && !AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState$lambda$3(this.$wasPlaying$delegate) && this.$restartOnPlay) {
                            this.label = 1;
                            if(LottieAnimatableKt.resetToBeginning(this.$animatable, this) == a0) {
                                return a0;
                            }
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        d5.n.D(object0);
                        return h0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState$lambda$4(this.$wasPlaying$delegate, this.$isPlaying);
                if(!this.$isPlaying) {
                    return h0;
                }
                float f = this.$animatable.getProgress();
                this.label = 2;
                return DefaultImpls.animate$default(this.$animatable, this.$composition, 0, this.$iterations, this.$reverseOnRepeat, this.$actualSpeed, this.$clipSpec, f, false, this.$cancellationBehavior, false, this.$useCompositionFrameRate, this, 0x202, null) == a0 ? a0 : h0;
            }
        };
        J.g(new Object[]{lottieComposition0, Boolean.valueOf(z5), lottieClipSpec1, f1, v3}, animateLottieCompositionAsStateKt$animateLottieCompositionAsState$30, ((p)l0));
        ((p)l0).p(false);
        return lottieAnimationState0;
    }

    private static final boolean animateLottieCompositionAsState$lambda$3(b0 b00) {
        return ((Boolean)b00.getValue()).booleanValue();
    }

    private static final void animateLottieCompositionAsState$lambda$4(b0 b00, boolean z) {
        b00.setValue(Boolean.valueOf(z));
    }
}

