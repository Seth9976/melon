package com.iloen.melon.fragments.comments;

import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;

public final class e implements DialogInterface.OnDismissListener {
    public final int a;
    public final CmtBaseFragment b;

    public e(CmtBaseFragment cmtBaseFragment0, int v) {
        this.a = v;
        this.b = cmtBaseFragment0;
        super();
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface0) {
        if(this.a != 0) {
            CommentListRenewalFragment.initInputPopup$lambda$19$lambda$18(((CommentListRenewalFragment)this.b), dialogInterface0);
            return;
        }
        ((AdcmtListFragment)this.b).lambda$initInputPopup$3(dialogInterface0);
    }
}

