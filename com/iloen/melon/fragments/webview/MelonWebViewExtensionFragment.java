package com.iloen.melon.fragments.webview;

import A8.M;
import android.os.Bundle;
import com.iloen.melon.custom.I1;
import com.iloen.melon.utils.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewExtensionFragment;", "Lcom/iloen/melon/fragments/webview/MelonWebViewDefaultMiniPlayerFragment;", "<init>", "()V", "SearchHotKeywordInnerFragment", "SearchKeywordInnerFragment", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class MelonWebViewExtensionFragment extends MelonWebViewDefaultMiniPlayerFragment {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewExtensionFragment$SearchHotKeywordInnerFragment;", "Lcom/iloen/melon/fragments/webview/MelonWebViewExtensionFragment;", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SearchHotKeywordInnerFragment extends MelonWebViewExtensionFragment {
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00042\u0006\u0010\t\u001A\u00020\bH\u0007¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewExtensionFragment$SearchHotKeywordInnerFragment$Companion;", "", "<init>", "()V", "", "keyword", "tab", "order", "Lcom/iloen/melon/custom/I1;", "jsConnect", "Lcom/iloen/melon/fragments/webview/MelonWebViewExtensionFragment$SearchHotKeywordInnerFragment;", "newInstance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/custom/I1;)Lcom/iloen/melon/fragments/webview/MelonWebViewExtensionFragment$SearchHotKeywordInnerFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final SearchHotKeywordInnerFragment newInstance(@NotNull String s, @Nullable String s1, @Nullable String s2, @NotNull I1 i10) {
                q.g(s, "keyword");
                q.g(i10, "jsConnect");
                SearchHotKeywordInnerFragment melonWebViewExtensionFragment$SearchHotKeywordInnerFragment0 = new SearchHotKeywordInnerFragment();
                Bundle bundle0 = new Bundle();
                String s3 = M.M;
                String s4 = StringUtils.getEncodeUTF8(s);
                String s5 = "";
                if(s1 != null && s1.length() != 0) {
                    if(s2 != null && s2.length() != 0) {
                        s5 = "&order=" + s2;
                    }
                    s5 = "&tab=" + s1 + s5;
                }
                bundle0.putString("url", s3 + s4 + s5);
                melonWebViewExtensionFragment$SearchHotKeywordInnerFragment0.setArguments(bundle0);
                melonWebViewExtensionFragment$SearchHotKeywordInnerFragment0.setJsConnect(i10);
                return melonWebViewExtensionFragment$SearchHotKeywordInnerFragment0;
            }
        }

        public static final int $stable;
        @NotNull
        public static final Companion Companion;

        static {
            SearchHotKeywordInnerFragment.Companion = new Companion(null);
            SearchHotKeywordInnerFragment.$stable = 8;
        }

        @NotNull
        public static final SearchHotKeywordInnerFragment newInstance(@NotNull String s, @Nullable String s1, @Nullable String s2, @NotNull I1 i10) {
            return SearchHotKeywordInnerFragment.Companion.newInstance(s, s1, s2, i10);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewExtensionFragment$SearchKeywordInnerFragment;", "Lcom/iloen/melon/fragments/webview/MelonWebViewExtensionFragment;", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SearchKeywordInnerFragment extends MelonWebViewExtensionFragment {
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000B\u001A\u00020\n2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00042\u0006\u0010\t\u001A\u00020\bH\u0007¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/webview/MelonWebViewExtensionFragment$SearchKeywordInnerFragment$Companion;", "", "<init>", "()V", "", "keyword", "tab", "order", "Lcom/iloen/melon/custom/I1;", "jsConnect", "Lcom/iloen/melon/fragments/webview/MelonWebViewExtensionFragment$SearchKeywordInnerFragment;", "newInstance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/custom/I1;)Lcom/iloen/melon/fragments/webview/MelonWebViewExtensionFragment$SearchKeywordInnerFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.fragments.webview.MelonWebViewExtensionFragment.SearchKeywordInnerFragment.Companion {
            private com.iloen.melon.fragments.webview.MelonWebViewExtensionFragment.SearchKeywordInnerFragment.Companion() {
            }

            public com.iloen.melon.fragments.webview.MelonWebViewExtensionFragment.SearchKeywordInnerFragment.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final SearchKeywordInnerFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @NotNull I1 i10) {
                q.g(i10, "jsConnect");
                SearchKeywordInnerFragment melonWebViewExtensionFragment$SearchKeywordInnerFragment0 = new SearchKeywordInnerFragment();
                Bundle bundle0 = new Bundle();
                String s3 = M.L;
                String s4 = StringUtils.getEncodeUTF8(s);
                String s5 = "";
                if(s1 != null && s1.length() != 0) {
                    if(s2 != null && s2.length() != 0) {
                        s5 = "&order=" + s2;
                    }
                    s5 = "&tab=" + s1 + s5;
                }
                bundle0.putString("url", s3 + s4 + s5);
                melonWebViewExtensionFragment$SearchKeywordInnerFragment0.setArguments(bundle0);
                melonWebViewExtensionFragment$SearchKeywordInnerFragment0.setJsConnect(i10);
                return melonWebViewExtensionFragment$SearchKeywordInnerFragment0;
            }
        }

        public static final int $stable;
        @NotNull
        public static final com.iloen.melon.fragments.webview.MelonWebViewExtensionFragment.SearchKeywordInnerFragment.Companion Companion;

        static {
            SearchKeywordInnerFragment.Companion = new com.iloen.melon.fragments.webview.MelonWebViewExtensionFragment.SearchKeywordInnerFragment.Companion(null);
            SearchKeywordInnerFragment.$stable = 8;
        }

        @NotNull
        public static final SearchKeywordInnerFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @NotNull I1 i10) {
            return SearchKeywordInnerFragment.Companion.newInstance(s, s1, s2, i10);
        }
    }

    public static final int $stable = 8;

}

