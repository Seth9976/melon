package com.iloen.melon.popup;

import android.app.Dialog;

public interface RetainPopup {
    void dismissRetainedPopup();

    Dialog getRetainedDialog();

    boolean isRetainedPopupShowing();

    void setRetainDialog(Dialog arg1);
}

