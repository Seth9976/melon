package com.google.android.gms.internal.measurement;

import H0.b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzly {
    public abstract zzlq zza();

    public static zzlq zzb(Class class0) {
        zzly zzly0;
        String s;
        Class class1 = zzly.class;
        ClassLoader classLoader0 = class1.getClassLoader();
        if(class0.equals(zzlq.class)) {
            s = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
            goto label_7;
        }
        if(class0.getPackage().equals(class1.getPackage())) {
            s = b.j(class0.getPackage().getName(), ".BlazeGenerated", class0.getSimpleName(), "Loader");
            try {
            label_7:
                Class class2 = Class.forName(s, true, classLoader0);
                try {
                    zzly0 = (zzly)class2.getConstructor(null).newInstance(null);
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
                return (zzlq)class0.cast(zzly0.zza());
            }
            catch(ClassNotFoundException unused_ex) {
                Iterator iterator0 = ServiceLoader.load(class1, classLoader0).iterator();
                ArrayList arrayList0 = new ArrayList();
                while(iterator0.hasNext()) {
                    try {
                        Object object0 = iterator0.next();
                        arrayList0.add(((zzlq)class0.cast(((zzly)object0).zza())));
                    }
                    catch(ServiceConfigurationError serviceConfigurationError0) {
                        Logger.getLogger("com.google.android.gms.internal.measurement.zzll").logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load " + class0.getSimpleName(), serviceConfigurationError0);
                    }
                }
                switch(arrayList0.size()) {
                    case 0: {
                        return null;
                    }
                    case 1: {
                        return (zzlq)arrayList0.get(0);
                    }
                    default: {
                        try {
                            return (zzlq)class0.getMethod("combine", Collection.class).invoke(null, arrayList0);
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

