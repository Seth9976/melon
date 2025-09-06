package f9;

import com.iloen.melon.custom.S0;
import com.iloen.melon.mcache.error.ParseError.NeedParse;
import com.iloen.melon.mcache.error.StreamIOError.OpenError;
import h9.d;
import h9.f;
import ie.H;
import java.io.File;
import java.io.FileInputStream;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class b extends i implements n {
    public final c r;

    public b(c c0, Continuation continuation0) {
        this.r = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((b)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        t t0 = this.r.g;
        if(t0 != null) {
            try {
                f9.n n0 = t0.e;
                if(n0.F()) {
                    throw new NeedParse("ClientRequest", "localPath() - Please parsing.");
                }
                String s = n0.g;
                long v = n0.n;
                S0 s00 = f.b;
                s00.k0("Connection (Frontend Local Source): " + s);
                File file0 = new File(s);
                if(!file0.exists()) {
                    throw new OpenError("ServerResponse", s + " is not exist.");
                }
                o o0 = new o(n0.A(), v, new FileInputStream(file0));
                if(o0.available() > 0) {
                    d d0 = new d();
                    t0.f = d0;
                    d0.c = (long)o0.available();
                }
                f.b("ServerResponse", "Finish to response cache.[filePath: " + s + "] - " + ("isSuccess: " + (o0.available() > 0)));
                s00.k0("Connection (Frontend Response): Local Complete");
                o0.skip(v);
                t0.j(o0, null);
                return H.a;
            }
            catch(Exception exception0) {
            }
            f.d("ServerResponse", "loadLocalContents() - " + exception0.toString());
            return H.a;
        }
        q.m("serverResponse");
        throw null;
    }
}

