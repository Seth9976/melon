package com.iloen.melon.fragments.mymusic;

import B9.s;
import B9.u;
import B9.v;
import E8.c;
import H0.e;
import P4.a;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.request.LikeListArtistPlaylistBaseReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicLikeListArtistPlaylistReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeListDjPlaylistReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeListPlaylistReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeListArtistPlaylistRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicLikeListArtistPlaylistRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListDjPlaylistRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListPlaylistRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.DjPlayListInfoBase;
import d3.g;
import ie.j;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 H2\u00020\u0001:\u0002HIB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ-\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001D\u001A\u00020\u001C2\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u001B\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010 \u001A\u00020\u001FH\u0014\u00A2\u0006\u0004\b \u0010!J\u001B\u0010%\u001A\u0006\u0012\u0002\b\u00030$2\u0006\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b%\u0010&J\u0019\u0010\'\u001A\u00020\t2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0002\u00A2\u0006\u0004\b\'\u0010(J\u0019\u0010)\u001A\u00020\t2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0002\u00A2\u0006\u0004\b)\u0010(J\u0019\u0010*\u001A\u00020\t2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0002\u00A2\u0006\u0004\b*\u0010(J\u0019\u0010,\u001A\u00020+2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0002\u00A2\u0006\u0004\b,\u0010-J\u0017\u0010/\u001A\u00020\t2\u0006\u0010.\u001A\u00020+H\u0002\u00A2\u0006\u0004\b/\u00100J\'\u00106\u001A\u00020\t2\u0006\u00102\u001A\u0002012\u0006\u00103\u001A\u00020+2\u0006\u00105\u001A\u000204H\u0002\u00A2\u0006\u0004\b6\u00107J\'\u00108\u001A\u00020\t2\u0006\u00102\u001A\u0002012\u0006\u00103\u001A\u00020+2\u0006\u00105\u001A\u000204H\u0002\u00A2\u0006\u0004\b8\u00107R\u0016\u00109\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b;\u0010<R!\u0010C\u001A\b\u0012\u0004\u0012\u00020>0=8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b?\u0010@\u001A\u0004\bA\u0010BR\u0014\u0010G\u001A\u00020D8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bE\u0010F\u00A8\u0006J"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedPlaylistFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "requestLikePlaylist", "(Lv9/i;)V", "requestLikeDjPlaylist", "requestLikeArtistPlaylist", "", "getStartIndex", "(Lv9/i;)I", "alyacPosition", "tiaraLogClickAlyacView", "(I)V", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "data", "position", "Lcom/iloen/melon/net/v4x/common/ContsTypeCode;", "contsTypeCode", "tiaraLogOpenPlaylistDetail", "(Lcom/melon/net/res/common/DjPlayListInfoBase;ILcom/iloen/melon/net/v4x/common/ContsTypeCode;)V", "tiaraLogPlayPlaylist", "memberKey", "Ljava/lang/String;", "sortPos", "I", "", "Lv9/j;", "sortings$delegate", "Lie/j;", "getSortings", "()Ljava/util/List;", "sortings", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "LikedPlaylistAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class OtherMusicLikedPlaylistFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedPlaylistFragment$Companion;", "", "<init>", "()V", "TAG", "", "SORT_DJ", "", "SORT_NORMAL", "SORT_ARTIST", "START_INDEX", "PAGE_SIZE", "TOGGLE_TYPE", "newInstance", "Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedPlaylistFragment;", "targetMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final OtherMusicLikedPlaylistFragment newInstance(@NotNull String s) {
            q.g(s, "targetMemberKey");
            OtherMusicLikedPlaylistFragment otherMusicLikedPlaylistFragment0 = new OtherMusicLikedPlaylistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            otherMusicLikedPlaylistFragment0.setArguments(bundle0);
            return otherMusicLikedPlaylistFragment0;
        }
    }

    @Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0003\u001E!$\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0015\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0019\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u00032\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001D\u0010\u001CR\u0014\u0010\u001F\u001A\u00020\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010\"\u001A\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001A\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006\'"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedPlaylistFragment$LikedPlaylistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v4x/common/ArtistPlayListInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedPlaylistFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "getHeaderViewItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER", "I", "VIEW_TYPE_PLAYLIST", "com/iloen/melon/fragments/mymusic/OtherMusicLikedPlaylistFragment$LikedPlaylistAdapter$djPlaylistClickListener$1", "djPlaylistClickListener", "Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedPlaylistFragment$LikedPlaylistAdapter$djPlaylistClickListener$1;", "com/iloen/melon/fragments/mymusic/OtherMusicLikedPlaylistFragment$LikedPlaylistAdapter$playlistClickListener$1", "playlistClickListener", "Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedPlaylistFragment$LikedPlaylistAdapter$playlistClickListener$1;", "com/iloen/melon/fragments/mymusic/OtherMusicLikedPlaylistFragment$LikedPlaylistAdapter$artistPlaylistClickListener$1", "artistPlaylistClickListener", "Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedPlaylistFragment$LikedPlaylistAdapter$artistPlaylistClickListener$1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LikedPlaylistAdapter extends p {
        private final int VIEW_TYPE_HEADER;
        private final int VIEW_TYPE_PLAYLIST;
        @NotNull
        private final com.iloen.melon.fragments.mymusic.OtherMusicLikedPlaylistFragment.LikedPlaylistAdapter.artistPlaylistClickListener.1 artistPlaylistClickListener;
        @NotNull
        private final com.iloen.melon.fragments.mymusic.OtherMusicLikedPlaylistFragment.LikedPlaylistAdapter.djPlaylistClickListener.1 djPlaylistClickListener;
        @NotNull
        private final com.iloen.melon.fragments.mymusic.OtherMusicLikedPlaylistFragment.LikedPlaylistAdapter.playlistClickListener.1 playlistClickListener;

        public LikedPlaylistAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            OtherMusicLikedPlaylistFragment.this = otherMusicLikedPlaylistFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_HEADER = 1;
            this.VIEW_TYPE_PLAYLIST = 2;
            this.djPlaylistClickListener = new s() {
                private final ContsTypeCode contsTypeCode;

                {
                    OtherMusicLikedPlaylistFragment otherMusicLikedPlaylistFragment0 = this;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.contsTypeCode = ContsTypeCode.DJ_PLAYLIST;
                }

                @Override  // B9.s
                public void clickBody(ArtistPlayListInfoBase artistPlayListInfoBase0, int v) {
                    if(artistPlayListInfoBase0 != null) {
                        Navigator.openDjPlaylistDetail(artistPlayListInfoBase0.plylstseq);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        this.tiaraLogOpenPlaylistDetail(artistPlayListInfoBase0, v, this.contsTypeCode);
                    }
                }

                @Override  // B9.s
                public void clickThumbnail(ArtistPlayListInfoBase artistPlayListInfoBase0, int v) {
                    if(artistPlayListInfoBase0 != null) {
                        Navigator.openDjPlaylistDetail(artistPlayListInfoBase0.plylstseq);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        this.tiaraLogOpenPlaylistDetail(artistPlayListInfoBase0, v, this.contsTypeCode);
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
                        String s2 = LikedPlaylistAdapter.this.getMenuId();
                        this.playPlaylist(s, s1, s2, artistPlayListInfoBase0.statsElements);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        this.tiaraLogPlayPlaylist(artistPlayListInfoBase0, v, this.contsTypeCode);
                    }
                }
            };
            this.playlistClickListener = new s() {
                private final ContsTypeCode contsTypeCode;

                {
                    OtherMusicLikedPlaylistFragment otherMusicLikedPlaylistFragment0 = this;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.contsTypeCode = ContsTypeCode.PLAYLIST;
                }

                @Override  // B9.s
                public void clickBody(ArtistPlayListInfoBase artistPlayListInfoBase0, int v) {
                    if(artistPlayListInfoBase0 != null) {
                        Navigator.INSTANCE.openPlaylistDetail(artistPlayListInfoBase0.plylstseq);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        this.tiaraLogOpenPlaylistDetail(artistPlayListInfoBase0, v, this.contsTypeCode);
                    }
                }

                @Override  // B9.s
                public void clickThumbnail(ArtistPlayListInfoBase artistPlayListInfoBase0, int v) {
                    if(artistPlayListInfoBase0 != null) {
                        Navigator.INSTANCE.openPlaylistDetail(artistPlayListInfoBase0.plylstseq);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        this.tiaraLogOpenPlaylistDetail(artistPlayListInfoBase0, v, this.contsTypeCode);
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
                        String s2 = LikedPlaylistAdapter.this.getMenuId();
                        this.playPlaylist(s, s1, s2, artistPlayListInfoBase0.statsElements);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        this.tiaraLogPlayPlaylist(artistPlayListInfoBase0, v, this.contsTypeCode);
                    }
                }
            };
            this.artistPlaylistClickListener = new s() {
                private final ContsTypeCode contsTypeCode;

                {
                    OtherMusicLikedPlaylistFragment otherMusicLikedPlaylistFragment0 = this;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.contsTypeCode = ContsTypeCode.ARTIST_PLAYLIST;
                }

                @Override  // B9.s
                public void clickBody(ArtistPlayListInfoBase artistPlayListInfoBase0, int v) {
                    if(artistPlayListInfoBase0 != null) {
                        Navigator.INSTANCE.openArtistPlaylistDetail(artistPlayListInfoBase0.plylstseq);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        this.tiaraLogOpenPlaylistDetail(artistPlayListInfoBase0, v, this.contsTypeCode);
                    }
                }

                @Override  // B9.s
                public void clickThumbnail(ArtistPlayListInfoBase artistPlayListInfoBase0, int v) {
                    if(artistPlayListInfoBase0 != null) {
                        Navigator.INSTANCE.openArtistPlaylistDetail(artistPlayListInfoBase0.plylstseq);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        this.tiaraLogOpenPlaylistDetail(artistPlayListInfoBase0, v, this.contsTypeCode);
                    }
                }

                @Override  // B9.s
                public boolean longClickBody(ArtistPlayListInfoBase artistPlayListInfoBase0, int v) {
                    if(artistPlayListInfoBase0 != null) {
                        String s = LikedPlaylistAdapter.this.getMenuId();
                        this.showContextPopupArtistPlaylist(artistPlayListInfoBase0, s);
                        return true;
                    }
                    return false;
                }

                @Override  // B9.s
                public void playPlaylist(ArtistPlayListInfoBase artistPlayListInfoBase0, int v) {
                    if(artistPlayListInfoBase0 != null) {
                        String s = artistPlayListInfoBase0.plylstseq;
                        String s1 = artistPlayListInfoBase0.contsTypeCode;
                        String s2 = LikedPlaylistAdapter.this.getMenuId();
                        this.playPlaylist(s, s1, s2, artistPlayListInfoBase0.statsElements);
                        q.f(this.contsTypeCode, "contsTypeCode");
                        this.tiaraLogPlayPlaylist(artistPlayListInfoBase0, v, this.contsTypeCode);
                    }
                }
            };
        }

        public static void a(OtherMusicLikedPlaylistFragment otherMusicLikedPlaylistFragment0, int v) {
            LikedPlaylistAdapter.onBindViewImpl$lambda$2$lambda$1$lambda$0(otherMusicLikedPlaylistFragment0, v);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? this.VIEW_TYPE_HEADER : this.VIEW_TYPE_PLAYLIST;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            com.iloen.melon.fragments.mymusic.OtherMusicLikedPlaylistFragment.LikedPlaylistAdapter.djPlaylistClickListener.1 otherMusicLikedPlaylistFragment$LikedPlaylistAdapter$djPlaylistClickListener$10;
            if(o00 instanceof v) {
                ArrayList arrayList0 = new ArrayList(OtherMusicLikedPlaylistFragment.this.getSortings());
                ((v)o00).a.a(arrayList0);
                ((v)o00).a.setSelectedIndex(OtherMusicLikedPlaylistFragment.this.sortPos);
                B b0 = new B(OtherMusicLikedPlaylistFragment.this, 5);
                c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
                ((v)o00).a.e(b0, c0);
                return;
            }
            if(o00 instanceof u) {
                ArtistPlayListInfoBase artistPlayListInfoBase0 = (ArtistPlayListInfoBase)this.getItem(v1);
                switch(OtherMusicLikedPlaylistFragment.this.sortPos) {
                    case 0: {
                        otherMusicLikedPlaylistFragment$LikedPlaylistAdapter$djPlaylistClickListener$10 = this.djPlaylistClickListener;
                        break;
                    }
                    case 2: {
                        otherMusicLikedPlaylistFragment$LikedPlaylistAdapter$djPlaylistClickListener$10 = this.artistPlaylistClickListener;
                        break;
                    }
                    default: {
                        otherMusicLikedPlaylistFragment$LikedPlaylistAdapter$djPlaylistClickListener$10 = this.playlistClickListener;
                    }
                }
                ((u)o00).b(artistPlayListInfoBase0, v1, otherMusicLikedPlaylistFragment$LikedPlaylistAdapter$djPlaylistClickListener$10);
            }
        }

        private static final void onBindViewImpl$lambda$2$lambda$1$lambda$0(OtherMusicLikedPlaylistFragment otherMusicLikedPlaylistFragment0, int v) {
            if(otherMusicLikedPlaylistFragment0.sortPos == v) {
                return;
            }
            otherMusicLikedPlaylistFragment0.sortPos = v;
            otherMusicLikedPlaylistFragment0.startFetch("alyac change");
            otherMusicLikedPlaylistFragment0.tiaraLogClickAlyacView(v);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return v == this.VIEW_TYPE_HEADER ? a.w(viewGroup0) : e.P(viewGroup0, B9.q.d);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int PAGE_SIZE = 100;
    private static final int SORT_ARTIST = 2;
    private static final int SORT_DJ = 0;
    private static final int SORT_NORMAL = 1;
    private static final int START_INDEX = 1;
    @NotNull
    private static final String TAG = "MyMusicLikedPlaylistFragment";
    @NotNull
    private static final String TOGGLE_TYPE = "NEW";
    @NotNull
    private String memberKey;
    private int sortPos;
    @NotNull
    private final j sortings$delegate;

    static {
        OtherMusicLikedPlaylistFragment.Companion = new Companion(null);
        OtherMusicLikedPlaylistFragment.$stable = 8;
    }

    public OtherMusicLikedPlaylistFragment() {
        this.memberKey = "";
        this.sortings$delegate = g.Q(new k(this, 4));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new LikedPlaylistAdapter(this, context0, null);
        ((com.iloen.melon.adapters.common.j)j00).setListContentType(4);
        return j00;
    }

    private final f getBaseTiaraLogEventBuilder() {
        f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
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
        return l1.f(MelonContentUris.S.buildUpon().appendPath("playlist").appendQueryParameter("sortType", String.valueOf(this.sortPos)), "targetMemberKey", this.memberKey, "toString(...)");
    }

    private final List getSortings() {
        return (List)this.sortings$delegate.getValue();
    }

    private final int getStartIndex(i i0) {
        if(i0 == null) {
            return 1;
        }
        if(i0.equals(i.b)) {
            return 1;
        }
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.OtherMusicLikedPlaylistFragment.LikedPlaylistAdapter");
        return ((LikedPlaylistAdapter)j00).getCount() + 1;
    }

    @NotNull
    public static final OtherMusicLikedPlaylistFragment newInstance(@NotNull String s) {
        return OtherMusicLikedPlaylistFragment.Companion.newInstance(s);
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
            LikedPlaylistAdapter otherMusicLikedPlaylistFragment$LikedPlaylistAdapter0 = this.mAdapter instanceof LikedPlaylistAdapter ? ((LikedPlaylistAdapter)this.mAdapter) : null;
            if(otherMusicLikedPlaylistFragment$LikedPlaylistAdapter0 != null) {
                otherMusicLikedPlaylistFragment$LikedPlaylistAdapter0.clear();
            }
        }
        int v = this.sortPos;
        switch(v) {
            case 0: {
                this.requestLikeDjPlaylist(i0);
                return true;
            }
            case 1: {
                this.requestLikePlaylist(i0);
                return true;
            }
            default: {
                if(v != 2) {
                    return false;
                }
                this.requestLikeArtistPlaylist(i0);
                return true;
            }
        }
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
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
    }

    private final void requestLikeArtistPlaylist(i i0) {
        Params likeListArtistPlaylistBaseReq$Params0 = new Params();
        likeListArtistPlaylistBaseReq$Params0.orderBy = "NEW";
        likeListArtistPlaylistBaseReq$Params0.startIndex = this.getStartIndex(i0);
        likeListArtistPlaylistBaseReq$Params0.pageSize = 100;
        likeListArtistPlaylistBaseReq$Params0.targetMemberKey = this.memberKey;
        RequestBuilder.newInstance(new MyMusicLikeListArtistPlaylistReq(this.getContext(), likeListArtistPlaylistBaseReq$Params0)).tag(this.getRequestTag()).listener(new Z(this, i0, 0)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestLikeArtistPlaylist$lambda$8(OtherMusicLikedPlaylistFragment otherMusicLikedPlaylistFragment0, i i0, MyMusicLikeListArtistPlaylistRes myMusicLikeListArtistPlaylistRes0) {
        if(!otherMusicLikedPlaylistFragment0.prepareFetchComplete(myMusicLikeListArtistPlaylistRes0)) {
            return;
        }
        RESPONSE myMusicLikeListArtistPlaylistRes$RESPONSE0 = myMusicLikeListArtistPlaylistRes0 == null ? null : myMusicLikeListArtistPlaylistRes0.response;
        if(myMusicLikeListArtistPlaylistRes$RESPONSE0 != null) {
            otherMusicLikedPlaylistFragment0.mMelonTiaraProperty = new p8.s(myMusicLikeListArtistPlaylistRes$RESPONSE0.section, myMusicLikeListArtistPlaylistRes$RESPONSE0.page, myMusicLikeListArtistPlaylistRes$RESPONSE0.menuId, null);
        }
        otherMusicLikedPlaylistFragment0.performFetchComplete(i0, myMusicLikeListArtistPlaylistRes0);
    }

    private final void requestLikeDjPlaylist(i i0) {
        com.iloen.melon.net.v4x.request.LikeListDjPlaylistBaseReq.Params likeListDjPlaylistBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListDjPlaylistBaseReq.Params();
        likeListDjPlaylistBaseReq$Params0.orderBy = "NEW";
        likeListDjPlaylistBaseReq$Params0.startIndex = this.getStartIndex(i0);
        likeListDjPlaylistBaseReq$Params0.pageSize = 100;
        likeListDjPlaylistBaseReq$Params0.targetMemberKey = this.memberKey;
        RequestBuilder.newInstance(new MyMusicLikeListDjPlaylistReq(this.getContext(), likeListDjPlaylistBaseReq$Params0)).tag(this.getRequestTag()).listener(new Z(this, i0, 1)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestLikeDjPlaylist$lambda$6(OtherMusicLikedPlaylistFragment otherMusicLikedPlaylistFragment0, i i0, MyMusicLikeListDjPlaylistRes myMusicLikeListDjPlaylistRes0) {
        if(!otherMusicLikedPlaylistFragment0.prepareFetchComplete(myMusicLikeListDjPlaylistRes0)) {
            return;
        }
        com.iloen.melon.net.v4x.response.MyMusicLikeListDjPlaylistRes.RESPONSE myMusicLikeListDjPlaylistRes$RESPONSE0 = myMusicLikeListDjPlaylistRes0 == null ? null : myMusicLikeListDjPlaylistRes0.response;
        if(myMusicLikeListDjPlaylistRes$RESPONSE0 != null) {
            otherMusicLikedPlaylistFragment0.mMelonTiaraProperty = new p8.s(myMusicLikeListDjPlaylistRes$RESPONSE0.section, myMusicLikeListDjPlaylistRes$RESPONSE0.page, myMusicLikeListDjPlaylistRes$RESPONSE0.menuId, null);
        }
        otherMusicLikedPlaylistFragment0.performFetchComplete(i0, myMusicLikeListDjPlaylistRes0);
    }

    private final void requestLikePlaylist(i i0) {
        com.iloen.melon.net.v4x.request.LikeListPlaylistBaseReq.Params likeListPlaylistBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListPlaylistBaseReq.Params();
        likeListPlaylistBaseReq$Params0.orderBy = "NEW";
        likeListPlaylistBaseReq$Params0.startIndex = this.getStartIndex(i0);
        likeListPlaylistBaseReq$Params0.pageSize = 100;
        likeListPlaylistBaseReq$Params0.targetMemberKey = this.memberKey;
        RequestBuilder.newInstance(new MyMusicLikeListPlaylistReq(this.getContext(), likeListPlaylistBaseReq$Params0)).tag(this.getRequestTag()).listener(new Z(this, i0, 2)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestLikePlaylist$lambda$4(OtherMusicLikedPlaylistFragment otherMusicLikedPlaylistFragment0, i i0, MyMusicLikeListPlaylistRes myMusicLikeListPlaylistRes0) {
        if(!otherMusicLikedPlaylistFragment0.prepareFetchComplete(myMusicLikeListPlaylistRes0)) {
            return;
        }
        com.iloen.melon.net.v4x.response.MyMusicLikeListPlaylistRes.RESPONSE myMusicLikeListPlaylistRes$RESPONSE0 = myMusicLikeListPlaylistRes0 == null ? null : myMusicLikeListPlaylistRes0.response;
        if(myMusicLikeListPlaylistRes$RESPONSE0 != null) {
            otherMusicLikedPlaylistFragment0.mMelonTiaraProperty = new p8.s(myMusicLikeListPlaylistRes$RESPONSE0.section, myMusicLikeListPlaylistRes$RESPONSE0.page, myMusicLikeListPlaylistRes$RESPONSE0.menuId, null);
        }
        otherMusicLikedPlaylistFragment0.performFetchComplete(i0, myMusicLikeListPlaylistRes0);
    }

    private static final List sortings_delegate$lambda$2(OtherMusicLikedPlaylistFragment otherMusicLikedPlaylistFragment0) {
        String[] arr_s;
        Context context0 = otherMusicLikedPlaylistFragment0.getContext();
        if(context0 == null) {
            arr_s = new String[0];
        }
        else {
            Resources resources0 = context0.getResources();
            if(resources0 == null) {
                arr_s = new String[0];
            }
            else {
                arr_s = resources0.getStringArray(0x7F030022);  // array:other_music_playlist_like_sort_type
                if(arr_s == null) {
                    arr_s = new String[0];
                }
            }
        }
        List list0 = new ArrayList(arr_s.length);
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.b = s;
            list0.add(j0);
        }
        return list0;
    }

    private final void tiaraLogClickAlyacView(int v) {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.y = this.getString(0x7F130EB8);  // string:tiara_gnb_layer1_gnb "GNB"
        v9.j j0 = (v9.j)je.p.n0(v, this.getSortings());
        f0.F = j0 == null ? null : j0.b;
        f0.a().track();
    }

    private final void tiaraLogOpenPlaylistDetail(DjPlayListInfoBase djPlayListInfoBase0, int v, ContsTypeCode contsTypeCode0) {
        f f0 = this.getBaseTiaraLogEventBuilder();
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
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        f0.d = ActionKind.PlayMusic;
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.C = String.valueOf(v + 1);
        f0.e = djPlayListInfoBase0.plylstseq;
        f0.f = Y.i(contsTypeCode0, "code(...)");
        f0.g = djPlayListInfoBase0.plylsttitle;
        f0.a().track();
    }
}

