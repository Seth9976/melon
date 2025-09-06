package co.ab180.airbridge.internal.e0;

import e1.u;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.TimeoutKt;
import oe.c;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A?\u0010\u0007\u001A\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u001A\b\u0004\u0010\u0006\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0080Hø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001A\'\u0010\u0007\u001A\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\t\u001A\u00028\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000B"}, d2 = {"T", "", "timeMillis", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "Lie/H;", "block", "a", "(JLwe/k;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class f {
    @Nullable
    public static final Object a(long v, @NotNull k k0, @NotNull Continuation continuation0) {
        @Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\n\u001A\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u001A\b\u0004\u0010\u0006\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000E\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007H\u0080H¢\u0006\u0004\b\n\u0010\u000B"}, d2 = {"T", "", "timeMillis", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "Lie/H;", "block", "Lkotlin/coroutines/Continuation;", "continuation", "", "suspendCoroutineWithTimeout", "(JLwe/k;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.util.CoroutineUtilsKt", f = "CoroutineUtils.kt", l = {13}, m = "suspendCoroutineWithTimeout")
        public static final class a extends c {
            Object a;
            int b;
            Object c;

            public a(Continuation continuation0) {
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return f.a(0L, null, this);
            }
        }


        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001A\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008A@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.util.CoroutineUtilsKt$suspendCoroutineWithTimeout$2", f = "CoroutineUtils.kt", l = {24}, m = "invokeSuspend")
        public static final class b extends i implements n {
            Object a;
            Object b;
            int c;
            final H d;
            final k e;

            public b(H h0, k k0, Continuation continuation0) {
                this.d = h0;
                this.e = k0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                return new b(this.d, this.e, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((b)this.create(object0, ((Continuation)object1))).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
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
                        this.e.invoke(cancellableContinuationImpl0);
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
                        b f$b0 = (b)this.a;
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

        a f$a0;
        if(continuation0 instanceof a) {
            f$a0 = (a)continuation0;
            int v1 = f$a0.b;
            if((v1 & 0x80000000) == 0) {
                f$a0 = new a(continuation0);
            }
            else {
                f$a0.b = v1 ^ 0x80000000;
            }
        }
        else {
            f$a0 = new a(continuation0);
        }
        Object object0 = f$a0.a;
        ne.a a0 = ne.a.a;
        switch(f$a0.b) {
            case 0: {
                H h0 = H0.b.p(object0);
                h0.a = null;
                b f$b0 = new b(h0, k0, null);
                f$a0.c = h0;
                f$a0.b = 1;
                return TimeoutKt.withTimeoutOrNull(v, f$b0, f$a0) == a0 ? a0 : h0.a;
            }
            case 1: {
                H h1 = (H)f$a0.c;
                d5.n.D(object0);
                return h1.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static final void a(@NotNull CancellableContinuation cancellableContinuation0, Object object0) {
        if(cancellableContinuation0.isActive()) {
            cancellableContinuation0.resumeWith(object0);
        }
    }

    @Nullable
    private static final Object b(long v, @NotNull k k0, @NotNull Continuation continuation0) {
        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        h0.a = null;
        TimeoutKt.withTimeoutOrNull(v, new b(h0, k0, null), continuation0);
        return h0.a;
    }
}

