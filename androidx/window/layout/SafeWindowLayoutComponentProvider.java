package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001A\u00020\u0018H\u0002J\r\u0010\u0019\u001A\u00020\u0018H\u0001¢\u0006\u0002\b\u001AJ\r\u0010\u001B\u001A\u00020\u0018H\u0001¢\u0006\u0002\b\u001CJ\r\u0010\u001D\u001A\u00020\u0018H\u0001¢\u0006\u0002\b\u001EJ\b\u0010\u001F\u001A\u00020\u0018H\u0002J\b\u0010 \u001A\u00020\u0018H\u0002J\b\u0010!\u001A\u00020\u0018H\u0002J\b\u0010\"\u001A\u00020\u0018H\u0002J\b\u0010#\u001A\u00020\u0018H\u0002J\b\u0010$\u001A\u00020\u0018H\u0002J\r\u0010%\u001A\u00020\u0018H\u0001¢\u0006\u0002\b&J\b\u0010\'\u001A\u00020\u0018H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0018\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\b8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\nR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\b8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\nR\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001A\u0006\u0012\u0002\b\u00030\b8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\n¨\u0006("}, d2 = {"Landroidx/window/layout/SafeWindowLayoutComponentProvider;", "", "loader", "Ljava/lang/ClassLoader;", "consumerAdapter", "Landroidx/window/core/ConsumerAdapter;", "(Ljava/lang/ClassLoader;Landroidx/window/core/ConsumerAdapter;)V", "displayFoldFeatureClass", "Ljava/lang/Class;", "getDisplayFoldFeatureClass", "()Ljava/lang/Class;", "foldingFeatureClass", "getFoldingFeatureClass", "safeWindowExtensionsProvider", "Landroidx/window/SafeWindowExtensionsProvider;", "supportedWindowFeaturesClass", "getSupportedWindowFeaturesClass", "windowLayoutComponent", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "getWindowLayoutComponent", "()Landroidx/window/extensions/layout/WindowLayoutComponent;", "windowLayoutComponentClass", "getWindowLayoutComponentClass", "canUseWindowLayoutComponent", "", "hasValidVendorApiLevel1", "hasValidVendorApiLevel1$window_release", "hasValidVendorApiLevel2", "hasValidVendorApiLevel2$window_release", "hasValidVendorApiLevel6", "hasValidVendorApiLevel6$window_release", "isDisplayFoldFeatureValid", "isFoldingFeatureValid", "isGetSupportedWindowFeaturesValid", "isMethodWindowLayoutInfoListenerJavaConsumerValid", "isMethodWindowLayoutInfoListenerWindowConsumerValid", "isSupportedWindowFeaturesValid", "isWindowLayoutComponentAccessible", "isWindowLayoutComponentAccessible$window_release", "isWindowLayoutProviderValid", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SafeWindowLayoutComponentProvider {
    @NotNull
    private final ConsumerAdapter consumerAdapter;
    @NotNull
    private final ClassLoader loader;
    @NotNull
    private final SafeWindowExtensionsProvider safeWindowExtensionsProvider;

    public SafeWindowLayoutComponentProvider(@NotNull ClassLoader classLoader0, @NotNull ConsumerAdapter consumerAdapter0) {
        q.g(classLoader0, "loader");
        q.g(consumerAdapter0, "consumerAdapter");
        super();
        this.loader = classLoader0;
        this.consumerAdapter = consumerAdapter0;
        this.safeWindowExtensionsProvider = new SafeWindowExtensionsProvider(classLoader0);
    }

    private final boolean canUseWindowLayoutComponent() {
        if(!this.isWindowLayoutComponentAccessible$window_release()) {
            return false;
        }
        int v = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
        if(v < 1) {
            return false;
        }
        if(v == 1) {
            return this.hasValidVendorApiLevel1$window_release();
        }
        return v >= 5 ? this.hasValidVendorApiLevel6$window_release() : this.hasValidVendorApiLevel2$window_release();
    }

    private final Class getDisplayFoldFeatureClass() {
        Class class0 = this.loader.loadClass("androidx.window.extensions.layout.DisplayFoldFeature");
        q.f(class0, "loadClass(...)");
        return class0;
    }

    private final Class getFoldingFeatureClass() {
        Class class0 = this.loader.loadClass("androidx.window.extensions.layout.FoldingFeature");
        q.f(class0, "loadClass(...)");
        return class0;
    }

    private final Class getSupportedWindowFeaturesClass() {
        Class class0 = this.loader.loadClass("androidx.window.extensions.layout.SupportedWindowFeatures");
        q.f(class0, "loadClass(...)");
        return class0;
    }

    @Nullable
    public final WindowLayoutComponent getWindowLayoutComponent() {
        if(this.canUseWindowLayoutComponent()) {
            try {
                return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
            }
            catch(UnsupportedOperationException unused_ex) {
            }
        }
        return null;
    }

    private final Class getWindowLayoutComponentClass() {
        Class class0 = this.loader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        q.f(class0, "loadClass(...)");
        return class0;
    }

    public final boolean hasValidVendorApiLevel1$window_release() {
        return this.isMethodWindowLayoutInfoListenerJavaConsumerValid();
    }

    // 去混淆评级： 低(20)
    public final boolean hasValidVendorApiLevel2$window_release() {
        return this.hasValidVendorApiLevel1$window_release() && this.isMethodWindowLayoutInfoListenerWindowConsumerValid();
    }

    // 去混淆评级： 低(40)
    public final boolean hasValidVendorApiLevel6$window_release() {
        return this.hasValidVendorApiLevel2$window_release() && this.isDisplayFoldFeatureValid() && this.isSupportedWindowFeaturesValid() && this.isGetSupportedWindowFeaturesValid();
    }

    private final boolean isDisplayFoldFeatureValid() {
        return ReflectionUtils.validateReflection$window_release("DisplayFoldFeature is not valid", new a() {
            {
                SafeWindowLayoutComponentProvider.this = safeWindowLayoutComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Class class0 = SafeWindowLayoutComponentProvider.this.getDisplayFoldFeatureClass();
                Method method0 = class0.getMethod("getType", null);
                Class class1 = Integer.TYPE;
                Method method1 = class0.getMethod("hasProperty", class1);
                Method method2 = class0.getMethod("hasProperties", int[].class);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, class1)) {
                    q.d(method1);
                    if(reflectionUtils0.isPublic$window_release(method1)) {
                        Class class2 = Boolean.TYPE;
                        if(reflectionUtils0.doesReturn$window_release(method1, class2)) {
                            q.d(method2);
                            return !reflectionUtils0.isPublic$window_release(method2) || !reflectionUtils0.doesReturn$window_release(method2, class2) ? false : true;
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isFoldingFeatureValid() {
        return ReflectionUtils.validateReflection$window_release("FoldingFeature class is not valid", new a() {
            {
                SafeWindowLayoutComponentProvider.this = safeWindowLayoutComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Class class0 = SafeWindowLayoutComponentProvider.this.getFoldingFeatureClass();
                Method method0 = class0.getMethod("getBounds", null);
                Method method1 = class0.getMethod("getType", null);
                Method method2 = class0.getMethod("getState", null);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                J j0 = I.a;
                if(reflectionUtils0.doesReturn$window_release(method0, j0.b(Rect.class)) && reflectionUtils0.isPublic$window_release(method0)) {
                    q.d(method1);
                    Class class1 = Integer.TYPE;
                    if(reflectionUtils0.doesReturn$window_release(method1, j0.b(class1)) && reflectionUtils0.isPublic$window_release(method1)) {
                        q.d(method2);
                        return !reflectionUtils0.doesReturn$window_release(method2, j0.b(class1)) || !reflectionUtils0.isPublic$window_release(method2) ? false : true;
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isGetSupportedWindowFeaturesValid() {
        return ReflectionUtils.validateReflection$window_release("WindowLayoutComponent#getSupportedWindowFeatures is not valid", new a() {
            {
                SafeWindowLayoutComponentProvider.this = safeWindowLayoutComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeWindowLayoutComponentProvider.this.getWindowLayoutComponentClass().getMethod("getSupportedWindowFeatures", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, SafeWindowLayoutComponentProvider.this.getSupportedWindowFeaturesClass()) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    // 去混淆评级： 中等(60)
    private final boolean isMethodWindowLayoutInfoListenerJavaConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("WindowLayoutComponent#addWindowLayoutInfoListener(android.app.Activity, java.util.function.Consumer) is not valid", new a() {
            {
                SafeWindowLayoutComponentProvider.this = safeWindowLayoutComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Class class0 = SafeWindowLayoutComponentProvider.this.consumerAdapter.consumerClassOrNull$window_release();
                if(class0 == null) {
                    return false;
                }
                Class class1 = SafeWindowLayoutComponentProvider.this.getWindowLayoutComponentClass();
                Method method0 = class1.getMethod("addWindowLayoutInfoListener", Activity.class, class0);
                Method method1 = class1.getMethod("removeWindowLayoutInfoListener", class0);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0)) {
                    q.d(method1);
                    return reflectionUtils0.isPublic$window_release(method1);
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    // 去混淆评级： 中等(60)
    private final boolean isMethodWindowLayoutInfoListenerWindowConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("WindowLayoutComponent#addWindowLayoutInfoListener(android.content.Context, androidx.window.extensions.core.util.function.Consumer) is not valid", new a() {
            {
                SafeWindowLayoutComponentProvider.this = safeWindowLayoutComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Class class0 = SafeWindowLayoutComponentProvider.this.getWindowLayoutComponentClass();
                Method method0 = class0.getMethod("addWindowLayoutInfoListener", Context.class, Consumer.class);
                Method method1 = class0.getMethod("removeWindowLayoutInfoListener", Consumer.class);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0)) {
                    q.d(method1);
                    return reflectionUtils0.isPublic$window_release(method1);
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isSupportedWindowFeaturesValid() {
        return ReflectionUtils.validateReflection$window_release("SupportedWindowFeatures is not valid", new a() {
            {
                SafeWindowLayoutComponentProvider.this = safeWindowLayoutComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeWindowLayoutComponentProvider.this.getSupportedWindowFeaturesClass().getMethod("getDisplayFoldFeatures", null);
                Type type0 = method0.getGenericReturnType();
                q.e(type0, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
                boolean z = false;
                Type type1 = ((ParameterizedType)type0).getActualTypeArguments()[0];
                q.e(type1, "null cannot be cast to non-null type java.lang.Class<*>");
                if(ReflectionUtils.INSTANCE.isPublic$window_release(method0) && ReflectionUtils.INSTANCE.doesReturn$window_release(method0, List.class) && ((Class)type1).equals(SafeWindowLayoutComponentProvider.this.getDisplayFoldFeatureClass())) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    // 去混淆评级： 低(30)
    public final boolean isWindowLayoutComponentAccessible$window_release() {
        return this.safeWindowExtensionsProvider.isWindowExtensionsValid$window_release() && this.isWindowLayoutProviderValid() && this.isFoldingFeatureValid();
    }

    private final boolean isWindowLayoutProviderValid() {
        return ReflectionUtils.validateReflection$window_release("WindowExtensions#getWindowLayoutComponent is not valid", new a() {
            {
                SafeWindowLayoutComponentProvider.this = safeWindowLayoutComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeWindowLayoutComponentProvider.this.safeWindowExtensionsProvider.getWindowExtensionsClass$window_release().getMethod("getWindowLayoutComponent", null);
                Class class0 = SafeWindowLayoutComponentProvider.this.getWindowLayoutComponentClass();
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, class0) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }
}

