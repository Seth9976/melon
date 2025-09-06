package androidx.compose.ui.text.font;

import J0.f;
import R1.j;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import de.c;
import e1.H;
import e1.J;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import t1.a;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class AndroidFontLoader {
    public final Context a;

    public AndroidFontLoader(@NotNull Context context0) {
        this.a = context0.getApplicationContext();
    }

    public final Typeface a(H h0) {
        if(h0 instanceof H) {
            h0.getClass();
            Context context0 = this.a;
            Typeface typeface0 = j.a(context0, h0.a);
            q.d(typeface0);
            ArrayList arrayList0 = h0.c.a;
            if(typeface0 != null) {
                if(arrayList0.isEmpty()) {
                    return typeface0;
                }
                ThreadLocal threadLocal0 = J.a;
                Paint paint0 = (Paint)threadLocal0.get();
                if(paint0 == null) {
                    paint0 = new Paint();
                    threadLocal0.set(paint0);
                }
                paint0.setFontVariationSettings(null);
                paint0.setTypeface(typeface0);
                paint0.setFontVariationSettings(a.a(arrayList0, null, new f(c.c(context0), 1), 0x1F));
                return paint0.getTypeface();
            }
        }
        return null;
    }
}

