package com.facebook.login;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import com.facebook.login.widget.LoginButton.LoginClickListener;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPlaybackScheme;
import com.iloen.melon.fragments.cashfriends.CashFriendsFragment;
import com.iloen.melon.popup.MelonTextNCheckPopup;
import com.iloen.melon.utils.preference.MelonPrefs;
import kotlin.jvm.internal.q;
import m8.c;

public final class b implements DialogInterface.OnClickListener {
    public final int a;
    public final Object b;

    public b(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                DeviceAuthDialog.presentConfirmation$lambda$8(((DeviceAuthDialog)object0), dialogInterface0, v);
                return;
            }
            case 1: {
                LoginClickListener.a(((LoginManager)object0), dialogInterface0, v);
                return;
            }
            case 2: {
                com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1.d(((CashFriendsFragment)object0), dialogInterface0, v);
                return;
            }
            case 3: {
                if(-1 == v) {
                    q.e(dialogInterface0, "null cannot be cast to non-null type com.iloen.melon.popup.MelonTextNCheckPopup");
                    if(((MelonTextNCheckPopup)dialogInterface0).isCheckState()) {
                        MelonPrefs.getInstance().setString("NoticePopupSeq", ((String)object0));
                    }
                }
                return;
            }
            default: {
                if(v == -1) {
                    EventBusHelper.post(new EventPlaybackScheme(((c)object0).c1()));
                }
            }
        }
    }
}

