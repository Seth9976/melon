package com.google.android.gms.auth.api.phone;

import com.google.android.gms.common.api.CommonStatusCodes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/google/android/gms/auth/api/phone/IncomingCallRetrieverStatusCodes;", "Lcom/google/android/gms/common/api/CommonStatusCodes;", "<init>", "()V", "CONCURRENT_REQUESTS", "", "IN_EMERGENCY_CALL", "API_UNAVAILABLE", "RATE_LIMIT_REACHED", "TELEPHONY_FEATURE_UNAVAILABLE", "INVALID_PHONE_NUMBER_RANGE", "USER_CONSENT_DENIED", "FAILURE_OTHER", "getVerificationStatusCodeString", "", "statusCode", "java.com.google.android.gmscore.integ.client.auth-api-phone_auth-api-phone"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class IncomingCallRetrieverStatusCodes extends CommonStatusCodes {
    public static final int API_UNAVAILABLE = 0xCF0B;
    public static final int CONCURRENT_REQUESTS = 0xCF09;
    public static final int FAILURE_OTHER = 0xCF10;
    @NotNull
    public static final IncomingCallRetrieverStatusCodes INSTANCE = null;
    public static final int INVALID_PHONE_NUMBER_RANGE = 0xCF0E;
    public static final int IN_EMERGENCY_CALL = 0xCF0A;
    public static final int RATE_LIMIT_REACHED = 0xCF0C;
    public static final int TELEPHONY_FEATURE_UNAVAILABLE = 0xCF0D;
    public static final int USER_CONSENT_DENIED = 0xCF0F;

    static {
        IncomingCallRetrieverStatusCodes.INSTANCE = new IncomingCallRetrieverStatusCodes();
    }

    @NotNull
    public final String getVerificationStatusCodeString(int v) [...] // 潜在的解密器
}

