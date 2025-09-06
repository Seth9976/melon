package co.ab180.airbridge.internal.v;

import java.io.Closeable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J1\u0010\b\u001A\u00020\u00062 \u0010\u0007\u001A\u001C\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\b\u0010\tJ9\u0010\b\u001A\u00020\u00062\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH&¢\u0006\u0004\b\b\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\u0006H&¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lco/ab180/airbridge/internal/v/d;", "Ljava/io/Closeable;", "Lkotlin/Function2;", "Lco/ab180/airbridge/internal/v/c;", "", "Lco/ab180/airbridge/AirbridgeInAppPurchase;", "Lie/H;", "onPurchasesUpdatedListener", "a", "(Lwe/n;)V", "Lkotlin/Function1;", "onBillingSetupFinished", "Lkotlin/Function0;", "onBillingServiceDisconnected", "(Lwe/k;Lwe/a;)V", "d", "()V", "", "n", "()Z", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface d extends Closeable {
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    public static final class a {
        public static void a(d d0, k k0, we.a a0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startConnection");
            }
            if((v & 1) != 0) {
                k0 = null;
            }
            if((v & 2) != 0) {
                a0 = null;
            }
            d0.a(k0, a0);
        }
    }

    void a(@Nullable k arg1, @Nullable we.a arg2);

    void a(@NotNull n arg1);

    void d();

    boolean n();
}

