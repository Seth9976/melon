package com.iloen.melon.fragments.mymusic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.ToggleView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.request.LikeListArtistPlaylistBaseReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicLikeListArtistPlaylistReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeListDjPlaylistReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeListPlaylistReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeListSameArtistPlaylistReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeListSameDjPlaylistReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeListSamePlaylistReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeListArtistPlaylistRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListDjPlaylistRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListPlaylistRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSameArtistPlaylistRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSameDjPlaylistRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSamePlaylistRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.DjPlaylistNewHolderImpl.OnClickListener;
import com.iloen.melon.viewholders.DjPlaylistNewHolderImpl;
import com.iloen.melon.viewholders.PlaylistNewHolderImpl;
import com.melon.net.res.common.DjPlayListInfoBase;
import e.k;
import e1.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import v9.j;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0002IJB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\t\u001A\u00020\b2\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J!\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001D\u001A\u00020\u00152\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0005H\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010 \u001A\u00020\u00122\u0006\u0010\u001F\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b \u0010!J\u000F\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b#\u0010$J\u001B\u0010(\u001A\u0006\u0012\u0002\b\u00030\'2\u0006\u0010&\u001A\u00020%H\u0014\u00A2\u0006\u0004\b(\u0010)J\u0019\u0010*\u001A\u00020\u00122\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0002\u00A2\u0006\u0004\b*\u0010+J\u0019\u0010,\u001A\u00020\u00122\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0002\u00A2\u0006\u0004\b,\u0010+J\u0019\u0010-\u001A\u00020\u00122\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0002\u00A2\u0006\u0004\b-\u0010+J\u0019\u0010.\u001A\u00020\u00122\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0002\u00A2\u0006\u0004\b.\u0010+J\u0019\u0010/\u001A\u00020\u00122\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0002\u00A2\u0006\u0004\b/\u0010+J\u0019\u00100\u001A\u00020\u00122\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0002\u00A2\u0006\u0004\b0\u0010+J\u0019\u00102\u001A\u0002012\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0002\u00A2\u0006\u0004\b2\u00103J\u0017\u00105\u001A\u00020\u00122\u0006\u00104\u001A\u000201H\u0002\u00A2\u0006\u0004\b5\u00106J\u0017\u00107\u001A\u00020\u00052\u0006\u00104\u001A\u000201H\u0002\u00A2\u0006\u0004\b7\u00108R\u0014\u00109\u001A\u0002018\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001A\u0002018\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b;\u0010:R\u0014\u0010<\u001A\u0002018\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b<\u0010:R\u0014\u0010=\u001A\u0002018\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b=\u0010:R\u0014\u0010>\u001A\u0002018\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b>\u0010:R$\u0010B\u001A\u0012\u0012\u0004\u0012\u00020@0?j\b\u0012\u0004\u0012\u00020@`A8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001A\u0002018\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010:R\u0016\u0010G\u001A\u0002018\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010:R\u0016\u0010H\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bH\u0010E\u00A8\u0006K"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedPlaylistFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lcom/iloen/melon/fragments/mymusic/OnCheckMyself;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "isMyself", "()Z", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "requestLikePlaylist", "(Lv9/i;)V", "requestLikeSamePlaylist", "requestLikeDjPlaylist", "requestLikeSameDjPlaylist", "requestLikeArtistPlaylist", "requestLikeSameArtistPlaylist", "", "getStartIndex", "(Lv9/i;)I", "position", "setToggleData", "(I)V", "getFilterTypeForServer", "(I)Ljava/lang/String;", "SORT_NOMAL", "I", "SORT_DJ", "SORT_ARTIST", "START_INDEX", "PAGE_SIZE", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "toggleList", "Ljava/util/ArrayList;", "toggleType", "Ljava/lang/String;", "togglePos", "sortPos", "memberKey", "Companion", "LikedPlaylistAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicLikedPlaylistFragment extends MetaContentBaseFragment implements OnCheckMyself {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedPlaylistFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicLikedPlaylistFragment;", "targetMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicLikedPlaylistFragment newInstance(@NotNull String s) {
            q.g(s, "targetMemberKey");
            MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0 = new MyMusicLikedPlaylistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            myMusicLikedPlaylistFragment0.setArguments(bundle0);
            return myMusicLikedPlaylistFragment0;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001D\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\r2\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001A\u001A\u00020\u00032\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ)\u0010\u001E\u001A\u00020\u001D2\b\u0010\u001C\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010!¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedPlaylistFragment$LikedPlaylistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v4x/common/ArtistPlayListInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedPlaylistFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "sortPosition", "", "", "getToggleNameList", "(I)Ljava/util/List;", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "getHeaderViewItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER", "I", "VIEW_TYPE_PLAYLIST", "VIEW_TYPE_DJ_PLAYLIST", "HeaderViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LikedPlaylistAdapter extends p {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedPlaylistFragment$LikedPlaylistAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedPlaylistFragment$LikedPlaylistAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/SortingBarView;", "sortBarView", "Lcom/iloen/melon/custom/SortingBarView;", "getSortBarView", "()Lcom/iloen/melon/custom/SortingBarView;", "Lcom/iloen/melon/custom/ToggleView;", "toggleView", "Lcom/iloen/melon/custom/ToggleView;", "getToggleView", "()Lcom/iloen/melon/custom/ToggleView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class HeaderViewHolder extends O0 {
            @NotNull
            private final SortingBarView sortBarView;
            @NotNull
            private final ToggleView toggleView;

            public HeaderViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                LikedPlaylistAdapter.this = myMusicLikedPlaylistFragment$LikedPlaylistAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0AB8);  // id:sort_bar
                q.f(view1, "findViewById(...)");
                this.sortBarView = (SortingBarView)view1;
                View view2 = view0.findViewById(0x7F0A0498);  // id:filter
                q.f(view2, "findViewById(...)");
                this.toggleView = (ToggleView)view2;
                ((SortingBarView)view1).setItems(MyMusicLikedPlaylistFragment.this.getResources().getStringArray(0x7F03001F));  // array:my_music_playlist_like_sort_type
                ((SortingBarView)view1).setSortBarStyle(2);
                ((SortingBarView)view1).setButtonWidth(ScreenUtils.dipToPixel(myMusicLikedPlaylistFragment$LikedPlaylistAdapter0.getContext(), 86.0f));
                ((ToggleView)view2).e(myMusicLikedPlaylistFragment$LikedPlaylistAdapter0.getToggleNameList(MyMusicLikedPlaylistFragment.this.sortPos), new G(MyMusicLikedPlaylistFragment.this, 1));
                ((ToggleView)view2).setFilterPosition(MyMusicLikedPlaylistFragment.this.togglePos);
            }

            private static final void _init_$lambda$0(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, int v, String s) {
                myMusicLikedPlaylistFragment0.toggleType = myMusicLikedPlaylistFragment0.getFilterTypeForServer(v);
                myMusicLikedPlaylistFragment0.togglePos = v;
                myMusicLikedPlaylistFragment0.startFetch("toggle change");
            }

            public static void a(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, int v, String s) {
                HeaderViewHolder._init_$lambda$0(myMusicLikedPlaylistFragment0, v, s);
            }

            @NotNull
            public final SortingBarView getSortBarView() {
                return this.sortBarView;
            }

            @NotNull
            public final ToggleView getToggleView() {
                return this.toggleView;
            }
        }

        private final int VIEW_TYPE_DJ_PLAYLIST;
        private final int VIEW_TYPE_HEADER;
        private final int VIEW_TYPE_PLAYLIST;

        public LikedPlaylistAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicLikedPlaylistFragment.this = myMusicLikedPlaylistFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_HEADER = 1;
            this.VIEW_TYPE_PLAYLIST = 2;
            this.VIEW_TYPE_DJ_PLAYLIST = 3;
        }

        public static void a(ArtistPlayListInfoBase artistPlayListInfoBase0, MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, LikedPlaylistAdapter myMusicLikedPlaylistFragment$LikedPlaylistAdapter0, View view0, int v) {
            LikedPlaylistAdapter.onBindViewImpl$lambda$8$lambda$7(artistPlayListInfoBase0, myMusicLikedPlaylistFragment0, myMusicLikedPlaylistFragment$LikedPlaylistAdapter0, view0, v);
        }

        public static void b(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, ArtistPlayListInfoBase artistPlayListInfoBase0, View view0, int v) {
            LikedPlaylistAdapter.onBindViewImpl$lambda$6$lambda$5(myMusicLikedPlaylistFragment0, artistPlayListInfoBase0, view0, v);
        }

        public static void c(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, int v, String s) {
            LikedPlaylistAdapter.onBindViewImpl$lambda$3$lambda$2$lambda$1(myMusicLikedPlaylistFragment0, v, s);
        }

        public static void d(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, ArtistPlayListInfoBase artistPlayListInfoBase0, DjPlayListInfoBase djPlayListInfoBase0) {
            LikedPlaylistAdapter.onBindViewImpl$lambda$6$lambda$4(myMusicLikedPlaylistFragment0, artistPlayListInfoBase0, djPlayListInfoBase0);
        }

        public static void e(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, HeaderViewHolder myMusicLikedPlaylistFragment$LikedPlaylistAdapter$HeaderViewHolder0, LikedPlaylistAdapter myMusicLikedPlaylistFragment$LikedPlaylistAdapter0, int v) {
            LikedPlaylistAdapter.onBindViewImpl$lambda$3$lambda$2(myMusicLikedPlaylistFragment0, myMusicLikedPlaylistFragment$LikedPlaylistAdapter$HeaderViewHolder0, myMusicLikedPlaylistFragment$LikedPlaylistAdapter0, v);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            if(v == this.getAvailableHeaderPosition()) {
                return this.VIEW_TYPE_HEADER;
            }
            return MyMusicLikedPlaylistFragment.this.sortPos == MyMusicLikedPlaylistFragment.this.SORT_DJ ? this.VIEW_TYPE_DJ_PLAYLIST : this.VIEW_TYPE_PLAYLIST;
        }

        private final List getToggleNameList(int v) {
            int v1;
            if(MyMusicLikedPlaylistFragment.this.isMyself()) {
                switch(v) {
                    case 0: {
                        v1 = 0x7F030046;  // array:sortingbar_playlist
                        break;
                    }
                    case 1: {
                        v1 = 0x7F030037;  // array:sortingbar_djplaylist
                        break;
                    }
                    default: {
                        v1 = 0x7F030034;  // array:sortingbar_artistplaylist
                    }
                }
            }
            else {
                v1 = 0x7F030021;  // array:other_music_like
            }
            String[] arr_s = MyMusicLikedPlaylistFragment.this.getResources().getStringArray(v1);
            q.f(arr_s, "getStringArray(...)");
            return k.A(Arrays.copyOf(arr_s, arr_s.length));
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            ArtistPlayListInfoBase artistPlayListInfoBase0 = (ArtistPlayListInfoBase)this.getItem(v1);
            if(o00 instanceof HeaderViewHolder) {
                MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0 = MyMusicLikedPlaylistFragment.this;
                if(!myMusicLikedPlaylistFragment0.isMyself() || this.getCount() >= 1) {
                    ViewUtils.showWhen(((HeaderViewHolder)o00).getToggleView(), true);
                }
                else {
                    ViewUtils.hideWhen(((HeaderViewHolder)o00).getToggleView(), true);
                }
                if(!myMusicLikedPlaylistFragment0.isMyself() || this.getCount() <= 0) {
                    ((HeaderViewHolder)o00).getSortBarView().setRightLayout(null);
                }
                else {
                    SortingBarView sortingBarView0 = ((HeaderViewHolder)o00).getSortBarView();
                    g g0 = new g(myMusicLikedPlaylistFragment0, this, 4);
                    sortingBarView0.c(L.f, g0);
                }
                ((HeaderViewHolder)o00).getSortBarView().setSelection(myMusicLikedPlaylistFragment0.sortPos);
                ((HeaderViewHolder)o00).getSortBarView().setOnSortSelectionListener(new E(myMusicLikedPlaylistFragment0, ((HeaderViewHolder)o00), this, 0));
                return;
            }
            if(o00 instanceof DjPlaylistNewHolderImpl) {
                ViewUtils.showWhen(((DjPlaylistNewHolderImpl)o00).moreIv, true);
                ((DjPlaylistNewHolderImpl)o00).bindView(artistPlayListInfoBase0, v1);
                ((DjPlaylistNewHolderImpl)o00).setOnClickListener(new OnClickListener() {
                    @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                    public void clickBody(DjPlayListInfoBase djPlayListInfoBase0) {
                        q.g(djPlayListInfoBase0, "data");
                        Navigator.openDjPlaylistDetail(djPlayListInfoBase0.plylstseq);
                    }

                    @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                    public void clickTag1(String s) {
                        q.g(s, "tagSeq");
                        Navigator.openMelonDJTagHubDetail(s);
                    }

                    @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                    public void clickTag2(String s) {
                        q.g(s, "tagSeq");
                        Navigator.openMelonDJTagHubDetail(s);
                    }

                    @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                    public void clickThumbnail(DjPlayListInfoBase djPlayListInfoBase0) {
                        q.g(djPlayListInfoBase0, "data");
                        Navigator.openDjPlaylistDetail(djPlayListInfoBase0.plylstseq);
                    }

                    @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                    public void playDjPlaylist(DjPlayListInfoBase djPlayListInfoBase0) {
                        q.g(djPlayListInfoBase0, "data");
                        String s = djPlayListInfoBase0.plylstseq;
                        String s1 = djPlayListInfoBase0.contsTypeCode;
                        String s2 = LikedPlaylistAdapter.this.getMenuId();
                        this.playPlaylist(s, s1, s2, djPlayListInfoBase0.statsElements);
                    }
                });
                ((DjPlaylistNewHolderImpl)o00).setOnMoreClickListener(new F(MyMusicLikedPlaylistFragment.this, artistPlayListInfoBase0));
                ((DjPlaylistNewHolderImpl)o00).setOnLongClickListener(new F(MyMusicLikedPlaylistFragment.this, artistPlayListInfoBase0));
                return;
            }
            if(o00 instanceof PlaylistNewHolderImpl) {
                MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment1 = MyMusicLikedPlaylistFragment.this;
                if(artistPlayListInfoBase0 != null) {
                    ViewUtils.showWhen(((PlaylistNewHolderImpl)o00).moreIv, true);
                    ((PlaylistNewHolderImpl)o00).bindView(artistPlayListInfoBase0, v1);
                    ((PlaylistNewHolderImpl)o00).setOnClickListener(new com.iloen.melon.viewholders.PlaylistNewHolderImpl.OnClickListener() {
                        @Override  // com.iloen.melon.viewholders.PlaylistNewHolderImpl$OnClickListener
                        public void clickItemView(ArtistPlayListInfoBase artistPlayListInfoBase0) {
                            q.g(artistPlayListInfoBase0, "data");
                            if("Y".equals(artistPlayListInfoBase0.isartist)) {
                                Navigator.INSTANCE.openArtistPlaylistDetail(artistPlayListInfoBase0.plylstseq);
                                return;
                            }
                            Navigator.INSTANCE.openPlaylistDetail(artistPlayListInfoBase0.plylstseq);
                        }

                        @Override  // com.iloen.melon.viewholders.PlaylistNewHolderImpl$OnClickListener
                        public void clickMore(ArtistPlayListInfoBase artistPlayListInfoBase0) {
                            q.g(artistPlayListInfoBase0, "data");
                            if("Y".equals(artistPlayListInfoBase0.isartist)) {
                                String s = LikedPlaylistAdapter.this.getMenuId();
                                this.showContextPopupArtistPlaylist(artistPlayListInfoBase0, s);
                                return;
                            }
                            this.showContextPopupPlayList(artistPlayListInfoBase0);
                        }

                        @Override  // com.iloen.melon.viewholders.PlaylistNewHolderImpl$OnClickListener
                        public void playPlaylist(ArtistPlayListInfoBase artistPlayListInfoBase0) {
                            q.g(artistPlayListInfoBase0, "data");
                            String s = artistPlayListInfoBase0.plylstseq;
                            String s1 = artistPlayListInfoBase0.contsTypeCode;
                            String s2 = LikedPlaylistAdapter.this.getMenuId();
                            this.playPlaylist(s, s1, s2, artistPlayListInfoBase0.statsElements);
                        }
                    });
                    ((PlaylistNewHolderImpl)o00).setOnLongClickListener(new E(artistPlayListInfoBase0, myMusicLikedPlaylistFragment1, this));
                }
            }
        }

        private static final void onBindViewImpl$lambda$3$lambda$0(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, LikedPlaylistAdapter myMusicLikedPlaylistFragment$LikedPlaylistAdapter0, View view0) {
            String s;
            int v = myMusicLikedPlaylistFragment0.sortPos;
            if(v == myMusicLikedPlaylistFragment0.SORT_NOMAL) {
                s = "playlist";
            }
            else {
                s = v == myMusicLikedPlaylistFragment0.SORT_DJ ? "dj_playlist" : "artist_playlist";
            }
            MyMusicLikeEditFragment.newInstance(s, myMusicLikedPlaylistFragment0.toggleType, myMusicLikedPlaylistFragment$LikedPlaylistAdapter0.getCacheKey()).open();
        }

        private static final void onBindViewImpl$lambda$3$lambda$2(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, HeaderViewHolder myMusicLikedPlaylistFragment$LikedPlaylistAdapter$HeaderViewHolder0, LikedPlaylistAdapter myMusicLikedPlaylistFragment$LikedPlaylistAdapter0, int v) {
            if(myMusicLikedPlaylistFragment0.sortPos == v) {
                return;
            }
            myMusicLikedPlaylistFragment0.sortPos = v;
            myMusicLikedPlaylistFragment0.setToggleData(myMusicLikedPlaylistFragment0.sortPos);
            String s = ((j)myMusicLikedPlaylistFragment0.toggleList.get(0)).c;
            q.f(s, "code");
            myMusicLikedPlaylistFragment0.toggleType = s;
            myMusicLikedPlaylistFragment$LikedPlaylistAdapter$HeaderViewHolder0.getToggleView().e(myMusicLikedPlaylistFragment$LikedPlaylistAdapter0.getToggleNameList(myMusicLikedPlaylistFragment0.sortPos), new G(myMusicLikedPlaylistFragment0, 0));
            myMusicLikedPlaylistFragment0.startFetch("sortbar change");
        }

        private static final void onBindViewImpl$lambda$3$lambda$2$lambda$1(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, int v, String s) {
            myMusicLikedPlaylistFragment0.toggleType = myMusicLikedPlaylistFragment0.getFilterTypeForServer(v);
            myMusicLikedPlaylistFragment0.togglePos = v;
            myMusicLikedPlaylistFragment0.startFetch("toggle change");
        }

        private static final void onBindViewImpl$lambda$6$lambda$4(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, ArtistPlayListInfoBase artistPlayListInfoBase0, DjPlayListInfoBase djPlayListInfoBase0) {
            myMusicLikedPlaylistFragment0.showContextPopupPlayList(artistPlayListInfoBase0);
        }

        private static final void onBindViewImpl$lambda$6$lambda$5(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, ArtistPlayListInfoBase artistPlayListInfoBase0, View view0, int v) {
            myMusicLikedPlaylistFragment0.showContextPopupPlayList(artistPlayListInfoBase0);
        }

        private static final void onBindViewImpl$lambda$8$lambda$7(ArtistPlayListInfoBase artistPlayListInfoBase0, MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, LikedPlaylistAdapter myMusicLikedPlaylistFragment$LikedPlaylistAdapter0, View view0, int v) {
            if("Y".equals(artistPlayListInfoBase0.isartist)) {
                myMusicLikedPlaylistFragment0.showContextPopupArtistPlaylist(artistPlayListInfoBase0, myMusicLikedPlaylistFragment$LikedPlaylistAdapter0.getMenuId());
                return;
            }
            myMusicLikedPlaylistFragment0.showContextPopupPlayList(artistPlayListInfoBase0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_HEADER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0859, viewGroup0, false);  // layout:sortbar_filter_toggle
                q.f(view0, "inflate(...)");
                return new HeaderViewHolder(this, view0);
            }
            return v == this.VIEW_TYPE_DJ_PLAYLIST ? new DjPlaylistNewHolderImpl(LayoutInflater.from(this.getContext()).inflate(0x7F0D048E, viewGroup0, false)) : new PlaylistNewHolderImpl(LayoutInflater.from(this.getContext()).inflate(0x7F0D049F, viewGroup0, false));  // layout:listitem_djplaylist_new
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private final int PAGE_SIZE;
    private final int SORT_ARTIST;
    private final int SORT_DJ;
    private final int SORT_NOMAL;
    private final int START_INDEX;
    @NotNull
    private static final String TAG = "MyMusicLikedPlaylistFragment";
    @NotNull
    private String memberKey;
    private int sortPos;
    @NotNull
    private final ArrayList toggleList;
    private int togglePos;
    @NotNull
    private String toggleType;

    static {
        MyMusicLikedPlaylistFragment.Companion = new Companion(null);
        MyMusicLikedPlaylistFragment.$stable = 8;
    }

    public MyMusicLikedPlaylistFragment() {
        this.SORT_DJ = 1;
        this.SORT_ARTIST = 2;
        this.START_INDEX = 1;
        this.PAGE_SIZE = 100;
        this.toggleList = new ArrayList();
        this.toggleType = "NEW";
        this.sortPos = 1;
        this.memberKey = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new LikedPlaylistAdapter(this, context0, null);
        ((com.iloen.melon.adapters.common.j)j00).setListContentType(4);
        return j00;
    }

    public static void d0(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, i i0, MyMusicLikeListSameArtistPlaylistRes myMusicLikeListSameArtistPlaylistRes0) {
        MyMusicLikedPlaylistFragment.requestLikeSameArtistPlaylist$lambda$12(myMusicLikedPlaylistFragment0, i0, myMusicLikeListSameArtistPlaylistRes0);
    }

    public static void e0(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, i i0, MyMusicLikeListDjPlaylistRes myMusicLikeListDjPlaylistRes0) {
        MyMusicLikedPlaylistFragment.requestLikeDjPlaylist$lambda$6(myMusicLikedPlaylistFragment0, i0, myMusicLikeListDjPlaylistRes0);
    }

    public static void f0(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, i i0, MyMusicLikeListPlaylistRes myMusicLikeListPlaylistRes0) {
        MyMusicLikedPlaylistFragment.requestLikePlaylist$lambda$2(myMusicLikedPlaylistFragment0, i0, myMusicLikeListPlaylistRes0);
    }

    public static void g0(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, i i0, MyMusicLikeListSameDjPlaylistRes myMusicLikeListSameDjPlaylistRes0) {
        MyMusicLikedPlaylistFragment.requestLikeSameDjPlaylist$lambda$8(myMusicLikedPlaylistFragment0, i0, myMusicLikeListSameDjPlaylistRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.S.buildUpon().appendPath("playlist").appendQueryParameter("sortType", String.valueOf(this.sortPos)).appendQueryParameter("filterType", this.toggleType), "targetMemberKey", this.memberKey, "toString(...)");
    }

    private final String getFilterTypeForServer(int v) {
        j j0 = (j)je.p.n0(v, this.toggleList);
        if(j0 != null) {
            return j0.c == null ? "" : j0.c;
        }
        return "";
    }

    private final int getStartIndex(i i0) {
        if(i0 == null) {
            return this.START_INDEX;
        }
        if(i0.equals(i.b)) {
            return this.START_INDEX;
        }
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedPlaylistFragment.LikedPlaylistAdapter");
        return ((LikedPlaylistAdapter)j00).getCount() + 1;
    }

    public static void h0(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, i i0, MyMusicLikeListSamePlaylistRes myMusicLikeListSamePlaylistRes0) {
        MyMusicLikedPlaylistFragment.requestLikeSamePlaylist$lambda$4(myMusicLikedPlaylistFragment0, i0, myMusicLikeListSamePlaylistRes0);
    }

    public static void i0(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, i i0, MyMusicLikeListArtistPlaylistRes myMusicLikeListArtistPlaylistRes0) {
        MyMusicLikedPlaylistFragment.requestLikeArtistPlaylist$lambda$10(myMusicLikedPlaylistFragment0, i0, myMusicLikeListArtistPlaylistRes0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.mymusic.OnCheckMyself
    public boolean isMyself() {
        return TextUtils.isEmpty(this.memberKey) || q.b(this.memberKey, u.v(((e0)o.a()).j()));
    }

    @NotNull
    public static final MyMusicLikedPlaylistFragment newInstance(@NotNull String s) {
        return MyMusicLikedPlaylistFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D056B, viewGroup0, false);  // layout:mymusic_more
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        if(i.b.equals(i0)) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedPlaylistFragment.LikedPlaylistAdapter");
            ((LikedPlaylistAdapter)j00).clear();
        }
        boolean z = q.b(this.toggleType, "LIKE_ME");
        int v = this.sortPos;
        if(v == this.SORT_NOMAL) {
            if(z) {
                this.requestLikeSamePlaylist(i0);
                return true;
            }
            this.requestLikePlaylist(i0);
            return true;
        }
        if(v == this.SORT_DJ) {
            if(z) {
                this.requestLikeSameDjPlaylist(i0);
                return true;
            }
            this.requestLikeDjPlaylist(i0);
            return true;
        }
        if(v == this.SORT_ARTIST) {
            if(z) {
                this.requestLikeSameArtistPlaylist(i0);
                return true;
            }
            this.requestLikeArtistPlaylist(i0);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argMemberKey");
        if(s == null) {
            s = "";
        }
        this.memberKey = s;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.setToggleData(this.sortPos);
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
    }

    private final void requestLikeArtistPlaylist(i i0) {
        Params likeListArtistPlaylistBaseReq$Params0 = new Params();
        likeListArtistPlaylistBaseReq$Params0.orderBy = this.toggleType;
        likeListArtistPlaylistBaseReq$Params0.startIndex = this.getStartIndex(i0);
        likeListArtistPlaylistBaseReq$Params0.pageSize = this.PAGE_SIZE;
        likeListArtistPlaylistBaseReq$Params0.targetMemberKey = this.isMyself() ? u.v(((e0)o.a()).j()) : this.memberKey;
        RequestBuilder.newInstance(new MyMusicLikeListArtistPlaylistReq(this.getContext(), likeListArtistPlaylistBaseReq$Params0)).tag("MyMusicLikedPlaylistFragment").listener(new D(this, i0, 3)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestLikeArtistPlaylist$lambda$10(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, i i0, MyMusicLikeListArtistPlaylistRes myMusicLikeListArtistPlaylistRes0) {
        if(!myMusicLikedPlaylistFragment0.prepareFetchComplete(myMusicLikeListArtistPlaylistRes0)) {
            return;
        }
        myMusicLikedPlaylistFragment0.performFetchComplete(i0, myMusicLikeListArtistPlaylistRes0);
    }

    private final void requestLikeDjPlaylist(i i0) {
        com.iloen.melon.net.v4x.request.LikeListDjPlaylistBaseReq.Params likeListDjPlaylistBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListDjPlaylistBaseReq.Params();
        likeListDjPlaylistBaseReq$Params0.orderBy = this.toggleType;
        likeListDjPlaylistBaseReq$Params0.startIndex = this.getStartIndex(i0);
        likeListDjPlaylistBaseReq$Params0.pageSize = this.PAGE_SIZE;
        likeListDjPlaylistBaseReq$Params0.targetMemberKey = this.isMyself() ? u.v(((e0)o.a()).j()) : this.memberKey;
        RequestBuilder.newInstance(new MyMusicLikeListDjPlaylistReq(this.getContext(), likeListDjPlaylistBaseReq$Params0)).tag("MyMusicLikedPlaylistFragment").listener(new D(this, i0, 1)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestLikeDjPlaylist$lambda$6(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, i i0, MyMusicLikeListDjPlaylistRes myMusicLikeListDjPlaylistRes0) {
        if(!myMusicLikedPlaylistFragment0.prepareFetchComplete(myMusicLikeListDjPlaylistRes0)) {
            return;
        }
        myMusicLikedPlaylistFragment0.performFetchComplete(i0, myMusicLikeListDjPlaylistRes0);
    }

    private final void requestLikePlaylist(i i0) {
        com.iloen.melon.net.v4x.request.LikeListPlaylistBaseReq.Params likeListPlaylistBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListPlaylistBaseReq.Params();
        likeListPlaylistBaseReq$Params0.orderBy = this.toggleType;
        likeListPlaylistBaseReq$Params0.startIndex = this.getStartIndex(i0);
        likeListPlaylistBaseReq$Params0.pageSize = this.PAGE_SIZE;
        likeListPlaylistBaseReq$Params0.targetMemberKey = this.isMyself() ? u.v(((e0)o.a()).j()) : this.memberKey;
        RequestBuilder.newInstance(new MyMusicLikeListPlaylistReq(this.getContext(), likeListPlaylistBaseReq$Params0)).tag("MyMusicLikedPlaylistFragment").listener(new D(this, i0, 5)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestLikePlaylist$lambda$2(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, i i0, MyMusicLikeListPlaylistRes myMusicLikeListPlaylistRes0) {
        if(!myMusicLikedPlaylistFragment0.prepareFetchComplete(myMusicLikeListPlaylistRes0)) {
            return;
        }
        myMusicLikedPlaylistFragment0.performFetchComplete(i0, myMusicLikeListPlaylistRes0);
    }

    private final void requestLikeSameArtistPlaylist(i i0) {
        com.iloen.melon.net.v4x.request.MyMusicLikeListSameArtistPlaylistReq.Params myMusicLikeListSameArtistPlaylistReq$Params0 = new com.iloen.melon.net.v4x.request.MyMusicLikeListSameArtistPlaylistReq.Params();
        myMusicLikeListSameArtistPlaylistReq$Params0.startIndex = this.getStartIndex(i0);
        myMusicLikeListSameArtistPlaylistReq$Params0.pageSize = this.PAGE_SIZE;
        myMusicLikeListSameArtistPlaylistReq$Params0.targetMemberKey = this.memberKey;
        RequestBuilder.newInstance(new MyMusicLikeListSameArtistPlaylistReq(this.getContext(), myMusicLikeListSameArtistPlaylistReq$Params0)).tag("MyMusicLikedPlaylistFragment").listener(new D(this, i0, 2)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestLikeSameArtistPlaylist$lambda$12(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, i i0, MyMusicLikeListSameArtistPlaylistRes myMusicLikeListSameArtistPlaylistRes0) {
        if(!myMusicLikedPlaylistFragment0.prepareFetchComplete(myMusicLikeListSameArtistPlaylistRes0)) {
            return;
        }
        myMusicLikedPlaylistFragment0.performFetchComplete(i0, myMusicLikeListSameArtistPlaylistRes0);
    }

    private final void requestLikeSameDjPlaylist(i i0) {
        com.iloen.melon.net.v4x.request.MyMusicLikeListSameDjPlaylistReq.Params myMusicLikeListSameDjPlaylistReq$Params0 = new com.iloen.melon.net.v4x.request.MyMusicLikeListSameDjPlaylistReq.Params();
        myMusicLikeListSameDjPlaylistReq$Params0.startIndex = this.getStartIndex(i0);
        myMusicLikeListSameDjPlaylistReq$Params0.pageSize = this.PAGE_SIZE;
        myMusicLikeListSameDjPlaylistReq$Params0.targetMemberKey = this.memberKey;
        RequestBuilder.newInstance(new MyMusicLikeListSameDjPlaylistReq(this.getContext(), myMusicLikeListSameDjPlaylistReq$Params0)).tag("MyMusicLikedPlaylistFragment").listener(new D(this, i0, 0)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestLikeSameDjPlaylist$lambda$8(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, i i0, MyMusicLikeListSameDjPlaylistRes myMusicLikeListSameDjPlaylistRes0) {
        if(!myMusicLikedPlaylistFragment0.prepareFetchComplete(myMusicLikeListSameDjPlaylistRes0)) {
            return;
        }
        myMusicLikedPlaylistFragment0.performFetchComplete(i0, myMusicLikeListSameDjPlaylistRes0);
    }

    private final void requestLikeSamePlaylist(i i0) {
        com.iloen.melon.net.v4x.request.MyMusicLikeListSamePlaylistReq.Params myMusicLikeListSamePlaylistReq$Params0 = new com.iloen.melon.net.v4x.request.MyMusicLikeListSamePlaylistReq.Params();
        myMusicLikeListSamePlaylistReq$Params0.startIndex = this.getStartIndex(i0);
        myMusicLikeListSamePlaylistReq$Params0.pageSize = this.PAGE_SIZE;
        myMusicLikeListSamePlaylistReq$Params0.targetMemberKey = this.memberKey;
        RequestBuilder.newInstance(new MyMusicLikeListSamePlaylistReq(this.getContext(), myMusicLikeListSamePlaylistReq$Params0)).tag("MyMusicLikedPlaylistFragment").listener(new D(this, i0, 4)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestLikeSamePlaylist$lambda$4(MyMusicLikedPlaylistFragment myMusicLikedPlaylistFragment0, i i0, MyMusicLikeListSamePlaylistRes myMusicLikeListSamePlaylistRes0) {
        if(!myMusicLikedPlaylistFragment0.prepareFetchComplete(myMusicLikeListSamePlaylistRes0)) {
            return;
        }
        myMusicLikedPlaylistFragment0.performFetchComplete(i0, myMusicLikeListSamePlaylistRes0);
    }

    private final void setToggleData(int v) {
        if(!this.toggleList.isEmpty()) {
            this.toggleList.clear();
        }
        j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.c = "NEW";
        this.toggleList.add(j0);
        if(this.isMyself()) {
            j j1 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j1.c = v == 0 || v == 1 ? "MAKER" : "ARTIST";
            this.toggleList.add(j1);
            return;
        }
        j j2 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j2.c = "LIKE_ME";
        this.toggleList.add(j2);
    }
}

