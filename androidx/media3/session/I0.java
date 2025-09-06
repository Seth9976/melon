package androidx.media3.session;

import M6.H;
import androidx.media3.session.legacy.MediaBrowserCompat.MediaItem;
import androidx.media3.session.legacy.u;
import e3.b;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public final class i0 implements Runnable {
    public final int a;
    public final H b;
    public final u c;

    public i0(H h0, u u0, int v) {
        this.a = v;
        this.b = h0;
        this.c = u0;
        super();
    }

    @Override
    public final void run() {
        u u1;
        u u0;
        if(this.a != 0) {
            try {
                u0 = this.c;
                List list0 = (List)this.b.get();
                u0.f((list0 == null ? null : h1.g(list0)));
            }
            catch(CancellationException | ExecutionException | InterruptedException cancellationException0) {
                b.E("MLSLegacyStub", "Library operation failed", cancellationException0);
                u0.f(null);
            }
            return;
        }
        try {
            u1 = this.c;
            u1.f(((MediaBrowserCompat.MediaItem)this.b.get()));
        }
        catch(CancellationException | ExecutionException | InterruptedException cancellationException1) {
            b.E("MLSLegacyStub", "Library operation failed", cancellationException1);
            u1.f(null);
        }
    }
}

