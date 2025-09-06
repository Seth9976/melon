package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001A\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001A\u00020\f2\b\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000B\u001A\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000EJ)\u0010\u0010\u001A\u00020\n2\b\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\fH\u0017¢\u0006\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0014\u001A\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001A"}, d2 = {"Landroidx/lifecycle/LifecycleService;", "Landroid/app/Service;", "Landroidx/lifecycle/D;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "startId", "Lie/H;", "onStart", "(Landroid/content/Intent;I)V", "flags", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "Landroidx/lifecycle/l0;", "dispatcher", "Landroidx/lifecycle/l0;", "Landroidx/lifecycle/t;", "getLifecycle", "()Landroidx/lifecycle/t;", "lifecycle", "lifecycle-service_release"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public class LifecycleService extends Service implements D {
    @NotNull
    private final l0 dispatcher;

    public LifecycleService() {
        this.dispatcher = new l0(this);
    }

    @Override  // androidx.lifecycle.D
    @NotNull
    public t getLifecycle() {
        return this.dispatcher.a;
    }

    @Override  // android.app.Service
    @Nullable
    public IBinder onBind(@NotNull Intent intent0) {
        q.g(intent0, "intent");
        this.dispatcher.getClass();
        this.dispatcher.a(r.ON_START);
        return null;
    }

    @Override  // android.app.Service
    public void onCreate() {
        this.dispatcher.getClass();
        this.dispatcher.a(r.ON_CREATE);
        super.onCreate();
    }

    @Override  // android.app.Service
    public void onDestroy() {
        this.dispatcher.getClass();
        this.dispatcher.a(r.ON_STOP);
        this.dispatcher.a(r.ON_DESTROY);
        super.onDestroy();
    }

    @Override  // android.app.Service
    @d
    public void onStart(@Nullable Intent intent0, int v) {
        this.dispatcher.getClass();
        this.dispatcher.a(r.ON_START);
        super.onStart(intent0, v);
    }

    @Override  // android.app.Service
    public int onStartCommand(@Nullable Intent intent0, int v, int v1) {
        return super.onStartCommand(intent0, v, v1);
    }
}

