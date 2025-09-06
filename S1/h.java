package S1;

import R1.d;
import R1.e;
import Z1.i;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface.Builder;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import d5.f;
import h7.u0;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class h extends f {
    public final Class f;
    public final Constructor g;
    public final Method h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;
    public static Class m = null;
    public static Constructor n = null;
    public static Method o = null;
    public static Method p = null;
    public static boolean q = false;

    public h() {
        Method method4;
        Method method3;
        Method method2;
        Method method1;
        Method method0;
        Constructor constructor0;
        Class class0 = null;
        try {
            Class class1 = Class.forName("android.graphics.FontFamily");
            constructor0 = class1.getConstructor(null);
            method0 = h.e0(class1);
            method1 = class1.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
            method2 = class1.getMethod("freeze", null);
            method3 = class1.getMethod("abortCreation", null);
            method4 = this.f0(class1);
            class0 = class1;
        }
        catch(ClassNotFoundException | NoSuchMethodException classNotFoundException0) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + classNotFoundException0.getClass().getName(), classNotFoundException0);
            method4 = null;
            constructor0 = null;
            method0 = null;
            method1 = null;
            method2 = null;
            method3 = null;
        }
        this.f = class0;
        this.g = constructor0;
        this.h = method0;
        this.i = method1;
        this.j = method2;
        this.k = method3;
        this.l = method4;
    }

    public final boolean Z(Context context0, Object object0, String s, int v, int v1, int v2, FontVariationAxis[] arr_fontVariationAxis) {
        try {
            Object[] arr_object = {context0.getAssets(), s, 0, Boolean.FALSE, v, v1, v2, arr_fontVariationAxis};
            return ((Boolean)this.h.invoke(object0, arr_object)).booleanValue();
        }
        catch(IllegalAccessException | InvocationTargetException unused_ex) {
            return false;
        }
    }

    public static boolean a0(int v, Object object0, String s, boolean z) {
        h.d0();
        try {
            return ((Boolean)h.o.invoke(object0, s, v, Boolean.valueOf(z))).booleanValue();
        }
        catch(IllegalAccessException | InvocationTargetException exception0) {
            throw new RuntimeException(exception0);
        }
    }

    public Typeface b0(Object object0) {
        try {
            Object object1 = Array.newInstance(this.f, 1);
            Array.set(object1, 0, object0);
            return (Typeface)this.l.invoke(null, object1, -1, -1);
        }
        catch(IllegalAccessException | InvocationTargetException unused_ex) {
            return null;
        }
    }

    public final boolean c0(Object object0) {
        try {
            return ((Boolean)this.j.invoke(object0, null)).booleanValue();
        }
        catch(IllegalAccessException | InvocationTargetException unused_ex) {
            return false;
        }
    }

    public static void d0() {
        Method method1;
        Method method0;
        Class class0;
        Constructor constructor0;
        if(h.q) {
            return;
        }
        try {
            h.q = true;
            constructor0 = null;
            class0 = Class.forName("android.graphics.FontFamily");
            Constructor constructor1 = class0.getConstructor(null);
            method0 = class0.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            Class[] arr_class = {Array.newInstance(class0, 1).getClass()};
            method1 = Typeface.class.getMethod("createFromFamiliesWithDefault", arr_class);
            constructor0 = constructor1;
        }
        catch(ClassNotFoundException | NoSuchMethodException classNotFoundException0) {
            Log.e("TypefaceCompatApi21Impl", classNotFoundException0.getClass().getName(), classNotFoundException0);
            method1 = null;
            class0 = null;
            method0 = null;
        }
        h.n = constructor0;
        h.m = class0;
        h.o = method0;
        h.p = method1;
    }

    public static Method e0(Class class0) {
        return class0.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    public Method f0(Class class0) {
        Class[] arr_class = {Array.newInstance(class0, 1).getClass(), Integer.TYPE, Integer.TYPE};
        Method method0 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arr_class);
        method0.setAccessible(true);
        return method0;
    }

    @Override  // d5.f
    public final Typeface o(Context context0, d d0, Resources resources0, int v) {
        int v2;
        e[] arr_e1;
        Object object1;
        Object object0;
        Method method0 = this.h;
        if(method0 == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if(method0 != null) {
            try {
                object0 = this.g.newInstance(null);
            }
            catch(IllegalAccessException | InstantiationException | InvocationTargetException unused_ex) {
                object0 = null;
            }
            if(object0 != null) {
                e[] arr_e = d0.a;
                for(int v1 = 0; v1 < arr_e.length; ++v1) {
                    e e0 = arr_e[v1];
                    FontVariationAxis[] arr_fontVariationAxis = FontVariationAxis.fromFontVariationSettings(e0.d);
                    if(!this.Z(context0, object0, e0.a, e0.e, e0.b, ((int)e0.c), arr_fontVariationAxis)) {
                        try {
                            this.k.invoke(object0, null);
                        }
                        catch(IllegalAccessException | InvocationTargetException unused_ex) {
                        }
                        return null;
                    }
                }
                return this.c0(object0) ? this.b0(object0) : null;
            }
            return null;
        }
        h.d0();
        try {
            object1 = h.n.newInstance(null);
            arr_e1 = d0.a;
            v2 = 0;
        }
        catch(IllegalAccessException | InstantiationException | InvocationTargetException illegalAccessException0) {
            throw new RuntimeException(illegalAccessException0);
        }
        while(v2 < arr_e1.length) {
            e e1 = arr_e1[v2];
            File file0 = u0.E(context0);
            if(file0 != null) {
                try {
                    if(u0.q(file0, resources0, e1.f)) {
                        String s = file0.getPath();
                        if(!h.a0(e1.b, object1, s, e1.c)) {
                            return null;
                        }
                        ++v2;
                        continue;
                    }
                    return null;
                }
                catch(RuntimeException unused_ex) {
                    return null;
                }
                finally {
                    file0.delete();
                }
                ++v2;
                continue;
            }
            return null;
        }
        h.d0();
        try {
            Object object2 = Array.newInstance(h.m, 1);
            Array.set(object2, 0, object1);
            return (Typeface)h.p.invoke(null, object2);
        }
        catch(IllegalAccessException | InvocationTargetException illegalAccessException1) {
            throw new RuntimeException(illegalAccessException1);
        }
    }

    @Override  // d5.f
    public final Typeface p(Context context0, i[] arr_i, int v) {
        boolean z1;
        Object object0;
        if(arr_i.length >= 1) {
            Method method0 = this.h;
            if(method0 == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            if(method0 == null) {
                i i2 = this.x(arr_i, v);
                ContentResolver contentResolver0 = context0.getContentResolver();
                try(ParcelFileDescriptor parcelFileDescriptor0 = contentResolver0.openFileDescriptor(i2.a, "r", null)) {
                    return parcelFileDescriptor0 != null ? new Typeface.Builder(parcelFileDescriptor0.getFileDescriptor()).setWeight(i2.c).setItalic(i2.d).build() : null;
                }
                catch(IOException unused_ex) {
                }
            }
            else {
                HashMap hashMap0 = new HashMap();
                for(int v1 = 0; v1 < arr_i.length; ++v1) {
                    i i0 = arr_i[v1];
                    if(i0.e == 0) {
                        Uri uri0 = i0.a;
                        if(!hashMap0.containsKey(uri0)) {
                            hashMap0.put(uri0, u0.M(context0, uri0));
                        }
                    }
                }
                Map map0 = Collections.unmodifiableMap(hashMap0);
                try {
                    object0 = this.g.newInstance(null);
                }
                catch(IllegalAccessException | InstantiationException | InvocationTargetException unused_ex) {
                    object0 = null;
                }
                if(object0 != null) {
                    int v2 = 0;
                    boolean z = false;
                    while(true) {
                        Method method1 = this.k;
                        if(v2 >= arr_i.length) {
                            goto label_36;
                        }
                        i i1 = arr_i[v2];
                        ByteBuffer byteBuffer0 = (ByteBuffer)map0.get(i1.a);
                        if(byteBuffer0 != null) {
                            try {
                                z1 = ((Boolean)this.i.invoke(object0, byteBuffer0, i1.b, 0, i1.c, ((int)i1.d))).booleanValue();
                            }
                            catch(IllegalAccessException | InvocationTargetException unused_ex) {
                                z1 = false;
                            }
                            try {
                                if(!z1) {
                                    method1.invoke(object0, null);
                                    return null;
                                }
                                z = true;
                                ++v2;
                                continue;
                            label_36:
                                if(!z) {
                                    method1.invoke(object0, null);
                                    return null;
                                }
                                break;
                            }
                            catch(IllegalAccessException | InvocationTargetException unused_ex) {
                                return null;
                            }
                        }
                        ++v2;
                    }
                    if(this.c0(object0)) {
                        Typeface typeface0 = this.b0(object0);
                        return typeface0 == null ? null : Typeface.create(typeface0, v);
                    }
                }
            }
        }
        return null;
    }

    @Override  // d5.f
    public final Typeface r(Context context0, Resources resources0, int v, String s, int v1) {
        Object object0;
        Method method0 = this.h;
        if(method0 == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if(method0 != null) {
            try {
                object0 = this.g.newInstance(null);
            }
            catch(IllegalAccessException | InstantiationException | InvocationTargetException unused_ex) {
                object0 = null;
            }
            if(object0 != null) {
                if(!this.Z(context0, object0, s, 0, -1, -1, null)) {
                    try {
                        this.k.invoke(object0, null);
                    }
                    catch(IllegalAccessException | InvocationTargetException unused_ex) {
                    }
                    return null;
                }
                return this.c0(object0) ? this.b0(object0) : null;
            }
            return null;
        }
        return super.r(context0, resources0, v, s, v1);
    }
}

