package kotlinx.serialization;

import De.d;
import H0.b;
import i.n.i.b.a.s.e.M3;
import ie.m;
import ie.s;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import je.n;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A\u001F\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001A!\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0006\u001A-\u0010\f\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\b\b\u0002\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000B\u001A/\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00002\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000E\u0010\u000F\u001AI\u0010\u0017\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\b\b\u0000\u0010\u0011*\u00020\u0004*\u00020\u00002\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\r2\u0014\u0010\u0014\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001A+\u0010\u001B\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00182\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u001A\u001A\u0017\u0010\u001E\u001A\u0006\u0012\u0002\b\u00030\r*\u00020\u0001H\u0002¢\u0006\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", "Ljava/lang/reflect/Type;", "type", "Lkotlinx/serialization/KSerializer;", "", "serializer", "(Lkotlinx/serialization/modules/SerializersModule;Ljava/lang/reflect/Type;)Lkotlinx/serialization/KSerializer;", "serializerOrNull", "", "failOnMissingTypeArgSerializer", "serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt", "(Lkotlinx/serialization/modules/SerializersModule;Ljava/lang/reflect/Type;Z)Lkotlinx/serialization/KSerializer;", "serializerByJavaTypeImpl", "Ljava/lang/Class;", "typeSerializer$SerializersKt__SerializersJvmKt", "(Lkotlinx/serialization/modules/SerializersModule;Ljava/lang/Class;Z)Lkotlinx/serialization/KSerializer;", "typeSerializer", "T", "jClass", "", "typeArgumentsSerializers", "reflectiveOrContextual$SerializersKt__SerializersJvmKt", "(Lkotlinx/serialization/modules/SerializersModule;Ljava/lang/Class;Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "reflectiveOrContextual", "Ljava/lang/reflect/GenericArrayType;", "genericArraySerializer$SerializersKt__SerializersJvmKt", "(Lkotlinx/serialization/modules/SerializersModule;Ljava/lang/reflect/GenericArrayType;Z)Lkotlinx/serialization/KSerializer;", "genericArraySerializer", "prettyClass$SerializersKt__SerializersJvmKt", "(Ljava/lang/reflect/Type;)Ljava/lang/Class;", "prettyClass", "kotlinx-serialization-core"}, k = 5, mv = {2, 0, 0}, xi = 0x30, xs = "kotlinx/serialization/SerializersKt")
abstract class SerializersKt__SerializersJvmKt {
    private static final KSerializer genericArraySerializer$SerializersKt__SerializersJvmKt(SerializersModule serializersModule0, GenericArrayType genericArrayType0, boolean z) {
        d d0;
        KSerializer kSerializer0;
        Type type0 = genericArrayType0.getGenericComponentType();
        if(type0 instanceof WildcardType) {
            Type[] arr_type = ((WildcardType)type0).getUpperBounds();
            q.f(arr_type, "getUpperBounds(...)");
            type0 = (Type)n.h0(arr_type);
        }
        q.d(type0);
        if(z) {
            kSerializer0 = SerializersKt.serializer(serializersModule0, type0);
        }
        else {
            kSerializer0 = SerializersKt.serializerOrNull(serializersModule0, type0);
            if(kSerializer0 == null) {
                return null;
            }
        }
        boolean z1 = false;
        if(type0 instanceof ParameterizedType) {
            z1 = true;
            Type type1 = ((ParameterizedType)type0).getRawType();
            q.e(type1, "null cannot be cast to non-null type java.lang.Class<*>");
            d0 = df.d.y(((Class)type1));
        }
        else if(type0 instanceof d) {
            z1 = true;
            d0 = (d)type0;
        }
        if(z1) {
            q.e(d0, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            KSerializer kSerializer1 = BuiltinSerializersKt.ArraySerializer(d0, kSerializer0);
            q.e(kSerializer1, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return kSerializer1;
        }
        StringBuilder stringBuilder0 = new StringBuilder("unsupported type in GenericArray: ");
        Class class0 = type0.getClass();
        throw new IllegalStateException(b.l(I.a, class0, stringBuilder0));
    }

    private static final Class prettyClass$SerializersKt__SerializersJvmKt(Type type0) {
        if(type0 instanceof Class) {
            return (Class)type0;
        }
        if(type0 instanceof ParameterizedType) {
            Type type1 = ((ParameterizedType)type0).getRawType();
            q.f(type1, "getRawType(...)");
            return SerializersKt__SerializersJvmKt.prettyClass$SerializersKt__SerializersJvmKt(type1);
        }
        if(type0 instanceof WildcardType) {
            Type[] arr_type = ((WildcardType)type0).getUpperBounds();
            q.f(arr_type, "getUpperBounds(...)");
            Object object0 = n.h0(arr_type);
            q.f(object0, "first(...)");
            return SerializersKt__SerializersJvmKt.prettyClass$SerializersKt__SerializersJvmKt(((Type)object0));
        }
        if(type0 instanceof GenericArrayType) {
            Type type2 = ((GenericArrayType)type0).getGenericComponentType();
            q.f(type2, "getGenericComponentType(...)");
            return SerializersKt__SerializersJvmKt.prettyClass$SerializersKt__SerializersJvmKt(type2);
        }
        StringBuilder stringBuilder0 = new StringBuilder("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument ");
        stringBuilder0.append(type0);
        stringBuilder0.append(" has type ");
        Class class0 = type0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0));
    }

