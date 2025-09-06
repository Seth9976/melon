package Cc;

import ac.d;
import androidx.compose.runtime.b1;
import com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt;
import com.melon.ui.J4;
import com.melon.ui.K4;
import e.k;
import e1.G;
import ed.J;
import ed.s0;
import ed.t0;
import je.w;
import we.a;

public final class b0 implements a {
    public final int a;
    public final b1 b;

    public b0(b1 b10, int v) {
        this.a = v;
        this.b = b10;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                Boolean boolean0 = (Boolean)this.b.getValue();
                boolean0.getClass();
                return boolean0;
            }
            case 1: {
                return (z)this.b.getValue();
            }
            case 2: {
                return (z)this.b.getValue();
            }
            case 3: {
                return (z)this.b.getValue();
            }
            case 4: {
                return (z)this.b.getValue();
            }
            case 5: {
                return Boolean.valueOf(PlaylistCommonSongListComposableKt.access$topButtonManagingNestedScrollConnection$lambda$46(this.b));
            }
            case 6: {
                K4 k40 = (K4)this.b.getValue();
                if(k40 instanceof t0) {
                    return J.a;
                }
                if(k40 instanceof J4) {
                    return J.a;
                }
                return k40 instanceof s0 ? J.b : J.c;
            }
            case 7: {
                K4 k41 = (K4)this.b.getValue();
                if(k41 instanceof t0) {
                    return ((t0)k41).a;
                }
                return k41 instanceof s0 ? k.z(((s0)k41).a) : w.a;
            }
            case 8: {
                Boolean boolean1 = (Boolean)this.b.getValue();
                boolean1.booleanValue();
                return boolean1;
            }
            case 9: {
                return G.e(((d)this.b.getValue()));
            }
            case 10: {
                return ((Number)this.b.getValue()).floatValue();
            }
            case 11: {
                return ((Number)this.b.getValue()).floatValue();
            }
            default: {
                return G.e(((d)this.b.getValue()));
            }
        }
    }
}

