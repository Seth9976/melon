package com.airbnb.lottie.compose;

import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B3\b\u0000\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0018\u0010\b\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\nB!\b\u0016\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u000B\u001A\u00028\u0000¢\u0006\u0004\b\t\u0010\fR\u001A\u0010\u0003\u001A\u00028\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0005\u001A\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R,\u0010\b\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u00000\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/airbnb/lottie/compose/LottieDynamicProperty;", "T", "", "property", "Lcom/airbnb/lottie/model/KeyPath;", "keyPath", "Lkotlin/Function1;", "Lcom/airbnb/lottie/value/LottieFrameInfo;", "callback", "<init>", "(Ljava/lang/Object;Lcom/airbnb/lottie/model/KeyPath;Lwe/k;)V", "value", "(Ljava/lang/Object;Lcom/airbnb/lottie/model/KeyPath;Ljava/lang/Object;)V", "Ljava/lang/Object;", "getProperty$lottie_compose_release", "()Ljava/lang/Object;", "Lcom/airbnb/lottie/model/KeyPath;", "getKeyPath$lottie_compose_release", "()Lcom/airbnb/lottie/model/KeyPath;", "Lwe/k;", "getCallback$lottie_compose_release", "()Lwe/k;", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class LottieDynamicProperty {
    public static final int $stable = 8;
    @NotNull
    private final k callback;
    @NotNull
    private final KeyPath keyPath;
    private final Object property;

    public LottieDynamicProperty(Object object0, @NotNull KeyPath keyPath0, Object object1) {
        q.g(keyPath0, "keyPath");
        this(object0, keyPath0, new k() {
            final Object $value;

            {
                this.$value = object0;
                super(1);
            }

            public final Object invoke(@NotNull LottieFrameInfo lottieFrameInfo0) {
                q.g(lottieFrameInfo0, "it");
                return this.$value;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((LottieFrameInfo)object0));
            }
        });
    }

    public LottieDynamicProperty(Object object0, @NotNull KeyPath keyPath0, @NotNull k k0) {
        q.g(keyPath0, "keyPath");
        q.g(k0, "callback");
        super();
        this.property = object0;
        this.keyPath = keyPath0;
        this.callback = k0;
    }

    @NotNull
    public final k getCallback$lottie_compose_release() {
        return this.callback;
    }

    @NotNull
    public final KeyPath getKeyPath$lottie_compose_release() {
        return this.keyPath;
    }

    public final Object getProperty$lottie_compose_release() {
        return this.property;
    }
}

