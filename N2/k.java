package n2;

import d5.n;
import ie.H;
import kotlin.jvm.internal.q;
import l2.c0;
import l2.q0;
import ne.a;
import okio.BufferedSink;
import okio.FileHandle;
import okio.Okio;

public final class k extends c implements q0 {
    @Override  // l2.q0
    public final Object e(Object object0, oe.c c0) {
        FileHandle fileHandle2;
        BufferedSink bufferedSink1;
        Throwable throwable3;
        FileHandle fileHandle1;
        H h1;
        BufferedSink bufferedSink0;
        FileHandle fileHandle0;
        j j0;
        if(c0 instanceof j) {
            j0 = (j)c0;
            int v = j0.G;
            if((v & 0x80000000) == 0) {
                j0 = new j(this, c0);
            }
            else {
                j0.G = v ^ 0x80000000;
            }
        }
        else {
            j0 = new j(this, c0);
        }
        Object object1 = j0.D;
        a a0 = a.a;
        H h0 = H.a;
        Throwable throwable0 = null;
        switch(j0.G) {
            case 0: {
                n.D(object1);
                if(this.d.a.get()) {
                    throw new IllegalStateException("This scope has already been closed.");
                }
                fileHandle0 = this.a.openReadWrite(this.b);
                try {
                    bufferedSink0 = Okio.buffer(FileHandle.sink$default(fileHandle0, 0L, 1, null));
                }
                catch(Throwable throwable1) {
                    goto label_72;
                }
                try {
                    j0.r = fileHandle0;
                    j0.w = fileHandle0;
                    j0.B = bufferedSink0;
                    j0.G = 1;
                    h1 = ((c0)this.c.b).writeTo(object0, bufferedSink0.outputStream(), j0);
                }
                catch(Throwable throwable2) {
                    fileHandle1 = fileHandle0;
                    throwable3 = throwable2;
                    bufferedSink1 = bufferedSink0;
                    break;
                }
                if(h1 != a0) {
                    h1 = h0;
                }
                if(h1 == a0) {
                    return a0;
                }
                fileHandle1 = fileHandle0;
                fileHandle2 = fileHandle1;
                bufferedSink1 = bufferedSink0;
                goto label_43;
            }
            case 1: {
                try {
                    bufferedSink1 = j0.B;
                    fileHandle2 = j0.w;
                    fileHandle1 = j0.r;
                    n.D(object1);
                label_43:
                    fileHandle2.flush();
                    goto label_59;
                }
                catch(Throwable throwable3) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(bufferedSink1 != null) {
            try {
                bufferedSink1.close();
            }
            catch(Throwable throwable4) {
                try {
                    e2.a.q(throwable3, throwable4);
                }
                catch(Throwable throwable1) {
                    fileHandle0 = fileHandle1;
                    goto label_72;
                }
            }
        }
        Throwable throwable5 = throwable3;
        fileHandle0 = fileHandle1;
        H h2 = null;
        goto label_67;
    label_59:
        if(bufferedSink1 == null) {
        label_64:
            throwable5 = null;
        }
        else {
            try {
                bufferedSink1.close();
                goto label_64;
            }
            catch(Throwable throwable5) {
            }
        }
        fileHandle0 = fileHandle1;
        h2 = h0;
        try {
        label_67:
            if(throwable5 != null) {
                throw throwable5;
            }
            q.d(h2);
            goto label_80;
        }
        catch(Throwable throwable1) {
        }
    label_72:
        if(fileHandle0 != null) {
            try {
                fileHandle0.close();
            }
            catch(Throwable throwable6) {
                e2.a.q(throwable1, throwable6);
            }
        }
        throwable0 = throwable1;
        H h3 = null;
        goto label_85;
    label_80:
        if(fileHandle0 != null) {
            try {
                fileHandle0.close();
            }
            catch(Throwable throwable0) {
            }
        }
        h3 = h0;
    label_85:
        if(throwable0 != null) {
            throw throwable0;
        }
        q.d(h3);
        return h0;
    }
}

