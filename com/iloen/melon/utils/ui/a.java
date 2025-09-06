package com.iloen.melon.utils.ui;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import com.iloen.melon.net.v4x.response.MainNoticePopupRes.Response.NoticePopup.BANON;
import com.iloen.melon.net.v4x.response.MainNoticePopupRes.Response.NoticePopup;
import com.iloen.melon.popup.MelonTextNCheckPopup;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

public final class a implements DialogInterface.OnClickListener {
    public final NoticePopup a;
    public final MusicBrowserPopupHelper b;

    public a(MusicBrowserPopupHelper musicBrowserPopupHelper0, NoticePopup mainNoticePopupRes$Response$NoticePopup0) {
        this.a = mainNoticePopupRes$Response$NoticePopup0;
        this.b = musicBrowserPopupHelper0;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        if(-1 == v) {
            q.e(dialogInterface0, "null cannot be cast to non-null type com.iloen.melon.popup.MelonTextNCheckPopup");
            if(((MelonTextNCheckPopup)dialogInterface0).isCheckState()) {
                NoticePopup mainNoticePopupRes$Response$NoticePopup0 = this.a;
                BANON mainNoticePopupRes$Response$NoticePopup$BANON0 = mainNoticePopupRes$Response$NoticePopup0.banon;
                if(mainNoticePopupRes$Response$NoticePopup$BANON0 != null) {
                    BuildersKt__Builders_commonKt.launch$default(this.b.g(), null, null, new MusicBrowserPopupHelper.showNoticePopupWithOption.1.1.1(this.b, mainNoticePopupRes$Response$NoticePopup0, mainNoticePopupRes$Response$NoticePopup$BANON0, null), 3, null);
                }
            }
        }
    }
}

