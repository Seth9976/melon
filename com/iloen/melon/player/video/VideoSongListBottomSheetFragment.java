package com.iloen.melon.player.video;

import A7.d;
import De.I;
import J8.K;
import J8.N3;
import J8.f3;
import P1.c;
import U4.x;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.b;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonBottomSheetBaseFragment;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.SONG;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.BottomSheetUtil;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import e1.m;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import we.n;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000F\u0010\rJ\u0015\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u000B¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001A\u001A\u00020\u00122\u0006\u0010\u0019\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001D\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u001D\u0010\u001BR\u0017\u0010#\u001A\u00020\u001E8\u0006¢\u0006\f\n\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment;", "Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment;", "Lcom/iloen/melon/player/video/LiveViewModel;", "viewModel", "Lcom/iloen/melon/net/v6x/response/LiveTimedMetaSongRes$RESPONSE;", "songListRes", "<init>", "(Lcom/iloen/melon/player/video/LiveViewModel;Lcom/iloen/melon/net/v6x/response/LiveTimedMetaSongRes$RESPONSE;)V", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "newFragment", "()Lcom/iloen/melon/fragments/MelonBaseFragment;", "", "useTransparentBackground", "()Z", "useDirectExpand", "isHideStatusBar", "Landroidx/fragment/app/I;", "fragment", "Lie/H;", "setParentFragment", "(Landroidx/fragment/app/I;)V", "isShow", "setShowControllerAfterClosing", "(Z)V", "Landroid/content/DialogInterface;", "it", "onDialogShow", "(Landroid/content/DialogInterface;)V", "dialog", "onDismiss", "Lcom/iloen/melon/utils/log/LogU;", "c", "Lcom/iloen/melon/utils/log/LogU;", "getLog", "()Lcom/iloen/melon/utils/log/LogU;", "log", "Companion", "SongListFragment", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoSongListBottomSheetFragment extends MelonBottomSheetBaseFragment {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 =2\u00020\u0001:\u0003=>?B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u000F\u0010\rJ+\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020\u00102\b\u0010\u0013\u001A\u0004\u0018\u00010\u00122\b\u0010\u0014\u001A\u0004\u0018\u00010\tH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\tH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ-\u0010#\u001A\u00020\u00062\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010\"\u001A\u0004\u0018\u00010!H\u0014\u00A2\u0006\u0004\b#\u0010$J\u001B\u0010(\u001A\u0006\u0012\u0002\b\u00030\'2\u0006\u0010&\u001A\u00020%H\u0014\u00A2\u0006\u0004\b(\u0010)J\u000F\u0010+\u001A\u00020*H\u0014\u00A2\u0006\u0004\b+\u0010,J\u0019\u0010/\u001A\u00020\u000B2\b\u0010.\u001A\u0004\u0018\u00010-H\u0014\u00A2\u0006\u0004\b/\u00100J+\u00105\u001A\n\u0012\u0006\u0012\u0004\u0018\u000104032\b\u00101\u001A\u0004\u0018\u00010!2\b\u00102\u001A\u0004\u0018\u00010!H\u0014\u00A2\u0006\u0004\b5\u00106R\u0017\u0010<\u001A\u0002078\u0006\u00A2\u0006\f\n\u0004\b8\u00109\u001A\u0004\b:\u0010;\u00A8\u0006@"}, d2 = {"Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment$SongListFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lcom/iloen/melon/player/video/LiveViewModel;", "viewModel", "<init>", "(Lcom/iloen/melon/player/video/LiveViewModel;)V", "", "shouldShowMiniPlayer", "()Z", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "()V", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "", "userData", "onAddToNowPlayingList", "(Ljava/lang/Object;)V", "albumId", "albumName", "", "Lcom/iloen/melon/types/Song;", "onAddSongsToPlaylist", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Lcom/iloen/melon/utils/log/LogU;", "e", "Lcom/iloen/melon/utils/log/LogU;", "getLog", "()Lcom/iloen/melon/utils/log/LogU;", "log", "Companion", "SongItemAdapter", "EventMeta", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SongListFragment extends MetaContentBaseFragment {
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001D\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001A\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment$SongListFragment$Companion;", "", "Lcom/iloen/melon/net/v6x/response/LiveTimedMetaSongRes$RESPONSE;", "songListRes", "Lcom/iloen/melon/player/video/LiveViewModel;", "viewModel", "Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment$SongListFragment;", "newInstance", "(Lcom/iloen/melon/net/v6x/response/LiveTimedMetaSongRes$RESPONSE;Lcom/iloen/melon/player/video/LiveViewModel;)Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment$SongListFragment;", "", "ARG_SONG_RES", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.Companion {
            public com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final SongListFragment newInstance(@NotNull RESPONSE liveTimedMetaSongRes$RESPONSE0, @NotNull LiveViewModel liveViewModel0) {
                q.g(liveTimedMetaSongRes$RESPONSE0, "songListRes");
                q.g(liveViewModel0, "viewModel");
                SongListFragment videoSongListBottomSheetFragment$SongListFragment0 = new SongListFragment(liveViewModel0);
                Bundle bundle0 = new Bundle();
                bundle0.putSerializable("argSongRes", liveTimedMetaSongRes$RESPONSE0);
                videoSongListBottomSheetFragment$SongListFragment0.setArguments(bundle0);
                return videoSongListBottomSheetFragment$SongListFragment0;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000B\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000B\u0010\tJ.\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\tJ\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\tR\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001A\u0004\b\u001A\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u0017\u001A\u0004\b\u001C\u0010\t¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment$SongListFragment$EventMeta;", "", "", "id", "type", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment$SongListFragment$EventMeta;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getId", "b", "getType", "c", "getName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        static final class EventMeta {
            public final String a;
            public final String b;
            public final String c;

            public EventMeta(@NotNull String s, @NotNull String s1, @NotNull String s2) {
                q.g(s, "id");
                q.g(s1, "type");
                q.g(s2, "name");
                super();
                this.a = s;
                this.b = s1;
                this.c = s2;
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final String component2() {
                return this.b;
            }

            @NotNull
            public final String component3() {
                return this.c;
            }

            @NotNull
            public final EventMeta copy(@NotNull String s, @NotNull String s1, @NotNull String s2) {
                q.g(s, "id");
                q.g(s1, "type");
                q.g(s2, "name");
                return new EventMeta(s, s1, s2);
            }

            public static EventMeta copy$default(EventMeta videoSongListBottomSheetFragment$SongListFragment$EventMeta0, String s, String s1, String s2, int v, Object object0) {
                if((v & 1) != 0) {
                    s = videoSongListBottomSheetFragment$SongListFragment$EventMeta0.a;
                }
                if((v & 2) != 0) {
                    s1 = videoSongListBottomSheetFragment$SongListFragment$EventMeta0.b;
                }
                if((v & 4) != 0) {
                    s2 = videoSongListBottomSheetFragment$SongListFragment$EventMeta0.c;
                }
                return videoSongListBottomSheetFragment$SongListFragment$EventMeta0.copy(s, s1, s2);
            }

            @Override
            public boolean equals(@Nullable Object object0) {
                if(this == object0) {
                    return true;
                }
                if(!(object0 instanceof EventMeta)) {
                    return false;
                }
                if(!q.b(this.a, ((EventMeta)object0).a)) {
                    return false;
                }
                return q.b(this.b, ((EventMeta)object0).b) ? q.b(this.c, ((EventMeta)object0).c) : false;
            }

            @NotNull
            public final String getId() {
                return this.a;
            }

            @NotNull
            public final String getName() {
                return this.c;
            }

            @NotNull
            public final String getType() {
                return this.b;
            }

            @Override
            public int hashCode() {
                return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
            }

            @Override
            @NotNull
            public String toString() {
                return x.m(d.o("EventMeta(id=", this.a, ", type=", this.b, ", name="), this.c, ")");
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001EB\u0011\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001A\u00020\u000B2\u0016\u0010\n\u001A\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0014\u001A\u00020\u00022\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u00022\u0006\u0010\u0017\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment$SongListFragment$SongItemAdapter;", "Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "<init>", "(Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment$SongListFragment;Landroid/content/Context;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/LiveTimedMetaSongRes$SONG;", "Lkotlin/collections/ArrayList;", "data", "Lie/H;", "setData", "(Ljava/util/ArrayList;)V", "", "getItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "holder", "position", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;I)V", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "SongViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SongItemAdapter extends j0 {
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001D\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment$SongListFragment$SongItemAdapter$SongViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/N3;", "itemBinding", "<init>", "(Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment$SongListFragment$SongItemAdapter;LJ8/N3;)V", "Lcom/iloen/melon/net/v6x/response/LiveTimedMetaSongRes$SONG;", "data", "", "isFullScreen", "Lie/H;", "bindItem", "(Lcom/iloen/melon/net/v6x/response/LiveTimedMetaSongRes$SONG;Z)V", "a", "LJ8/N3;", "getItemBinding", "()LJ8/N3;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            final class SongViewHolder extends O0 {
                public final N3 a;
                public final SongItemAdapter b;
                public static final int c;

                public SongViewHolder(@NotNull N3 n30) {
                    q.g(n30, "itemBinding");
                    ImageView imageView0 = n30.c;
                    ImageView imageView1 = n30.b;
                    MelonTextView melonTextView0 = n30.g;
                    f3 f30 = n30.f;
                    this.b = videoSongListBottomSheetFragment$SongListFragment$SongItemAdapter0;
                    super(n30.a);
                    this.a = n30;
                    Context context0 = videoSongListBottomSheetFragment$SongListFragment$SongItemAdapter0.getContext();
                    if(context0 != null) {
                        if(SongListFragment.this.a.isFullScreen()) {
                            melonTextView0.setTextColor(ColorUtils.getColor(context0, 0x7F0604B4));  // color:white500e_support_high_contrast
                            imageView1.setImageResource(0x7F0800E2);  // drawable:btn_add_28_w
                            imageView0.setImageResource(0x7F080157);  // drawable:btn_common_more_04_w
                            f30.c.setImageResource(0x7F08078C);  // drawable:noimage_logo_mini_w
                            Drawable drawable0 = c.getDrawable(context0, 0x7F080933);  // drawable:thumbnail_background_image_round_w
                            f30.c.setBackground(drawable0);
                            Drawable drawable1 = c.getDrawable(videoSongListBottomSheetFragment$SongListFragment$SongItemAdapter0.getContext(), 0x7F0808FD);  // drawable:shape_rectangle_stroke_0_5dp_white120e_radius4
                            f30.d.setBackground(drawable1);
                            return;
                        }
                        melonTextView0.setTextColor(ColorUtils.getColor(videoSongListBottomSheetFragment$SongListFragment$SongItemAdapter0.getContext(), 0x7F060160));  // color:gray600s_support_high_contrast
                        imageView1.setImageResource(0x7F0800E1);  // drawable:btn_add_28
                        imageView0.setImageResource(0x7F080158);  // drawable:btn_common_more_05
                        f30.c.setImageResource(0x7F08078B);  // drawable:noimage_logo_mini
                        Drawable drawable2 = c.getDrawable(context0, 0x7F080930);  // drawable:thumbnail_background_image_round
                        f30.c.setBackground(drawable2);
                        Drawable drawable3 = c.getDrawable(videoSongListBottomSheetFragment$SongListFragment$SongItemAdapter0.getContext(), 0x7F080939);  // drawable:thumbnail_frame_round
                        f30.d.setBackground(drawable3);
                    }
                }

                public final void bindItem(@NotNull SONG liveTimedMetaSongRes$SONG0, boolean z) {
                    q.g(liveTimedMetaSongRes$SONG0, "data");
                    boolean z1 = liveTimedMetaSongRes$SONG0.canService;
                    N3 n30 = this.a;
                    View view0 = n30.e;
                    ImageView imageView0 = n30.b;
                    f3 f30 = n30.f;
                    RelativeLayout relativeLayout0 = n30.a;
                    LottieAnimationView lottieAnimationView0 = n30.d;
                    MelonTextView melonTextView0 = n30.h;
                    ViewUtils.setEnable(n30.i, z1);
                    SongItemAdapter videoSongListBottomSheetFragment$SongListFragment$SongItemAdapter0 = this.b;
                    Context context0 = videoSongListBottomSheetFragment$SongListFragment$SongItemAdapter0.getContext();
                    SongListFragment videoSongListBottomSheetFragment$SongListFragment0 = SongListFragment.this;
                    if(context0 != null) {
                        Glide.with(context0).load(liveTimedMetaSongRes$SONG0.albumImg).into(f30.b);
                    }
                    ViewUtils.showWhen(imageView0, z1);
                    ViewUtils.setTextViewMarquee(melonTextView0, liveTimedMetaSongRes$SONG0.isPick);
                    melonTextView0.setText(liveTimedMetaSongRes$SONG0.songName);
                    String s = ProtocolUtils.getArtistNames(liveTimedMetaSongRes$SONG0.artistList);
                    n30.g.setText(s);
                    if(liveTimedMetaSongRes$SONG0.isPick) {
                        ViewUtils.showWhen(view0, true);
                        ViewUtils.showWhen(lottieAnimationView0, true);
                        melonTextView0.setTextColor(ColorUtils.getColor(videoSongListBottomSheetFragment$SongListFragment$SongItemAdapter0.getContext(), (z ? 0x7F060179 : 0x7F06017C)));  // color:green490e
                        lottieAnimationView0.playAnimation();
                    }
                    else {
                        ViewUtils.hideWhen(view0, true);
                        ViewUtils.hideWhen(lottieAnimationView0, true);
                        melonTextView0.setTextColor(ColorUtils.getColor(videoSongListBottomSheetFragment$SongListFragment$SongItemAdapter0.getContext(), (z ? 0x7F0604A1 : 0x7F06016D)));  // color:white000e
                        lottieAnimationView0.cancelAnimation();
                    }
                    ViewUtils.setOnClickListener(imageView0, new p0(liveTimedMetaSongRes$SONG0, videoSongListBottomSheetFragment$SongListFragment0, 0));
                    p0 p00 = new p0(videoSongListBottomSheetFragment$SongListFragment0, liveTimedMetaSongRes$SONG0);
                    ViewUtils.setOnClickListener(n30.c, p00);
                    p0 p01 = new p0(liveTimedMetaSongRes$SONG0, videoSongListBottomSheetFragment$SongListFragment0, 2);
                    ViewUtils.setOnClickListener(f30.a, p01);
                    ViewUtils.showWhen(relativeLayout0.findViewById(0x7F0A063B), liveTimedMetaSongRes$SONG0.isAdult);  // id:iv_list_19
                    ViewUtils.showWhen(relativeLayout0.findViewById(0x7F0A0640), liveTimedMetaSongRes$SONG0.isFree);  // id:iv_list_free
                    ViewUtils.showWhen(relativeLayout0.findViewById(0x7F0A0641), liveTimedMetaSongRes$SONG0.isHoldback);  // id:iv_list_holdback
                }

                @NotNull
                public final N3 getItemBinding() {
                    return this.a;
                }
            }

            public final Context a;
            public ArrayList b;
            public final SongListFragment c;

            public SongItemAdapter(@Nullable Context context0) {
                this.a = context0;
                this.b = new ArrayList();
            }

            @Nullable
            public final Context getContext() {
                return this.a;
            }

            @Override  // androidx.recyclerview.widget.j0
            public int getItemCount() {
                return this.b.size();
            }

            @Override  // androidx.recyclerview.widget.j0
            public void onBindViewHolder(@NotNull O0 o00, int v) {
                q.g(o00, "holder");
                if(o00 instanceof SongViewHolder) {
                    Object object0 = this.b.get(v);
                    q.f(object0, "get(...)");
                    ((SongViewHolder)o00).bindItem(((SONG)object0), SongListFragment.this.a.isFullScreen());
                }
            }

            @Override  // androidx.recyclerview.widget.j0
            @NotNull
            public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
                q.g(viewGroup0, "parent");
                View view0 = LayoutInflater.from(this.a).inflate(0x7F0D08FD, viewGroup0, false);  // layout:video_song_list_item
                int v1 = 0x7F0A00B7;  // id:artist_layout
                if(((LinearLayout)I.C(view0, 0x7F0A00B7)) != null) {  // id:artist_layout
                    v1 = 0x7F0A013B;  // id:btn_add
                    View view1 = I.C(view0, 0x7F0A013B);  // id:btn_add
                    if(((ImageView)view1) != null) {
                        v1 = 0x7F0A0169;  // id:btn_info
                        View view2 = I.C(view0, 0x7F0A0169);  // id:btn_info
                        if(((ImageView)view2) != null && ((LinearLayout)I.C(view0, 0x7F0A0184)) != null) {  // id:btn_play_container
                            v1 = 0x7F0A0658;  // id:iv_now_playing
                            View view3 = I.C(view0, 0x7F0A0658);  // id:iv_now_playing
                            if(((LottieAnimationView)view3) != null) {
                                v1 = 0x7F0A0659;  // id:iv_now_playing_bg
                                View view4 = I.C(view0, 0x7F0A0659);  // id:iv_now_playing_bg
                                if(view4 != null && ((FrameLayout)I.C(view0, 0x7F0A075A)) != null && (((RelativeLayout)I.C(view0, 0x7F0A0807)) != null && ((RelativeLayout)I.C(view0, 0x7F0A08EA)) != null)) {  // id:left_layout
                                    v1 = 0x7F0A0B72;  // id:thumb_container
                                    View view5 = I.C(view0, 0x7F0A0B72);  // id:thumb_container
                                    if(view5 != null) {
                                        f3 f30 = f3.a(view5);
                                        v1 = 0x7F0A0B96;  // id:title_container
                                        if(((LinearLayout)I.C(view0, 0x7F0A0B96)) != null && ((LinearLayout)I.C(view0, 0x7F0A0B9E)) != null) {  // id:title_container
                                            v1 = 0x7F0A0C12;  // id:tv_artist
                                            View view6 = I.C(view0, 0x7F0A0C12);  // id:tv_artist
                                            if(((MelonTextView)view6) != null) {
                                                v1 = 0x7F0A0D34;  // id:tv_title
                                                View view7 = I.C(view0, 0x7F0A0D34);  // id:tv_title
                                                if(((MelonTextView)view7) != null) {
                                                    v1 = 0x7F0A0DF5;  // id:wrapper_layout
                                                    View view8 = I.C(view0, 0x7F0A0DF5);  // id:wrapper_layout
                                                    if(((RelativeLayout)view8) != null) {
                                                        return new SongViewHolder(this, new N3(((RelativeLayout)view0), ((ImageView)view1), ((ImageView)view2), ((LottieAnimationView)view3), view4, f30, ((MelonTextView)view6), ((MelonTextView)view7), ((RelativeLayout)view8)));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
            }

            public final void setData(@NotNull ArrayList arrayList0) {
                q.g(arrayList0, "data");
                this.b = arrayList0;
            }
        }

        public static final int $stable;
        @NotNull
        public static final com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.Companion Companion;
        public final LiveViewModel a;
        public K b;
        public RESPONSE c;
        public final ArrayList d;
        public final LogU e;

        static {
            SongListFragment.Companion = new com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.Companion(null);
            SongListFragment.$stable = 8;
        }

        public SongListFragment(@NotNull LiveViewModel liveViewModel0) {
            q.g(liveViewModel0, "viewModel");
            super();
            this.a = liveViewModel0;
            this.d = new ArrayList();
            LogU logU0 = Z.g("VideoSongListBottomSheetFragment", true);
            logU0.setCategory(Category.UI);
            this.e = logU0;
        }

        public static final void access$closeBottomSheet(SongListFragment videoSongListBottomSheetFragment$SongListFragment0) {
            videoSongListBottomSheetFragment$SongListFragment0.getClass();
            BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(videoSongListBottomSheetFragment$SongListFragment0);
        }

        public static final MetaContentBaseFragment access$getRootFragment(SongListFragment videoSongListBottomSheetFragment$SongListFragment0) {
            androidx.fragment.app.I i0 = videoSongListBottomSheetFragment$SongListFragment0.getParentFragment();
            VideoSongListBottomSheetFragment videoSongListBottomSheetFragment0 = i0 instanceof VideoSongListBottomSheetFragment ? ((VideoSongListBottomSheetFragment)i0) : null;
            androidx.fragment.app.I i1 = videoSongListBottomSheetFragment0 == null ? null : videoSongListBottomSheetFragment0.d;
            return i1 instanceof MetaContentBaseFragment ? ((MetaContentBaseFragment)i1) : null;
        }

        public static final void access$sendTiaraLogPlayer(SongListFragment videoSongListBottomSheetFragment$SongListFragment0, String s, ActionKind actionKind0, String s1, EventMeta videoSongListBottomSheetFragment$SongListFragment$EventMeta0) {
            Object object0 = videoSongListBottomSheetFragment$SongListFragment0.a.getCurrentVideoPlayable().getValue();
            if(((Playable)object0) == null) {
                return;
            }
            m.F(new n0(videoSongListBottomSheetFragment$SongListFragment$EventMeta0, s, actionKind0, videoSongListBottomSheetFragment$SongListFragment0, s1, ((Playable)object0))).track();
        }

        public static final void access$setAddSongInfo(SongListFragment videoSongListBottomSheetFragment$SongListFragment0, ArrayList arrayList0) {
            ArrayList arrayList1 = videoSongListBottomSheetFragment$SongListFragment0.d;
            arrayList1.clear();
            if(arrayList0 != null && !arrayList0.isEmpty()) {
                arrayList1.addAll(arrayList0);
            }
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        @NotNull
        public j0 createRecyclerViewAdapter(@NotNull Context context0) {
            q.g(context0, "context");
            return new SongItemAdapter(this, context0);
        }

        public static String d0(SongListFragment videoSongListBottomSheetFragment$SongListFragment0) {
            String s = videoSongListBottomSheetFragment$SongListFragment0.mMenuId;
            q.f(s, "mMenuId");
            return s;
        }

        @NotNull
        public final LogU getLog() {
            return this.e;
        }

        @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
        @NotNull
        public List onAddSongsToPlaylist(@Nullable String s, @Nullable String s1) {
            List list0 = new ArrayList();
            for(Object object0: this.d) {
                SongInfoBase songInfoBase0 = (SongInfoBase)object0;
                if(songInfoBase0.canService) {
                    ((ArrayList)list0).add(Song.a(songInfoBase0));
                }
            }
            return list0;
        }

        @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
        public void onAddToNowPlayingList(@Nullable Object object0) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object1: this.d) {
                arrayList0.add(Playable.from(((SongInfoBase)object1), this.mMenuId, null));
            }
            this.playSongs(arrayList0, false);
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        @NotNull
        public RecyclerView onCreateRecyclerView() {
            K k0 = this.b;
            q.d(k0);
            ((RecyclerView)k0.i).getContext();
            LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(1, false);
            ((RecyclerView)k0.i).setLayoutManager(linearLayoutManager0);
            ((RecyclerView)k0.i).setAdapter(this.mAdapter);
            ((RecyclerView)k0.i).setHasFixedSize(true);
            return (RecyclerView)k0.i;
        }

        @Override  // androidx.fragment.app.I
        @NotNull
        public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
            q.g(layoutInflater0, "inflater");
            View view0 = layoutInflater0.inflate(0x7F0D08FC, viewGroup0, false);  // layout:video_song_list_bottomsheet
            int v = 0x7F0A0127;  // id:bottom_sheet_container
            View view1 = I.C(view0, 0x7F0A0127);  // id:bottom_sheet_container
            if(((ConstraintLayout)view1) != null) {
                v = 0x7F0A014B;  // id:btn_close
                View view2 = I.C(view0, 0x7F0A014B);  // id:btn_close
                if(((MelonTextView)view2) != null && ((RelativeLayout)I.C(view0, 0x7F0A02CB)) != null) {  // id:close_container
                    v = 0x7F0A0337;  // id:content_container
                    View view3 = I.C(view0, 0x7F0A0337);  // id:content_container
                    if(((RelativeLayout)view3) != null) {
                        v = 0x7F0A03D5;  // id:divider
                        View view4 = I.C(view0, 0x7F0A03D5);  // id:divider
                        if(view4 != null) {
                            v = 0x7F0A09D1;  // id:recycler_view
                            View view5 = I.C(view0, 0x7F0A09D1);  // id:recycler_view
                            if(((RecyclerView)view5) != null && ((RelativeLayout)I.C(view0, 0x7F0A0B96)) != null) {  // id:title_container
                                v = 0x7F0A0C11;  // id:tv_all_add
                                View view6 = I.C(view0, 0x7F0A0C11);  // id:tv_all_add
                                if(((MelonTextView)view6) != null) {
                                    v = 0x7F0A0C6E;  // id:tv_empty
                                    View view7 = I.C(view0, 0x7F0A0C6E);  // id:tv_empty
                                    if(((MelonTextView)view7) != null) {
                                        v = 0x7F0A0D34;  // id:tv_title
                                        View view8 = I.C(view0, 0x7F0A0D34);  // id:tv_title
                                        if(((MelonTextView)view8) != null) {
                                            this.b = new K(((RelativeLayout)view0), ((ConstraintLayout)view1), ((RelativeLayout)view0), ((MelonTextView)view2), ((RelativeLayout)view3), view4, ((RecyclerView)view5), ((MelonTextView)view6), ((MelonTextView)view7), ((MelonTextView)view8));
                                            q.f(((RelativeLayout)view0), "getRoot(...)");
                                            return (RelativeLayout)view0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }

        @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
        public void onDestroy() {
            super.onDestroy();
            this.b = null;
        }

        @Override  // com.iloen.melon.fragments.FetcherBaseFragment
        public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
            K k0 = this.b;
            q.d(k0);
            ArrayList arrayList0 = null;
            ((MelonTextView)k0.k).setText((this.c == null ? null : this.c.title));
            if(this.a.isFullScreen()) {
                K k1 = this.b;
                q.d(k1);
                int v = ColorUtils.getColor(this.getContext(), 0x7F0604A1);  // color:white000e
                ((MelonTextView)k1.k).setTextColor(v);
                K k2 = this.b;
                q.d(k2);
                int v1 = ColorUtils.getColor(this.getContext(), 0x7F0604A1);  // color:white000e
                k2.d.setTextColor(v1);
                K k3 = this.b;
                q.d(k3);
                int v2 = ColorUtils.getColor(this.getContext(), 0x7F0604A1);  // color:white000e
                k3.f.setTextColor(v2);
                K k4 = this.b;
                q.d(k4);
                k4.f.setCompoundDrawablesWithIntrinsicBounds(0x7F08011A, 0, 0, 0);  // drawable:btn_common_add_17_w
            }
            else {
                K k5 = this.b;
                q.d(k5);
                int v3 = ColorUtils.getColor(this.getContext(), 0x7F06016D);  // color:gray900s
                ((MelonTextView)k5.k).setTextColor(v3);
                K k6 = this.b;
                q.d(k6);
                int v4 = ColorUtils.getColor(this.getContext(), 0x7F06016D);  // color:gray900s
                k6.d.setTextColor(v4);
                K k7 = this.b;
                q.d(k7);
                int v5 = ColorUtils.getColor(this.getContext(), 0x7F060165);  // color:gray800s
                k7.f.setTextColor(v5);
                K k8 = this.b;
                q.d(k8);
                k8.f.setCompoundDrawablesWithIntrinsicBounds(0x7F080118, 0, 0, 0);  // drawable:btn_common_add_17_off
            }
            K k9 = this.b;
            q.d(k9);
            v v6 = new v(this, 4);
            ViewUtils.setOnClickListener(k9.f, v6);
            RESPONSE liveTimedMetaSongRes$RESPONSE0 = this.c;
            if(liveTimedMetaSongRes$RESPONSE0 != null) {
                arrayList0 = liveTimedMetaSongRes$RESPONSE0.songList;
            }
            if(arrayList0 != null && !arrayList0.isEmpty()) {
                K k10 = this.b;
                q.d(k10);
                ViewUtils.showWhen(((MelonTextView)k10.j), false);
                K k11 = this.b;
                q.d(k11);
                ViewUtils.hideWhen(((RecyclerView)k11.i), false);
                j0 j00 = this.getAdapter();
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.SongItemAdapter");
                ((SongItemAdapter)j00).setData(arrayList0);
                return true;
            }
            K k12 = this.b;
            q.d(k12);
            ViewUtils.showWhen(((MelonTextView)k12.j), true);
            K k13 = this.b;
            q.d(k13);
            ViewUtils.hideWhen(((RecyclerView)k13.i), true);
            return true;
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        public void onRestoreInstanceState(@NotNull Bundle bundle0) {
            q.g(bundle0, "inState");
            this.c = (RESPONSE)b.G(bundle0, "argSongRes", RESPONSE.class);
        }

        @Override  // com.iloen.melon.fragments.MelonBaseFragment
        public void onSaveInstanceState(@NotNull Bundle bundle0) {
            q.g(bundle0, "outState");
            super.onSaveInstanceState(bundle0);
            bundle0.putSerializable("argSongRes", this.c);
        }

        @Override  // com.iloen.melon.fragments.FetcherBaseFragment
        public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
            int v7;
            int v4;
            int v3;
            int v2;
            int v1;
            float f1;
            q.g(view0, "view");
            super.onViewCreated(view0, bundle0);
            this.mMenuId = "1000002967";
            Context context0 = this.getContext();
            float f = 0.0f;
            if(context0 == null) {
                f1 = 0.0f;
            }
            else {
                Resources resources0 = context0.getResources();
                f1 = resources0 == null ? 0.0f : resources0.getDimension(0x7F07047C);  // dimen:video_song_list_bottomsheet_header_height
            }
            Context context1 = this.getContext();
            if(context1 != null) {
                Resources resources1 = context1.getResources();
                if(resources1 != null) {
                    f = resources1.getDimension(0x7F07047B);  // dimen:video_song_list_bottomsheet_footer_height
                }
            }
            LiveViewModel liveViewModel0 = this.a;
            int v = 17;
            if(liveViewModel0.isFullScreen()) {
                if(((Boolean)liveViewModel0.isOrientationPortrait().getValue()).booleanValue()) {
                    int v5 = (int)(f1 + ((float)ViewUtilsKt.dpToPx(330)) + f);
                    int v6 = ((Number)liveViewModel0.getScreenHeight().getValue()).intValue();
                    if(v5 > v6) {
                        v5 = v6;
                    }
                    v2 = 0x7F08088B;  // drawable:shape_gradient_gray600e_transparent_angle270
                    v4 = -2;
                    v3 = v5;
                    v1 = -1;
                }
                else {
                    v1 = ScreenUtils.dipToPixel(this.getContext(), 340.0f);
                    v = 3;
                    v2 = 0x7F08088A;  // drawable:shape_gradient_gray600e_transparent_angle180
                    v3 = -1;
                    v4 = -1;
                }
                v7 = 0x7F0604AE;  // color:white120e
            }
            else {
                if(((Boolean)liveViewModel0.isTopBottomSplit().getValue()).booleanValue()) {
                    v3 = liveViewModel0.getLiveBottomSheetMaxHeightForSeparated();
                    v1 = -1;
                }
                else {
                    v1 = liveViewModel0.getLiveBottomSheetMaxWidthForSeparated();
                    v = 5;
                    v3 = -1;
                }
                v2 = 0x7F08091C;  // drawable:shape_white001s_top_round8
                v7 = 0x7F06014A;  // color:gray100a
                v4 = -2;
            }
            LogU.debug$default(this.e, "onViewCreated width - " + v1, null, false, 6, null);
            K k0 = this.b;
            q.d(k0);
            RelativeLayout relativeLayout0 = (RelativeLayout)k0.g;
            q.f(relativeLayout0, "bottomSheetMaxHeightFrame");
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = relativeLayout0.getLayoutParams();
            if(viewGroup$LayoutParams0 != null) {
                ((FrameLayout.LayoutParams)viewGroup$LayoutParams0).width = v1;
                ((FrameLayout.LayoutParams)viewGroup$LayoutParams0).gravity = v | 80;
                ((FrameLayout.LayoutParams)viewGroup$LayoutParams0).height = v3;
                relativeLayout0.setLayoutParams(((FrameLayout.LayoutParams)viewGroup$LayoutParams0));
                switch(v4) {
                    case -2: {
                        K k1 = this.b;
                        q.d(k1);
                        ConstraintLayout constraintLayout0 = k1.c;
                        q.f(constraintLayout0, "bottomSheetContainer");
                        ViewGroup.LayoutParams viewGroup$LayoutParams1 = constraintLayout0.getLayoutParams();
                        if(viewGroup$LayoutParams1 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                        }
                        viewGroup$LayoutParams1.height = -2;
                        constraintLayout0.setLayoutParams(viewGroup$LayoutParams1);
                        K k2 = this.b;
                        q.d(k2);
                        RelativeLayout relativeLayout1 = (RelativeLayout)k2.h;
                        q.f(relativeLayout1, "contentContainer");
                        ViewGroup.LayoutParams viewGroup$LayoutParams2 = relativeLayout1.getLayoutParams();
                        if(viewGroup$LayoutParams2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        }
                        ((LayoutParams)viewGroup$LayoutParams2).height = -2;
                        relativeLayout1.setLayoutParams(((LayoutParams)viewGroup$LayoutParams2));
                        K k3 = this.b;
                        q.d(k3);
                        RecyclerView recyclerView0 = (RecyclerView)k3.i;
                        q.f(recyclerView0, "recyclerView");
                        ViewGroup.LayoutParams viewGroup$LayoutParams3 = recyclerView0.getLayoutParams();
                        if(viewGroup$LayoutParams3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                        }
                        viewGroup$LayoutParams3.height = -2;
                        recyclerView0.setLayoutParams(viewGroup$LayoutParams3);
                        goto label_113;
                    }
                    case -1: {
                        K k4 = this.b;
                        q.d(k4);
                        ConstraintLayout constraintLayout1 = k4.c;
                        q.f(constraintLayout1, "bottomSheetContainer");
                        ViewGroup.LayoutParams viewGroup$LayoutParams4 = constraintLayout1.getLayoutParams();
                        if(viewGroup$LayoutParams4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                        }
                        viewGroup$LayoutParams4.height = -1;
                        constraintLayout1.setLayoutParams(viewGroup$LayoutParams4);
                        K k5 = this.b;
                        q.d(k5);
                        RelativeLayout relativeLayout2 = (RelativeLayout)k5.h;
                        q.f(relativeLayout2, "contentContainer");
                        ViewGroup.LayoutParams viewGroup$LayoutParams5 = relativeLayout2.getLayoutParams();
                        if(viewGroup$LayoutParams5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        }
                        ((LayoutParams)viewGroup$LayoutParams5).height = 0;
                        relativeLayout2.setLayoutParams(((LayoutParams)viewGroup$LayoutParams5));
                        K k6 = this.b;
                        q.d(k6);
                        RecyclerView recyclerView1 = (RecyclerView)k6.i;
                        q.f(recyclerView1, "recyclerView");
                        ViewGroup.LayoutParams viewGroup$LayoutParams6 = recyclerView1.getLayoutParams();
                        if(viewGroup$LayoutParams6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                        }
                        viewGroup$LayoutParams6.height = -1;
                        recyclerView1.setLayoutParams(viewGroup$LayoutParams6);
                    label_113:
                        K k7 = this.b;
                        q.d(k7);
                        k7.c.setBackgroundResource(v2);
                        K k8 = this.b;
                        q.d(k8);
                        int v8 = ColorUtils.getColor(this.getContext(), v7);
                        k8.e.setBackgroundColor(v8);
                        D d0 = this.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
                            public int r;
                            public final SongListFragment w;

                            {
                                this.w = videoSongListBottomSheetFragment$SongListFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.onViewCreated.8(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.onViewCreated.8)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        D d0 = this.w.getViewLifecycleOwner();
                                        q.f(d0, "getViewLifecycleOwner(...)");
                                        com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.onViewCreated.8.1 videoSongListBottomSheetFragment$SongListFragment$onViewCreated$8$10 = new n(null) {
                                            public int r;
                                            public final SongListFragment w;

                                            {
                                                this.w = videoSongListBottomSheetFragment$SongListFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.onViewCreated.8.1(this.w, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.onViewCreated.8.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                a a0 = a.a;
                                                switch(this.r) {
                                                    case 0: {
                                                        d5.n.D(object0);
                                                        com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.onViewCreated.8.1.1 videoSongListBottomSheetFragment$SongListFragment$onViewCreated$8$1$10 = new FlowCollector() {
                                                            public final SongListFragment a;

                                                            {
                                                                this.a = videoSongListBottomSheetFragment$SongListFragment0;
                                                            }

                                                            public final Object emit(VideoStatus videoStatus0, Continuation continuation0) {
                                                                if(videoStatus0 == VideoStatus.MiniMode) {
                                                                    SongListFragment.access$closeBottomSheet(this.a);
                                                                }
                                                                return H.a;
                                                            }

                                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                                            public Object emit(Object object0, Continuation continuation0) {
                                                                return this.emit(((VideoStatus)object0), continuation0);
                                                            }
                                                        };
                                                        this.r = 1;
                                                        if(this.w.a.getVideoStatus().collect(videoSongListBottomSheetFragment$SongListFragment$onViewCreated$8$1$10, this) == a0) {
                                                            return a0;
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        d5.n.D(object0);
                                                        break;
                                                    }
                                                    default: {
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                }
                                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                            }
                                        };
                                        this.r = 1;
                                        return f0.j(d0, s.d, videoSongListBottomSheetFragment$SongListFragment$onViewCreated$8$10, this) == a0 ? a0 : H.a;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        return H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        }, 3, null);
                        if(liveViewModel0.isFullScreen()) {
                            D d1 = this.getViewLifecycleOwner();
                            q.f(d1, "getViewLifecycleOwner(...)");
                            BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new n(null) {
                                public int r;
                                public final SongListFragment w;

                                {
                                    this.w = videoSongListBottomSheetFragment$SongListFragment0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    return new com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.onViewCreated.9(this.w, continuation0);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                    return ((com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.onViewCreated.9)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    a a0 = a.a;
                                    switch(this.r) {
                                        case 0: {
                                            d5.n.D(object0);
                                            com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.onViewCreated.9.1 videoSongListBottomSheetFragment$SongListFragment$onViewCreated$9$10 = new n(null) {
                                                public Object r;
                                                public final SongListFragment w;

                                                {
                                                    this.w = videoSongListBottomSheetFragment$SongListFragment0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // oe.a
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    Continuation continuation1 = new com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.onViewCreated.9.1(this.w, continuation0);
                                                    continuation1.r = object0;
                                                    return continuation1;
                                                }

                                                public final Object invoke(ControllerVisibleStatus controllerVisibleStatus0, Continuation continuation0) {
                                                    return ((com.iloen.melon.player.video.VideoSongListBottomSheetFragment.SongListFragment.onViewCreated.9.1)this.create(controllerVisibleStatus0, continuation0)).invokeSuspend(H.a);
                                                }

                                                @Override  // we.n
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((ControllerVisibleStatus)object0), ((Continuation)object1));
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    ControllerVisibleStatus controllerVisibleStatus0 = (ControllerVisibleStatus)this.r;
                                                    d5.n.D(object0);
                                                    if(controllerVisibleStatus0 != ControllerVisibleStatus.ALL_GONE) {
                                                        SongListFragment.access$closeBottomSheet(this.w);
                                                    }
                                                    return H.a;
                                                }
                                            };
                                            this.r = 1;
                                            return FlowKt.collectLatest(this.w.a.getControllerVisibleType(), videoSongListBottomSheetFragment$SongListFragment$onViewCreated$9$10, this) == a0 ? a0 : H.a;
                                        }
                                        case 1: {
                                            d5.n.D(object0);
                                            return H.a;
                                        }
                                        default: {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                    }
                                }
                            }, 3, null);
                        }
                        return;
                    }
                    default: {
                        goto label_113;
                    }
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        public boolean shouldShowMiniPlayer() {
            return false;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "VideoSongListBottomSheetFragment";
    public final LiveViewModel a;
    public final RESPONSE b;
    public final LogU c;
    public androidx.fragment.app.I d;
    public boolean e;

    static {
        VideoSongListBottomSheetFragment.Companion = new Companion(null);
        VideoSongListBottomSheetFragment.$stable = 8;
    }

    public VideoSongListBottomSheetFragment(@NotNull LiveViewModel liveViewModel0, @NotNull RESPONSE liveTimedMetaSongRes$RESPONSE0) {
        q.g(liveViewModel0, "viewModel");
        q.g(liveTimedMetaSongRes$RESPONSE0, "songListRes");
        super();
        this.a = liveViewModel0;
        this.b = liveTimedMetaSongRes$RESPONSE0;
        LogU logU0 = Z.g("VideoSongListBottomSheetFragment", true);
        logU0.setCategory(Category.UI);
        this.c = logU0;
    }

    @NotNull
    public final LogU getLog() {
        return this.c;
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public boolean isHideStatusBar() {
        return this.a.isFullScreen();
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public androidx.fragment.app.I newFragment() {
        return this.newFragment();
    }

    @NotNull
    public MelonBaseFragment newFragment() {
        return SongListFragment.Companion.newInstance(this.b, this.a);
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public void onDialogShow(@NotNull DialogInterface dialogInterface0) {
        q.g(dialogInterface0, "it");
        super.onDialogShow(dialogInterface0);
        this.a.updateIsShowingSongListBottomSheet(true);
        if(this.a.isFullScreen() && !((Boolean)this.a.isOrientationPortrait().getValue()).booleanValue()) {
            BottomSheetBehavior bottomSheetBehavior0 = this.getBehavior();
            if(bottomSheetBehavior0 != null) {
                bottomSheetBehavior0.g0 = false;
            }
        }
    }

    @Override  // androidx.fragment.app.w
    public void onDismiss(@NotNull DialogInterface dialogInterface0) {
        q.g(dialogInterface0, "dialog");
        super.onDismiss(dialogInterface0);
        this.a.updateIsShowingSongListBottomSheet(false);
        this.a.updateControllerAllVisible(Boolean.valueOf(this.e));
    }

    public final void setParentFragment(@NotNull androidx.fragment.app.I i0) {
        q.g(i0, "fragment");
        this.d = i0;
    }

    public final void setShowControllerAfterClosing(boolean z) {
        this.e = z;
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public boolean useDirectExpand() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public boolean useTransparentBackground() {
        return this.a.isFullScreen();
    }
}

