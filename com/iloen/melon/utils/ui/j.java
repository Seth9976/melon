package com.iloen.melon.utils.ui;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import com.iloen.melon.net.v4x.response.NotificationLoginRes.Response.Promotion.BANON;
import com.iloen.melon.net.v4x.response.NotificationLoginRes.Response.Promotion;
import com.iloen.melon.popup.MelonTMPPopup;
import com.iloen.melon.utils.log.LogU;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

public final class j implements DialogInterface.OnClickListener {
    public final Promotion a;
    public final MusicBrowserPopupHelper b;
    public final String c;

    public j(Promotion notificationLoginRes$Response$Promotion0, MusicBrowserPopupHelper musicBrowserPopupHelper0, String s) {
        this.a = notificationLoginRes$Response$Promotion0;
        this.b = musicBrowserPopupHelper0;
        this.c = s;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        if(-1 == v) {
            q.e(dialogInterface0, "null cannot be cast to non-null type com.iloen.melon.popup.MelonTMPPopup");
            if(((MelonTMPPopup)dialogInterface0).isCheckState()) {
                BANON notificationLoginRes$Response$Promotion$BANON0 = this.a.banOn;
                if(notificationLoginRes$Response$Promotion$BANON0 != null) {
                    String s = notificationLoginRes$Response$Promotion$BANON0.id;
                    LogU.Companion.d("MusicBrowserPopupHelper", "showLoginPopup() popupId: " + s);
                    BuildersKt__Builders_commonKt.launch$default(this.b.g(), null, null, new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1.2.1.1(this.b, this.c, s, notificationLoginRes$Response$Promotion$BANON0, null), 3, null);
                }
            }
        }
    }
}

