package com.iloen.melon.fragments.comments;

import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;

public final class d implements DialogInterface.OnShowListener {
    public final int a;
    public final CmtBaseFragment b;

    public d(CmtBaseFragment cmtBaseFragment0, int v) {
        this.a = v;
        this.b = cmtBaseFragment0;
        super();
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public final void onShow(DialogInterface dialogInterface0) {
        if(this.a != 0) {
            CommentListRenewalFragment.initInputPopup$lambda$19$lambda$17(((CommentListRenewalFragment)this.b), dialogInterface0);
            return;
        }
        ((AdcmtListFragment)this.b).lambda$initInputPopup$2(dialogInterface0);
    }
}

