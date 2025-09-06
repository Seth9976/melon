package U8;

import androidx.compose.runtime.b0;
import com.iloen.melon.lyric.LyricsInfo;
import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import kotlin.jvm.internal.C;
import qd.O;
import we.a;
import we.k;

public final class h implements a {
    public final int a;
    public final boolean b;
    public final k c;
    public final int d;
    public final Object e;
    public final Object f;

    public h(b0 b00, int v, C c0, k k0, boolean z) {
        this.a = 0;
        super();
        this.e = b00;
        this.d = v;
        this.f = c0;
        this.c = k0;
        this.b = z;
    }

    public h(w0.h h0, boolean z, k k0, int v, LyricsInfo lyricsInfo0) {
        this.a = 1;
        super();
        this.e = h0;
        this.b = z;
        this.c = k0;
        this.d = v;
        this.f = lyricsInfo0;
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            w0.h.a(((w0.h)this.e));
            if(this.b) {
                ToastManager.showShort(0x7F130813);  // string:player_lyric_seekmode_need_full_song "선택 구간의 가사 탐색은 전곡 듣기에서 가능합니다."
                return H.a;
            }
            O o0 = new O(this.d, ((LyricsInfo)this.f).a);
            this.c.invoke(o0);
            return H.a;
        }
        b0 b00 = (b0)this.e;
        int v = ((Number)b00.getValue()).intValue();
        k k0 = this.c;
        int v1 = this.d;
        if(v != v1) {
            ((C)this.f).a = true;
            k0.invoke(v1);
            b00.setValue(v1);
            return H.a;
        }
        if(this.b) {
            k0.invoke(v1);
        }
        return H.a;
    }
}

