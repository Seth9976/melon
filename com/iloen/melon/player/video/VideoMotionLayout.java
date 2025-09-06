package com.iloen.melon.player.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fR\"\u0010\u000F\u001A\u00020\n8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/player/video/VideoMotionLayout;", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "g1", "Z", "isTouching", "()Z", "setTouching", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoMotionLayout extends MotionLayout {
    public static final int $stable = 8;
    public boolean g1;

    public VideoMotionLayout(@NotNull Context context0, @NotNull AttributeSet attributeSet0) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        super(context0, attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public boolean dispatchTouchEvent(@NotNull MotionEvent motionEvent0) {
        q.g(motionEvent0, "ev");
        int v = motionEvent0.getAction();
        switch(v) {
            case 0: {
                this.g1 = true;
                break;
            }
            case 1: {
                this.g1 = false;
                return super.dispatchTouchEvent(motionEvent0);
            }
            default: {
                if(v == 3) {
                    this.g1 = false;
                    return super.dispatchTouchEvent(motionEvent0);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent0);
    }

    public final boolean isTouching() {
        return this.g1;
    }

    public final void setTouching(boolean z) {
        this.g1 = z;
    }
}

