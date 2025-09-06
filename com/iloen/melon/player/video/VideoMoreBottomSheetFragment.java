package com.iloen.melon.player.video;

import J8.Q0;
import U4.x;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.o;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonBottomSheetBaseFragment;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.response.MelonTvVdoGetMvProgInfoRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MelonTvVdoGetMvProgInfoRes;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response;
import com.iloen.melon.net.v6x.response.LiveDetailRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.BottomSheetUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import m0.b;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u8.d;
import v9.h;
import zd.M;
import zd.Q;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001F2\u00020\u0001:\u0003\u001F !B/\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0016\u0010\u0007\u001A\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0018\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001D\u001A\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u000FH\u0017¢\u0006\u0004\b\u001D\u0010\u001E¨\u0006\""}, d2 = {"Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment;", "Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment;", "Lcom/iloen/melon/player/video/VideoViewModel;", "viewModel", "Ljava/util/ArrayList;", "Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$VideoMoreItem;", "Lkotlin/collections/ArrayList;", "videoMoreItem", "Lzd/Q;", "popupType", "<init>", "(Lcom/iloen/melon/player/video/VideoViewModel;Ljava/util/ArrayList;Lzd/Q;)V", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "newFragment", "()Lcom/iloen/melon/fragments/MelonBaseFragment;", "", "getTheme", "()I", "Landroidx/fragment/app/I;", "fragment", "Lie/H;", "setParentFragment", "(Landroidx/fragment/app/I;)V", "", "useDirectExpand", "()Z", "Landroid/content/Intent;", "intent", "requestCode", "startActivityForResult", "(Landroid/content/Intent;I)V", "Companion", "VideoMoreFragment", "VideoMoreItem", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoMoreBottomSheetFragment extends MelonBottomSheetBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000B\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000B\u0010\u0007R\u0014\u0010\f\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000E\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000E\u0010\u0007R\u0014\u0010\u000F\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000F\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "ITEM_CAST", "I", "ITEM_PROGRAM", "ITEM_LIVE_ALARM", "ITEM_SETTING_QUALITY", "ITEM_DOWNLOAD", "ITEM_SHARE", "ITEM_ARTIST_CHANNEL", "ITEM_REPEAT", "ITEM_QUALITY_SELECT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u00A2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001LB\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ%\u0010\u000F\u001A\u00020\u000E2\u0016\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\f\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001A\u001A\u00020\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0015H\u0016\u00A2\u0006\u0004\b\u001F\u0010 J!\u0010\"\u001A\u00020\u000E2\u0006\u0010!\u001A\u00020\u001E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0015H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001A\u00020\u000E2\u0006\u0010%\u001A\u00020$H\u0016\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010(\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b(\u0010)J\u001D\u0010-\u001A\b\u0012\u0002\b\u0003\u0018\u00010,2\u0006\u0010+\u001A\u00020*H\u0014\u00A2\u0006\u0004\b-\u0010.J\u0011\u00100\u001A\u0004\u0018\u00010/H\u0014\u00A2\u0006\u0004\b0\u00101J-\u00108\u001A\u00020\u00072\b\u00103\u001A\u0004\u0018\u0001022\b\u00105\u001A\u0004\u0018\u0001042\b\u00107\u001A\u0004\u0018\u000106H\u0014\u00A2\u0006\u0004\b8\u00109R\"\u0010A\u001A\u00020:8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b;\u0010<\u001A\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0017\u0010G\u001A\u00020B8\u0006\u00A2\u0006\f\n\u0004\bC\u0010D\u001A\u0004\bE\u0010FR\u0014\u0010K\u001A\u00020H8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bI\u0010J\u00A8\u0006M"}, d2 = {"Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$VideoMoreFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/iloen/melon/player/video/VideoViewModel;", "viewModel", "<init>", "(Lcom/iloen/melon/player/video/VideoViewModel;)V", "", "shouldShowMiniPlayer", "()Z", "Ljava/util/ArrayList;", "Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$VideoMoreItem;", "Lkotlin/collections/ArrayList;", "itemList", "Lie/H;", "setData", "(Ljava/util/ArrayList;)V", "Lzd/Q;", "popupType", "setPopupType", "(Lzd/Q;)V", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDestroy", "()V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "", "b", "I", "getPeekHeight", "()I", "setPeekHeight", "(I)V", "peekHeight", "Lcom/iloen/melon/utils/log/LogU;", "c", "Lcom/iloen/melon/utils/log/LogU;", "getLog", "()Lcom/iloen/melon/utils/log/LogU;", "log", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class VideoMoreFragment extends MetaContentBaseFragment implements CoroutineScope {
        @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$VideoMoreFragment$Companion;", "", "Lcom/iloen/melon/player/video/VideoViewModel;", "viewModel", "Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$VideoMoreFragment;", "newInstance", "(Lcom/iloen/melon/player/video/VideoViewModel;)Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$VideoMoreFragment;", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.player.video.VideoMoreBottomSheetFragment.VideoMoreFragment.Companion {
            public com.iloen.melon.player.video.VideoMoreBottomSheetFragment.VideoMoreFragment.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final VideoMoreFragment newInstance(@NotNull VideoViewModel videoViewModel0) {
                q.g(videoViewModel0, "viewModel");
                return new VideoMoreFragment(videoViewModel0);
            }
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public static final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] arr_v = new int[M.values().length];
                try {
                    arr_v[0x72] = 1;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[109] = 2;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[38] = 3;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[5] = 4;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[11] = 5;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[108] = 6;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[107] = 7;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[106] = 8;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[110] = 9;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                WhenMappings.$EnumSwitchMapping$0 = arr_v;
            }
        }

        public static final int $stable;
        @NotNull
        public static final com.iloen.melon.player.video.VideoMoreBottomSheetFragment.VideoMoreFragment.Companion Companion;
        public final VideoViewModel a;
        public int b;
        public final LogU c;
        public final LiveViewModel d;
        public Q0 e;
        public RESPONSE f;
        public Response g;
        public Q h;

        static {
            VideoMoreFragment.Companion = new com.iloen.melon.player.video.VideoMoreBottomSheetFragment.VideoMoreFragment.Companion(null);
            VideoMoreFragment.$stable = 8;
        }

        public VideoMoreFragment(@NotNull VideoViewModel videoViewModel0) {
            q.g(videoViewModel0, "viewModel");
            super();
            this.a = videoViewModel0;
            new ArrayList();
            this.b = 1500;
            LogU logU0 = Z.g("VideoMoreFragment", true);
            logU0.setCategory(Category.UI);
            this.c = logU0;
            this.d = (LiveViewModel)videoViewModel0;
            new ArrayList();
        }

        public static final void access$closeBottomSheet(VideoMoreFragment videoMoreBottomSheetFragment$VideoMoreFragment0) {
            videoMoreBottomSheetFragment$VideoMoreFragment0.d0();
        }

        public static final MelonBaseFragment access$getRootFragment(VideoMoreFragment videoMoreBottomSheetFragment$VideoMoreFragment0) {
            return videoMoreBottomSheetFragment$VideoMoreFragment0.e0();
        }

        public static final Deferred access$requestSongPlayerInfoPostContentAsync(VideoMoreFragment videoMoreBottomSheetFragment$VideoMoreFragment0, String s, String s1) {
            videoMoreBottomSheetFragment$VideoMoreFragment0.getClass();
            return BuildersKt__Builders_commonKt.async$default(videoMoreBottomSheetFragment$VideoMoreFragment0, null, null, new VideoMoreBottomSheetFragment.VideoMoreFragment.requestSongPlayerInfoPostContentAsync.1(videoMoreBottomSheetFragment$VideoMoreFragment0, s, s1, null), 3, null);
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        @Nullable
        public j0 createRecyclerViewAdapter(@NotNull Context context0) {
            q.g(context0, "context");
            return null;
        }

        public final void d0() {
            BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(this);
        }

        public final MelonBaseFragment e0() {
            I i0 = this.getParentFragment();
            VideoMoreBottomSheetFragment videoMoreBottomSheetFragment0 = i0 instanceof VideoMoreBottomSheetFragment ? ((VideoMoreBottomSheetFragment)i0) : null;
            I i1 = videoMoreBottomSheetFragment0 == null ? null : videoMoreBottomSheetFragment0.d;
            return i1 instanceof MelonBaseFragment ? ((MelonBaseFragment)i1) : null;
        }

        @Override  // kotlinx.coroutines.CoroutineScope
        @NotNull
        public i getCoroutineContext() {
            return Dispatchers.getIO();
        }

        @NotNull
        public final LogU getLog() {
            return this.c;
        }

        public final int getPeekHeight() {
            return this.b;
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        public void onConfigurationChanged(@NotNull Configuration configuration0) {
            q.g(configuration0, "newConfig");
            super.onConfigurationChanged(configuration0);
            Dialog dialog0 = this.getRetainedDialog();
            if(dialog0 != null) {
                dialog0.dismiss();
            }
            BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(this);
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        @Nullable
        public RecyclerView onCreateRecyclerView() {
            return null;
        }

        @Override  // androidx.fragment.app.I
        @NotNull
        public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
            q.g(layoutInflater0, "inflater");
            Q0 q00 = Q0.a(layoutInflater0, viewGroup0);
            this.e = q00;
            q.f(q00.a, "getRoot(...)");
            return q00.a;
        }

        @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
        public void onDestroy() {
            super.onDestroy();
            this.e = null;
        }

        @Override  // com.iloen.melon.fragments.FetcherBaseFragment
        public boolean onFetchStart(@Nullable v9.i i0, @Nullable h h0, @Nullable String s) {
            return false;
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        public void onRestoreInstanceState(@NotNull Bundle bundle0) {
            q.g(bundle0, "inState");
        }

        @Override  // com.iloen.melon.fragments.FetcherBaseFragment
        public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
            RESPONSE melonTvVdoGetMvProgInfoRes$RESPONSE0;
            q.g(view0, "view");
            super.onViewCreated(view0, bundle0);
            Playable playable0 = (Playable)this.a.getCurrentVideoPlayable().getValue();
            d d0 = (d)this.a.getVdoGetMvProgInfoRes().getValue();
            Response liveDetailRes$Response0 = null;
            if(d0 == null) {
                melonTvVdoGetMvProgInfoRes$RESPONSE0 = null;
            }
            else {
                MelonTvVdoGetMvProgInfoRes melonTvVdoGetMvProgInfoRes0 = (MelonTvVdoGetMvProgInfoRes)d0.b;
                melonTvVdoGetMvProgInfoRes$RESPONSE0 = melonTvVdoGetMvProgInfoRes0 == null ? null : melonTvVdoGetMvProgInfoRes0.response;
            }
            this.f = melonTvVdoGetMvProgInfoRes$RESPONSE0;
            LiveDetailRes liveDetailRes0 = (LiveDetailRes)this.d.getLiveRes().getValue();
            if(liveDetailRes0 != null) {
                liveDetailRes$Response0 = liveDetailRes0.response;
            }
            this.g = liveDetailRes$Response0;
            Q0 q00 = this.e;
            q.d(q00);
            b b0 = new b(0xA9CCA905, new X(this, 1), true);
            q00.b.setContent(b0);
        }

        public final void setData(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "itemList");
        }

        public final void setPeekHeight(int v) {
            this.b = v;
        }

        public final void setPopupType(@NotNull Q q0) {
            q.g(q0, "popupType");
            this.h = q0;
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        public boolean shouldShowMiniPlayer() {
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ.\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0010\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\fJ\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\nR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\fR\u0017\u0010\u0006\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001A\u001A\u0004\b\u001D\u0010\f¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$VideoMoreItem;", "", "", "title", "", "viewType", "position", "<init>", "(Ljava/lang/String;II)V", "component1", "()Ljava/lang/String;", "component2", "()I", "component3", "copy", "(Ljava/lang/String;II)Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$VideoMoreItem;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getTitle", "b", "I", "getViewType", "c", "getPosition", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class VideoMoreItem {
        public static final int $stable;
        public final String a;
        public final int b;
        public final int c;

        public VideoMoreItem() {
            this(null, 0, 0, 7, null);
        }

        public VideoMoreItem(@NotNull String s, int v, int v1) {
            q.g(s, "title");
            super();
            this.a = s;
            this.b = v;
            this.c = v1;
        }

        public VideoMoreItem(String s, int v, int v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v2 & 1) != 0) {
                s = "";
            }
            if((v2 & 2) != 0) {
                v = 0;
            }
            if((v2 & 4) != 0) {
                v1 = -1;
            }
            this(s, v, v1);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        public final int component3() {
            return this.c;
        }

        @NotNull
        public final VideoMoreItem copy(@NotNull String s, int v, int v1) {
            q.g(s, "title");
            return new VideoMoreItem(s, v, v1);
        }

        public static VideoMoreItem copy$default(VideoMoreItem videoMoreBottomSheetFragment$VideoMoreItem0, String s, int v, int v1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                s = videoMoreBottomSheetFragment$VideoMoreItem0.a;
            }
            if((v2 & 2) != 0) {
                v = videoMoreBottomSheetFragment$VideoMoreItem0.b;
            }
            if((v2 & 4) != 0) {
                v1 = videoMoreBottomSheetFragment$VideoMoreItem0.c;
            }
            return videoMoreBottomSheetFragment$VideoMoreItem0.copy(s, v, v1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof VideoMoreItem)) {
                return false;
            }
            if(!q.b(this.a, ((VideoMoreItem)object0).a)) {
                return false;
            }
            return this.b == ((VideoMoreItem)object0).b ? this.c == ((VideoMoreItem)object0).c : false;
        }

        public final int getPosition() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public final int getViewType() {
            return this.b;
        }

        @Override
        public int hashCode() {
            return this.c + A7.d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = o.u(this.b, "VideoMoreItem(title=", this.a, ", viewType=", ", position=");
            return x.g(this.c, ")", stringBuilder0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int ITEM_ARTIST_CHANNEL = 6;
    public static final int ITEM_CAST = 0;
    public static final int ITEM_DOWNLOAD = 4;
    public static final int ITEM_LIVE_ALARM = 2;
    public static final int ITEM_PROGRAM = 1;
    public static final int ITEM_QUALITY_SELECT = 8;
    public static final int ITEM_REPEAT = 7;
    public static final int ITEM_SETTING_QUALITY = 3;
    public static final int ITEM_SHARE = 5;
    @NotNull
    public static final String TAG = "VideoMoreBottomSheetFragment";
    public final VideoViewModel a;
    public final ArrayList b;
    public final Q c;
    public I d;

    static {
        VideoMoreBottomSheetFragment.Companion = new Companion(null);
        VideoMoreBottomSheetFragment.$stable = 8;
    }

    public VideoMoreBottomSheetFragment(@NotNull VideoViewModel videoViewModel0, @NotNull ArrayList arrayList0, @NotNull Q q0) {
        q.g(videoViewModel0, "viewModel");
        q.g(arrayList0, "videoMoreItem");
        q.g(q0, "popupType");
        super();
        this.a = videoViewModel0;
        this.b = arrayList0;
        this.c = q0;
    }

    @Override  // androidx.fragment.app.w
    public int getTheme() {
        return 0x7F1402FC;  // style:Theme.NotTransparentInNavigationBar
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public I newFragment() {
        return this.newFragment();
    }

    @NotNull
    public MelonBaseFragment newFragment() {
        MelonBaseFragment melonBaseFragment0 = VideoMoreFragment.Companion.newInstance(this.a);
        ((VideoMoreFragment)melonBaseFragment0).setData(this.b);
        ((VideoMoreFragment)melonBaseFragment0).setPopupType(this.c);
        return melonBaseFragment0;
    }

    public final void setParentFragment(@NotNull I i0) {
        q.g(i0, "fragment");
        this.d = i0;
    }

    @Override  // androidx.fragment.app.I
    @ie.d
    public void startActivityForResult(@NotNull Intent intent0, int v) {
        q.g(intent0, "intent");
        I i0 = this.d;
        if(i0 != null) {
            i0.startActivityForResult(intent0, v);
            return;
        }
        super.startActivityForResult(intent0, v);
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public boolean useDirectExpand() {
        return true;
    }
}

