package n2;

import d5.n;
import i.n.i.b.a.s.e.Ga;
import java.io.Closeable;
import java.io.FileNotFoundException;
import kb.r;
import kotlin.jvm.internal.q;
import l2.a0;
import l2.c0;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

public class c implements a0 {
    public final FileSystem a;
    public final Path b;
    public final Ga c;
    public final a d;

    public c(FileSystem fileSystem0, Path path0, Ga ga0) {
        q.g(fileSystem0, "fileSystem");
        q.g(path0, "path");
        super();
        this.a = fileSystem0;
        this.b = path0;
        this.c = ga0;
        this.d = new a();
    }

    @Override  // l2.a0
    public final Object c(r r0) {
        return c.f(this, r0);
    }

    @Override  // l2.a
    public final void close() {
        this.d.a.set(true);
    }

    public static Object f(c c0, oe.c c1) {
        Closeable closeable0;
        Throwable throwable4;
        Throwable throwable2;
        BufferedSource bufferedSource1;
        c c2;
        Object object1;
        BufferedSource bufferedSource0;
        b b0;
        if(c1 instanceof b) {
            b0 = (b)c1;
            int v = b0.E;
            if((v & 0x80000000) == 0) {
                b0 = new b(c0, c1);
            }
            else {
                b0.E = v ^ 0x80000000;
            }
        }
        else {
            b0 = new b(c0, c1);
        }
        Object object0 = b0.B;
        ne.a a0 = ne.a.a;
        Throwable throwable0 = null;
        switch(b0.E) {
            case 0: {
                n.D(object0);
                if(c0.d.a.get()) {
                    throw new IllegalStateException("This scope has already been closed.");
                }
                try {
                    bufferedSource0 = Okio.buffer(c0.a.source(c0.b));
                }
                catch(FileNotFoundException unused_ex) {
                    goto label_57;
                }
                try {
                    b0.r = c0;
                    b0.w = bufferedSource0;
                    b0.E = 1;
                    object1 = ((c0)c0.c.b).readFrom(bufferedSource0.inputStream(), b0);
                }
                catch(Throwable throwable1) {
                    c2 = c0;
                    bufferedSource1 = bufferedSource0;
                    throwable2 = throwable1;
                    goto label_38;
                }
                if(object1 == a0) {
                    return a0;
                }
                c2 = c0;
                bufferedSource1 = bufferedSource0;
                object0 = object1;
                goto label_46;
            }
            case 1: {
                bufferedSource1 = b0.w;
                c2 = (c)b0.r;
                try {
                    n.D(object0);
                    goto label_46;
                }
                catch(Throwable throwable2) {
                }
            label_38:
                if(bufferedSource1 != null) {
                    try {
                        bufferedSource1.close();
                    }
                    catch(Throwable throwable3) {
                        try {
                            e2.a.q(throwable2, throwable3);
                            throwable4 = throwable2;
                            object0 = null;
                            goto label_52;
                        }
                        catch(FileNotFoundException unused_ex) {
                            goto label_56;
                        }
                    }
                }
                throwable4 = throwable2;
                object0 = null;
                goto label_52;
            label_46:
                if(bufferedSource1 != null) {
                    try {
                        bufferedSource1.close();
                    }
                    catch(Throwable throwable4) {
                        goto label_52;
                    }
                }
                throwable4 = null;
                try {
                label_52:
                    if(throwable4 != null) {
                        throw throwable4;
                    }
                    q.d(object0);
                    return object0;
                label_56:
                    c0 = c2;
                }
                catch(FileNotFoundException unused_ex) {
                    goto label_56;
                }
            label_57:
                c0 c00 = (c0)c0.c.b;
                Path path0 = c0.b;
                if(c0.a.exists(path0)) {
                    closeable0 = Okio.buffer(c0.a.source(path0));
                    try {
                        b0.r = closeable0;
                        b0.w = null;
                        b0.E = 2;
                        object0 = c00.readFrom(((BufferedSource)closeable0).inputStream(), b0);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_80;
                    }
                    catch(Throwable throwable5) {
                        goto label_72;
                    }
                    return a0;
                }
                return c00.getDefaultValue();
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        closeable0 = (Closeable)b0.r;
        try {
            n.D(object0);
        }
        catch(Throwable throwable5) {
        label_72:
            if(closeable0 != null) {
                try {
                    closeable0.close();
                }
                catch(Throwable throwable6) {
                    e2.a.q(throwable5, throwable6);
                }
            }
            throwable0 = throwable5;
            object0 = null;
            goto label_84;
        }
    label_80:
        if(closeable0 != null) {
            try {
                closeable0.close();
            }
            catch(Throwable throwable0) {
            }
        }
    label_84:
        if(throwable0 != null) {
            throw throwable0;
        }
        q.d(object0);
        return object0;
    }
}

