package com.google.android.gms.flags;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zze extends IInterface {
    boolean getBooleanFlagValue(String arg1, boolean arg2, int arg3);

    int getIntFlagValue(String arg1, int arg2, int arg3);

    long getLongFlagValue(String arg1, long arg2, int arg3);

    String getStringFlagValue(String arg1, String arg2, int arg3);

    void init(IObjectWrapper arg1);
}

