package co.ab180.airbridge.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0001\n\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\r\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\f¨\u0006\u000E"}, d2 = {"Lco/ab180/airbridge/internal/n;", "Lco/ab180/airbridge/internal/m;", "<init>", "()V", "Lie/H;", "i", "Lco/ab180/airbridge/internal/b$a;", "k", "()Lco/ab180/airbridge/internal/b$a;", "close", "co/ab180/airbridge/internal/n$a", "a", "Lco/ab180/airbridge/internal/n$a;", "interceptor", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class n implements m {
    private final a a;

    public n() {
        @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J3\u0010\n\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"co/ab180/airbridge/internal/n$a", "Lco/ab180/airbridge/internal/b$a;", "", "priority", "", "tag", "message", "", "t", "Lie/H;", "a", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
        public static final class a extends co.ab180.airbridge.internal.b.a {
            @Override  // co.ab180.airbridge.internal.b$a
            public void a(int v, @Nullable String s, @NotNull String s1, @Nullable Throwable throwable0) {
            }
        }

        this.a = new a();
    }

    @Override
    public void close() {
    }

    @Override  // co.ab180.airbridge.internal.m
    public void i() {
    }

    @Override  // co.ab180.airbridge.internal.m
    @NotNull
    public co.ab180.airbridge.internal.b.a k() {
        return this.a;
    }
}

