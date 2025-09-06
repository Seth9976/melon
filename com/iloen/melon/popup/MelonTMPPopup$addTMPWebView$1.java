package com.iloen.melon.popup;

import com.iloen.melon.custom.MelonWebView;
import com.iloen.melon.custom.MelonWebViewInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u001A\u001A\u00020\u000B2\u0006\u0010\u0019\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u001A\u0010\u0011¨\u0006\u001B"}, d2 = {"com/iloen/melon/popup/MelonTMPPopup$addTMPWebView$1", "Lcom/iloen/melon/custom/MelonWebViewInterface;", "Lcom/iloen/melon/custom/MelonWebView;", "getWebView", "()Lcom/iloen/melon/custom/MelonWebView;", "", "show", "", "type", "count", "bEditMode", "Lie/H;", "showToolbar", "(ZIIZ)V", "isToolbarVisible", "()Z", "showProgress", "(Z)V", "showBlockedProgress", "doLoginNeedDlg", "()V", "showNetworkDisabledPopup", "navigateBack", "reset", "goHome", "isDark", "darkChanged", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonTMPPopup.addTMPWebView.1 implements MelonWebViewInterface {
    public final MelonTMPPopup a;

    public MelonTMPPopup.addTMPWebView.1(MelonTMPPopup melonTMPPopup0) {
        this.a = melonTMPPopup0;
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void darkChanged(boolean z) {
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void doLoginNeedDlg() {
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public MelonWebView getWebView() {
        return new MelonWebView(this.a.getContext());
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void goHome(boolean z) {
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public boolean isToolbarVisible() {
        return false;
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void navigateBack() {
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void showBlockedProgress(boolean z) {
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void showNetworkDisabledPopup() {
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void showProgress(boolean z) {
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface
    public void showToolbar(boolean z, int v, int v1, boolean z1) {
    }
}

