package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

@KeepForSdk
public final class ListenerHolder {
    @KeepForSdk
    public static final class ListenerKey {
        private final Object zaa;
        private final String zab;

        @KeepForSdk
        public ListenerKey(Object object0, String s) {
            this.zaa = object0;
            this.zab = s;
        }

        @Override
        @KeepForSdk
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof ListenerKey ? this.zaa == ((ListenerKey)object0).zaa && this.zab.equals(((ListenerKey)object0).zab) : false;
        }

        @Override
        @KeepForSdk
        public int hashCode() {
            return this.zab.hashCode() + System.identityHashCode(this.zaa) * 0x1F;
        }

        @KeepForSdk
        public String toIdString() {
            return this.zab + "@" + System.identityHashCode(this.zaa);
        }
    }

    @KeepForSdk
    public interface Notifier {
        @KeepForSdk
        void notifyListener(Object arg1);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    private final Executor zaa;
    private volatile Object zab;
    private volatile ListenerKey zac;

    @KeepForSdk
    public ListenerHolder(Looper looper0, Object object0, String s) {
        this.zaa = new HandlerExecutor(looper0);
        this.zab = Preconditions.checkNotNull(object0, "Listener must not be null");
        this.zac = new ListenerKey(object0, Preconditions.checkNotEmpty(s));
    }

    @KeepForSdk
    public ListenerHolder(Executor executor0, Object object0, String s) {
        this.zaa = (Executor)Preconditions.checkNotNull(executor0, "Executor must not be null");
        this.zab = Preconditions.checkNotNull(object0, "Listener must not be null");
        this.zac = new ListenerKey(object0, Preconditions.checkNotEmpty(s));
    }

    @KeepForSdk
    public void clear() {
        this.zab = null;
        this.zac = null;
    }

    @KeepForSdk
    public ListenerKey getListenerKey() {
        return this.zac;
    }

    @KeepForSdk
    public boolean hasListener() {
        return this.zab != null;
    }

    @KeepForSdk
    public void notifyListener(Notifier listenerHolder$Notifier0) {
        Preconditions.checkNotNull(listenerHolder$Notifier0, "Notifier must not be null");
        zacb zacb0 = new zacb(this, listenerHolder$Notifier0);
        this.zaa.execute(zacb0);
    }

    public final void zaa(Notifier listenerHolder$Notifier0) {
        Object object0 = this.zab;
        if(object0 == null) {
            listenerHolder$Notifier0.onNotifyListenerFailed();
            return;
        }
        try {
            listenerHolder$Notifier0.notifyListener(object0);
        }
        catch(RuntimeException runtimeException0) {
            listenerHolder$Notifier0.onNotifyListenerFailed();
            throw runtimeException0;
        }
    }
}

