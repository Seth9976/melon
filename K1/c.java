package k1;

import A0.e;
import A0.h;
import A0.i;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import kotlin.jvm.internal.q;

public final class c extends CharacterStyle implements UpdateAppearance {
    public final e a;

    public c(e e0) {
        this.a = e0;
    }

    @Override  // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint0) {
        Paint.Cap paint$Cap0;
        Paint.Join paint$Join0;
        if(textPaint0 != null) {
            e e0 = this.a;
            if(q.b(e0, h.b)) {
                textPaint0.setStyle(Paint.Style.FILL);
                return;
            }
            if(e0 instanceof i) {
                textPaint0.setStyle(Paint.Style.STROKE);
                textPaint0.setStrokeWidth(((i)e0).b);
                textPaint0.setStrokeMiter(((i)e0).c);
                int v = ((i)e0).e;
                if(v == 0) {
                    paint$Join0 = Paint.Join.MITER;
                }
                else if(v == 1) {
                    paint$Join0 = Paint.Join.ROUND;
                }
                else {
                    paint$Join0 = v == 2 ? Paint.Join.BEVEL : Paint.Join.MITER;
                }
                textPaint0.setStrokeJoin(paint$Join0);
                int v1 = ((i)e0).d;
                if(v1 == 0) {
                    paint$Cap0 = Paint.Cap.BUTT;
                }
                else if(v1 == 1) {
                    paint$Cap0 = Paint.Cap.ROUND;
                }
                else {
                    paint$Cap0 = v1 == 2 ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
                }
                textPaint0.setStrokeCap(paint$Cap0);
                ((i)e0).getClass();
                textPaint0.setPathEffect(null);
            }
        }
    }
}

