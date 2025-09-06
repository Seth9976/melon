package com.iloen.melon.fragments.webview;

import A8.M;
import Tf.a;
import android.os.Bundle;
import android.view.View;
import com.iloen.melon.custom.MelonWebView;
import com.iloen.melon.utils.ContentValuesEncodedUtils;
import com.iloen.melon.utils.NameValuePairList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016J\b\u0010\u0006\u001A\u00020\u0005H\u0014¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewDefaultMiniPlayerFragment;", "Lcom/iloen/melon/fragments/webview/MelonWebViewFragment;", "<init>", "()V", "shouldShowMiniPlayer", "", "hasCloseOrBackButton", "Companion", "BuyingGoodsFragment", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class MelonWebViewDefaultMiniPlayerFragment extends MelonWebViewFragment {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000E\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0003R\"\u0010\u0011\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001A\u00020\u00048\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewDefaultMiniPlayerFragment$BuyingGoodsFragment;", "Lcom/iloen/melon/fragments/webview/MelonWebViewDefaultMiniPlayerFragment;", "<init>", "()V", "", "url", "", "isGoodsBuyRecommendUrl", "(Ljava/lang/String;)Z", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "doLoginNeedDlg", "fromLoginDialog", "Z", "getFromLoginDialog", "()Z", "setFromLoginDialog", "(Z)V", "prevUrl", "Ljava/lang/String;", "getPrevUrl", "()Ljava/lang/String;", "setPrevUrl", "(Ljava/lang/String;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class BuyingGoodsFragment extends MelonWebViewDefaultMiniPlayerFragment {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0007J\b\u0010\u0004\u001A\u00020\u0005H\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewDefaultMiniPlayerFragment$BuyingGoodsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/webview/MelonWebViewDefaultMiniPlayerFragment$BuyingGoodsFragment;", "url", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final BuyingGoodsFragment newInstance() {
                Bundle bundle0 = new Bundle();
                bundle0.putString("url", M.D);
                BuyingGoodsFragment melonWebViewDefaultMiniPlayerFragment$BuyingGoodsFragment0 = new BuyingGoodsFragment();
                melonWebViewDefaultMiniPlayerFragment$BuyingGoodsFragment0.setArguments(bundle0);
                return melonWebViewDefaultMiniPlayerFragment$BuyingGoodsFragment0;
            }

            @NotNull
            public final BuyingGoodsFragment newInstance(@Nullable String s) {
                Bundle bundle0 = new Bundle();
                if(s == null || s.length() == 0) {
                    s = M.D;
                }
                bundle0.putString("url", s);
                BuyingGoodsFragment melonWebViewDefaultMiniPlayerFragment$BuyingGoodsFragment0 = new BuyingGoodsFragment();
                melonWebViewDefaultMiniPlayerFragment$BuyingGoodsFragment0.setArguments(bundle0);
                return melonWebViewDefaultMiniPlayerFragment$BuyingGoodsFragment0;
            }
        }

        public static final int $stable;
        @NotNull
        public static final Companion Companion;
        private boolean fromLoginDialog;
        @NotNull
        private String prevUrl;

        static {
            BuyingGoodsFragment.Companion = new Companion(null);
            BuyingGoodsFragment.$stable = 8;
        }

        public BuyingGoodsFragment() {
            this.prevUrl = "";
        }

        @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
        public void doLoginNeedDlg() {
            String s;
            super.doLoginNeedDlg();
            this.fromLoginDialog = true;
            MelonWebView melonWebView0 = this.mWebView;
            if(melonWebView0 == null) {
                s = "";
            }
            else {
                s = melonWebView0.getUrl();
                if(s == null) {
                    s = "";
                }
            }
            this.prevUrl = s;
        }

        public final boolean getFromLoginDialog() {
            return this.fromLoginDialog;
        }

        @NotNull
        public final String getPrevUrl() {
            return this.prevUrl;
        }

        // 去混淆评级： 低(20)
        private final boolean isGoodsBuyRecommendUrl(String s) {
            return q.b(M.D, s) || q.b(M.E, s);
        }

        @NotNull
        public static final BuyingGoodsFragment newInstance() {
            return BuyingGoodsFragment.Companion.newInstance();
        }

        @NotNull
        public static final BuyingGoodsFragment newInstance(@Nullable String s) {
            return BuyingGoodsFragment.Companion.newInstance(s);
        }

        @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
        public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
            String s;
            q.g(view0, "view");
            super.onViewCreated(view0, bundle0);
            if(this.mWebView != null && this.isLoginUser() && this.isGoodsBuyRecommendUrl(this.prevUrl)) {
                MelonWebView melonWebView0 = this.mWebView;
                if(melonWebView0 == null) {
                    s = "";
                }
                else {
                    s = melonWebView0.getUrl();
                    if(s == null) {
                        s = "";
                    }
                }
                if(this.isGoodsBuyRecommendUrl(s)) {
                    this.mWebView.reload();
                }
            }
            this.fromLoginDialog = false;
            this.prevUrl = "";
        }

        public final void setFromLoginDialog(boolean z) {
            this.fromLoginDialog = z;
        }

        public final void setPrevUrl(@NotNull String s) {
            q.g(s, "<set-?>");
            this.prevUrl = s;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0007J\"\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0002¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewDefaultMiniPlayerFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/webview/MelonWebViewDefaultMiniPlayerFragment;", "url", "", "params", "Lcom/iloen/melon/utils/NameValuePairList;", "post", "", "data", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class com.iloen.melon.fragments.webview.MelonWebViewDefaultMiniPlayerFragment.Companion {
        private com.iloen.melon.fragments.webview.MelonWebViewDefaultMiniPlayerFragment.Companion() {
        }

        public com.iloen.melon.fragments.webview.MelonWebViewDefaultMiniPlayerFragment.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final MelonWebViewDefaultMiniPlayerFragment newInstance(String s, byte[] arr_b) {
            MelonWebViewDefaultMiniPlayerFragment melonWebViewDefaultMiniPlayerFragment0 = new MelonWebViewDefaultMiniPlayerFragment();
            melonWebViewDefaultMiniPlayerFragment0.setArguments(MelonWebViewFragment.makePostArgs(s, arr_b));
            return melonWebViewDefaultMiniPlayerFragment0;
        }

        @NotNull
        public final MelonWebViewDefaultMiniPlayerFragment newInstance(@Nullable String s) {
            MelonWebViewDefaultMiniPlayerFragment melonWebViewDefaultMiniPlayerFragment0 = new MelonWebViewDefaultMiniPlayerFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("url", s);
            melonWebViewDefaultMiniPlayerFragment0.setArguments(bundle0);
            return melonWebViewDefaultMiniPlayerFragment0;
        }

        @NotNull
        public final MelonWebViewDefaultMiniPlayerFragment newInstance(@NotNull String s, @Nullable NameValuePairList nameValuePairList0, boolean z) {
            q.g(s, "url");
            if(z) {
                String s1 = ContentValuesEncodedUtils.format(nameValuePairList0, "utf-8");
                q.d(s1);
                byte[] arr_b = s1.getBytes(a.a);
                q.f(arr_b, "getBytes(...)");
                return this.newInstance(s, arr_b);
            }
            return this.newInstance(MelonWebViewFragment.makeGetArgs(s, nameValuePairList0));
        }
    }

    public static final int $stable;
    @NotNull
    public static final com.iloen.melon.fragments.webview.MelonWebViewDefaultMiniPlayerFragment.Companion Companion;

    static {
        MelonWebViewDefaultMiniPlayerFragment.Companion = new com.iloen.melon.fragments.webview.MelonWebViewDefaultMiniPlayerFragment.Companion(null);
        MelonWebViewDefaultMiniPlayerFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public boolean hasCloseOrBackButton() {
        return false;
    }

    @NotNull
    public static final MelonWebViewDefaultMiniPlayerFragment newInstance(@Nullable String s) {
        return MelonWebViewDefaultMiniPlayerFragment.Companion.newInstance(s);
    }

    @NotNull
    public static final MelonWebViewDefaultMiniPlayerFragment newInstance(@NotNull String s, @Nullable NameValuePairList nameValuePairList0, boolean z) {
        return MelonWebViewDefaultMiniPlayerFragment.Companion.newInstance(s, nameValuePairList0, z);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return true;
    }
}

