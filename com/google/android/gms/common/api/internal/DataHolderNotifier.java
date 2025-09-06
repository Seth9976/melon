package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
public abstract class DataHolderNotifier implements Notifier {
    private final DataHolder zaa;

    @KeepForSdk
    public DataHolderNotifier(DataHolder dataHolder0) {
        this.zaa = dataHolder0;
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    @KeepForSdk
    public final void notifyListener(Object object0) {
        this.notifyListener(object0, this.zaa);
    }

    @KeepForSdk
    public abstract void notifyListener(Object arg1, DataHolder arg2);

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    @KeepForSdk
    public void onNotifyListenerFailed() {
        DataHolder dataHolder0 = this.zaa;
        if(dataHolder0 != null) {
            dataHolder0.close();
        }
    }
}

