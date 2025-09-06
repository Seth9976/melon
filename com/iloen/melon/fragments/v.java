package com.iloen.melon.fragments;

import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;

public final class v implements DialogInterface.OnShowListener {
    public final MelonBottomSheetBaseFragment a;

    public v(MelonBottomSheetBaseFragment melonBottomSheetBaseFragment0) {
        this.a = melonBottomSheetBaseFragment0;
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public final void onShow(DialogInterface dialogInterface0) {
        MelonBottomSheetBaseFragment.onCreateDialog$lambda$0(this.a, dialogInterface0);
    }
}

