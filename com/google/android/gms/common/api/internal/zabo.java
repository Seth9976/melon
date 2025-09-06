package com.google.android.gms.common.api.internal;

final class zabo implements Runnable {
    final zabp zaa;

    public zabo(zabp zabp0) {
        this.zaa = zabp0;
        super();
    }

    @Override
    public final void run() {
        String s = zabq.zae(this.zaa.zaa).getClass().getName() + " disconnecting because it was signed out.";
        zabq.zae(this.zaa.zaa).disconnect(s);
    }
}

