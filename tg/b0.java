package tg;

import H0.b;
import U4.x;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import ma.c;

public abstract class b0 {
    public static final Type[] a = null;
    public static boolean b = true;
    public static Constructor c;

    static {
        b0.a = new Type[0];
    }

    public abstract void a(N arg1, Object arg2);

    public static final Object b(d d0, Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        cancellableContinuationImpl0.invokeOnCancellation(new v(d0, 0));
        d0.enqueue(new c(cancellableContinuationImpl0, 1));
        return cancellableContinuationImpl0.getResult();
    }

    public static final Object c(d d0, Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        cancellableContinuationImpl0.invokeOnCancellation(new v(d0, 1));
        d0.enqueue(new c(cancellableContinuationImpl0, 2));
        return cancellableContinuationImpl0.getResult();
    }

    public static void d(Type type0) {
        if(type0 instanceof Class && ((Class)type0).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean e(Type type0, Type type1) {
        if(type0 == type1) {
            return true;
        }
        if(type0 instanceof Class) {
            return type0.equals(type1);
        }
        if(type0 instanceof ParameterizedType) {
            if(!(type1 instanceof ParameterizedType)) {
                return false;
            }
            Type type2 = ((ParameterizedType)type0).getOwnerType();
            Type type3 = ((ParameterizedType)type1).getOwnerType();
            return (type2 == type3 || type2 != null && type2.equals(type3)) && ((ParameterizedType)type0).getRawType().equals(((ParameterizedType)type1).getRawType()) && Arrays.equals(((ParameterizedType)type0).getActualTypeArguments(), ((ParameterizedType)type1).getActualTypeArguments());
        }
        if(type0 instanceof GenericArrayType) {
            return type1 instanceof GenericArrayType ? b0.e(((GenericArrayType)type0).getGenericComponentType(), ((GenericArrayType)type1).getGenericComponentType()) : false;
        }
        if(type0 instanceof WildcardType) {
            return type1 instanceof WildcardType ? Arrays.equals(((WildcardType)type0).getUpperBounds(), ((WildcardType)type1).getUpperBounds()) && Arrays.equals(((WildcardType)type0).getLowerBounds(), ((WildcardType)type1).getLowerBounds()) : false;
        }
        return type0 instanceof TypeVariable && type1 instanceof TypeVariable ? ((TypeVariable)type0).getGenericDeclaration() == ((TypeVariable)type1).getGenericDeclaration() && ((TypeVariable)type0).getName().equals(((TypeVariable)type1).getName()) : false;
    }

    public static Type f(Type type0, Class class0, Class class1) {
        if(class1 == class0) {
            return type0;
        }
        if(class1.isInterface()) {
            Class[] arr_class = class0.getInterfaces();
            for(int v = 0; v < arr_class.length; ++v) {
                Class class2 = arr_class[v];
                if(class2 == class1) {
                    return class0.getGenericInterfaces()[v];
                }
                if(class1.isAssignableFrom(class2)) {
                    return b0.f(class0.getGenericInterfaces()[v], arr_class[v], class1);
                }
            }
        }
        if(!class0.isInterface()) {
            while(class0 != Object.class) {
                Class class3 = class0.getSuperclass();
                if(class3 == class1) {
                    return class0.getGenericSuperclass();
                }
                if(class1.isAssignableFrom(class3)) {
                    return b0.f(class0.getGenericSuperclass(), class3, class1);
                }
                class0 = class3;
            }
        }
        return class1;
    }

    public static Type g(int v, ParameterizedType parameterizedType0) {
        Type[] arr_type = parameterizedType0.getActualTypeArguments();
        if(v >= 0 && v < arr_type.length) {
            Type type0 = arr_type[v];
            return type0 instanceof WildcardType ? ((WildcardType)type0).getUpperBounds()[0] : type0;
        }
        StringBuilder stringBuilder0 = x.n(v, "Index ", " not in range [0,");
        stringBuilder0.append(arr_type.length);
        stringBuilder0.append(") for ");
        stringBuilder0.append(parameterizedType0);
        throw new IllegalArgumentException(stringBuilder0.toString());
    }

    public static Class h(Type type0) {
        Objects.requireNonNull(type0, "type == null");
        if(type0 instanceof Class) {
            return (Class)type0;
        }
        if(type0 instanceof ParameterizedType) {
            Type type1 = ((ParameterizedType)type0).getRawType();
            if(!(type1 instanceof Class)) {
                throw new IllegalArgumentException();
            }
            return (Class)type1;
        }
        if(type0 instanceof GenericArrayType) {
            return Array.newInstance(b0.h(((GenericArrayType)type0).getGenericComponentType()), 0).getClass();
        }
        if(type0 instanceof TypeVariable) {
            return Object.class;
        }
        if(!(type0 instanceof WildcardType)) {
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type0 + "> is of type " + type0.getClass().getName());
        }
        return b0.h(((WildcardType)type0).getUpperBounds()[0]);
    }

    public static Type i(Type type0, Class class0) {
        Class class1 = Map.class;
        if(!class1.isAssignableFrom(class0)) {
            throw new IllegalArgumentException();
        }
        return b0.p(type0, class0, b0.f(type0, class0, class1));
    }

    public static boolean j(Type type0) {
        if(type0 instanceof Class) {
            return false;
        }
        if(type0 instanceof ParameterizedType) {
            Type[] arr_type = ((ParameterizedType)type0).getActualTypeArguments();
            for(int v = 0; v < arr_type.length; ++v) {
                if(b0.j(arr_type[v])) {
                    return true;
                }
            }
            return false;
        }
        if(type0 instanceof GenericArrayType) {
            return b0.j(((GenericArrayType)type0).getGenericComponentType());
        }
        if(type0 instanceof TypeVariable) {
            return true;
        }
        if(!(type0 instanceof WildcardType)) {
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type0 + "> is of type " + (type0 == null ? "null" : type0.getClass().getName()));
        }
        return true;
    }

