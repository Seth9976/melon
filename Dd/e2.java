package Dd;

import Cb.j;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistInformCntCheckRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistInformCntCheckRes;
import com.iloen.melon.utils.Navigator;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.q4;
import com.melon.ui.t4;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class e2 extends i implements n {
    public final MyMusicPlaylistInformCntCheckRes r;
    public final g1 w;

    public e2(MyMusicPlaylistInformCntCheckRes myMusicPlaylistInformCntCheckRes0, g1 g10, Continuation continuation0) {
        this.r = myMusicPlaylistInformCntCheckRes0;
        this.w = g10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e2(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((e2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        g1 g10 = this.w;
        StringProviderImpl stringProviderImpl0 = g10.c;
        d5.n.D(object0);
        Notification httpResponse$Notification0 = null;
        MyMusicPlaylistInformCntCheckRes myMusicPlaylistInformCntCheckRes0 = this.r;
        H h0 = H.a;
        if(Cb.i.l((myMusicPlaylistInformCntCheckRes0 == null ? null : myMusicPlaylistInformCntCheckRes0.notification))) {
            if(myMusicPlaylistInformCntCheckRes0 != null) {
                httpResponse$Notification0 = myMusicPlaylistInformCntCheckRes0.notification;
            }
            j.b(httpResponse$Notification0, false, 3);
            return h0;
        }
        if(myMusicPlaylistInformCntCheckRes0 != null && j.d(myMusicPlaylistInformCntCheckRes0)) {
            RESPONSE myMusicPlaylistInformCntCheckRes$RESPONSE0 = myMusicPlaylistInformCntCheckRes0.response;
            if(myMusicPlaylistInformCntCheckRes$RESPONSE0 != null) {
                httpResponse$Notification0 = myMusicPlaylistInformCntCheckRes$RESPONSE0.cntoverYn;
            }
            if("N".equals(httpResponse$Notification0)) {
                Navigator.open(PlaylistMakeFragment.newInstance("", "M20001", "mymusicPlaylistNewMake"));
                return h0;
            }
            g10.sendUiEvent(new q4(28, stringProviderImpl0.a(0x7F1300D0), stringProviderImpl0.a(0x7F13077A), null, null));  // string:alert_dlg_title_info "안내"
            return h0;
        }
        g10.sendUiEvent(new t4(stringProviderImpl0.a(0x7F1303C6)));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        return h0;
    }
}

