package g3;

import java.io.IOException;

public class g extends IOException {
    public final int a;
    public static final int b;

    public g(int v) {
        this.a = v;
    }

    public g(int v, Exception exception0) {
        super(exception0);
        this.a = v;
    }

    public g(int v, Exception exception0, String s) {
        super(s, exception0);
        this.a = v;
    }
}

