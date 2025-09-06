package com.kakao.sdk.auth;

import com.kakao.sdk.common.util.SdkLog;
import kotlin.Metadata;
import we.a;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A&\u0010\u0003\u001A\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0082\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Lkotlin/Function0;", "f", "parseOrNull", "(Lwe/a;)Ljava/lang/Object;", "auth_release"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class TokenManagerKt {
    private static final Object parseOrNull(a a0) {
        try {
            return a0.invoke();
        }
        catch(Exception exception0) {
            SdkLog.Companion.e(exception0);
            return null;
        }
    }
}

