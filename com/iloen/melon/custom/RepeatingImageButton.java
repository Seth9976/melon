package com.iloen.melon.custom;

import E9.t;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageButton;
import b3.Z;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.playback.VideoControllerHelper;
import pd.h;

public class RepeatingImageButton extends AppCompatImageButton {
    public long d;
    public int e;
    public h f;
    public long g;
    public boolean h;
    public final t i;
    public static final int j;

    public RepeatingImageButton(Context context0) {
        this(context0, null);
    }

    public RepeatingImageButton(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x1010072);
    }

    public RepeatingImageButton(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.g = 500L;
        this.i = new t(this, 16);
        this.setFocusable(true);
        this.setLongClickable(true);
    }

    public final void a(boolean z) {
        int v2;
        long v = SystemClock.elapsedRealtime();
        h h0 = this.f;
        if(h0 != null && this.h) {
            long v1 = v - this.d;
            if(z) {
                v2 = -1;
            }
            else {
                v2 = this.e;
                this.e = v2 + 1;
            }
            VideoControllerHelper videoControllerHelper0 = h0.b;
            if(h0.a != 0) {
                StringBuilder stringBuilder0 = Z.n(v2, "onRepeat() rewind (", ",", v1);
                stringBuilder0.append(")");
                LogU.debug$default(videoControllerHelper0.b, stringBuilder0.toString(), null, false, 6, null);
                videoControllerHelper0.f.y(v2, v1);
                return;
            }
            StringBuilder stringBuilder1 = Z.n(v2, "onRepeat() forward (", ",", v1);
            stringBuilder1.append(")");
            LogU.debug$default(videoControllerHelper0.b, stringBuilder1.toString(), null, false, 6, null);
            videoControllerHelper0.f.c(v2, v1);
        }
    }

    @Override  // android.view.View
    public final boolean onKeyDown(int v, KeyEvent keyEvent0) {
        if(v != 23 && v != 66) {
            return super.onKeyDown(v, keyEvent0);
        }
        super.onKeyDown(v, keyEvent0);
        return true;
    }

    @Override  // android.view.View
    public final boolean onKeyUp(int v, KeyEvent keyEvent0) {
        if(v == 23 || v == 66) {
            this.removeCallbacks(this.i);
            if(this.h && this.d != 0L) {
                this.a(true);
            }
            this.d = 0L;
        }
        return super.onKeyUp(v, keyEvent0);
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        if(motionEvent0.getAction() == 1) {
            this.removeCallbacks(this.i);
            if(this.h && this.d != 0L) {
                this.a(true);
                this.d = 0L;
            }
            this.d = 0L;
        }
        return super.onTouchEvent(motionEvent0);
    }

    @Override  // android.view.View
    public final boolean performLongClick() {
        this.d = SystemClock.elapsedRealtime();
        this.e = 0;
        this.h = true;
        this.post(this.i);
        return true;
    }
}

