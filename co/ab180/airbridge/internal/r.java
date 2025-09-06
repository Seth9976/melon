package co.ab180.airbridge.internal;

import co.ab180.airbridge.common.Event;
import co.ab180.airbridge.internal.network.model.b;
import co.ab180.airbridge.internal.network.model.c;
import java.io.Closeable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0006H&¢\u0006\u0004\b\u0003\u0010\bJ\u0017\u0010\n\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\u0006H&¢\u0006\u0004\b\n\u0010\bJ;\u0010\u0011\u001A\u00020\u00102\u0014\u0010\r\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\u000B2\u0014\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000BH&¢\u0006\u0004\b\u0011\u0010\u0012JE\u0010\u0011\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u00132\b\b\u0002\u0010\u0016\u001A\u00020\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0018\b\u0002\u0010\u001B\u001A\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u001A\u0018\u00010\u0019H&¢\u0006\u0004\b\u0011\u0010\u001CR\u0014\u0010\u001F\u001A\u00020\u00108&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E¨\u0006 "}, d2 = {"Lco/ab180/airbridge/internal/r;", "Ljava/io/Closeable;", "Lie/H;", "f", "()V", "g", "", "deeplink", "(Ljava/lang/String;)V", "pushToken", "e", "Lkotlin/Function1;", "Landroid/net/Uri;", "onSuccess", "", "onFailure", "", "a", "(Lwe/k;Lwe/k;)Z", "Lco/ab180/airbridge/internal/network/model/c;", "eventType", "Lco/ab180/airbridge/internal/network/model/b;", "triggerType", "Lco/ab180/airbridge/common/Event;", "event", "", "", "sdkAttributes", "(Lco/ab180/airbridge/internal/network/model/c;Lco/ab180/airbridge/internal/network/model/b;Lco/ab180/airbridge/common/Event;Ljava/util/Map;)V", "j", "()Z", "isTrackingStarted", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface r extends Closeable {
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    public static final class a {
        public static void a(r r0, c c0, b b0, Event event0, Map map0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackEvent");
            }
            if((v & 2) != 0) {
                b0 = b.a;
            }
            if((v & 8) != 0) {
                map0 = null;
            }
            r0.a(c0, b0, event0, map0);
        }
    }

    void a(@NotNull c arg1, @NotNull b arg2, @Nullable Event arg3, @Nullable Map arg4);

    boolean a(@NotNull k arg1, @Nullable k arg2);

    void e(@NotNull String arg1);

    void f();

    void f(@NotNull String arg1);

    void g();

    boolean j();
}

