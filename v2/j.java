package v2;

import df.d;
import java.util.concurrent.ThreadPoolExecutor;
import o9.b;

public final class j extends d {
    public final d g;
    public final ThreadPoolExecutor h;

    public j(d d0, ThreadPoolExecutor threadPoolExecutor0) {
        this.g = d0;
        this.h = threadPoolExecutor0;
    }

    @Override  // df.d
    public final void C(Throwable throwable0) {
        try {
            this.g.C(throwable0);
        }
        finally {
            this.h.shutdown();
        }
    }

    @Override  // df.d
    public final void D(b b0) {
        try {
            this.g.D(b0);
        }
        finally {
            this.h.shutdown();
        }
    }
}

