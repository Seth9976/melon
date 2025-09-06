package com.iloen.melon.utils.ui;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import com.iloen.melon.net.HttpResponse.Notification.Buttons;
import com.iloen.melon.popup.MelonTextPopup;

public final class b implements DialogInterface.OnClickListener {
    public final int a;
    public final Buttons b;
    public final Buttons c;
    public final MelonTextPopup d;

    public b(int v, Buttons httpResponse$Notification$Buttons0, MusicBrowserPopupHelper musicBrowserPopupHelper0, Buttons httpResponse$Notification$Buttons1, MelonTextPopup melonTextPopup0) {
        this.a = v;
        this.b = httpResponse$Notification$Buttons0;
        this.c = httpResponse$Notification$Buttons1;
        this.d = melonTextPopup0;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        Buttons httpResponse$Notification$Buttons0 = this.b;
        if(this.a != 1) {
            if(v != -2) {
                Buttons httpResponse$Notification$Buttons1 = this.c;
                if(httpResponse$Notification$Buttons1 != null) {
                    MusicBrowserPopupHelper.d(httpResponse$Notification$Buttons1.linkUri);
                }
            }
            else if(httpResponse$Notification$Buttons0 != null) {
                MusicBrowserPopupHelper.d(httpResponse$Notification$Buttons0.linkUri);
            }
        }
        else if(v == -1 && httpResponse$Notification$Buttons0 != null) {
            MusicBrowserPopupHelper.d(httpResponse$Notification$Buttons0.linkUri);
        }
        this.d.dismiss();
    }
}

