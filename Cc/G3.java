package Cc;

import U.c0;
import androidx.compose.runtime.b0;
import com.iloen.melon.utils.system.ToastManager;
import f1.x;
import gd.i7;
import ie.H;
import kotlin.jvm.internal.q;
import w0.h;
import we.k;

public final class g3 implements k {
    public final int a;
    public final k b;
    public final b0 c;
    public final h d;

    public g3(h h0, k k0, b0 b00) {
        this.a = 0;
        super();
        this.d = h0;
        this.b = k0;
        this.c = b00;
    }

    public g3(k k0, b0 b00, h h0) {
        this.a = 1;
        super();
        this.b = k0;
        this.c = b00;
        this.d = h0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((c0)object0), "$this$KeyboardActions");
            i7 i70 = new i7(((x)this.c.getValue()).a.b, "", "btn", 0, true);
            this.b.invoke(i70);
            x x0 = new x("", 0L, 6);
            this.c.setValue(x0);
            h.a(this.d);
            return H.a;
        }
        q.g(((c0)object0), "$this$KeyboardActions");
        b0 b00 = this.c;
        if(((String)b00.getValue()).length() > 0) {
            h.a(this.d);
            k k0 = this.b;
            if(k0 != null) {
                k0.invoke(((String)b00.getValue()));
                return H.a;
            }
        }
        else {
            ToastManager.show(0x7F1308E5);  // string:search_bottom_tab_search_hint "검색어를 입력하세요"
        }
        return H.a;
    }
}

