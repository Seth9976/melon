package com.iloen.melon.fragments.webview;

import Tf.a;
import android.os.Bundle;
import com.iloen.melon.custom.f1;
import com.iloen.melon.utils.ContentValuesEncodedUtils;
import com.iloen.melon.utils.NameValuePairList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\u0006J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\u0003J\u000F\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u0003¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewDefaultFragment;", "Lcom/iloen/melon/fragments/webview/MelonWebViewFragment;", "<init>", "()V", "", "shouldShowMiniPlayer", "()Z", "hasCloseOrBackButton", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "Lie/H;", "onResume", "onPause", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class MelonWebViewDefaultFragment extends MelonWebViewFragment {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0007J\"\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0002¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewDefaultFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/webview/MelonWebViewDefaultFragment;", "url", "", "params", "Lcom/iloen/melon/utils/NameValuePairList;", "post", "", "data", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final MelonWebViewDefaultFragment newInstance(String s, byte[] arr_b) {
            MelonWebViewDefaultFragment melonWebViewDefaultFragment0 = new MelonWebViewDefaultFragment();
            melonWebViewDefaultFragment0.setArguments(MelonWebViewFragment.makePostArgs(s, arr_b));
            return melonWebViewDefaultFragment0;
        }

        @NotNull
        public final MelonWebViewDefaultFragment newInstance(@Nullable String s) {
            MelonWebViewDefaultFragment melonWebViewDefaultFragment0 = new MelonWebViewDefaultFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("url", s);
            melonWebViewDefaultFragment0.setArguments(bundle0);
            return melonWebViewDefaultFragment0;
        }

        @NotNull
        public final MelonWebViewDefaultFragment newInstance(@NotNull String s, @Nullable NameValuePairList nameValuePairList0, boolean z) {
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
        MelonWebViewDefaultFragment.Companion = new Companion(null);
        MelonWebViewDefaultFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public f1 getInsetHandlingType() {
        return f1.c;
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public boolean hasCloseOrBackButton() {
        return false;
    }

    @NotNull
    public static final MelonWebViewDefaultFragment newInstance(@Nullable String s) {
        return MelonWebViewDefaultFragment.Companion.newInstance(s);
    }

    @NotNull
    public static final MelonWebViewDefaultFragment newInstance(@NotNull String s, @Nullable NameValuePairList nameValuePairList0, boolean z) {
        return MelonWebViewDefaultFragment.Companion.newInstance(s, nameValuePairList0, z);
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void onPause() {
        super.onPause();
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void onResume() {
        super.onResume();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

