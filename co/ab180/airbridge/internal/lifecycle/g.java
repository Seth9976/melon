package co.ab180.airbridge.internal.lifecycle;

import android.app.Application;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000B\u0010\nR\u0014\u0010\r\u001A\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\f¨\u0006\u000E"}, d2 = {"Lco/ab180/airbridge/internal/lifecycle/g;", "Lco/ab180/airbridge/internal/lifecycle/f;", "<init>", "()V", "Landroid/app/Application;", "app", "", "enable", "Lie/H;", "b", "(Landroid/app/Application;Z)V", "a", "Lco/ab180/airbridge/internal/lifecycle/f;", "delegate", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class g implements f {
    private final f a;

    public g() {
        this.a = new a();
    }

    @Override  // co.ab180.airbridge.internal.lifecycle.f
    public void a(@NotNull Application application0, boolean z) {
        this.a.a(application0, z);
    }

    @Override  // co.ab180.airbridge.internal.lifecycle.f
    public void b(@NotNull Application application0, boolean z) {
        this.a.b(application0, z);
    }
}

