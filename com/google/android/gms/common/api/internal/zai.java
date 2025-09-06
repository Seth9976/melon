package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class zai {
    public final int zac;

    public zai(int v) {
        this.zac = v;
    }

    public abstract void zad(Status arg1);

    public abstract void zae(Exception arg1);

    public abstract void zaf(zabq arg1);

    public abstract void zag(zaad arg1, boolean arg2);

    public static Status zah(RemoteException remoteException0) {
        return new Status(19, remoteException0.getClass().getSimpleName() + ": " + remoteException0.getLocalizedMessage());
    }
}

