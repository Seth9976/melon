package co.ab180.airbridge.internal.u.c;

import android.content.Intent;
import co.ab180.airbridge.common.OnFailure;
import co.ab180.airbridge.common.OnSuccess;
import co.ab180.airbridge.internal.g;
import co.ab180.airbridge.internal.z.f;
import ie.j;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\f\u001A\u00020\u000B2\u000E\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\u000EJC\u0010\f\u001A\u00020\u00152\u0006\u0010\u0010\u001A\u00020\u000F2\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00140\u00062\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\u0016R\u001B\u0010\u001A\u001A\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0018\u001A\u0004\b\f\u0010\u0019¨\u0006\u001B"}, d2 = {"Lco/ab180/airbridge/internal/u/c/i;", "Lco/ab180/airbridge/internal/u/c/b;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Lco/ab180/airbridge/common/OnSuccess;", "Landroid/net/Uri;", "onSuccess", "Lco/ab180/airbridge/common/OnFailure;", "onFailure", "", "a", "(Landroid/content/Intent;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "(Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "", "channel", "", "", "option", "Lco/ab180/airbridge/common/AirbridgeTrackingLink;", "Lie/H;", "(Ljava/lang/String;Ljava/util/Map;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)V", "Lco/ab180/airbridge/internal/g;", "Lie/j;", "()Lco/ab180/airbridge/internal/g;", "deeplinker", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class i implements b {
    private final j a;

    public i() {
        this.a = f.b(g.class);
    }

    private final g a() {
        return (g)this.a.getValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.b
    public void a(@NotNull String s, @NotNull Map map0, @NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        this.a().a(s, map0, onSuccess0, onFailure0);
    }

    @Override  // co.ab180.airbridge.internal.u.c.b
    public boolean a(@NotNull Intent intent0, @NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        return this.a().a(intent0, onSuccess0, onFailure0);
    }

    @Override  // co.ab180.airbridge.internal.u.c.b
    public boolean a(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        return this.a().a(onSuccess0, onFailure0);
    }
}

