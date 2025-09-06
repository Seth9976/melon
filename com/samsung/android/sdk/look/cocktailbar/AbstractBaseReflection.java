package com.samsung.android.sdk.look.cocktailbar;

import U4.x;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import jeb.synthetic.FIN;
import k8.Y;

abstract class AbstractBaseReflection {
    private static final String TAG = "AbstractBaseReflection";
    protected Class mBaseClass;
    private HashMap mClassMap;
    private ArrayList mNameList;
    private ArrayList mReflectionList;

    public AbstractBaseReflection() {
        this.mBaseClass = null;
        this.mNameList = new ArrayList();
        this.mReflectionList = new ArrayList();
        this.mClassMap = new HashMap();
        this.loadReflection();
    }

    public AbstractBaseReflection(Class class0) {
        this.mBaseClass = null;
        this.mNameList = new ArrayList();
        this.mReflectionList = new ArrayList();
        this.mClassMap = new HashMap();
        this.loadReflection(class0);
    }

    public AbstractBaseReflection(String s) {
        this.mBaseClass = null;
        this.mNameList = new ArrayList();
        this.mReflectionList = new ArrayList();
        this.mClassMap = new HashMap();
        this.loadReflection(s);
    }

    private void addReflectionInstance(String s, Object object0) {
        synchronized(this.mNameList) {
            this.mNameList.add(s);
            this.mReflectionList.add(object0);
        }
    }

    public Object createInstance() {
        return this.createInstance(new Object[0]);
    }

    public Object createInstance(Class[] arr_class, Object[] arr_object) {
        if(arr_object == null) {
            arr_object = new Object[0];
        }
        Constructor constructor0 = this.loadConstructorIfNeeded(arr_class);
        if(constructor0 == null) {
            Log.d(this.getBaseClassName(), "Cannot invoke there\'s no constructor.");
            return null;
        }
        try {
            constructor0.setAccessible(true);
            return constructor0.newInstance(arr_object);
        }
        catch(IllegalAccessException illegalAccessException0) {
            System.err.println(this.getBaseClassName() + " IllegalAccessException encountered invoking constructor " + illegalAccessException0);
            return null;
        }
        catch(InvocationTargetException invocationTargetException0) {
            System.err.println(this.getBaseClassName() + " InvocationTargetException encountered invoking constructor " + invocationTargetException0);
            return null;
        }
        catch(InstantiationException instantiationException0) {
            instantiationException0.printStackTrace();
            System.err.println(this.getBaseClassName() + " InstantiationException encountered invoking constructor " + instantiationException0);
            return null;
        }
    }

    public Object createInstance(Object[] arr_object) {
        return this.createInstance(null, arr_object);
    }

    public abstract String getBaseClassName();

    public boolean getBooleanStaticValue(String s, boolean z) {
        Object object0 = this.getStaticValue(s);
        return object0 == null ? z : ((Boolean)object0).booleanValue();
    }

    public Class getClass(String s) {
        try {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            System.err.println(s + " Unable to load class " + classNotFoundException0);
            return null;
        }
    }

    public Class getClassType() {
        return this.mBaseClass;
    }

    public double getDoubleStaticValue(String s, double f) {
        Object object0 = this.getStaticValue(s);
        return object0 == null ? f : ((double)(((Double)object0)));
    }

    public float getFloatStaticValue(String s, float f) {
        Object object0 = this.getStaticValue(s);
        return object0 == null ? f : ((float)(((Float)object0)));
    }

    public int getIntStaticValue(String s, int v) {
        Object object0 = this.getStaticValue(s);
        return object0 == null ? v : ((int)(((Integer)object0)));
    }

    public long getLongStaticValue(String s, long v) {
        Object object0 = this.getStaticValue(s);
        return object0 == null ? v : ((long)(((Long)object0)));
    }

    public Object getNormalValue(Object object0, String s) {
        if(object0 != null && s != null && !s.isEmpty()) {
            Field field0 = this.loadFieldIfNeeded(s);
            if(field0 == null) {
                Log.d(this.getBaseClassName(), "Cannot get value : " + s);
                return null;
            }
            try {
                return field0.get(object0);
            }
            catch(IllegalAccessException illegalAccessException0) {
                System.err.println(this.getBaseClassName() + " IllegalAccessException encountered get " + s + illegalAccessException0);
                return null;
            }
        }
        x.w("Cannot get value : ", s, this.getBaseClassName());
        return null;
    }

