package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineExceptionHandler;
import me.a;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0018\u0010\u0010\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lme/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "Ljava/lang/reflect/Method;", "preHandler", "()Ljava/lang/reflect/Method;", "Lme/i;", "context", "", "exception", "Lie/H;", "handleException", "(Lme/i;Ljava/lang/Throwable;)V", "", "_preHandler", "Ljava/lang/Object;", "kotlinx-coroutines-android"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class AndroidExceptionPreHandler extends a implements CoroutineExceptionHandler {
    @Nullable
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.Key);
        this._preHandler = this;
    }

    @Override  // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(@NotNull i i0, @NotNull Throwable throwable0) {
        if(Build.VERSION.SDK_INT < 28) {
            Method method0 = this.preHandler();
            Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0 = null;
            Object object0 = method0 == null ? null : method0.invoke(null, null);
            if(object0 instanceof Thread.UncaughtExceptionHandler) {
                thread$UncaughtExceptionHandler0 = (Thread.UncaughtExceptionHandler)object0;
            }
            if(thread$UncaughtExceptionHandler0 != null) {
                thread$UncaughtExceptionHandler0.uncaughtException(Thread.currentThread(), throwable0);
            }
        }
    }

    private final Method preHandler() {
        Method method0;
        Object object0 = this._preHandler;
        if(object0 != this) {
            return (Method)object0;
        }
        try {
            method0 = null;
            Method method1 = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", null);
            if(Modifier.isPublic(method1.getModifiers()) && Modifier.isStatic(method1.getModifiers())) {
                method0 = method1;
            }
        }
        catch(Throwable unused_ex) {
        }
        this._preHandler = method0;
        return method0;
    }
}

