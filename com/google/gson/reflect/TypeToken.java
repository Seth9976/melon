package com.google.gson.reflect;

import T7.e;
import T7.f;
import T7.h;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TypeToken {
    private final int hashCode;
    private final Class rawType;
    private final Type type;

    public TypeToken() {
        Type type0 = this.getTypeTokenTypeArgument();
        this.type = type0;
        this.rawType = h.h(type0);
        this.hashCode = type0.hashCode();
    }

    private TypeToken(Type type0) {
        Objects.requireNonNull(type0);
        Type type1 = h.a(type0);
        this.type = type1;
        this.rawType = h.h(type1);
        this.hashCode = type1.hashCode();
    }

    private static IllegalArgumentException buildUnsupportedTypeException(Type type0, Class[] arr_class) {
        StringBuilder stringBuilder0 = new StringBuilder("Unsupported type, expected one of: ");
        for(int v = 0; v < arr_class.length; ++v) {
            stringBuilder0.append(arr_class[v].getName());
            stringBuilder0.append(", ");
        }
        stringBuilder0.append("but got: ");
        stringBuilder0.append(type0.getClass().getName());
        stringBuilder0.append(", for type token: ");
        stringBuilder0.append(type0.toString());
        return new IllegalArgumentException(stringBuilder0.toString());
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof TypeToken && h.e(this.type, ((TypeToken)object0).type);
    }

    public static TypeToken get(Class class0) {
        return new TypeToken(class0);
    }

    public static TypeToken get(Type type0) {
        return new TypeToken(type0);
    }

    public static TypeToken getArray(Type type0) {
        return new TypeToken(new e(type0));
    }

    public static TypeToken getParameterized(Type type0, Type[] arr_type) {
        Objects.requireNonNull(type0);
        Objects.requireNonNull(arr_type);
        if(!(type0 instanceof Class)) {
            throw new IllegalArgumentException("rawType must be of type Class, but was " + type0);
        }
        TypeVariable[] arr_typeVariable = ((Class)type0).getTypeParameters();
        if(arr_type.length != arr_typeVariable.length) {
            throw new IllegalArgumentException(((Class)type0).getName() + " requires " + arr_typeVariable.length + " type arguments, but got " + arr_type.length);
        }
        if(arr_type.length == 0) {
            return TypeToken.get(((Class)type0));
        }
        if(type0 instanceof Class && !Modifier.isStatic(((Class)type0).getModifiers()) && ((Class)type0).getDeclaringClass() != null) {
            throw new IllegalArgumentException("Raw type " + ((Class)type0).getName() + " is not supported because it requires specifying an owner type");
        }
        for(int v = 0; v < arr_typeVariable.length; ++v) {
            Type type1 = arr_type[v];
            Objects.requireNonNull(type1, "Type argument must not be null");
            Class class0 = h.h(type1);
            TypeVariable typeVariable0 = arr_typeVariable[v];
            Type[] arr_type1 = typeVariable0.getBounds();
            for(int v1 = 0; v1 < arr_type1.length; ++v1) {
                if(!h.h(arr_type1[v1]).isAssignableFrom(class0)) {
                    throw new IllegalArgumentException("Type argument " + type1 + " does not satisfy bounds for type variable " + typeVariable0 + " declared by " + type0);
                }
            }
        }
        return new TypeToken(new f(null, ((Class)type0), arr_type));
    }

    public final Class getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    private Type getTypeTokenTypeArgument() {
        Type type0 = this.getClass().getGenericSuperclass();
        Class class0 = TypeToken.class;
        if(!(type0 instanceof ParameterizedType)) {
            throw type0 == class0 ? new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee https://github.com/google/gson/blob/main/Troubleshooting.md#type-token-raw") : new IllegalStateException("Must only create direct subclasses of TypeToken");
        }
        if(((ParameterizedType)type0).getRawType() != class0) {
            throw new IllegalStateException("Must only create direct subclasses of TypeToken");
        }
        Type type1 = h.a(((ParameterizedType)type0).getActualTypeArguments()[0]);
        if(TypeToken.isCapturingTypeVariablesForbidden()) {
            TypeToken.verifyNoTypeVariable(type1);
        }
        return type1;
    }

    @Override
    public final int hashCode() {
        return this.hashCode;
    }

    private static boolean isAssignableFrom(Type type0, GenericArrayType genericArrayType0) {
        Type type1 = genericArrayType0.getGenericComponentType();
        if(type1 instanceof ParameterizedType) {
            if(type0 instanceof GenericArrayType) {
                return TypeToken.isAssignableFrom(((GenericArrayType)type0).getGenericComponentType(), ((ParameterizedType)type1), new HashMap());
            }
            if(type0 instanceof Class) {
                for(type0 = (Class)type0; ((Class)type0).isArray(); type0 = ((Class)type0).getComponentType()) {
                }
            }
            return TypeToken.isAssignableFrom(type0, ((ParameterizedType)type1), new HashMap());
        }
        return true;
    }

    private static boolean isAssignableFrom(Type type0, ParameterizedType parameterizedType0, Map map0) {
        if(type0 == null) {
            return false;
        }
        if(parameterizedType0.equals(type0)) {
            return true;
        }
        Class class0 = h.h(type0);
        ParameterizedType parameterizedType1 = type0 instanceof ParameterizedType ? ((ParameterizedType)type0) : null;
        if(parameterizedType1 != null) {
            Type[] arr_type = parameterizedType1.getActualTypeArguments();
            TypeVariable[] arr_typeVariable = class0.getTypeParameters();
            for(int v1 = 0; v1 < arr_type.length; ++v1) {
                Type type1 = arr_type[v1];
                TypeVariable typeVariable0 = arr_typeVariable[v1];
                while(type1 instanceof TypeVariable) {
                    type1 = (Type)map0.get(((TypeVariable)type1).getName());
                }
                map0.put(typeVariable0.getName(), type1);
            }
            if(TypeToken.typeEquals(parameterizedType1, parameterizedType0, map0)) {
                return true;
            }
        }
        Type[] arr_type1 = class0.getGenericInterfaces();
        for(int v = 0; v < arr_type1.length; ++v) {
            if(TypeToken.isAssignableFrom(arr_type1[v], parameterizedType0, new HashMap(map0))) {
                return true;
            }
        }
        return TypeToken.isAssignableFrom(class0.getGenericSuperclass(), parameterizedType0, new HashMap(map0));
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken typeToken0) {
        return this.isAssignableFrom(typeToken0.getType());
    }

    @Deprecated
    public boolean isAssignableFrom(Class class0) {
        return this.isAssignableFrom(class0);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type0) {
        if(type0 == null) {
            return false;
        }
        if(this.type.equals(type0)) {
            return true;
        }
        Type type1 = this.type;
        if(type1 instanceof Class) {
            Class class0 = h.h(type0);
            return this.rawType.isAssignableFrom(class0);
        }
        if(type1 instanceof ParameterizedType) {
            return TypeToken.isAssignableFrom(type0, ((ParameterizedType)type1), new HashMap());
        }
        if(!(type1 instanceof GenericArrayType)) {
            throw TypeToken.buildUnsupportedTypeException(type1, new Class[]{Class.class, ParameterizedType.class, GenericArrayType.class});
        }
        Class class1 = h.h(type0);
        return this.rawType.isAssignableFrom(class1) && TypeToken.isAssignableFrom(type0, ((GenericArrayType)this.type));
    }

    private static boolean isCapturingTypeVariablesForbidden() {
        return !Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true");
    }

    // 去混淆评级： 低(30)
    private static boolean matches(Type type0, Type type1, Map map0) {
        return type1.equals(type0) || type0 instanceof TypeVariable && type1.equals(map0.get(((TypeVariable)type0).getName()));
    }

    @Override
    public final String toString() {
        return h.l(this.type);
    }

    private static boolean typeEquals(ParameterizedType parameterizedType0, ParameterizedType parameterizedType1, Map map0) {
        if(parameterizedType0.getRawType().equals(parameterizedType1.getRawType())) {
            Type[] arr_type = parameterizedType0.getActualTypeArguments();
            Type[] arr_type1 = parameterizedType1.getActualTypeArguments();
            for(int v = 0; v < arr_type.length; ++v) {
                if(!TypeToken.matches(arr_type[v], arr_type1[v], map0)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static void verifyNoTypeVariable(Type type0) {
        int v = 0;
        if(type0 instanceof TypeVariable) {
            throw new IllegalArgumentException("TypeToken type argument must not contain a type variable; captured type variable " + ((TypeVariable)type0).getName() + " declared by " + ((TypeVariable)type0).getGenericDeclaration() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#typetoken-type-variable");
        }
        if(type0 instanceof GenericArrayType) {
            TypeToken.verifyNoTypeVariable(((GenericArrayType)type0).getGenericComponentType());
            return;
        }
        if(type0 instanceof ParameterizedType) {
            Type type1 = ((ParameterizedType)type0).getOwnerType();
            if(type1 != null) {
                TypeToken.verifyNoTypeVariable(type1);
            }
            Type[] arr_type = ((ParameterizedType)type0).getActualTypeArguments();
            while(v < arr_type.length) {
                TypeToken.verifyNoTypeVariable(arr_type[v]);
                ++v;
            }
            return;
        }
        if(type0 instanceof WildcardType) {
            Type[] arr_type1 = ((WildcardType)type0).getLowerBounds();
            for(int v1 = 0; v1 < arr_type1.length; ++v1) {
                TypeToken.verifyNoTypeVariable(arr_type1[v1]);
            }
            Type[] arr_type2 = ((WildcardType)type0).getUpperBounds();
            while(v < arr_type2.length) {
                TypeToken.verifyNoTypeVariable(arr_type2[v]);
                ++v;
            }
            return;
        }
        if(type0 == null) {
            throw new IllegalArgumentException("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
        }
    }
}

