package co.ab180.airbridge.internal.d0.f.a;

import android.content.Context;
import d5.n;
import e.k;
import ie.d;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@d
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\u000E\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0014\u001A\u0012\u0012\u0004\u0012\u00020\u00100\u000Fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lco/ab180/airbridge/internal/d0/f/a/c;", "Ljava/io/Closeable;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lco/ab180/airbridge/internal/d0/f/a/d;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lie/H;", "close", "()V", "a", "Landroid/content/Context;", "appContext", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "servicePackageNames", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c implements Closeable {
    private final Context a;
    private final ArrayList b;

    public c(@NotNull Context context0) {
        this.a = context0.getApplicationContext();
        this.b = k.e(new String[]{"com.skt.skaf.A000Z00040", "com.kt.olleh.storefront", "com.kt.olleh.istore", "com.lguplus.appstore", "android.lgt.appstore"});
    }

    @Override
    public void close() {
    }

    @Nullable
    public final Object d(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/d0/f/a/d;", "continuation", "", "request", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.thirdparty.onestore.installreferrer.OneStoreInstallReferrerClients", f = "OneStoreInstallReferrerClients.kt", l = {22}, m = "request")
        static final class a extends oe.c {
            Object a;
            int b;
            final c c;
            Object d;
            Object e;
            Object f;
            Object g;

            public a(c c0, Continuation continuation0) {
                this.c = c0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.d(this);
            }
        }

        co.ab180.airbridge.internal.d0.f.a.d d0;
        Closeable closeable0;
        Throwable throwable0;
        Iterator iterator0;
        c c0;
        a c$a0;
        if(continuation0 instanceof a) {
            c$a0 = (a)continuation0;
            int v = c$a0.b;
            if((v & 0x80000000) == 0) {
                c$a0 = new a(this, continuation0);
            }
            else {
                c$a0.b = v ^ 0x80000000;
            }
        }
        else {
            c$a0 = new a(this, continuation0);
        }
        Object object0 = c$a0.a;
        ne.a a0 = ne.a.a;
    alab1:
        switch(c$a0.b) {
            case 0: {
                n.D(object0);
                c0 = this;
                iterator0 = this.b.iterator();
                goto label_28;
            }
            case 1: {
                throwable0 = (Throwable)c$a0.g;
                closeable0 = (Closeable)c$a0.f;
                iterator0 = (Iterator)c$a0.e;
                c0 = (c)c$a0.d;
                try {
                    n.D(object0);
                    while(true) {
                        d0 = (co.ab180.airbridge.internal.d0.f.a.d)object0;
                        break alab1;
                    }
                }
                catch(Throwable throwable1) {
                    d8.d.l(closeable0, throwable1);
                    throw throwable1;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d8.d.l(closeable0, throwable0);
        if(d0 != null) {
            String s = d0.c();
            if(s != null && s.length() != 0) {
                return d0;
            }
        }
    label_28:
        throwable0 = null;
        if(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            closeable0 = new b(c0.a, ((String)object1));
            try {
                c$a0.d = c0;
                c$a0.e = iterator0;
                c$a0.f = closeable0;
                c$a0.g = null;
                c$a0.b = 1;
                object0 = ((b)closeable0).d(c$a0);
                if(object0 != a0) {
                    d0 = (co.ab180.airbridge.internal.d0.f.a.d)object0;
                    break alab1;
                }
                return a0;
            }
            catch(Throwable throwable1) {
                d8.d.l(closeable0, throwable1);
                throw throwable1;
            }
        }
        return null;
    }
}

