package io.netty.util.internal;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public abstract class TypeParameterMatcher {
    static final class ReflectiveMatcher extends TypeParameterMatcher {
        private final Class type;

        public ReflectiveMatcher(Class class0) {
            this.type = class0;
        }

        @Override  // io.netty.util.internal.TypeParameterMatcher
        public boolean match(Object object0) {
            return this.type.isInstance(object0);
        }
    }

    private static final TypeParameterMatcher NOOP;

    static {
        TypeParameterMatcher.NOOP = new TypeParameterMatcher() {
            @Override  // io.netty.util.internal.TypeParameterMatcher
            public boolean match(Object object0) {
                return true;
            }
        };
    }

    private static Class fail(Class class0, String s) {
        throw new IllegalStateException("cannot determine the type of the type parameter \'" + s + "\': " + class0);
    }

    public static TypeParameterMatcher find(Object object0, Class class0, String s) {
        Map map0 = InternalThreadLocalMap.get().typeParameterMatcherFindCache();
        Class class1 = object0.getClass();
        Map map1 = (Map)map0.get(class1);
        if(map1 == null) {
            map1 = new HashMap();
            map0.put(class1, map1);
        }
        TypeParameterMatcher typeParameterMatcher0 = (TypeParameterMatcher)map1.get(s);
        if(typeParameterMatcher0 == null) {
            TypeParameterMatcher typeParameterMatcher1 = TypeParameterMatcher.get(TypeParameterMatcher.find0(object0, class0, s));
            map1.put(s, typeParameterMatcher1);
            return typeParameterMatcher1;
        }
        return typeParameterMatcher0;
    }

    private static Class find0(Object object0, Class class0, String s) {
        Class class3;
        Class class2;
        Class class1 = object0.getClass();
        while(true) {
            class2 = class1;
        label_2:
            if(class2.getSuperclass() != class0) {
                goto label_39;
            }
            TypeVariable[] arr_typeVariable = class2.getSuperclass().getTypeParameters();
            int v = 0;
            while(true) {
                if(v < arr_typeVariable.length) {
                    if(s.equals(arr_typeVariable[v].getName())) {
                        break;
                    }
                    else {
                        ++v;
                        continue;
                    }
                }
                v = -1;
                break;
            }
            if(v < 0) {
                throw new IllegalStateException("unknown type parameter \'" + s + "\': " + class0);
            }
            Type type0 = class2.getGenericSuperclass();
            class3 = Object.class;
            if(!(type0 instanceof ParameterizedType)) {
                return class3;
            }
            Type type1 = ((ParameterizedType)type0).getActualTypeArguments()[v];
            if(type1 instanceof ParameterizedType) {
                type1 = ((ParameterizedType)type1).getRawType();
            }
            if(type1 instanceof Class) {
                return (Class)type1;
            }
            if(type1 instanceof GenericArrayType) {
                Type type2 = ((GenericArrayType)type1).getGenericComponentType();
                if(type2 instanceof ParameterizedType) {
                    type2 = ((ParameterizedType)type2).getRawType();
                }
                if(type2 instanceof Class) {
                    return Array.newInstance(((Class)type2), 0).getClass();
                }
            }
            if(type1 instanceof TypeVariable) {
                if(!(((TypeVariable)type1).getGenericDeclaration() instanceof Class)) {
                    return class3;
                }
                Class class4 = (Class)((TypeVariable)type1).getGenericDeclaration();
                String s1 = ((TypeVariable)type1).getName();
                if(!class4.isAssignableFrom(class1)) {
                    break;
                }
                s = s1;
                class0 = class4;
                continue;
            }
            return TypeParameterMatcher.fail(class1, s);
        }
        return class3;
    label_39:
        class2 = class2.getSuperclass();
        if(class2 != null) {
            goto label_2;
        }
        return TypeParameterMatcher.fail(class1, s);
    }

    public static TypeParameterMatcher get(Class class0) {
        Map map0 = InternalThreadLocalMap.get().typeParameterMatcherGetCache();
        TypeParameterMatcher typeParameterMatcher0 = (TypeParameterMatcher)map0.get(class0);
        if(typeParameterMatcher0 == null) {
            typeParameterMatcher0 = class0 == Object.class ? TypeParameterMatcher.NOOP : new ReflectiveMatcher(class0);
            map0.put(class0, typeParameterMatcher0);
        }
        return typeParameterMatcher0;
    }

    public abstract boolean match(Object arg1);
}

