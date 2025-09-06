package com.iloen.melon.player.playlist.music;

import com.melon.ui.K4;
import java.util.ArrayList;
import java.util.HashSet;
import je.p;
import kotlin.jvm.internal.q;
import we.k;

public final class l implements k {
    public final int a;
    public final k b;

    public l(int v, k k0) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        k k0 = this.b;
        if(this.a != 0) {
            q.g(((K4)object0), "prevState");
            return ((K4)object0) instanceof Success ? ((K4)k0.invoke(((K4)object0))) : ((K4)object0);
        }
        q.g(((K4)object0), "prevState");
        K4 k40 = (K4)k0.invoke(((K4)object0));
        if(((K4)object0) instanceof Success && k40 instanceof Success) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object1: ((Success)(((K4)object0))).getSongList()) {
                if(((SongUiState)object1).isSelected()) {
                    arrayList0.add(object1);
                }
            }
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object2: arrayList0) {
                arrayList1.add(((SongUiState)object2).getTrackId());
            }
            HashSet hashSet0 = p.N0(arrayList1);
            ArrayList arrayList2 = new ArrayList();
            for(Object object3: ((Success)(((K4)object0))).getSongList()) {
                if(((SongUiState)object3).isMarquee()) {
                    arrayList2.add(object3);
                }
            }
            ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList2));
            for(Object object4: arrayList2) {
                arrayList3.add(((SongUiState)object4).getTrackId());
            }
            HashSet hashSet1 = p.N0(arrayList3);
            Iterable iterable0 = ((Success)k40).getSongList();
            ArrayList arrayList4 = new ArrayList(je.q.Q(10, iterable0));
            for(Object object5: iterable0) {
                String s = ((SongUiState)object5).getTrackId();
                arrayList4.add(SongUiState.copy$default(((SongUiState)object5), null, null, null, null, null, hashSet0.contains(s), hashSet1.contains(s), false, false, null, 0x39F, null));
            }
            return Success.copy$default(((Success)k40), null, false, false, null, null, arrayList4, 0, ((Success)(((K4)object0))).getSectionSelectState(), 0x5F, null);
        }
        return k40;
    }
}

