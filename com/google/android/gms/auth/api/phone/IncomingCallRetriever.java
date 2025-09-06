package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.auth-api-phone.zzp;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0007J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/google/android/gms/auth/api/phone/IncomingCallRetriever;", "", "<init>", "()V", "PHONE_VERIFICATION_STATUS_INTENT_ACTION", "", "PHONE_VERIFICATION_STATUS_INTENT_EXTRA", "SEND_PERMISSION", "ACTIVITY_RESULT_INTENT_EXTRA_MESSAGE", "ACTIVITY_RESULT_INTENT_EXTRA_STATUS_CODE", "getClient", "Lcom/google/android/gms/auth/api/phone/IncomingCallRetrieverClient;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "java.com.google.android.gmscore.integ.client.auth-api-phone_auth-api-phone"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class IncomingCallRetriever {
    @NotNull
    public static final String ACTIVITY_RESULT_INTENT_EXTRA_MESSAGE = "MESSAGE";
    @NotNull
    public static final String ACTIVITY_RESULT_INTENT_EXTRA_STATUS_CODE = "STATUS_CODE";
    @NotNull
    public static final IncomingCallRetriever INSTANCE = null;
    @NotNull
    public static final String PHONE_VERIFICATION_STATUS_INTENT_ACTION = "com.google.android.gms.auth.api.phone.PHONE_VERIFICATION_STATUS_INTENT_ACTION";
    @NotNull
    public static final String PHONE_VERIFICATION_STATUS_INTENT_EXTRA = "PHONE_VERIFICATION_STATUS_INTENT_EXTRA";
    @NotNull
    public static final String SEND_PERMISSION = "com.google.android.gms.auth.api.phone.permission.SEND";

    static {
        IncomingCallRetriever.INSTANCE = new IncomingCallRetriever();
    }

    @NotNull
    public static final IncomingCallRetrieverClient getClient(Activity activity0) {
        q.g(activity0, "activity");
        return new zzp(activity0);
    }

    @NotNull
    public static final IncomingCallRetrieverClient getClient(Context context0) {
        q.g(context0, "context");
        return new zzp(context0);
    }
}

