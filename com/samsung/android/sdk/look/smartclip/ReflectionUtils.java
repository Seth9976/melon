package com.samsung.android.sdk.look.smartclip;

import java.lang.reflect.Method;

class ReflectionUtils {
    public static Class getClassByName(String s) {
        return Class.forName(s);
    }

    private static Object invokeMethod(Object object0, String s, String s1, Object[] arr_object) {
        Method method0;
        Class class0 = object0 == null ? ReflectionUtils.getClassByName(s) : object0.getClass();
        Class[] arr_class = new Class[arr_object.length];
        for(int v = 0; v < arr_object.length; ++v) {
            Object object1 = arr_object[v];
            if(object1 instanceof Integer) {
                arr_class[v] = Integer.TYPE;
            }
            else if(object1 instanceof Long) {
                arr_class[v] = Long.TYPE;
            }
            else if(object1 instanceof Short) {
                arr_class[v] = Short.TYPE;
            }
            else if(object1 instanceof Byte) {
                arr_class[v] = Byte.TYPE;
            }
            else if(object1 instanceof Character) {
                arr_class[v] = Character.TYPE;
            }
            else if(object1 instanceof Boolean) {
                arr_class[v] = Boolean.TYPE;
            }
            else if(object1 instanceof Float) {
                arr_class[v] = Float.TYPE;
            }
            else if(object1 instanceof Double) {
                arr_class[v] = Double.TYPE;
            }
            else {
                arr_class[v] = object1.getClass();
            }
        }
        try {
            method0 = class0.getMethod(s1, arr_class);
        }
        catch(NoSuchMethodException unused_ex) {
            Method[] arr_method = class0.getMethods();
            int v1 = 0;
        alab1:
            while(true) {
                if(v1 >= arr_method.length) {
                    method0 = null;
                    break;
                }
                Method method1 = arr_method[v1];
                if(s1.equals(method1.getName())) {
                    Class[] arr_class1 = method1.getParameterTypes();
                    if(arr_class1.length == arr_object.length) {
                        for(int v2 = 0; true; ++v2) {
                            if(v2 >= arr_class1.length) {
                                method0 = method1;
                                break alab1;
                            }
                            if(!arr_class1[v2].isPrimitive()) {
                                Object object2 = arr_object[v2];
                                if(object2 == null || arr_class1[v2].isInstance(object2)) {
                                    continue;
                                }
                                break;
                            }
                            else if(!arr_class1[v2].getName().equals(arr_class[v2].getName())) {
                                break;
                            }
                        }
                    }
                }
                ++v1;
            }
        }
        if(method0 == null) {
            throw new NoSuchMethodException("Could not find " + class0.getName() + "." + s1 + "() method");
        }
        return method0.invoke(object0, arr_object);
    }

    public static Object invokeMethod(Object object0, String s, Object[] arr_object) {
        return ReflectionUtils.invokeMethod(object0, null, s, arr_object);
    }

    public static Object invokeStaticMethod(String s, String s1, Object[] arr_object) {
        return ReflectionUtils.invokeMethod(null, s, s1, arr_object);
    }
}

