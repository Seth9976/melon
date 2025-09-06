package com.google.android.gms.dynamite;

import dalvik.system.PathClassLoader;

final class zzc extends PathClassLoader {
    public zzc(String s, ClassLoader classLoader0) {
        super(s, classLoader0);
    }

    @Override
    public final Class loadClass(String s, boolean z) {
        if(!s.startsWith("java.") && !s.startsWith("android.")) {
            try {
                return this.findClass(s);
            }
            catch(ClassNotFoundException unused_ex) {
            }
        }
        return super.loadClass(s, z);
    }
}

