package co.ab180.airbridge.internal.d0.b.a;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import ie.H;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import me.j;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0018B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH$¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\u0007H$¢\u0006\u0004\b\r\u0010\tJ#\u0010\u0012\u001A\u00020\u00072\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\u000EH\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0010H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0014\u001A\u0004\u0018\u00018\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0015R\u001A\u0010\u001C\u001A\u00020\u00038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001BR\u0018\u0010\u001F\u001A\u0004\u0018\u00010\u001D8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0012\u0010\u001ER\u0016\u0010#\u001A\u00020 8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\'\u001A\u00020$8$X¤\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&R\u0014\u0010)\u001A\u00020$8$X¤\u0004¢\u0006\u0006\u001A\u0004\b(\u0010&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lco/ab180/airbridge/internal/d0/b/a/d;", "R", "Ljava/io/Closeable;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "n", "()Z", "Landroid/content/Intent;", "h", "()Landroid/content/Intent;", "q", "Lkotlin/Function1;", "Landroid/os/IBinder;", "Lie/H;", "onServiceConnected", "b", "(Lwe/k;)Z", "d", "()V", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "a", "Landroid/content/Context;", "m", "()Landroid/content/Context;", "appContext", "Landroid/content/ServiceConnection;", "Landroid/content/ServiceConnection;", "serviceConnection", "Lco/ab180/airbridge/internal/d0/b/a/d$a;", "c", "Lco/ab180/airbridge/internal/d0/b/a/d$a;", "clientState", "", "p", "()Ljava/lang/String;", "tag", "o", "packageName", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public abstract class d implements Closeable {
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"co/ab180/airbridge/internal/d0/b/a/d$a", "", "Lco/ab180/airbridge/internal/d0/b/a/d$a;", "", "value", "<init>", "(Ljava/lang/String;II)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static enum a {
        DISCONNECTED(0),
        CONNECTING(1),
        CONNECTED(2),
        CLOSED(3);

        private a(int v1) {
        }
    }

    @NotNull
    private final Context a;
    private ServiceConnection b;
    private a c;

    public d(@NotNull Context context0) {
        this.a = context0.getApplicationContext();
        this.c = a.a;
    }

    public static final a a(d d0) {
        return d0.c;
    }

    public static Object a(d d0, Continuation continuation0) [...] // Inlined contents

    @SuppressLint({"QueryPermissionsNeeded"})
    public final boolean b(@NotNull k k0) {
        @Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"co/ab180/airbridge/internal/d0/b/a/d$b", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "remote", "Lie/H;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
        public static final class b implements ServiceConnection {
            final d a;
            final k b;

            public b(d d0, k k0) {
                this.a = d0;
                this.b = k0;
                super();
            }

            @Override  // android.content.ServiceConnection
            public void onServiceConnected(@NotNull ComponentName componentName0, @NotNull IBinder iBinder0) {
                @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001A\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008A@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
                @e(c = "co.ab180.airbridge.internal.thirdparty.common.ipc.ServiceClient$startConnection$1$onServiceConnected$1", f = "ServiceClient.kt", l = {}, m = "invokeSuspend")
                static final class co.ab180.airbridge.internal.d0.b.a.d.b.a extends i implements n {
                    int a;
                    final b b;
                    final IBinder c;

                    public co.ab180.airbridge.internal.d0.b.a.d.b.a(b d$b0, IBinder iBinder0, Continuation continuation0) {
                        this.b = d$b0;
                        this.c = iBinder0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    @NotNull
                    public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                        return new co.ab180.airbridge.internal.d0.b.a.d.b.a(this.b, this.c, continuation0);
                    }

                    @Override  // we.n
                    public final Object invoke(Object object0, Object object1) {
                        return ((co.ab180.airbridge.internal.d0.b.a.d.b.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        if(this.a != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        try {
                            this.b.b.invoke(this.c);
                        }
                        catch(Exception unused_ex) {
                            this.b.a.d();
                        }
                        return H.a;
                    }
                }

                this.a.c = a.c;
                try {
                    co.ab180.airbridge.internal.d0.b.a.d.b.a d$b$a0 = new co.ab180.airbridge.internal.d0.b.a.d.b.a(this, iBinder0, null);
                    BuildersKt__Builders_commonKt.launch$default(() -> j.a, Dispatchers.getIO(), null, d$b$a0, 2, null);
                }
                catch(Exception unused_ex) {
                    this.a.d();
                }
            }

            @Override  // android.content.ServiceConnection
            public void onServiceDisconnected(@NotNull ComponentName componentName0) {
                this.a.c = a.a;
                this.a.d();
            }
        }

        if(this.n()) {
            co.ab180.airbridge.internal.b.e.e(this.p() + " - Service connection is valid. No need to re-initialize.", new Object[0]);
            return false;
        }
        a d$a0 = this.c;
        if(d$a0 == a.b) {
            co.ab180.airbridge.internal.b.e.f(this.p() + " - Client is already in the process of connecting to the service.", new Object[0]);
            return false;
        }
        if(d$a0 == a.d) {
            co.ab180.airbridge.internal.b.e.f(this.p() + " - Client was already closed and can\'t be reused. Please create another instance.", new Object[0]);
            return false;
        }
        co.ab180.airbridge.internal.b.b b$b0 = co.ab180.airbridge.internal.b.e;
        b$b0.e(this.p() + " - Starting service setup.", new Object[0]);
        Intent intent0 = this.h();
        List list0 = this.a.getPackageManager().queryIntentServices(intent0, 0);
        if(!list0.isEmpty()) {
            ResolveInfo resolveInfo0 = (ResolveInfo)list0.get(0);
            if(resolveInfo0.serviceInfo != null && q.b(resolveInfo0.serviceInfo.packageName, this.o()) && resolveInfo0.serviceInfo.name != null && this.q()) {
                Intent intent1 = new Intent(intent0);
                b d$b0 = new b(this, k0);
                this.b = d$b0;
                if(this.a.bindService(intent1, d$b0, 1)) {
                    b$b0.e(this.p() + " - Service was bonded successfully.", new Object[0]);
                    return true;
                }
                b$b0.f(this.p() + " - Connection to service is blocked.", new Object[0]);
                this.c = a.a;
                return false;
            }
        }
        this.c = a.a;
        b$b0.e(this.p() + " - Service unavailable on device.", new Object[0]);
        return false;
    }

    @Override
    public void close() {
        this.d();
    }

    @Nullable
    public Object d(@NotNull Continuation continuation0) {
        return null;
    }

    public final void d() {
        this.c = a.d;
        ServiceConnection serviceConnection0 = this.b;
        if(serviceConnection0 != null) {
            try {
                this.a.unbindService(serviceConnection0);
            }
            catch(Exception unused_ex) {
                co.ab180.airbridge.internal.b.e.b(this.p() + " - Disconnection to service is failed.", new Object[0]);
            }
        }
        this.b = null;
    }

    @NotNull
    public abstract Intent h();

    @NotNull
    public final Context m() {
        return this.a;
    }

    private final boolean n() {
        return this.c == a.c && this.b != null;
    }

    @NotNull
    public abstract String o();

    @NotNull
    public abstract String p();

    public abstract boolean q();
}

