package co.ab180.airbridge;

import co.ab180.airbridge.common.Event;
import co.ab180.airbridge.internal.network.model.b;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A;\u0010\r\u001A\u00020\f*\u00020\u00002\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0016\u0010\u000B\u001A\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\bH\u0000¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lco/ab180/airbridge/Airbridge;", "Lco/ab180/airbridge/AirbridgeLifecycleIntegration;", "getLifecycleIntegration", "(Lco/ab180/airbridge/Airbridge;)Lco/ab180/airbridge/AirbridgeLifecycleIntegration;", "Lco/ab180/airbridge/internal/network/model/b;", "triggerType", "Lco/ab180/airbridge/common/Event;", "event", "", "", "", "sdkAttributes", "Lie/H;", "trackEvent", "(Lco/ab180/airbridge/Airbridge;Lco/ab180/airbridge/internal/network/model/b;Lco/ab180/airbridge/common/Event;Ljava/util/Map;)V", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class AirbridgeExKt {
    @Nullable
    public static final AirbridgeLifecycleIntegration getLifecycleIntegration(@NotNull Airbridge airbridge0) {
        return airbridge0.getInstance$airbridge_release().n();
    }

    public static final void trackEvent(@NotNull Airbridge airbridge0, @NotNull b b0, @NotNull Event event0, @Nullable Map map0) {
        airbridge0.getInstance$airbridge_release().a(b0, event0, map0);
    }
}

