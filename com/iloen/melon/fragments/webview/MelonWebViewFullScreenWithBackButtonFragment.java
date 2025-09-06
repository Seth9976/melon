package com.iloen.melon.fragments.webview;

import B.a;
import android.view.View;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.detail.viewholder.p;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0003J\u000F\u0010\t\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0019\u0010\f\u001A\u00020\u00072\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\r¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewFullScreenWithBackButtonFragment;", "Lcom/iloen/melon/fragments/webview/MelonWebViewFullScreenFragment;", "<init>", "()V", "", "isScreenLandscapeSupported", "()Z", "Lie/H;", "restoreScreenRotation", "shouldShowMiniPlayer", "", "title", "setWebviewTitleBar", "(Ljava/lang/String;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonWebViewFullScreenWithBackButtonFragment extends MelonWebViewFullScreenFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewFullScreenWithBackButtonFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/webview/MelonWebViewFullScreenWithBackButtonFragment;", "item", "Lcom/iloen/melon/fragments/webview/MelonWebViewFullScreenFragment$ParamItem;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MelonWebViewFullScreenWithBackButtonFragment newInstance(@Nullable ParamItem melonWebViewFullScreenFragment$ParamItem0) {
            MelonWebViewFullScreenWithBackButtonFragment melonWebViewFullScreenWithBackButtonFragment0 = new MelonWebViewFullScreenWithBackButtonFragment();
            melonWebViewFullScreenWithBackButtonFragment0.setArguments(MelonWebViewFullScreenFragment.createBundleArguments(melonWebViewFullScreenFragment$ParamItem0));
            return melonWebViewFullScreenWithBackButtonFragment0;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;

    static {
        MelonWebViewFullScreenWithBackButtonFragment.Companion = new Companion(null);
        MelonWebViewFullScreenWithBackButtonFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    @NotNull
    public static final MelonWebViewFullScreenWithBackButtonFragment newInstance(@Nullable ParamItem melonWebViewFullScreenFragment$ParamItem0) {
        return MelonWebViewFullScreenWithBackButtonFragment.Companion.newInstance(melonWebViewFullScreenFragment$ParamItem0);
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment
    public void restoreScreenRotation() {
        ViewUtils.setOrientation(this.getActivity(), 1);
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment
    public void setWebviewTitleBar(@Nullable String s) {
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.t(4, new p(this, 10)));
            titleBar0.setBackgroundColor(0);
            titleBar0.f(false);
            titleBar0.setTitle(s);
        }
    }

    private static final void setWebviewTitleBar$lambda$1$lambda$0(MelonWebViewFullScreenWithBackButtonFragment melonWebViewFullScreenWithBackButtonFragment0, View view0) {
        melonWebViewFullScreenWithBackButtonFragment0.historyBack();
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment
    public boolean shouldShowMiniPlayer() {
        return true;
    }

    public static void t0(MelonWebViewFullScreenWithBackButtonFragment melonWebViewFullScreenWithBackButtonFragment0, View view0) {
        MelonWebViewFullScreenWithBackButtonFragment.setWebviewTitleBar$lambda$1$lambda$0(melonWebViewFullScreenWithBackButtonFragment0, view0);
    }
}

