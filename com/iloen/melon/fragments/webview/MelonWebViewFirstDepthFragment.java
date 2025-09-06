package com.iloen.melon.fragments.webview;

import F8.o;
import Tf.a;
import android.os.Bundle;
import android.view.View;
import com.iloen.melon.fragments.detail.viewholder.p;
import com.iloen.melon.utils.ContentValuesEncodedUtils;
import com.iloen.melon.utils.NameValuePairList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewFirstDepthFragment;", "Lcom/iloen/melon/fragments/webview/MelonWebViewFragment;", "<init>", "()V", "", "shouldShowMiniPlayer", "()Z", "LF8/o;", "getTitleBarItem", "()LF8/o;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonWebViewFirstDepthFragment extends MelonWebViewFragment {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0007J\"\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0002¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewFirstDepthFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/webview/MelonWebViewFirstDepthFragment;", "url", "", "params", "Lcom/iloen/melon/utils/NameValuePairList;", "post", "", "data", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final MelonWebViewFirstDepthFragment newInstance(String s, byte[] arr_b) {
            MelonWebViewFirstDepthFragment melonWebViewFirstDepthFragment0 = new MelonWebViewFirstDepthFragment();
            melonWebViewFirstDepthFragment0.setArguments(MelonWebViewFragment.makePostArgs(s, arr_b));
            return melonWebViewFirstDepthFragment0;
        }

        @NotNull
        public final MelonWebViewFirstDepthFragment newInstance(@Nullable String s) {
            MelonWebViewFirstDepthFragment melonWebViewFirstDepthFragment0 = new MelonWebViewFirstDepthFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("url", s);
            melonWebViewFirstDepthFragment0.setArguments(bundle0);
            return melonWebViewFirstDepthFragment0;
        }

        @NotNull
        public final MelonWebViewFirstDepthFragment newInstance(@NotNull String s, @Nullable NameValuePairList nameValuePairList0, boolean z) {
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
    public static final Companion Companion;

    static {
        MelonWebViewFirstDepthFragment.Companion = new Companion(null);
        MelonWebViewFirstDepthFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    @NotNull
    public o getTitleBarItem() {
        return B.a.t(3, new p(this, 9));
    }

    private static final void getTitleBarItem$lambda$0(MelonWebViewFirstDepthFragment melonWebViewFirstDepthFragment0, View view0) {
        melonWebViewFirstDepthFragment0.historyBack();
    }

    @NotNull
    public static final MelonWebViewFirstDepthFragment newInstance(@Nullable String s) {
        return MelonWebViewFirstDepthFragment.Companion.newInstance(s);
    }

    @NotNull
    public static final MelonWebViewFirstDepthFragment newInstance(@NotNull String s, @Nullable NameValuePairList nameValuePairList0, boolean z) {
        return MelonWebViewFirstDepthFragment.Companion.newInstance(s, nameValuePairList0, z);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return true;
    }

    public static void t0(MelonWebViewFirstDepthFragment melonWebViewFirstDepthFragment0, View view0) {
        MelonWebViewFirstDepthFragment.getTitleBarItem$lambda$0(melonWebViewFirstDepthFragment0, view0);
    }
}