    public static Object k(Class class0, Method method0, Object object0, Object[] arr_object) {
        Constructor constructor0 = b0.c;
        if(constructor0 == null) {
            constructor0 = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            constructor0.setAccessible(true);
            b0.c = constructor0;
        }
        return ((MethodHandles.Lookup)constructor0.newInstance(class0, -1)).unreflectSpecial(method0, class0).bindTo(object0).invokeWithArguments(arr_object);
    }

    public static boolean l(Annotation[] arr_annotation, Class class0) {
        for(int v = 0; v < arr_annotation.length; ++v) {
            if(class0.isInstance(arr_annotation[v])) {
                return true;
            }
        }
        return false;
    }

    public static IllegalArgumentException m(Method method0, Exception exception0, String s, Object[] arr_object) {
        StringBuilder stringBuilder0 = x.p(String.format(s, arr_object), "\n    for method ");
        stringBuilder0.append(method0.getDeclaringClass().getSimpleName());
        stringBuilder0.append(".");
        stringBuilder0.append(method0.getName());
        return new IllegalArgumentException(stringBuilder0.toString(), exception0);
    }

    public static IllegalArgumentException n(Method method0, int v, String s, Object[] arr_object) {
        return b0.m(method0, null, b.j(s, " (", K.b.c(method0, v), ")"), arr_object);
    }

    public static IllegalArgumentException o(Method method0, Exception exception0, int v, String s, Object[] arr_object) {
        return b0.m(method0, exception0, b.j(s, " (", K.b.c(method0, v), ")"), arr_object);
    }

