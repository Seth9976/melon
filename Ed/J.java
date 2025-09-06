package ed;

import J8.L2;
import Nc.h1;
import android.widget.LinearLayout;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes.Contents;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import java.util.List;
import je.p;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import we.a;
import we.k;

public final class j implements k {
    public final F a;
    public final List b;
    public final boolean c;
    public final H d;
    public final a e;
    public final ed.Z.a f;
    public final float g;
    public final int h;

    public j(F f0, List list0, boolean z, H h0, a a0, ed.Z.a z$a0, float f1, int v) {
        this.a = f0;
        this.b = list0;
        this.c = z;
        this.d = h0;
        this.e = a0;
        this.f = z$a0;
        this.g = f1;
        this.h = v;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s;
        q.g(((L2)object0), "$this$AndroidViewBinding");
        LinearLayout linearLayout0 = ((L2)object0).d;
        F f0 = this.a;
        ((L2)object0).e.setText(String.valueOf(f0.a + 1));
        MelonTextView melonTextView0 = ((L2)object0).c;
        List list0 = this.b;
        if(list0 == null) {
            s = "";
        }
        else {
            Contents searchHotKeywordAndMenuListRes$Contents0 = (Contents)p.n0(f0.a, list0);
            if(searchHotKeywordAndMenuListRes$Contents0 == null) {
                s = "";
            }
            else {
                s = searchHotKeywordAndMenuListRes$Contents0.keyword;
                if(s == null) {
                    s = "";
                }
            }
        }
        melonTextView0.setText(s);
        ViewUtilsKt.setAccessibilityButtonClassName(melonTextView0);
        ed.Z.a z$a0 = this.f;
        com.iloen.melon.fragments.present.a a0 = new com.iloen.melon.fragments.present.a(7, this.e, z$a0);
        ((L2)object0).b.setOnClickListener(a0);
        linearLayout0.setOnClickListener(new com.iloen.melon.fragments.present.a(8, ((L2)object0), z$a0));
        if(this.c) {
            this.d.a = new h1(((L2)object0), this.g);
        }
        linearLayout0.setAccessibilityDelegate(new y(z$a0, f0, this.h, list0, ((L2)object0)));
        return ie.H.a;
    }
}

