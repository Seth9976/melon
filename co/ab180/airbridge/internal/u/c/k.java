package co.ab180.airbridge.internal.u.c;

import co.ab180.airbridge.common.Event;
import co.ab180.airbridge.internal.network.model.b;
import co.ab180.airbridge.internal.network.model.c;
import co.ab180.airbridge.internal.r;
import co.ab180.airbridge.internal.z.f;
import ie.j;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0016\u0010\u000B\u001A\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u001B\u0010\u0012\u001A\u00020\u000F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0010\u001A\u0004\b\r\u0010\u0011¨\u0006\u0013"}, d2 = {"Lco/ab180/airbridge/internal/u/c/k;", "Lco/ab180/airbridge/internal/u/c/d;", "<init>", "()V", "Lco/ab180/airbridge/internal/network/model/b;", "triggerType", "Lco/ab180/airbridge/common/Event;", "event", "", "", "", "sdkAttributes", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/network/model/b;Lco/ab180/airbridge/common/Event;Ljava/util/Map;)V", "Lco/ab180/airbridge/internal/r;", "Lie/j;", "()Lco/ab180/airbridge/internal/r;", "tracker", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class k implements d {
    private final j a;

    public k() {
        this.a = f.b(r.class);
    }

    private final r a() {
        return (r)this.a.getValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.d
    public void a(@NotNull b b0, @NotNull Event event0, @Nullable Map map0) {
        co.ab180.airbridge.internal.b.e.d("Track in-app event: category={" + event0.getCategory() + '}', new Object[0]);
        this.a().a(c.k, b0, event0, map0);
    }
}

