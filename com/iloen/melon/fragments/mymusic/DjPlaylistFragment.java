package com.iloen.melon.fragments.mymusic;

import B9.t;
import B9.u;
import B9.v;
import J8.J0;
import J8.Q1;
import J8.b3;
import P4.a;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
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
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment;
import com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.request.MyMusicDjPlaylistInformCntCheckReq;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistInformCntCheckReq;
import com.iloen.melon.net.v4x.response.MyMusicDjPlaylistInformCntCheckRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicDjPlaylistInformCntCheckRes;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistInformCntCheckRes;
import com.iloen.melon.net.v5x.request.MyMusicSeriesInformCntCheckReq;
import com.iloen.melon.net.v5x.response.MyMusicSeriesInformCntCheckRes;
import com.iloen.melon.net.v6x.request.DjPlaylistListV6Req.Params;
import com.iloen.melon.net.v6x.request.DjPlaylistListV6Req;
import com.iloen.melon.net.v6x.response.DjPlaylistListV6Res.RESPONSE.PLAYLIST;
import com.iloen.melon.net.v6x.response.DjPlaylistListV6Res;
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
import p8.s;
import v9.h;
import v9.i;
import va.e0;
import va.o;
import zd.M;
import zd.x;

@Metadata(d1 = {"\u0000\u00A4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0002Z[B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u000FJ-\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0016\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001F\u001A\u00020\u00052\u0006\u0010\u001B\u001A\u00020\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u0010\u001E\u001A\u0004\u0018\u00010\bH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010\"\u001A\u00020!H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u001B\u0010\'\u001A\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010*\u001A\u00020)H\u0002\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010,\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b,\u0010\u0004J\u000F\u0010-\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b-\u0010\u0004J\u000F\u0010.\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b.\u0010\u0004J\u000F\u0010/\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b/\u0010\u0004J\u0017\u00101\u001A\u00020\r2\u0006\u00100\u001A\u00020)H\u0002\u00A2\u0006\u0004\b1\u00102J\u000F\u00103\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b3\u0010\u0004J\u000F\u00104\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b4\u0010\u0004J\'\u0010:\u001A\u00020\r2\u0006\u00106\u001A\u0002052\u0006\u00107\u001A\u00020)2\u0006\u00109\u001A\u000208H\u0002\u00A2\u0006\u0004\b:\u0010;J\'\u0010<\u001A\u00020\r2\u0006\u00106\u001A\u0002052\u0006\u00107\u001A\u00020)2\u0006\u00109\u001A\u000208H\u0002\u00A2\u0006\u0004\b<\u0010;J\u001F\u0010=\u001A\u00020\r2\u0006\u00106\u001A\u0002052\u0006\u00107\u001A\u00020)H\u0002\u00A2\u0006\u0004\b=\u0010>R\u0016\u0010?\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001A\u00020)8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001A\u00020)8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010DR)\u0010L\u001A\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010\b0\b0F8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bH\u0010I\u001A\u0004\bJ\u0010KR%\u0010O\u001A\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010N0N0M8\u0006\u00A2\u0006\f\n\u0004\bO\u0010P\u001A\u0004\bQ\u0010RR\u001A\u0010U\u001A\b\u0012\u0004\u0012\u00020S0F8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bT\u0010KR\u0014\u0010Y\u001A\u00020V8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bW\u0010X\u00A8\u0006\\"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/DjPlaylistFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lcom/iloen/melon/fragments/mymusic/OnCheckMyself;", "<init>", "()V", "", "isMyself", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "", "getTopPadding", "()I", "makePlaylist", "checkWithMakePlaylist", "checkWithMakeDjPlaylist", "checkWithMakeSeriesFolder", "alyacPosition", "tiaraLogClickAlyacView", "(I)V", "tiaraLogMakePlaylist", "tiaraLogImageToPlaylist", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "data", "position", "Lcom/iloen/melon/net/v4x/common/ContsTypeCode;", "contsTypeCode", "tiaraLogOpenPlaylistDetail", "(Lcom/melon/net/res/common/DjPlayListInfoBase;ILcom/iloen/melon/net/v4x/common/ContsTypeCode;)V", "tiaraLogPlayPlaylist", "tiaraLogMoreDjPlaylist", "(Lcom/melon/net/res/common/DjPlayListInfoBase;I)V", "targetMemberKey", "Ljava/lang/String;", "isPowerDj", "Z", "currentFilterIndex", "I", "currentSortIndex", "", "kotlin.jvm.PlatformType", "sortingTexts$delegate", "Lie/j;", "getSortingTexts", "()Ljava/util/List;", "sortingTexts", "Le/b;", "Le/j;", "pickMedia", "Le/b;", "getPickMedia", "()Le/b;", "Lv9/j;", "getFilterItems", "filterItems", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "PlaylistAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DjPlaylistFragment extends MetaContentBaseFragment implements OnCheckMyself {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u000B2\b\b\u0002\u0010\u001B\u001A\u00020\u000BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/DjPlaylistFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_TARGET_MEMBERKEY", "ARG_IS_POWER_DJ", "ARG_SORT_TYPE", "ARG_FILTER_TYPE", "FILTER_ALL", "", "FILTER_SERIES", "SORT_RECENT_EDIT", "SORT_UPDETE", "SORT_ALPHABET", "SORT_LIKE", "TALKBACK_ACTION_DEFAULT", "TALKBACK_ACTION_NAVIGATE_PLAYLIST_DETAIL", "TALKBACK_ACTION_PLAYBACK", "TALKBACK_ACTION_MORE", "newInstance", "Lcom/iloen/melon/fragments/mymusic/DjPlaylistFragment;", "targetMemberKey", "isPowerDj", "", "sortIndex", "filterIndex", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DjPlaylistFragment newInstance(@NotNull String s, boolean z, int v, int v1) {
            q.g(s, "targetMemberKey");
            DjPlaylistFragment djPlaylistFragment0 = new DjPlaylistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argTargetMemberKey", s);
            bundle0.putInt("argSortIndex", v);
            bundle0.putInt("argFilterIndex", v1);
            bundle0.putBoolean("argIsPowerDj", z);
            djPlaylistFragment0.setArguments(bundle0);
            return djPlaylistFragment0;
        }

        public static DjPlaylistFragment newInstance$default(Companion djPlaylistFragment$Companion0, String s, boolean z, int v, int v1, int v2, Object object0) {
            if((v2 & 4) != 0) {
                v = 0;
            }
            if((v2 & 8) != 0) {
                v1 = 0;
            }
            return djPlaylistFragment$Companion0.newInstance(s, z, v, v1);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\b\b*\u0002\u001E!\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000F\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001C\u0010\u001BR\u0014\u0010\u001D\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001D\u0010\u001BR\u0014\u0010\u001F\u001A\u00020\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010\"\u001A\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001A\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b$\u0010\fR\u0014\u0010\'\u001A\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b&\u0010\f¨\u0006("}, d2 = {"Lcom/iloen/melon/fragments/mymusic/DjPlaylistFragment$PlaylistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/DjPlaylistListV6Res$RESPONSE$PLAYLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/DjPlaylistFragment;Landroid/content/Context;Ljava/util/List;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_ALYAC_FILTER", "I", "VIEW_TYPE_MAKE_AND_SORT", "VIEW_TYPE_PLAYLIST", "com/iloen/melon/fragments/mymusic/DjPlaylistFragment$PlaylistAdapter$djPlaylistActionLister$1", "djPlaylistActionLister", "Lcom/iloen/melon/fragments/mymusic/DjPlaylistFragment$PlaylistAdapter$djPlaylistActionLister$1;", "com/iloen/melon/fragments/mymusic/DjPlaylistFragment$PlaylistAdapter$seriesPlaylistActionListener$1", "seriesPlaylistActionListener", "Lcom/iloen/melon/fragments/mymusic/DjPlaylistFragment$PlaylistAdapter$seriesPlaylistActionListener$1;", "getScrollableAlyacHolderCount", "scrollableAlyacHolderCount", "getMakeAndSortHolderCount", "makeAndSortHolderCount", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class PlaylistAdapter extends p {
        private final int VIEW_TYPE_ALYAC_FILTER;
        private final int VIEW_TYPE_MAKE_AND_SORT;
        private final int VIEW_TYPE_PLAYLIST;
        @NotNull
        private final com.iloen.melon.fragments.mymusic.DjPlaylistFragment.PlaylistAdapter.djPlaylistActionLister.1 djPlaylistActionLister;
        @NotNull
        private final com.iloen.melon.fragments.mymusic.DjPlaylistFragment.PlaylistAdapter.seriesPlaylistActionListener.1 seriesPlaylistActionListener;

        public PlaylistAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            DjPlaylistFragment.this = djPlaylistFragment0;
            super(context0, list0);
            this.VIEW_TYPE_ALYAC_FILTER = 1;
            this.VIEW_TYPE_MAKE_AND_SORT = 2;
            this.VIEW_TYPE_PLAYLIST = 3;
            this.djPlaylistActionLister = new t() {
                private final ContsTypeCode contsTypeCode;

                {
                    DjPlaylistFragment djPlaylistFragment0 = this;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.contsTypeCode = ContsTypeCode.DJ_PLAYLIST;
                }

                @Override  // B9.t
                public void clickBody(DjPlayListInfoBase djPlayListInfoBase0, int v) {
                    if(djPlayListInfoBase0 != null) {
                        Navigator.openDjPlaylistDetail(djPlayListInfoBase0.plylstseq);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        this.tiaraLogOpenPlaylistDetail(djPlayListInfoBase0, v, this.contsTypeCode);
                    }
                }

                @Override  // B9.t
                public void clickThumbnail(DjPlayListInfoBase djPlayListInfoBase0, int v) {
                    if(djPlayListInfoBase0 != null) {
                        Navigator.openDjPlaylistDetail(djPlayListInfoBase0.plylstseq);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        this.tiaraLogOpenPlaylistDetail(djPlayListInfoBase0, v, this.contsTypeCode);
                    }
                }

                @Override  // B9.t
                public boolean longClickBody(DjPlayListInfoBase djPlayListInfoBase0, int v) {
                    if(djPlayListInfoBase0 != null) {
                        this.showContextPopupDjPlaylist(djPlayListInfoBase0);
                        return true;
                    }
                    return false;
                }

                @Override  // B9.t
                public void playDjPlaylist(DjPlayListInfoBase djPlayListInfoBase0, int v) {
                    if(djPlayListInfoBase0 != null) {
                        String s = djPlayListInfoBase0.plylstseq;
                        String s1 = djPlayListInfoBase0.contsTypeCode;
                        String s2 = PlaylistAdapter.this.getMenuId();
                        this.playPlaylist(s, s1, s2, djPlayListInfoBase0.statsElements);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        this.tiaraLogPlayPlaylist(djPlayListInfoBase0, v, this.contsTypeCode);
                    }
                }
            };
            this.seriesPlaylistActionListener = new t() {
                private final ContsTypeCode contsTypeCode;

                {
                    this.contsTypeCode = ContsTypeCode.MELON_DJ_SERIES;
                }

                @Override  // B9.t
                public void clickBody(DjPlayListInfoBase djPlayListInfoBase0, int v) {
                    if(djPlayListInfoBase0 != null) {
                        Navigator.INSTANCE.openSeriesFolderDetail(djPlayListInfoBase0.plylstseq);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        DjPlaylistFragment.this.tiaraLogOpenPlaylistDetail(djPlayListInfoBase0, v, this.contsTypeCode);
                    }
                }

                @Override  // B9.t
                public void clickThumbnail(DjPlayListInfoBase djPlayListInfoBase0, int v) {
                    if(djPlayListInfoBase0 != null) {
                        Navigator.INSTANCE.openSeriesFolderDetail(djPlayListInfoBase0.plylstseq);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        DjPlaylistFragment.this.tiaraLogOpenPlaylistDetail(djPlayListInfoBase0, v, this.contsTypeCode);
                    }
                }

                @Override  // B9.t
                public boolean longClickBody(DjPlayListInfoBase djPlayListInfoBase0, int v) {
                    return false;
                }

                @Override  // B9.t
                public void playDjPlaylist(DjPlayListInfoBase djPlayListInfoBase0, int v) {
                }
            };
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.getScrollableAlyacHolderCount() + this.getMakeAndSortHolderCount();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            if(this.getHeaderViewItemCount() > 0 && v == this.getAvailableHeaderPosition()) {
                return this.getScrollableAlyacHolderCount() <= 0 ? this.VIEW_TYPE_MAKE_AND_SORT : this.VIEW_TYPE_ALYAC_FILTER;
            }
            return this.getHeaderViewItemCount() <= 1 || v != this.getAvailableHeaderPosition() + 1 ? this.VIEW_TYPE_PLAYLIST : this.VIEW_TYPE_MAKE_AND_SORT;
        }

        private final int getMakeAndSortHolderCount() {
            return DjPlaylistFragment.this.isMyself();
        }

        private final int getScrollableAlyacHolderCount() {
            return DjPlaylistFragment.this.isPowerDj;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            int v2 = o00.getItemViewType();
            if(v2 == this.VIEW_TYPE_ALYAC_FILTER) {
                int v3 = (int)((v)o00).a.getResources().getDimension(0x7F0700E3);  // dimen:detail_list_padding_left_right
                ((v)o00).a.setPadding(v3);
                List list0 = DjPlaylistFragment.this.getFilterItems();
                ((v)o00).a.a(list0);
                ((v)o00).a.setSelectedIndex(DjPlaylistFragment.this.currentFilterIndex);
                c c0 = new c(DjPlaylistFragment.this, 0);
                E8.c c1 = new E8.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                ((v)o00).a.e(c0, c1);
                return;
            }
            if(v2 == this.VIEW_TYPE_MAKE_AND_SORT) {
                LinearLayoutCompat linearLayoutCompat0 = ((PlaylistMakeAndSortBarViewHolder)o00).getBinding().a;
                q.f(linearLayoutCompat0, "getRoot(...)");
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = linearLayoutCompat0.getLayoutParams();
                if(viewGroup$LayoutParams0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                int v4 = ScreenUtils.dipToPixel(this.getContext(), (this.getScrollableAlyacHolderCount() <= 0 ? 16.0f : 10.0f));
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).setMargins(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin, v4, ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin, ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin);
                linearLayoutCompat0.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
                b3 b30 = ((PlaylistMakeAndSortBarViewHolder)o00).getBinding();
                d d0 = new d(DjPlaylistFragment.this, 0);
                b30.c.setOnClickListener(d0);
                b3 b31 = ((PlaylistMakeAndSortBarViewHolder)o00).getBinding();
                d d1 = new d(DjPlaylistFragment.this, 1);
                b31.b.setOnClickListener(d1);
                b3 b32 = ((PlaylistMakeAndSortBarViewHolder)o00).getBinding();
                List list1 = DjPlaylistFragment.this.getSortingTexts();
                String s = (String)je.p.n0(DjPlaylistFragment.this.currentSortIndex, list1);
                b32.d.setText(s);
                String s1 = DjPlaylistFragment.this.getString(0x7F130BAE);  // string:talkback_order_by "정렬,"
                ViewUtils.setContentDescriptionWithButtonClassName(b32.d, s1 + s);
                e e0 = new e(0, DjPlaylistFragment.this, b32.d);
                b32.d.setOnClickListener(e0);
                return;
            }
            if(v2 == this.VIEW_TYPE_PLAYLIST) {
                J0 j00 = ((u)o00).a;
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.DjPlaylistListV6Res.RESPONSE.PLAYLIST");
                Q1 q10 = (Q1)j00.f;
                MelonTextView melonTextView0 = ((Q1)j00.f).k;
                ImageView imageView0 = j00.c;
                if(q.b(((PLAYLIST)object0).playlistTypeCode, "M20005")) {
                    ((u)o00).c(((PLAYLIST)object0), v1, this.seriesPlaylistActionListener, false);
                    ((RelativeLayout)j00.g).setVisibility(0);
                    ((Q1)j00.f).j.setVisibility(0);
                    ((Q1)j00.f).f.setVisibility(8);
                    melonTextView0.setVisibility(0);
                    melonTextView0.setText(DjPlaylistFragment.this.getString(0x7F130921, new Object[]{((PLAYLIST)object0).plyLstCnt}));  // string:series_playlist_count "%s개"
                    Object[] arr_object = {((PLAYLIST)object0).plylsttitle, q10.b.getText(), ((PLAYLIST)object0).plyLstCnt};
                    String s2 = DjPlaylistFragment.this.getString(0x7F130C45, arr_object);  // string:talkback_series_playlist_listitem_container "시리즈, %1$s, 제작자 %2$s, %3$s개, 
                                                                                            // 상세보기"
                    ViewUtils.setContentDescriptionWithButtonClassName(((u)o00).itemView, s2);
                }
                else {
                    ((u)o00).c(((PLAYLIST)object0), v1, this.djPlaylistActionLister, true);
                    if(DjPlaylistFragment.this.isMyself()) {
                        melonTextView0.setVisibility(0);
                        melonTextView0.setText(DjPlaylistFragment.this.getString(0x7F13083B, new Object[]{((PLAYLIST)object0).songcnt}));  // string:playlist_song_count "%s곡"
                        imageView0.setVisibility(0);
                        imageView0.setOnClickListener(new f(DjPlaylistFragment.this, ((PLAYLIST)object0), v1, 0));
                        imageView0.setImportantForAccessibility(2);
                    }
                    else {
                        melonTextView0.setVisibility(8);
                        imageView0.setVisibility(8);
                    }
                    com.iloen.melon.fragments.mymusic.DjPlaylistFragment.PlaylistAdapter.onBindViewImpl.7 djPlaylistFragment$PlaylistAdapter$onBindViewImpl$70 = new View.AccessibilityDelegate() {
                        @Override  // android.view.View$AccessibilityDelegate
                        public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                            q.g(view0, "host");
                            q.g(accessibilityNodeInfo0, "info");
                            super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, ((PLAYLIST)object0).getString(0x7F130272)));  // string:ctx_menu_open_playlist "플레이리스트 열기"
                            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, ((PLAYLIST)object0).getString(0x7F13025F)));  // string:ctx_menu_listen "듣기"
                            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000003, ((PLAYLIST)object0).getString(0x7F130266)));  // string:ctx_menu_more "더보기"
                            Object[] arr_object = {((u)o00).plylsttitle, ((Q1)this.$vh.a.f).b.getText(), ((u)o00).songcnt, ((Q1)this.$vh.a.f).e.getText()};
                            accessibilityNodeInfo0.setContentDescription(((PLAYLIST)object0).getString(0x7F130BE2, arr_object));  // string:talkback_playlist_common_listitem_container_count "%1$s, 제작자 %2$s, %3$s곡, 
                                                                                                                                  // 좋아요 %4$s개, 상세보기"
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
                                    ((Q1)this.$vh.a.f).f.performClick();
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
                    ((u)o00).itemView.setAccessibilityDelegate(djPlaylistFragment$PlaylistAdapter$onBindViewImpl$70);
                }
                q10.a.setImportantForAccessibility(4);
            }
        }

        private static final void onBindViewImpl$lambda$1$lambda$0(DjPlaylistFragment djPlaylistFragment0, int v) {
            if(djPlaylistFragment0.currentFilterIndex == v) {
                return;
            }
            djPlaylistFragment0.currentFilterIndex = v;
            djPlaylistFragment0.startFetch("alyac change");
            djPlaylistFragment0.tiaraLogClickAlyacView(v);
        }

        private static final void onBindViewImpl$lambda$3(DjPlaylistFragment djPlaylistFragment0, View view0) {
            if(djPlaylistFragment0.isPossiblePopupShow()) {
                djPlaylistFragment0.makePlaylist();
                djPlaylistFragment0.tiaraLogMakePlaylist();
            }
        }

        private static final void onBindViewImpl$lambda$5(DjPlaylistFragment djPlaylistFragment0, View view0) {
            if(djPlaylistFragment0.isPossiblePopupShow()) {
                b.x(djPlaylistFragment0.getChildFragmentManager(), djPlaylistFragment0.getString(0x7F130026), djPlaylistFragment0.getString(0x7F130CA9), false, false, null, djPlaylistFragment0.getString(0x7F130CA8), new com.iloen.melon.fragments.mymusic.b(djPlaylistFragment0, 0), null, null, null, 3704);  // string:add_song_with_image "이미지로 곡 추가"
                djPlaylistFragment0.tiaraLogImageToPlaylist();
            }
        }

        private static final H onBindViewImpl$lambda$5$lambda$4(DjPlaylistFragment djPlaylistFragment0) {
            djPlaylistFragment0.getPickMedia().b(k.c(new g()));  // 初始化器: Ljava/lang/Object;-><init>()V
            return H.a;
        }

        private static final void onBindViewImpl$lambda$7(DjPlaylistFragment djPlaylistFragment0, MelonTextView melonTextView0, View view0) {
            if(djPlaylistFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = djPlaylistFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(djPlaylistFragment0.getSortingTexts(), djPlaylistFragment0.currentSortIndex);
                    bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.fragments.mymusic.g(djPlaylistFragment0, melonTextView0, 0));
                    bottomSingleFilterListPopup0.setOnDismissListener(djPlaylistFragment0.mDialogDismissListener);
                    djPlaylistFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$7$lambda$6(DjPlaylistFragment djPlaylistFragment0, MelonTextView melonTextView0, int v) {
            djPlaylistFragment0.currentSortIndex = v;
            melonTextView0.setText(((String)je.p.n0(djPlaylistFragment0.currentSortIndex, djPlaylistFragment0.getSortingTexts())));
            djPlaylistFragment0.startFetch("filter change");
        }

        private static final void onBindViewImpl$lambda$8(DjPlaylistFragment djPlaylistFragment0, PLAYLIST djPlaylistListV6Res$RESPONSE$PLAYLIST0, int v, View view0) {
            djPlaylistFragment0.showContextPopupDjPlaylist(djPlaylistListV6Res$RESPONSE$PLAYLIST0);
            djPlaylistFragment0.tiaraLogMoreDjPlaylist(djPlaylistListV6Res$RESPONSE$PLAYLIST0, v);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_ALYAC_FILTER) {
                return a.w(viewGroup0);
            }
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
    private static final String ARG_FILTER_TYPE = "argFilterIndex";
    @NotNull
    private static final String ARG_IS_POWER_DJ = "argIsPowerDj";
    @NotNull
    private static final String ARG_SORT_TYPE = "argSortIndex";
    @NotNull
    private static final String ARG_TARGET_MEMBERKEY = "argTargetMemberKey";
    @NotNull
    public static final Companion Companion = null;
    public static final int FILTER_ALL = 0;
    public static final int FILTER_SERIES = 1;
    public static final int SORT_ALPHABET = 2;
    public static final int SORT_LIKE = 3;
    public static final int SORT_RECENT_EDIT = 0;
    public static final int SORT_UPDETE = 1;
    @NotNull
    private static final String TAG = "DjPlaylistFragment";
    private static final int TALKBACK_ACTION_DEFAULT = 100000000;
    private static final int TALKBACK_ACTION_MORE = 100000003;
    private static final int TALKBACK_ACTION_NAVIGATE_PLAYLIST_DETAIL = 100000001;
    private static final int TALKBACK_ACTION_PLAYBACK = 100000002;
    private int currentFilterIndex;
    private int currentSortIndex;
    private boolean isPowerDj;
    @NotNull
    private final e.b pickMedia;
    @NotNull
    private final j sortingTexts$delegate;
    @NotNull
    private String targetMemberKey;

    static {
        DjPlaylistFragment.Companion = new Companion(null);
        DjPlaylistFragment.$stable = 8;
    }

    public DjPlaylistFragment() {
        this.targetMemberKey = "";
        this.sortingTexts$delegate = d3.g.Q(new com.iloen.melon.fragments.mymusic.b(this, 1));
        e.b b0 = this.registerForActivityResult(new f.c(5), new W(1));
        q.f(b0, "registerForActivityResult(...)");
        this.pickMedia = b0;
    }

    private final void checkWithMakeDjPlaylist() {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        RequestBuilder.newInstance(new MyMusicDjPlaylistInformCntCheckReq(this.getContext())).tag("DjPlaylistFragment").listener(new c(this, 2)).errorListener(new W(3)).request();
    }

    private static final void checkWithMakeDjPlaylist$lambda$13(DjPlaylistFragment djPlaylistFragment0, Object object0) {
        q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.MyMusicDjPlaylistInformCntCheckRes");
        if(djPlaylistFragment0.isFragmentValid()) {
            Cb.j.b(((MyMusicDjPlaylistInformCntCheckRes)object0).notification, false, 3);
            if(Cb.j.d(((HttpResponse)object0))) {
                RESPONSE myMusicDjPlaylistInformCntCheckRes$RESPONSE0 = ((MyMusicDjPlaylistInformCntCheckRes)object0).response;
                String s = null;
                if("N".equals((myMusicDjPlaylistInformCntCheckRes$RESPONSE0 == null ? null : myMusicDjPlaylistInformCntCheckRes$RESPONSE0.cntoverYn))) {
                    Navigator.open(PlaylistMakeFragment.newInstance("", "M20002", "melondjMakeDjplaylist"));
                    return;
                }
                l0 l00 = djPlaylistFragment0.getChildFragmentManager();
                String s1 = djPlaylistFragment0.getContext() == null ? null : "안내";
                if(djPlaylistFragment0.getContext() != null) {
                    s = "플레이리스트는 최대 500개까지 만들 수 있습니다. 기존 플레이리스트를 삭제하신 후 다시 시도해주세요.";
                }
                b.d(b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
            }
        }
    }

    private static final void checkWithMakeDjPlaylist$lambda$14(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final void checkWithMakePlaylist() {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        RequestBuilder.newInstance(new MyMusicPlaylistInformCntCheckReq(this.getContext())).tag(this.getRequestTag()).listener(new c(this, 3)).errorListener(new W(4)).request();
    }

    private static final void checkWithMakePlaylist$lambda$10(DjPlaylistFragment djPlaylistFragment0, Object object0) {
        q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.MyMusicPlaylistInformCntCheckRes");
        if(djPlaylistFragment0.isFragmentValid()) {
            Cb.j.b(((MyMusicPlaylistInformCntCheckRes)object0).notification, false, 3);
            if(Cb.j.d(((HttpResponse)object0))) {
                com.iloen.melon.net.v4x.response.MyMusicPlaylistInformCntCheckRes.RESPONSE myMusicPlaylistInformCntCheckRes$RESPONSE0 = ((MyMusicPlaylistInformCntCheckRes)object0).response;
                String s = null;
                if("N".equals((myMusicPlaylistInformCntCheckRes$RESPONSE0 == null ? null : myMusicPlaylistInformCntCheckRes$RESPONSE0.cntoverYn))) {
                    Navigator.open(PlaylistMakeFragment.newInstance("", "M20001", "mymusicPlaylistNewMake"));
                    return;
                }
                l0 l00 = djPlaylistFragment0.getChildFragmentManager();
                String s1 = djPlaylistFragment0.getContext() == null ? null : "안내";
                if(djPlaylistFragment0.getContext() != null) {
                    s = "플레이리스트는 최대 500개까지 만들 수 있습니다. 기존 플레이리스트를 삭제하신 후 다시 시도해주세요.";
                }
                b.d(b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
            }
        }
    }

    private static final void checkWithMakePlaylist$lambda$11(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final void checkWithMakeSeriesFolder() {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        RequestBuilder.newInstance(new MyMusicSeriesInformCntCheckReq(this.getContext())).tag("DjPlaylistFragment").listener(new c(this, 1)).errorListener(new W(2)).request();
    }

    private static final void checkWithMakeSeriesFolder$lambda$16(DjPlaylistFragment djPlaylistFragment0, Object object0) {
        q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.MyMusicSeriesInformCntCheckRes");
        if(djPlaylistFragment0.isFragmentValid()) {
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

    private static final void checkWithMakeSeriesFolder$lambda$17(VolleyError volleyError0) {
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

    private final p8.f getBaseTiaraLogEventBuilder() {
        p8.f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        s s0 = this.mMelonTiaraProperty;
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
        String s = MelonContentUris.Y.buildUpon().appendQueryParameter("targetMemberKey", this.targetMemberKey).appendQueryParameter("sortIndex", String.valueOf(this.currentSortIndex)).appendQueryParameter("filterIndex", String.valueOf(this.currentFilterIndex)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final List getFilterItems() {
        String[] arr_s = this.getResources().getStringArray(0x7F03001C);  // array:my_music_dj_playlist_filter_type
        q.f(arr_s, "getStringArray(...)");
        List list0 = new ArrayList(arr_s.length);
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.b = s;
            list0.add(j0);
        }
        return list0;
    }

    @NotNull
    public final e.b getPickMedia() {
        return this.pickMedia;
    }

    private final List getSortingTexts() {
        return (List)this.sortingTexts$delegate.getValue();
    }

    // 去混淆评级： 低(20)
    private final int getTopPadding() {
        return this.isMyself() || this.isPowerDj ? 0 : ScreenUtils.dipToPixel(this.getContext(), 10.0f);
    }

    @Override  // com.iloen.melon.fragments.mymusic.OnCheckMyself
    public boolean isMyself() {
        return this.targetMemberKey.length() > 0 && q.b(this.targetMemberKey, e1.u.v(((e0)o.a()).j()));
    }

    private final void makePlaylist() {
        if(!this.isMyself()) {
            LogU.Companion.d("DjPlaylistFragment", "makePlaylist() : in other playlist, but try to make new one");
            return;
        }
        if(((e0)o.a()).j().getIsDj()) {
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(x.x);
            arrayList0.add(x.y);
            if(this.isPowerDj) {
                arrayList0.add(x.z);
            }
            l0 l00 = this.getChildFragmentManager();
            String s = this.getString(0x7F130C9F);  // string:text_make_playlist "플레이리스트 만들기"
            q.f(s, "getString(...)");
            b.u(l00, s, arrayList0, new com.iloen.melon.fragments.mymusic.a(this, 0));
            return;
        }
        this.checkWithMakePlaylist();
    }

    private static final H makePlaylist$lambda$8(DjPlaylistFragment djPlaylistFragment0, k2 k20) {
        q.g(k20, "onEvent");
        if(k20 instanceof K1) {
            switch(WhenMappings.$EnumSwitchMapping$0[((K1)k20).b.a.ordinal()]) {
                case 1: {
                    djPlaylistFragment0.checkWithMakePlaylist();
                    break;
                }
                case 2: {
                    djPlaylistFragment0.checkWithMakeDjPlaylist();
                    return H.a;
                }
                case 3: {
                    djPlaylistFragment0.checkWithMakeSeriesFolder();
                    return H.a;
                }
                default: {
                    return H.a;
                }
            }
        }
        return H.a;
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
        return layoutInflater0.inflate(0x7F0D01E7, viewGroup0, false);  // layout:default_recyclerview
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @Nullable h h0, @Nullable String s) {
        q.g(i0, "type");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.DjPlaylistFragment.PlaylistAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((PlaylistAdapter)j00).clear();
        }
        Params djPlaylistListV6Req$Params0 = new Params();
        djPlaylistListV6Req$Params0.startIndex = i1.equals(i0) ? 1 : ((PlaylistAdapter)j00).getCount() + 1;
        djPlaylistListV6Req$Params0.pageSize = 100;
        String s1 = "DSP";
        switch(this.currentSortIndex) {
            case 1: {
                s1 = "UDT";
                break;
            }
            case 2: {
                s1 = "ALP";
                break;
            }
            case 3: {
                s1 = "LIK";
            }
        }
        djPlaylistListV6Req$Params0.sortBy = s1;
        djPlaylistListV6Req$Params0.targetMemberKey = this.targetMemberKey;
        djPlaylistListV6Req$Params0.plylstTypeCode = this.currentFilterIndex == 1 ? "M20005" : "all";
        djPlaylistListV6Req$Params0.mode = "inform";
        RequestBuilder.newInstance(new DjPlaylistListV6Req(this.getContext(), djPlaylistListV6Req$Params0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.mymusic.g(this, i0, 9)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$5(DjPlaylistFragment djPlaylistFragment0, i i0, DjPlaylistListV6Res djPlaylistListV6Res0) {
        if(!djPlaylistFragment0.prepareFetchComplete(djPlaylistListV6Res0)) {
            return;
        }
        com.iloen.melon.net.v6x.response.DjPlaylistListV6Res.RESPONSE djPlaylistListV6Res$RESPONSE0 = djPlaylistListV6Res0 == null ? null : djPlaylistListV6Res0.response;
        if(djPlaylistListV6Res$RESPONSE0 != null) {
            djPlaylistFragment0.mMelonTiaraProperty = new s(djPlaylistListV6Res$RESPONSE0.section, djPlaylistListV6Res$RESPONSE0.page, djPlaylistListV6Res$RESPONSE0.menuId, null);
        }
        djPlaylistFragment0.performFetchComplete(i0, djPlaylistListV6Res0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argTargetMemberKey");
        if(s == null) {
            s = "";
        }
        this.targetMemberKey = s;
        this.currentSortIndex = bundle0.getInt("argSortIndex");
        this.currentFilterIndex = bundle0.getInt("argFilterIndex");
        this.isPowerDj = bundle0.getBoolean("argIsPowerDj");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argTargetMemberKey", this.targetMemberKey);
        bundle0.putInt("argSortIndex", this.currentSortIndex);
        bundle0.putInt("argFilterIndex", this.currentFilterIndex);
        bundle0.putBoolean("argIsPowerDj", this.isPowerDj);
    }

    private static final void pickMedia$lambda$3(List list0) {
        q.g(list0, "uris");
        if(!list0.isEmpty()) {
            ImageToPlaylistFragment imageToPlaylistFragment0 = ImageToPlaylistFragment.Companion.newInstance(list0);
            Navigator.INSTANCE.open(imageToPlaylistFragment0);
            return;
        }
        LogU.Companion.d("DjPlaylistFragment", "No media selected");
    }

    private static final List sortingTexts_delegate$lambda$2(DjPlaylistFragment djPlaylistFragment0) {
        Context context0 = djPlaylistFragment0.getContext();
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

    private final void tiaraLogClickAlyacView(int v) {
        p8.f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.y = this.getString(0x7F130EB8);  // string:tiara_gnb_layer1_gnb "GNB"
        v9.j j0 = (v9.j)je.p.n0(v, this.getFilterItems());
        f0.F = j0 == null ? null : j0.b;
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

    private final void tiaraLogMoreDjPlaylist(DjPlayListInfoBase djPlayListInfoBase0, int v) {
        p8.f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.C = String.valueOf(v + 1);
        f0.F = this.getString(0x7F130D54);  // string:tiara_click_copy_more "더보기"
        f0.e = djPlayListInfoBase0.plylstseq;
        f0.f = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
        f0.g = djPlayListInfoBase0.plylsttitle;
        f0.a().track();
    }

    private final void tiaraLogOpenPlaylistDetail(DjPlayListInfoBase djPlayListInfoBase0, int v, ContsTypeCode contsTypeCode0) {
        p8.f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.C = String.valueOf(v + 1);
        f0.e = djPlayListInfoBase0.plylstseq;
        f0.f = Y.i(contsTypeCode0, "code(...)");
        f0.g = djPlayListInfoBase0.plylsttitle;
        f0.a().track();
    }

    private final void tiaraLogPlayPlaylist(DjPlayListInfoBase djPlayListInfoBase0, int v, ContsTypeCode contsTypeCode0) {
        p8.f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.PlayMusic;
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.C = String.valueOf(v + 1);
        f0.e = djPlayListInfoBase0.plylstseq;
        f0.f = Y.i(contsTypeCode0, "code(...)");
        f0.g = djPlayListInfoBase0.plylsttitle;
        f0.a().track();
    }
}

