package com.airbnb.lottie.compose;

import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.w;
import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001A\u00020\u0004H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\fH\u0000¢\u0006\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R/\u0010\u001A\u001A\u0004\u0018\u00010\u00042\b\u0010\u0014\u001A\u0004\u0018\u00010\u00048V@RX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\nR/\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u0014\u001A\u0004\u0018\u00010\f8V@RX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u001B\u0010\u0016\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u000FR\u001B\u0010\"\u001A\u00020\u001F8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#R\u001B\u0010%\u001A\u00020\u001F8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010!\u001A\u0004\b%\u0010#R\u001B\u0010\'\u001A\u00020\u001F8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001A\u0004\b\'\u0010#R\u001B\u0010)\u001A\u00020\u001F8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010!\u001A\u0004\b)\u0010#¨\u0006*"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionResultImpl;", "Lcom/airbnb/lottie/compose/LottieCompositionResult;", "<init>", "()V", "Lcom/airbnb/lottie/LottieComposition;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "composition", "Lie/H;", "complete$lottie_compose_release", "(Lcom/airbnb/lottie/LottieComposition;)V", "complete", "", "error", "completeExceptionally$lottie_compose_release", "(Ljava/lang/Throwable;)V", "completeExceptionally", "Lkotlinx/coroutines/CompletableDeferred;", "compositionDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "<set-?>", "value$delegate", "Landroidx/compose/runtime/b0;", "getValue", "()Lcom/airbnb/lottie/LottieComposition;", "setValue", "value", "error$delegate", "getError", "()Ljava/lang/Throwable;", "setError", "", "isLoading$delegate", "Landroidx/compose/runtime/b1;", "isLoading", "()Z", "isComplete$delegate", "isComplete", "isFailure$delegate", "isFailure", "isSuccess$delegate", "isSuccess", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class LottieCompositionResultImpl implements LottieCompositionResult {
    public static final int $stable;
    @NotNull
    private final CompletableDeferred compositionDeferred;
    @NotNull
    private final b0 error$delegate;
    @NotNull
    private final b1 isComplete$delegate;
    @NotNull
    private final b1 isFailure$delegate;
    @NotNull
    private final b1 isLoading$delegate;
    @NotNull
    private final b1 isSuccess$delegate;
    @NotNull
    private final b0 value$delegate;

    public LottieCompositionResultImpl() {
        this.compositionDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.value$delegate = w.s(null);
        this.error$delegate = w.s(null);
        this.isLoading$delegate = w.i(new a() {
            {
                LottieCompositionResultImpl.this = lottieCompositionResultImpl0;
                super(0);
            }

            @NotNull
            public final Boolean invoke() {
                return LottieCompositionResultImpl.this.getValue() != null || LottieCompositionResultImpl.this.getError() != null ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
        this.isComplete$delegate = w.i(new a() {
            {
                LottieCompositionResultImpl.this = lottieCompositionResultImpl0;
                super(0);
            }

            @NotNull
            public final Boolean invoke() {
                return LottieCompositionResultImpl.this.getValue() != null || LottieCompositionResultImpl.this.getError() != null;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
        this.isFailure$delegate = w.i(new a() {
            {
                LottieCompositionResultImpl.this = lottieCompositionResultImpl0;
                super(0);
            }

            @NotNull
            public final Boolean invoke() {
                return LottieCompositionResultImpl.this.getError() == null ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
        this.isSuccess$delegate = w.i(new a() {
            {
                LottieCompositionResultImpl.this = lottieCompositionResultImpl0;
                super(0);
            }

            @NotNull
            public final Boolean invoke() {
                return LottieCompositionResultImpl.this.getValue() == null ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    @Override  // com.airbnb.lottie.compose.LottieCompositionResult
    @Nullable
    public Object await(@NotNull Continuation continuation0) {
        return this.compositionDeferred.await(continuation0);
    }

    public final void complete$lottie_compose_release(@NotNull LottieComposition lottieComposition0) {
        synchronized(this) {
            q.g(lottieComposition0, "composition");
            if(this.isComplete()) {
                return;
            }
            this.setValue(lottieComposition0);
            this.compositionDeferred.complete(lottieComposition0);
        }
    }

    public final void completeExceptionally$lottie_compose_release(@NotNull Throwable throwable0) {
        synchronized(this) {
            q.g(throwable0, "error");
            if(this.isComplete()) {
                return;
            }
            this.setError(throwable0);
            this.compositionDeferred.completeExceptionally(throwable0);
        }
    }

    @Override  // com.airbnb.lottie.compose.LottieCompositionResult
    @Nullable
    public Throwable getError() {
        return (Throwable)this.error$delegate.getValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieCompositionResult
    @Nullable
    public LottieComposition getValue() {
        return (LottieComposition)this.value$delegate.getValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieCompositionResult
    public Object getValue() {
        return this.getValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieCompositionResult
    public boolean isComplete() {
        return ((Boolean)this.isComplete$delegate.getValue()).booleanValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieCompositionResult
    public boolean isFailure() {
        return ((Boolean)this.isFailure$delegate.getValue()).booleanValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieCompositionResult
    public boolean isLoading() {
        return ((Boolean)this.isLoading$delegate.getValue()).booleanValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieCompositionResult
    public boolean isSuccess() {
        return ((Boolean)this.isSuccess$delegate.getValue()).booleanValue();
    }

    private void setError(Throwable throwable0) {
        this.error$delegate.setValue(throwable0);
    }

    private void setValue(LottieComposition lottieComposition0) {
        this.value$delegate.setValue(lottieComposition0);
    }
}

