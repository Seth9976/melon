package androidx.window.core;

import De.d;
import P4.a;
import android.annotation.SuppressLint;
import android.util.Pair;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@SuppressLint({"BanUncheckedReflection"})
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0003\u001A\u001B\u001CB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\t\u0010\bJ9\u0010\u0011\u001A\u00020\u0001\"\b\b\u0000\u0010\u000B*\u00020\u00012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\f2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\u0004\b\u0011\u0010\u0012JW\u0010\u0017\u001A\u00020\u0001\"\b\b\u0000\u0010\u000B*\u00020\u0001\"\b\b\u0001\u0010\u0013*\u00020\u00012\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\f2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00010\f2\u0018\u0010\u0010\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000F0\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019¨\u0006\u001D"}, d2 = {"Landroidx/window/core/PredicateAdapter;", "", "Ljava/lang/ClassLoader;", "loader", "<init>", "(Ljava/lang/ClassLoader;)V", "Ljava/lang/Class;", "predicateClassOrThrow", "()Ljava/lang/Class;", "predicateClassOrNull$window_release", "predicateClassOrNull", "T", "LDe/d;", "clazz", "Lkotlin/Function1;", "", "predicate", "buildPredicate", "(LDe/d;Lwe/k;)Ljava/lang/Object;", "U", "firstClazz", "secondClazz", "Lkotlin/Function2;", "buildPairPredicate", "(LDe/d;LDe/d;Lwe/n;)Ljava/lang/Object;", "Ljava/lang/ClassLoader;", "BaseHandler", "PairPredicateStubHandler", "PredicateStubHandler", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class PredicateAdapter {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\n\b\"\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0015\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\r\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\t2\u0010\u0010\f\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u000BH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\u00102\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00028\u0000H&¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0014\u001A\u00020\u0010*\u00020\t2\u0010\u0010\u0013\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u000BH\u0004¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001A\u00020\u0010*\u00020\t2\u0010\u0010\u0013\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u000BH\u0004¢\u0006\u0004\b\u0016\u0010\u0015J%\u0010\u0017\u001A\u00020\u0010*\u00020\t2\u0010\u0010\u0013\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u000BH\u0004¢\u0006\u0004\b\u0017\u0010\u0015J%\u0010\u0018\u001A\u00020\u0010*\u00020\t2\u0010\u0010\u0013\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u000BH\u0004¢\u0006\u0004\b\u0018\u0010\u0015R\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019¨\u0006\u001A"}, d2 = {"Landroidx/window/core/PredicateAdapter$BaseHandler;", "", "T", "Ljava/lang/reflect/InvocationHandler;", "LDe/d;", "clazz", "<init>", "(LDe/d;)V", "obj", "Ljava/lang/reflect/Method;", "method", "", "parameters", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "parameter", "", "invokeTest", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "args", "isEquals", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)Z", "isHashCode", "isTest", "isToString", "LDe/d;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    static abstract class BaseHandler implements InvocationHandler {
        @NotNull
        private final d clazz;

        public BaseHandler(@NotNull d d0) {
            q.g(d0, "clazz");
            super();
            this.clazz = d0;
        }

        @Override
        @NotNull
        public Object invoke(@NotNull Object object0, @NotNull Method method0, @Nullable Object[] arr_object) {
            q.g(object0, "obj");
            q.g(method0, "method");
            Object object1 = null;
            boolean z = false;
            if(this.isTest(method0, arr_object)) {
                d d0 = this.clazz;
                if(arr_object != null) {
                    object1 = arr_object[0];
                }
                a.f(d0, object1);
                return Boolean.valueOf(this.invokeTest(object0, object1));
            }
            if(this.isEquals(method0, arr_object)) {
                if(arr_object != null) {
                    object1 = arr_object[0];
                }
                q.d(object1);
                if(object0 == object1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            if(this.isHashCode(method0, arr_object)) {
                return this.hashCode();
            }
            if(!this.isToString(method0, arr_object)) {
                throw new UnsupportedOperationException("Unexpected method call object:" + object0 + ", method: " + method0 + ", args: " + arr_object);
            }
            return this.toString();
        }

        public abstract boolean invokeTest(@NotNull Object arg1, @NotNull Object arg2);

        public final boolean isEquals(@NotNull Method method0, @Nullable Object[] arr_object) {
            q.g(method0, "<this>");
            return q.b(method0.getName(), "equals") && method0.getReturnType().equals(Boolean.TYPE) && arr_object != null && arr_object.length == 1;
        }

        public final boolean isHashCode(@NotNull Method method0, @Nullable Object[] arr_object) {
            q.g(method0, "<this>");
            return q.b(method0.getName(), "hashCode") && method0.getReturnType().equals(Integer.TYPE) && arr_object == null;
        }

        public final boolean isTest(@NotNull Method method0, @Nullable Object[] arr_object) {
            q.g(method0, "<this>");
            return q.b(method0.getName(), "test") && method0.getReturnType().equals(Boolean.TYPE) && arr_object != null && arr_object.length == 1;
        }

        public final boolean isToString(@NotNull Method method0, @Nullable Object[] arr_object) {
            q.g(method0, "<this>");
            return q.b(method0.getName(), "toString") && method0.getReturnType().equals(String.class) && arr_object == null;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0004B=\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0018\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\'\u0010\u0010\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\u00012\u000E\u0010\u000F\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u001A\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018R&\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\u0019¨\u0006\u001A"}, d2 = {"Landroidx/window/core/PredicateAdapter$PairPredicateStubHandler;", "", "T", "U", "Landroidx/window/core/PredicateAdapter$BaseHandler;", "Landroid/util/Pair;", "LDe/d;", "clazzT", "clazzU", "Lkotlin/Function2;", "", "predicate", "<init>", "(LDe/d;LDe/d;Lwe/n;)V", "obj", "parameter", "invokeTest", "(Ljava/lang/Object;Landroid/util/Pair;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "LDe/d;", "Lwe/n;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    static final class PairPredicateStubHandler extends BaseHandler {
        @NotNull
        private final d clazzT;
        @NotNull
        private final d clazzU;
        @NotNull
        private final n predicate;

        public PairPredicateStubHandler(@NotNull d d0, @NotNull d d1, @NotNull n n0) {
            q.g(d0, "clazzT");
            q.g(d1, "clazzU");
            q.g(n0, "predicate");
            super(I.a.b(Pair.class));
            this.clazzT = d0;
            this.clazzU = d1;
            this.predicate = n0;
        }

        @Override
        public int hashCode() {
            return this.predicate.hashCode();
        }

        public boolean invokeTest(@NotNull Object object0, @NotNull Pair pair0) {
            q.g(object0, "obj");
            q.g(pair0, "parameter");
            Object object1 = pair0.first;
            a.f(this.clazzT, object1);
            Object object2 = pair0.second;
            a.f(this.clazzU, object2);
            return ((Boolean)this.predicate.invoke(object1, object2)).booleanValue();
        }

        @Override  // androidx.window.core.PredicateAdapter$BaseHandler
        public boolean invokeTest(Object object0, Object object1) {
            return this.invokeTest(object0, ((Pair)object1));
        }

        @Override
        @NotNull
        public String toString() {
            return this.predicate.toString();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\r\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\b\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/window/core/PredicateAdapter$PredicateStubHandler;", "", "T", "Landroidx/window/core/PredicateAdapter$BaseHandler;", "LDe/d;", "clazzT", "Lkotlin/Function1;", "", "predicate", "<init>", "(LDe/d;Lwe/k;)V", "obj", "parameter", "invokeTest", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lwe/k;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    static final class PredicateStubHandler extends BaseHandler {
        @NotNull
        private final k predicate;

        public PredicateStubHandler(@NotNull d d0, @NotNull k k0) {
            q.g(d0, "clazzT");
            q.g(k0, "predicate");
            super(d0);
            this.predicate = k0;
        }

        @Override
        public int hashCode() {
            return this.predicate.hashCode();
        }

        @Override  // androidx.window.core.PredicateAdapter$BaseHandler
        public boolean invokeTest(@NotNull Object object0, @NotNull Object object1) {
            q.g(object0, "obj");
            q.g(object1, "parameter");
            return ((Boolean)this.predicate.invoke(object1)).booleanValue();
        }

        @Override
        @NotNull
        public String toString() {
            return this.predicate.toString();
        }
    }

    @NotNull
    private final ClassLoader loader;

    public PredicateAdapter(@NotNull ClassLoader classLoader0) {
        q.g(classLoader0, "loader");
        super();
        this.loader = classLoader0;
    }

    @NotNull
    public final Object buildPairPredicate(@NotNull d d0, @NotNull d d1, @NotNull n n0) {
        q.g(d0, "firstClazz");
        q.g(d1, "secondClazz");
        q.g(n0, "predicate");
        PairPredicateStubHandler predicateAdapter$PairPredicateStubHandler0 = new PairPredicateStubHandler(d0, d1, n0);
        Class[] arr_class = {this.predicateClassOrThrow()};
        Object object0 = Proxy.newProxyInstance(this.loader, arr_class, predicateAdapter$PairPredicateStubHandler0);
        q.f(object0, "newProxyInstance(...)");
        return object0;
    }

    @NotNull
    public final Object buildPredicate(@NotNull d d0, @NotNull k k0) {
        q.g(d0, "clazz");
        q.g(k0, "predicate");
        PredicateStubHandler predicateAdapter$PredicateStubHandler0 = new PredicateStubHandler(d0, k0);
        Class[] arr_class = {this.predicateClassOrThrow()};
        Object object0 = Proxy.newProxyInstance(this.loader, arr_class, predicateAdapter$PredicateStubHandler0);
        q.f(object0, "newProxyInstance(...)");
        return object0;
    }

    @Nullable
    public final Class predicateClassOrNull$window_release() {
        try {
            return this.predicateClassOrThrow();
        }
        catch(ClassNotFoundException unused_ex) {
            return null;
        }
    }

    private final Class predicateClassOrThrow() {
        Class class0 = this.loader.loadClass("java.util.function.Predicate");
        q.f(class0, "loadClass(...)");
        return class0;
    }
}

