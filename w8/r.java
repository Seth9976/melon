package w8;

import B2.a;
import E9.h;
import V4.u;
import android.content.Context;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import we.n;

public final class r implements n {
    public final boolean a;
    public final boolean b;
    public final float c;
    public final Context d;

    public r(boolean z, boolean z1, float f, Context context0) {
        this.a = z;
        this.b = z1;
        this.c = f;
        this.d = context0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v1;
        int v = (int)(((Integer)object1));
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            boolean z = this.a;
            if(z) {
                v1 = 0x7F0802AE;  // drawable:btn_widget_shuffle_on
            }
            else {
                v1 = this.b ? 0x7F0802AF : 0x7F0802AD;  // drawable:btn_widget_shuffle_w
            }
            B2.n n0 = u.G(this.c);
            h.g(new a(v1), this.d.getString((z ? 0x7F130C4D : 0x7F130C4C)), n0, 0, ((p)(((l)object0))), 0, 24);  // string:talkback_shuffle_on "셔플 사용중, 변경"
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

