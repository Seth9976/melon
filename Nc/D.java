package nc;

import com.iloen.melon.playback.playlist.add.DrawerAddRequestPlayableListInfo;
import kotlin.jvm.internal.C;
import oe.c;

public final class d extends c {
    public Object B;
    public final u0 D;
    public int E;
    public DrawerAddRequestPlayableListInfo r;
    public C w;

    public d(u0 u00, c c0) {
        this.D = u00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.j(null, this);
    }
}