    private Object getReflectionInstance(String s) {
        ArrayList arrayList0 = this.mNameList;
        __monitor_enter(arrayList0);
        int v = FIN.finallyOpen$NT();
        if(s == null) {
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(arrayList0);
            FIN.finallyCodeEnd$NT(v);
            return null;
        }
        int v1 = this.mNameList.size();
        for(int v2 = 0; true; ++v2) {
            if(v2 >= v1) {
                FIN.finallyExec$NT(v);
                return null;
            }
            String s1 = (String)this.mNameList.get(v2);
            int v3 = s1.length();
            if(v3 == s.length()) {
                int v4 = v3 - 1;
                char[] arr_c = s1.toCharArray();
                char[] arr_c1 = s.toCharArray();
                for(int v5 = 0; v5 < v3; ++v5) {
                    int v6 = arr_c[v5];
                    if((arr_c1[v5] & v6) != v6) {
                        break;
                    }
                    if(v5 == v4) {
                        FIN.finallyExec$NT(v);
                        return this.mReflectionList.get(v2);
                    }
                }
            }
        }
    }

    public Object getStaticValue(String s) {
        if(this.mBaseClass != null && s != null && !s.isEmpty()) {
            try {
                Field field0 = this.mBaseClass.getDeclaredField(s);
                field0.setAccessible(true);
                return field0.get(null);
            }
            catch(NoSuchFieldException unused_ex) {
                try {
                    return this.mBaseClass.getField(s).get(null);
                }
                catch(NoSuchFieldException noSuchFieldException0) {
                    System.err.println(this.getBaseClassName() + " No field " + noSuchFieldException0);
                    return null;
                }
                catch(IllegalAccessException illegalAccessException1) {
                    System.err.println(this.getBaseClassName() + " IllegalAccessException encountered get " + s + illegalAccessException1);
                    return null;
                }
            }
            catch(IllegalAccessException illegalAccessException0) {
                System.err.println(this.getBaseClassName() + " IllegalAccessException encountered get " + s + illegalAccessException0);
                return null;
            }
        }
        x.w("Cannot get static value : ", s, this.getBaseClassName());
        return null;
    }

    public String getStringStaticValue(String s, String s1) {
        Object object0 = this.getStaticValue(s);
        return object0 == null ? s1 : ((String)object0);
    }

    private String getUniqueConstructorName(Class[] arr_class) {
        String s = this.getBaseClassName();
        if(arr_class == null) {
            return s + "_EMPTY";
        }
        for(int v = 0; v < arr_class.length; ++v) {
            Class class0 = arr_class[v];
            try {
                s = s + class0.getName();
            }
            catch(NullPointerException nullPointerException0) {
                System.err.println(this.getBaseClassName() + " getUniqueConstructorName " + nullPointerException0);
            }
        }
        return s;
    }

    private String getUniqueFieldName(String s) {
        return "FIELD_" + s;
    }

    private String getUniqueMethodName(String s, Class[] arr_class) {
        if(arr_class == null) {
            return s;
        }
        StringBuilder stringBuilder0 = Y.p(s);
        for(int v = 0; v < arr_class.length; ++v) {
            Class class0 = arr_class[v];
            if(class0 != null) {
                stringBuilder0.append(class0.getName());
            }
        }
        return stringBuilder0.toString();
    }

    public Object invokeNormalMethod(Object object0, String s) {
        return this.invokeNormalMethod(object0, s, new Object[0]);
    }

    public Object invokeNormalMethod(Object object0, String s, Class[] arr_class, Object[] arr_object) {
        if(object0 != null && s != null && !s.isEmpty()) {
            if(arr_object == null) {
                arr_object = new Object[0];
            }
            Method method0 = this.loadMethodIfNeeded(s, arr_class);
            if(method0 == null) {
                Log.d(this.getBaseClassName(), "Cannot invoke there\'s no method reflection : " + s);
                return null;
            }
            try {
                return method0.invoke(object0, arr_object);
            }
            catch(IllegalAccessException illegalAccessException0) {
                System.err.println(this.getBaseClassName() + " IllegalAccessException encountered invoking " + s + illegalAccessException0);
                return null;
            }
            catch(InvocationTargetException invocationTargetException0) {
                System.err.println(this.getBaseClassName() + " InvocationTargetException encountered invoking " + s + invocationTargetException0);
                invocationTargetException0.printStackTrace();
                return null;
            }
        }
        x.w("Cannot invoke ", s, this.getBaseClassName());
        return null;
    }

    public Object invokeNormalMethod(Object object0, String s, Object[] arr_object) {
        return this.invokeNormalMethod(object0, s, null, arr_object);
    }

    public Object invokeStaticMethod(String s) {
        return this.invokeStaticMethod(s, new Object[0]);
    }

    public Object invokeStaticMethod(String s, Class[] arr_class, Object[] arr_object) {
        if(s != null && !s.isEmpty()) {
            if(arr_object == null) {
                arr_object = new Object[0];
            }
            Method method0 = this.loadMethodIfNeeded(s, arr_class);
            if(method0 == null) {
                Log.d(this.getBaseClassName(), "Cannot invoke there\'s no method reflection : " + s);
                return null;
            }
            try {
                return method0.invoke(null, arr_object);
            }
            catch(IllegalAccessException illegalAccessException0) {
                System.err.println(this.getBaseClassName() + " IllegalAccessException encountered invoking " + s + illegalAccessException0);
                return null;
            }
            catch(InvocationTargetException invocationTargetException0) {
                System.err.println(this.getBaseClassName() + " InvocationTargetException encountered invoking " + s + invocationTargetException0);
                return null;
            }
        }
        x.w("Cannot invoke ", s, this.getBaseClassName());
        return null;
    }

