package y;

import N1.C;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import jeb.synthetic.TWR;

public abstract class f {
    public static final ArrayMap a;
    public static final ArrayMap b;

    static {
        ArrayMap arrayMap0 = new ArrayMap();
        arrayMap0.put(Boolean.class, "bool");
        arrayMap0.put(Byte.class, "byte");
        arrayMap0.put(Short.class, "short");
        arrayMap0.put(Integer.class, "int");
        arrayMap0.put(Long.class, "long");
        arrayMap0.put(Double.class, "double");
        arrayMap0.put(Float.class, "float");
        arrayMap0.put(String.class, "string");
        arrayMap0.put(Parcelable.class, "parcelable");
        arrayMap0.put(Map.class, "map");
        arrayMap0.put(List.class, "list");
        arrayMap0.put(IconCompat.class, "image");
        f.a = arrayMap0;
        ArrayMap arrayMap1 = new ArrayMap();
        arrayMap1.put(0, "primitive");
        arrayMap1.put(1, "iInterface");
        arrayMap1.put(9, "iBinder");
        arrayMap1.put(2, "map");
        arrayMap1.put(3, "set");
        arrayMap1.put(4, "list");
        arrayMap1.put(5, "object");
        arrayMap1.put(6, "image");
        f.b = arrayMap1;
    }

    public static void a(Bundle bundle0, AbstractCollection abstractCollection0, d d0) {
        ArrayList arrayList0 = bundle0.getParcelableArrayList("tag_value");
        if(arrayList0 == null) {
            throw new e("Bundle is missing the collection", d0);
        }
        for(Object object0: arrayList0) {
            abstractCollection0.add(f.f(((Bundle)(((Parcelable)object0))), d0));
        }
    }

    public static Object b(Bundle bundle0, d d0) {
        String s = bundle0.getString("tag_value");
        if(s == null) {
            throw new e("Missing enum name [" + null + "]", d0);
        }
        String s1 = bundle0.getString("tag_class_name");
        if(s1 != null) {
            try {
                return f.g(Class.forName(s1), "valueOf", d0).invoke(null, s);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                throw new e("Enum value [" + s + "] does not exist in enum class [" + s1 + "]", d0, illegalArgumentException0);
            }
            catch(ClassNotFoundException classNotFoundException0) {
                throw new e("Enum class [" + s1 + "] not found", d0, classNotFoundException0);
            }
            catch(ReflectiveOperationException reflectiveOperationException0) {
                throw new e("Enum of class [" + s1 + "] missing valueOf method", d0, reflectiveOperationException0);
            }
        }
        throw new e("Missing enum className [" + null + "]", d0);
    }

    public static Object c(Bundle bundle0, d d0) {
        IBinder iBinder0 = bundle0.getBinder("tag_value");
        if(iBinder0 == null) {
            throw new e("Bundle is missing the binder", d0);
        }
        String s = bundle0.getString("tag_class_name");
        if(s != null) {
            try {
                Object object0 = f.g(Class.forName(s), "asInterface", d0).invoke(null, iBinder0);
                if(object0 == null) {
                    throw new e("Failed to get interface from binder", d0);
                }
                return object0;
            }
            catch(ClassNotFoundException classNotFoundException0) {
                throw new e("Binder for unknown IInterface: " + s, d0, classNotFoundException0);
            }
            catch(ReflectiveOperationException reflectiveOperationException0) {
                throw new e("Method to create IInterface from a Binder is not accessible for interface: " + s, d0, reflectiveOperationException0);
            }
        }
        throw new e("Bundle is missing IInterface class name", d0);
    }

    public static HashMap d(Bundle bundle0, d d0) {
        ArrayList arrayList0 = bundle0.getParcelableArrayList("tag_value");
        if(arrayList0 == null) {
            throw new e("Bundle is missing the map", d0);
        }
        HashMap hashMap0 = new HashMap();
        for(Object object0: arrayList0) {
            Bundle bundle1 = ((Bundle)(((Parcelable)object0))).getBundle("tag_1");
            Bundle bundle2 = ((Bundle)(((Parcelable)object0))).getBundle("tag_2");
            if(bundle1 == null) {
                throw new e("Bundle is missing key", d0);
            }
            hashMap0.put(f.f(bundle1, d0), (bundle2 == null ? null : f.f(bundle2, d0)));
        }
        return hashMap0;
    }

