package rf;

import java.io.IOException;

public final class p extends IOException {
    public a a;

    public p(String s) {
        super(s);
        this.a = null;
    }

    public final void a(j j0) {
        this.a = j0;
    }

    public static p b() {
        return new p("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }
}

