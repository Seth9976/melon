package n2;

import d5.n;
import i.n.i.b.a.s.e.Ga;
import ie.H;
import java.io.IOException;
import kb.r;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.sync.Mutex.DefaultImpls;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import l2.L;
import l2.i0;
import l2.l0;
import oe.c;
import okio.FileSystem;
import okio.Path;

public final class i implements l0 {
    public final FileSystem a;
    public final Path b;
    public final Ga c;
    public final i0 d;
    public final e e;
    public final a f;
    public final Mutex g;

    public i(FileSystem fileSystem0, Path path0, Ga ga0, i0 i00, e e0) {
        q.g(fileSystem0, "fileSystem");
        q.g(path0, "path");
        q.g(i00, "coordinator");
        super();
        this.a = fileSystem0;
        this.b = path0;
        this.c = ga0;
        this.d = i00;
        this.e = e0;
        this.f = new a();
        this.g = MutexKt.Mutex$default(false, 1, null);
    }

    @Override  // l2.l0
    public final Object a(L l0, c c0) {
        l2.a a1;
        Throwable throwable2;
        Mutex mutex2;
        i i1;
        Path path2;
        k k0;
        Path path1;
        i i0;
        Mutex mutex0;
        Path path0;
        h h0;
        if(c0 instanceof h) {
            h0 = (h)c0;
            int v = h0.I;
            if((v & 0x80000000) == 0) {
                h0 = new h(this, c0);
            }
            else {
                h0.I = v ^ 0x80000000;
            }
        }
        else {
            h0 = new h(this, c0);
        }
        Object object0 = h0.E;
        ne.a a0 = ne.a.a;
        switch(h0.I) {
            case 0: {
                n.D(object0);
                if(this.f.a.get()) {
                    throw new IllegalStateException("StorageConnection has already been disposed.");
                }
                path0 = this.b.parent();
                if(path0 == null) {
                    throw new IllegalStateException("must have a parent path");
                }
                this.a.createDirectories(path0, false);
                h0.r = this;
                h0.w = l0;
                h0.B = path0;
                mutex0 = this.g;
                h0.D = mutex0;
                h0.I = 1;
                if(mutex0.lock(null, h0) != a0) {
                    i0 = this;
                    goto label_37;
                }
                return a0;
            }
            case 1: {
                Mutex mutex1 = (Mutex)h0.D;
                path0 = h0.B;
                we.n n0 = (we.n)h0.w;
                i0 = h0.r;
                n.D(object0);
                mutex0 = mutex1;
                l0 = n0;
                try {
                label_37:
                    path1 = path0.resolve(i0.b.name() + ".tmp");
                    try {
                        i0.a.delete(path1, false);
                        q.g(path1, "path");
                        k0 = new k(i0.a, path1, i0.c);  // 初始化器: Ln2/c;-><init>(Lokio/FileSystem;Lokio/Path;Li/n/i/b/a/s/e/Ga;)V
                        goto label_44;
                    }
                    catch(IOException iOException0) {
                    }
                }
                catch(Throwable throwable0) {
                    mutex0.unlock(null);
                    throw throwable0;
                }
                goto label_89;
                try {
                label_44:
                    h0.r = i0;
                    h0.w = mutex0;
                    h0.B = path1;
                    h0.D = k0;
                    h0.I = 2;
                    if(l0.invoke(k0, h0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable1) {
                    path2 = path1;
                    i1 = i0;
                    mutex2 = mutex0;
                    throwable2 = throwable1;
                    a1 = k0;
                    goto label_71;
                }
                path2 = path1;
                a1 = k0;
                i1 = i0;
                mutex2 = mutex0;
                break;
            }
            case 2: {
                a1 = (l2.a)h0.D;
                path2 = h0.B;
                mutex2 = (Mutex)h0.w;
                i1 = h0.r;
                try {
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable2) {
                }
                try {
                label_71:
                    a1.close();
                    throw throwable2;
                }
                catch(Throwable throwable3) {
                    try {
                        e2.a.q(throwable2, throwable3);
                        throw throwable2;
                    }
                    catch(IOException iOException0) {
                        goto label_86;
                    }
                    catch(Throwable throwable0) {
                        mutex0 = mutex2;
                        mutex0.unlock(null);
                        throw throwable0;
                    }
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            a1.close();
            throwable4 = null;
        }
        catch(Throwable throwable4) {
        }
        try {
            if(throwable4 != null) {
                throw throwable4;
            }
            if(i1.a.exists(path2)) {
                i1.a.atomicMove(path2, i1.b);
            }
            goto label_98;
        }
        catch(IOException iOException0) {
        label_86:
            i0 = i1;
            mutex0 = mutex2;
            path1 = path2;
            try {
            label_89:
                if(i0.a.exists(path1)) {
                    try {
                        i0.a.delete(path1);
                    }
                    catch(IOException unused_ex) {
                    }
                }
                throw iOException0;
            }
            catch(Throwable throwable0) {
            }
        }
        catch(Throwable throwable0) {
            mutex0 = mutex2;
        }
        mutex0.unlock(null);
        throw throwable0;
    label_98:
        mutex2.unlock(null);
        return H.a;
    }

    @Override  // l2.l0
    public final Object b(r r0, c c0) {
        n2.c c2;
        Throwable throwable3;
        Object object1;
        i i0;
        boolean z1;
        Throwable throwable1;
        n2.c c1;
        g g0;
        if(c0 instanceof g) {
            g0 = (g)c0;
            int v = g0.G;
            if((v & 0x80000000) == 0) {
                g0 = new g(this, c0);
            }
            else {
                g0.G = v ^ 0x80000000;
            }
        }
        else {
            g0 = new g(this, c0);
        }
        Object object0 = g0.D;
        ne.a a0 = ne.a.a;
        switch(g0.G) {
            case 0: {
                n.D(object0);
                if(this.f.a.get()) {
                    throw new IllegalStateException("StorageConnection has already been disposed.");
                }
                boolean z = DefaultImpls.tryLock$default(this.g, null, 1, null);
                try {
                    c1 = new n2.c(this.a, this.b, this.c);
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    z1 = z;
                    i0 = this;
                    goto label_64;
                }
                try {
                    g0.r = this;
                    g0.w = c1;
                    g0.B = z;
                    g0.G = 1;
                    object1 = r0.invoke(c1, Boolean.valueOf(z), g0);
                }
                catch(Throwable throwable2) {
                    throwable3 = throwable2;
                    z1 = z;
                    i0 = this;
                    c2 = c1;
                    goto label_49;
                }
                if(object1 == a0) {
                    return a0;
                }
                object0 = object1;
                z1 = z;
                i0 = this;
                c2 = c1;
                break;
            }
            case 1: {
                try {
                    z1 = g0.B;
                    c2 = g0.w;
                    i0 = g0.r;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable3) {
                }
                try {
                label_49:
                    c2.close();
                    throw throwable3;
                }
                catch(Throwable throwable4) {
                    try {
                        e2.a.q(throwable3, throwable4);
                        throw throwable3;
                    }
                    catch(Throwable throwable1) {
                        goto label_64;
                    }
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            c2.close();
            throwable5 = null;
        }
        catch(Throwable throwable5) {
        }
        if(throwable5 == null) {
            if(z1) {
                DefaultImpls.unlock$default(i0.g, null, 1, null);
            }
            return object0;
        }
        try {
            throw throwable5;
        }
        catch(Throwable throwable1) {
        }
    label_64:
        if(z1) {
            DefaultImpls.unlock$default(i0.g, null, 1, null);
        }
        throw throwable1;
    }

    @Override  // l2.a
    public final void close() {
        this.f.a.set(true);
        this.e.invoke();
    }

    @Override  // l2.l0
    public final i0 d() {
        return this.d;
    }
}

