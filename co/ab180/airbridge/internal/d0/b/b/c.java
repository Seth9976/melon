package co.ab180.airbridge.internal.d0.b.b;

import java.lang.reflect.InvocationTargetException;

public abstract class c {
    private Class a;
    private Object b;

    public c(String s) {
        try {
            Class class0 = Class.forName(s);
            this.a = class0;
            this.b = class0.newInstance();
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new a(classNotFoundException0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new a(illegalAccessException0);
        }
        catch(InstantiationException instantiationException0) {
            throw new a(instantiationException0);
        }
    }

    public c(String s, Object object0) {
        try {
            Class class0 = Class.forName(s);
            this.a = class0;
            if(!class0.isInstance(object0)) {
                throw new a("Instance type is not same as class name that you provided");
            }
            this.b = object0;
            return;
        }
        catch(ClassNotFoundException classNotFoundException0) {
        }
        throw new a(classNotFoundException0);
    }

    public c(String s, Class[] arr_class, Object[] arr_object) {
        try {
            Class class0 = Class.forName(s);
            this.a = class0;
            this.b = class0.getConstructor(arr_class).newInstance(arr_object);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new a(classNotFoundException0);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new a(noSuchMethodException0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new a(illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new a(invocationTargetException0);
        }
        catch(InstantiationException instantiationException0) {
            throw new a(instantiationException0);
        }
    }

    public static Object a(String s, String s1) {
        try {
            return Class.forName(s).getMethod(s1, null).invoke(null, null);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new a(classNotFoundException0);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new a(noSuchMethodException0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new a(illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new a(invocationTargetException0);
        }
    }

    public static Object a(String s, String s1, Class[] arr_class, Object[] arr_object) {
        try {
            return Class.forName(s).getMethod(s1, arr_class).invoke(null, arr_object);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new a(classNotFoundException0);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new a(noSuchMethodException0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new a(illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new a(invocationTargetException0);
        }
    }

    public Class a() {
        return this.a;
    }

    public Object a(String s) {
        try {
            return this.a.getMethod(s, null).invoke(this.b, null);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new a(noSuchMethodException0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new a(illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new a(invocationTargetException0);
        }
    }

    public Object a(String s, Class[] arr_class, Object[] arr_object) {
        try {
            return this.a.getMethod(s, arr_class).invoke(this.b, arr_object);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new a(noSuchMethodException0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new a(illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new a(invocationTargetException0);
        }
    }

    public Object b() {
        return this.b;
    }
}

