package co.ab180.airbridge.internal.y;

import android.net.Uri;
import co.ab180.airbridge.internal.c0.f.a;
import co.ab180.airbridge.internal.network.model.c;
import co.ab180.airbridge.internal.z.f;
import d5.n;
import ie.H;
import ie.j;
import ie.o;
import ie.p;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\n\u001A\u00020\u00062\u0014\u0010\u0007\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\n\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\r¢\u0006\u0004\b\n\u0010\u000FJ9\u0010\f\u001A\u00020\u00102\u0014\u0010\u0007\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\u0011R\u001B\u0010\u0015\u001A\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0013\u001A\u0004\b\n\u0010\u0014R\u0014\u0010\u0018\u001A\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R/\u0010\u001C\u001A\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0019\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002@\u0002X\u0082\u000Eø\u0001\u0000¢\u0006\u0006\n\u0004\b\u001A\u0010\u001B\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001D"}, d2 = {"Lco/ab180/airbridge/internal/y/b;", "", "<init>", "()V", "Lkotlin/Function1;", "Landroid/net/Uri;", "Lie/H;", "onSuccess", "", "onFailure", "a", "(Lwe/k;Lwe/k;)V", "b", "Lco/ab180/airbridge/internal/network/model/c;", "eventType", "(Lco/ab180/airbridge/internal/network/model/c;)V", "", "(Lwe/k;Lwe/k;)Z", "Lco/ab180/airbridge/internal/c0/f/a;", "Lie/j;", "()Lco/ab180/airbridge/internal/c0/f/a;", "preferences", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isSetHandle", "Lie/p;", "c", "Lwe/k;", "handleListener", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b {
    private final j a;
    private final AtomicBoolean b;
    private k c;

    public b() {
        this.a = f.b(a.class);
        this.b = new AtomicBoolean(false);
    }

    private final a a() {
        return (a)this.a.getValue();
    }

    private final void a(k k0, k k1) {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\u00020\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lie/p;", "Landroid/net/Uri;", "it", "Lie/H;", "a", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.y.b.a extends r implements k {
            final k a;
            final k b;

            public co.ab180.airbridge.internal.y.b.a(k k0, k k1) {
                this.a = k0;
                this.b = k1;
                super(1);
            }

            public final void a(@NotNull Object object0) {
                Object object1 = ((p)object0).a;
                if(!(object1 instanceof o)) {
                    k k0 = this.a;
                    if(object1 instanceof o) {
                        object1 = null;
                    }
                    k0.invoke(object1);
                    return;
                }
                k k1 = this.b;
                if(k1 != null) {
                    Throwable throwable0 = p.a(object1);
                    if(throwable0 == null) {
                        throwable0 = new Throwable();
                    }
                    H h0 = (H)k1.invoke(throwable0);
                }
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.a(object0);
                return H.a;
            }
        }

        this.c = new co.ab180.airbridge.internal.y.b.a(k0, k1);
    }

    public final void a(@Nullable c c0) {
        if(c0 == c.f || c0 == c.g || c0 == c.h) {
            this.a().b(true);
            co.ab180.airbridge.internal.b.e.d("Ignored on handling deferred deeplink by deeplink event. eventType={" + c0 + '}', new Object[0]);
        }
        this.b();
    }

    private final void b() {
        o o0;
        if(this.a().f()) {
            k k0 = this.c;
            if(k0 != null) {
                this.a().d(false);
                String s = this.a().x();
                if(s == null || s.length() == 0) {
                    String s1 = this.a().q();
                    if(this.a().l()) {
                        s1 = null;
                    }
                    o0 = s1 == null ? null : Uri.parse(s1);
                }
                else {
                    o0 = n.t(new Throwable(s));
                }
                k0.invoke(new p(o0));
            }
        }
    }

    public final boolean b(@NotNull k k0, @Nullable k k1) {
        co.ab180.airbridge.internal.b.e.e("DeferredDeepLinkDelegate(" + co.ab180.airbridge.internal.e0.p.a(this) + ")#handleDeferredDeeplink: firstHandle={" + this.a().y() + '}', new Object[0]);
        if(this.a().y() && !this.b.getAndSet(true)) {
            this.a(k0, k1);
            this.b();
        }
        return false;
    }
}

