package a3;

import androidx.media3.session.o1;
import b3.P;
import e3.e;
import e3.j;

public final class a implements e, j {
    public final int a;
    public final boolean b;

    public a(boolean z, int v) {
        this.a = v;
        this.b = z;
        super();
    }

    @Override  // e3.e
    public void accept(Object object0) {
        switch(this.a) {
            case 4: {
                ((o1)object0).setPlayWhenReady(this.b);
                return;
            }
            case 5: {
                ((o1)object0).q(this.b);
                return;
            }
            default: {
                ((o1)object0).setShuffleModeEnabled(this.b);
            }
        }
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        switch(this.a) {
            case 0: {
                ((P)object0).onIsPlayingChanged(this.b);
                return;
            }
            case 1: {
                ((P)object0).onShuffleModeEnabledChanged(this.b);
                return;
            }
            case 2: {
                ((P)object0).S(this.b);
                return;
            }
            default: {
                ((P)object0).onShuffleModeEnabledChanged(this.b);
            }
        }
    }
}