    public static Type p(Type type0, Class class0, Type type1) {
        Type type3;
        while(type1 instanceof TypeVariable) {
            TypeVariable typeVariable0 = (TypeVariable)type1;
            GenericDeclaration genericDeclaration0 = typeVariable0.getGenericDeclaration();
            Class class1 = genericDeclaration0 instanceof Class ? ((Class)genericDeclaration0) : null;
            if(class1 != null) {
                Type type2 = b0.f(type0, class0, class1);
                if(type2 instanceof ParameterizedType) {
                    TypeVariable[] arr_typeVariable = class1.getTypeParameters();
                    while(v < arr_typeVariable.length) {
                        if(typeVariable0.equals(arr_typeVariable[v])) {
                            type3 = ((ParameterizedType)type2).getActualTypeArguments()[v];
                            goto label_16;
                        }
                        ++v;
                    }
                    throw new NoSuchElementException();
                }
            }
            type3 = typeVariable0;
        label_16:
            if(type3 == typeVariable0) {
                return type3;
            }
            v = 0;
            type1 = type3;
        }
        if(type1 instanceof Class && ((Class)type1).isArray()) {
            Class class2 = ((Class)type1).getComponentType();
            Type type4 = b0.p(type0, class0, class2);
            return class2 == type4 ? ((Class)type1) : new Y(type4);
        }
        if(type1 instanceof GenericArrayType) {
            Type type5 = ((GenericArrayType)type1).getGenericComponentType();
            Type type6 = b0.p(type0, class0, type5);
            return type5 == type6 ? ((GenericArrayType)type1) : new Y(type6);
        }
        if(type1 instanceof ParameterizedType) {
            Type type7 = ((ParameterizedType)type1).getOwnerType();
            Type type8 = b0.p(type0, class0, type7);
            boolean z = type8 != type7;
            Type[] arr_type = ((ParameterizedType)type1).getActualTypeArguments();
            int v1 = arr_type.length;
            while(v < v1) {
                Type type9 = b0.p(type0, class0, arr_type[v]);
                if(type9 != arr_type[v]) {
                    if(!z) {
                        arr_type = (Type[])arr_type.clone();
                        z = true;
                    }
                    arr_type[v] = type9;
                }
                ++v;
            }
            return z ? new Z(type8, ((ParameterizedType)type1).getRawType(), arr_type) : ((ParameterizedType)type1);
        }
        if(type1 instanceof WildcardType) {
            type1 = (WildcardType)type1;
            Type[] arr_type1 = ((WildcardType)type1).getLowerBounds();
            Type[] arr_type2 = ((WildcardType)type1).getUpperBounds();
            if(arr_type1.length == 1) {
                Type type10 = b0.p(type0, class0, arr_type1[0]);
                if(type10 != arr_type1[0]) {
                    return new a0(new Type[]{Object.class}, new Type[]{type10});
                }
            }
            else if(arr_type2.length == 1) {
                Type type11 = b0.p(type0, class0, arr_type2[0]);
                if(type11 != arr_type2[0]) {
                    return new a0(new Type[]{type11}, b0.a);
                }
            }
        }
        return type1;
    }

    public static final void q(Continuation continuation0, Throwable throwable0) {
        w w0;
        if(continuation0 instanceof w) {
            w0 = (w)continuation0;
            int v = w0.w;
            if((v & 0x80000000) == 0) {
                w0 = new w(continuation0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                w0.w = v ^ 0x80000000;
            }
        }
        else {
            w0 = new w(continuation0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = w0.r;
        switch(w0.w) {
            case 0: {
                n.D(object0);
                w0.w = 1;
                Dispatchers.getDefault().dispatch(w0.getContext(), new M6.u(20, w0, throwable0));
                return;
            }
            case 1: {
                n.D(object0);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static void r(Throwable throwable0) {
        if(throwable0 instanceof VirtualMachineError) {
            throw (VirtualMachineError)throwable0;
        }
        if(throwable0 instanceof ThreadDeath) {
            throw (ThreadDeath)throwable0;
        }
        if(throwable0 instanceof LinkageError) {
            throw (LinkageError)throwable0;
        }
    }

    // 去混淆评级： 低(20)
    public static String s(Type type0) {
        return type0 instanceof Class ? ((Class)type0).getName() : type0.toString();
    }
}

