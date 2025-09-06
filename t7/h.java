package T7;

import H0.b;
import W7.a;
import W7.c;
import com.google.gson.internal.bind.X;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.x;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public abstract class h {
    public static final Type[] a;

    static {
        h.a = new Type[0];
    }

    public static Type a(Type type0) {
        if(type0 instanceof Class) {
            return ((Class)type0).isArray() ? new e(h.a(((Class)type0).getComponentType())) : ((Class)type0);
        }
        if(type0 instanceof ParameterizedType) {
            return new f(((ParameterizedType)type0).getOwnerType(), ((Class)((ParameterizedType)type0).getRawType()), ((ParameterizedType)type0).getActualTypeArguments());
        }
        if(type0 instanceof GenericArrayType) {
            return new e(((GenericArrayType)type0).getGenericComponentType());
        }
        return type0 instanceof WildcardType ? new g(((WildcardType)type0).getUpperBounds(), ((WildcardType)type0).getLowerBounds()) : type0;
    }

    public static void b(boolean z) {
        if(!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void c(Type type0) {
        h.b(!(type0 instanceof Class) || !((Class)type0).isPrimitive());
    }

    public static void d(String s) {
        if(s.length() > 10000) {
            throw new NumberFormatException("Number string too large: " + s.substring(0, 30) + "...");
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
            return type1 instanceof ParameterizedType ? Objects.equals(((ParameterizedType)type0).getOwnerType(), ((ParameterizedType)type1).getOwnerType()) && ((ParameterizedType)type0).getRawType().equals(((ParameterizedType)type1).getRawType()) && Arrays.equals(((ParameterizedType)type0).getActualTypeArguments(), ((ParameterizedType)type1).getActualTypeArguments()) : false;
        }
        if(type0 instanceof GenericArrayType) {
            return type1 instanceof GenericArrayType ? h.e(((GenericArrayType)type0).getGenericComponentType(), ((GenericArrayType)type1).getGenericComponentType()) : false;
        }
        if(type0 instanceof WildcardType) {
            return type1 instanceof WildcardType ? Arrays.equals(((WildcardType)type0).getUpperBounds(), ((WildcardType)type1).getUpperBounds()) && Arrays.equals(((WildcardType)type0).getLowerBounds(), ((WildcardType)type1).getLowerBounds()) : false;
        }
        return type0 instanceof TypeVariable && type1 instanceof TypeVariable ? Objects.equals(((TypeVariable)type0).getGenericDeclaration(), ((TypeVariable)type1).getGenericDeclaration()) && ((TypeVariable)type0).getName().equals(((TypeVariable)type1).getName()) : false;
    }

    public static void f(List list0) {
        Iterator iterator0 = list0.iterator();
        if(iterator0.hasNext()) {
            throw b.b(iterator0);
        }
    }

    public static Type g(Type type0, Class class0, Class class1) {
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
                    return h.g(class0.getGenericInterfaces()[v], arr_class[v], class1);
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
                    return h.g(class0.getGenericSuperclass(), class3, class1);
                }
                class0 = class3;
            }
        }
        return class1;
    }

    public static Class h(Type type0) {
        if(type0 instanceof Class) {
            return (Class)type0;
        }
        if(type0 instanceof ParameterizedType) {
            Type type1 = ((ParameterizedType)type0).getRawType();
            h.b(type1 instanceof Class);
            return (Class)type1;
        }
        if(type0 instanceof GenericArrayType) {
            return Array.newInstance(h.h(((GenericArrayType)type0).getGenericComponentType()), 0).getClass();
        }
        if(type0 instanceof TypeVariable) {
            return Object.class;
        }
        if(!(type0 instanceof WildcardType)) {
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type0 + "> is of type " + (type0 == null ? "null" : type0.getClass().getName()));
        }
        return h.h(((WildcardType)type0).getUpperBounds()[0]);
    }

    public static q i(a a0) {
        try {
            boolean z = true;
            a0.Z();
            z = false;
            return (q)X.z.b(a0);
        }
        catch(EOFException eOFException0) {
            if(!z) {
                throw new x(eOFException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
            }
            return s.a;
        }
        catch(c c0) {
            throw new x(c0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
        }
        catch(IOException iOException0) {
            throw new r(iOException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
        }
        catch(NumberFormatException numberFormatException0) {
            throw new x(numberFormatException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
        }
    }

    public static BigDecimal j(String s) {
        h.d(s);
        BigDecimal bigDecimal0 = new BigDecimal(s);
        if(Math.abs(bigDecimal0.scale()) >= 10000L) {
            throw new NumberFormatException("Number has unsupported scale: " + s);
        }
        return bigDecimal0;
    }

    public static Type k(Type type0, Class class0, Type type1, HashMap hashMap0) {
        int v;
        TypeVariable typeVariable0 = null;
    alab1:
        do {
            v = 0;
            if(!(type1 instanceof TypeVariable)) {
                goto label_27;
            }
            TypeVariable typeVariable1 = (TypeVariable)type1;
            Type type2 = (Type)hashMap0.get(typeVariable1);
            Class class1 = Void.TYPE;
            if(type2 != null) {
                return type2 == class1 ? type1 : type2;
            }
            hashMap0.put(typeVariable1, class1);
            if(typeVariable0 == null) {
                typeVariable0 = typeVariable1;
            }
            GenericDeclaration genericDeclaration0 = typeVariable1.getGenericDeclaration();
            Class class2 = genericDeclaration0 instanceof Class ? ((Class)genericDeclaration0) : null;
            if(class2 != null) {
                Type type3 = h.g(type0, class0, class2);
                if(type3 instanceof ParameterizedType) {
                    TypeVariable[] arr_typeVariable = class2.getTypeParameters();
                    while(v < arr_typeVariable.length) {
                        if(typeVariable1.equals(arr_typeVariable[v])) {
                            type1 = ((ParameterizedType)type3).getActualTypeArguments()[v];
                            continue alab1;
                        }
                        ++v;
                    }
                    throw new NoSuchElementException();
                }
            }
            type1 = typeVariable1;
        }
        while(type1 != typeVariable1);
        goto label_76;
    label_27:
        if(type1 instanceof Class && ((Class)type1).isArray()) {
            Class class3 = ((Class)type1).getComponentType();
            Type type4 = h.k(type0, class0, class3, hashMap0);
            type1 = Objects.equals(class3, type4) ? ((Class)type1) : new e(type4);
        }
        else if(type1 instanceof GenericArrayType) {
            type1 = (GenericArrayType)type1;
            Type type5 = ((GenericArrayType)type1).getGenericComponentType();
            Type type6 = h.k(type0, class0, type5, hashMap0);
            if(!Objects.equals(type5, type6)) {
                type1 = new e(type6);
            }
        }
        else if(type1 instanceof ParameterizedType) {
            type1 = (ParameterizedType)type1;
            Type type7 = ((ParameterizedType)type1).getOwnerType();
            Type type8 = h.k(type0, class0, type7, hashMap0);
            boolean z = Objects.equals(type8, type7);
            Type[] arr_type = ((ParameterizedType)type1).getActualTypeArguments();
            Type[] arr_type1 = arr_type;
            boolean z1 = false;
            while(v < arr_type.length) {
                Type type9 = h.k(type0, class0, arr_type1[v], hashMap0);
                if(!Objects.equals(type9, arr_type1[v])) {
                    if(!z1) {
                        arr_type1 = (Type[])arr_type1.clone();
                        z1 = true;
                    }
                    arr_type1[v] = type9;
                }
                ++v;
            }
            if(!z || z1) {
                type1 = new f(type8, ((Class)((ParameterizedType)type1).getRawType()), arr_type1);
            }
        }
        else if(type1 instanceof WildcardType) {
            type1 = (WildcardType)type1;
            Type[] arr_type2 = ((WildcardType)type1).getLowerBounds();
            Type[] arr_type3 = ((WildcardType)type1).getUpperBounds();
            if(arr_type2.length == 1) {
                Type type10 = h.k(type0, class0, arr_type2[0], hashMap0);
                if(type10 != arr_type2[0]) {
                    Type[] arr_type4 = type10 instanceof WildcardType ? ((WildcardType)type10).getLowerBounds() : new Type[]{type10};
                    type1 = new g(new Type[]{Object.class}, arr_type4);
                }
            }
            else if(arr_type3.length == 1) {
                Type type11 = h.k(type0, class0, arr_type3[0], hashMap0);
                if(type11 != arr_type3[0]) {
                    type1 = new g((type11 instanceof WildcardType ? ((WildcardType)type11).getUpperBounds() : new Type[]{type11}), h.a);
                }
            }
        }
    label_76:
        if(typeVariable0 != null) {
            hashMap0.put(typeVariable0, type1);
        }
        return type1;
    }

    // 去混淆评级： 低(20)
    public static String l(Type type0) {
        return type0 instanceof Class ? ((Class)type0).getName() : type0.toString();
    }

    public static Class m(Class class0) {
        if(class0 == Integer.TYPE) {
            return Integer.class;
        }
        if(class0 == Float.TYPE) {
            return Float.class;
        }
        if(class0 == Byte.TYPE) {
            return Byte.class;
        }
        if(class0 == Double.TYPE) {
            return Double.class;
        }
        if(class0 == Long.TYPE) {
            return Long.class;
        }
        if(class0 == Character.TYPE) {
            return Character.class;
        }
        if(class0 == Boolean.TYPE) {
            return Boolean.class;
        }
        if(class0 == Short.TYPE) {
            return Short.class;
        }
        return class0 == Void.TYPE ? Void.class : class0;
    }
}

