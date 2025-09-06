package com.iloen.melon.fragments.cashfriends;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

public final class a implements DialogInterface.OnClickListener {
    public final int a;
    public final we.a b;

    public a(int v, we.a a0) {
        this.a = v;
        this.b = a0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        if(this.a != 0) {
            com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1.c(this.b, dialogInterface0, v);
            return;
        }
        com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1.e(this.b, dialogInterface0, v);
    }
}

