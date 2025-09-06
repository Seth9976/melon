package com.iloen.melon.fragments.mymusic;

import B9.s;
import B9.u;
import F8.G;
import J8.Q1;
import J8.b3;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment;
import com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.request.MyMusicDjPlaylistInformCntCheckReq;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistInformCntCheckReq;
import com.iloen.melon.net.v4x.response.MyMusicDjPlaylistInformCntCheckRes;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistInformCntCheckRes;
import com.iloen.melon.net.v5x.request.MyMusicSeriesInformCntCheckReq;
import com.iloen.melon.net.v5x.response.MyMusicSeriesInformCntCheckRes;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistListV6Req.Params;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistListV6Req;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListV6Res.RESPONSE.PLAYLISTLIST;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListV6Res.RESPONSE;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListV6Res;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.ui.K1;
import com.melon.ui.k2;
import com.melon.ui.popup.b;
import e.k;
import f.c;
import f.g;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.List;
import je.n;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import va.o;
import zd.M;
import zd.x;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0002WXB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\b\u001A\u00020\u0005H\u0014\u00A2\u0006\u0004\b\b\u0010\u0007J\u000F\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0010J-\u0010\u0019\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\fH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ!\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u001B\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\fH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ+\u0010#\u001A\u00020\u00052\u0006\u0010\u001F\u001A\u00020\u001E2\b\u0010!\u001A\u0004\u0018\u00010 2\b\u0010\"\u001A\u0004\u0018\u00010\tH\u0014\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010&\u001A\u00020%H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u001B\u0010+\u001A\u0006\u0012\u0002\b\u00030*2\u0006\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b+\u0010,J\u000F\u0010-\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b-\u0010\u0004J\u000F\u0010/\u001A\u00020.H\u0002\u00A2\u0006\u0004\b/\u00100J\u000F\u00101\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b1\u0010\u0004J\u000F\u00102\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b2\u0010\u0004J\u000F\u00103\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b3\u0010\u0004J\u000F\u00104\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b4\u0010\u0004J\u000F\u00105\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b5\u0010\u0004J\u000F\u00106\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b6\u0010\u0004J\u000F\u00107\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b7\u0010\u0004J\u001F\u0010;\u001A\u00020\u000E2\u0006\u00109\u001A\u0002082\u0006\u0010:\u001A\u00020.H\u0002\u00A2\u0006\u0004\b;\u0010<J\u001F\u0010=\u001A\u00020\u000E2\u0006\u00109\u001A\u0002082\u0006\u0010:\u001A\u00020.H\u0002\u00A2\u0006\u0004\b=\u0010<J\u001F\u0010>\u001A\u00020\u000E2\u0006\u00109\u001A\u0002082\u0006\u0010:\u001A\u00020.H\u0002\u00A2\u0006\u0004\b>\u0010<R\u0016\u0010?\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001A\u00020.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010BR)\u0010L\u001A\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010\t0\t0F8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bH\u0010I\u001A\u0004\bJ\u0010KR%\u0010O\u001A\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010N0N0M8\u0006\u00A2\u0006\f\n\u0004\bO\u0010P\u001A\u0004\bQ\u0010RR\u0014\u0010V\u001A\u00020S8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bT\u0010U\u00A8\u0006Y"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/PlaylistFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lcom/iloen/melon/fragments/mymusic/OnCheckMyself;", "<init>", "()V", "", "isMyself", "()Z", "hasScrolledLine", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "makeTitleBar", "", "getTopPadding", "()I", "makePlaylist", "checkWithMakePlaylist", "checkWithMakeDjPlaylist", "checkWithMakeSeriesFolder", "tiaraLogEditPlaylist", "tiaraLogMakePlaylist", "tiaraLogImageToPlaylist", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "data", "position", "tiaraLogOpenPlaylistDetail", "(Lcom/melon/net/res/common/DjPlayListInfoBase;I)V", "tiaraLogPlayPlaylist", "tiaraLogMorePlaylist", "targetMemberKey", "Ljava/lang/String;", "isPowerDj", "Z", "currentSortIndex", "I", "isUnderPagerFragment", "", "kotlin.jvm.PlatformType", "filterTexts$delegate", "Lie/j;", "getFilterTexts", "()Ljava/util/List;", "filterTexts", "Le/b;", "Le/j;", "pickMedia", "Le/b;", "getPickMedia", "()Le/b;", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "PlaylistAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistFragment extends MetaContentBaseFragment implements OnCheckMyself {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u00162\b\b\u0002\u0010\u0019\u001A\u00020\u000BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/PlaylistFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_TARGET_MEMBERKEY", "ARG_SORT_TYPE", "ARG_IS_UNDER_PAGER", "ARG_IS_POWER_DJ", "SORT_RECENT_EDIT", "", "SORT_UPDETE", "SORT_ALPHABET", "SORT_LIKE", "TALKBACK_ACTION_DEFAULT", "TALKBACK_ACTION_NAVIGATE_PLAYLIST_DETAIL", "TALKBACK_ACTION_PLAYBACK", "TALKBACK_ACTION_MORE", "newInstance", "Lcom/iloen/melon/fragments/mymusic/PlaylistFragment;", "isUnderPagerFragment", "", "targetMemberKey", "isPowerDj", "sortIndex", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistFragment newInstance(boolean z, @NotNull String s, boolean z1, int v) {
            q.g(s, "targetMemberKey");
            PlaylistFragment playlistFragment0 = new PlaylistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argIsUnderPager", z);
            bundle0.putString("argTargetMemberKey", s);
            bundle0.putBoolean("argIsPowerDj", z1);
            bundle0.putInt("argSortIndex", v);
            playlistFragment0.setArguments(bundle0);
            return playlistFragment0;
        }

        public static PlaylistFragment newInstance$default(Companion playlistFragment$Companion0, boolean z, String s, boolean z1, int v, int v1, Object object0) {
            if((v1 & 8) != 0) {
                v = 0;
            }
            return playlistFragment$Companion0.newInstance(z, s, z1, v);
        }
    }

    @Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004*\u0001&\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001A\u00020\u00102\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ\'\u0010!\u001A\u00020 2\u0006\u0010\u001F\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u0013H\u0016¢\u0006\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010\'\u001A\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\'\u0010(¨\u0006)"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/PlaylistFragment$PlaylistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/MyMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/PlaylistFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_MAKE_AND_SORT", "I", "VIEW_TYPE_PLAYLIST", "com/iloen/melon/fragments/mymusic/PlaylistFragment$PlaylistAdapter$actionListener$1", "actionListener", "Lcom/iloen/melon/fragments/mymusic/PlaylistFragment$PlaylistAdapter$actionListener$1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class PlaylistAdapter extends p {
        private final int VIEW_TYPE_MAKE_AND_SORT;
        private final int VIEW_TYPE_PLAYLIST;
        @NotNull
        private final com.iloen.melon.fragments.mymusic.PlaylistFragment.PlaylistAdapter.actionListener.1 actionListener;

        public PlaylistAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            PlaylistFragment.this = playlistFragment0;
            super(context0, list0);
            this.VIEW_TYPE_MAKE_AND_SORT = 1;
            this.VIEW_TYPE_PLAYLIST = 2;
            this.actionListener = new s() {
                @Override  // B9.s
                public void clickBody(ArtistPlayListInfoBase artistPlayListInfoBase0, int v) {
                    if(artistPlayListInfoBase0 != null) {
                        Navigator.INSTANCE.openPlaylistDetail(artistPlayListInfoBase0.plylstseq);
                        this.tiaraLogOpenPlaylistDetail(artistPlayListInfoBase0, v);
                    }
                }

                @Override  // B9.s
                public void clickThumbnail(ArtistPlayListInfoBase artistPlayListInfoBase0, int v) {
                    if(artistPlayListInfoBase0 != null) {
                        Navigator.INSTANCE.openPlaylistDetail(artistPlayListInfoBase0.plylstseq);
                        this.tiaraLogOpenPlaylistDetail(artistPlayListInfoBase0, v);
                    }
                }

                @Override  // B9.s
                public boolean longClickBody(ArtistPlayListInfoBase artistPlayListInfoBase0, int v) {
                    if(artistPlayListInfoBase0 != null) {
                        this.showContextPopupPlayList(artistPlayListInfoBase0);
                        return true;
                    }
                    return false;
                }

                @Override  // B9.s
                public void playPlaylist(ArtistPlayListInfoBase artistPlayListInfoBase0, int v) {
                    if(artistPlayListInfoBase0 != null) {
                        String s = artistPlayListInfoBase0.plylstseq;
                        String s1 = artistPlayListInfoBase0.contsTypeCode;
                        String s2 = PlaylistAdapter.this.getMenuId();
                        this.playPlaylist(s, s1, s2, artistPlayListInfoBase0.statsElements);
                        this.tiaraLogPlayPlaylist(artistPlayListInfoBase0, v);
                    }
                }
            };
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return PlaylistFragment.this.isMyself();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? this.VIEW_TYPE_PLAYLIST : this.VIEW_TYPE_MAKE_AND_SORT;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            if(httpResponse0 instanceof MyMusicPlaylistListV6Res) {
                RESPONSE myMusicPlaylistListV6Res$RESPONSE0 = ((MyMusicPlaylistListV6Res)httpResponse0).response;
                if(myMusicPlaylistListV6Res$RESPONSE0 == null) {
                    return false;
                }
                this.setMenuId(myMusicPlaylistListV6Res$RESPONSE0.menuId);
                this.updateModifiedTime(this.getCacheKey());
                this.setHasMore(myMusicPlaylistListV6Res$RESPONSE0.hasMore);
                ArrayList arrayList0 = myMusicPlaylistListV6Res$RESPONSE0.playlistList;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    this.addAll(arrayList0);
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            int v2 = o00.getItemViewType();
            if(v2 == this.VIEW_TYPE_MAKE_AND_SORT) {
                b3 b30 = ((PlaylistMakeAndSortBarViewHolder)o00).getBinding();
                e0 e00 = new e0(PlaylistFragment.this, 0);
                b30.c.setOnClickListener(e00);
                b3 b31 = ((PlaylistMakeAndSortBarViewHolder)o00).getBinding();
                e0 e01 = new e0(PlaylistFragment.this, 1);
                b31.b.setOnClickListener(e01);
                b3 b32 = ((PlaylistMakeAndSortBarViewHolder)o00).getBinding();
                List list0 = PlaylistFragment.this.getFilterTexts();
                String s = (String)je.p.n0(PlaylistFragment.this.currentSortIndex, list0);
                b32.d.setText(s);
                String s1 = PlaylistFragment.this.getString(0x7F130BAE);  // string:talkback_order_by "정렬,"
                ViewUtils.setContentDescriptionWithButtonClassName(b32.d, s1 + s);
                e e0 = new e(8, PlaylistFragment.this, b32.d);
                b32.d.setOnClickListener(e0);
                return;
            }
            if(v2 == this.VIEW_TYPE_PLAYLIST) {
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.MyMusicPlaylistListV6Res.RESPONSE.PLAYLISTLIST");
                ((u)o00).b(((PLAYLISTLIST)object0), v1, this.actionListener);
                Q1 q10 = (Q1)((u)o00).a.f;
                MelonTextView melonTextView0 = q10.k;
                ImageView imageView0 = ((u)o00).a.c;
                if(PlaylistFragment.this.isMyself()) {
                    melonTextView0.setVisibility(0);
                    melonTextView0.setText(PlaylistFragment.this.getString(0x7F13083B, new Object[]{((PLAYLISTLIST)object0).songcnt}));  // string:playlist_song_count "%s곡"
                    imageView0.setVisibility(0);
                    imageView0.setOnClickListener(new f(PlaylistFragment.this, ((PLAYLISTLIST)object0), v1, 3));
                }
                q10.a.setImportantForAccessibility(4);
                imageView0.setImportantForAccessibility(2);
                com.iloen.melon.fragments.mymusic.PlaylistFragment.PlaylistAdapter.onBindViewImpl.5 playlistFragment$PlaylistAdapter$onBindViewImpl$50 = new View.AccessibilityDelegate() {
                    @Override  // android.view.View$AccessibilityDelegate
                    public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                        String s;
                        q.g(view0, "host");
                        q.g(accessibilityNodeInfo0, "info");
                        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, ((PLAYLISTLIST)object0).getString(0x7F130272)));  // string:ctx_menu_open_playlist "플레이리스트 열기"
                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, ((PLAYLISTLIST)object0).getString(0x7F13025F)));  // string:ctx_menu_listen "듣기"
                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000003, ((PLAYLISTLIST)object0).getString(0x7F130266)));  // string:ctx_menu_more "더보기"
                        if(((PLAYLISTLIST)object0).isMyself()) {
                            Object[] arr_object = {q10.plylsttitle, ((u)o00).b.getText(), q10.songcnt, ((u)o00).e.getText()};
                            s = ((PLAYLISTLIST)object0).getString(0x7F130BE2, arr_object);  // string:talkback_playlist_common_listitem_container_count "%1$s, 제작자 %2$s, %3$s곡, 
                                                                                            // 좋아요 %4$s개, 상세보기"
                        }
                        else {
                            Object[] arr_object1 = {q10.plylsttitle, ((u)o00).b.getText(), ((u)o00).e.getText()};
                            s = ((PLAYLISTLIST)object0).getString(0x7F130BE3, arr_object1);  // string:talkback_playlist_common_listitem_container_like "%1$s, 제작자 %2$s, 좋아요 %3$s개, 
                                                                                             // 상세보기"
                        }
                        accessibilityNodeInfo0.setContentDescription(s);
                        accessibilityNodeInfo0.setClassName("android.widget.Button");
                    }

                    @Override  // android.view.View$AccessibilityDelegate
                    public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                        q.g(view0, "host");
                        switch(v) {
                            case 100000001: {
                                this.$vh.itemView.performClick();
                                return true;
                            }
                            case 100000002: {
                                ((u)o00).f.performClick();
                                return true;
                            }
                            case 100000003: {
                                this.$vh.itemView.performLongClick();
                                return true;
                            }
                            default: {
                                return super.performAccessibilityAction(view0, v, bundle0);
                            }
                        }
                    }
                };
                ((u)o00).itemView.setAccessibilityDelegate(playlistFragment$PlaylistAdapter$onBindViewImpl$50);
            }
        }

        private static final void onBindViewImpl$lambda$0(PlaylistFragment playlistFragment0, View view0) {
            if(playlistFragment0.isPossiblePopupShow()) {
                playlistFragment0.makePlaylist();
                playlistFragment0.tiaraLogMakePlaylist();
            }
        }

        private static final void onBindViewImpl$lambda$2(PlaylistFragment playlistFragment0, View view0) {
            if(playlistFragment0.isPossiblePopupShow()) {
                b.x(playlistFragment0.getChildFragmentManager(), playlistFragment0.getString(0x7F130026), playlistFragment0.getString(0x7F130CA9), false, false, null, playlistFragment0.getString(0x7F130CA8), new f0(playlistFragment0, 0), null, null, null, 3704);  // string:add_song_with_image "이미지로 곡 추가"
                playlistFragment0.tiaraLogImageToPlaylist();
            }
        }

        private static final H onBindViewImpl$lambda$2$lambda$1(PlaylistFragment playlistFragment0) {
            playlistFragment0.getPickMedia().b(k.c(new g()));  // 初始化器: Ljava/lang/Object;-><init>()V
            return H.a;
        }

        private static final void onBindViewImpl$lambda$4(PlaylistFragment playlistFragment0, MelonTextView melonTextView0, View view0) {
            if(playlistFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = playlistFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(playlistFragment0.getFilterTexts(), playlistFragment0.currentSortIndex);
                    bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.fragments.mymusic.g(playlistFragment0, melonTextView0, 7));
                    bottomSingleFilterListPopup0.setOnDismissListener(playlistFragment0.mDialogDismissListener);
                    playlistFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$4$lambda$3(PlaylistFragment playlistFragment0, MelonTextView melonTextView0, int v) {
            playlistFragment0.currentSortIndex = v;
            melonTextView0.setText(((String)je.p.n0(playlistFragment0.currentSortIndex, playlistFragment0.getFilterTexts())));
            playlistFragment0.startFetch("filter change");
        }

        private static final void onBindViewImpl$lambda$5(PlaylistFragment playlistFragment0, PLAYLISTLIST myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0, int v, View view0) {
            playlistFragment0.showContextPopupPlayList(myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0);
            playlistFragment0.tiaraLogMorePlaylist(myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0, v);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return v == this.VIEW_TYPE_MAKE_AND_SORT ? PlaylistMakeAndSortBarViewHolder.Companion.newInstance(viewGroup0) : H0.e.P(viewGroup0, B9.q.d);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[M.values().length];
            try {
                arr_v[33] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[34] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[35] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_IS_POWER_DJ = "argIsPowerDj";
    @NotNull
    private static final String ARG_IS_UNDER_PAGER = "argIsUnderPager";
    @NotNull
    private static final String ARG_SORT_TYPE = "argSortIndex";
    @NotNull
    private static final String ARG_TARGET_MEMBERKEY = "argTargetMemberKey";
    @NotNull
    public static final Companion Companion = null;
    public static final int SORT_ALPHABET = 2;
    public static final int SORT_LIKE = 3;
    public static final int SORT_RECENT_EDIT = 0;
    public static final int SORT_UPDETE = 1;
    @NotNull
    private static final String TAG = "PlaylistFragment";
    private static final int TALKBACK_ACTION_DEFAULT = 100000000;
    private static final int TALKBACK_ACTION_MORE = 100000003;
    private static final int TALKBACK_ACTION_NAVIGATE_PLAYLIST_DETAIL = 100000001;
    private static final int TALKBACK_ACTION_PLAYBACK = 100000002;
    private int currentSortIndex;
    @NotNull
    private final j filterTexts$delegate;
    private boolean isPowerDj;
    private boolean isUnderPagerFragment;
    @NotNull
    private final e.b pickMedia;
    @NotNull
    private String targetMemberKey;

    static {
        PlaylistFragment.Companion = new Companion(null);
        PlaylistFragment.$stable = 8;
    }

    public PlaylistFragment() {
        this.targetMemberKey = "";
        this.filterTexts$delegate = d3.g.Q(new f0(this, 1));
        e.b b0 = this.registerForActivityResult(new c(5), new W(16));
        q.f(b0, "registerForActivityResult(...)");
        this.pickMedia = b0;
    }

    private final void checkWithMakeDjPlaylist() {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        RequestBuilder.newInstance(new MyMusicDjPlaylistInformCntCheckReq(this.getContext())).tag(this.getRequestTag()).listener(new d0(this, 2)).errorListener(new W(15)).request();
    }

    private static final void checkWithMakeDjPlaylist$lambda$12(PlaylistFragment playlistFragment0, Object object0) {
        q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.MyMusicDjPlaylistInformCntCheckRes");
        if(playlistFragment0.isFragmentValid()) {
            Cb.j.b(((MyMusicDjPlaylistInformCntCheckRes)object0).notification, false, 3);
            if(Cb.j.d(((HttpResponse)object0))) {
                com.iloen.melon.net.v4x.response.MyMusicDjPlaylistInformCntCheckRes.RESPONSE myMusicDjPlaylistInformCntCheckRes$RESPONSE0 = ((MyMusicDjPlaylistInformCntCheckRes)object0).response;
                String s = null;
                if("N".equals((myMusicDjPlaylistInformCntCheckRes$RESPONSE0 == null ? null : myMusicDjPlaylistInformCntCheckRes$RESPONSE0.cntoverYn))) {
                    Navigator.open(PlaylistMakeFragment.newInstance("", "M20002", "melondjMakeDjplaylist"));
                    return;
                }
                l0 l00 = playlistFragment0.getChildFragmentManager();
                String s1 = playlistFragment0.getContext() == null ? null : "안내";
                if(playlistFragment0.getContext() != null) {
                    s = "플레이리스트는 최대 500개까지 만들 수 있습니다. 기존 플레이리스트를 삭제하신 후 다시 시도해주세요.";
                }
                b.d(b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
            }
        }
    }

    private static final void checkWithMakeDjPlaylist$lambda$13(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final void checkWithMakePlaylist() {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        RequestBuilder.newInstance(new MyMusicPlaylistInformCntCheckReq(this.getContext())).tag(this.getRequestTag()).listener(new d0(this, 0)).errorListener(new W(13)).request();
    }

    private static final void checkWithMakePlaylist$lambda$10(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private static final void checkWithMakePlaylist$lambda$9(PlaylistFragment playlistFragment0, Object object0) {
        q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.MyMusicPlaylistInformCntCheckRes");
        if(playlistFragment0.isFragmentValid()) {
            Cb.j.b(((MyMusicPlaylistInformCntCheckRes)object0).notification, false, 3);
            if(Cb.j.d(((HttpResponse)object0))) {
                com.iloen.melon.net.v4x.response.MyMusicPlaylistInformCntCheckRes.RESPONSE myMusicPlaylistInformCntCheckRes$RESPONSE0 = ((MyMusicPlaylistInformCntCheckRes)object0).response;
                String s = null;
                if("N".equals((myMusicPlaylistInformCntCheckRes$RESPONSE0 == null ? null : myMusicPlaylistInformCntCheckRes$RESPONSE0.cntoverYn))) {
                    Navigator.open(PlaylistMakeFragment.newInstance("", "M20001", "mymusicPlaylistNewMake"));
                    return;
                }
                l0 l00 = playlistFragment0.getChildFragmentManager();
                String s1 = playlistFragment0.getContext() == null ? null : "안내";
                if(playlistFragment0.getContext() != null) {
                    s = "플레이리스트는 최대 500개까지 만들 수 있습니다. 기존 플레이리스트를 삭제하신 후 다시 시도해주세요.";
                }
                b.d(b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
            }
        }
    }

    private final void checkWithMakeSeriesFolder() {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        RequestBuilder.newInstance(new MyMusicSeriesInformCntCheckReq(this.getContext())).tag(this.getRequestTag()).listener(new d0(this, 1)).errorListener(new W(14)).request();
    }

    private static final void checkWithMakeSeriesFolder$lambda$15(PlaylistFragment playlistFragment0, Object object0) {
        q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.MyMusicSeriesInformCntCheckRes");
        if(playlistFragment0.isFragmentValid()) {
            Cb.j.b(((MyMusicSeriesInformCntCheckRes)object0).notification, false, 3);
            if(Cb.j.d(((HttpResponse)object0))) {
                com.iloen.melon.net.v5x.response.MyMusicSeriesInformCntCheckRes.RESPONSE myMusicSeriesInformCntCheckRes$RESPONSE0 = ((MyMusicSeriesInformCntCheckRes)object0).response;
                if("N".equals((myMusicSeriesInformCntCheckRes$RESPONSE0 == null ? null : myMusicSeriesInformCntCheckRes$RESPONSE0.cntoverYn))) {
                    Navigator.open(SeriesPlaylistMakeFragment.Companion.newInstance("", true));
                    return;
                }
                ToastManager.show(0x7F13065F);  // string:melondj_series_folder_make_limit "시리즈 플레이리스트는 20개까지 생성 할 수 있습니다."
            }
        }
    }

    private static final void checkWithMakeSeriesFolder$lambda$16(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new PlaylistAdapter(this, context0, null);
        v9.e e0 = new v9.e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.c = ScreenUtils.dipToPixel(context0, 484.0f);
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    private static final List filterTexts_delegate$lambda$0(PlaylistFragment playlistFragment0) {
        Context context0 = playlistFragment0.getContext();
        if(context0 != null) {
            Resources resources0 = context0.getResources();
            if(resources0 != null) {
                String[] arr_s = resources0.getStringArray(0x7F03003A);  // array:sortingbar_library_playlist
                if(arr_s != null) {
                    return n.N(arr_s);
                }
            }
        }
        return w.a;
    }

    private final p8.f getBaseTiaraLogEventBuilder() {
        p8.f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        p8.s s0 = this.mMelonTiaraProperty;
        String s1 = null;
        f0.b = s0 == null ? null : s0.a;
        if(s0 != null) {
            s1 = s0.b;
        }
        f0.c = s1;
        f0.I = this.getMenuId();
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.X.buildUpon().appendQueryParameter("targetMemberKey", this.targetMemberKey).appendQueryParameter("sortIndex", String.valueOf(this.currentSortIndex)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final List getFilterTexts() {
        return (List)this.filterTexts$delegate.getValue();
    }

    @NotNull
    public final e.b getPickMedia() {
        return this.pickMedia;
    }

    // 去混淆评级： 低(20)
    private final int getTopPadding() {
        return this.isMyself() ? ScreenUtils.dipToPixel(this.getContext(), 0.0f) : ScreenUtils.dipToPixel(this.getContext(), 10.0f);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return !this.isUnderPagerFragment;
    }

    @Override  // com.iloen.melon.fragments.mymusic.OnCheckMyself
    public boolean isMyself() {
        return this.targetMemberKey.length() > 0 && q.b(this.targetMemberKey, e1.u.v(((va.e0)o.a()).j()));
    }

    private final void makePlaylist() {
        if(!this.isMyself()) {
            LogU.Companion.d("PlaylistFragment", "makePlaylist() : in other playlist, but try to make new one");
            return;
        }
        if(((va.e0)o.a()).j().getIsDj()) {
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(x.x);
            arrayList0.add(x.y);
            if(this.isPowerDj) {
                arrayList0.add(x.z);
            }
            l0 l00 = this.getChildFragmentManager();
            String s = this.getString(0x7F130C9F);  // string:text_make_playlist "플레이리스트 만들기"
            q.f(s, "getString(...)");
            b.u(l00, s, arrayList0, new a(this, 1));
            return;
        }
        this.checkWithMakePlaylist();
    }

    private static final H makePlaylist$lambda$7(PlaylistFragment playlistFragment0, k2 k20) {
        q.g(k20, "onEvent");
        if(k20 instanceof K1) {
            switch(WhenMappings.$EnumSwitchMapping$0[((K1)k20).b.a.ordinal()]) {
                case 1: {
                    playlistFragment0.checkWithMakePlaylist();
                    break;
                }
                case 2: {
                    playlistFragment0.checkWithMakeDjPlaylist();
                    return H.a;
                }
                case 3: {
                    playlistFragment0.checkWithMakeSeriesFolder();
                    return H.a;
                }
                default: {
                    return H.a;
                }
            }
        }
        return H.a;
    }

    private final void makeTitleBar() {
        ViewUtils.hideWhen(this.getTitleBar(), this.isUnderPagerFragment);
        if(!this.isUnderPagerFragment) {
            TitleBar titleBar0 = this.getTitleBar();
            if(titleBar0 != null) {
                F8.o o0 = B.a.s(1);
                if(this.isMyself()) {
                    G g0 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
                    g0.c = new e0(this, 2);
                    o0.g(g0);
                }
                titleBar0.a(o0);
                titleBar0.setTitle(this.getString(0x7F13058F));  // string:main_mymusic_playlist "플레이리스트"
            }
        }
    }

    private static final void makeTitleBar$lambda$3$lambda$2(PlaylistFragment playlistFragment0, View view0) {
        String s = playlistFragment0.getCacheKey();
        MyMusicPlayListEditFragment.Companion.newInstance(0, s).open();
        playlistFragment0.tiaraLogEditPlaylist();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(true);
        int v = this.getTopPadding();
        ((RecyclerView)view0).setPadding(((RecyclerView)view0).getPaddingLeft(), v, ((RecyclerView)view0).getPaddingRight(), ((RecyclerView)view0).getPaddingBottom());
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02A9, viewGroup0, false);  // layout:fragment_detail_basic
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @Nullable h h0, @Nullable String s) {
        q.g(i0, "type");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.PlaylistFragment.PlaylistAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((PlaylistAdapter)j00).clear();
        }
        Params myMusicPlaylistListV6Req$Params0 = new Params();
        myMusicPlaylistListV6Req$Params0.startIndex = i1.equals(i0) ? 1 : ((PlaylistAdapter)j00).getCount() + 1;
        myMusicPlaylistListV6Req$Params0.pageSize = 100;
        String s1 = "DSPLY_ORDER";
        switch(this.currentSortIndex) {
            case 1: {
                s1 = "UPDT_DATE";
                break;
            }
            case 2: {
                s1 = "ALPHABET";
                break;
            }
            case 3: {
                s1 = "SUMM_CNT";
            }
        }
        myMusicPlaylistListV6Req$Params0.orderBy = s1;
        myMusicPlaylistListV6Req$Params0.targetMemberKey = this.targetMemberKey;
        myMusicPlaylistListV6Req$Params0.plylstTypeCode = "M20001";
        RequestBuilder.newInstance(new MyMusicPlaylistListV6Req(this.getContext(), myMusicPlaylistListV6Req$Params0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.mymusic.g(this, i0, 25)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$4(PlaylistFragment playlistFragment0, i i0, MyMusicPlaylistListV6Res myMusicPlaylistListV6Res0) {
        if(!playlistFragment0.prepareFetchComplete(myMusicPlaylistListV6Res0)) {
            return;
        }
        RESPONSE myMusicPlaylistListV6Res$RESPONSE0 = myMusicPlaylistListV6Res0.response;
        if(myMusicPlaylistListV6Res$RESPONSE0 != null) {
            playlistFragment0.mMelonTiaraProperty = new p8.s(myMusicPlaylistListV6Res$RESPONSE0.section, myMusicPlaylistListV6Res$RESPONSE0.page, myMusicPlaylistListV6Res$RESPONSE0.menuId, null);
        }
        playlistFragment0.performFetchComplete(i0, myMusicPlaylistListV6Res0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.targetMemberKey = l1.g(bundle0, "inState", "argTargetMemberKey", "", "getString(...)");
        this.currentSortIndex = bundle0.getInt("argSortIndex", 0);
        this.isUnderPagerFragment = bundle0.getBoolean("argIsUnderPager", false);
        this.isPowerDj = bundle0.getBoolean("argIsPowerDj", false);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argTargetMemberKey", this.targetMemberKey);
        bundle0.putInt("argSortIndex", this.currentSortIndex);
        bundle0.putBoolean("argIsUnderPager", this.isUnderPagerFragment);
        bundle0.putBoolean("argIsPowerDj", this.isPowerDj);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.makeTitleBar();
    }

    private static final void pickMedia$lambda$1(List list0) {
        q.g(list0, "uris");
        if(!list0.isEmpty()) {
            ImageToPlaylistFragment imageToPlaylistFragment0 = ImageToPlaylistFragment.Companion.newInstance(list0);
            Navigator.INSTANCE.open(imageToPlaylistFragment0);
            return;
        }
        LogU.Companion.d("PlaylistFragment", "No media selected");
    }

    private final void tiaraLogEditPlaylist() {
        p8.f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.y = this.getString(0x7F130DF3);  // string:tiara_common_layer1_gnb "GNB"
        f0.F = this.getString(0x7F130D27);  // string:tiara_click_copy_edit "편집"
        f0.a().track();
    }

    private final void tiaraLogImageToPlaylist() {
        p8.f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.y = this.getString(0x7F130EB8);  // string:tiara_gnb_layer1_gnb "GNB"
        f0.F = this.getString(0x7F130D3A);  // string:tiara_click_copy_image_to_playlist "이미지로곡추가"
        f0.a().track();
    }

    private final void tiaraLogMakePlaylist() {
        p8.f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.y = this.getString(0x7F130EB8);  // string:tiara_gnb_layer1_gnb "GNB"
        f0.F = this.getString(0x7F130D4C);  // string:tiara_click_copy_make "만들기"
        f0.a().track();
    }

    private final void tiaraLogMorePlaylist(DjPlayListInfoBase djPlayListInfoBase0, int v) {
        p8.f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.F = this.getString(0x7F130D54);  // string:tiara_click_copy_more "더보기"
        f0.C = String.valueOf(v + 1);
        f0.e = djPlayListInfoBase0.plylstseq;
        f0.f = Y.i(ContsTypeCode.PLAYLIST, "code(...)");
        f0.g = djPlayListInfoBase0.plylsttitle;
        f0.a().track();
    }

    private final void tiaraLogOpenPlaylistDetail(DjPlayListInfoBase djPlayListInfoBase0, int v) {
        p8.f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.C = String.valueOf(v + 1);
        f0.e = djPlayListInfoBase0.plylstseq;
        f0.f = Y.i(ContsTypeCode.PLAYLIST, "code(...)");
        f0.g = djPlayListInfoBase0.plylsttitle;
        f0.a().track();
    }

    private final void tiaraLogPlayPlaylist(DjPlayListInfoBase djPlayListInfoBase0, int v) {
        p8.f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.PlayMusic;
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.C = String.valueOf(v + 1);
        f0.e = djPlayListInfoBase0.plylstseq;
        f0.f = Y.i(ContsTypeCode.PLAYLIST, "code(...)");
        f0.g = djPlayListInfoBase0.plylsttitle;
        f0.a().track();
    }
}

