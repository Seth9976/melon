package jg;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.q;

public abstract class g {
    public static final String a;
    public static final String b;
    public static final int c;

    static {
        q.f("Linux", "System.getProperty(\"os.name\")");
        String s = "Linux" + '/' + "4.14.295-g84b42e6a786c-ab9578266";
        g.a = s + " UPnP/1.0 mmupnp/3.0.0";
        g.b = s + " UPnP/1.0 mmupnp/3.0.0";
        g.c = (int)TimeUnit.SECONDS.toMillis(30L);
    }
}

