package nc;

import com.iloen.melon.playback.playlist.add.DrawerAddRequestPlayableListInfo;
import oe.c;

public final class g extends c {
    public final u0 B;
    public int D;
    public DrawerAddRequestPlayableListInfo r;
    public Object w;

    public g(u0 u00, c c0) {
        this.B = u00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.s(null, this);
    }
}

