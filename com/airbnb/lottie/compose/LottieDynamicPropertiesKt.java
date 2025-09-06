package com.airbnb.lottie.compose;

import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Arrays;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000-\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\u0011\u001A+\u0010\u0004\u001A\u00020\u00032\u001A\u0010\u0002\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000\"\u0006\u0012\u0002\b\u00030\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001A?\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001A\u00028\u00002\u0006\u0010\b\u001A\u00028\u00002\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0000\"\u00020\tH\u0007¢\u0006\u0004\b\u000B\u0010\f\u001AQ\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001A\u00028\u00002\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0000\"\u00020\t2\u0018\u0010\u000F\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E\u0012\u0004\u0012\u00028\u00000\rH\u0007¢\u0006\u0004\b\u000B\u0010\u0010\u001A1\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0006*\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E\u0012\u0004\u0012\u00028\u00000\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015²\u0006$\u0010\u0014\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u00068\nX\u008A\u0084\u0002"}, d2 = {"", "Lcom/airbnb/lottie/compose/LottieDynamicProperty;", "properties", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "rememberLottieDynamicProperties", "([Lcom/airbnb/lottie/compose/LottieDynamicProperty;Landroidx/compose/runtime/l;I)Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "T", "property", "value", "", "keyPath", "rememberLottieDynamicProperty", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/String;Landroidx/compose/runtime/l;I)Lcom/airbnb/lottie/compose/LottieDynamicProperty;", "Lkotlin/Function1;", "Lcom/airbnb/lottie/value/LottieFrameInfo;", "callback", "(Ljava/lang/Object;[Ljava/lang/String;Lwe/k;Landroidx/compose/runtime/l;I)Lcom/airbnb/lottie/compose/LottieDynamicProperty;", "com/airbnb/lottie/compose/LottieDynamicPropertiesKt$toValueCallback$1", "toValueCallback", "(Lwe/k;)Lcom/airbnb/lottie/compose/LottieDynamicPropertiesKt$toValueCallback$1;", "callbackState", "lottie-compose_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class LottieDynamicPropertiesKt {
    public static final com.airbnb.lottie.compose.LottieDynamicPropertiesKt.toValueCallback.1 access$toValueCallback(k k0) {
        return LottieDynamicPropertiesKt.toValueCallback(k0);
    }

    @NotNull
    public static final LottieDynamicProperties rememberLottieDynamicProperties(@NotNull LottieDynamicProperty[] arr_lottieDynamicProperty, @Nullable l l0, int v) {
        q.g(arr_lottieDynamicProperty, "properties");
        ((p)l0).b0(0xE86C0321);
        int v1 = Arrays.hashCode(arr_lottieDynamicProperty);
        ((p)l0).b0(0x20DF0A1);
        boolean z = ((p)l0).e(v1);
        LottieDynamicProperties lottieDynamicProperties0 = ((p)l0).N();
        if(z || lottieDynamicProperties0 == androidx.compose.runtime.k.a) {
            lottieDynamicProperties0 = new LottieDynamicProperties(n.z0(arr_lottieDynamicProperty));
            ((p)l0).l0(lottieDynamicProperties0);
        }
        ((p)l0).p(false);
        ((p)l0).p(false);
        return lottieDynamicProperties0;
    }

    @NotNull
    public static final LottieDynamicProperty rememberLottieDynamicProperty(Object object0, Object object1, @NotNull String[] arr_s, @Nullable l l0, int v) {
        q.g(arr_s, "keyPath");
        ((p)l0).b0(0x956531F5);
        ((p)l0).b0(0x602B3379);
        boolean z = ((p)l0).g(arr_s);
        KeyPath keyPath0 = ((p)l0).N();
        V v1 = androidx.compose.runtime.k.a;
        if(z || keyPath0 == v1) {
            keyPath0 = new KeyPath(((String[])Arrays.copyOf(arr_s, arr_s.length)));
            ((p)l0).l0(keyPath0);
        }
        ((p)l0).p(false);
        ((p)l0).b0(0x602B33AC);
        boolean z1 = ((p)l0).g(keyPath0);
        int v2 = 1;
        boolean z2 = (v & 14 ^ 6) > 4 && ((p)l0).g(object0) || (v & 6) == 4;
        if(((v & 0x70 ^ 0x30) <= 0x20 || !((p)l0).g(object1)) && (v & 0x30) != 0x20) {
            v2 = 0;
        }
        LottieDynamicProperty lottieDynamicProperty0 = ((p)l0).N();
        if((z1 | z2 | v2) != 0 || lottieDynamicProperty0 == v1) {
            lottieDynamicProperty0 = new LottieDynamicProperty(object0, keyPath0, object1);
            ((p)l0).l0(lottieDynamicProperty0);
        }
        ((p)l0).p(false);
        ((p)l0).p(false);
        return lottieDynamicProperty0;
    }

    @NotNull
    public static final LottieDynamicProperty rememberLottieDynamicProperty(Object object0, @NotNull String[] arr_s, @NotNull k k0, @Nullable l l0, int v) {
        q.g(arr_s, "keyPath");
        q.g(k0, "callback");
        ((p)l0).b0(0x4F63241A);
        int v1 = Arrays.hashCode(arr_s);
        ((p)l0).b0(0x602B37C5);
        boolean z = ((p)l0).e(v1);
        KeyPath keyPath0 = ((p)l0).N();
        V v2 = androidx.compose.runtime.k.a;
        if(z || keyPath0 == v2) {
            keyPath0 = new KeyPath(((String[])Arrays.copyOf(arr_s, arr_s.length)));
            ((p)l0).l0(keyPath0);
        }
        ((p)l0).p(false);
        b0 b00 = w.w(k0, ((p)l0));
        ((p)l0).b0(0x602B3842);
        boolean z1 = ((p)l0).g(keyPath0);
        boolean z2 = (v & 14 ^ 6) > 4 && ((p)l0).g(object0) || (v & 6) == 4;
        LottieDynamicProperty lottieDynamicProperty0 = ((p)l0).N();
        if(z2 || z1 || lottieDynamicProperty0 == v2) {
            lottieDynamicProperty0 = new LottieDynamicProperty(object0, keyPath0, new k(b00) {
                final b1 $callbackState$delegate;

                {
                    this.$callbackState$delegate = b10;
                    super(1);
                }

                public final Object invoke(@NotNull LottieFrameInfo lottieFrameInfo0) {
                    q.g(lottieFrameInfo0, "it");
                    return LottieDynamicPropertiesKt.rememberLottieDynamicProperty$lambda$4(this.$callbackState$delegate).invoke(lottieFrameInfo0);
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    return this.invoke(((LottieFrameInfo)object0));
                }
            });
            ((p)l0).l0(lottieDynamicProperty0);
        }
        ((p)l0).p(false);
        ((p)l0).p(false);
        return lottieDynamicProperty0;
    }

    private static final k rememberLottieDynamicProperty$lambda$4(b1 b10) {
        return (k)b10.getValue();
    }

    private static final com.airbnb.lottie.compose.LottieDynamicPropertiesKt.toValueCallback.1 toValueCallback(k k0) {
        return new LottieValueCallback() {
            @Override  // com.airbnb.lottie.value.LottieValueCallback
            public Object getValue(@NotNull LottieFrameInfo lottieFrameInfo0) {
                q.g(lottieFrameInfo0, "frameInfo");
                return k0.invoke(lottieFrameInfo0);
            }
        };
    }
}

