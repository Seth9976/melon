package k8;

import O4.c;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import ie.H;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;

public final class k0 extends c {
    public final AtomicBoolean b;
    public final Drawable c;
    public final CancellableContinuationImpl d;

    public k0(AtomicBoolean atomicBoolean0, WebpDrawable webpDrawable0, CancellableContinuationImpl cancellableContinuationImpl0) {
        this.b = atomicBoolean0;
        this.c = webpDrawable0;
        this.d = cancellableContinuationImpl0;
    }

    @Override  // O4.c
    public final void a(Drawable drawable0) {
        q.g(drawable0, "d");
        if(!this.b.compareAndSet(false, true)) {
            return;
        }
        ((WebpDrawable)this.c).unregisterAnimationCallback(this);
        this.d.resumeWith(H.a);
    }
}

