package id;

import Kd.g;
import com.iloen.melon.utils.Navigator;
import ie.H;
import we.a;

public final class n implements a {
    public final int a;
    public final g b;

    public n(g g0, int v) {
        this.a = v;
        this.b = g0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            Navigator.openAlbumInfo(this.b.c);
            return H.a;
        }
        Navigator.openSongInfo(this.b.a);
        return H.a;
    }
}

