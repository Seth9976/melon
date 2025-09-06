package kotlinx.serialization.internal;

import Tf.v;
import df.d;
import ie.A;
import ie.B;
import ie.E;
import ie.F;
import ie.H;
import ie.u;
import ie.x;
import ie.y;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import ke.e;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.s;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\u001A#\u0010\u0004\u001A\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000\u00A2\u0006\u0004\b\u0004\u0010\u0005\u001AM\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00010\n\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\n\b\u0001\u0010\u0006*\u0004\u0018\u00018\u0000*\u0012\u0012\u0004\u0012\u00028\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000\u00A2\u0006\u0004\b\u000B\u0010\f\u001A\u0017\u0010\u000F\u001A\u00020\u000E*\u0006\u0012\u0002\b\u00030\rH\u0000\u00A2\u0006\u0004\b\u000F\u0010\u0010\u001AO\u0010\u0013\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\r2\"\u0010\u0012\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00110\n\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0011H\u0000\u00A2\u0006\u0004\b\u0013\u0010\u0014\u001AO\u0010\u0015\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\r2\"\u0010\u0012\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00110\n\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0011H\u0002\u00A2\u0006\u0004\b\u0015\u0010\u0014\u001A%\u0010\u0016\u001A\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\rH\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017\u001A#\u0010\u0018\u001A\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\rH\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019\u001A#\u0010\u001A\u001A\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\rH\u0002\u00A2\u0006\u0004\b\u001A\u0010\u0019\u001AQ\u0010\u001C\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\"\b\b\u0000\u0010\u0001*\u00020\u00002\n\u0010\u001B\u001A\u0006\u0012\u0002\b\u00030\r2\"\u0010\u0012\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00110\n\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0011H\u0002\u00A2\u0006\u0004\b\u001C\u0010\u0014\u001AM\u0010\u001E\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u001D\u001A\u00020\u00002\"\u0010\u0012\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00110\n\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0011H\u0002\u00A2\u0006\u0004\b\u001E\u0010\u001F\u001A!\u0010\"\u001A\u0004\u0018\u00010\u0000*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010!\u001A\u00020 H\u0002\u00A2\u0006\u0004\b\"\u0010#\u001A)\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\rH\u0002\u00A2\u0006\u0004\b$\u0010%\u001A+\u0010&\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\rH\u0002\u00A2\u0006\u0004\b&\u0010%\u001A#\u0010(\u001A\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\'H\u0000\u00A2\u0006\u0004\b(\u0010)\u00A8\u0006*"}, d2 = {"", "T", "LDe/d;", "", "isInterface", "(LDe/d;)Z", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "", "toNativeArrayImpl", "(Ljava/util/ArrayList;LDe/d;)[Ljava/lang/Object;", "Ljava/lang/Class;", "", "serializerNotRegistered", "(Ljava/lang/Class;)Ljava/lang/Void;", "Lkotlinx/serialization/KSerializer;", "args", "constructSerializerForGivenTypeArgs", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "findInNamedCompanion", "findNamedCompanionByAnnotation", "(Ljava/lang/Class;)Ljava/lang/Object;", "isNotAnnotated", "(Ljava/lang/Class;)Z", "isPolymorphicSerializer", "jClass", "invokeSerializerOnDefaultCompanion", "companion", "invokeSerializerOnCompanion", "(Ljava/lang/Object;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "companionName", "companionOrNull", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "createEnumSerializer", "(Ljava/lang/Class;)Lkotlinx/serialization/KSerializer;", "findObjectSerializer", "", "initBuiltins", "()Ljava/util/Map;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class PlatformKt {
    private static final Object companionOrNull(Class class0, String s) {
        try {
            Field field0 = class0.getDeclaredField(s);
            field0.setAccessible(true);
            return field0.get(null);
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    @Nullable
    public static final KSerializer constructSerializerForGivenTypeArgs(@NotNull Class class0, @NotNull KSerializer[] arr_kSerializer) {
        q.g(class0, "<this>");
        q.g(arr_kSerializer, "args");
        if(class0.isEnum() && PlatformKt.isNotAnnotated(class0)) {
            return PlatformKt.createEnumSerializer(class0);
        }
        KSerializer kSerializer0 = PlatformKt.invokeSerializerOnDefaultCompanion(class0, ((KSerializer[])Arrays.copyOf(arr_kSerializer, arr_kSerializer.length)));
        if(kSerializer0 != null) {
            return kSerializer0;
        }
        KSerializer kSerializer1 = PlatformKt.findObjectSerializer(class0);
        if(kSerializer1 != null) {
            return kSerializer1;
        }
        KSerializer kSerializer2 = PlatformKt.findInNamedCompanion(class0, ((KSerializer[])Arrays.copyOf(arr_kSerializer, arr_kSerializer.length)));
        if(kSerializer2 != null) {
            return kSerializer2;
        }
        return PlatformKt.isPolymorphicSerializer(class0) ? new PolymorphicSerializer(d.y(class0)) : null;
    }

    private static final KSerializer createEnumSerializer(Class class0) {
        Object[] arr_object = class0.getEnumConstants();
        String s = class0.getCanonicalName();
        q.f(s, "getCanonicalName(...)");
        q.e(arr_object, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer(s, ((Enum[])arr_object));
    }

    private static final KSerializer findInNamedCompanion(Class class0, KSerializer[] arr_kSerializer) {
        Object object1;
        Object object0 = PlatformKt.findNamedCompanionByAnnotation(class0);
        if(object0 != null) {
            KSerializer kSerializer0 = PlatformKt.invokeSerializerOnCompanion(object0, ((KSerializer[])Arrays.copyOf(arr_kSerializer, arr_kSerializer.length)));
            if(kSerializer0 != null) {
                return kSerializer0;
            }
        }
        try {
            Class[] arr_class = class0.getDeclaredClasses();
            q.f(arr_class, "getDeclaredClasses(...)");
            int v = 0;
            Class class1 = null;
            boolean z = false;
            while(v < arr_class.length) {
                Class class2 = arr_class[v];
                if(class2.getSimpleName().equals("$serializer")) {
                    if(!z) {
                        z = true;
                        class1 = class2;
                        goto label_19;
                    }
                    class1 = null;
                    goto label_23;
                }
            label_19:
                ++v;
            }
            if(!z) {
                class1 = null;
            }
        label_23:
            if(class1 == null) {
                object1 = null;
            }
            else {
                Field field0 = class1.getField("INSTANCE");
                object1 = field0 == null ? null : field0.get(null);
            }
            return object1 instanceof KSerializer ? ((KSerializer)object1) : null;
        }
        catch(NoSuchFieldException unused_ex) {
        }
        return null;
    }

    private static final Object findNamedCompanionByAnnotation(Class class0) {
        Class[] arr_class = class0.getDeclaredClasses();
        q.f(arr_class, "getDeclaredClasses(...)");
        for(int v = 0; v < arr_class.length; ++v) {
            Class class1 = arr_class[v];
            if(class1.getAnnotation(NamedCompanion.class) != null) {
                return class1 == null ? null : PlatformKt.companionOrNull(class0, class1.getSimpleName());
            }
        }
        throw new NullPointerException();
    }

    private static final KSerializer findObjectSerializer(Class class0) {
        int v = 0;
        String s = class0.getCanonicalName();
        if(s != null && !v.r0(s, "java.", false) && !v.r0(s, "kotlin.", false)) {
            Field[] arr_field = class0.getDeclaredFields();
            q.f(arr_field, "getDeclaredFields(...)");
            Field field0 = null;
            int v1 = 0;
            boolean z = false;
            while(v1 < arr_field.length) {
                Field field1 = arr_field[v1];
                if(q.b(field1.getName(), "INSTANCE") && q.b(field1.getType(), class0) && Modifier.isStatic(field1.getModifiers())) {
                    if(!z) {
                        z = true;
                        field0 = field1;
                        goto label_17;
                    }
                    field0 = null;
                    goto label_21;
                }
            label_17:
                ++v1;
            }
            if(!z) {
                field0 = null;
            }
        label_21:
            if(field0 != null) {
                Object object0 = field0.get(null);
                Method[] arr_method = class0.getMethods();
                q.f(arr_method, "getMethods(...)");
                Method method0 = null;
                boolean z1 = false;
                while(v < arr_method.length) {
                    Method method1 = arr_method[v];
                    if(q.b(method1.getName(), "serializer")) {
                        Class[] arr_class = method1.getParameterTypes();
                        q.f(arr_class, "getParameterTypes(...)");
                        if(arr_class.length == 0 && q.b(method1.getReturnType(), KSerializer.class)) {
                            if(!z1) {
                                method0 = method1;
                                z1 = true;
                                goto label_39;
                            }
                            method0 = null;
                            goto label_43;
                        }
                    }
                label_39:
                    ++v;
                }
                if(!z1) {
                    method0 = null;
                }
            label_43:
                if(method0 != null) {
                    Object object1 = method0.invoke(object0, null);
                    return object1 instanceof KSerializer ? ((KSerializer)object1) : null;
                }
            }
        }
        return null;
    }

    @NotNull
    public static final Map initBuiltins() {
        e e0 = new e();
        J j0 = I.a;
        e0.put(j0.b(String.class), BuiltinSerializersKt.serializer(M.a));
        e0.put(j0.b(Character.TYPE), BuiltinSerializersKt.serializer(f.a));
        e0.put(j0.b(char[].class), BuiltinSerializersKt.CharArraySerializer());
        e0.put(j0.b(Double.TYPE), BuiltinSerializersKt.serializer(i.a));
        e0.put(j0.b(double[].class), BuiltinSerializersKt.DoubleArraySerializer());
        e0.put(j0.b(Float.TYPE), BuiltinSerializersKt.serializer(j.a));
        e0.put(j0.b(float[].class), BuiltinSerializersKt.FloatArraySerializer());
        e0.put(j0.b(Long.TYPE), BuiltinSerializersKt.serializer(s.a));
        e0.put(j0.b(long[].class), BuiltinSerializersKt.LongArraySerializer());
        e0.put(j0.b(A.class), BuiltinSerializersKt.serializer(A.b));
        e0.put(j0.b(Integer.TYPE), BuiltinSerializersKt.serializer(o.a));
        e0.put(j0.b(int[].class), BuiltinSerializersKt.IntArraySerializer());
        e0.put(j0.b(x.class), BuiltinSerializersKt.serializer(x.b));
        e0.put(j0.b(Short.TYPE), BuiltinSerializersKt.serializer(L.a));
        e0.put(j0.b(short[].class), BuiltinSerializersKt.ShortArraySerializer());
        e0.put(j0.b(E.class), BuiltinSerializersKt.serializer(E.b));
        e0.put(j0.b(Byte.TYPE), BuiltinSerializersKt.serializer(c.a));
        e0.put(j0.b(byte[].class), BuiltinSerializersKt.ByteArraySerializer());
        e0.put(j0.b(u.class), BuiltinSerializersKt.serializer(u.b));
        e0.put(j0.b(Boolean.TYPE), BuiltinSerializersKt.serializer(b.a));
        e0.put(j0.b(boolean[].class), BuiltinSerializersKt.BooleanArraySerializer());
        e0.put(j0.b(H.class), BuiltinSerializersKt.serializer(H.a));
        e0.put(j0.b(Void.class), BuiltinSerializersKt.NothingSerializer());
        try {
            e0.put(j0.b(Uf.b.class), BuiltinSerializersKt.serializer(Uf.b.b));
        }
        catch(NoClassDefFoundError | ClassNotFoundException unused_ex) {
        }
        try {
            e0.put(I.a.b(B.class), BuiltinSerializersKt.ULongArraySerializer());
        }
        catch(NoClassDefFoundError | ClassNotFoundException unused_ex) {
        }
        try {
            e0.put(I.a.b(y.class), BuiltinSerializersKt.UIntArraySerializer());
        }
        catch(NoClassDefFoundError | ClassNotFoundException unused_ex) {
        }
        try {
            e0.put(I.a.b(F.class), BuiltinSerializersKt.UShortArraySerializer());
        }
        catch(NoClassDefFoundError | ClassNotFoundException unused_ex) {
        }
        try {
            e0.put(I.a.b(ie.v.class), BuiltinSerializersKt.UByteArraySerializer());
        }
        catch(NoClassDefFoundError | ClassNotFoundException unused_ex) {
        }
        try {
            e0.put(I.a.b(Vf.b.class), BuiltinSerializersKt.serializer(Vf.b.c));
        }
        catch(NoClassDefFoundError | ClassNotFoundException unused_ex) {
        }
        return e0.b();
    }

    private static final KSerializer invokeSerializerOnCompanion(Object object0, KSerializer[] arr_kSerializer) {
        Class[] arr_class1;
        try {
            if(arr_kSerializer.length == 0) {
                arr_class1 = new Class[0];
            }
            else {
                Class[] arr_class = new Class[arr_kSerializer.length];
                for(int v = 0; v < arr_kSerializer.length; ++v) {
                    arr_class[v] = KSerializer.class;
                }
                arr_class1 = arr_class;
            }
            Object object1 = object0.getClass().getDeclaredMethod("serializer", ((Class[])Arrays.copyOf(arr_class1, arr_class1.length))).invoke(object0, Arrays.copyOf(arr_kSerializer, arr_kSerializer.length));
            return object1 instanceof KSerializer ? ((KSerializer)object1) : null;
        }
        catch(NoSuchMethodException unused_ex) {
            return null;
        }
        catch(InvocationTargetException invocationTargetException0) {
            Throwable throwable0 = invocationTargetException0.getCause();
            if(throwable0 == null) {
                throw invocationTargetException0;
            }
            String s = throwable0.getMessage();
            if(s == null) {
                s = invocationTargetException0.getMessage();
            }
            throw new InvocationTargetException(throwable0, s);
        }
    }

    private static final KSerializer invokeSerializerOnDefaultCompanion(Class class0, KSerializer[] arr_kSerializer) {
        Object object0 = PlatformKt.companionOrNull(class0, "Companion");
        return object0 == null ? null : PlatformKt.invokeSerializerOnCompanion(object0, ((KSerializer[])Arrays.copyOf(arr_kSerializer, arr_kSerializer.length)));
    }

    public static final boolean isInterface(@NotNull De.d d0) {
        q.g(d0, "<this>");
        return d.v(d0).isInterface();
    }

    private static final boolean isNotAnnotated(Class class0) {
        return class0.getAnnotation(Serializable.class) == null && class0.getAnnotation(Polymorphic.class) == null;
    }

    private static final boolean isPolymorphicSerializer(Class class0) {
        if(class0.getAnnotation(Polymorphic.class) == null) {
            Serializable serializable0 = (Serializable)class0.getAnnotation(Serializable.class);
            if(serializable0 != null) {
                Class class1 = serializable0.with();
                return I.a.b(class1).equals(I.a.b(PolymorphicSerializer.class));
            }
            return false;
        }
        return true;
    }

    @NotNull
    public static final Void serializerNotRegistered(@NotNull Class class0) {
        q.g(class0, "<this>");
        throw new SerializationException(Platform_commonKt.notRegisteredMessage(d.y(class0)));
    }

    @NotNull
    public static final Object[] toNativeArrayImpl(@NotNull ArrayList arrayList0, @NotNull De.d d0) {
        q.g(arrayList0, "<this>");
        q.g(d0, "eClass");
        Object object0 = Array.newInstance(d.v(d0), arrayList0.size());
        q.e(object0, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        Object[] arr_object = arrayList0.toArray(((Object[])object0));
        q.f(arr_object, "toArray(...)");
        return arr_object;
    }
}

