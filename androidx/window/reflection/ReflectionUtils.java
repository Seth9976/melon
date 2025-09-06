package androidx.window.reflection;

import De.d;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000B\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001A\u00020\u00072\u0010\u0010\r\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u0006H\u0000¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0016\u001A\u00020\u0007*\u00020\u00112\n\u0010\u0013\u001A\u0006\u0012\u0002\b\u00030\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0016\u001A\u00020\u0007*\u00020\u00112\n\u0010\u0013\u001A\u0006\u0012\u0002\b\u00030\fH\u0000¢\u0006\u0004\b\u0014\u0010\u0017J\'\u0010\u001C\u001A\u00020\u00072\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\f2\n\u0010\u0019\u001A\u0006\u0012\u0002\b\u00030\fH\u0000¢\u0006\u0004\b\u001A\u0010\u001BR\u001C\u0010 \u001A\u00020\u0007*\u0006\u0012\u0002\b\u00030\u001D8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0018\u0010 \u001A\u00020\u0007*\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010!R\u0018\u0010 \u001A\u00020\u0007*\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010#¨\u0006$"}, d2 = {"Landroidx/window/reflection/ReflectionUtils;", "", "<init>", "()V", "", "errorMessage", "Lkotlin/Function0;", "", "block", "validateReflection$window_release", "(Ljava/lang/String;Lwe/a;)Z", "validateReflection", "Ljava/lang/Class;", "classLoader", "checkIsPresent$window_release", "(Lwe/a;)Z", "checkIsPresent", "Ljava/lang/reflect/Method;", "LDe/d;", "clazz", "doesReturn$window_release", "(Ljava/lang/reflect/Method;LDe/d;)Z", "doesReturn", "(Ljava/lang/reflect/Method;Ljava/lang/Class;)Z", "implementation", "requirements", "validateImplementation$window_release", "(Ljava/lang/Class;Ljava/lang/Class;)Z", "validateImplementation", "Ljava/lang/reflect/Constructor;", "isPublic$window_release", "(Ljava/lang/reflect/Constructor;)Z", "isPublic", "(Ljava/lang/reflect/Method;)Z", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)Z", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ReflectionUtils {
    @NotNull
    public static final ReflectionUtils INSTANCE;

    static {
        ReflectionUtils.INSTANCE = new ReflectionUtils();
    }

    public final boolean checkIsPresent$window_release(@NotNull a a0) {
        q.g(a0, "classLoader");
        try {
            a0.invoke();
            return true;
        }
        catch(ClassNotFoundException | NoClassDefFoundError unused_ex) {
            return false;
        }
    }

    public final boolean doesReturn$window_release(@NotNull Method method0, @NotNull d d0) {
        q.g(method0, "<this>");
        q.g(d0, "clazz");
        return this.doesReturn$window_release(method0, df.d.v(d0));
    }

    public final boolean doesReturn$window_release(@NotNull Method method0, @NotNull Class class0) {
        q.g(method0, "<this>");
        q.g(class0, "clazz");
        return method0.getReturnType().equals(class0);
    }

    public final boolean isPublic$window_release(@NotNull Constructor constructor0) {
        q.g(constructor0, "<this>");
        return Modifier.isPublic(constructor0.getModifiers());
    }

    public final boolean isPublic$window_release(@NotNull Field field0) {
        q.g(field0, "<this>");
        return Modifier.isPublic(field0.getModifiers());
    }

    public final boolean isPublic$window_release(@NotNull Method method0) {
        q.g(method0, "<this>");
        return Modifier.isPublic(method0.getModifiers());
    }

    public final boolean validateImplementation$window_release(@NotNull Class class0, @NotNull Class class1) {
        q.g(class0, "implementation");
        q.g(class1, "requirements");
        Method[] arr_method = class1.getMethods();
        q.f(arr_method, "getMethods(...)");
        for(int v = 0; v < arr_method.length; ++v) {
            Method method0 = arr_method[v];
            if(!ReflectionUtils.validateReflection$window_release((class0.getName() + '#' + method0.getName() + " is not valid"), new a(method0) {
                final Class $implementation;
                final Method $it;

                {
                    this.$implementation = class0;
                    this.$it = method0;
                    super(0);
                }

                public final Boolean invoke() {
                    String s = this.$it.getName();
                    Class[] arr_class = this.$it.getParameterTypes();
                    Class[] arr_class1 = (Class[])Arrays.copyOf(arr_class, arr_class.length);
                    Method method0 = this.$implementation.getMethod(s, arr_class1);
                    ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                    q.d(method0);
                    if(reflectionUtils0.isPublic$window_release(method0)) {
                        Class class0 = this.$it.getReturnType();
                        q.f(class0, "getReturnType(...)");
                        return reflectionUtils0.doesReturn$window_release(method0, class0);
                    }
                    return false;
                }

                @Override  // we.a
                public Object invoke() {
                    return this.invoke();
                }
            })) {
                return false;
            }
        }
        return true;
    }

    public static final boolean validateReflection$window_release(@NotNull String s, @NotNull a a0) {
        q.g(s, "errorMessage");
        q.g(a0, "block");
        try {
            boolean z = ((Boolean)a0.invoke()).booleanValue();
            if(!z) {
                Log.e("ReflectionGuard", s);
            }
            return z;
        }
        catch(ClassNotFoundException unused_ex) {
            Log.e("ReflectionGuard", "ClassNotFound: " + s);
            return false;
        }
        catch(NoSuchMethodException unused_ex) {
            Log.e("ReflectionGuard", "NoSuchMethod: " + s);
            return false;
        }
        catch(NoSuchFieldException unused_ex) {
            Log.e("ReflectionGuard", "NoSuchField: " + s);
            return false;
        }
    }
}

