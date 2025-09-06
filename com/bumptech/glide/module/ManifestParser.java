package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    public ManifestParser(Context context0) {
        this.context = context0;
    }

    private ApplicationInfo getOurApplicationInfo() {
        return this.context.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80);
    }

    public List parse() {
        if(Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        List list0 = new ArrayList();
        try {
            ApplicationInfo applicationInfo0 = this.getOurApplicationInfo();
            if(applicationInfo0 != null && applicationInfo0.metaData != null) {
                if(Log.isLoggable("ManifestParser", 2)) {
                    Log.v("ManifestParser", "Got app info metadata: " + applicationInfo0.metaData);
                }
                for(Object object0: applicationInfo0.metaData.keySet()) {
                    String s = (String)object0;
                    if("GlideModule".equals(applicationInfo0.metaData.get(s))) {
                        ((ArrayList)list0).add(ManifestParser.parseModule(s));
                        if(Log.isLoggable("ManifestParser", 3)) {
                            Log.d("ManifestParser", "Loaded Glide module: " + s);
                        }
                    }
                }
                if(Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Finished loading Glide modules");
                    return list0;
                }
            }
            else if(Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Got null app info metadata");
                return list0;
            }
            return list0;
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
        }
        if(Log.isLoggable("ManifestParser", 6)) {
            Log.e("ManifestParser", "Failed to parse glide modules", packageManager$NameNotFoundException0);
        }
        return list0;
    }

    private static GlideModule parseModule(String s) {
        Object object0;
        Class class0;
        try {
            class0 = Class.forName(s);
            object0 = null;
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", classNotFoundException0);
        }
        try {
            object0 = class0.getDeclaredConstructor(null).newInstance(null);
        }
        catch(InstantiationException instantiationException0) {
            ManifestParser.throwInstantiateGlideModuleException(class0, instantiationException0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            ManifestParser.throwInstantiateGlideModuleException(class0, illegalAccessException0);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            ManifestParser.throwInstantiateGlideModuleException(class0, noSuchMethodException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            ManifestParser.throwInstantiateGlideModuleException(class0, invocationTargetException0);
        }
        if(!(object0 instanceof GlideModule)) {
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + object0);
        }
        return (GlideModule)object0;
    }

    private static void throwInstantiateGlideModuleException(Class class0, Exception exception0) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + class0, exception0);
    }
}

