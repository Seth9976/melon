package O9;

import N9.a;
import Nc.f;
import jd.M0;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public final class g {
    public final a a;
    public final CoroutineDispatcher b;
    public final f c;
    public final O9.a d;
    public final O9.a e;
    public final M0 f;
    public Job g;
    public long h;
    public int i;

    public g(a a0, f f0, O9.a a1, O9.a a2, M0 m00) {
        CoroutineDispatcher coroutineDispatcher0 = Dispatchers.getIO();
        q.g(a0, "apiConnect");
        q.g(coroutineDispatcher0, "ioDispatcher");
        super();
        this.a = a0;
        this.b = coroutineDispatcher0;
        this.c = f0;
        this.d = a1;
        this.e = a2;
        this.f = m00;
        this.h = 2000L;
    }
}

