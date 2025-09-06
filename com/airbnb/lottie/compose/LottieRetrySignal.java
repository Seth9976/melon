package com.airbnb.lottie.compose;

import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u0004H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007R\u001A\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR+\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/airbnb/lottie/compose/LottieRetrySignal;", "", "<init>", "()V", "Lie/H;", "retry", "awaitRetry", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Channel;", "channel", "Lkotlinx/coroutines/channels/Channel;", "", "<set-?>", "isAwaitingRetry$delegate", "Landroidx/compose/runtime/b0;", "isAwaitingRetry", "()Z", "setAwaitingRetry", "(Z)V", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class LottieRetrySignal {
    public static final int $stable;
    @NotNull
    private final Channel channel;
    @NotNull
    private final b0 isAwaitingRetry$delegate;

    public LottieRetrySignal() {
        this.channel = ChannelKt.Channel$default(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        this.isAwaitingRetry$delegate = w.s(Boolean.FALSE);
    }

    @Nullable
    public final Object awaitRetry(@NotNull Continuation continuation0) {
        LottieRetrySignal lottieRetrySignal0;
        com.airbnb.lottie.compose.LottieRetrySignal.awaitRetry.1 lottieRetrySignal$awaitRetry$10;
        if(continuation0 instanceof com.airbnb.lottie.compose.LottieRetrySignal.awaitRetry.1) {
            lottieRetrySignal$awaitRetry$10 = (com.airbnb.lottie.compose.LottieRetrySignal.awaitRetry.1)continuation0;
            int v = lottieRetrySignal$awaitRetry$10.label;
            if((v & 0x80000000) == 0) {
                lottieRetrySignal$awaitRetry$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.awaitRetry(this);
                    }
                };
            }
            else {
                lottieRetrySignal$awaitRetry$10.label = v ^ 0x80000000;
            }
        }
        else {
            lottieRetrySignal$awaitRetry$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.awaitRetry(this);
                }
            };
        }
        Object object0 = lottieRetrySignal$awaitRetry$10.result;
        a a0 = a.a;
        switch(lottieRetrySignal$awaitRetry$10.label) {
            case 0: {
                n.D(object0);
                try {
                    this.setAwaitingRetry(true);
                    lottieRetrySignal$awaitRetry$10.L$0 = this;
                    lottieRetrySignal$awaitRetry$10.label = 1;
                    if(this.channel.receive(lottieRetrySignal$awaitRetry$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    lottieRetrySignal0 = this;
                    lottieRetrySignal0.setAwaitingRetry(false);
                    throw throwable0;
                }
                lottieRetrySignal0 = this;
                break;
            }
            case 1: {
                lottieRetrySignal0 = (LottieRetrySignal)lottieRetrySignal$awaitRetry$10.L$0;
                try {
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
                lottieRetrySignal0.setAwaitingRetry(false);
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        lottieRetrySignal0.setAwaitingRetry(false);
        return H.a;
    }

    public final boolean isAwaitingRetry() {
        return ((Boolean)this.isAwaitingRetry$delegate.getValue()).booleanValue();
    }

    public final void retry() {
        ChannelsKt.trySendBlocking(this.channel, H.a);
    }

    private final void setAwaitingRetry(boolean z) {
        this.isAwaitingRetry$delegate.setValue(Boolean.valueOf(z));
    }
}

