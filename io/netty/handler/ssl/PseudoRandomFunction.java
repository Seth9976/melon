package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

final class PseudoRandomFunction {
    private static byte[] concat(byte[] arr_b, byte[] arr_b1) {
        byte[] arr_b2 = Arrays.copyOf(arr_b, arr_b.length + arr_b1.length);
        System.arraycopy(arr_b1, 0, arr_b2, arr_b.length, arr_b1.length);
        return arr_b2;
    }

    public static byte[] hash(byte[] arr_b, byte[] arr_b1, byte[] arr_b2, int v, String s) {
        ObjectUtil.checkPositiveOrZero(v, "length");
        try {
            Mac mac0 = Mac.getInstance(s);
            mac0.init(new SecretKeySpec(arr_b, s));
            int v1 = (int)Math.ceil(((double)v) / ((double)mac0.getMacLength()));
            byte[] arr_b3 = EmptyArrays.EMPTY_BYTES;
            byte[] arr_b4 = PseudoRandomFunction.concat(arr_b1, arr_b2);
            byte[] arr_b5 = arr_b4;
            for(int v2 = 0; v2 < v1; ++v2) {
                arr_b5 = mac0.doFinal(arr_b5);
                arr_b3 = PseudoRandomFunction.concat(arr_b3, mac0.doFinal(PseudoRandomFunction.concat(arr_b5, arr_b4)));
            }
            return Arrays.copyOf(arr_b3, v);
        }
        catch(GeneralSecurityException generalSecurityException0) {
        }
        throw new IllegalArgumentException("Could not find algo: " + s, generalSecurityException0);
    }
}

