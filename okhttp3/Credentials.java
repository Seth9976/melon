package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import va.e;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lokhttp3/Credentials;", "", "()V", "basic", "", "username", "password", "charset", "Ljava/nio/charset/Charset;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Credentials {
    @NotNull
    public static final Credentials INSTANCE;

    static {
        Credentials.INSTANCE = new Credentials();
    }

    @NotNull
    public static final String basic(@NotNull String s, @NotNull String s1) {
        q.g(s, "username");
        q.g(s1, "password");
        return Credentials.basic$default(s, s1, null, 4, null);
    }

    @NotNull
    public static final String basic(@NotNull String s, @NotNull String s1, @NotNull Charset charset0) {
        q.g(s, "username");
        q.g(s1, "password");
        q.g(charset0, "charset");
        return e.b("Basic ", ByteString.Companion.encodeString(s + ':' + s1, charset0).base64());
    }

    public static String basic$default(String s, String s1, Charset charset0, int v, Object object0) {
        if((v & 4) != 0) {
            charset0 = StandardCharsets.ISO_8859_1;
            q.f(charset0, "ISO_8859_1");
        }
        return Credentials.basic(s, s1, charset0);
    }
}

