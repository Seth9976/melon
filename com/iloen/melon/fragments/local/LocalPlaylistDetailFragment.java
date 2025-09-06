package com.iloen.melon.fragments.local;

import E9.h;
import F8.G;
import F8.o;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.adapters.common.s;
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.custom.FilterLayout;
import com.iloen.melon.custom.I;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import e.k;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import v9.e;
import v9.m;
import we.n;
import z6.f;

@Metadata(d1 = {"\u0000\u00AC\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 _2\u00020\u0001:\u0002_`B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0003J\u000F\u0010\u0014\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0003J\u001B\u0010\u001A\u001A\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u0018\u001A\u00020\u0017H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001D\u001A\u00020\u001CH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010!\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u001FH\u0014\u00A2\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001A\u0004\u0018\u00010\u0007H\u0014\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\u0013H\u0014\u00A2\u0006\u0004\b%\u0010\u0015J\u000F\u0010&\u001A\u00020\u0013H\u0014\u00A2\u0006\u0004\b&\u0010\u0015J\u000F\u0010\'\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\'\u0010\u0003J\u0011\u0010)\u001A\u0004\u0018\u00010(H\u0014\u00A2\u0006\u0004\b)\u0010*J!\u0010.\u001A\u00020\u000B2\b\u0010,\u001A\u0004\u0018\u00010+2\u0006\u0010-\u001A\u00020\u0013H\u0014\u00A2\u0006\u0004\b.\u0010/J\'\u00104\u001A\u00020\u000B2\u0006\u00101\u001A\u0002002\u0006\u00102\u001A\u0002002\u0006\u00103\u001A\u000200H\u0014\u00A2\u0006\u0004\b4\u00105J\u0019\u00108\u001A\u0002002\b\u00107\u001A\u0004\u0018\u000106H\u0002\u00A2\u0006\u0004\b8\u00109J\u0017\u0010;\u001A\u00020\u000B2\u0006\u0010:\u001A\u000200H\u0002\u00A2\u0006\u0004\b;\u0010<J\u001D\u0010@\u001A\u00020?2\f\u0010>\u001A\b\u0012\u0004\u0012\u0002060=H\u0002\u00A2\u0006\u0004\b@\u0010AJ\u001D\u0010C\u001A\u00020\u000B2\f\u0010B\u001A\b\u0012\u0004\u0012\u0002060=H\u0002\u00A2\u0006\u0004\bC\u0010DJ-\u0010F\u001A\u00020\u000B2\f\u0010B\u001A\b\u0012\u0004\u0012\u0002060E2\u0006\u00102\u001A\u0002002\u0006\u00103\u001A\u000200H\u0002\u00A2\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001A\u0002002\u0006\u0010H\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\bI\u0010JR\u0018\u0010L\u001A\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001A\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010R\u001A\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bR\u0010SR\u001B\u0010Y\u001A\u00020T8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bU\u0010V\u001A\u0004\bW\u0010XR\u0016\u0010Z\u001A\u00020?8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001A\u00020?8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\\\u0010[R\u0016\u0010]\u001A\u0002008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b]\u0010^\u00A8\u0006a"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistDetailFragment;", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment;", "<init>", "()V", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onPause", "", "getLocalTrackType", "()I", "startQuery", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "", "ratio", "updateHeaderRatio", "(F)V", "buildParallaxHeaderView", "()Landroid/view/View;", "getParallaxHeaderHeight", "getParallaxFixedHeight", "onAddSongsToLocalPlaylist", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "", "playAll", "nowPlay", "needShufflePlay", "playSongs", "(ZZZ)V", "Lcom/iloen/melon/playback/Playable;", "playable", "isAvailableItem", "(Lcom/iloen/melon/playback/Playable;)Z", "isVisible", "setAllCheckButtonVisibility", "(Z)V", "", "playlist", "", "getAllDuration", "(Ljava/util/List;)Ljava/lang/String;", "playableList", "setSongCntAndDuration", "(Ljava/util/List;)V", "Ljava/util/ArrayList;", "checkAndPlaySongs", "(Ljava/util/ArrayList;ZZ)V", "position", "setMarkedItem", "(I)Z", "Landroid/widget/ImageView;", "bgIv", "Landroid/widget/ImageView;", "Lcom/iloen/melon/custom/FilterLayout;", "filterLayout", "Lcom/iloen/melon/custom/FilterLayout;", "Landroid/widget/TextView;", "playlistNameTv", "Landroid/widget/TextView;", "LF8/G;", "editBtn$delegate", "Lie/j;", "getEditBtn", "()LF8/G;", "editBtn", "songCnt", "Ljava/lang/String;", "plyduration", "isFilterVisible", "Z", "Companion", "LocalPlaylistDetailSongAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LocalPlaylistDetailFragment extends LocalContentNewDbBaseFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistDetailFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/local/LocalPlaylistDetailFragment;", "playlistId", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LocalPlaylistDetailFragment newInstance(long v) {
            LocalPlaylistDetailFragment localPlaylistDetailFragment0 = new LocalPlaylistDetailFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putLong("playlistid", v);
            bundle0.putString("argPlaybackMenuId", "1000000350");
            localPlaylistDetailFragment0.setArguments(bundle0);
            return localPlaylistDetailFragment0;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0011\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\u000B\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u00032\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001C\u001A\u00020\u001A2\u0006\u0010\n\u001A\u00020\b2\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u001B\u001A\u00020\u001AH\u0014¢\u0006\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001E\u0010\u001F¨\u0006!"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistDetailFragment$LocalPlaylistDetailSongAdapter;", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$LocalContentBaseSongAdapter;", "Lcom/iloen/melon/playback/Playable;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "<init>", "(Lcom/iloen/melon/fragments/local/LocalPlaylistDetailFragment;Landroid/content/Context;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "getServiceAvailableCount", "()I", "", "key", "", "marked", "setMarked", "(ILjava/lang/String;Z)Z", "PLAYLIST", "I", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LocalPlaylistDetailSongAdapter extends LocalContentBaseSongAdapter {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0019\u0010\u000B\u001A\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000B\u0010\b\u001A\u0004\b\f\u0010\nR\u0017\u0010\r\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001A\u0004\b\u000E\u0010\nR\u0017\u0010\u000F\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000F\u0010\b\u001A\u0004\b\u0010\u0010\nR\u0017\u0010\u0012\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001A\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001A\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001A\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001A\u0010\b\u001A\u0004\b\u001B\u0010\nR\u0017\u0010\u001C\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001C\u0010\b\u001A\u0004\b\u001D\u0010\n¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/local/LocalPlaylistDetailFragment$LocalPlaylistDetailSongAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "defaultThumbnail", "Landroid/widget/ImageView;", "getDefaultThumbnail", "()Landroid/widget/ImageView;", "thumbnail", "getThumbnail", "listDcf", "getListDcf", "listMp3", "getListMp3", "Landroid/widget/TextView;", "listFlac", "Landroid/widget/TextView;", "getListFlac", "()Landroid/widget/TextView;", "titleText", "getTitleText", "artistText", "getArtistText", "btnPlay", "getBtnPlay", "btnInfo", "getBtnInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ViewHolder extends O0 {
            @NotNull
            private final TextView artistText;
            @NotNull
            private final ImageView btnInfo;
            @NotNull
            private final ImageView btnPlay;
            @NotNull
            private final ImageView defaultThumbnail;
            @NotNull
            private final ImageView listDcf;
            @NotNull
            private final TextView listFlac;
            @NotNull
            private final ImageView listMp3;
            @Nullable
            private final ImageView thumbnail;
            @NotNull
            private final TextView titleText;

            public ViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                LocalPlaylistDetailSongAdapter.this = localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0;
                super(view0);
                Context context0 = view0.getContext();
                View view1 = view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
                q.f(view1, "findViewById(...)");
                this.defaultThumbnail = (ImageView)view1;
                ViewUtils.setDefaultImage(((ImageView)view1), ScreenUtils.dipToPixel(context0, 48.0f));
                this.thumbnail = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
                View view2 = view0.findViewById(0x7F0A063E);  // id:iv_list_dcf
                q.f(view2, "findViewById(...)");
                this.listDcf = (ImageView)view2;
                View view3 = view0.findViewById(0x7F0A0643);  // id:iv_list_mp3
                q.f(view3, "findViewById(...)");
                this.listMp3 = (ImageView)view3;
                View view4 = view0.findViewById(0x7F0A063F);  // id:iv_list_flac
                q.f(view4, "findViewById(...)");
                this.listFlac = (TextView)view4;
                View view5 = view0.findViewById(0x7F0A0D34);  // id:tv_title
                q.f(view5, "findViewById(...)");
                this.titleText = (TextView)view5;
                View view6 = view0.findViewById(0x7F0A0C12);  // id:tv_artist
                q.f(view6, "findViewById(...)");
                this.artistText = (TextView)view6;
                View view7 = view0.findViewById(0x7F0A0182);  // id:btn_play
                q.f(view7, "findViewById(...)");
                this.btnPlay = (ImageView)view7;
                View view8 = view0.findViewById(0x7F0A0169);  // id:btn_info
                q.f(view8, "findViewById(...)");
                this.btnInfo = (ImageView)view8;
            }

            @NotNull
            public final TextView getArtistText() {
                return this.artistText;
            }

            @NotNull
            public final ImageView getBtnInfo() {
                return this.btnInfo;
            }

            @NotNull
            public final ImageView getBtnPlay() {
                return this.btnPlay;
            }

            @NotNull
            public final ImageView getDefaultThumbnail() {
                return this.defaultThumbnail;
            }

            @NotNull
            public final ImageView getListDcf() {
                return this.listDcf;
            }

            @NotNull
            public final TextView getListFlac() {
                return this.listFlac;
            }

            @NotNull
            public final ImageView getListMp3() {
                return this.listMp3;
            }

            @Nullable
            public final ImageView getThumbnail() {
                return this.thumbnail;
            }

            @NotNull
            public final TextView getTitleText() {
                return this.titleText;
            }
        }

        private final int PLAYLIST;

        public LocalPlaylistDetailSongAdapter(@Nullable Context context0) {
            super(context0, null);
            this.PLAYLIST = 1;
        }

        // 检测为 Lambda 实现
        public static boolean b(View view0) [...]

        // 检测为 Lambda 实现
        public static boolean c(LocalPlaylistDetailFragment localPlaylistDetailFragment0, int v, Playable playable0, LocalPlaylistDetailSongAdapter localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0, View view0) [...]

        public static void d(View view0) {
        }

        public static void e(LocalPlaylistDetailFragment localPlaylistDetailFragment0, int v, Playable playable0, LocalPlaylistDetailSongAdapter localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0, View view0) {
            LocalPlaylistDetailSongAdapter.onBindViewImpl$lambda$7(playable0, localPlaylistDetailFragment0, localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0, v, view0);
        }

        public static void f(View view0) {
        }

        public static void g(View view0) {
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.PLAYLIST;
        }

        @Override  // com.iloen.melon.adapters.common.q
        public int getServiceAvailableCount() {
            List list0 = this.getList();
            q.f(list0, "getList(...)");
            LocalPlaylistDetailFragment localPlaylistDetailFragment0 = LocalPlaylistDetailFragment.this;
            int v = 0;
            if(list0 instanceof Collection && list0.isEmpty()) {
                return 0;
            }
            for(Object object0: list0) {
                if(localPlaylistDetailFragment0.isAvailableItem((object0 instanceof Playable ? ((Playable)object0) : null))) {
                    ++v;
                    if(v < 0) {
                        k.N();
                        throw null;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return v;
        }

        public static void h(LocalPlaylistDetailFragment localPlaylistDetailFragment0, int v, Playable playable0, LocalPlaylistDetailSongAdapter localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0, View view0) {
            LocalPlaylistDetailSongAdapter.onBindViewImpl$lambda$5(localPlaylistDetailFragment0, v, playable0, localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.LocalPlaylistDetailSongAdapter.ViewHolder");
            ViewHolder localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0 = (ViewHolder)o00;
            Playable playable0 = (Playable)this.getItem(v1);
            boolean z = false;
            if(LocalPlaylistDetailFragment.this.isAvailableItem(playable0)) {
                z z1 = (View view0) -> {
                    LocalPlaylistDetailFragment.this.onItemClick(view0, v);
                    if(this.getContext() != null) {
                        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                        g0.a = "선택";
                        g0.d = ActionKind.ClickContent;
                        g0.b = "보관함";
                        g0.c = "보관함_로컬플레이리스트";
                        g0.y = "곡리스트";
                        g0.F = "곡선택";
                        g0.I = "1000000350";
                        g0.C = String.valueOf(v1 + 1);
                        String s = null;
                        g0.e = playable0 == null ? null : "";
                        if(playable0 != null) {
                            s = "";
                        }
                        g0.g = s;
                        g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                        g0.a().track();
                    }
                };
                ViewUtils.setOnClickListener(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.itemView, z1);
                ViewUtils.setEnable(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.itemView, true, true);
                if(this.isMarked(v1)) {
                    int v2 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                    localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.itemView.setBackgroundColor(v2);
                }
                else {
                    int v3 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                    localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.itemView.setBackgroundColor(v3);
                }
                A a0 = (View view0) -> LocalPlaylistDetailSongAdapter.onBindViewImpl$lambda$3(LocalPlaylistDetailFragment.this, playable0, this, v1, view0);
                ViewUtils.setOnLongClickListener(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.itemView, a0);
                ViewUtils.showWhen(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getBtnPlay(), true);
                ViewUtils.showWhen(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getBtnInfo(), true);
                ViewUtils.setOnClickListener(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getBtnInfo(), new B(LocalPlaylistDetailFragment.this, v1, playable0, this));
                ViewUtils.setOnClickListener(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getBtnPlay(), new B(playable0, LocalPlaylistDetailFragment.this, this, v1));
            }
            else {
                C c0 = new C(0);
                ViewUtils.setOnClickListener(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.itemView, c0);
                ViewUtils.setEnable(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.itemView, false, true);
                int v4 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.itemView.setBackgroundColor(v4);
                D d0 = (View view0) -> false;
                ViewUtils.setOnLongClickListener(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.itemView, d0);
                ViewUtils.showWhen(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getBtnPlay(), true);
                ViewUtils.showWhen(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getBtnInfo(), true);
                ViewUtils.setOnClickListener(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getBtnInfo(), new C(1));
                ViewUtils.setOnClickListener(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getBtnPlay(), new C(2));
            }
            int v5 = FilenameUtils.getFileType("");
            ViewUtils.showWhen(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getListDcf(), 0x402 == v5);
            ViewUtils.showWhen(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getListFlac(), 0x202 == v5);
            ImageView imageView0 = localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getListMp3();
            if(0x402 != v5 && 0x202 != v5) {
                z = true;
            }
            ViewUtils.showWhen(imageView0, z);
            String s = null;
            String s1 = playable0 == null ? null : "";
            TextView textView0 = localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getTitleText();
            if(TextUtils.isEmpty(s1)) {
                s1 = "";
            }
            textView0.setText(s1);
            ViewUtils.setTextViewMarquee(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getTitleText(), this.isMarqueeNeeded(v1));
            if(playable0 != null) {
                s = "";
            }
            localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getArtistText().setText((TextUtils.isEmpty(s) ? "" : s));
            if(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getThumbnail() != null) {
                StorageUtils.isScopedStorage();
                String s2 = f.i(s, "", "");
                LocalPlaylistDetailFragment.this.showAlbumImage(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter$ViewHolder0.getThumbnail(), "", (playable0 == null ? 0L : playable0.getMediaStoreAlbumId()), s2);
            }
        }

        // 检测为 Lambda 实现
        private static final void onBindViewImpl$lambda$1(LocalPlaylistDetailFragment localPlaylistDetailFragment0, int v, LocalPlaylistDetailSongAdapter localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0, int v1, Playable playable0, View view0) [...]

        private static final void onBindViewImpl$lambda$10(View view0) {
        }

        private static final void onBindViewImpl$lambda$11(View view0) {
        }

        private static final boolean onBindViewImpl$lambda$3(LocalPlaylistDetailFragment localPlaylistDetailFragment0, Playable playable0, LocalPlaylistDetailSongAdapter localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0, int v, View view0) {
            localPlaylistDetailFragment0.showMoreContextPopup(playable0);
            if(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0.getContext() != null) {
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.a = "페이지이동";
                g0.d = ActionKind.ClickContent;
                g0.b = "보관함";
                g0.c = "보관함_로컬플레이리스트";
                g0.y = "곡리스트";
                g0.F = "곡더보기";
                g0.I = "1000000350";
                String s = null;
                g0.e = playable0 == null ? null : "";
                if(playable0 != null) {
                    s = "";
                }
                g0.g = s;
                g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                g0.C = String.valueOf(v + 1);
                g0.a().track();
            }
            return true;
        }

        private static final void onBindViewImpl$lambda$5(LocalPlaylistDetailFragment localPlaylistDetailFragment0, int v, Playable playable0, LocalPlaylistDetailSongAdapter localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0, View view0) {
            if(localPlaylistDetailFragment0.setMarkedItem(v)) {
                localPlaylistDetailFragment0.showMoreContextPopup(playable0);
            }
            if(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0.getContext() != null) {
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.a = "페이지이동";
                g0.d = ActionKind.ClickContent;
                g0.b = "보관함";
                g0.c = "보관함_로컬플레이리스트";
                g0.y = "곡리스트";
                g0.F = "곡더보기";
                g0.I = "1000000350";
                g0.C = String.valueOf(v + 1);
                String s = null;
                g0.e = playable0 == null ? null : "";
                if(playable0 != null) {
                    s = "";
                }
                g0.g = s;
                g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                g0.a().track();
            }
        }

        private static final void onBindViewImpl$lambda$7(Playable playable0, LocalPlaylistDetailFragment localPlaylistDetailFragment0, LocalPlaylistDetailSongAdapter localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0, int v, View view0) {
            if(playable0 != null) {
                playable0.setMenuid(localPlaylistDetailFragment0.mPlaybackMenuId);
            }
            localPlaylistDetailFragment0.playSong(Playable.copyValueOf(playable0), true);
            if(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0.getContext() != null) {
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.a = "음악재생";
                g0.d = ActionKind.PlayMusic;
                g0.b = "보관함";
                g0.c = "보관함_로컬플레이리스트";
                g0.y = "곡리스트";
                g0.F = "음악재생";
                g0.I = "1000000350";
                g0.C = String.valueOf(v + 1);
                String s = null;
                g0.e = playable0 == null ? null : "";
                if(playable0 != null) {
                    s = "";
                }
                g0.g = s;
                g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                g0.a().track();
            }
        }

        private static final void onBindViewImpl$lambda$8(View view0) {
        }

        private static final boolean onBindViewImpl$lambda$9(View view0) [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04AE, viewGroup0, false);  // layout:listitem_song_new
            q.f(view0, "inflate(...)");
            return new ViewHolder(this, view0);
        }

        @Override  // com.iloen.melon.adapters.common.q
        public boolean setMarked(int v, @Nullable String s, boolean z) {
            Playable playable0 = (Playable)this.getItem(v);
            return LocalPlaylistDetailFragment.this.isAvailableItem(playable0) ? super.setMarked(v, s, z) : false;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "LocalPlaylistDetailFragment";
    @Nullable
    private ImageView bgIv;
    @NotNull
    private final j editBtn$delegate;
    @Nullable
    private FilterLayout filterLayout;
    private boolean isFilterVisible;
    @Nullable
    private TextView playlistNameTv;
    @NotNull
    private String plyduration;
    @NotNull
    private String songCnt;

    static {
        LocalPlaylistDetailFragment.Companion = new Companion(null);
        LocalPlaylistDetailFragment.$stable = 8;
    }

    public LocalPlaylistDetailFragment() {
        this.editBtn$delegate = d3.g.Q(() -> new G());  // 初始化器: Ljava/lang/Object;-><init>()V
        this.songCnt = "";
        this.plyduration = "";
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @Nullable
    public View buildParallaxHeaderView() {
        return LayoutInflater.from(this.getContext()).inflate(0x7F0D04BE, null, false);  // layout:local_playlist_detail_header
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        return ToolBar.f(((ToolBar)view0), 102);
    }

    private final void checkAndPlaySongs(ArrayList arrayList0, boolean z, boolean z1) {
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            if(this.isAvailableItem(((Playable)object0))) {
                arrayList1.add(object0);
            }
        }
        if(!arrayList1.isEmpty()) {
            this.playSongs(h.W(arrayList1), z, false, z1);
            return;
        }
        ToastManager.show(0x7F13038A);  // string:empty_list_song "재생 가능한 곡이 없습니다."
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new LocalPlaylistDetailSongAdapter(this, this.getContext());
        ((com.iloen.melon.adapters.common.j)j00).setListContentType(1);
        ((com.iloen.melon.adapters.common.j)j00).setMarkedMode(true);
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.f = this.getString(0x7F130509);  // string:localplaylist_edit_empty_text "수록곡이 없습니다."
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    // 检测为 Lambda 实现
    private static final G editBtn_delegate$lambda$0() [...]

    private final String getAllDuration(List list0) {
        long v = 0L;
        for(Object object0: list0) {
            v += ((Playable)object0).getDuration();
        }
        return StringUtils.INSTANCE.formatPlaylistTime(v);
    }

    private final G getEditBtn() {
        return (G)this.editBtn$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public int getLocalTrackType() {
        return 4;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        Context context0 = this.getContext();
        return this.isFilterVisible ? ScreenUtils.dipToPixel(context0, 156.0f) : ScreenUtils.dipToPixel(context0, 116.0f);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        Context context0 = this.getContext();
        return this.isFilterVisible ? ScreenUtils.dipToPixel(context0, 383.0f) : ScreenUtils.dipToPixel(context0, 345.0f);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "storageboxLocalplaylistDetail");
    }

    private final boolean isAvailableItem(Playable playable0) {
        return playable0 != null && !playable0.isTypeOfEdu();
    }

    @NotNull
    public static final LocalPlaylistDetailFragment newInstance(long v) {
        return LocalPlaylistDetailFragment.Companion.newInstance(v);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onAddSongsToLocalPlaylist() {
        if(this.isAdded()) {
            this.startFetch("add local playlist");
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.updateParallaxTranslation(0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new DetailLinearLayoutManager(this.getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.setSelectAllWithToolbar(false);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@Nullable ToolBarItem toolBar$ToolBarItem0, int v) {
        if(this.getContentAdapter() == null) {
            String s = this.getTAG();
            LogU.Companion.w(s, "onToolBarClick() invalid adapter");
            return;
        }
        if(v == 0) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new n(null) {
                int label;

                {
                    LocalPlaylistDetailFragment.this = localPlaylistDetailFragment0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.onToolBarClick.1(LocalPlaylistDetailFragment.this, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.onToolBarClick.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            ob.z z0 = LocalPlaylistDetailFragment.this.getPlayerUseCase();
                            this.label = 1;
                            object0 = z0.o(this);
                            if(object0 == a0) {
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
                    if(((Boolean)object0).booleanValue()) {
                        Bc.h h0 = LocalPlaylistDetailFragment.this.getPlayerUiHelper();
                        l0 l00 = LocalPlaylistDetailFragment.this.getChildFragmentManager();
                        q.f(l00, "getChildFragmentManager(...)");
                        h0.e(l00, new c(LocalPlaylistDetailFragment.this, 3));
                        return H.a;
                    }
                    LocalPlaylistDetailFragment.this.playSongs(false, true, false);
                    LocalPlaylistDetailFragment.this.setSelectAllWithToolbar(false);
                    return H.a;

                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                    @oe.e(c = "com.iloen.melon.fragments.local.LocalPlaylistDetailFragment$onToolBarClick$1$1$1", f = "LocalPlaylistDetailFragment.kt", l = {311}, m = "invokeSuspend")
                    final class com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.onToolBarClick.1.1.1 extends i implements n {
                        int label;

                        public com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.onToolBarClick.1.1.1(LocalPlaylistDetailFragment localPlaylistDetailFragment0, Continuation continuation0) {
                            LocalPlaylistDetailFragment.this = localPlaylistDetailFragment0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.onToolBarClick.1.1.1(LocalPlaylistDetailFragment.this, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.onToolBarClick.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    ob.z z0 = LocalPlaylistDetailFragment.this.getPlayerUseCase();
                                    this.label = 1;
                                    if(z0.b(0x7F13090F, this) == a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
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
                            LocalPlaylistDetailFragment.this.playSongs(false, true, false);
                            LocalPlaylistDetailFragment.this.setSelectAllWithToolbar(false);
                            return H.a;
                        }
                    }

                }

                private static final H invokeSuspend$lambda$0(LocalPlaylistDetailFragment localPlaylistDetailFragment0) {
                    BuildersKt__Builders_commonKt.launch$default(f0.f(localPlaylistDetailFragment0), Dispatchers.getMain(), null, new com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.onToolBarClick.1.1.1(localPlaylistDetailFragment0, null), 2, null);
                    return H.a;
                }
            }, 2, null);
            return;
        }
        if(2 == v) {
            this.showTrackAddToLocalPlaylistPopup("담기");
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        boolean z = false;
        if(titleBar0 != null) {
            G g0 = this.getEditBtn();
            g0.c = new x(this, 0);
            o o0 = B.a.s(7);
            o0.g(this.getEditBtn());
            titleBar0.a(o0);
            titleBar0.setBackgroundColor(0);
            titleBar0.setTitle(this.getPlaylistName());
        }
        this.bgIv = (ImageView)view0.findViewById(0x7F0A0936);  // id:playlist_image
        this.playlistNameTv = (TextView)view0.findViewById(0x7F0A0937);  // id:playlist_name
        String s = MusicUtils.getPlaylistNameById(this.getPlaylistId());
        q.f(s, "getPlaylistNameById(...)");
        this.setPlaylistName(s);
        TextView textView0 = this.playlistNameTv;
        if(textView0 != null) {
            textView0.setText(this.getPlaylistName());
        }
        this.filterLayout = (FilterLayout)view0.findViewById(0x7F0A049E);  // id:filter_layout
        View view1 = view0.findViewById(0x7F0A01BB);  // id:btn_shuffle
        if(view1 != null) {
            view1.setOnClickListener(new x(this, 1));
        }
        View view2 = view0.findViewById(0x7F0A0183);  // id:btn_play_all
        if(view2 != null) {
            view2.setOnClickListener(new x(this, 2));
        }
        if(this.getItemCount() > 0) {
            z = true;
        }
        this.setAllCheckButtonVisibility(z);
    }

    private static final void onViewCreated$lambda$1(LocalPlaylistDetailFragment localPlaylistDetailFragment0, View view0) {
        LocalPlaylistDetailEditFragment.Companion.newInstance(localPlaylistDetailFragment0.getPlaylistId(), localPlaylistDetailFragment0.getPlaylistName()).open();
    }

    private static final void onViewCreated$lambda$3(LocalPlaylistDetailFragment localPlaylistDetailFragment0, View view0) {
        j0 j00 = localPlaylistDetailFragment0.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.LocalPlaylistDetailSongAdapter");
        List list0 = ((LocalPlaylistDetailSongAdapter)j00).getPlayableListForPlay();
        q.e(list0, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.playback.Playable>");
        localPlaylistDetailFragment0.checkAndPlaySongs(((ArrayList)list0), true, true);
        if(localPlaylistDetailFragment0.getContext() != null) {
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = "음악재생";
            g0.b = "보관함";
            g0.c = "보관함_로컬플레이리스트";
            g0.y = "곡리스트";
            g0.F = "셔플재생";
            g0.I = "1000000350";
            g0.a().track();
        }
    }

    private static final void onViewCreated$lambda$5(LocalPlaylistDetailFragment localPlaylistDetailFragment0, View view0) {
        j0 j00 = localPlaylistDetailFragment0.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.LocalPlaylistDetailSongAdapter");
        List list0 = ((LocalPlaylistDetailSongAdapter)j00).getPlayableListForPlay();
        q.e(list0, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.playback.Playable>");
        localPlaylistDetailFragment0.checkAndPlaySongs(((ArrayList)list0), true, false);
        if(localPlaylistDetailFragment0.getContext() != null) {
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = "음악재생";
            g0.b = "보관함";
            g0.c = "보관함_로컬플레이리스트";
            g0.y = "곡리스트";
            g0.F = "전체재생";
            g0.I = "1000000350";
            g0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void playSongs(boolean z, boolean z1, boolean z2) {
        m m0 = this.getMarkedList(z);
        if(m0.a) {
            if(!z || !m0.c) {
                return;
            }
            ToastManager.show(0x7F13038A);  // string:empty_list_song "재생 가능한 곡이 없습니다."
            return;
        }
        if(z1 && m0.b) {
            String s = this.getTAG();
            LogU.Companion.d(s, "playSongs() - TaskAuthMsgContent run...");
            this.runTaskAuthMsgContent();
            return;
        }
        j0 j00 = this.mAdapter;
        if(!(j00 instanceof s)) {
            String s1 = this.getTAG();
            LogU.Companion.d(s1, "playSongs() - invalid adapter");
            return;
        }
        List list0 = ((s)j00).getPlayableItems(m0.d);
        q.e(list0, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.playback.Playable>");
        if(((ArrayList)list0).isEmpty()) {
            return;
        }
        this.setSelectAllWithToolbar(false);
        this.checkAndPlaySongs(((ArrayList)list0), z1, z2);
    }

    private final void setAllCheckButtonVisibility(boolean z) {
        this.isFilterVisible = z;
        if(z) {
            FilterLayout filterLayout0 = this.filterLayout;
            if(filterLayout0 != null) {
                com.iloen.melon.fragments.local.q q0 = new com.iloen.melon.fragments.local.q(this, filterLayout0);
                filterLayout0.b(I.e, q0);
                filterLayout0.setRightLayout(L.i);
                String s = this.songCnt;
                String s1 = this.plyduration;
                filterLayout0.setRightLayout(L.i);
                TextView textView0 = (TextView)filterLayout0.c.findViewById(0x7F0A0AA3);  // id:song_cnt
                TextView textView1 = (TextView)filterLayout0.c.findViewById(0x7F0A0403);  // id:duration_sum
                if(textView0 != null && textView1 != null) {
                    textView0.setText(s);
                    textView1.setText(s1);
                }
            }
        }
        else {
            FilterLayout filterLayout1 = this.filterLayout;
            if(filterLayout1 != null) {
                filterLayout1.setOnCheckedListener(null);
                filterLayout1.setLeftButton(null);
                filterLayout1.setRightLayout(null);
            }
        }
        this.updateParallaxHeaderView();
    }

    private static final void setAllCheckButtonVisibility$lambda$8$lambda$7(LocalPlaylistDetailFragment localPlaylistDetailFragment0, FilterLayout filterLayout0, S s0, boolean z) {
        localPlaylistDetailFragment0.toggleSelectAll();
        if(filterLayout0.getContext() != null) {
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = "선택";
            g0.b = "보관함";
            g0.c = "보관함_로컬플레이리스트";
            g0.y = "곡리스트";
            g0.F = "전체선택";
            g0.I = "1000000350";
            g0.a().track();
        }
    }

    private final boolean setMarkedItem(int v) {
        LocalPlaylistDetailSongAdapter localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0 = (LocalPlaylistDetailSongAdapter)this.getAdapter();
        if(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0 == null) {
            String s = this.getTAG();
            LogU.Companion.d(s, "setMarkedItem() - invalid adapter");
            return false;
        }
        if(localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0.isInEditMode()) {
            String s1 = this.getTAG();
            LogU.Companion.d(s1, "setMarkedItem() - ignore in edit mode");
            return false;
        }
        localPlaylistDetailFragment$LocalPlaylistDetailSongAdapter0.setWeakMarked(v);
        return true;
    }

    private final void setSongCntAndDuration(List list0) {
        this.songCnt = list0.size() + (this.getContext() == null ? null : "곡");
        this.plyduration = this.getAllDuration(list0);
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public void startQuery() {
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new n(null) {
            int label;

            {
                LocalPlaylistDetailFragment.this = localPlaylistDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.startQuery.1(LocalPlaylistDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.startQuery.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                int v = 1;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.startQuery.1.playableList.1 localPlaylistDetailFragment$startQuery$1$playableList$10 = new n(null) {
                            Object L$0;
                            int label;

                            {
                                LocalPlaylistDetailFragment.this = localPlaylistDetailFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.startQuery.1.playableList.1(LocalPlaylistDetailFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.startQuery.1.playableList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        G8.i.a.f();
                                        List list0 = G8.i.b(LocalPlaylistDetailFragment.this.getPlaylistId());
                                        G8.i.a.f();
                                        String s = LocalPlaylistDetailFragment.this.mPlaybackMenuId;
                                        q.f(s, "access$getMPlaybackMenuId$p$s2098296158(...)");
                                        this.L$0 = null;
                                        this.label = 1;
                                        ArrayList arrayList0 = G8.i.d(s, list0);
                                        return arrayList0 == a0 ? a0 : arrayList0;
                                    }
                                    case 1: {
                                        List list1 = (List)this.L$0;
                                        d5.n.D(object0);
                                        return object0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        this.label = 1;
                        object0 = BuildersKt.withContext(LocalPlaylistDetailFragment.this.getIoDispatcher(), localPlaylistDetailFragment$startQuery$1$playableList$10, this);
                        if(object0 == a0) {
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
                j0 j00 = LocalPlaylistDetailFragment.this.mAdapter;
                if(j00 != null) {
                    LocalPlaylistDetailFragment localPlaylistDetailFragment0 = LocalPlaylistDetailFragment.this;
                    if(j00 instanceof LocalPlaylistDetailSongAdapter) {
                        localPlaylistDetailFragment0.dismissProgressDialog();
                        ((LocalPlaylistDetailSongAdapter)j00).clear();
                        ((LocalPlaylistDetailSongAdapter)j00).addAll(((ArrayList)object0));
                        localPlaylistDetailFragment0.performFetchCompleteOnlyViews();
                        if(((ArrayList)object0) != null && !((ArrayList)object0).isEmpty()) {
                            v = 0;
                            Object object1 = ((ArrayList)object0).get(0);
                            q.f(object1, "get(...)");
                            boolean z = !StorageUtils.isScopedStorage();
                            q.d("");
                            q.f("", "getAlbum(...)");
                            String s = f.i("", "", "");
                            q.d("");
                            localPlaylistDetailFragment0.showAlbumImage(localPlaylistDetailFragment0.bgIv, "", ((Playable)object1).getMediaStoreAlbumId(), s);
                        }
                        localPlaylistDetailFragment0.setSongCntAndDuration(((ArrayList)object0));
                        localPlaylistDetailFragment0.setAllCheckButtonVisibility(((boolean)(v ^ 1)));
                    }
                }
                return H.a;
            }
        }, 3, null);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void updateHeaderRatio(float f) {
        TitleBar titleBar0 = this.getTitleBar();
        if(Float.compare(f, 1.0f) >= 0) {
            if(titleBar0 != null) {
                titleBar0.setTitle(this.getPlaylistName());
            }
            ViewUtils.hideWhen(this.playlistNameTv, true);
            if(this.playlistNameTv != null && this.playlistNameTv.getVisibility() == 0) {
                ViewUtils.hideWhen(this.playlistNameTv, true);
            }
            return;
        }
        if(titleBar0 != null) {
            titleBar0.setTitle("");
        }
        if(this.playlistNameTv == null || this.playlistNameTv.getVisibility() == 0) {
            return;
        }
        ViewUtils.showWhen(this.playlistNameTv, true);
    }
}

