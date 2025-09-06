package com.iloen.melon.custom;

import Vb.i;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR(\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\f0\u000B8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u001C\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00148\u0006@FX\u0086\u000E¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR$\u0010\"\u001A\u00020\u001D2\u0006\u0010\u0015\u001A\u00020\u001D8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R$\u0010%\u001A\u00020\u001D2\u0006\u0010\u0015\u001A\u00020\u001D8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b#\u0010\u001F\"\u0004\b$\u0010!R$\u0010+\u001A\u00020&2\u0006\u0010\u0015\u001A\u00020&8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/iloen/melon/custom/VideoOverlayDoubleTapView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/animation/ValueAnimator;", "getCircleAnimator", "()Landroid/animation/ValueAnimator;", "Lkotlin/Function0;", "Lie/H;", "n", "Lwe/a;", "getPerformAtEnd", "()Lwe/a;", "setPerformAtEnd", "(Lwe/a;)V", "performAtEnd", "", "value", "o", "F", "getArcSize", "()F", "setArcSize", "(F)V", "arcSize", "", "getCircleBackgroundColor", "()I", "setCircleBackgroundColor", "(I)V", "circleBackgroundColor", "getCircleColor", "setCircleColor", "circleColor", "", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "animationDuration", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoOverlayDoubleTapView extends View {
    public final Paint a;
    public final Paint b;
    public int c;
    public int d;
    public final Path e;
    public boolean f;
    public float g;
    public float h;
    public float i;
    public final int j;
    public final int k;
    public ValueAnimator l;
    public boolean m;
    public a n;
    public float o;
    public static final int r;

    public VideoOverlayDoubleTapView(@Nullable Context context0, @NotNull AttributeSet attributeSet0) {
        q.g(attributeSet0, "attrs");
        super(context0, attributeSet0);
        Paint paint0 = new Paint();
        this.a = paint0;
        Paint paint1 = new Paint();
        this.b = paint1;
        this.e = new Path();
        this.f = true;
        if(context0 == null) {
            throw new IllegalArgumentException("Context is null.");
        }
        Paint.Style paint$Style0 = Paint.Style.FILL;
        paint0.setStyle(paint$Style0);
        paint0.setAntiAlias(true);
        paint0.setColor(ColorUtils.getColor(context0, 0x7F0604BD));  // color:white_20
        paint1.setStyle(paint$Style0);
        paint1.setAntiAlias(true);
        paint1.setColor(ColorUtils.getColor(context0, 0x7F0604BC));  // color:white_15
        DisplayMetrics displayMetrics0 = context0.getResources().getDisplayMetrics();
        this.c = displayMetrics0.widthPixels;
        this.d = displayMetrics0.heightPixels;
        this.j = (int)(30.0f * displayMetrics0.density);
        this.k = (int)(displayMetrics0.density * 400.0f);
        this.b();
        this.l = this.getCircleAnimator();
        this.n = new i(19);
        this.o = 20.0f;
    }

    public final void a(a a0) {
        this.m = true;
        this.getCircleAnimator().end();
        a0.invoke();
        this.m = false;
        this.getCircleAnimator().start();
    }

    public final void b() {
        float f = ((float)this.c) * 0.45f;
        this.e.reset();
        float f1 = this.f ? 0.0f : ((float)this.c);
        int v = this.f ? 1 : -1;
        this.e.moveTo(f1, 0.0f);
        this.e.lineTo((f - this.o) * ((float)v) + f1, 0.0f);
        float f2 = (float)this.d;
        this.e.quadTo((f + this.o) * ((float)v) + f1, f2 / 2.0f, (f - this.o) * ((float)v) + f1, f2);
        this.e.lineTo(f1, ((float)this.d));
        this.e.close();
        this.invalidate();
    }

    public final long getAnimationDuration() {
        return this.l == null ? 800L : this.l.getDuration();
    }

    public final float getArcSize() {
        return this.o;
    }

    private final ValueAnimator getCircleAnimator() {
        if(this.l == null) {
            ValueAnimator valueAnimator0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            valueAnimator0.setDuration(this.getAnimationDuration());
            valueAnimator0.addUpdateListener(new com.google.android.exoplayer2.ui.a(this, 5));
            valueAnimator0.addListener(new z1(this, 0));
            this.l = valueAnimator0;
        }
        ValueAnimator valueAnimator1 = this.l;
        q.d(valueAnimator1);
        return valueAnimator1;
    }

    public final int getCircleBackgroundColor() {
        return this.a.getColor();
    }

    public final int getCircleColor() {
        return this.b.getColor();
    }

    @NotNull
    public final a getPerformAtEnd() {
        return this.n;
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        q.g(canvas0, "canvas");
        super.onDraw(canvas0);
        canvas0.clipPath(this.e);
        canvas0.drawPath(this.e, this.a);
        canvas0.drawCircle(this.g, this.h, this.i, this.b);
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        this.c = v;
        this.d = v1;
        this.b();
    }

    public final void setAnimationDuration(long v) {
        this.getCircleAnimator().setDuration(v);
    }

    public final void setArcSize(float f) {
        this.o = f;
        this.b();
    }

    public final void setCircleBackgroundColor(int v) {
        this.a.setColor(v);
    }

    public final void setCircleColor(int v) {
        this.b.setColor(v);
    }

    public final void setPerformAtEnd(@NotNull a a0) {
        q.g(a0, "<set-?>");
        this.n = a0;
    }
}

