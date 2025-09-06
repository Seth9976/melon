package com.iloen.melon.custom;

import Fd.C;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import b9.a;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import d3.g;
import ie.r;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u001B\u0010\u000B\u001A\u00020\n2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0004\b\u000B\u0010\u0010R\u001B\u0010\u0016\u001A\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/custom/TypeAnimationText;", "Lcom/iloen/melon/custom/MelonEditText;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "str", "Lie/H;", "setAnimationText", "(Ljava/lang/CharSequence;)V", "", "", "list", "(Ljava/util/List;)V", "Ljava/lang/Runnable;", "E", "Lie/j;", "getAddRunnable", "()Ljava/lang/Runnable;", "addRunnable", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TypeAnimationText extends MelonEditText {
    public final float B;
    public final Handler D;
    public final r E;
    public final C G;
    public static final int I;
    public final boolean k;
    public CharSequence l;
    public int m;
    public final long n;
    public final long o;
    public final Paint r;
    public final Rect w;

    public TypeAnimationText(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null);
    }

    public TypeAnimationText(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
        this.k = true;
        this.l = "";
        this.n = 150L;
        this.o = 3500L;
        this.setCursorVisible(true);
        this.B = (float)ScreenUtils.dipToPixel(context0, 13.5f);
        this.w = new Rect();
        Paint paint0 = new Paint();
        this.r = paint0;
        paint0.setStyle(Paint.Style.STROKE);
        Paint paint1 = this.r;
        if(paint1 != null) {
            paint1.setStrokeWidth(((float)ScreenUtils.dipToPixel(this.getContext(), 1.0f)));
            Paint paint2 = this.r;
            if(paint2 != null) {
                paint2.setTypeface(this.getTypeface());
                Paint paint3 = this.r;
                if(paint3 != null) {
                    paint3.setColor(ColorUtils.getColor(this.getContext(), 0x7F0604AE));  // color:white120e
                    this.D = new Handler(Looper.getMainLooper());
                    this.E = g.Q(new a(this, 16));
                    this.G = new C(this, 3);
                    return;
                }
                q.m("paint");
                throw null;
            }
            q.m("paint");
            throw null;
        }
        q.m("paint");
        throw null;
    }

    public static void d(TypeAnimationText typeAnimationText0) {
        long v = typeAnimationText0.o;
        Handler handler0 = typeAnimationText0.D;
        if(typeAnimationText0.m == 0) {
            Editable editable0 = typeAnimationText0.getText();
            if(editable0 != null && editable0.length() != 0) {
                typeAnimationText0.setText("");
            }
        }
        if(typeAnimationText0.l.length() == 0) {
            return;
        }
        int v1 = typeAnimationText0.m;
        typeAnimationText0.m = v1 + 1;
        String s = String.valueOf(typeAnimationText0.l.charAt(v1));
        int v2 = Selection.getSelectionStart(typeAnimationText0.getText());
        Layout layout0 = typeAnimationText0.getLayout();
        if((layout0 == null || v2 == -1 ? -1 : layout0.getLineForOffset(v2)) == typeAnimationText0.getMaxLines() - 1 && q.b(s, "\n")) {
            typeAnimationText0.m = 0;
            handler0.postDelayed(typeAnimationText0.getAddRunnable(), v);
            return;
        }
        typeAnimationText0.append(s);
        typeAnimationText0.requestFocus();
        Editable editable1 = typeAnimationText0.getText();
        typeAnimationText0.setSelection((editable1 == null ? 0 : editable1.length()));
        if(typeAnimationText0.m < typeAnimationText0.l.length()) {
            handler0.postDelayed(typeAnimationText0.getAddRunnable(), typeAnimationText0.n);
            return;
        }
        typeAnimationText0.m = 0;
        handler0.postDelayed(typeAnimationText0.getAddRunnable(), v);
    }

    public final void e() {
        this.clearFocus();
        Runnable runnable0 = this.getAddRunnable();
        this.D.removeCallbacks(runnable0);
    }

    public final void f() {
        Runnable runnable0 = this.getAddRunnable();
        this.D.removeCallbacks(runnable0);
        Runnable runnable1 = this.getAddRunnable();
        this.D.postDelayed(runnable1, this.n);
    }

    private final Runnable getAddRunnable() {
        return (Runnable)this.E.getValue();
    }

    @Override  // android.widget.TextView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.addTextChangedListener(this.G);
    }

    @Override  // androidx.appcompat.widget.AppCompatEditText
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeTextChangedListener(this.G);
        this.D.removeCallbacksAndMessages(null);
    }

    @Override  // android.widget.TextView
    public final void onDraw(Canvas canvas0) {
        q.g(canvas0, "canvas");
        int v = this.getHeight() / this.getLineHeight();
        if(this.getLineCount() > v) {
            v = this.getLineCount();
        }
        Rect rect0 = this.w;
        if(rect0 != null) {
            Paint paint0 = this.r;
            if(paint0 != null) {
                int v2 = this.getLineBounds(0, rect0);
                for(int v1 = 0; v1 < v; ++v1) {
                    canvas0.drawLine(((float)rect0.left), ((float)v2) + this.B, ((float)rect0.right), ((float)v2) + this.B, paint0);
                    v2 += this.getLineHeight();
                }
                super.onDraw(canvas0);
                return;
            }
            q.m("paint");
            throw null;
        }
        q.m("rect");
        throw null;
    }

    // 去混淆评级： 低(20)
    @Override  // android.widget.TextView
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        return this.k ? false : super.onTouchEvent(motionEvent0);
    }

    private final void setAnimationText(CharSequence charSequence0) {
        this.l = charSequence0;
        this.m = 0;
        this.setText("");
    }

    public final void setAnimationText(@NotNull List list0) {
        q.g(list0, "list");
        this.setLines(list0.size());
        this.setAnimationText(p.q0(list0, "\n", null, null, null, 62));
    }
}

