package com.iloen.melon.player.playlist.search;

import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.t4;
import ie.H;
import kotlin.jvm.internal.q;
import oc.S;
import oc.U;
import we.k;

public final class e implements k {
    public final int a;
    public final PlaylistSearchViewModel b;

    public e(PlaylistSearchViewModel playlistSearchViewModel0, int v) {
        this.a = v;
        this.b = playlistSearchViewModel0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        PlaylistSearchViewModel playlistSearchViewModel0 = this.b;
        if(this.a != 0) {
            q.g(((U)object0), "removeResult");
            if(((U)object0) instanceof S && !((S)(((U)object0))).b) {
                playlistSearchViewModel0.sendUiEvent(new t4(((StringProviderImpl)playlistSearchViewModel0.i).a(0x7F1303C6)));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
            return h0;
        }
        q.g(((U)object0), "removeResult");
        if(((U)object0) instanceof S && !((S)(((U)object0))).b) {
            playlistSearchViewModel0.sendUiEvent(new t4(((StringProviderImpl)playlistSearchViewModel0.i).a(0x7F1303C6)));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        }
        return h0;
    }
}

