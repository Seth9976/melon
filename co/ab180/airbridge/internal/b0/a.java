package co.ab180.airbridge.internal.b0;

import U4.x;
import android.content.Context;
import co.ab180.airbridge.internal.e0.f;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import e1.u;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.TimeoutKt;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lco/ab180/airbridge/internal/b0/a;", "", "Landroid/content/Context;", "context", "Lco/ab180/airbridge/internal/b0/a$a;", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0003\u001A\u00020\n2\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0003\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001A\u0010\u0010\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001A\u0004\b\u0013\u0010\u0004R\u0019\u0010\t\u001A\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001A\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"co/ab180/airbridge/internal/b0/a$a", "", "", "a", "()I", "", "b", "()Ljava/lang/String;", "appSetIDScope", "appSetID", "Lco/ab180/airbridge/internal/b0/a$a;", "(ILjava/lang/String;)Lco/ab180/airbridge/internal/b0/a$a;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "d", "Ljava/lang/String;", "c", "<init>", "(ILjava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class co.ab180.airbridge.internal.b0.a.a {
        private final int a;
        @NotNull
        private final String b;

        public co.ab180.airbridge.internal.b0.a.a(int v, @NotNull String s) {
            this.a = v;
            this.b = s;
        }

        public static co.ab180.airbridge.internal.b0.a.a a(co.ab180.airbridge.internal.b0.a.a a$a0, int v, String s, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = a$a0.a;
            }
            if((v1 & 2) != 0) {
                s = a$a0.b;
            }
            return a$a0.a(v, s);
        }

        public final int a() {
            return this.a;
        }

        @NotNull
        public final co.ab180.airbridge.internal.b0.a.a a(int v, @NotNull String s) {
            return new co.ab180.airbridge.internal.b0.a.a(v, s);
        }

        @NotNull
        public final String b() {
            return this.b;
        }

        @NotNull
        public final String c() {
            return this.b;
        }

        public final int d() {
            return this.a;
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 || object0 instanceof co.ab180.airbridge.internal.b0.a.a && this.a == ((co.ab180.airbridge.internal.b0.a.a)object0).a && q.b(this.b, ((co.ab180.airbridge.internal.b0.a.a)object0).b);
        }

        @Override
        public int hashCode() {
            return this.b == null ? this.a * 0x1F : this.a * 0x1F + this.b.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("Result(appSetIDScope=");
            stringBuilder0.append(this.a);
            stringBuilder0.append(", appSetID=");
            return x.m(stringBuilder0, this.b, ")");
        }
    }

    @Nullable
    public final Object a(@NotNull Context context0, @NotNull Continuation continuation0) {
        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001A\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008A@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "co/ab180/airbridge/internal/e0/f$b", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.util.CoroutineUtilsKt$suspendCoroutineWithTimeout$2", f = "CoroutineUtils.kt", l = {24}, m = "invokeSuspend")
        public static final class b extends i implements n {
            Object a;
            Object b;
            int c;
            final H d;
            final Context e;

            public b(H h0, Continuation continuation0, Context context0) {
                this.d = h0;
                this.e = context0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new b(this.d, continuation0, this.e);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((b)this.create(object0, ((Continuation)object1))).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u00032\u000E\u0010\u0002\u001A\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/android/gms/appset/AppSetIdInfo;", "kotlin.jvm.PlatformType", "it", "Lie/H;", "a", "(Lcom/google/android/gms/appset/AppSetIdInfo;)V", "co/ab180/airbridge/internal/scrapper/AppSetInfo$getAppSetIdInfo$2$1"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.b0.a.b.a implements OnSuccessListener {
                    final CancellableContinuation a;

                    public co.ab180.airbridge.internal.b0.a.b.a(CancellableContinuation cancellableContinuation0) {
                        this.a = cancellableContinuation0;
                        super();
                    }

                    public final void a(AppSetIdInfo appSetIdInfo0) {
                        co.ab180.airbridge.internal.b0.a.a a$a0 = new co.ab180.airbridge.internal.b0.a.a(appSetIdInfo0.getScope(), appSetIdInfo0.getId());
                        f.a(this.a, a$a0);
                    }

                    @Override  // com.google.android.gms.tasks.OnSuccessListener
                    public void onSuccess(Object object0) {
                        this.a(((AppSetIdInfo)object0));
                    }
                }


                @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lie/H;", "onCanceled", "()V", "co/ab180/airbridge/internal/scrapper/AppSetInfo$getAppSetIdInfo$2$2", "<anonymous>"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.b0.a.b.b implements OnCanceledListener {
                    final CancellableContinuation a;

                    public co.ab180.airbridge.internal.b0.a.b.b(CancellableContinuation cancellableContinuation0) {
                        this.a = cancellableContinuation0;
                        super();
                    }

                    @Override  // com.google.android.gms.tasks.OnCanceledListener
                    public final void onCanceled() {
                        f.a(this.a, null);
                    }
                }


                @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/lang/Exception;", "it", "Lie/H;", "onFailure", "(Ljava/lang/Exception;)V", "co/ab180/airbridge/internal/scrapper/AppSetInfo$getAppSetIdInfo$2$3", "<anonymous>"}, k = 3, mv = {1, 4, 3})
                static final class c implements OnFailureListener {
                    final CancellableContinuation a;

                    public c(CancellableContinuation cancellableContinuation0) {
                        this.a = cancellableContinuation0;
                        super();
                    }

                    @Override  // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(@NotNull Exception exception0) {
                        f.a(this.a, null);
                    }
                }

                H h1;
                ne.a a0 = ne.a.a;
                switch(this.c) {
                    case 0: {
                        d5.n.D(object0);
                        H h0 = this.d;
                        this.a = this;
                        this.b = h0;
                        this.c = 1;
                        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(this), 1);
                        cancellableContinuationImpl0.initCancellability();
                        try {
                            AppSet.getClient(this.e).getAppSetIdInfo().addOnSuccessListener(new co.ab180.airbridge.internal.b0.a.b.a(cancellableContinuationImpl0)).addOnCanceledListener(new co.ab180.airbridge.internal.b0.a.b.b(cancellableContinuationImpl0)).addOnFailureListener(new c(cancellableContinuationImpl0));
                        }
                        catch(Throwable unused_ex) {
                            f.a(cancellableContinuationImpl0, null);
                        }
                        Object object1 = cancellableContinuationImpl0.getResult();
                        if(object1 == a0) {
                            return a0;
                        }
                        h1 = h0;
                        object0 = object1;
                        break;
                    }
                    case 1: {
                        h1 = (H)this.b;
                        b a$b0 = (b)this.a;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                h1.a = object0;
                return ie.H.a;
            }
        }


        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001A\u00020\u00002\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/content/Context;", "context", "Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/b0/a$a;", "continuation", "", "getAppSetIdInfo", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.AppSetInfo", f = "AppSetInfo.kt", l = {35}, m = "getAppSetIdInfo")
        static final class co.ab180.airbridge.internal.b0.a.c extends oe.c {
            Object a;
            int b;
            final a c;
            Object d;

            public co.ab180.airbridge.internal.b0.a.c(a a0, Continuation continuation0) {
                this.c = a0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(null, this);
            }
        }

        co.ab180.airbridge.internal.b0.a.c a$c0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.a.c) {
            a$c0 = (co.ab180.airbridge.internal.b0.a.c)continuation0;
            int v = a$c0.b;
            if((v & 0x80000000) == 0) {
                a$c0 = new co.ab180.airbridge.internal.b0.a.c(this, continuation0);
            }
            else {
                a$c0.b = v ^ 0x80000000;
            }
        }
        else {
            a$c0 = new co.ab180.airbridge.internal.b0.a.c(this, continuation0);
        }
        Object object0 = a$c0.a;
        ne.a a0 = ne.a.a;
        switch(a$c0.b) {
            case 0: {
                H h0 = H0.b.p(object0);
                h0.a = null;
                b a$b0 = new b(h0, null, context0);
                a$c0.d = h0;
                a$c0.b = 1;
                return TimeoutKt.withTimeoutOrNull(3000L, a$b0, a$c0) == a0 ? a0 : h0.a;
            }
            case 1: {
                H h1 = (H)a$c0.d;
                d5.n.D(object0);
                return h1.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

