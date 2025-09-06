package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.I;

final class zae extends zag {
    final Intent zaa;
    final I zab;
    final int zac;

    public zae(Intent intent0, I i0, int v) {
        this.zaa = intent0;
        this.zab = i0;
        this.zac = v;
        super();
    }

    @Override  // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent0 = this.zaa;
        if(intent0 != null) {
            this.zab.startActivityForResult(intent0, this.zac);
        }
    }
}

