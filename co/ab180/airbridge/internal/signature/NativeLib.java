package co.ab180.airbridge.internal.signature;

import co.ab180.airbridge.internal.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000F\u0010\u0010J*\u0010\u0007\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0086 ¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001A\u00020\t8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\n\u0010\u000BR\u0013\u0010\u000E\u001A\u00020\t8F@\u0006¢\u0006\u0006\u001A\u0004\b\n\u0010\r¨\u0006\u0011"}, d2 = {"Lco/ab180/airbridge/internal/signature/NativeLib;", "", "", "secretKey", "meg", "", "timestamp", "generate", "(Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;", "", "a", "Z", "_isLoaded", "()Z", "isLoaded", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class NativeLib {
    private boolean a;

    public NativeLib() {
        try {
            System.loadLibrary("airbridgelib");
            this.a = true;
        }
        catch(Throwable throwable0) {
            b.e.g("Failed to load airbridge native library: " + throwable0.getMessage(), new Object[0]);
        }
    }

    public final boolean a() {
        return this.a;
    }

    @Nullable
    public final native String generate(@NotNull String arg1, @NotNull String arg2, long arg3) {
    }
}

