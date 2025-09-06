package Cc;

import android.database.SQLException;
import com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment;
import com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel;
import h7.u0;
import ie.H;
import we.a;
import we.k;
import z4.g;

public final class o1 implements a {
    public final int a;
    public final boolean b;
    public final Object c;

    public o1(Object object0, boolean z, int v) {
        this.a = v;
        this.c = object0;
        this.b = z;
        super();
    }

    public o1(boolean z, MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0) {
        this.a = 1;
        super();
        this.b = z;
        this.c = mixUpPlaylistComposeFragment0;
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        boolean z = this.b;
        Object object0 = this.c;
        switch(this.a) {
            case 0: {
                ((k)object0).invoke(Boolean.valueOf(!z));
                return h0;
            }
            case 1: {
                if(z) {
                    ((MixUpPlaylistComposeFragment)object0).n().logClickUnselectAll();
                }
                else {
                    ((MixUpPlaylistComposeFragment)object0).n().logClickSelectAll();
                }
                ((MixUpPlaylistComposeViewModel)((MixUpPlaylistComposeFragment)object0).getViewModel()).toggleSelectAll();
                return h0;
            }
            default: {
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append("Timed out attempting to acquire a " + (z ? "reader" : "writer") + " connection.");
                stringBuilder0.append("\n\nWriter pool:\n");
                ((g)object0).b.d(stringBuilder0);
                stringBuilder0.append("Reader pool:");
                stringBuilder0.append('\n');
                ((g)object0).a.d(stringBuilder0);
                try {
                    u0.S(5, stringBuilder0.toString());
                    throw null;
                }
                catch(SQLException sQLException0) {
                    sQLException0.printStackTrace();
                    return h0;
                }
            }
        }
    }
}

