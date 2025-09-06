package com.iloen.melon.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0004\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/custom/VerticalTextView;", "Lcom/iloen/melon/custom/MelonTextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VerticalTextView extends MelonTextView {
    public VerticalTextView(@Nullable Context context0) {
        super(context0);
    }

    public VerticalTextView(@NotNull Context context0, @NotNull AttributeSet attributeSet0) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        this(context0, attributeSet0, 0);
    }

    public VerticalTextView(@NotNull Context context0, @NotNull AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        super(context0, attributeSet0, v);
    }

    @Override  // android.widget.TextView
    public final void onDraw(Canvas canvas0) {
        q.g(canvas0, "canvas");
        TextPaint textPaint0 = this.getPaint();
        textPaint0.setColor(this.getCurrentTextColor());
        textPaint0.drawableState = this.getDrawableState();
        canvas0.save();
        canvas0.translate(((float)this.getWidth()), 0.0f);
        canvas0.rotate(90.0f);
        canvas0.translate(((float)this.getCompoundPaddingLeft()), ((float)this.getExtendedPaddingTop()));
        this.getLayout().draw(canvas0);
        canvas0.restore();
    }

    @Override  // androidx.appcompat.widget.AppCompatTextView
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v1, v);
        this.setMeasuredDimension(this.getMeasuredHeight(), this.getMeasuredWidth());
    }
}

