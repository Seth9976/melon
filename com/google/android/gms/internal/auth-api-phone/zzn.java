package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.auth.api.phone.IncomingCallRetrieverRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import kotlin.jvm.internal.q;

public final class zzn implements RemoteCall {
    public final IncomingCallRetrieverRequest zza;

    public zzn(IncomingCallRetrieverRequest incomingCallRetrieverRequest0) {
        this.zza = incomingCallRetrieverRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        q.g(((zzae)object0), "clientImpl");
        q.g(((TaskCompletionSource)object1), "completionSource");
        zzo zzo0 = new zzo(((TaskCompletionSource)object1));
        ((zzh)((zzae)object0).getService()).zzc(zzo0, this.zza);
    }
}

