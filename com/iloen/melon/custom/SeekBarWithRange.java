package com.iloen.melon.custom;

import P1.c;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import d3.g;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\'\b\u0007\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0019\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00138\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R$\u0010\u001C\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00138\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u001A\u0010\u0016\u001A\u0004\b\u001B\u0010\u0018R\u001B\u0010\"\u001A\u00020\u001D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!R\u001B\u0010%\u001A\u00020\u001D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001F\u001A\u0004\b$\u0010!¨\u0006&"}, d2 = {"Lcom/iloen/melon/custom/SeekBarWithRange;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "isPressed", "Lie/H;", "setSeekbarPressed", "(Z)V", "l", "setOnSeekBarChangeListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "", "value", "b", "J", "getRangeA", "()J", "rangeA", "c", "getRangeB", "rangeB", "Landroid/graphics/drawable/NinePatchDrawable;", "i", "Lie/j;", "getImgPlayerSeekbarCover", "()Landroid/graphics/drawable/NinePatchDrawable;", "imgPlayerSeekbarCover", "j", "getImgPlayerSeekbarCoverPress", "imgPlayerSeekbarCoverPress", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SeekBarWithRange extends AppCompatSeekBar implements SeekBar.OnSeekBarChangeListener {
    public long b;
    public long c;
    public final Paint d;
    public final Paint e;
    public boolean f;
    public Bitmap g;
    public Bitmap h;
    public final r i;
    public final r j;
    public SeekBar.OnSeekBarChangeListener k;
    public static final int l;

    public SeekBarWithRange(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public SeekBarWithRange(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public SeekBarWithRange(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        this.b = -1L;
        this.c = -1L;
        Paint paint0 = new Paint(1);
        Paint.Style paint$Style0 = Paint.Style.FILL;
        paint0.setStyle(paint$Style0);
        paint0.setColor(ColorUtils.getColor(context0, 0x7F060179));  // color:green490e
        this.d = paint0;
        Paint paint1 = new Paint(1);
        paint1.setStyle(paint$Style0);
        paint1.setColor(0);
        paint1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.e = paint1;
        this.i = g.Q(new Y0(this, context0, 0));
        this.j = g.Q(new Y0(this, context0, 1));
        this.setThumb(null);
        this.setLayerType(1, null);
    }

    public SeekBarWithRange(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    public final void a(Canvas canvas0, float f) {
        Paint paint0 = this.d;
        if(this.f) {
            Bitmap bitmap0 = this.h;
            if(bitmap0 != null) {
                canvas0.drawBitmap(bitmap0, f, 0.0f, paint0);
                return;
            }
            q.m("imgPlayerSeekbarRepeatPress");
            throw null;
        }
        Bitmap bitmap1 = this.g;
        if(bitmap1 != null) {
            canvas0.drawBitmap(bitmap1, f, 0.0f, paint0);
            return;
        }
        q.m("imgPlayerSeekbarRepeat");
        throw null;
    }

    private final NinePatchDrawable getImgPlayerSeekbarCover() {
        return (NinePatchDrawable)this.i.getValue();
    }

    private final NinePatchDrawable getImgPlayerSeekbarCoverPress() {
        return (NinePatchDrawable)this.j.getValue();
    }

    public final long getRangeA() {
        return this.b;
    }

    public final long getRangeB() {
        return this.c;
    }

    @Override  // android.widget.ProgressBar
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.g == null) {
            Bitmap bitmap0 = BitmapFactory.decodeResource(this.getResources(), 0x7F080376);  // drawable:fullplayer_img_seekbar_repeat_divider
            q.f(bitmap0, "decodeResource(...)");
            this.g = bitmap0;
            Bitmap bitmap1 = BitmapFactory.decodeResource(this.getResources(), 0x7F080377);  // drawable:fullplayer_img_seekbar_repeat_divider_touch
            q.f(bitmap1, "decodeResource(...)");
            this.h = bitmap1;
        }
    }

    @Override  // android.widget.ProgressBar
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap0 = this.g;
        if(bitmap0 != null) {
            bitmap0.recycle();
            Bitmap bitmap1 = this.h;
            if(bitmap1 != null) {
                bitmap1.recycle();
                return;
            }
            q.m("imgPlayerSeekbarRepeatPress");
            throw null;
        }
    }

    @Override  // androidx.appcompat.widget.AppCompatSeekBar
    public final void onDraw(Canvas canvas0) {
        synchronized(this) {
            q.g(canvas0, "canvas");
            super.onDraw(canvas0);
            float f = (float)this.getPaddingLeft();
            float f1 = (float)this.getPaddingRight();
            float f2 = (((float)this.getWidth()) - f - f1) * ((float)this.b) / ((float)this.getMax()) + f;
            float f3 = f + (((float)this.getWidth()) - f - f1) * ((float)this.c) / ((float)this.getMax());
            float f4 = (float)ScreenUtils.dipToPixel(this.getContext(), 1.0f);
            if(this.b > -1L) {
                NinePatchDrawable ninePatchDrawable0 = this.f ? this.getImgPlayerSeekbarCoverPress() : this.getImgPlayerSeekbarCover();
                int v1 = this.getPaddingLeft();
                int v2 = this.getPaddingTop();
                int v3 = this.getHeight();
                canvas0.drawRect(((float)(v1 - 1)), ((float)(v2 - 1)), ((float)(((int)f2) + 1)), ((float)(v3 + 1)), this.e);
                ninePatchDrawable0.setBounds(v1 - 1, v2 - 1, ((int)f2) + 1, v3 + 1);
                ninePatchDrawable0.draw(canvas0);
                this.a(canvas0, f2 - f4);
            }
            if(this.c > -1L) {
                this.a(canvas0, f3 - f4);
            }
        }
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        q.g(seekBar0, "seekBar");
        if(z) {
            long v1 = this.b;
            if(v1 == -1L || ((long)v) >= v1) {
                long v2 = this.c;
                if(v2 != -1L && ((long)v) > v2) {
                    v = (int)v2;
                    this.setProgress(v);
                }
            }
            else {
                v = (int)v1;
                this.setProgress(v);
            }
        }
        SeekBar.OnSeekBarChangeListener seekBar$OnSeekBarChangeListener0 = this.k;
        if(seekBar$OnSeekBarChangeListener0 != null) {
            seekBar$OnSeekBarChangeListener0.onProgressChanged(seekBar0, v, z);
        }
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar0) {
        q.g(seekBar0, "seekBar");
        this.f = true;
        SeekBar.OnSeekBarChangeListener seekBar$OnSeekBarChangeListener0 = this.k;
        if(seekBar$OnSeekBarChangeListener0 != null) {
            seekBar$OnSeekBarChangeListener0.onStartTrackingTouch(seekBar0);
        }
        this.setSeekbarPressed(true);
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar0) {
        q.g(seekBar0, "seekBar");
        this.f = false;
        SeekBar.OnSeekBarChangeListener seekBar$OnSeekBarChangeListener0 = this.k;
        if(seekBar$OnSeekBarChangeListener0 != null) {
            seekBar$OnSeekBarChangeListener0.onStopTrackingTouch(seekBar0);
        }
        this.setSeekbarPressed(false);
    }

    @Override  // android.widget.SeekBar
    public void setOnSeekBarChangeListener(@NotNull SeekBar.OnSeekBarChangeListener seekBar$OnSeekBarChangeListener0) {
        q.g(seekBar$OnSeekBarChangeListener0, "l");
        this.k = seekBar$OnSeekBarChangeListener0;
        super.setOnSeekBarChangeListener(this);
    }

    private final void setSeekbarPressed(boolean z) {
        this.setProgressDrawable((z ? c.getDrawable(this.getContext(), 0x7F080379) : c.getDrawable(this.getContext(), 0x7F080378)));  // drawable:fullplayer_progress_p
    }
}

