package com.facebook.login;

import Tf.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/login/NonceUtil;", "", "()V", "isValidNonce", "", "nonce", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class NonceUtil {
    @NotNull
    public static final NonceUtil INSTANCE;

    static {
        NonceUtil.INSTANCE = new NonceUtil();
    }

    public static final boolean isValidNonce(@Nullable String s) {
        int v = 0;
        if(s != null && s.length() != 0) {
            if(o.E0(s, ' ', 0, 6) >= 0) {
                v = 1;
            }
            return v ^ 1;
        }
        return false;
    }
}

