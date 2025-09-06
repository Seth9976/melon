package w8;

import B2.a;
import E9.h;
import V4.u;
import android.content.Context;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import oc.M;
import we.n;

public final class v implements n {
    public final M a;
    public final boolean b;
    public final float c;
    public final Context d;

    public v(M m0, boolean z, float f, Context context0) {
        this.a = m0;
        this.b = z;
        this.c = f;
        this.d = context0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v2;
        int v1;
        int v = (int)(((Integer)object1));
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            M m0 = this.a;
            switch(m0.ordinal()) {
                case 1: {
                    v1 = 0x7F0802A6;  // drawable:btn_widget_replay_on
                    break;
                }
                case 2: {
                    v1 = 0x7F0802A7;  // drawable:btn_widget_replay_one
                    break;
                }
                default: {
                    v1 = this.b ? 0x7F0802A8 : 0x7F0802A5;  // drawable:btn_widget_replay_w
                }
            }
            switch(m0.ordinal()) {
                case 1: {
                    v2 = 0x7F130C20;  // string:talkback_repeat_all "전체 음악 반복중, 변경"
                    break;
                }
                case 2: {
                    v2 = 0x7F130C22;  // string:talkback_repeat_one "현재 음악 반복중, 변경"
                    break;
                }
                default: {
                    v2 = 0x7F130C21;  // string:talkback_repeat_none "반복 안 함, 변경"
                }
            }
            B2.n n0 = u.G(this.c);
            h.g(new a(v1), this.d.getString(v2), n0, 0, ((p)(((l)object0))), 0, 24);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

