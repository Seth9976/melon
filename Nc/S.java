package nc;

import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import java.util.List;
import oe.c;

public final class s extends c {
    public u0 B;
    public u0 D;
    public boolean E;
    public int G;
    public Object I;
    public final u0 M;
    public int N;
    public List r;
    public DrawerPlaylistInfo w;

    public s(u0 u00, c c0) {
        this.M = u00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.I = object0;
        this.N |= 0x80000000;
        return this.M.J(null, null, false, this);
    }
}

