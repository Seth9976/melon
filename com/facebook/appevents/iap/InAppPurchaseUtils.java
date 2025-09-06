package com.facebook.appevents.iap;

import android.content.Context;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007J#\u0010\u0007\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u0006H\u0001¢\u0006\u0002\b\nJE\u0010\u000B\u001A\u0004\u0018\u00010\f2\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u000E\u001A\u00020\u00062\u001E\u0010\u000F\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0010\"\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0013\u001A\u0004\u0018\u00010\f2\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u000E\u001A\u00020\u00062\u001E\u0010\u000F\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0010\"\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0012JE\u0010\u0014\u001A\u0004\u0018\u00010\u00012\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0015\u001A\u00020\f2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00012\u0016\u0010\u000F\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0017¨\u0006\u001A"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseUtils;", "", "()V", "getClass", "Ljava/lang/Class;", "className", "", "getClassFromContext", "context", "Landroid/content/Context;", "getClassFromContext$facebook_core_release", "getDeclaredMethod", "Ljava/lang/reflect/Method;", "clazz", "methodName", "args", "", "getDeclaredMethod$facebook_core_release", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getMethod", "invokeMethod", "method", "obj", "(Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "BillingClientVersion", "IAPProductType", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InAppPurchaseUtils {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "NONE", "V1", "V2_V4", "V5_V7", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum BillingClientVersion {
        NONE("none"),
        V1("Android-GPBL-V1"),
        V2_V4("Android-GPBL-V2-V4"),
        V5_V7("Android-GPBL-V5-V7");

        @NotNull
        private final String type;

        private static final BillingClientVersion[] $values() [...] // Inlined contents

        private BillingClientVersion(String s1) {
            this.type = s1;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "INAPP", "SUBS", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum IAPProductType {
        INAPP("inapp"),
        SUBS("subs");

        @NotNull
        private final String type;

        private static final IAPProductType[] $values() [...] // Inlined contents

        private IAPProductType(String s1) {
            this.type = s1;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    @NotNull
    public static final InAppPurchaseUtils INSTANCE;

    static {
        InAppPurchaseUtils.INSTANCE = new InAppPurchaseUtils();
    }

    @Nullable
    public static final Class getClass(@NotNull String s) {
        Class class0 = InAppPurchaseUtils.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(s, "className");
            try {
                return Class.forName(s);
            }
            catch(ClassNotFoundException unused_ex) {
                return null;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @Nullable
    public static final Class getClassFromContext$facebook_core_release(@NotNull Context context0, @NotNull String s) {
        Class class0 = InAppPurchaseUtils.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(context0, "context");
            q.g(s, "className");
            try {
                return context0.getClassLoader().loadClass(s);
            }
            catch(ClassNotFoundException unused_ex) {
                return null;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @Nullable
    public static final Method getDeclaredMethod$facebook_core_release(@NotNull Class class0, @NotNull String s, @NotNull Class[] arr_class) {
        Class class1 = InAppPurchaseUtils.class;
        if(CrashShieldHandler.isObjectCrashing(class1)) {
            return null;
        }
        try {
            q.g(class0, "clazz");
            q.g(s, "methodName");
            q.g(arr_class, "args");
            try {
                return class0.getDeclaredMethod(s, ((Class[])Arrays.copyOf(arr_class, arr_class.length)));
            }
            catch(NoSuchMethodException unused_ex) {
                return null;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class1);
            return null;
        }
    }

    @Nullable
    public static final Method getMethod(@NotNull Class class0, @NotNull String s, @NotNull Class[] arr_class) {
        Class class1 = InAppPurchaseUtils.class;
        if(CrashShieldHandler.isObjectCrashing(class1)) {
            return null;
        }
        try {
            q.g(class0, "clazz");
            q.g(s, "methodName");
            q.g(arr_class, "args");
            try {
                return class0.getMethod(s, ((Class[])Arrays.copyOf(arr_class, arr_class.length)));
            }
            catch(NoSuchMethodException unused_ex) {
                return null;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class1);
            return null;
        }
    }

    @Nullable
    public static final Object invokeMethod(@NotNull Class class0, @NotNull Method method0, @Nullable Object object0, @NotNull Object[] arr_object) {
        Class class1 = InAppPurchaseUtils.class;
        if(CrashShieldHandler.isObjectCrashing(class1)) {
            return null;
        }
        try {
            q.g(class0, "clazz");
            q.g(method0, "method");
            q.g(arr_object, "args");
            if(object0 != null) {
                object0 = class0.cast(object0);
            }
            try {
                return method0.invoke(object0, Arrays.copyOf(arr_object, arr_object.length));
            }
            catch(IllegalAccessException | InvocationTargetException unused_ex) {
                return null;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class1);
            return null;
        }
    }
}

