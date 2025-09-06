package co.ab180.airbridge.internal;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.internal.b0.l;
import co.ab180.airbridge.internal.z.a;
import co.ab180.airbridge.internal.z.j;
import ie.H;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u001F\u0010\n\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\n\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u0003J\u000F\u0010\f\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0003R\u0016\u0010\u000F\u001A\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u000ER\u0014\u0010\u0012\u001A\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0018\u0010\u0015\u001A\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014¨\u0006\u0016"}, d2 = {"Lco/ab180/airbridge/internal/f;", "Lco/ab180/airbridge/internal/e;", "<init>", "()V", "Lie/H;", "c", "Landroid/app/Application;", "app", "Lco/ab180/airbridge/AirbridgeOption;", "option", "a", "(Landroid/app/Application;Lco/ab180/airbridge/AirbridgeOption;)V", "b", "Lco/ab180/airbridge/internal/z/a;", "Lco/ab180/airbridge/internal/z/a;", "debris", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sdkPrepare", "Lco/ab180/airbridge/internal/z/j;", "Lco/ab180/airbridge/internal/z/j;", "debrisModule", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class f implements e {
    private a a;
    private final AtomicBoolean b;
    private j c;

    public f() {
        this.b = new AtomicBoolean(false);
    }

    @Override  // co.ab180.airbridge.internal.e
    public void a() {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lco/ab180/airbridge/internal/z/j;", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/z/j;)V"}, k = 3, mv = {1, 4, 3})
        static final class b extends r implements k {
            final AirbridgeOption a;

            public b(AirbridgeOption airbridgeOption0) {
                this.a = airbridgeOption0;
                super(1);
            }

            public final void a(@NotNull j j0) {
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/b0/l;", "a", "()Lco/ab180/airbridge/internal/b0/l;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.a extends r implements we.a {
                    public static final co.ab180.airbridge.internal.f.b.a a;

                    static {
                        co.ab180.airbridge.internal.f.b.a.a = new co.ab180.airbridge.internal.f.b.a();
                    }

                    public co.ab180.airbridge.internal.f.b.a() {
                        super(0);
                    }

                    @NotNull
                    public final l a() {
                        return new l();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/o;", "a", "()Lco/ab180/airbridge/internal/o;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.b extends r implements we.a {
                    public static final co.ab180.airbridge.internal.f.b.b a;

                    static {
                        co.ab180.airbridge.internal.f.b.b.a = new co.ab180.airbridge.internal.f.b.b();
                    }

                    public co.ab180.airbridge.internal.f.b.b() {
                        super(0);
                    }

                    @NotNull
                    public final o a() {
                        return new q();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/n;", "a", "()Lco/ab180/airbridge/internal/n;"}, k = 3, mv = {1, 4, 3})
                static final class c extends r implements we.a {
                    public static final c a;

                    static {
                        c.a = new c();
                    }

                    public c() {
                        super(0);
                    }

                    @NotNull
                    public final n a() {
                        return new n();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/g;", "a", "()Lco/ab180/airbridge/internal/g;"}, k = 3, mv = {1, 4, 3})
                static final class d extends r implements we.a {
                    public static final d a;

                    static {
                        d.a = new d();
                    }

                    public d() {
                        super(0);
                    }

                    @NotNull
                    public final g a() {
                        return new h();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/d;", "a", "()Lco/ab180/airbridge/internal/d;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.e extends r implements we.a {
                    public static final co.ab180.airbridge.internal.f.b.e a;

                    static {
                        co.ab180.airbridge.internal.f.b.e.a = new co.ab180.airbridge.internal.f.b.e();
                    }

                    public co.ab180.airbridge.internal.f.b.e() {
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.d a() {
                        return new co.ab180.airbridge.internal.d();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/j;", "a", "()Lco/ab180/airbridge/internal/j;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.f extends r implements we.a {
                    public static final co.ab180.airbridge.internal.f.b.f a;

                    static {
                        co.ab180.airbridge.internal.f.b.f.a = new co.ab180.airbridge.internal.f.b.f();
                    }

                    public co.ab180.airbridge.internal.f.b.f() {
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.j a() {
                        return new co.ab180.airbridge.internal.j();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/t;", "a", "()Lco/ab180/airbridge/internal/t;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.g extends r implements we.a {
                    public static final co.ab180.airbridge.internal.f.b.g a;

                    static {
                        co.ab180.airbridge.internal.f.b.g.a = new co.ab180.airbridge.internal.f.b.g();
                    }

                    public co.ab180.airbridge.internal.f.b.g() {
                        super(0);
                    }

                    @NotNull
                    public final t a() {
                        return new t();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/l;", "a", "()Lco/ab180/airbridge/internal/l;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.h extends r implements we.a {
                    public static final co.ab180.airbridge.internal.f.b.h a;

                    static {
                        co.ab180.airbridge.internal.f.b.h.a = new co.ab180.airbridge.internal.f.b.h();
                    }

                    public co.ab180.airbridge.internal.f.b.h() {
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.l a() {
                        return new co.ab180.airbridge.internal.l();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/v/b;", "a", "()Lco/ab180/airbridge/internal/v/b;"}, k = 3, mv = {1, 4, 3})
                static final class i extends r implements we.a {
                    public static final i a;

                    static {
                        i.a = new i();
                    }

                    public i() {
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.v.b a() {
                        return new co.ab180.airbridge.internal.v.b(null, 1, null);
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/v/e;", "a", "()Lco/ab180/airbridge/internal/v/e;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.j extends r implements we.a {
                    public static final co.ab180.airbridge.internal.f.b.j a;

                    static {
                        co.ab180.airbridge.internal.f.b.j.a = new co.ab180.airbridge.internal.f.b.j();
                    }

                    public co.ab180.airbridge.internal.f.b.j() {
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.v.e a() {
                        return new co.ab180.airbridge.internal.v.e();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/b0/e;", "a", "()Lco/ab180/airbridge/internal/b0/e;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.k extends r implements we.a {
                    public static final co.ab180.airbridge.internal.f.b.k a;

                    static {
                        co.ab180.airbridge.internal.f.b.k.a = new co.ab180.airbridge.internal.f.b.k();
                    }

                    public co.ab180.airbridge.internal.f.b.k() {
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.b0.e a() {
                        return new co.ab180.airbridge.internal.b0.f();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/c0/f/a;", "a", "()Lco/ab180/airbridge/internal/c0/f/a;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.l extends r implements we.a {
                    public static final co.ab180.airbridge.internal.f.b.l a;

                    static {
                        co.ab180.airbridge.internal.f.b.l.a = new co.ab180.airbridge.internal.f.b.l();
                    }

                    public co.ab180.airbridge.internal.f.b.l() {
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.c0.f.a a() {
                        return new co.ab180.airbridge.internal.c0.f.b();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/c0/e/a;", "a", "()Lco/ab180/airbridge/internal/c0/e/a;"}, k = 3, mv = {1, 4, 3})
                static final class m extends r implements we.a {
                    final j a;

                    public m(j j0) {
                        this.a = j0;
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.c0.e.a a() {
                        return new co.ab180.airbridge.internal.c0.e.a(((Context)a.a(co.ab180.airbridge.internal.z.h.b.a()).a(Context.class)), 0, 2, null);
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/c0/c;", "a", "()Lco/ab180/airbridge/internal/c0/c;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.n extends r implements we.a {
                    final j a;

                    public co.ab180.airbridge.internal.f.b.n(j j0) {
                        this.a = j0;
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.c0.c a() {
                        return new co.ab180.airbridge.internal.c0.d(((co.ab180.airbridge.internal.c0.e.a)a.a(co.ab180.airbridge.internal.z.h.b.a()).a(co.ab180.airbridge.internal.c0.e.a.class)));
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/a0/c;", "a", "()Lco/ab180/airbridge/internal/a0/c;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.o extends r implements we.a {
                    public static final co.ab180.airbridge.internal.f.b.o a;

                    static {
                        co.ab180.airbridge.internal.f.b.o.a = new co.ab180.airbridge.internal.f.b.o();
                    }

                    public co.ab180.airbridge.internal.f.b.o() {
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.a0.c a() {
                        return new co.ab180.airbridge.internal.a0.d();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/a0/a;", "a", "()Lco/ab180/airbridge/internal/a0/a;"}, k = 3, mv = {1, 4, 3})
                static final class p extends r implements we.a {
                    final b a;
                    final j b;

                    public p(b f$b0, j j0) {
                        this.a = f$b0;
                        this.b = j0;
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.a0.a a() {
                        co.ab180.airbridge.internal.z.l l0 = a.a(co.ab180.airbridge.internal.z.h.b.a());
                        return new co.ab180.airbridge.internal.a0.b(this.a.a.getName(), this.a.a.getToken(), ((co.ab180.airbridge.internal.a0.c)l0.a(co.ab180.airbridge.internal.a0.c.class)));
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/b0/i;", "a", "()Lco/ab180/airbridge/internal/b0/i;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.q extends r implements we.a {
                    public static final co.ab180.airbridge.internal.f.b.q a;

                    static {
                        co.ab180.airbridge.internal.f.b.q.a = new co.ab180.airbridge.internal.f.b.q();
                    }

                    public co.ab180.airbridge.internal.f.b.q() {
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.b0.i a() {
                        return new co.ab180.airbridge.internal.b0.j();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/b0/h;", "a", "()Lco/ab180/airbridge/internal/b0/h;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.b.r extends r implements we.a {
                    public static final co.ab180.airbridge.internal.f.b.r a;

                    static {
                        co.ab180.airbridge.internal.f.b.r.a = new co.ab180.airbridge.internal.f.b.r();
                    }

                    public co.ab180.airbridge.internal.f.b.r() {
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.b0.h a() {
                        return new co.ab180.airbridge.internal.b0.h();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }


                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/internal/b0/b;", "a", "()Lco/ab180/airbridge/internal/b0/b;"}, k = 3, mv = {1, 4, 3})
                static final class s extends r implements we.a {
                    public static final s a;

                    static {
                        s.a = new s();
                    }

                    public s() {
                        super(0);
                    }

                    @NotNull
                    public final co.ab180.airbridge.internal.b0.b a() {
                        return new co.ab180.airbridge.internal.b0.c();
                    }

                    @Override  // we.a
                    public Object invoke() {
                        return this.a();
                    }
                }

                j0.m().add(new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.b0.e.class, co.ab180.airbridge.internal.f.b.k.a, null, null, 12, null));
                j0.m().add(new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.c0.f.a.class, co.ab180.airbridge.internal.f.b.l.a, null, null, 12, null));
                m f$b$m0 = new m(j0);
                j0.m().add(new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.c0.e.a.class, f$b$m0, null, null, 12, null));
                co.ab180.airbridge.internal.f.b.n f$b$n0 = new co.ab180.airbridge.internal.f.b.n(j0);
                j0.m().add(new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.c0.c.class, f$b$n0, null, null, 12, null));
                j0.m().add(new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.a0.c.class, co.ab180.airbridge.internal.f.b.o.a, null, null, 12, null));
                p f$b$p0 = new p(this, j0);
                j0.m().add(new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.a0.a.class, f$b$p0, null, null, 12, null));
                j0.m().add(new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.b0.i.class, co.ab180.airbridge.internal.f.b.q.a, null, null, 12, null));
                co.ab180.airbridge.internal.z.c c0 = new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.b0.h.class, co.ab180.airbridge.internal.f.b.r.a, null, null, 12, null);
                j0.m().add(c0);
                co.ab180.airbridge.internal.z.d.a(c0, new De.d[]{I.a.b(co.ab180.airbridge.internal.b0.g.class), I.a.b(Closeable.class)});
                j0.m().add(new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.b0.b.class, s.a, null, null, 12, null));
                co.ab180.airbridge.internal.z.c c1 = new co.ab180.airbridge.internal.z.c(l.class, co.ab180.airbridge.internal.f.b.a.a, null, null, 12, null);
                j0.m().add(c1);
                co.ab180.airbridge.internal.z.d.a(c1, new De.d[]{I.a.b(co.ab180.airbridge.internal.b0.k.class), I.a.b(Closeable.class)});
                j0.m().add(new co.ab180.airbridge.internal.z.c(o.class, co.ab180.airbridge.internal.f.b.b.a, null, null, 12, null));
                co.ab180.airbridge.internal.z.c c2 = new co.ab180.airbridge.internal.z.c(n.class, c.a, null, null, 12, null);
                j0.m().add(c2);
                co.ab180.airbridge.internal.z.d.a(c2, new De.d[]{I.a.b(co.ab180.airbridge.internal.m.class), I.a.b(Closeable.class)});
                j0.m().add(new co.ab180.airbridge.internal.z.c(g.class, d.a, null, null, 12, null));
                co.ab180.airbridge.internal.z.c c3 = new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.d.class, co.ab180.airbridge.internal.f.b.e.a, null, null, 12, null);
                j0.m().add(c3);
                co.ab180.airbridge.internal.z.d.a(c3, new De.d[]{I.a.b(co.ab180.airbridge.internal.c.class), I.a.b(Closeable.class)});
                co.ab180.airbridge.internal.z.c c4 = new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.j.class, co.ab180.airbridge.internal.f.b.f.a, null, null, 12, null);
                j0.m().add(c4);
                co.ab180.airbridge.internal.z.d.a(c4, new De.d[]{I.a.b(co.ab180.airbridge.internal.i.class), I.a.b(Closeable.class)});
                co.ab180.airbridge.internal.z.c c5 = new co.ab180.airbridge.internal.z.c(t.class, co.ab180.airbridge.internal.f.b.g.a, null, null, 12, null);
                j0.m().add(c5);
                co.ab180.airbridge.internal.z.d.a(c5, new De.d[]{I.a.b(co.ab180.airbridge.internal.r.class), I.a.b(Closeable.class)});
                co.ab180.airbridge.internal.z.c c6 = new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.l.class, co.ab180.airbridge.internal.f.b.h.a, null, null, 12, null);
                j0.m().add(c6);
                co.ab180.airbridge.internal.z.d.a(c6, new De.d[]{I.a.b(co.ab180.airbridge.internal.k.class), I.a.b(Closeable.class)});
                co.ab180.airbridge.internal.z.c c7 = new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.v.b.class, i.a, null, null, 12, null);
                j0.m().add(c7);
                co.ab180.airbridge.internal.z.d.a(c7, new De.d[]{I.a.b(co.ab180.airbridge.internal.v.a.class), I.a.b(Closeable.class)});
                co.ab180.airbridge.internal.z.c c8 = new co.ab180.airbridge.internal.z.c(co.ab180.airbridge.internal.v.e.class, co.ab180.airbridge.internal.f.b.j.a, null, null, 12, null);
                j0.m().add(c8);
                co.ab180.airbridge.internal.z.d.a(c8, new De.d[]{I.a.b(co.ab180.airbridge.internal.v.d.class), I.a.b(Closeable.class)});
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.a(((j)object0));
                return H.a;
            }
        }

        j j0 = co.ab180.airbridge.internal.z.k.a(new b(((AirbridgeOption)a.a(this.a).a(AirbridgeOption.class))));
        this.c = j0;
        if(j0 != null) {
            this.a.a(j0);
        }
        this.c();
    }

    @Override  // co.ab180.airbridge.internal.e
    public void a(@NotNull Application application0, @NotNull AirbridgeOption airbridgeOption0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lco/ab180/airbridge/internal/z/b;", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/z/b;)V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.f.a extends r implements k {
            final Application a;
            final AirbridgeOption b;

            public co.ab180.airbridge.internal.f.a(Application application0, AirbridgeOption airbridgeOption0) {
                this.a = application0;
                this.b = airbridgeOption0;
                super(1);
            }

            public final void a(@NotNull co.ab180.airbridge.internal.z.b b0) {
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lco/ab180/airbridge/internal/z/j;", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/z/j;)V"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.a.a extends r implements k {
                    final co.ab180.airbridge.internal.f.a a;

                    public co.ab180.airbridge.internal.f.a.a(co.ab180.airbridge.internal.f.a f$a0) {
                        this.a = f$a0;
                        super(1);
                    }

                    public final void a(@NotNull j j0) {
                        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/app/Application;", "a", "()Landroid/app/Application;"}, k = 3, mv = {1, 4, 3})
                        static final class co.ab180.airbridge.internal.f.a.a.a extends r implements we.a {
                            final co.ab180.airbridge.internal.f.a.a a;

                            public co.ab180.airbridge.internal.f.a.a.a(co.ab180.airbridge.internal.f.a.a f$a$a0) {
                                this.a = f$a$a0;
                                super(0);
                            }

                            @NotNull
                            public final Application a() {
                                return this.a.a.a;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                return this.a();
                            }
                        }


                        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/content/Context;", "a", "()Landroid/content/Context;"}, k = 3, mv = {1, 4, 3})
                        static final class co.ab180.airbridge.internal.f.a.a.b extends r implements we.a {
                            final co.ab180.airbridge.internal.f.a.a a;

                            public co.ab180.airbridge.internal.f.a.a.b(co.ab180.airbridge.internal.f.a.a f$a$a0) {
                                this.a = f$a$a0;
                                super(0);
                            }

                            @NotNull
                            public final Context a() {
                                Context context0 = this.a.a.a;
                                if(context0 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
                                }
                                return context0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                return this.a();
                            }
                        }

                        co.ab180.airbridge.internal.f.a.a.a f$a$a$a0 = new co.ab180.airbridge.internal.f.a.a.a(this);
                        j0.m().add(new co.ab180.airbridge.internal.z.c(Application.class, f$a$a$a0, null, null, 12, null));
                        co.ab180.airbridge.internal.f.a.a.b f$a$a$b0 = new co.ab180.airbridge.internal.f.a.a.b(this);
                        j0.m().add(new co.ab180.airbridge.internal.z.c(Context.class, f$a$a$b0, null, null, 12, null));
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.a(((j)object0));
                        return H.a;
                    }
                }


                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lco/ab180/airbridge/internal/z/j;", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/z/j;)V"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.f.a.b extends r implements k {
                    final co.ab180.airbridge.internal.f.a a;

                    public co.ab180.airbridge.internal.f.a.b(co.ab180.airbridge.internal.f.a f$a0) {
                        this.a = f$a0;
                        super(1);
                    }

                    public final void a(@NotNull j j0) {
                        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lco/ab180/airbridge/AirbridgeOption;", "a", "()Lco/ab180/airbridge/AirbridgeOption;"}, k = 3, mv = {1, 4, 3})
                        static final class co.ab180.airbridge.internal.f.a.b.a extends r implements we.a {
                            final co.ab180.airbridge.internal.f.a.b a;

                            public co.ab180.airbridge.internal.f.a.b.a(co.ab180.airbridge.internal.f.a.b f$a$b0) {
                                this.a = f$a$b0;
                                super(0);
                            }

                            @NotNull
                            public final AirbridgeOption a() {
                                return this.a.a.b;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                return this.a();
                            }
                        }

                        co.ab180.airbridge.internal.f.a.b.a f$a$b$a0 = new co.ab180.airbridge.internal.f.a.b.a(this);
                        j0.m().add(new co.ab180.airbridge.internal.z.c(AirbridgeOption.class, f$a$b$a0, null, null, 12, null));
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.a(((j)object0));
                        return H.a;
                    }
                }

                b0.a(new j[]{co.ab180.airbridge.internal.z.k.a(new co.ab180.airbridge.internal.f.a.a(this)), co.ab180.airbridge.internal.z.k.a(new co.ab180.airbridge.internal.f.a.b(this))});
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.a(((co.ab180.airbridge.internal.z.b)object0));
                return H.a;
            }
        }

        this.a = co.ab180.airbridge.internal.z.g.a(new co.ab180.airbridge.internal.f.a(application0, airbridgeOption0));
        int v = airbridgeOption0.getLogLevel().getAndroidLogLevel();
        co.ab180.airbridge.internal.b.e.b(v);
        if(airbridgeOption0.isSdkEnabled()) {
            this.a();
        }
    }

    @Override  // co.ab180.airbridge.internal.e
    public void b() {
        for(Object object0: this.a.b(Closeable.class)) {
            ((Closeable)object0).close();
        }
        j j0 = this.c;
        if(j0 != null) {
            this.a.b(j0);
        }
        this.c = null;
    }

    private final void c() {
        if(!this.b.getAndSet(true)) {
            AirbridgeOption airbridgeOption0 = (AirbridgeOption)a.a(this.a).a(AirbridgeOption.class);
            if(airbridgeOption0.isResetEventBufferEnabled()) {
                SQLiteDatabase sQLiteDatabase0 = ((co.ab180.airbridge.internal.c0.e.a)a.a(this.a).a(co.ab180.airbridge.internal.c0.e.a.class)).getWritableDatabase();
                sQLiteDatabase0.delete("event", null, null);
                sQLiteDatabase0.close();
                co.ab180.airbridge.internal.b.e.a("Clear event packet storage", new Object[0]);
            }
            Object object0 = a.a(this.a).a(Context.class);
            Object object1 = a.a(this.a).a(co.ab180.airbridge.internal.c0.f.a.class);
            co.ab180.airbridge.internal.e0.t.a(co.ab180.airbridge.internal.e0.t.f, ((Context)object0), ((co.ab180.airbridge.internal.c0.f.a)object1), "4.7.0", false, 8, null);
            if(airbridgeOption0.isSDKSignatureSecretEnabled$airbridge_release()) {
                co.ab180.airbridge.internal.signature.e.b.a(airbridgeOption0.getSecretId(), airbridgeOption0.getSecretKey());
            }
        }
    }
}

