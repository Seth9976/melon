package t5;

import android.os.Looper;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import androidx.lifecycle.t;
import com.iloen.melon.custom.MelonImageView;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import v5.a;

public final class w implements View.OnAttachStateChangeListener {
    public final MelonImageView a;
    public l b;
    public Job c;
    public u d;
    public boolean e;

    public w(MelonImageView melonImageView0) {
        this.a = melonImageView0;
    }

    public final l a() {
        synchronized(this) {
            l l0 = this.b;
            if(l0 != null && q.b(Looper.myLooper(), Looper.getMainLooper()) && this.e) {
                this.e = false;
                return l0;
            }
            Job job0 = this.c;
            if(job0 != null) {
                DefaultImpls.cancel$default(job0, null, 1, null);
            }
            this.c = null;
            l l1 = new l(this.a);
            this.b = l1;
            return l1;
        }
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view0) {
        u u0 = this.d;
        if(u0 == null) {
            return;
        }
        this.e = true;
        u0.a.b(u0.b);
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view0) {
        u u0 = this.d;
        if(u0 != null) {
            t t0 = u0.d;
            DefaultImpls.cancel$default(u0.e, null, 1, null);
            a a0 = u0.c;
            if(a0 != null) {
                t0.c(a0);
            }
            t0.c(u0);
        }
    }
}

