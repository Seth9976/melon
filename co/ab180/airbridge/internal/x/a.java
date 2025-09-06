package co.ab180.airbridge.internal.x;

import co.ab180.airbridge.internal.b;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import me.h;
import me.i;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ6\u0010\u000E\u001A\u00020\r2\"\u0010\f\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u0010R\u0018\u0010\u0012\u001A\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000E\u0010\u0011R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lco/ab180/airbridge/internal/x/a;", "", "", "tag", "<init>", "(Ljava/lang/String;)V", "Lkotlinx/coroutines/CoroutineScope;", "b", "()Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "block", "Lkotlinx/coroutines/Job;", "a", "(Lwe/n;)Lkotlinx/coroutines/Job;", "()V", "Lkotlinx/coroutines/CoroutineScope;", "_scope", "Ljava/lang/String;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public class a {
    private CoroutineScope a;
    private final String b;

    public a(@NotNull String s) {
        this.b = s;
    }

    @NotNull
    public Job a(@NotNull n n0) {
        return BuildersKt__Builders_commonKt.launch$default(this.b(), null, null, n0, 3, null);
    }

    public void a() {
        CoroutineScope coroutineScope0 = this.a;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, null, 1, null);
        }
        this.a = null;
    }

    private final CoroutineScope b() {
        @Metadata(d1 = {"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001F\u0010\b\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"co/ab180/airbridge/internal/x/a$a", "Lme/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lme/i;", "context", "", "exception", "Lie/H;", "handleException", "(Lme/i;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 3})
        public static final class co.ab180.airbridge.internal.x.a.a extends me.a implements CoroutineExceptionHandler {
            final a a;

            public co.ab180.airbridge.internal.x.a.a(h h0, a a0) {
                this.a = a0;
                super(h0);
            }

            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(@NotNull i i0, @NotNull Throwable throwable0) {
                b.e.f(throwable0, "Unexpected exception emitted in " + this.a.b, new Object[0]);
            }
        }

        if(this.a == null) {
            this.a = CoroutineScopeKt.CoroutineScope(new co.ab180.airbridge.internal.x.a.a(CoroutineExceptionHandler.Key, this));
        }
        return this.a;
    }
}

