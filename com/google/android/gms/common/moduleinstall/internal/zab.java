package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.Feature;
import java.util.Comparator;

public final class zab implements Comparator {
    public static final zab zaa;

    static {
        zab.zaa = new zab();
    }

    @Override
    public final int compare(Object object0, Object object1) {
        return ((Feature)object0).getName().equals(((Feature)object1).getName()) ? Long.compare(((Feature)object0).getVersion(), ((Feature)object1).getVersion()) : ((Feature)object0).getName().compareTo(((Feature)object1).getName());
    }
}