    private static final KSerializer reflectiveOrContextual$SerializersKt__SerializersJvmKt(SerializersModule serializersModule0, Class class0, List list0) {
        KSerializer[] arr_kSerializer = (KSerializer[])list0.toArray(new KSerializer[0]);
        KSerializer kSerializer0 = PlatformKt.constructSerializerForGivenTypeArgs(class0, ((KSerializer[])Arrays.copyOf(arr_kSerializer, arr_kSerializer.length)));
        if(kSerializer0 != null) {
            return kSerializer0;
        }
        d d0 = df.d.y(class0);
        KSerializer kSerializer1 = PrimitivesKt.builtinSerializerOrNull(d0);
        if(kSerializer1 == null) {
            KSerializer kSerializer2 = serializersModule0.getContextual(d0, list0);
            if(kSerializer2 == null) {
                return class0.isInterface() ? new PolymorphicSerializer(df.d.y(class0)) : null;
            }
            return kSerializer2;
        }
        return kSerializer1;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull SerializersModule serializersModule0, @NotNull Type type0) {
        q.g(serializersModule0, "<this>");
        q.g(type0, "type");
        KSerializer kSerializer0 = SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule0, type0, true);
        if(kSerializer0 != null) {
            return kSerializer0;
        }
        PlatformKt.serializerNotRegistered(SerializersKt__SerializersJvmKt.prettyClass$SerializersKt__SerializersJvmKt(type0));
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    private static final KSerializer serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(SerializersModule serializersModule0, Type type0, boolean z) {
        ArrayList arrayList0;
        if(type0 instanceof GenericArrayType) {
            return SerializersKt__SerializersJvmKt.genericArraySerializer$SerializersKt__SerializersJvmKt(serializersModule0, ((GenericArrayType)type0), z);
        }
        if(type0 instanceof Class) {
            return SerializersKt__SerializersJvmKt.typeSerializer$SerializersKt__SerializersJvmKt(serializersModule0, ((Class)type0), z);
        }
        if(type0 instanceof ParameterizedType) {
            Type type1 = ((ParameterizedType)type0).getRawType();
            q.e(type1, "null cannot be cast to non-null type java.lang.Class<*>");
            Type[] arr_type = ((ParameterizedType)type0).getActualTypeArguments();
            q.d(arr_type);
            if(z) {
                arrayList0 = new ArrayList(arr_type.length);
                for(int v = 0; v < arr_type.length; ++v) {
                    Type type2 = arr_type[v];
                    q.d(type2);
                    arrayList0.add(SerializersKt.serializer(serializersModule0, type2));
                }
            }
            else {
                arrayList0 = new ArrayList(arr_type.length);
                for(int v1 = 0; v1 < arr_type.length; ++v1) {
                    Type type3 = arr_type[v1];
                    q.d(type3);
                    KSerializer kSerializer0 = SerializersKt.serializerOrNull(serializersModule0, type3);
                    if(kSerializer0 == null) {
                        return null;
                    }
                    arrayList0.add(kSerializer0);
                }
            }
            if(Set.class.isAssignableFrom(((Class)type1))) {
                KSerializer kSerializer1 = BuiltinSerializersKt.SetSerializer(((KSerializer)arrayList0.get(0)));
                q.e(kSerializer1, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                return kSerializer1;
            }
            if(!List.class.isAssignableFrom(((Class)type1)) && !Collection.class.isAssignableFrom(((Class)type1))) {
                if(Map.class.isAssignableFrom(((Class)type1))) {
                    KSerializer kSerializer2 = BuiltinSerializersKt.MapSerializer(((KSerializer)arrayList0.get(0)), ((KSerializer)arrayList0.get(1)));
                    q.e(kSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                    return kSerializer2;
                }
                if(Map.Entry.class.isAssignableFrom(((Class)type1))) {
                    KSerializer kSerializer3 = BuiltinSerializersKt.MapEntrySerializer(((KSerializer)arrayList0.get(0)), ((KSerializer)arrayList0.get(1)));
                    q.e(kSerializer3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                    return kSerializer3;
                }
                if(m.class.isAssignableFrom(((Class)type1))) {
                    KSerializer kSerializer4 = BuiltinSerializersKt.PairSerializer(((KSerializer)arrayList0.get(0)), ((KSerializer)arrayList0.get(1)));
                    q.e(kSerializer4, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                    return kSerializer4;
                }
                if(s.class.isAssignableFrom(((Class)type1))) {
                    KSerializer kSerializer5 = BuiltinSerializersKt.TripleSerializer(((KSerializer)arrayList0.get(0)), ((KSerializer)arrayList0.get(1)), ((KSerializer)arrayList0.get(2)));
                    q.e(kSerializer5, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                    return kSerializer5;
                }
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object0: arrayList0) {
                    q.e(((KSerializer)object0), "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
                    arrayList1.add(((KSerializer)object0));
                }
                return SerializersKt__SerializersJvmKt.reflectiveOrContextual$SerializersKt__SerializersJvmKt(serializersModule0, ((Class)type1), arrayList1);
            }
            KSerializer kSerializer6 = BuiltinSerializersKt.ListSerializer(((KSerializer)arrayList0.get(0)));
            q.e(kSerializer6, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return kSerializer6;
        }
        if(type0 instanceof WildcardType) {
            Type[] arr_type1 = ((WildcardType)type0).getUpperBounds();
            q.f(arr_type1, "getUpperBounds(...)");
            Object object1 = n.h0(arr_type1);
            q.f(object1, "first(...)");
            return SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt$default(serializersModule0, ((Type)object1), false, 2, null);
        }
        StringBuilder stringBuilder0 = new StringBuilder("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument ");
        stringBuilder0.append(type0);
        stringBuilder0.append(" has type ");
        Class class0 = type0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0));
    }

    public static KSerializer serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt$default(SerializersModule serializersModule0, Type type0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = true;
        }
        return SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule0, type0, z);
    }

    @Nullable
    public static final KSerializer serializerOrNull(@NotNull SerializersModule serializersModule0, @NotNull Type type0) {
        q.g(serializersModule0, "<this>");
        q.g(type0, "type");
        return SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule0, type0, false);
    }

    private static final KSerializer typeSerializer$SerializersKt__SerializersJvmKt(SerializersModule serializersModule0, Class class0, boolean z) {
        KSerializer kSerializer0;
        if(class0.isArray() && !class0.getComponentType().isPrimitive()) {
            Class class1 = class0.getComponentType();
            q.f(class1, "getComponentType(...)");
            if(z) {
                kSerializer0 = SerializersKt.serializer(serializersModule0, class1);
            }
            else {
                kSerializer0 = SerializersKt.serializerOrNull(serializersModule0, class1);
                if(kSerializer0 == null) {
                    return null;
                }
            }
            KSerializer kSerializer1 = BuiltinSerializersKt.ArraySerializer(df.d.y(class1), kSerializer0);
            q.e(kSerializer1, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return kSerializer1;
        }
        return SerializersKt__SerializersJvmKt.reflectiveOrContextual$SerializersKt__SerializersJvmKt(serializersModule0, class0, w.a);
    }
}

