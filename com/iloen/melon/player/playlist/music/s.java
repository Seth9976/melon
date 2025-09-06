package com.iloen.melon.player.playlist.music;

import androidx.compose.runtime.l;
import com.iloen.melon.popup.MalrangServiceGuidePopupKt;
import ie.H;
import we.a;
import we.n;

public final class s implements n {
    public final int a;
    public final a b;
    public final a c;
    public final int d;
    public final int e;

    public s(a a0, a a1, int v, int v1, int v2) {
        this.a = v2;
        this.b = a0;
        this.c = a1;
        this.d = v;
        this.e = v1;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).intValue();
        if(this.a != 0) {
            MalrangServiceGuidePopupKt.BottomSheetDialogScreen(this.b, this.c, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)), this.e);
            return H.a;
        }
        SmartPlaylistFragmentKt.SmartPlaylistEmptyView(this.b, this.c, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)), this.e);
        return H.a;
    }
}

