package k1;

import X.k;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.runtime.E;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import i1.i;
import x0.e;
import y0.O;

public final class d extends CharacterStyle implements UpdateAppearance {
    public final O a;
    public final float b;
    public final b0 c;
    public final E d;

    public d(O o0, float f) {
        this.a = o0;
        this.b = f;
        this.c = w.s(new e(0x7FC000007FC00000L));
        this.d = w.i(new k(this, 19));
    }

    @Override  // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint0) {
        i.b(textPaint0, this.b);
        textPaint0.setShader(((Shader)this.d.getValue()));
    }
}

