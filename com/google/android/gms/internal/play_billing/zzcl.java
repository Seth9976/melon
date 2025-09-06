package com.google.android.gms.internal.play_billing;

import H0.b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzcl {
    public abstract zzcd zza();

    public static zzcd zzb(Class class0) {
        zzcl zzcl0;
        String s;
        Class class1 = zzcl.class;
        ClassLoader classLoader0 = class1.getClassLoader();
        if(class0.equals(zzcd.class)) {
            s = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
            goto label_7;
        }
        if(class0.getPackage().equals(class1.getPackage())) {
            s = b.j(class0.getPackage().getName(), ".BlazeGenerated", class0.getSimpleName(), "Loader");
            try {
            label_7:
                Class class2 = Class.forName(s, true, classLoader0);
                try {
                    zzcl0 = (zzcl)class2.getConstructor(null).newInstance(null);
                }
                catch(NoSuchMethodException noSuchMethodException0) {
                    throw new IllegalStateException(noSuchMethodException0);
                }
                catch(InstantiationException instantiationException0) {
                    throw new IllegalStateException(instantiationException0);
                }
                catch(IllegalAccessException illegalAccessException0) {
                    throw new IllegalStateException(illegalAccessException0);
                }
                catch(InvocationTargetException invocationTargetException0) {
                    throw new IllegalStateException(invocationTargetException0);
                }
                return (zzcd)class0.cast(zzcl0.zza());
            }
            catch(ClassNotFoundException unused_ex) {
                Iterator iterator0 = ServiceLoader.load(class1, classLoader0).iterator();
                ArrayList arrayList0 = new ArrayList();
                while(iterator0.hasNext()) {
                    try {
                        Object object0 = iterator0.next();
                        arrayList0.add(((zzcd)class0.cast(((zzcl)object0).zza())));
                    }
                    catch(ServiceConfigurationError serviceConfigurationError0) {
                        Logger.getLogger("com.google.android.gms.internal.play_billing.zzby").logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load " + class0.getSimpleName(), serviceConfigurationError0);
                    }
                }
                switch(arrayList0.size()) {
                    case 0: {
                        return null;
                    }
                    case 1: {
                        return (zzcd)arrayList0.get(0);
                    }
                    default: {
                        try {
                            return (zzcd)class0.getMethod("combine", Collection.class).invoke(null, arrayList0);
                        }
                        catch(NoSuchMethodException noSuchMethodException1) {
                            throw new IllegalStateException(noSuchMethodException1);
                        }
                        catch(IllegalAccessException illegalAccessException1) {
                            throw new IllegalStateException(illegalAccessException1);
                        }
                        catch(InvocationTargetException invocationTargetException1) {
                            throw new IllegalStateException(invocationTargetException1);
                        }
                    }
                }
            }
        }
        throw new IllegalArgumentException(class0.getName());
    }
}

