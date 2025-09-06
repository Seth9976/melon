package com.facebook.appevents.iap;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.Method;
import java.util.List;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B=\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\u0006¢\u0006\u0002\u0010\nJ\"\u0010\r\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u000E\u001A\u00020\u000F2\u0010\u0010\u0010\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011R\u000E\u0010\t\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "", "skuDetailsParamsClazz", "Ljava/lang/Class;", "builderClazz", "newBuilderMethod", "Ljava/lang/reflect/Method;", "setTypeMethod", "setSkusListMethod", "buildMethod", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getSkuDetailsParamsClazz", "()Ljava/lang/Class;", "getSkuDetailsParams", "productType", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;", "skuIDs", "", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InAppPurchaseSkuDetailsWrapper {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0002J\n\u0010\r\u001A\u0004\u0018\u00010\u000BH\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper$Companion;", "", "()V", "CLASSNAME_SKU_DETAILS_PARAMS", "", "CLASSNAME_SKU_DETAILS_PARAMS_BUILDER", "METHOD_BUILD", "METHOD_NEW_BUILDER", "METHOD_SET_SKU_LIST", "METHOD_SET_TYPE", "instance", "Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "createInstance", "getOrCreateInstance", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final InAppPurchaseSkuDetailsWrapper createInstance() {
            Class class0 = InAppPurchaseUtils.getClass("com.android.billingclient.api.SkuDetailsParams");
            Class class1 = InAppPurchaseUtils.getClass("com.android.billingclient.api.SkuDetailsParams$Builder");
            if(class0 != null && class1 != null) {
                Method method0 = InAppPurchaseUtils.getMethod(class0, "newBuilder", new Class[0]);
                Method method1 = InAppPurchaseUtils.getMethod(class1, "setType", new Class[]{String.class});
                Method method2 = InAppPurchaseUtils.getMethod(class1, "setSkusList", new Class[]{List.class});
                Method method3 = InAppPurchaseUtils.getMethod(class1, "build", new Class[0]);
                if(method0 != null && method1 != null && method2 != null && method3 != null) {
                    InAppPurchaseSkuDetailsWrapper.access$setInstance$cp(new InAppPurchaseSkuDetailsWrapper(class0, class1, method0, method1, method2, method3));
                    return InAppPurchaseSkuDetailsWrapper.access$getInstance$cp();
                }
            }
            return null;
        }

        @Nullable
        public final InAppPurchaseSkuDetailsWrapper getOrCreateInstance() {
            synchronized(this) {
                InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper0 = InAppPurchaseSkuDetailsWrapper.access$getInstance$cp();
                if(inAppPurchaseSkuDetailsWrapper0 == null) {
                    inAppPurchaseSkuDetailsWrapper0 = this.createInstance();
                }
                return inAppPurchaseSkuDetailsWrapper0;
            }
        }
    }

    @NotNull
    private static final String CLASSNAME_SKU_DETAILS_PARAMS = "com.android.billingclient.api.SkuDetailsParams";
    @NotNull
    private static final String CLASSNAME_SKU_DETAILS_PARAMS_BUILDER = "com.android.billingclient.api.SkuDetailsParams$Builder";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String METHOD_BUILD = "build";
    @NotNull
    private static final String METHOD_NEW_BUILDER = "newBuilder";
    @NotNull
    private static final String METHOD_SET_SKU_LIST = "setSkusList";
    @NotNull
    private static final String METHOD_SET_TYPE = "setType";
    @NotNull
    private final Method buildMethod;
    @NotNull
    private final Class builderClazz;
    @Nullable
    private static InAppPurchaseSkuDetailsWrapper instance;
    @NotNull
    private final Method newBuilderMethod;
    @NotNull
    private final Method setSkusListMethod;
    @NotNull
    private final Method setTypeMethod;
    @NotNull
    private final Class skuDetailsParamsClazz;

    static {
        InAppPurchaseSkuDetailsWrapper.Companion = new Companion(null);
    }

    public InAppPurchaseSkuDetailsWrapper(@NotNull Class class0, @NotNull Class class1, @NotNull Method method0, @NotNull Method method1, @NotNull Method method2, @NotNull Method method3) {
        q.g(class0, "skuDetailsParamsClazz");
        q.g(class1, "builderClazz");
        q.g(method0, "newBuilderMethod");
        q.g(method1, "setTypeMethod");
        q.g(method2, "setSkusListMethod");
        q.g(method3, "buildMethod");
        super();
        this.skuDetailsParamsClazz = class0;
        this.builderClazz = class1;
        this.newBuilderMethod = method0;
        this.setTypeMethod = method1;
        this.setSkusListMethod = method2;
        this.buildMethod = method3;
    }

    // 去混淆评级： 低(20)
    public static final InAppPurchaseSkuDetailsWrapper access$getInstance$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseSkuDetailsWrapper.class) ? null : InAppPurchaseSkuDetailsWrapper.instance;
    }

    public static final void access$setInstance$cp(InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper0) {
        if(CrashShieldHandler.isObjectCrashing(InAppPurchaseSkuDetailsWrapper.class)) {
            return;
        }
        InAppPurchaseSkuDetailsWrapper.instance = inAppPurchaseSkuDetailsWrapper0;
    }

    @Nullable
    public static final InAppPurchaseSkuDetailsWrapper getOrCreateInstance() {
        Class class0 = InAppPurchaseSkuDetailsWrapper.class;
        __monitor_enter(class0);
        int v = FIN.finallyOpen$NT();
        if(CrashShieldHandler.isObjectCrashing(InAppPurchaseSkuDetailsWrapper.class)) {
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(class0);
            FIN.finallyCodeEnd$NT(v);
            return null;
        }
        try {
            InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper0 = InAppPurchaseSkuDetailsWrapper.Companion.getOrCreateInstance();
            FIN.finallyExec$NT(v);
            return inAppPurchaseSkuDetailsWrapper0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, InAppPurchaseSkuDetailsWrapper.class);
            FIN.finallyExec$NT(v);
            return null;
        }
    }

    @Nullable
    public final Object getSkuDetailsParams(@NotNull IAPProductType inAppPurchaseUtils$IAPProductType0, @Nullable List list0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(inAppPurchaseUtils$IAPProductType0, "productType");
            Object object0 = InAppPurchaseUtils.invokeMethod(this.skuDetailsParamsClazz, this.newBuilderMethod, null, new Object[0]);
            if(object0 == null) {
                return null;
            }
            Object object1 = InAppPurchaseUtils.invokeMethod(this.builderClazz, this.setTypeMethod, object0, new Object[]{inAppPurchaseUtils$IAPProductType0.getType()});
            if(object1 == null) {
                return null;
            }
            Object object2 = InAppPurchaseUtils.invokeMethod(this.builderClazz, this.setSkusListMethod, object1, new Object[]{list0});
            return object2 == null ? null : InAppPurchaseUtils.invokeMethod(this.builderClazz, this.buildMethod, object2, new Object[0]);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final Class getSkuDetailsParamsClazz() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.skuDetailsParamsClazz;
    }
}

