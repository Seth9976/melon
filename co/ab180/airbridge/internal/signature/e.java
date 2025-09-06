package co.ab180.airbridge.internal.signature;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\b\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001A\u00020\u0007¢\u0006\u0004\b\n\u0010\u0003J!\u0010\b\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000B\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\b\u0010\u000ER\u0016\u0010\u0010\u001A\u00020\u00018\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\b\u0010\u000FR\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\u0011¨\u0006\u0012"}, d2 = {"Lco/ab180/airbridge/internal/signature/e;", "Lco/ab180/airbridge/internal/signature/b;", "<init>", "()V", "", "secretId", "secretKey", "Lie/H;", "a", "(Ljava/lang/String;Ljava/lang/String;)V", "b", "msg", "", "timestamp", "(Ljava/lang/String;J)Ljava/lang/String;", "Lco/ab180/airbridge/internal/signature/b;", "signerInstance", "()Ljava/lang/String;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class e implements b {
    private static b a;
    @NotNull
    public static final e b;

    static {
        e.b = new e();
        e.a = new c();
    }

    @Override  // co.ab180.airbridge.internal.signature.b
    @Nullable
    public String a() {
        return e.a.a();
    }

    @Override  // co.ab180.airbridge.internal.signature.b
    @Nullable
    public String a(@NotNull String s, long v) {
        return e.a.a(s, v);
    }

    public final void a(@NotNull String s, @NotNull String s1) {
        e.a = new a(s, s1);
    }

    public final void b() {
        e.a = new c();
    }
}

