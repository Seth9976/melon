package e7;

import h7.B;
import java.io.File;

public final class a {
    public final B a;
    public final String b;
    public final File c;

    public a(B b0, String s, File file0) {
        this.a = b0;
        if(s == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.b = s;
        this.c = file0;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this || object0 instanceof a && this.a.equals(((a)object0).a) && this.b.equals(((a)object0).b) && this.c.equals(((a)object0).c);
    }

    @Override
    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode();
    }

    @Override
    public final String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.a + ", sessionId=" + this.b + ", reportFile=" + this.c + "}";
    }
}

