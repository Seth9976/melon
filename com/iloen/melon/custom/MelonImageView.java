package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path.Direction;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder;
import com.iloen.melon.MelonAppBase;
import k8.t1;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0010\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\"\u0010\u0018\u001A\u00020\u00118\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/custom/MelonImageView;", "Lcom/iloen/melon/custom/RecyclingImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "I", "getCornerType", "()I", "setCornerType", "(I)V", "cornerType", "", "d", "F", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "cornerRadius", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class MelonImageView extends RecyclingImageView {
    public final Drawable a;
    public final Path b;
    public int c;
    public float d;
    public static final float e;

    static {
        MelonAppBase.Companion.getClass();
        MelonImageView.e = t.a().getMelonImageviewDefaultRadius();
        q.f(new Builder().setCrossFadeEnabled(true).build(), "build(...)");
    }

    public MelonImageView(@Nullable Context context0) {
        this(context0, null, 6, 0);
    }

    public MelonImageView(@Nullable Context context0, @Nullable AttributeSet attributeSet0) {
        this(context0, attributeSet0, 4, 0);
    }

    public MelonImageView(@Nullable Context context0, @Nullable AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.b = new Path();
        D d0 = f0.d(this);
        if(d0 != null) {
            androidx.lifecycle.t t0 = d0.getLifecycle();
            if(t0 != null) {
                t0.a(new n0());  // 初始化器: Ljava/lang/Object;-><init>()V
            }
        }
        if(!this.isInEditMode()) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.t);
            q.f(typedArray0, "obtainStyledAttributes(...)");
            try {
                this.a = typedArray0.getDrawable(0);
                this.c = typedArray0.getInt(2, 1);
                this.d = typedArray0.getDimension(1, MelonImageView.e);
            }
            finally {
                typedArray0.recycle();
            }
        }
    }

    public MelonImageView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable0 = this.a;
        if(drawable0 != null && drawable0.isStateful()) {
            drawable0.setState(this.getDrawableState());
            this.invalidate();
        }
    }

    public final float getCornerRadius() {
        return this.d;
    }

    public final int getCornerType() {
        return this.c;
    }

    @Override  // android.widget.ImageView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            q.d(drawable0);
            drawable0.setVisible(this.getVisibility() == 0, false);
        }
    }

    @Override  // com.iloen.melon.custom.RecyclingImageView
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            q.d(drawable0);
            drawable0.setVisible(false, false);
        }
    }

    @Override  // android.widget.ImageView
    public void onDraw(Canvas canvas0) {
        q.g(canvas0, "canvas");
        if(this.c == 1) {
            canvas0.clipPath(this.b);
        }
        Drawable drawable0 = this.a;
        if(drawable0 != null && this.getDrawable() == null) {
            int v = this.getPaddingTop();
            int v1 = this.getPaddingLeft();
            int v2 = this.getPaddingRight();
            int v3 = this.getPaddingBottom();
            int v4 = this.getWidth();
            int v5 = this.getHeight();
            int v6 = drawable0.getIntrinsicWidth();
            int v7 = drawable0.getIntrinsicHeight();
            canvas0.save();
            canvas0.translate(((float)(v4 - (v2 + v1) - v6)) * 0.5f + ((float)v1), ((float)(v5 - (v3 + v) - v7)) * 0.5f + ((float)v));
            drawable0.draw(canvas0);
            canvas0.restore();
        }
        super.onDraw(canvas0);
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.setBounds(0, 0, drawable0.getIntrinsicWidth(), drawable0.getIntrinsicHeight());
        }
        this.b.reset();
        RectF rectF0 = new RectF(0.0f, 0.0f, ((float)v), ((float)v1));
        this.b.addRoundRect(rectF0, this.d, this.d, Path.Direction.CW);
    }

    public final void setCornerRadius(float f) {
        this.d = f;
    }

    public final void setCornerType(int v) {
        this.c = v;
    }
}

