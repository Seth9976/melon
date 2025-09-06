package I7;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class l {
    public final HashSet a;
    public final Executor b;
    public final d c;
    public final d d;

    static {
        Charset.forName("UTF-8");
        Pattern.compile("^(1|true|t|yes|y|on)$", 2);
        Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    }

    public l(Executor executor0, d d0, d d1) {
        this.a = new HashSet();
        this.b = executor0;
        this.c = d0;
        this.d = d1;
    }
}

