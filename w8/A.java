package W8;

import Q.e;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.fragment.app.I;
import com.iloen.melon.fragments.detail.ui.ListeningGraphKt;
import com.iloen.melon.fragments.detail.ui.ListeningUiState;
import com.iloen.melon.player.playlist.music.MusicPlaylistFragment;
import com.iloen.melon.player.playlist.music.SmartPlaylistFragment;
import com.iloen.melon.player.video.VideoLivePreviewComposablesKt;
import d8.d;
import de.c;
import hd.i;
import ie.H;
import java.util.List;
import jd.B2;
import jd.C2;
import kotlin.jvm.internal.q;
import ld.m;
import we.n;

public final class a implements n {
    public final int a;
    public final int b;
    public final Object c;

    public a(int v, e e0, int v1) {
        this.a = 4;
        super();
        this.b = v;
        this.c = e0;
    }

    public a(I i0, int v, int v1) {
        this.a = v1;
        this.b = v;
        this.c = i0;
        super();
    }

    public a(Object object0, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        V v0 = k.a;
        boolean z = false;
        H h0 = H.a;
        int v1 = this.b;
        Object object2 = this.c;
        switch(this.a) {
            case 0: {
                return ListeningGraphKt.d(((ListeningUiState)object2), v1, ((l)object0), ((int)(((Integer)object1))));
            }
            case 1: {
                ((Integer)object1).intValue();
                ((MusicPlaylistFragment)object2).UiWhenPlaylistEmpty(((l)object0), (v1 | 1) & -920350135 | ((0x24924924 & (v1 | 1)) >> 1 | 306783378 & (v1 | 1)) | (306783378 & (v1 | 1)) << 1 & (0x24924924 & (v1 | 1)));
                return h0;
            }
            case 2: {
                ((Integer)object1).intValue();
                ((SmartPlaylistFragment)object2).UiWhenPlaylistEmpty(((l)object0), (v1 | 1) & -920350135 | ((0x24924924 & (v1 | 1)) >> 1 | 306783378 & (v1 | 1)) | (306783378 & (v1 | 1)) << 1 & (0x24924924 & (v1 | 1)));
                return h0;
            }
            case 3: {
                ((Integer)object1).intValue();
                VideoLivePreviewComposablesKt.VideoLiveItems(((List)object2), ((l)object0), (v1 | 1) & -920350135 | ((0x24924924 & (v1 | 1)) >> 1 | 306783378 & (v1 | 1)) | (306783378 & (v1 | 1)) << 1 & (0x24924924 & (v1 | 1)));
                return h0;
            }
            case 4: {
                ((Integer)object1).getClass();
                e2.a.e(v1, ((e)object2), ((l)object0), 1);
                return h0;
            }
            case 5: {
                int v2 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v2 & 1, (v2 & 3) != 2)) {
                    int v3 = ((C2)object2).f;
                    boolean z1 = ((p)(((l)object0))).i(((C2)object2));
                    B2 b20 = ((p)(((l)object0))).N();
                    if(z1 || b20 == v0) {
                        b20 = new B2(((C2)object2), 1);
                        ((p)(((l)object0))).l0(b20);
                    }
                    d.g(v1, v3, b20, ((p)(((l)object0))), 0);
                    return h0;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
            case 6: {
                int v4 = (int)(((Integer)object1));
                if((v4 & 3) != 2) {
                    z = true;
                }
                if(((p)(((l)object0))).Q(v4 & 1, z)) {
                    a0 a00 = w.p(v1);
                    String[] arr_s = ((m)object2).getResources().getStringArray(0x7F03004C);  // array:sortingbar_type1
                    q.f(arr_s, "getStringArray(...)");
                    boolean z2 = ((p)(((l)object0))).i(((m)object2));
                    i i0 = ((p)(((l)object0))).N();
                    if(z2 || i0 == v0) {
                        i0 = new i(((m)object2), 17);
                        ((p)(((l)object0))).l0(i0);
                    }
                    x1.a.g(a00, arr_s, 0, 0.0f, 0.0f, i0, ((p)(((l)object0))), 0, 28);
                    return h0;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
            default: {
                ((Integer)object1).intValue();
                c.b(((zd.m)object2), ((l)object0), (v1 | 1) & -920350135 | ((0x24924924 & (v1 | 1)) >> 1 | 306783378 & (v1 | 1)) | (306783378 & (v1 | 1)) << 1 & (0x24924924 & (v1 | 1)));
                return h0;
            }
        }
    }
}

