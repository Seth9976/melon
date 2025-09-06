package com.iloen.melon.custom;

public interface MelonWebViewInterface {
    void darkChanged(boolean arg1);

    void doLoginNeedDlg();

    MelonWebView getWebView();

    void goHome(boolean arg1);

    boolean isToolbarVisible();

    void navigateBack();

    void showBlockedProgress(boolean arg1);

    void showNetworkDisabledPopup();

    void showProgress(boolean arg1);

    void showToolbar(boolean arg1, int arg2, int arg3, boolean arg4);
}

