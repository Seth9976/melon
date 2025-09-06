package w8;

import B2.a;
import E9.h;
import android.content.Context;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import we.n;

public final class l0 implements n {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final Context d;
    public final B2.n e;

    public l0(boolean z, boolean z1, boolean z2, Context context0, B2.n n0) {
        this.a = z;
        this.b = z1;
        this.c = z2;
        this.d = context0;
        this.e = n0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v1;
        int v = (int)(((Integer)object1));
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            if(this.a) {
                ((p)(((l)object0))).a0(0x27E51819);
            }
            else {
                ((p)(((l)object0))).a0(0x287093BD);
                boolean z = this.b;
                boolean z1 = this.c;
                if(!z) {
                    v1 = z1 ? 0x7F0802A2 : 0x7F0802A1;  // drawable:btn_widget_play_w
                }
                else if(z1) {
                    v1 = 0x7F0802A0;  // drawable:btn_widget_pause_w
                }
                else {
                    v1 = 0x7F08029F;  // drawable:btn_widget_pause_b
                }
                h.g(new a(v1), this.d.getString((z ? 0x7F130BD2 : 0x7F130BB4)), this.e, 0, ((p)(((l)object0))), 0, 24);  // string:talkback_player_pause "일시정지"
            }
            ((p)(((l)object0))).p(false);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

