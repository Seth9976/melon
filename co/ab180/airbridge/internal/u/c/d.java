package co.ab180.airbridge.internal.u.c;

import co.ab180.airbridge.common.Event;
import co.ab180.airbridge.internal.network.model.b;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J9\u0010\n\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0018\b\u0002\u0010\b\u001A\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/u/c/d;", "", "Lco/ab180/airbridge/internal/network/model/b;", "triggerType", "Lco/ab180/airbridge/common/Event;", "event", "", "", "sdkAttributes", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/network/model/b;Lco/ab180/airbridge/common/Event;Ljava/util/Map;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface d {
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    public static final class a {
        public static void a(d d0, b b0, Event event0, Map map0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackEvent");
            }
            if((v & 4) != 0) {
                map0 = null;
            }
            d0.a(b0, event0, map0);
        }
    }

    void a(@NotNull b arg1, @NotNull Event arg2, @Nullable Map arg3);
}