    public static Object e(Bundle bundle0, d d0) {
        String s = bundle0.getString("tag_class_name");
        if(s == null) {
            throw new e("Bundle is missing the class name", d0);
        }
        try {
            Class class0 = Class.forName(s);
            Constructor constructor0 = class0.getDeclaredConstructor(null);
            constructor0.setAccessible(true);
            Object object0 = constructor0.newInstance(null);
            for(Object object1: f.h(class0)) {
                Field field0 = (Field)object1;
                field0.setAccessible(true);
                String s1 = field0.getDeclaringClass().getName() + field0.getName();
                Object object2 = bundle0.get(s1);
                if(object2 == null) {
                    object2 = bundle0.get(s1.replaceAll("androidx.core.graphics.drawable.IconCompat", "android.support.v4.graphics.drawable.IconCompat"));
                }
                if(object2 instanceof Bundle) {
                    field0.set(object0, f.f(((Bundle)object2), d0));
                }
                else if(object2 == null && Log.isLoggable("CarApp.Bun", 3)) {
                    Log.d("CarApp.Bun", "Value is null for field: " + field0);
                }
            }
            return object0;
        }
        catch(ClassNotFoundException classNotFoundException0) {
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new e("Object missing no args constructor: " + s, d0, noSuchMethodException0);
        }
        catch(ReflectiveOperationException reflectiveOperationException0) {
            throw new e("Constructor or field is not accessible: " + s, d0, reflectiveOperationException0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            throw new e("Failed to deserialize class: " + s, d0, illegalArgumentException0);
        }
        throw new e("Object for unknown class: " + s, d0, classNotFoundException0);
    }

    public static Object f(Bundle bundle0, d d0) {
        C c0;
        IBinder iBinder0;
        Class class0;
        Object object3;
        IconCompat iconCompat0;
        Object object2;
        ArrayList arrayList0;
        HashSet hashSet0;
        HashMap hashMap0;
        Object object1;
        Object object0;
        ClassLoader classLoader0 = f.class.getClassLoader();
        Objects.requireNonNull(classLoader0);
        bundle0.setClassLoader(classLoader0);
        int v = bundle0.getInt("tag_class_type");
        Integer integer0 = bundle0.getInt("tag_class_type");
        String s = (String)f.b.get(integer0);
        if(s == null) {
            s = "unknown";
        }
        d d1 = new d(bundle0, s, d0.b);
        try {
            switch(v) {
                case 0: {
                    object0 = bundle0.get("tag_value");
                    if(object0 == null) {
                        throw new e("Bundle is missing the primitive value", d1);
                    }
                    break;
                }
                case 1: {
                    goto label_16;
                }
                case 2: {
                    goto label_19;
                }
                case 3: {
                    goto label_22;
                }
                case 4: {
                    goto label_26;
                }
                case 5: {
                    goto label_30;
                }
                case 6: {
                    goto label_33;
                }
                case 7: {
                    goto label_41;
                }
                case 8: {
                    goto label_44;
                }
                case 9: {
                    goto label_53;
                }
                case 10: {
                    goto label_58;
                }
                default: {
                    throw new e("Unsupported class type in bundle: " + v, d1);
                }
            }
        }
        catch(Throwable throwable0) {
            goto label_61;
        }
        d1.close();
        return object0;
        try {
        label_16:
            object1 = f.c(bundle0, d1);
        }
        catch(Throwable throwable0) {
            goto label_61;
        }
        d1.close();
        return object1;
        try {
        label_19:
            hashMap0 = f.d(bundle0, d1);
        }
        catch(Throwable throwable0) {
            goto label_61;
        }
        d1.close();
        return hashMap0;
        try {
        label_22:
            hashSet0 = new HashSet();
            f.a(bundle0, hashSet0, d1);
        }
        catch(Throwable throwable0) {
            goto label_61;
        }
        d1.close();
        return hashSet0;
        try {
        label_26:
            arrayList0 = new ArrayList();
            f.a(bundle0, arrayList0, d1);
        }
        catch(Throwable throwable0) {
            goto label_61;
        }
        d1.close();
        return arrayList0;
        try {
        label_30:
            object2 = f.e(bundle0, d1);
        }
        catch(Throwable throwable0) {
            goto label_61;
        }
        d1.close();
        return object2;
        try {
        label_33:
            Bundle bundle1 = bundle0.getBundle("tag_value");
            if(bundle1 == null) {
                throw new e("IconCompat bundle is null", d1);
            }
            iconCompat0 = IconCompat.b(bundle1);
            if(iconCompat0 == null) {
                throw new e("Failed to create IconCompat from bundle", d1);
            }
        }
        catch(Throwable throwable0) {
            goto label_61;
        }
        d1.close();
        return iconCompat0;
        try {
        label_41:
            object3 = f.b(bundle0, d1);
        }
        catch(Throwable throwable0) {
            goto label_61;
        }
        d1.close();
        return object3;
        try {
        label_44:
            String s1 = bundle0.getString("tag_value");
            if(s1 == null) {
                throw new e("Class is missing the class name", d1);
            }
            try {
                class0 = Class.forName(s1);
            }
            catch(ClassNotFoundException classNotFoundException0) {
                throw new e("Class name is unknown: " + s1, d1, classNotFoundException0);
            }
        }
        catch(Throwable throwable0) {
            goto label_61;
        }
        d1.close();
        return class0;
        try {
        label_53:
            iBinder0 = bundle0.getBinder("tag_value");
            if(iBinder0 == null) {
                throw new e("Bundle is missing the binder", d1);
            }
        }
        catch(Throwable throwable0) {
            goto label_61;
        }
        d1.close();
        return iBinder0;
        try {
        label_58:
            c0 = C.a(bundle0);
        }
        catch(Throwable throwable0) {
        label_61:
            TWR.safeClose$NT(d1, throwable0);
            throw throwable0;
        }
        d1.close();
        return c0;
    }

    public static Method g(Class class0, String s, d d0) {
        if(class0 == null || class0 == Object.class) {
            throw new e("No method " + s + " in class " + class0, d0);
        }
        Method[] arr_method = class0.getDeclaredMethods();
        for(int v = 0; v < arr_method.length; ++v) {
            Method method0 = arr_method[v];
            if(method0.getName().equals(s)) {
                method0.setAccessible(true);
                return method0;
            }
        }
        return f.g(class0.getSuperclass(), s, d0);
    }

    public static ArrayList h(Class class0) {
        ArrayList arrayList0 = new ArrayList();
        if(class0 != null && class0 != Object.class) {
            Field[] arr_field = class0.getDeclaredFields();
            for(int v = 0; v < arr_field.length; ++v) {
                Field field0 = arr_field[v];
                if(!Modifier.isStatic(field0.getModifiers())) {
                    arrayList0.add(field0);
                }
            }
            arrayList0.addAll(f.h(class0.getSuperclass()));
        }
        return arrayList0;
    }

    public static String i(Class class0) {
        String s = (String)f.a.get(class0);
        if(s == null) {
            if(List.class.isAssignableFrom(class0)) {
                return "<List>";
            }
            if(Map.class.isAssignableFrom(class0)) {
                return "<Map>";
            }
            if(Set.class.isAssignableFrom(class0)) {
                return "<Set>";
            }
        }
        return s == null ? class0.getSimpleName() : s;
    }

    public static Bundle j(Collection collection0, d d0) {
        Bundle bundle0 = new Bundle(2);
        ArrayList arrayList0 = new ArrayList();
        int v = 0;
        for(Object object0: collection0) {
            arrayList0.add(f.o(object0, "<item " + v + ">", d0));
            ++v;
        }
        bundle0.putParcelableArrayList("tag_value", arrayList0);
        return bundle0;
    }

    public static Bundle k(Object object0, d d0) {
        String s;
        Bundle bundle0 = new Bundle(3);
        bundle0.putInt("tag_class_type", 7);
        Method method0 = f.g(object0.getClass(), "name", d0);
        try {
            s = (String)method0.invoke(object0, null);
        }
        catch(ReflectiveOperationException reflectiveOperationException0) {
            throw new e("Enum missing name method", d0, reflectiveOperationException0);
        }
        bundle0.putString("tag_value", s);
        bundle0.putString("tag_class_name", object0.getClass().getName());
        return bundle0;
    }

    public static Bundle l(Map map0, d d0) {
        Bundle bundle0 = new Bundle(2);
        ArrayList arrayList0 = new ArrayList();
        int v = 0;
        for(Object object0: map0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            Bundle bundle1 = new Bundle(2);
            bundle1.putBundle("tag_1", f.o(map$Entry0.getKey(), "<key " + v + ">", d0));
            if(map$Entry0.getValue() != null) {
                bundle1.putBundle("tag_2", f.o(map$Entry0.getValue(), "<value " + v + ">", d0));
            }
            ++v;
            arrayList0.add(bundle1);
        }
        bundle0.putInt("tag_class_type", 2);
        bundle0.putParcelableArrayList("tag_value", arrayList0);
        return bundle0;
    }

    public static Bundle m(Object object0, d d0) {
        Object object2;
        String s = object0.getClass().getName();
        try {
            object0.getClass().getDeclaredConstructor(null);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new e("Class to deserialize is missing a no args constructor: " + s, d0, noSuchMethodException0);
        }
        ArrayList arrayList0 = f.h(object0.getClass());
        Bundle bundle0 = new Bundle(arrayList0.size() + 2);
        bundle0.putInt("tag_class_type", 5);
        bundle0.putString("tag_class_name", s);
        for(Object object1: arrayList0) {
            Field field0 = (Field)object1;
            field0.setAccessible(true);
            String s1 = va.e.h(field0.getDeclaringClass().getName(), field0.getName());
            try {
                object2 = field0.get(object0);
                if(object2 == null) {
                    continue;
                }
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw new e("Field is not accessible: " + s1, d0, illegalAccessException0);
            }
            bundle0.putParcelable(s1, f.o(object2, field0.getName(), d0));
        }
        return bundle0;
    }

    public static Bundle n(Object object0, d d0) {
        Bundle bundle0 = new Bundle(2);
        bundle0.putInt("tag_class_type", 0);
        if(object0 instanceof Boolean) {
            bundle0.putBoolean("tag_value", ((Boolean)object0).booleanValue());
            return bundle0;
        }
        if(object0 instanceof Byte) {
            bundle0.putByte("tag_value", ((byte)(((Byte)object0))));
            return bundle0;
        }
        if(object0 instanceof Character) {
            bundle0.putChar("tag_value", ((Character)object0).charValue());
            return bundle0;
        }
        if(object0 instanceof Short) {
            bundle0.putShort("tag_value", ((short)(((Short)object0))));
            return bundle0;
        }
        if(object0 instanceof Integer) {
            bundle0.putInt("tag_value", ((int)(((Integer)object0))));
            return bundle0;
        }
        if(object0 instanceof Long) {
            bundle0.putLong("tag_value", ((long)(((Long)object0))));
            return bundle0;
        }
        if(object0 instanceof Double) {
            bundle0.putDouble("tag_value", ((double)(((Double)object0))));
            return bundle0;
        }
        if(object0 instanceof Float) {
            bundle0.putFloat("tag_value", ((float)(((Float)object0))));
            return bundle0;
        }
        if(object0 instanceof String) {
            bundle0.putString("tag_value", ((String)object0));
            return bundle0;
        }
        if(!(object0 instanceof Parcelable)) {
            throw new e("Unsupported primitive type: " + object0.getClass().getName(), d0);
        }
        bundle0.putParcelable("tag_value", ((Parcelable)object0));
        return bundle0;
    }

    public static Bundle o(Object object0, String s, d d0) {
        Bundle bundle10;
        Bundle bundle9;
        Bundle bundle8;
        Bundle bundle7;
        Bundle bundle6;
        Bundle bundle5;
        Bundle bundle4;
        Bundle bundle3;
        Bundle bundle2;
        Bundle bundle1;
        Bundle bundle0;
        ArrayDeque arrayDeque0 = d0.b;
        if(object0 != null) {
            for(Object object1: arrayDeque0) {
                if(((c)object1).a == object0) {
                    throw new b("Found cycle while bundling type " + object0.getClass().getSimpleName(), d0);  // 初始化器: Ly/e;-><init>(Ljava/lang/String;Ly/d;)V
                }
                if(false) {
                    break;
                }
            }
        }
        d d1 = new d(object0, s, arrayDeque0);
        try {
            if(object0 == null) {
                throw new e("Bundling of null object is not supported", d1);
            }
            if(!(object0 instanceof IconCompat)) {
                if(!(object0 instanceof Boolean) && !(object0 instanceof Byte) && !(object0 instanceof Character) && !(object0 instanceof Short) && !(object0 instanceof Integer) && !(object0 instanceof Long) && !(object0 instanceof Double) && !(object0 instanceof Float) && !(object0 instanceof String) && !(object0 instanceof Parcelable)) {
                    if(!(object0 instanceof IInterface)) {
                        if(!(object0 instanceof IBinder)) {
                            if(!(object0 instanceof Map)) {
                                if(!(object0 instanceof List)) {
                                    if(!(object0 instanceof Set)) {
                                        if(!object0.getClass().isEnum()) {
                                            if(!(object0 instanceof Class)) {
                                                if(object0.getClass().isArray()) {
                                                    throw new e("Object serializing contains an array, use a list or a set instead", d1);
                                                }
                                                if(object0 instanceof C) {
                                                    bundle0 = ((C)object0).b();
                                                    bundle0.putInt("tag_class_type", 10);
                                                    goto label_25;
                                                }
                                                goto label_27;
                                            }
                                            goto label_30;
                                        }
                                        goto label_35;
                                    }
                                    goto label_38;
                                }
                                goto label_42;
                            }
                            goto label_46;
                        }
                        goto label_49;
                    }
                    goto label_54;
                }
                goto label_61;
            }
            goto label_64;
        }
        catch(Throwable throwable0) {
            goto label_69;
        }
    label_25:
        d1.close();
        return bundle0;
        try {
        label_27:
            bundle1 = f.m(object0, d1);
        }
        catch(Throwable throwable0) {
            goto label_69;
        }
        d1.close();
        return bundle1;
        try {
        label_30:
            bundle2 = new Bundle(2);
            bundle2.putInt("tag_class_type", 8);
            bundle2.putString("tag_value", ((Class)object0).getName());
        }
        catch(Throwable throwable0) {
            goto label_69;
        }
        d1.close();
        return bundle2;
        try {
        label_35:
            bundle3 = f.k(object0, d1);
        }
        catch(Throwable throwable0) {
            goto label_69;
        }
        d1.close();
        return bundle3;
        try {
        label_38:
            bundle4 = f.j(((Set)object0), d1);
            bundle4.putInt("tag_class_type", 3);
        }
        catch(Throwable throwable0) {
            goto label_69;
        }
        d1.close();
        return bundle4;
        try {
        label_42:
            bundle5 = f.j(((List)object0), d1);
            bundle5.putInt("tag_class_type", 4);
        }
        catch(Throwable throwable0) {
            goto label_69;
        }
        d1.close();
        return bundle5;
        try {
        label_46:
            bundle6 = f.l(((Map)object0), d1);
        }
        catch(Throwable throwable0) {
            goto label_69;
        }
        d1.close();
        return bundle6;
        try {
        label_49:
            bundle7 = new Bundle(2);
            bundle7.putInt("tag_class_type", 9);
            bundle7.putBinder("tag_value", ((IBinder)object0));
        }
        catch(Throwable throwable0) {
            goto label_69;
        }
        d1.close();
        return bundle7;
        try {
        label_54:
            bundle8 = new Bundle(3);
            String s1 = ((IInterface)object0).getClass().getName();
            bundle8.putInt("tag_class_type", 1);
            bundle8.putBinder("tag_value", ((IInterface)object0).asBinder());
            bundle8.putString("tag_class_name", s1);
        }
        catch(Throwable throwable0) {
            goto label_69;
        }
        d1.close();
        return bundle8;
        try {
        label_61:
            bundle9 = f.n(object0, d1);
        }
        catch(Throwable throwable0) {
            goto label_69;
        }
        d1.close();
        return bundle9;
        try {
        label_64:
            bundle10 = new Bundle(2);
            bundle10.putInt("tag_class_type", 6);
            bundle10.putBundle("tag_value", ((IconCompat)object0).j());
        }
        catch(Throwable throwable0) {
        label_69:
            TWR.safeClose$NT(d1, throwable0);
            throw throwable0;
        }
        d1.close();
        return bundle10;
    }
}

