package com.google.android.gms.common.api.internal;

abstract class zabg {
    private final zabf zaa;

    public zabg(zabf zabf0) {
        this.zaa = zabf0;
    }

    public abstract void zaa();

    public final void zab(zabi zabi0) {
        zabi.zah(zabi0).lock();
        try {
            if(zabi.zag(zabi0) == this.zaa) {
                this.zaa();
            }
        }
        finally {
            zabi.zah(zabi0).unlock();
        }
    }
}

