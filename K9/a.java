package k9;

import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.HashMap;
import java.util.function.Consumer;
import kc.d3;
import oc.H;

public final class a implements Consumer {
    public final int a;
    public final Object b;

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void accept(Object object0) {
        if(this.a != 0) {
            PlaylistId playlistId0 = ((H)object0).getId();
            ((d3)this.b).A(playlistId0, false);
            return;
        }
        ((HashMap)this.b).remove(((String)object0));
    }
}

