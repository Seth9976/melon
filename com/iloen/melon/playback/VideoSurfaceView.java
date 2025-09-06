package com.iloen.melon.playback;

import Ma.m;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import com.google.firebase.b;
import k8.o;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001B\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0004\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\tH\u0014¢\u0006\u0004\b\u000F\u0010\u0010R*\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\t8\u0006@FX\u0086\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/playback/VideoSurfaceView;", "Landroid/view/SurfaceView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "Lie/H;", "onMeasure", "(II)V", "value", "scaleType", "I", "getScaleType", "()I", "setScaleType", "(I)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoSurfaceView extends SurfaceView {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/playback/VideoSurfaceView$Companion;", "", "<init>", "()V", "TAG", "", "SCALE_TYPE_UNKNOWN", "", "SCALE_TYPE_FIT_WIDTH", "SCALE_TYPE_FIT_HEIGHT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int SCALE_TYPE_FIT_HEIGHT = 1002;
    public static final int SCALE_TYPE_FIT_WIDTH = 1001;
    public static final int SCALE_TYPE_UNKNOWN = 1000;
    @NotNull
    private static final String TAG = "VideoSurfaceView";
    private int scaleType;

    static {
        VideoSurfaceView.Companion = new Companion(null);
        VideoSurfaceView.$stable = 8;
    }

    public VideoSurfaceView(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
        this.scaleType = 1000;
        this.setWillNotDraw(false);
    }

    public VideoSurfaceView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
        this.scaleType = 1000;
        this.setWillNotDraw(false);
    }

    public VideoSurfaceView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        this.scaleType = 1000;
        this.setWillNotDraw(false);
    }

    public final int getScaleType() {
        return this.scaleType;
    }

    @Override  // android.view.SurfaceView
    public void onMeasure(int v, int v1) {
        int v6;
        Context context0 = this.getContext();
        q.f(context0, "getContext(...)");
        Context context1 = context0.getApplicationContext();
        q.d(context1);
        Playable playable0 = ((d3)(((s2)((o)(((m)b.B(context1, m.class)))).w.get()))).f();
        int v2 = View.getDefaultSize(0, v);
        int v3 = View.getDefaultSize(0, v1);
        if(playable0 == null) {
            this.setMeasuredDimension(v2, v3);
            return;
        }
        int v4 = playable0.getMvWidth();
        int v5 = playable0.getMvHeight();
        if(v4 != 0 && v5 != 0) {
            if(playable0.isLandscapeMv()) {
                v6 = v3 * v4 / v5;
                if(v2 <= v6) {
                    v3 = v5 * v2 / v4;
                }
                else {
                    v2 = v6;
                }
            }
            else {
                int v7 = this.scaleType;
                if(v7 == 1001) {
                    v3 = v5 * v2 / v4;
                }
                else if(v7 == 1002) {
                    v2 = v4 * v3 / v5;
                }
                else {
                    v6 = v3 * v4 / v5;
                    if(v2 <= v6) {
                        v3 = v5 * v2 / v4;
                    }
                    else {
                        v2 = v6;
                    }
                }
            }
            this.setMeasuredDimension(v2, v3);
            return;
        }
        this.setMeasuredDimension(v2, v3);
    }

    public final void setScaleType(int v) {
        this.scaleType = v;
        this.requestLayout();
    }
}

