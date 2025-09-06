package i.n.i.b.a.s.e;

import android.hardware.display.DisplayManager.DisplayListener;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.media3.exoplayer.video.VideoFrameReleaseHelper;

public final class s2 implements DisplayManager.DisplayListener {
    public final int a;
    public final DisplayManager b;
    public final Object c;

    public s2(Object object0, DisplayManager displayManager0, int v) {
        this.a = v;
        this.c = object0;
        this.b = displayManager0;
        super();
    }

    private final void a(int v) {
    }

    private final void b(int v) {
    }

    private final void c(int v) {
    }

    private final void d(int v) {
    }

    @Override  // android.hardware.display.DisplayManager$DisplayListener
    public final void onDisplayAdded(int v) {
    }

    @Override  // android.hardware.display.DisplayManager$DisplayListener
    public final void onDisplayChanged(int v) {
        if(this.a != 0) {
            if(v == 0) {
                Display display0 = this.b.getDisplay(0);
                VideoFrameReleaseHelper.a(((VideoFrameReleaseHelper)this.c), display0);
            }
            return;
        }
        if(v == 0) {
            ((en)this.c).b();
        }
    }

    @Override  // android.hardware.display.DisplayManager$DisplayListener
    public final void onDisplayRemoved(int v) {
    }
}

