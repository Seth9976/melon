package co.ab180.airbridge.internal.e0;

import Tf.a;
import co.ab180.airbridge.internal.b;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000E\n\u0002\b\u0004\u001A\u001D\u0010\u0002\u001A\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0001\u001A\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "algorithm", "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class f0 {
    @NotNull
    public static final String a(@NotNull String s, @NotNull String s1) {
        if(s.length() == 0) {
            return "";
        }
        try {
            MessageDigest messageDigest0 = MessageDigest.getInstance(s1);
            messageDigest0.update(s.getBytes(a.a));
            return i.a(messageDigest0.digest());
        }
        catch(NoSuchAlgorithmException | InvalidKeyException noSuchAlgorithmException0) {
            b.e.f(noSuchAlgorithmException0);
            return "";
        }
    }

    public static String a(String s, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s1 = "SHA-256";
        }
        return f0.a(s, s1);
    }
}

