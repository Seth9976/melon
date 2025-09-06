package com.airbnb.lottie.compose;

import androidx.compose.runtime.b1;
import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\bg\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001A\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000B\u001A\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\r\u001A\u00020\f8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\f8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u000ER\u0014\u0010\u0010\u001A\u00020\f8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u000ER\u0014\u0010\u0011\u001A\u00020\f8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000E¨\u0006\u0012"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionResult;", "Landroidx/compose/runtime/b1;", "Lcom/airbnb/lottie/LottieComposition;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getValue", "()Lcom/airbnb/lottie/LottieComposition;", "value", "", "getError", "()Ljava/lang/Throwable;", "error", "", "isLoading", "()Z", "isComplete", "isFailure", "isSuccess", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface LottieCompositionResult extends b1 {
    @Nullable
    Object await(@NotNull Continuation arg1);

    @Nullable
    Throwable getError();

    @Nullable
    LottieComposition getValue();

    @Override  // androidx.compose.runtime.b1
    Object getValue();

    boolean isComplete();

    boolean isFailure();

    boolean isLoading();

    boolean isSuccess();
}

