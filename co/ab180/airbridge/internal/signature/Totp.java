package co.ab180.airbridge.internal.signature;

import java.lang.reflect.UndeclaredThrowableException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\n\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000BJ\'\u0010\u000F\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u000F\u0010\u0013¨\u0006\u0016"}, d2 = {"Lco/ab180/airbridge/internal/signature/Totp;", "", "", "secretKey", "", "timestamp", "", "codeLength", "timePeriod", "algorithm", "generate", "(Ljava/lang/String;JIILjava/lang/String;)Ljava/lang/String;", "", "secret", "payload", "a", "([B[BLjava/lang/String;)[B", "hash", "offset", "([BI)[B", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class Totp {
    @NotNull
    public static final Totp a;

    static {
        Totp.a = new Totp();
    }

    private final byte[] a(byte[] arr_b, int v) {
        byte[] arr_b1 = new byte[4];
        for(int v1 = 0; v1 <= 3; ++v1) {
            arr_b1[v1] = arr_b[v + v1];
        }
        arr_b1[0] = (byte)(arr_b1[0] & 0x7F);
        return arr_b1;
    }

    private final byte[] a(byte[] arr_b, byte[] arr_b1, String s) {
        try {
            Mac mac0 = Mac.getInstance(s);
            mac0.init(new SecretKeySpec(arr_b, s));
            return mac0.doFinal(arr_b1);
        }
        catch(GeneralSecurityException generalSecurityException0) {
            throw new UndeclaredThrowableException(generalSecurityException0);
        }
    }

    @NotNull
    public static final String generate(@NotNull String s, long v, int v1, int v2, @NotNull String s1) {
        byte[] arr_b = d.b(s);
        byte[] arr_b1 = d.a(v / 1000L / ((long)v2), 8);
        byte[] arr_b2 = Totp.a.a(arr_b, arr_b1, s1);
        return d.a(String.valueOf(((int)(((double)ByteBuffer.wrap(Totp.a.a(arr_b2, ((int)(((byte)(arr_b2[arr_b2.length - 1] & 15)))))).getInt()) % Math.pow(10.0, v1)))), v1);
    }
}

