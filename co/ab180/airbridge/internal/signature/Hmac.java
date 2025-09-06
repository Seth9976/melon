package co.ab180.airbridge.internal.signature;

import Tf.a;
import java.util.Formatter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\'\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000B¨\u0006\u000E"}, d2 = {"Lco/ab180/airbridge/internal/signature/Hmac;", "", "", "msg", "key", "alg", "generate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "bytes", "a", "([B)Ljava/lang/String;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class Hmac {
    @NotNull
    public static final Hmac a;

    static {
        Hmac.a = new Hmac();
    }

    private final String a(byte[] arr_b) {
        Formatter formatter0 = new Formatter();
        for(int v = 0; v < arr_b.length; ++v) {
            formatter0.format("%02x", ((byte)arr_b[v]));
        }
        return formatter0.toString();
    }

    @NotNull
    public static final String generate(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        Mac mac0 = Mac.getInstance(s2);
        mac0.init(new SecretKeySpec(s1.getBytes(a.a), s2));
        byte[] arr_b = mac0.doFinal(s.getBytes(a.a));
        return Hmac.a.a(arr_b);
    }
}

