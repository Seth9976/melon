package com.iloen.melon.custom;

import P1.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.iloen.melon.utils.color.ColorUtils;
import java.util.ArrayList;
import k8.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ye.a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001B\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0013\u001A\u00020\u000E2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001A\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001AJ\u0015\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u001B\u001A\u00020\u0015¢\u0006\u0004\b\u001C\u0010\u0018J\u0019\u0010\u001F\u001A\u00020\u000E2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001DH\u0016¢\u0006\u0004\b\u001F\u0010 R\"\u0010!\u001A\u00020\u00158\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b!\u0010\"\u001A\u0004\b!\u0010\u001A\"\u0004\b#\u0010\u0018¨\u0006$"}, d2 = {"Lcom/iloen/melon/custom/SeekBarForNewVideoPlayer;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "l", "Lie/H;", "setOnSeekBarChangeListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "Lcom/iloen/melon/custom/X0;", "onTrackingListener", "setOnTrackingListener", "(Lcom/iloen/melon/custom/X0;)V", "", "isLive", "setLiveMode", "(Z)V", "getEnableTracking", "()Z", "isAvailable", "setEnableTracking", "Landroid/graphics/drawable/Drawable;", "thumb", "setThumb", "(Landroid/graphics/drawable/Drawable;)V", "isInUserAction", "Z", "setInUserAction", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SeekBarForNewVideoPlayer extends AppCompatSeekBar implements SeekBar.OnSeekBarChangeListener {
    public SeekBar.OnSeekBarChangeListener b;
    public final ArrayList c;
    public X0 d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public boolean i;

    public SeekBarForNewVideoPlayer(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
        this.c = new ArrayList();
        this.h = -1;
    }

    public SeekBarForNewVideoPlayer(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 0);
    }

    public SeekBarForNewVideoPlayer(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        this.c = new ArrayList();
        this.h = -1;
        this.setThumbTintMode(PorterDuff.Mode.SRC);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.E, v, 0);
        q.f(typedArray0, "obtainStyledAttributes(...)");
        boolean z = typedArray0.getBoolean(0, false);
        this.setThumb(c.getDrawable(context0, 0x7F080945));  // drawable:video_seek_thumb
        this.setEnableTracking(z);
        typedArray0.recycle();
    }

    public final void a() {
        this.i = true;
        int v = this.f ? 0x7F06017C : 0x7F060179;  // color:green500s_support_high_contrast
        this.setThumbTintList(ColorStateList.valueOf(ColorUtils.getColor(this.getContext(), v)));
    }

    public final boolean getEnableTracking() {
        return this.e;
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        SeekBar.OnSeekBarChangeListener seekBar$OnSeekBarChangeListener0 = this.b;
        if(seekBar$OnSeekBarChangeListener0 != null) {
            seekBar$OnSeekBarChangeListener0.onProgressChanged(seekBar0, v, z);
        }
        for(Object object0: this.c) {
            ((SeekBar.OnSeekBarChangeListener)object0).onProgressChanged(seekBar0, v, z);
        }
        X0 x00 = this.d;
        if(x00 != null) {
            x00.onStartTracking(seekBar0, z);
        }
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar0) {
        if(!this.e) {
            return;
        }
        if(seekBar0 != null) {
            seekBar0.setEnabled(true);
        }
        SeekBar.OnSeekBarChangeListener seekBar$OnSeekBarChangeListener0 = this.b;
        if(seekBar$OnSeekBarChangeListener0 != null) {
            seekBar$OnSeekBarChangeListener0.onStartTrackingTouch(seekBar0);
        }
        for(Object object0: this.c) {
            ((SeekBar.OnSeekBarChangeListener)object0).onStartTrackingTouch(seekBar0);
        }
        if(seekBar0 != null) {
            double f = ((double)seekBar0.getProgress()) / ((double)seekBar0.getMax());
            X0 x00 = this.d;
            if(x00 != null) {
                x00.onThumbDragging(((int)(Double.isNaN(f * 100.0) ? 0 : a.U(f * 100.0))));
            }
        }
        int v = (int)this.getContext().getResources().getDimension(0x7F07047A);  // dimen:video_seekbar_padding_vertical
        if(seekBar0 != null) {
            seekBar0.setPadding(0, v, 0, v);
        }
        if(seekBar0 != null) {
            seekBar0.setProgressDrawable(null);
        }
        this.setThumb(c.getDrawable(this.getContext(), 0x7F080946));  // drawable:video_seek_thumb_touch
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar0) {
        if(!this.e) {
            return;
        }
        SeekBar.OnSeekBarChangeListener seekBar$OnSeekBarChangeListener0 = this.b;
        if(seekBar$OnSeekBarChangeListener0 != null) {
            seekBar$OnSeekBarChangeListener0.onStopTrackingTouch(seekBar0);
        }
        for(Object object0: this.c) {
            ((SeekBar.OnSeekBarChangeListener)object0).onStopTrackingTouch(seekBar0);
        }
        X0 x00 = this.d;
        if(x00 != null) {
            x00.onStopTracking(seekBar0);
        }
        this.setProgressDrawable(c.getDrawable(this.getContext(), (this.f ? 0x7F080944 : 0x7F080943)));  // drawable:video_progress_new_border
        int v = (int)this.getContext().getResources().getDimension(0x7F07047A);  // dimen:video_seekbar_padding_vertical
        if(seekBar0 != null) {
            seekBar0.setPadding(0, v, 0, v);
        }
        this.setThumb(c.getDrawable(this.getContext(), 0x7F080945));  // drawable:video_seek_thumb
    }

    @Override  // android.widget.AbsSeekBar
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        q.g(motionEvent0, "event");
        boolean z = false;
        if(!this.e) {
            return false;
        }
        int v = motionEvent0.getAction();
        switch(v) {
            case 0: {
                this.g = false;
                this.h = (int)motionEvent0.getX();
                return true;
            }
            case 1: {
                return super.onTouchEvent(motionEvent0);
            }
            default: {
                if(v == 2 && !this.g) {
                    int v1 = Math.abs(this.h - ((int)motionEvent0.getX()));
                    Drawable drawable0 = this.getThumb();
                    if(v1 >= (drawable0 == null ? 0 : drawable0.getIntrinsicWidth())) {
                        z = true;
                    }
                    this.g = z;
                    return true;
                }
                return super.onTouchEvent(motionEvent0);
            }
        }
    }

    public final void setEnableTracking(boolean z) {
        this.e = z;
        if(z) {
            this.a();
            return;
        }
        this.i = false;
        this.setThumbTintList(ColorStateList.valueOf(ColorUtils.getColor(this.getContext(), 0x7F06048A)));  // color:transparent
    }

    public final void setInUserAction(boolean z) {
    }

    public final void setLiveMode(boolean z) {
    }

    @Override  // android.widget.SeekBar
    public void setOnSeekBarChangeListener(@NotNull SeekBar.OnSeekBarChangeListener seekBar$OnSeekBarChangeListener0) {
        q.g(seekBar$OnSeekBarChangeListener0, "l");
        this.b = seekBar$OnSeekBarChangeListener0;
        super.setOnSeekBarChangeListener(this);
    }

    public final void setOnTrackingListener(@Nullable X0 x00) {
        this.d = x00;
    }

    @Override  // android.widget.AbsSeekBar
    public void setThumb(@Nullable Drawable drawable0) {
        super.setThumb(drawable0);
        if(this.f) {
            this.setThumbOffset(0);
        }
    }
}

