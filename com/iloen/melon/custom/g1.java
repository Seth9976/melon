package com.iloen.melon.custom;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.facebook.appevents.c;
import com.iloen.melon.player.video.VideoViewModel;
import com.iloen.melon.utils.log.LogU;

public final class G1 extends h1 {
    public final Handler a;
    public final c b;
    public boolean c;
    public final long d;
    public final VideoOverlayView e;

    public G1(VideoOverlayView videoOverlayView0) {
        this.e = videoOverlayView0;
        this.a = new Handler(Looper.getMainLooper());
        this.b = new c(this, 19);
        this.d = 800L;
    }

    @Override  // android.view.GestureDetector$OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent0) {
        LogU.Companion.d("VideoOverlayView", "onDoubleTap()");
        if(!this.c) {
            this.c = true;
            this.a.removeCallbacks(this.b);
            this.a.postDelayed(this.b, this.d);
        }
        return true;
    }

    @Override  // android.view.GestureDetector$OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent0) {
        LogU.Companion.d("VideoOverlayView", "onDoubleTapEvent()");
        if(motionEvent0 != null && motionEvent0.getActionMasked() == 1 && this.c) {
            float f = motionEvent0.getX();
            float f1 = motionEvent0.getY();
            this.e.e(f, f1);
            return true;
        }
        return false;
    }

    @Override  // android.view.GestureDetector$OnGestureListener
    public final boolean onDown(MotionEvent motionEvent0) {
        VideoViewModel videoViewModel0 = this.e.getViewModel();
        if(videoViewModel0 != null && videoViewModel0.isMiniPlayerMode()) {
            return false;
        }
        l1.B("onDown() isDoubleTapping:", this.c, LogU.Companion, "VideoOverlayView");
        return true;
    }

    @Override  // android.view.GestureDetector$OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent0) {
        if(motionEvent0 != null) {
            float f = motionEvent0.getX();
            float f1 = motionEvent0.getY();
            LogU.Companion.d("VideoOverlayView", "onSingleTapConfirmed() e.x:" + f + ", e.y:" + f1);
            if(this.c) {
                return true;
            }
            H1 h10 = this.e.getPerformListener();
            if(h10 != null) {
                h10.onSimpleClick();
            }
        }
        return false;
    }

    @Override  // android.view.GestureDetector$OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent0) {
        LogU.Companion.d("VideoOverlayView", "onSingleTapUp()");
        if(motionEvent0 != null && this.c) {
            float f = motionEvent0.getX();
            float f1 = motionEvent0.getY();
            this.e.e(f, f1);
            return true;
        }
        return false;
    }
}

