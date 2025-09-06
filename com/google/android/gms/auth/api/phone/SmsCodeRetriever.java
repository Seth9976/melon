package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.auth-api-phone.zzad;
import com.google.android.gms.internal.auth-api-phone.zzz;

public final class SmsCodeRetriever {
    public static final String EXTRA_SMS_CODE = "com.google.android.gms.auth.api.phone.EXTRA_SMS_CODE";
    public static final String EXTRA_SMS_CODE_LINE = "com.google.android.gms.auth.api.phone.EXTRA_SMS_CODE_LINE";
    public static final String EXTRA_STATUS = "com.google.android.gms.auth.api.phone.EXTRA_STATUS";
    public static final String SMS_CODE_RETRIEVED_ACTION = "com.google.android.gms.auth.api.phone.SMS_CODE_RETRIEVED";

    public static SmsCodeAutofillClient getAutofillClient(Activity activity0) {
        return new zzz(activity0);
    }

    public static SmsCodeAutofillClient getAutofillClient(Context context0) {
        return new zzz(context0);
    }

    public static SmsCodeBrowserClient getBrowserClient(Activity activity0) {
        return new zzad(activity0);
    }

    public static SmsCodeBrowserClient getBrowserClient(Context context0) {
        return new zzad(context0);
    }
}

