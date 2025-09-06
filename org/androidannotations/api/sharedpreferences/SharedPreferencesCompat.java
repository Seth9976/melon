package org.androidannotations.api.sharedpreferences;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public abstract class SharedPreferencesCompat {
    private static final Method APPLY_METHOD;
    private static final Method GET_STRING_SET_METHOD;
    private static final Method PUT_STRING_SET_METHOD;

    static {
        SharedPreferencesCompat.APPLY_METHOD = SharedPreferencesCompat.findMethod(SharedPreferences.Editor.class, "apply", new Class[0]);
        SharedPreferencesCompat.GET_STRING_SET_METHOD = SharedPreferencesCompat.findMethod(SharedPreferences.class, "getStringSet", new Class[]{String.class, Set.class});
        SharedPreferencesCompat.PUT_STRING_SET_METHOD = SharedPreferencesCompat.findMethod(SharedPreferences.Editor.class, "putStringSet", new Class[]{String.class, Set.class});
    }

    public static void apply(SharedPreferences.Editor sharedPreferences$Editor0) {
        try {
            SharedPreferencesCompat.invoke(SharedPreferencesCompat.APPLY_METHOD, sharedPreferences$Editor0, new Object[0]);
        }
        catch(NoSuchMethodException unused_ex) {
            sharedPreferences$Editor0.commit();
        }
    }

    private static Method findMethod(Class class0, String s, Class[] arr_class) {
        try {
            return class0.getMethod(s, arr_class);
        }
        catch(NoSuchMethodException unused_ex) {
            return null;
        }
    }

    public static Set getStringSet(SharedPreferences sharedPreferences0, String s, Set set0) {
        try {
            return (Set)SharedPreferencesCompat.invoke(SharedPreferencesCompat.GET_STRING_SET_METHOD, sharedPreferences0, new Object[]{s, set0});
        }
        catch(NoSuchMethodException unused_ex) {
            String s1 = sharedPreferences0.getString(s, null);
            return s1 == null ? set0 : SetXmlSerializer.deserialize(s1);
        }
    }

    public static Object invoke(Method method0, Object object0, Object[] arr_object) {
        if(method0 != null) {
            try {
                return method0.invoke(object0, arr_object);
            }
            catch(IllegalAccessException | InvocationTargetException | IllegalArgumentException unused_ex) {
                throw new NoSuchMethodException(method0.getName());
            }
        }
        throw new NoSuchMethodException();
    }

    public static void putStringSet(SharedPreferences.Editor sharedPreferences$Editor0, String s, Set set0) {
        try {
            SharedPreferencesCompat.invoke(SharedPreferencesCompat.PUT_STRING_SET_METHOD, sharedPreferences$Editor0, new Object[]{s, set0});
        }
        catch(NoSuchMethodException unused_ex) {
            sharedPreferences$Editor0.putString(s, SetXmlSerializer.serialize(set0));
        }
    }
}

