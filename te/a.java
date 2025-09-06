package te;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.q;

public final class a extends ByteArrayOutputStream {
    public final byte[] h() {
        byte[] arr_b = this.buf;
        q.f(arr_b, "buf");
        return arr_b;
    }
}

