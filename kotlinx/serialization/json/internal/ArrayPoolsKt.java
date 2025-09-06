package kotlinx.serialization.json.internal;

import Tf.v;
import d5.n;
import ie.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"MAX_CHARS_IN_POOL", "", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class ArrayPoolsKt {
    private static final int MAX_CHARS_IN_POOL;

    static {
        Integer integer0;
        try {
            String s = System.getProperty("kotlinx.serialization.json.pool.size");
            q.f(s, "getProperty(...)");
            integer0 = v.t0(s);
        }
        catch(Throwable throwable0) {
            integer0 = n.t(throwable0);
        }
        if(integer0 instanceof o) {
            integer0 = null;
        }
        ArrayPoolsKt.MAX_CHARS_IN_POOL = integer0 == null ? 0x200000 : ((int)integer0);
    }

    public static final int access$getMAX_CHARS_IN_POOL$p() [...] // 潜在的解密器
}

