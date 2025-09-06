package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import k8.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0004\u0010\u000BR\"\u0010\u0013\u001A\u00020\f8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001A\u001A\u00020\t8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001E\u001A\u00020\t8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001B\u0010\u0015\u001A\u0004\b\u001C\u0010\u0017\"\u0004\b\u001D\u0010\u0019¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/custom/OutlineTextView;", "Lcom/iloen/melon/custom/MelonTextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "i", "Z", "getTextStroke", "()Z", "setTextStroke", "(Z)V", "textStroke", "j", "I", "getTextStrokeWidth", "()I", "setTextStrokeWidth", "(I)V", "textStrokeWidth", "k", "getTextStrokeColor", "setTextStrokeColor", "textStrokeColor", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class OutlineTextView extends MelonTextView {
    public boolean i;
    public int j;
    public int k;

    public OutlineTextView(@Nullable Context context0) {
        super(context0);
        this.k = -1;
        this.i = false;
        this.j = 0;
    }

    public OutlineTextView(@NotNull Context context0, @NotNull AttributeSet attributeSet0) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        this(context0, attributeSet0, 0);
    }

    public OutlineTextView(@NotNull Context context0, @NotNull AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        super(context0, attributeSet0, v);
        this.k = -1;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.w, v, 0);
        q.f(typedArray0, "obtainStyledAttributes(...)");
        this.i = typedArray0.getBoolean(0, false);
        this.j = typedArray0.getDimensionPixelSize(2, 0);
        this.k = typedArray0.getColor(1, 0);
        typedArray0.recycle();
    }

    public final boolean getTextStroke() {
        return this.i;
    }

    public final int getTextStrokeColor() {
        return this.k;
    }

    public final int getTextStrokeWidth() {
        return this.j;
    }

    @Override  // android.widget.TextView
    public final void onDraw(Canvas canvas0) {
        q.g(canvas0, "canvas");
        if(this.i) {
            ColorStateList colorStateList0 = this.getTextColors();
            q.f(colorStateList0, "getTextColors(...)");
            this.getPaint().setStyle(Paint.Style.STROKE);
            this.getPaint().setStrokeWidth(((float)this.j));
            this.setTextColor(this.k);
            super.onDraw(canvas0);
            this.getPaint().setStyle(Paint.Style.FILL);
            this.setTextColor(colorStateList0);
        }
        super.onDraw(canvas0);
    }

    public final void setTextStroke(boolean z) {
        this.i = z;
    }

    public final void setTextStrokeColor(int v) {
        this.k = v;
    }

    public final void setTextStrokeWidth(int v) {
        this.j = v;
    }
}

