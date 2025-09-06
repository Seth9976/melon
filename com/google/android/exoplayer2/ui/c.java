package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import i.n.i.b.a.s.e.E4;
import i.n.i.b.a.s.e.Kd;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.Md;
import i.n.i.b.a.s.e.W2;
import i.n.i.b.a.s.e.qe;
import i.n.i.b.a.s.e.v3;
import java.util.List;

public final class c implements DialogCallback, v3 {
    public final int a;
    public final int b;
    public final Object c;
    public final Object d;
    public final Object e;

    public c(Object object0, Object object1, int v, Object object2, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.b = v;
        this.e = object2;
        super();
    }

    @Override  // i.n.i.b.a.s.e.v3
    public W2 b(W2 w20) {
        switch(this.a) {
            case 1: {
                return M7.e(((Md)this.c), w20, ((Kd)this.d), this.b, ((E4)this.e));
            }
            case 2: {
                E4 e41 = (E4)this.e;
                Md md1 = ((qe)this.c).h;
                return this.d instanceof Kd ? M7.e(md1, w20, ((Kd)this.d), this.b, e41) : M7.e(md1, w20, Kd.c, this.b, e41);
            }
            default: {
                Md md0 = (Md)this.c;
                E4 e40 = (E4)this.e;
                return this.d instanceof Kd ? M7.e(md0, w20, ((Kd)this.d), this.b, e40) : M7.e(md0, w20, Kd.c, this.b, e40);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder$DialogCallback
    public void onTracksSelected(boolean z, List list0) {
        TrackSelectionDialogBuilder.lambda$new$0(((DefaultTrackSelector)this.c), ((Parameters)this.d), this.b, ((TrackGroupArray)this.e), z, list0);
    }
}

