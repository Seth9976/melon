package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.iloen.melon.utils.system.ScreenUtils;
import k8.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0004\u0010\u000BJ\r\u0010\f\u001A\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001A\u00020\t¢\u0006\u0004\b\u0012\u0010\rJ\u0015\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\t¢\u0006\u0004\b\u0014\u0010\u0011J\r\u0010\u0016\u001A\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001A\u00020\u000F2\u0006\u0010\u0018\u001A\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/custom/UnderlineTextView;", "Lcom/iloen/melon/custom/MelonTextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getUnderlineColor", "()I", "underlineColor", "Lie/H;", "setUnderlineColor", "(I)V", "getUnderlineWidth", "underlineWidth", "setUnderlineWidth", "", "getViewType", "()Ljava/lang/String;", "viewType", "setViewType", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class UnderlineTextView extends MelonTextView {
    public int i;
    public int j;
    public float k;
    public String l;
    public final Paint m;
    public final Rect n;

    public UnderlineTextView(@Nullable Context context0) {
        super(context0);
        this.l = "typeLyric";
        this.n = new Rect();
        this.i = 0;
        this.j = 0;
    }

    public UnderlineTextView(@NotNull Context context0, @NotNull AttributeSet attributeSet0) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        this(context0, attributeSet0, 0);
    }

    public UnderlineTextView(@NotNull Context context0, @NotNull AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        super(context0, attributeSet0, v);
        this.l = "typeLyric";
        this.n = new Rect();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.L, v, 0);
        q.f(typedArray0, "obtainStyledAttributes(...)");
        this.i = typedArray0.getColor(0, 0);
        this.j = typedArray0.getDimensionPixelSize(2, 0);
        String s = typedArray0.getString(1);
        if(s == null) {
            s = "";
        }
        this.l = s;
        typedArray0.recycle();
        Paint paint0 = new Paint(1);
        paint0.setUnderlineText(true);
        paint0.setStyle(Paint.Style.STROKE);
        paint0.setColor(this.i);
        paint0.setStrokeWidth(((float)this.j));
        this.m = paint0;
    }

    public final int getUnderlineColor() {
        return this.i;
    }

    public final int getUnderlineWidth() {
        return this.j;
    }

    @NotNull
    public final String getViewType() {
        return this.l;
    }

    public final void h() {
        Paint paint0 = this.m;
        if(paint0 != null) {
            paint0.setColor(this.i);
            Paint paint1 = this.m;
            if(paint1 != null) {
                paint1.setStrokeWidth(((float)this.j));
                this.invalidate();
                return;
            }
            q.m("paint");
            throw null;
        }
    }

    @Override  // android.widget.TextView
    public final void onDraw(Canvas canvas0) {
        float f3;
        float f2;
        q.g(canvas0, "canvas");
        if(this.m != null) {
            float f = this.getLineSpacingExtra();
            int v = this.getLineCount();
            int v1 = 0;
            while(v1 < v) {
                Paint paint0 = this.m;
                if(paint0 != null) {
                    String s = this.getText().toString();
                    int v2 = this.getText().length();
                    Rect rect0 = this.n;
                    paint0.getTextBounds(s, 0, v2, rect0);
                    if(q.b(this.l, "typeNote")) {
                        float f1 = (float)this.getLineBounds(v1, rect0);
                        Context context0 = this.getContext();
                        Paint paint1 = this.m;
                        if(paint1 != null) {
                            int v3 = ScreenUtils.dipToPixel(context0, paint1.getFontMetrics().bottom);
                            f2 = this.k;
                            f3 = f1 + ((float)v3) + f / 2.0f;
                            goto label_25;
                        }
                        q.m("paint");
                        throw null;
                    }
                    else {
                        f3 = (float)this.getLineBounds(v1, rect0);
                        f2 = this.getLayout().getLineRight(v1) + 20.0f;
                    }
                label_25:
                    Paint paint2 = this.m;
                    if(paint2 != null) {
                        canvas0.drawLine(0.0f, f3, f2, f3, paint2);
                        ++v1;
                        continue;
                    }
                    q.m("paint");
                    throw null;
                }
                q.m("paint");
                throw null;
            }
        }
        super.onDraw(canvas0);
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        this.k = (float)v;
    }

    public final void setUnderlineColor(int v) {
        this.i = v;
    }

    public final void setUnderlineWidth(int v) {
        this.j = v;
    }

    public final void setViewType(@NotNull String s) {
        q.g(s, "viewType");
        this.l = s;
    }
}

