package i.n.i.b.a.s.e;

import H0.b;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.q;

public class t8 extends IOException {
    public t8(long v) {
        super(b.g(v, "Download time exceeds. The maximum timeout duration is 9223372036854775807, but we have spent ", " milliseconds."));
    }

    public t8(File file0, File file1, String s) {
        StringBuilder stringBuilder0 = new StringBuilder(file0.toString());
        if(file1 != null) {
            stringBuilder0.append(" -> " + file1);
        }
        stringBuilder0.append(": " + s);
        String s1 = stringBuilder0.toString();
        q.f(s1, "toString(...)");
        super(s1);
    }
}

