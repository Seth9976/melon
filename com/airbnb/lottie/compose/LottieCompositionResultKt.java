package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieComposition;
import d5.n;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0014\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"awaitOrNull", "Lcom/airbnb/lottie/LottieComposition;", "Lcom/airbnb/lottie/compose/LottieCompositionResult;", "(Lcom/airbnb/lottie/compose/LottieCompositionResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lottie-compose_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class LottieCompositionResultKt {
    @Nullable
    public static final Object awaitOrNull(@NotNull LottieCompositionResult lottieCompositionResult0, @NotNull Continuation continuation0) {
        com.airbnb.lottie.compose.LottieCompositionResultKt.awaitOrNull.1 lottieCompositionResultKt$awaitOrNull$10;
        if(continuation0 instanceof com.airbnb.lottie.compose.LottieCompositionResultKt.awaitOrNull.1) {
            lottieCompositionResultKt$awaitOrNull$10 = (com.airbnb.lottie.compose.LottieCompositionResultKt.awaitOrNull.1)continuation0;
            int v = lottieCompositionResultKt$awaitOrNull$10.label;
            if((v & 0x80000000) == 0) {
                lottieCompositionResultKt$awaitOrNull$10 = new c(continuation0) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return LottieCompositionResultKt.awaitOrNull(null, this);
                    }
                };
            }
            else {
                lottieCompositionResultKt$awaitOrNull$10.label = v ^ 0x80000000;
            }
        }
        else {
            lottieCompositionResultKt$awaitOrNull$10 = new c(continuation0) {
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return LottieCompositionResultKt.awaitOrNull(null, this);
                }
            };
        }
        Object object0 = lottieCompositionResultKt$awaitOrNull$10.result;
        a a0 = a.a;
        switch(lottieCompositionResultKt$awaitOrNull$10.label) {
            case 0: {
                n.D(object0);
                try {
                    lottieCompositionResultKt$awaitOrNull$10.label = 1;
                    object0 = lottieCompositionResult0.await(lottieCompositionResultKt$awaitOrNull$10);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return (LottieComposition)object0;
                }
                catch(Throwable unused_ex) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return null;
    }
}

