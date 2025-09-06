package co.ab180.airbridge.internal.e0;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import java.util.TooManyListenersException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0003¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u000B\u0010\bJ\u001D\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\f¢\u0006\u0004\b\u0007\u0010\u000EJ\u0015\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u000F\u0010\bR\u0018\u0010\r\u001A\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0018\u0010\u0013\u001A\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0018\u0010\u0016\u001A\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010\u0015¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/e0/y;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lie/H;", "a", "(Landroid/content/Context;)V", "d", "b", "e", "Lco/ab180/airbridge/internal/e0/y$a;", "networkStateChangeListener", "(Landroid/content/Context;Lco/ab180/airbridge/internal/e0/y$a;)V", "c", "Lco/ab180/airbridge/internal/e0/y$a;", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "networkCallback", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "broadcastReceiver", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class y {
    @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"co/ab180/airbridge/internal/e0/y$a", "", "Lie/H;", "m", "()V", "h", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public interface a {
        void h();

        void m();
    }

    private a a;
    private ConnectivityManager.NetworkCallback b;
    private BroadcastReceiver c;

    @TargetApi(24)
    private final void a(Context context0) {
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"co/ab180/airbridge/internal/e0/y$b", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "Lie/H;", "onAvailable", "(Landroid/net/Network;)V", "onLost", "airbridge_release"}, k = 1, mv = {1, 4, 3})
        public static final class b extends ConnectivityManager.NetworkCallback {
            final y a;

            public b(y y0) {
                this.a = y0;
                super();
            }

            @Override  // android.net.ConnectivityManager$NetworkCallback
            public void onAvailable(@NotNull Network network0) {
                super.onAvailable(network0);
                co.ab180.airbridge.internal.b.e.e("NetworkStateHandler. Network onAvailable", new Object[0]);
                a y$a0 = this.a.a;
                if(y$a0 != null) {
                    y$a0.m();
                }
            }

            @Override  // android.net.ConnectivityManager$NetworkCallback
            public void onLost(@NotNull Network network0) {
                super.onLost(network0);
                co.ab180.airbridge.internal.b.e.e("NetworkStateHandler. Network onLost", new Object[0]);
                a y$a0 = this.a.a;
                if(y$a0 != null) {
                    y$a0.h();
                }
            }
        }

        this.d(context0);
        b y$b0 = new b(this);
        this.b = y$b0;
        Object object0 = context0.getSystemService("connectivity");
        if(object0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        ((ConnectivityManager)object0).registerDefaultNetworkCallback(y$b0);
    }

    public static final void a(y y0, a y$a0) {
        y0.a = y$a0;
    }

    public final void a(@NotNull Context context0, @NotNull a y$a0) {
        this.c(context0);
        this.a = y$a0;
        try {
            this.a(context0);
        }
        catch(SecurityException unused_ex) {
            this.b(context0);
        }
        catch(TooManyListenersException unused_ex) {
            co.ab180.airbridge.internal.b.e.b("NetworkStateHandler#register error. TooManyListenersException. Check for logic that calls connectivityManager.registerDefaultNetworkCallback too many times", new Object[0]);
        }
        catch(Throwable throwable0) {
            co.ab180.airbridge.internal.b.e.f("NetworkStateHandler#register error : " + throwable0, new Object[0]);
        }
    }

    private final void b(Context context0) {
        @Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"co/ab180/airbridge/internal/e0/y$c", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lie/H;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
        public static final class c extends BroadcastReceiver {
            final y a;
            final ConnectivityManager b;

            public c(y y0, ConnectivityManager connectivityManager0) {
                this.a = y0;
                this.b = connectivityManager0;
                super();
            }

            @Override  // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context0, @Nullable Intent intent0) {
                a y$a1;
                NetworkInfo networkInfo0 = this.b.getActiveNetworkInfo();
                if(networkInfo0 == null) {
                    co.ab180.airbridge.internal.b.e.e("NetworkStateHandler. Network onLost", new Object[0]);
                    y$a1 = this.a.a;
                    if(y$a1 != null) {
                        y$a1.h();
                    }
                }
                else if(networkInfo0.isConnected()) {
                    co.ab180.airbridge.internal.b.e.e("NetworkStateHandler. Network onAvailable", new Object[0]);
                    a y$a0 = this.a.a;
                    if(y$a0 != null) {
                        y$a0.m();
                    }
                }
                else {
                    co.ab180.airbridge.internal.b.e.e("NetworkStateHandler. Network onLost", new Object[0]);
                    y$a1 = this.a.a;
                    if(y$a1 != null) {
                        y$a1.h();
                    }
                }
            }
        }

        this.e(context0);
        Object object0 = context0.getSystemService("connectivity");
        if(object0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        c y$c0 = new c(this, ((ConnectivityManager)object0));
        this.c = y$c0;
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context0.registerReceiver(y$c0, intentFilter0);
    }

    public final void c(@NotNull Context context0) {
        try {
            this.d(context0);
        }
        catch(SecurityException unused_ex) {
            this.e(context0);
        }
        catch(Throwable throwable0) {
            co.ab180.airbridge.internal.b.e.f("NetworkStateHandler#unregister error : " + throwable0, new Object[0]);
        }
    }

    @TargetApi(24)
    private final void d(Context context0) {
        ConnectivityManager.NetworkCallback connectivityManager$NetworkCallback0 = this.b;
        if(connectivityManager$NetworkCallback0 != null) {
            Object object0 = context0.getSystemService("connectivity");
            if(object0 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            ((ConnectivityManager)object0).unregisterNetworkCallback(connectivityManager$NetworkCallback0);
        }
    }

    private final void e(Context context0) {
        BroadcastReceiver broadcastReceiver0 = this.c;
        if(broadcastReceiver0 != null) {
            context0.unregisterReceiver(broadcastReceiver0);
        }
    }
}

