package androidx.window.core;

import De.d;
import P4.a;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import ie.H;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@SuppressLint({"BanUncheckedReflection"})
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001:\u0002\'(B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u0006H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ;\u0010\u000F\u001A\u00020\u0001\"\b\b\u0000\u0010\t*\u00020\u00012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\n2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\fH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0012\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0000\u00A2\u0006\u0004\b\u0011\u0010\bJI\u0010\u0016\u001A\u00020\r\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u00012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0015\u001A\u00020\u00142\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\f\u00A2\u0006\u0004\b\u0016\u0010\u0017J[\u0010\u001D\u001A\u00020\u001C\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u00012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u001A2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\fH\u0007\u00A2\u0006\u0004\b\u001D\u0010\u001EJS\u0010\u001F\u001A\u00020\u001C\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u00012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u00142\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\fH\u0007\u00A2\u0006\u0004\b\u001F\u0010 J[\u0010\u001D\u001A\u00020\u001C\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u00012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u00142\u0006\u0010\"\u001A\u00020!2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\fH\u0007\u00A2\u0006\u0004\b\u001D\u0010#JQ\u0010$\u001A\u00020\r\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u00012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u001A2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\f\u00A2\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010&\u00A8\u0006)"}, d2 = {"Landroidx/window/core/ConsumerAdapter;", "", "Ljava/lang/ClassLoader;", "loader", "<init>", "(Ljava/lang/ClassLoader;)V", "Ljava/lang/Class;", "unsafeConsumerClass", "()Ljava/lang/Class;", "T", "LDe/d;", "clazz", "Lkotlin/Function1;", "Lie/H;", "consumer", "buildConsumer", "(LDe/d;Lwe/k;)Ljava/lang/Object;", "consumerClassOrNull$window_release", "consumerClassOrNull", "obj", "", "methodName", "addConsumer", "(Ljava/lang/Object;LDe/d;Ljava/lang/String;Lwe/k;)V", "addMethodName", "removeMethodName", "Landroid/app/Activity;", "activity", "Landroidx/window/core/ConsumerAdapter$Subscription;", "createSubscription", "(Ljava/lang/Object;LDe/d;Ljava/lang/String;Ljava/lang/String;Landroid/app/Activity;Lwe/k;)Landroidx/window/core/ConsumerAdapter$Subscription;", "createSubscriptionNoActivity", "(Ljava/lang/Object;LDe/d;Ljava/lang/String;Ljava/lang/String;Lwe/k;)Landroidx/window/core/ConsumerAdapter$Subscription;", "Landroid/content/Context;", "context", "(Ljava/lang/Object;LDe/d;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Lwe/k;)Landroidx/window/core/ConsumerAdapter$Subscription;", "createConsumer", "(Ljava/lang/Object;LDe/d;Ljava/lang/String;Landroid/app/Activity;Lwe/k;)V", "Ljava/lang/ClassLoader;", "ConsumerHandler", "Subscription", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ConsumerAdapter {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0010\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B)\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000F\u001A\u00020\u000E*\u00020\u000B2\u0010\u0010\r\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J%\u0010\u0011\u001A\u00020\u000E*\u00020\u000B2\u0010\u0010\r\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J%\u0010\u0012\u001A\u00020\u000E*\u00020\u000B2\u0010\u0010\r\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J%\u0010\u0013\u001A\u00020\u000E*\u00020\u000B2\u0010\u0010\r\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0010J2\u0010\u0017\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u000B2\u0010\u0010\u0016\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001A\u001A\u00020\u00072\u0006\u0010\u0019\u001A\u00028\u0000¢\u0006\u0004\b\u001A\u0010\u001BR\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001CR \u0010\b\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001D¨\u0006\u001E"}, d2 = {"Landroidx/window/core/ConsumerAdapter$ConsumerHandler;", "", "T", "Ljava/lang/reflect/InvocationHandler;", "LDe/d;", "clazz", "Lkotlin/Function1;", "Lie/H;", "consumer", "<init>", "(LDe/d;Lwe/k;)V", "Ljava/lang/reflect/Method;", "", "args", "", "isEquals", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)Z", "isHashCode", "isAccept", "isToString", "obj", "method", "parameters", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "parameter", "invokeAccept", "(Ljava/lang/Object;)V", "LDe/d;", "Lwe/k;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    static final class ConsumerHandler implements InvocationHandler {
        @NotNull
        private final d clazz;
        @NotNull
        private final k consumer;

        public ConsumerHandler(@NotNull d d0, @NotNull k k0) {
            q.g(d0, "clazz");
            q.g(k0, "consumer");
            super();
            this.clazz = d0;
            this.consumer = k0;
        }

        @Override
        @NotNull
        public Object invoke(@NotNull Object object0, @NotNull Method method0, @Nullable Object[] arr_object) {
            q.g(object0, "obj");
            q.g(method0, "method");
            Object object1 = null;
            boolean z = false;
            if(this.isAccept(method0, arr_object)) {
                d d0 = this.clazz;
                if(arr_object != null) {
                    object1 = arr_object[0];
                }
                a.f(d0, object1);
                this.invokeAccept(object1);
                return H.a;
            }
            if(this.isEquals(method0, arr_object)) {
                if(arr_object != null) {
                    object1 = arr_object[0];
                }
                if(object0 == object1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            if(this.isHashCode(method0, arr_object)) {
                return this.consumer.hashCode();
            }
            if(!this.isToString(method0, arr_object)) {
                throw new UnsupportedOperationException("Unexpected method call object:" + object0 + ", method: " + method0 + ", args: " + arr_object);
            }
            return this.consumer.toString();
        }

        public final void invokeAccept(@NotNull Object object0) {
            q.g(object0, "parameter");
            this.consumer.invoke(object0);
        }

        private final boolean isAccept(Method method0, Object[] arr_object) {
            return q.b(method0.getName(), "accept") && arr_object != null && arr_object.length == 1;
        }

        // 去混淆评级： 低(20)
        private final boolean isEquals(Method method0, Object[] arr_object) {
            return q.b(method0.getName(), "equals") && method0.getReturnType().equals(Boolean.TYPE) && arr_object != null && arr_object.length == 1;
        }

        // 去混淆评级： 低(20)
        private final boolean isHashCode(Method method0, Object[] arr_object) {
            return q.b(method0.getName(), "hashCode") && method0.getReturnType().equals(Integer.TYPE) && arr_object == null;
        }

        // 去混淆评级： 低(20)
        private final boolean isToString(Method method0, Object[] arr_object) {
            return q.b(method0.getName(), "toString") && method0.getReturnType().equals(String.class) && arr_object == null;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/window/core/ConsumerAdapter$Subscription;", "", "Lie/H;", "dispose", "()V", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public interface Subscription {
        void dispose();
    }

    @NotNull
    private final ClassLoader loader;

    public ConsumerAdapter(@NotNull ClassLoader classLoader0) {
        q.g(classLoader0, "loader");
        super();
        this.loader = classLoader0;
    }

    public final void addConsumer(@NotNull Object object0, @NotNull d d0, @NotNull String s, @NotNull k k0) {
        q.g(object0, "obj");
        q.g(d0, "clazz");
        q.g(s, "methodName");
        q.g(k0, "consumer");
        object0.getClass().getMethod(s, this.unsafeConsumerClass()).invoke(object0, this.buildConsumer(d0, k0));
    }

    private final Object buildConsumer(d d0, k k0) {
        ConsumerHandler consumerAdapter$ConsumerHandler0 = new ConsumerHandler(d0, k0);
        Class[] arr_class = {this.unsafeConsumerClass()};
        Object object0 = Proxy.newProxyInstance(this.loader, arr_class, consumerAdapter$ConsumerHandler0);
        q.f(object0, "newProxyInstance(...)");
        return object0;
    }

    @Nullable
    public final Class consumerClassOrNull$window_release() {
        try {
            return this.unsafeConsumerClass();
        }
        catch(ClassNotFoundException unused_ex) {
            return null;
        }
    }

    public final void createConsumer(@NotNull Object object0, @NotNull d d0, @NotNull String s, @NotNull Activity activity0, @NotNull k k0) {
        q.g(object0, "obj");
        q.g(d0, "clazz");
        q.g(s, "addMethodName");
        q.g(activity0, "activity");
        q.g(k0, "consumer");
        Object object1 = this.buildConsumer(d0, k0);
        Class class0 = object0.getClass();
        Class class1 = this.unsafeConsumerClass();
        class0.getMethod(s, Activity.class, class1).invoke(object0, activity0, object1);
    }

    @NotNull
    public final Subscription createSubscription(@NotNull Object object0, @NotNull d d0, @NotNull String s, @NotNull String s1, @NotNull Activity activity0, @NotNull k k0) {
        q.g(object0, "obj");
        q.g(d0, "clazz");
        q.g(s, "addMethodName");
        q.g(s1, "removeMethodName");
        q.g(activity0, "activity");
        q.g(k0, "consumer");
        Object object1 = this.buildConsumer(d0, k0);
        Class class0 = object0.getClass();
        Class class1 = this.unsafeConsumerClass();
        class0.getMethod(s, Activity.class, class1).invoke(object0, activity0, object1);
        return new Subscription() {
            @Override  // androidx.window.core.ConsumerAdapter$Subscription
            public void dispose() {
                object0.invoke(object1, this.$javaConsumer);
            }
        };
    }

    @NotNull
    public final Subscription createSubscription(@NotNull Object object0, @NotNull d d0, @NotNull String s, @NotNull String s1, @NotNull Context context0, @NotNull k k0) {
        q.g(object0, "obj");
        q.g(d0, "clazz");
        q.g(s, "addMethodName");
        q.g(s1, "removeMethodName");
        q.g(context0, "context");
        q.g(k0, "consumer");
        Object object1 = this.buildConsumer(d0, k0);
        Class class0 = object0.getClass();
        Class class1 = this.unsafeConsumerClass();
        class0.getMethod(s, Context.class, class1).invoke(object0, context0, object1);
        return new Subscription() {
            @Override  // androidx.window.core.ConsumerAdapter$Subscription
            public void dispose() {
                object0.invoke(object1, this.$javaConsumer);
            }
        };
    }

    @NotNull
    public final Subscription createSubscriptionNoActivity(@NotNull Object object0, @NotNull d d0, @NotNull String s, @NotNull String s1, @NotNull k k0) {
        q.g(object0, "obj");
        q.g(d0, "clazz");
        q.g(s, "addMethodName");
        q.g(s1, "removeMethodName");
        q.g(k0, "consumer");
        Object object1 = this.buildConsumer(d0, k0);
        object0.getClass().getMethod(s, this.unsafeConsumerClass()).invoke(object0, object1);
        return new Subscription() {
            @Override  // androidx.window.core.ConsumerAdapter$Subscription
            public void dispose() {
                object0.invoke(object1, this.$javaConsumer);
            }
        };
    }

    private final Class unsafeConsumerClass() {
        Class class0 = this.loader.loadClass("java.util.function.Consumer");
        q.f(class0, "loadClass(...)");
        return class0;
    }
}

