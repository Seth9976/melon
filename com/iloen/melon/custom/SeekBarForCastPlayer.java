package com.iloen.melon.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;

public class SeekBarForCastPlayer extends AppCompatSeekBar implements SeekBar.OnSeekBarChangeListener {
    public ShapeDrawable b;
    public SeekBar.OnSeekBarChangeListener c;
    public int d;
    public int e;
    public int f;
    public int g;

    public SeekBarForCastPlayer(Context context0) {
        super(context0);
        this.a();
    }

    public SeekBarForCastPlayer(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a();
    }

    public SeekBarForCastPlayer(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a();
    }

    public final void a() {
        this.setMax(0x100);
        this.d = this.getPaddingStart();
        this.e = this.getPaddingEnd();
        this.f = this.getPaddingTop();
        this.g = this.getPaddingBottom();
        ShapeDrawable shapeDrawable0 = new ShapeDrawable(new OvalShape());
        this.b = shapeDrawable0;
        shapeDrawable0.getPaint().setColor(0);
        this.b.setIntrinsicHeight(ScreenUtils.dipToPixel(this.getContext(), 4.0f));
        this.b.setIntrinsicWidth(ScreenUtils.dipToPixel(this.getContext(), 4.0f));
        this.setThumb(this.b);
    }

    private ShapeDrawable getThumbDefault() {
        ShapeDrawable shapeDrawable0 = new ShapeDrawable(new OvalShape());
        shapeDrawable0.getPaint().setColor(ColorUtils.getColor(this.getContext(), 0x7F06017A));  // color:green500e_support_high_contrast
        shapeDrawable0.setIntrinsicHeight(ScreenUtils.dipToPixel(this.getContext(), 4.0f));
        shapeDrawable0.setIntrinsicWidth(ScreenUtils.dipToPixel(this.getContext(), 4.0f));
        return shapeDrawable0;
    }

    private ShapeDrawable getThumbFromProgress() {
        ShapeDrawable shapeDrawable0 = new ShapeDrawable(new OvalShape());
        shapeDrawable0.getPaint().setColor(ColorUtils.getColor(this.getContext(), 0x7F06017A));  // color:green500e_support_high_contrast
        shapeDrawable0.setIntrinsicHeight(ScreenUtils.dipToPixel(this.getContext(), 24.0f));
        shapeDrawable0.setIntrinsicWidth(ScreenUtils.dipToPixel(this.getContext(), 24.0f));
        return shapeDrawable0;
    }

    @Override  // androidx.appcompat.widget.AppCompatSeekBar
    public final void onDraw(Canvas canvas0) {
        synchronized(this) {
            super.onDraw(canvas0);
        }
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        SeekBar.OnSeekBarChangeListener seekBar$OnSeekBarChangeListener0 = this.c;
        if(seekBar$OnSeekBarChangeListener0 != null) {
            seekBar$OnSeekBarChangeListener0.onProgressChanged(seekBar0, v, z);
        }
        if(z) {
            this.setThumb(this.getThumbFromProgress());
            return;
        }
        this.setThumb(this.getThumbDefault());
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar0) {
        this.setPadding(this.d, 0, this.e, 0);
        SeekBar.OnSeekBarChangeListener seekBar$OnSeekBarChangeListener0 = this.c;
        if(seekBar$OnSeekBarChangeListener0 != null) {
            seekBar$OnSeekBarChangeListener0.onStartTrackingTouch(seekBar0);
        }
        this.setThumb(this.getThumbFromProgress());
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar0) {
        this.setPadding(this.d, this.f, this.e, this.g);
        SeekBar.OnSeekBarChangeListener seekBar$OnSeekBarChangeListener0 = this.c;
        if(seekBar$OnSeekBarChangeListener0 != null) {
            seekBar$OnSeekBarChangeListener0.onStopTrackingTouch(seekBar0);
        }
        this.setThumb(this.getThumbDefault());
    }

    @Override  // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener seekBar$OnSeekBarChangeListener0) {
        this.c = seekBar$OnSeekBarChangeListener0;
        super.setOnSeekBarChangeListener(this);
    }

    public void setOnTrackingListener(W0 w00) {
    }
}