    public Object invokeStaticMethod(String s, Object[] arr_object) {
        return this.invokeStaticMethod(s, null, arr_object);
    }

    public Class loadClassIfNeeded(String s) {
        Class class0 = (Class)this.mClassMap.get(s);
        if(class0 == null) {
            class0 = this.getClass(s);
            if(class0 != null) {
                this.mClassMap.put(s, class0);
            }
        }
        return class0;
    }

    public Constructor loadConstructorIfNeeded(Class[] arr_class) {
        Constructor constructor0 = null;
        String s = this.getUniqueConstructorName(arr_class);
        Object object0 = this.getReflectionInstance(s);
        if(object0 != null) {
            return (Constructor)object0;
        }
        if(this.mBaseClass != null && s != null && !s.isEmpty()) {
            if(arr_class == null) {
                arr_class = new Class[0];
            }
            try {
                constructor0 = this.mBaseClass.getConstructor(arr_class);
                this.addReflectionInstance(s, constructor0);
                return constructor0;
            }
            catch(NoSuchMethodException unused_ex) {
                try {
                    constructor0 = this.mBaseClass.getDeclaredConstructor(arr_class);
                    constructor0.setAccessible(true);
                    this.addReflectionInstance(s, constructor0);
                    return constructor0;
                }
                catch(NoSuchMethodException noSuchMethodException0) {
                    System.err.println(this.getBaseClassName() + " No method " + noSuchMethodException0);
                }
            }
        }
        return constructor0;
    }

    public Field loadFieldIfNeeded(String s) {
        Field field0 = null;
        if(s != null && !s.isEmpty()) {
            String s1 = this.getUniqueFieldName(s);
            Object object0 = this.getReflectionInstance(s1);
            if(object0 != null) {
                return (Field)object0;
            }
            Class class0 = this.mBaseClass;
            if(class0 == null) {
                return null;
            }
            try {
                field0 = class0.getField(s);
                this.addReflectionInstance(s1, field0);
                return field0;
            }
            catch(NoSuchFieldException unused_ex) {
                try {
                    field0 = this.mBaseClass.getDeclaredField(s);
                    field0.setAccessible(true);
                    this.addReflectionInstance(s1, field0);
                    return field0;
                }
                catch(NoSuchFieldException noSuchFieldException0) {
                    System.err.println(this.getBaseClassName() + " No field " + noSuchFieldException0);
                }
            }
        }
        return field0;
    }

    public Method loadMethodIfNeeded(String s, Class[] arr_class) {
        String s1 = this.getUniqueMethodName(s, arr_class);
        Object object0 = this.getReflectionInstance(s1);
        if(object0 != null) {
            return (Method)object0;
        }
        if(this.mBaseClass != null && s != null && !s.isEmpty()) {
            if(arr_class == null) {
                arr_class = new Class[0];
            }
            try {
                Method method0 = this.mBaseClass.getMethod(s, arr_class);
                this.addReflectionInstance(s1, method0);
                return method0;
            }
            catch(NoSuchMethodException unused_ex) {
                try {
                    Method method1 = this.mBaseClass.getDeclaredMethod(s, arr_class);
                    method1.setAccessible(true);
                    this.addReflectionInstance(s1, method1);
                    return method1;
                }
                catch(NoSuchMethodException noSuchMethodException0) {
                    System.err.println(this.getBaseClassName() + " No method " + noSuchMethodException0);
                }
            }
        }
        return null;
    }

    public void loadReflection() {
        this.loadReflection(this.getBaseClassName());
    }

    public void loadReflection(Class class0) {
        this.mBaseClass = class0;
        if(class0 == null) {
            Log.d("AbstractBaseReflection", "There\'s no class.");
            return;
        }
        this.loadStaticFields();
    }

    public void loadReflection(String s) {
        this.loadReflection(this.getClass(s));
    }

    public void loadStaticFields() {
    }

    public void setNormalValue(Object object0, String s, Object object1) {
        if(object0 != null && s != null && !s.isEmpty()) {
            Field field0 = this.loadFieldIfNeeded(s);
            if(field0 == null) {
                Log.d(this.getBaseClassName(), "Cannot set value : " + s);
                return;
            }
            try {
                field0.set(object0, object1);
            }
            catch(IllegalAccessException illegalAccessException0) {
                System.err.println(this.getBaseClassName() + " IllegalAccessException encountered set " + s + illegalAccessException0);
            }
            return;
        }
        x.w("Cannot set value : ", s, this.getBaseClassName());
    }
}

