package co.ab180.airbridge.internal.signature;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001A\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0006\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001E\u0010\u000B\u001A\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\u0006\u0010\nR\u0016\u0010\u000E\u001A\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0016\u0010\u0010\u001A\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\t¨\u0006\u0013"}, d2 = {"Lco/ab180/airbridge/internal/signature/a;", "Lco/ab180/airbridge/internal/signature/b;", "", "msg", "", "timestamp", "a", "(Ljava/lang/String;J)Ljava/lang/String;", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "secretId", "Lco/ab180/airbridge/internal/signature/NativeLib;", "Lco/ab180/airbridge/internal/signature/NativeLib;", "nativeLib", "c", "secretKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
final class a implements b {
    private final NativeLib a;
    @Nullable
    private final String b;
    private final String c;

    public a(@Nullable String s, @NotNull String s1) {
        this.b = s;
        this.c = s1;
        this.a = new NativeLib();
    }

    @Override  // co.ab180.airbridge.internal.signature.b
    @Nullable
    public String a() {
        return this.b;
    }

    // 去混淆评级： 低(20)
    @Override  // co.ab180.airbridge.internal.signature.b
    @Nullable
    public String a(@NotNull String s, long v) {
        return this.a.a() ? this.a.generate(this.c, s, v) : null;
    }
}

