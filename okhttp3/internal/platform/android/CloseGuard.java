package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB#\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001A\u0004\u0018\u00010\u00012\u0006\u0010\b\u001A\u00020\tJ\u0010\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lokhttp3/internal/platform/android/CloseGuard;", "", "getMethod", "Ljava/lang/reflect/Method;", "openMethod", "warnIfOpenMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "createAndOpen", "closer", "", "warnIfOpen", "", "closeGuardInstance", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CloseGuard {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001A\u00020\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/platform/android/CloseGuard$Companion;", "", "()V", "get", "Lokhttp3/internal/platform/android/CloseGuard;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final CloseGuard get() {
            try {
                Class class0 = Class.forName("dalvik.system.CloseGuard");
                return new CloseGuard(class0.getMethod("get", null), class0.getMethod("open", String.class), class0.getMethod("warnIfOpen", null));
            }
            catch(Exception unused_ex) {
                return new CloseGuard(null, null, null);
            }
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private final Method getMethod;
    @Nullable
    private final Method openMethod;
    @Nullable
    private final Method warnIfOpenMethod;

    static {
        CloseGuard.Companion = new Companion(null);
    }

    public CloseGuard(@Nullable Method method0, @Nullable Method method1, @Nullable Method method2) {
        this.getMethod = method0;
        this.openMethod = method1;
        this.warnIfOpenMethod = method2;
    }

    @Nullable
    public final Object createAndOpen(@NotNull String s) {
        q.g(s, "closer");
        Method method0 = this.getMethod;
        if(method0 != null) {
            try {
                Object object0 = method0.invoke(null, null);
                q.d(this.openMethod);
                this.openMethod.invoke(object0, s);
                return object0;
            }
            catch(Exception unused_ex) {
            }
        }
        return null;
    }

    public final boolean warnIfOpen(@Nullable Object object0) {
        if(object0 != null) {
            try {
                q.d(this.warnIfOpenMethod);
                this.warnIfOpenMethod.invoke(object0, null);
                return true;
            }
            catch(Exception unused_ex) {
            }
        }
        return false;
    }
}

