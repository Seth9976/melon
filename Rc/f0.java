package Rc;

import android.os.CountDownTimer;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.custom.VideoEndingView;
import com.iloen.melon.custom.y1;
import com.iloen.melon.utils.log.LogU;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

public final class f0 extends CountDownTimer {
    public final int a;
    public final Object b;

    public f0(t0 t00) {
        this.a = 0;
        this.b = t00;
        super(0x7FFFFFFFFFFFFFFFL, 1000L);
    }

    public f0(MusicBrowserActivity musicBrowserActivity0) {
        this.a = 2;
        this.b = musicBrowserActivity0;
        super(4000L, 1000L);
    }

    public f0(VideoEndingView videoEndingView0, long v) {
        this.a = 1;
        this.b = videoEndingView0;
        super(v, 1000L);
    }

    private final void a() {
    }

    private final void b(long v) {
    }

    @Override  // android.os.CountDownTimer
    public final void onFinish() {
        switch(this.a) {
            case 0: {
                break;
            }
            case 1: {
                VideoEndingView videoEndingView0 = (VideoEndingView)this.b;
                LogU.debug$default(videoEndingView0.o, "countDownTimer onFinish()", null, false, 6, null);
                y1 y10 = videoEndingView0.B;
                if(y10 != null) {
                    y10.onPlay((videoEndingView0.D == null ? null : videoEndingView0.D.a));
                }
                this.cancel();
                break;
            }
            default: {
                ((MusicBrowserActivity)this.b).countDownTimer = null;
            }
        }
    }

    @Override  // android.os.CountDownTimer
    public final void onTick(long v) {
        switch(this.a) {
            case 0: {
                long v1 = System.currentTimeMillis();
                t0 t00 = (t0)this.b;
                if(t00.r != v1 / 60000L) {
                    t00.r = v1 / 60000L;
                    BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.h(t00), Dispatchers.getIO(), null, new e0(t00, null), 2, null);
                }
                return;
            }
            case 1: {
                ((VideoEndingView)this.b).getClass();
                ((VideoEndingView)this.b).r.j.setText(v / 1000L + "초");
            }
        }
    }
}

