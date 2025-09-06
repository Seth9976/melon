package id;

import android.os.Message;
import android.os.SystemClock;
import com.iloen.melon.custom.ProgressImageView;
import com.iloen.melon.custom.U0;
import kotlin.jvm.internal.q;

public final class i extends U0 {
    public final k a;

    public i(k k0, ProgressImageView progressImageView0) {
        q.g(progressImageView0, "ref");
        this.a = k0;
        super(progressImageView0);
    }

    @Override  // com.iloen.melon.custom.U0
    public final void handleMessage(Object object0, Message message0) {
        if(message0 != null && message0.what == 1) {
            f f0 = this.a.r;
            int v = 0;
            if(f0 != null) {
                F f1 = f0.f;
                if(f1 != null) {
                    long v1 = f1.g;
                    long v2 = 0L;
                    if(v1 != 0L) {
                        if(f0 != null) {
                            if(f1 != null && v1 != 0L) {
                                v2 = SystemClock.elapsedRealtime() - f1.g;
                            }
                            v = (int)v2;
                        }
                        ((ProgressImageView)object0).setProgress(v);
                        this.sendEmptyMessageDelayed(1, 16L);
                        return;
                    }
                }
            }
            this.removeMessages(1);
            ((ProgressImageView)object0).setProgress(0);
        }
    }
}

