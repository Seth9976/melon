package com.google.android.gms.auth.api.phone;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001A\u00020\u0007H\'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/google/android/gms/auth/api/phone/IncomingCallRetrieverClient;", "Lcom/google/android/gms/common/api/HasApiKey;", "Lcom/google/android/gms/common/api/Api$ApiOptions$NoOptions;", "startIncomingCallRetriever", "Lcom/google/android/gms/tasks/Task;", "Landroid/app/PendingIntent;", "incomingCallRetrieverRequest", "Lcom/google/android/gms/auth/api/phone/IncomingCallRetrieverRequest;", "java.com.google.android.gmscore.integ.client.auth-api-phone_auth-api-phone"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface IncomingCallRetrieverClient extends HasApiKey {
    @NotNull
    Task startIncomingCallRetriever(IncomingCallRetrieverRequest arg1);
}

