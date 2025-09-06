package m9;

import com.iloen.melon.player.playlist.tiara.MixUpPlaylistViewImpLogHelper;
import com.melon.ui.interfaces.StringProviderImpl;
import we.a;

public final class q implements a {
    public final int a;
    public final MixUpPlaylistViewImpLogHelper b;

    public q(MixUpPlaylistViewImpLogHelper mixUpPlaylistViewImpLogHelper0, int v) {
        this.a = v;
        this.b = mixUpPlaylistViewImpLogHelper0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return ((StringProviderImpl)this.b.a).a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
    }
}

