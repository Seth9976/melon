package l5;

import ie.H;
import java.io.IOException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import okio.Okio;
import we.n;

public final class e extends i implements n {
    public final f r;

    public e(f f0, Continuation continuation0) {
        this.r = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        f f0 = this.r;
        synchronized(f0) {
            if(f0.l && !f0.m) {
                try {
                    f0.A();
                }
                catch(IOException unused_ex) {
                    f0.n = true;
                }
                if(f0.i >= 2000) {
                    try {
                        f0.C();
                    }
                    catch(IOException unused_ex) {
                        f0.o = true;
                        f0.j = Okio.buffer(Okio.blackhole());
                    }
                }
                return H.a;
            }
            return H.a;
        }
    }
}

