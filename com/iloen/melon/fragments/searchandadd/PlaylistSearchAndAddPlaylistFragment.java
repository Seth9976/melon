package com.iloen.melon.fragments.searchandadd;

import S2.c;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.w0;
import b3.Z;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq.Params;
import com.iloen.melon.net.v5x.response.MelonDjPlaylistListSongRes.RESPONSE;
import com.iloen.melon.net.v5x.response.MelonDjPlaylistListSongRes;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistListV6Req;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListV6Res.RESPONSE.PLAYLISTLIST;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListV6Res;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.net.res.common.SongInfoBase;
import e1.u;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.q;
import o9.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 <2\u00020\u0001:\u0004<=>?B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ-\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\'\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u0005\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u001B\u0010#\u001A\u0006\u0012\u0002\b\u00030\"2\u0006\u0010!\u001A\u00020 H\u0014\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b\'\u0010(R\u0016\u0010)\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001A\u00020+8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001A\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u00100R\u001C\u00102\u001A\b\u0018\u000101R\u00020\u00008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001A\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00105R\u001B\u0010;\u001A\u0002068BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b7\u00108\u001A\u0004\b9\u0010:\u00A8\u0006@"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment;", "Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseFragment;", "<init>", "()V", "", "type", "Lie/H;", "changeRecyclerView", "(I)V", "", "plylstSeq", "fetchPlaylistSongs", "(Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "getCacheKey", "()Ljava/lang/String;", "onBackPressed", "()Z", "recyclerViewType", "I", "Landroidx/recyclerview/widget/RecyclerView;", "songRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/utils/playlist/PlaylistDetailFactoryBase;", "playlistFactory", "Lcom/iloen/melon/utils/playlist/PlaylistDetailFactoryBase;", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter;", "songListAdapter", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter;", "selectedPlaylistName", "Ljava/lang/String;", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "playlistSearchViewModel$delegate", "Lie/j;", "getPlaylistSearchViewModel", "()Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "playlistSearchViewModel", "Companion", "PlaylistAdapter", "PlaylistHolder", "SongListAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistSearchAndAddPlaylistFragment extends SearchAndAddBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001A\u00020\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment;", "RECYCLER_VIEW_TYPE_PLAYLIST", "", "RECYCLER_VIEW_TYPE_SONGLIST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistSearchAndAddPlaylistFragment newInstance() {
            return new PlaylistSearchAndAddPlaylistFragment();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\u000B\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u00032\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$PlaylistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/MyMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "mContext", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment;Landroid/content/Context;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "vh", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Landroid/content/Context;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class PlaylistAdapter extends p {
        @NotNull
        private final Context mContext;

        public PlaylistAdapter(@NotNull Context context0) {
            q.g(context0, "mContext");
            PlaylistSearchAndAddPlaylistFragment.this = playlistSearchAndAddPlaylistFragment0;
            super(context0, null);
            this.mContext = context0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof PlaylistHolder) {
                ViewUtils.showWhen(((PlaylistHolder)o00).getFirstItemTopMargin(), v1 == 0);
                PLAYLISTLIST myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0 = (PLAYLISTLIST)this.getItem(v1);
                if(myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0 != null) {
                    f f0 = new f(0, PlaylistSearchAndAddPlaylistFragment.this, myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0);
                    ViewUtils.setOnClickListener(((PlaylistHolder)o00).itemView, f0);
                    Glide.with(((PlaylistHolder)o00).getIvThumb()).load(myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0.thumbimg).into(((PlaylistHolder)o00).getIvThumb());
                    ((PlaylistHolder)o00).getTvText().requestLayout();
                    ((PlaylistHolder)o00).getTvText().setText(myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0.plylsttitle);
                    TextView textView0 = ((PlaylistHolder)o00).getTvSongCnt();
                    String s = PlaylistSearchAndAddPlaylistFragment.this.getString(0x7F130655);  // string:melondj_playlist_song_count "%s곡"
                    q.f(s, "getString(...)");
                    Z.y(new Object[]{StringUtils.getCountString(myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0.songcnt, -1)}, 1, s, textView0);
                    if("Y".equals(myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0.openyn)) {
                        ((PlaylistHolder)o00).getTvText().setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    else {
                        ((PlaylistHolder)o00).getTvText().setCompoundDrawablesWithIntrinsicBounds(0x7F0805BC, 0, 0, 0);  // drawable:ic_private_16
                    }
                    if(v1 == this.getItemCount()) {
                        ((PlaylistHolder)o00).getVBottomLine().setVisibility(8);
                    }
                }
            }
        }

        private static final void onBindViewImpl$lambda$1$lambda$0(PlaylistSearchAndAddPlaylistFragment playlistSearchAndAddPlaylistFragment0, PLAYLISTLIST myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0, View view0) {
            playlistSearchAndAddPlaylistFragment0.selectedPlaylistName = myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0.plylsttitle;
            playlistSearchAndAddPlaylistFragment0.changeRecyclerView(1);
            playlistSearchAndAddPlaylistFragment0.fetchPlaylistSongs((myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0.plylstseq == null ? "" : myMusicPlaylistListV6Res$RESPONSE$PLAYLISTLIST0.plylstseq));
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04A5, viewGroup0, false);  // layout:listitem_search_and_add_playlist
            q.f(view0, "inflate(...)");
            return new PlaylistHolder(PlaylistSearchAndAddPlaylistFragment.this, view0);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\u0007\u001A\n \u0006*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u001F\u0010\f\u001A\n \u0006*\u0004\u0018\u00010\u000B0\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR*\u0010\u0011\u001A\n \u0006*\u0004\u0018\u00010\u00100\u00108\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001A\n \u0006*\u0004\u0018\u00010\u00100\u00108\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001A\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R*\u0010\u001A\u001A\n \u0006*\u0004\u0018\u00010\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001A\u0010\b\u001A\u0004\b\u001B\u0010\n\"\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$PlaylistHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment;Landroid/view/View;)V", "kotlin.jvm.PlatformType", "firstItemTopMargin", "Landroid/view/View;", "getFirstItemTopMargin", "()Landroid/view/View;", "Landroid/widget/ImageView;", "ivThumb", "Landroid/widget/ImageView;", "getIvThumb", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "tvText", "Landroid/widget/TextView;", "getTvText", "()Landroid/widget/TextView;", "setTvText", "(Landroid/widget/TextView;)V", "tvSongCnt", "getTvSongCnt", "setTvSongCnt", "vBottomLine", "getVBottomLine", "setVBottomLine", "(Landroid/view/View;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class PlaylistHolder extends O0 {
        private final View firstItemTopMargin;
        private final ImageView ivThumb;
        private TextView tvSongCnt;
        private TextView tvText;
        private View vBottomLine;

        public PlaylistHolder(@NotNull View view0) {
            q.g(view0, "view");
            PlaylistSearchAndAddPlaylistFragment.this = playlistSearchAndAddPlaylistFragment0;
            super(view0);
            this.firstItemTopMargin = view0.findViewById(0x7F0A04AD);  // id:first_item_top_margin
            this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
            this.tvText = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
            this.tvSongCnt = (TextView)view0.findViewById(0x7F0A0C50);  // id:tv_count
            this.vBottomLine = view0.findViewById(0x7F0A0D6B);  // id:underline
            view0.findViewById(0x7F0A0182).setVisibility(8);  // id:btn_play
        }

        public final View getFirstItemTopMargin() {
            return this.firstItemTopMargin;
        }

        public final ImageView getIvThumb() {
            return this.ivThumb;
        }

        public final TextView getTvSongCnt() {
            return this.tvSongCnt;
        }

        public final TextView getTvText() {
            return this.tvText;
        }

        public final View getVBottomLine() {
            return this.vBottomLine;
        }

        public final void setTvSongCnt(TextView textView0) {
            this.tvSongCnt = textView0;
        }

        public final void setTvText(TextView textView0) {
            this.tvText = textView0;
        }

        public final void setVBottomLine(View view0) {
            this.vBottomLine = view0;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\r\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005-./01B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J1\u0010\n\u001A\u00020\t2\"\u0010\b\u001A\u001E\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u0007\u00A2\u0006\u0004\b\n\u0010\u000BJ\r\u0010\f\u001A\u00020\t\u00A2\u0006\u0004\b\f\u0010\rJ\r\u0010\u000E\u001A\u00020\t\u00A2\u0006\u0004\b\u000E\u0010\rJ\u0017\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u001F\u0010\u0019\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CR*\u0010\u001D\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u000F8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u000F8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001A\u00020\u000F8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010#\u001A\u00020\u000F8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b#\u0010 R\u0014\u0010$\u001A\u00020\u000F8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010&\u001A\u00020%8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b&\u0010\'R\"\u0010(\u001A\u00020%8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b(\u0010\'\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,\u00A8\u00062"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter;", "Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/O0;", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment;)V", "Ljava/util/ArrayList;", "Lcom/melon/net/res/common/SongInfoBase;", "Lkotlin/collections/ArrayList;", "newSongList", "Lie/H;", "setSongList", "(Ljava/util/ArrayList;)V", "clearSongList", "()V", "setNetworkError", "", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "vh", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;I)V", "getItemCount", "()I", "songList", "Ljava/util/ArrayList;", "VIEW_TYPE_HEADER_TITLE", "I", "VIEW_TYPE_SONG_SELECTION", "VIEW_TYPE_SONG", "VIEW_TYPE_EMPTY_LIST", "VIEW_TYPE_NETWORK_ERROR", "", "isNetworkError", "Z", "fetchCompleted", "getFetchCompleted", "()Z", "setFetchCompleted", "(Z)V", "SearchSongHolder", "SectionTitleHolder", "SongSelectionHolder", "SongEmptyListHolder", "NetworkErrorHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class SongListAdapter extends j0 {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\"\u0010\f\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001A\u0004\b\r\u0010\t\"\u0004\b\u000E\u0010\u000BR\"\u0010\u0010\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter$NetworkErrorHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter;Landroid/view/View;)V", "networkErrorLayout", "Landroid/view/View;", "getNetworkErrorLayout", "()Landroid/view/View;", "setNetworkErrorLayout", "(Landroid/view/View;)V", "networkErrorRetryButton", "getNetworkErrorRetryButton", "setNetworkErrorRetryButton", "Landroid/widget/TextView;", "networkErrorConfirmButton", "Landroid/widget/TextView;", "getNetworkErrorConfirmButton", "()Landroid/widget/TextView;", "setNetworkErrorConfirmButton", "(Landroid/widget/TextView;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class NetworkErrorHolder extends O0 {
            @NotNull
            private TextView networkErrorConfirmButton;
            @NotNull
            private View networkErrorLayout;
            @NotNull
            private View networkErrorRetryButton;

            public NetworkErrorHolder(@NotNull View view0) {
                q.g(view0, "view");
                SongListAdapter.this = playlistSearchAndAddPlaylistFragment$SongListAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A08A5);  // id:network_error_layout
                q.f(view1, "findViewById(...)");
                this.networkErrorLayout = view1;
                View view2 = view0.findViewById(0x7F0A08A6);  // id:network_error_retry_button
                q.f(view2, "findViewById(...)");
                this.networkErrorRetryButton = view2;
                View view3 = view0.findViewById(0x7F0A08A2);  // id:network_error_confirm_button
                q.f(view3, "findViewById(...)");
                this.networkErrorConfirmButton = (TextView)view3;
            }

            @NotNull
            public final TextView getNetworkErrorConfirmButton() {
                return this.networkErrorConfirmButton;
            }

            @NotNull
            public final View getNetworkErrorLayout() {
                return this.networkErrorLayout;
            }

            @NotNull
            public final View getNetworkErrorRetryButton() {
                return this.networkErrorRetryButton;
            }

            public final void setNetworkErrorConfirmButton(@NotNull TextView textView0) {
                q.g(textView0, "<set-?>");
                this.networkErrorConfirmButton = textView0;
            }

            public final void setNetworkErrorLayout(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.networkErrorLayout = view0;
            }

            public final void setNetworkErrorRetryButton(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.networkErrorRetryButton = view0;
            }
        }

        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter$SearchSongHolder;", "Lcom/iloen/melon/viewholders/SongHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter;Landroid/view/View;)V", "ivAddBtn", "Landroid/widget/ImageView;", "getIvAddBtn", "()Landroid/widget/ImageView;", "setIvAddBtn", "(Landroid/widget/ImageView;)V", "ivPlayHighlight", "getIvPlayHighlight", "()Landroid/view/View;", "setIvPlayHighlight", "(Landroid/view/View;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SearchSongHolder extends SongHolder {
            @NotNull
            private ImageView ivAddBtn;
            @NotNull
            private View ivPlayHighlight;

            public SearchSongHolder(@NotNull View view0) {
                q.g(view0, "view");
                SongListAdapter.this = playlistSearchAndAddPlaylistFragment$SongListAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A05E2);  // id:iv_add_btn
                q.f(view1, "findViewById(...)");
                this.ivAddBtn = (ImageView)view1;
                View view2 = view0.findViewById(0x7F0A0661);  // id:iv_play_highlight
                q.f(view2, "findViewById(...)");
                this.ivPlayHighlight = view2;
            }

            @NotNull
            public final ImageView getIvAddBtn() {
                return this.ivAddBtn;
            }

            @NotNull
            public final View getIvPlayHighlight() {
                return this.ivPlayHighlight;
            }

            public final void setIvAddBtn(@NotNull ImageView imageView0) {
                q.g(imageView0, "<set-?>");
                this.ivAddBtn = imageView0;
            }

            public final void setIvPlayHighlight(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.ivPlayHighlight = view0;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter$SectionTitleHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "setTvTitle", "(Landroid/widget/TextView;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SectionTitleHolder extends O0 {
            @NotNull
            private TextView tvTitle;

            public SectionTitleHolder(@NotNull View view0) {
                q.g(view0, "view");
                SongListAdapter.this = playlistSearchAndAddPlaylistFragment$SongListAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0D34);  // id:tv_title
                q.f(view1, "findViewById(...)");
                this.tvTitle = (TextView)view1;
            }

            @NotNull
            public final TextView getTvTitle() {
                return this.tvTitle;
            }

            public final void setTvTitle(@NotNull TextView textView0) {
                q.g(textView0, "<set-?>");
                this.tvTitle = textView0;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\"\u0010\f\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001A\u0004\b\r\u0010\t\"\u0004\b\u000E\u0010\u000BR\"\u0010\u0010\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter$SongEmptyListHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter;Landroid/view/View;)V", "emptyLayout", "Landroid/view/View;", "getEmptyLayout", "()Landroid/view/View;", "setEmptyLayout", "(Landroid/view/View;)V", "emptyImage", "getEmptyImage", "setEmptyImage", "Landroid/widget/TextView;", "emptyText", "Landroid/widget/TextView;", "getEmptyText", "()Landroid/widget/TextView;", "setEmptyText", "(Landroid/widget/TextView;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SongEmptyListHolder extends O0 {
            @NotNull
            private View emptyImage;
            @NotNull
            private View emptyLayout;
            @NotNull
            private TextView emptyText;

            public SongEmptyListHolder(@NotNull View view0) {
                q.g(view0, "view");
                SongListAdapter.this = playlistSearchAndAddPlaylistFragment$SongListAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A042B);  // id:empty_layout
                q.f(view1, "findViewById(...)");
                this.emptyLayout = view1;
                View view2 = view0.findViewById(0x7F0A042A);  // id:empty_image
                q.f(view2, "findViewById(...)");
                this.emptyImage = view2;
                View view3 = view0.findViewById(0x7F0A042F);  // id:empty_text
                q.f(view3, "findViewById(...)");
                this.emptyText = (TextView)view3;
            }

            @NotNull
            public final View getEmptyImage() {
                return this.emptyImage;
            }

            @NotNull
            public final View getEmptyLayout() {
                return this.emptyLayout;
            }

            @NotNull
            public final TextView getEmptyText() {
                return this.emptyText;
            }

            public final void setEmptyImage(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.emptyImage = view0;
            }

            public final void setEmptyLayout(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.emptyLayout = view0;
            }

            public final void setEmptyText(@NotNull TextView textView0) {
                q.g(textView0, "<set-?>");
                this.emptyText = textView0;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\"\u0010\u000E\u001A\u00020\r8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001A\u00020\r8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0014\u0010\u000F\u001A\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter$SongSelectionHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddPlaylistFragment$SongListAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "setIvIcon", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "tvSelectAll", "Landroid/widget/TextView;", "getTvSelectAll", "()Landroid/widget/TextView;", "setTvSelectAll", "(Landroid/widget/TextView;)V", "tvSongCount", "getTvSongCount", "setTvSongCount", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SongSelectionHolder extends O0 {
            @NotNull
            private ImageView ivIcon;
            @NotNull
            private TextView tvSelectAll;
            @NotNull
            private TextView tvSongCount;

            public SongSelectionHolder(@NotNull View view0) {
                q.g(view0, "view");
                SongListAdapter.this = playlistSearchAndAddPlaylistFragment$SongListAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0635);  // id:iv_icon
                q.f(view1, "findViewById(...)");
                this.ivIcon = (ImageView)view1;
                View view2 = view0.findViewById(0x7F0A0D09);  // id:tv_select_all
                q.f(view2, "findViewById(...)");
                this.tvSelectAll = (TextView)view2;
                View view3 = view0.findViewById(0x7F0A0D17);  // id:tv_song_count
                q.f(view3, "findViewById(...)");
                this.tvSongCount = (TextView)view3;
            }

            @NotNull
            public final ImageView getIvIcon() {
                return this.ivIcon;
            }

            @NotNull
            public final TextView getTvSelectAll() {
                return this.tvSelectAll;
            }

            @NotNull
            public final TextView getTvSongCount() {
                return this.tvSongCount;
            }

            public final void setIvIcon(@NotNull ImageView imageView0) {
                q.g(imageView0, "<set-?>");
                this.ivIcon = imageView0;
            }

            public final void setTvSelectAll(@NotNull TextView textView0) {
                q.g(textView0, "<set-?>");
                this.tvSelectAll = textView0;
            }

            public final void setTvSongCount(@NotNull TextView textView0) {
                q.g(textView0, "<set-?>");
                this.tvSongCount = textView0;
            }
        }

        private final int VIEW_TYPE_EMPTY_LIST;
        private final int VIEW_TYPE_HEADER_TITLE;
        private final int VIEW_TYPE_NETWORK_ERROR;
        private final int VIEW_TYPE_SONG;
        private final int VIEW_TYPE_SONG_SELECTION;
        private boolean fetchCompleted;
        private boolean isNetworkError;
        @NotNull
        private ArrayList songList;

        public SongListAdapter() {
            this.songList = new ArrayList();
            this.VIEW_TYPE_SONG_SELECTION = 1;
            this.VIEW_TYPE_SONG = 2;
            this.VIEW_TYPE_EMPTY_LIST = 3;
            this.VIEW_TYPE_NETWORK_ERROR = 4;
        }

        public final void clearSongList() {
            this.songList.clear();
            this.notifyDataSetChanged();
        }

        public final boolean getFetchCompleted() {
            return this.fetchCompleted;
        }

        // 去混淆评级： 低(20)
        @Override  // androidx.recyclerview.widget.j0
        public int getItemCount() {
            return this.isNetworkError ? 1 : this.songList.size() + 2;
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            switch(v) {
                case 0: {
                    return this.isNetworkError ? this.VIEW_TYPE_NETWORK_ERROR : this.VIEW_TYPE_HEADER_TITLE;
                }
                case 1: {
                    return this.songList.size() >= 1 ? this.VIEW_TYPE_SONG_SELECTION : this.VIEW_TYPE_EMPTY_LIST;
                }
                default: {
                    return this.VIEW_TYPE_SONG;
                }
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(@NotNull O0 o00, int v) {
            String s = "";
            q.g(o00, "vh");
            if(o00 instanceof SectionTitleHolder) {
                d d0 = new d(PlaylistSearchAndAddPlaylistFragment.this, 1);
                o00.itemView.setOnClickListener(d0);
                ((SectionTitleHolder)o00).getTvTitle().setText(PlaylistSearchAndAddPlaylistFragment.this.selectedPlaylistName);
                return;
            }
            if(o00 instanceof SongSelectionHolder) {
                TextView textView0 = ((SongSelectionHolder)o00).getTvSongCount();
                String s1 = PlaylistSearchAndAddPlaylistFragment.this.getString(0x7F130655);  // string:melondj_playlist_song_count "%s곡"
                q.f(s1, "getString(...)");
                textView0.setText(String.format(s1, Arrays.copyOf(new Object[]{StringUtils.getCountString(this.songList.size(), -1)}, 1)));
                C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                c0.a = true;
                F f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
                Iterator iterator0 = this.songList.iterator();
                q.f(iterator0, "iterator(...)");
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    SongInfoBase songInfoBase0 = (SongInfoBase)object0;
                    if(songInfoBase0 != null && songInfoBase0.canService && !PlaylistSearchAndAddPlaylistFragment.this.getPlaylistSearchViewModel().containsSongId((songInfoBase0.songId == null ? "" : songInfoBase0.songId))) {
                        c0.a = false;
                        break;
                    }
                    if(songInfoBase0 != null && !songInfoBase0.canService) {
                        ++f0.a;
                    }
                }
                if(f0.a == this.songList.size()) {
                    c0.a = false;
                }
                if(c0.a) {
                    ((SongSelectionHolder)o00).getTvSelectAll().setText(PlaylistSearchAndAddPlaylistFragment.this.getString(0x7F130341));  // string:dj_playlist_search_unselect_all "추가해제"
                    ((SongSelectionHolder)o00).getTvSelectAll().setTextColor(ColorUtils.getColor(PlaylistSearchAndAddPlaylistFragment.this.getContext(), 0x7F06017C));  // color:green500s_support_high_contrast
                    ((SongSelectionHolder)o00).getIvIcon().setImageResource(0x7F080119);  // drawable:btn_common_add_17_on
                }
                else {
                    ((SongSelectionHolder)o00).getTvSelectAll().setText(PlaylistSearchAndAddPlaylistFragment.this.getString(0x7F130340));  // string:dj_playlist_search_select_all "전곡추가"
                    ((SongSelectionHolder)o00).getTvSelectAll().setTextColor(ColorUtils.getColor(PlaylistSearchAndAddPlaylistFragment.this.getContext(), 0x7F060165));  // color:gray800s
                    ((SongSelectionHolder)o00).getIvIcon().setImageResource(0x7F080118);  // drawable:btn_common_add_17_off
                }
                ((SongSelectionHolder)o00).getTvSelectAll().setOnClickListener(new g(this, c0, PlaylistSearchAndAddPlaylistFragment.this, f0));
                return;
            }
            if(o00 instanceof SearchSongHolder) {
                Object object1 = this.songList.get(v - 2);
                if(((SongInfoBase)object1) != null) {
                    PlaylistSearchAndAddPlaylistFragment playlistSearchAndAddPlaylistFragment0 = PlaylistSearchAndAddPlaylistFragment.this;
                    ViewUtils.setEnable(o00.itemView, ((SongInfoBase)object1).canService);
                    PlaylistSearchViewModel playlistSearchViewModel0 = playlistSearchAndAddPlaylistFragment0.getPlaylistSearchViewModel();
                    String s2 = ((SongInfoBase)object1).songId;
                    if(s2 != null) {
                        s = s2;
                    }
                    ((SearchSongHolder)o00).getIvAddBtn().setImageResource((playlistSearchViewModel0.containsSongId(s) ? 0x7F0800E0 : 0x7F0800DF));  // drawable:btn_add_24_on
                    if(((SongInfoBase)object1).canService) {
                        ViewUtils.setOnClickListener(((SearchSongHolder)o00).getIvAddBtn(), new h(playlistSearchAndAddPlaylistFragment0, ((SongInfoBase)object1), this, v, 0));
                    }
                    else {
                        ViewUtils.setOnClickListener(((SearchSongHolder)o00).getIvAddBtn(), null);
                        ViewUtils.setOnClickListener(o00.itemView, null);
                        int v1 = ColorUtils.getColor(playlistSearchAndAddPlaylistFragment0.getContext(), 0x7F06048A);  // color:transparent
                        o00.itemView.setBackgroundColor(v1);
                    }
                    ImageView imageView0 = ((SearchSongHolder)o00).thumbnailIv;
                    if(imageView0 != null) {
                        Glide.with(imageView0.getContext()).load(((SongInfoBase)object1).albumImg).into(((SearchSongHolder)o00).thumbnailIv);
                    }
                    ViewUtils.setOnClickListener(((SearchSongHolder)o00).getIvPlayHighlight(), new f(1, playlistSearchAndAddPlaylistFragment0, ((SongInfoBase)object1)));
                    ((SearchSongHolder)o00).titleTv.setText(((SongInfoBase)object1).songName);
                    ((SearchSongHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(((SongInfoBase)object1).artistList));
                    ViewUtils.showWhen(((SearchSongHolder)o00).list19Iv, ((SongInfoBase)object1).isAdult);
                    ViewUtils.showWhen(((SearchSongHolder)o00).listFreeIv, ((SongInfoBase)object1).isFree);
                    ViewUtils.showWhen(((SearchSongHolder)o00).listHoldbackIv, ((SongInfoBase)object1).isHoldback);
                }
            }
            else {
                if(o00 instanceof SongEmptyListHolder) {
                    ViewUtils.showWhen(((SongEmptyListHolder)o00).getEmptyLayout(), this.fetchCompleted);
                    ViewUtils.showWhen(((SongEmptyListHolder)o00).getEmptyImage(), true);
                    ((SongEmptyListHolder)o00).getEmptyText().setText(PlaylistSearchAndAddPlaylistFragment.this.getString(0x7F130829));  // string:playlist_edit_song_list_empty "수록곡이 없습니다."
                    return;
                }
                if(o00 instanceof NetworkErrorHolder) {
                    ViewUtils.showWhen(((NetworkErrorHolder)o00).getNetworkErrorLayout(), true);
                    ViewUtils.hideWhen(((NetworkErrorHolder)o00).getNetworkErrorRetryButton(), true);
                    ViewUtils.hideWhen(((NetworkErrorHolder)o00).getNetworkErrorConfirmButton(), true);
                }
            }
        }

        private static final void onBindViewHolder$lambda$1(PlaylistSearchAndAddPlaylistFragment playlistSearchAndAddPlaylistFragment0, View view0) {
            RecyclerView recyclerView0 = playlistSearchAndAddPlaylistFragment0.songRecyclerView;
            if(recyclerView0 != null) {
                w0 w00 = recyclerView0.getLayoutManager();
                if(w00 != null) {
                    w00.removeAllViews();
                }
                SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter0 = playlistSearchAndAddPlaylistFragment0.songListAdapter;
                if(playlistSearchAndAddPlaylistFragment$SongListAdapter0 != null) {
                    playlistSearchAndAddPlaylistFragment$SongListAdapter0.notifyDataSetChanged();
                }
                playlistSearchAndAddPlaylistFragment0.changeRecyclerView(0);
                return;
            }
            q.m("songRecyclerView");
            throw null;
        }

        private static final void onBindViewHolder$lambda$3(SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter0, C c0, PlaylistSearchAndAddPlaylistFragment playlistSearchAndAddPlaylistFragment0, F f0, View view0) {
            ArrayList arrayList0 = new ArrayList();
            Iterator iterator0 = playlistSearchAndAddPlaylistFragment$SongListAdapter0.songList.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                SongInfoBase songInfoBase0 = (SongInfoBase)object0;
                if(songInfoBase0 != null && songInfoBase0.canService) {
                    arrayList0.add((songInfoBase0.songId == null ? "" : songInfoBase0.songId));
                }
            }
            if(c0.a) {
                playlistSearchAndAddPlaylistFragment0.getPlaylistSearchViewModel().removeSongList(arrayList0);
                return;
            }
            if(f0.a == playlistSearchAndAddPlaylistFragment$SongListAdapter0.songList.size()) {
                ToastManager.show(0x7F13081D);  // string:playlist_added_songs_no_enable_song "추가 가능한 곡이 없습니다."
                return;
            }
            if(!playlistSearchAndAddPlaylistFragment0.getPlaylistSearchViewModel().addSongList(arrayList0)) {
                ToastManager.show(playlistSearchAndAddPlaylistFragment0.getPlaylistSearchViewModel().getOverSelectMessage());
            }
        }

        private static final void onBindViewHolder$lambda$6$lambda$4(PlaylistSearchAndAddPlaylistFragment playlistSearchAndAddPlaylistFragment0, SongInfoBase songInfoBase0, SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter0, int v, View view0) {
            PlaylistSearchViewModel playlistSearchViewModel0 = playlistSearchAndAddPlaylistFragment0.getPlaylistSearchViewModel();
            String s = songInfoBase0.songId;
            String s1 = "";
            if(s == null) {
                s = "";
            }
            if(playlistSearchViewModel0.containsSongId(s)) {
                PlaylistSearchViewModel playlistSearchViewModel1 = playlistSearchAndAddPlaylistFragment0.getPlaylistSearchViewModel();
                String s2 = songInfoBase0.songId;
                if(s2 != null) {
                    s1 = s2;
                }
                playlistSearchViewModel1.removeSong(s1);
            }
            else {
                PlaylistSearchViewModel playlistSearchViewModel2 = playlistSearchAndAddPlaylistFragment0.getPlaylistSearchViewModel();
                String s3 = songInfoBase0.songId;
                if(s3 != null) {
                    s1 = s3;
                }
                if(!playlistSearchViewModel2.addSong(s1)) {
                    ToastManager.show(playlistSearchAndAddPlaylistFragment0.getPlaylistSearchViewModel().getOverSelectMessage());
                }
            }
            playlistSearchAndAddPlaylistFragment$SongListAdapter0.notifyItemChanged(v);
        }

        private static final void onBindViewHolder$lambda$6$lambda$5(PlaylistSearchAndAddPlaylistFragment playlistSearchAndAddPlaylistFragment0, SongInfoBase songInfoBase0, View view0) {
            playlistSearchAndAddPlaylistFragment0.showInstantPlayPopup(Playable.from(songInfoBase0, playlistSearchAndAddPlaylistFragment0.getMenuId(), null));
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_HEADER_TITLE) {
                View view0 = LayoutInflater.from(PlaylistSearchAndAddPlaylistFragment.this.getContext()).inflate(0x7F0D04AA, viewGroup0, false);  // layout:listitem_song_dj_search_section_title
                q.f(view0, "inflate(...)");
                return new SectionTitleHolder(this, view0);
            }
            if(v == this.VIEW_TYPE_SONG_SELECTION) {
                View view1 = LayoutInflater.from(PlaylistSearchAndAddPlaylistFragment.this.getContext()).inflate(0x7F0D04AB, viewGroup0, false);  // layout:listitem_song_dj_search_song_selection
                q.f(view1, "inflate(...)");
                return new SongSelectionHolder(this, view1);
            }
            if(v == this.VIEW_TYPE_SONG) {
                View view2 = LayoutInflater.from(PlaylistSearchAndAddPlaylistFragment.this.getContext()).inflate(0x7F0D04A9, viewGroup0, false);  // layout:listitem_song_dj_search
                q.f(view2, "inflate(...)");
                return new SearchSongHolder(this, view2);
            }
            if(v == this.VIEW_TYPE_EMPTY_LIST) {
                View view3 = LayoutInflater.from(PlaylistSearchAndAddPlaylistFragment.this.getContext()).inflate(0x7F0D0022, viewGroup0, false);  // layout:adapter_empty_view
                q.f(view3, "inflate(...)");
                return new SongEmptyListHolder(this, view3);
            }
            View view4 = LayoutInflater.from(PlaylistSearchAndAddPlaylistFragment.this.getContext()).inflate(0x7F0D0028, viewGroup0, false);  // layout:adapter_network_error_view
            q.f(view4, "inflate(...)");
            return new NetworkErrorHolder(this, view4);
        }

        public final void setFetchCompleted(boolean z) {
            this.fetchCompleted = z;
        }

        public final void setNetworkError() {
            this.isNetworkError = true;
            this.notifyDataSetChanged();
        }

        public final void setSongList(@Nullable ArrayList arrayList0) {
            if(arrayList0 != null) {
                this.songList.clear();
                this.songList.addAll(arrayList0);
                this.notifyDataSetChanged();
            }
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int RECYCLER_VIEW_TYPE_PLAYLIST = 0;
    private static final int RECYCLER_VIEW_TYPE_SONGLIST = 1;
    @NotNull
    private static final String TAG = "SongRecentSearchAndAddFragment";
    @Nullable
    private PlaylistDetailFactoryBase playlistFactory;
    @NotNull
    private final j playlistSearchViewModel$delegate;
    private int recyclerViewType;
    @Nullable
    private String selectedPlaylistName;
    @Nullable
    private SongListAdapter songListAdapter;
    private RecyclerView songRecyclerView;

    static {
        PlaylistSearchAndAddPlaylistFragment.Companion = new Companion(null);
        PlaylistSearchAndAddPlaylistFragment.$stable = 8;
    }

    public PlaylistSearchAndAddPlaylistFragment() {
        this.playlistSearchViewModel$delegate = d3.g.Q(new e(this, 0));
    }

    private final void changeRecyclerView(int v) {
        this.recyclerViewType = v;
        boolean z = true;
        ViewUtils.showWhen(this.getRecyclerView(), v == 0);
        RecyclerView recyclerView0 = this.songRecyclerView;
        if(recyclerView0 != null) {
            if(v != 1) {
                z = false;
            }
            ViewUtils.showWhen(recyclerView0, z);
            if(v == 0) {
                SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter0 = this.songListAdapter;
                if(playlistSearchAndAddPlaylistFragment$SongListAdapter0 != null) {
                    playlistSearchAndAddPlaylistFragment$SongListAdapter0.clearSongList();
                }
                SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter1 = this.songListAdapter;
                if(playlistSearchAndAddPlaylistFragment$SongListAdapter1 != null) {
                    playlistSearchAndAddPlaylistFragment$SongListAdapter1.setFetchCompleted(false);
                }
            }
            return;
        }
        q.m("songRecyclerView");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new PlaylistAdapter(this, context0);
    }

    private final void fetchPlaylistSongs(String s) {
        Params playlistListSongBaseReq$Params0 = new Params();
        playlistListSongBaseReq$Params0.plylstSeq = s;
        playlistListSongBaseReq$Params0.mode = "modify";
        this.showProgress(true);
        RequestBuilder.newInstance((this.playlistFactory == null ? null : this.playlistFactory.songList(this.getContext(), playlistListSongBaseReq$Params0, 2))).tag("SongRecentSearchAndAddFragment").listener(new Listener() {
            public void onResponse(HttpResponse httpResponse0) {
                q.g(httpResponse0, "responseContainer");
                PlaylistSearchAndAddPlaylistFragment.this.showProgress(false);
                if(!httpResponse0.isSuccessful() || !(httpResponse0 instanceof MelonDjPlaylistListSongRes)) {
                    SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter3 = PlaylistSearchAndAddPlaylistFragment.this.songListAdapter;
                    if(playlistSearchAndAddPlaylistFragment$SongListAdapter3 != null) {
                        playlistSearchAndAddPlaylistFragment$SongListAdapter3.setNetworkError();
                    }
                }
                else {
                    SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter0 = PlaylistSearchAndAddPlaylistFragment.this.songListAdapter;
                    if(playlistSearchAndAddPlaylistFragment$SongListAdapter0 != null) {
                        playlistSearchAndAddPlaylistFragment$SongListAdapter0.setFetchCompleted(true);
                    }
                    if(((MelonDjPlaylistListSongRes)httpResponse0).response == null) {
                        SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter2 = PlaylistSearchAndAddPlaylistFragment.this.songListAdapter;
                        if(playlistSearchAndAddPlaylistFragment$SongListAdapter2 != null) {
                            playlistSearchAndAddPlaylistFragment$SongListAdapter2.clearSongList();
                        }
                    }
                    else {
                        SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter1 = PlaylistSearchAndAddPlaylistFragment.this.songListAdapter;
                        if(playlistSearchAndAddPlaylistFragment$SongListAdapter1 != null) {
                            RESPONSE melonDjPlaylistListSongRes$RESPONSE0 = ((MelonDjPlaylistListSongRes)httpResponse0).response;
                            playlistSearchAndAddPlaylistFragment$SongListAdapter1.setSongList((melonDjPlaylistListSongRes$RESPONSE0 == null ? null : melonDjPlaylistListSongRes$RESPONSE0.songList));
                        }
                    }
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((HttpResponse)object0));
            }
        }).errorListener(new m(this, 4)).request();
    }

    private static final void fetchPlaylistSongs$lambda$2(PlaylistSearchAndAddPlaylistFragment playlistSearchAndAddPlaylistFragment0, VolleyError volleyError0) {
        playlistSearchAndAddPlaylistFragment0.showProgress(false);
        SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter0 = playlistSearchAndAddPlaylistFragment0.songListAdapter;
        if(playlistSearchAndAddPlaylistFragment$SongListAdapter0 != null) {
            playlistSearchAndAddPlaylistFragment$SongListAdapter0.setNetworkError();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.h.buildUpon().appendPath("songRecent").appendQueryParameter("caller", String.valueOf(this.mCaller)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final PlaylistSearchViewModel getPlaylistSearchViewModel() {
        return (PlaylistSearchViewModel)this.playlistSearchViewModel$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        if(this.recyclerViewType == 1) {
            this.changeRecyclerView(0);
            return true;
        }
        return super.onBackPressed();
    }

    @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddBaseFragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02C0, viewGroup0, false);  // layout:fragment_search_and_add_playlist
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull v9.h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddPlaylistFragment.PlaylistAdapter");
        com.iloen.melon.net.v6x.request.MyMusicPlaylistListV6Req.Params myMusicPlaylistListV6Req$Params0 = new com.iloen.melon.net.v6x.request.MyMusicPlaylistListV6Req.Params();
        myMusicPlaylistListV6Req$Params0.startIndex = i.b.equals(i0) ? 1 : ((PlaylistAdapter)j00).getCount() + 1;
        myMusicPlaylistListV6Req$Params0.pageSize = 100;
        myMusicPlaylistListV6Req$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        myMusicPlaylistListV6Req$Params0.plylstTypeCode = "M20001";
        myMusicPlaylistListV6Req$Params0.orderBy = "DSPLY_ORDER";
        myMusicPlaylistListV6Req$Params0.mode = "search";
        RequestBuilder.newInstance(new MyMusicPlaylistListV6Req(this.getContext(), myMusicPlaylistListV6Req$Params0)).tag("SongRecentSearchAndAddFragment").listener(new Listener() {
            public void onResponse(MyMusicPlaylistListV6Res myMusicPlaylistListV6Res0) {
                if(!i0.prepareFetchComplete(myMusicPlaylistListV6Res0)) {
                    return;
                }
                i0.performFetchComplete(this.$type, myMusicPlaylistListV6Res0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicPlaylistListV6Res)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.playlistFactory = PlaylistDetailFactoryBase.create("M20002");
        View view1 = this.findViewById(0x7F0A0AB1);  // id:song_recycler_view
        q.e(view1, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.songRecyclerView = (RecyclerView)view1;
        ((RecyclerView)view1).setLayoutManager(new LinearLayoutManager(this.getContext()));
        SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter0 = new SongListAdapter(this);
        this.songListAdapter = playlistSearchAndAddPlaylistFragment$SongListAdapter0;
        RecyclerView recyclerView0 = this.songRecyclerView;
        if(recyclerView0 != null) {
            recyclerView0.setAdapter(playlistSearchAndAddPlaylistFragment$SongListAdapter0);
            this.getPlaylistSearchViewModel().getSongList().observe(this.requireActivity(), new PlaylistSearchAndAddPlaylistFragment.sam.androidx_lifecycle_Observer.0(new a(this, 1)));
            return;
        }
        q.m("songRecyclerView");
        throw null;
    }

    private static final H onViewCreated$lambda$1(PlaylistSearchAndAddPlaylistFragment playlistSearchAndAddPlaylistFragment0, ArrayList arrayList0) {
        SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter0 = playlistSearchAndAddPlaylistFragment0.songListAdapter;
        if(playlistSearchAndAddPlaylistFragment$SongListAdapter0 != null) {
            playlistSearchAndAddPlaylistFragment$SongListAdapter0.notifyDataSetChanged();
        }
        return H.a;
    }

    private static final PlaylistSearchViewModel playlistSearchViewModel_delegate$lambda$0(PlaylistSearchAndAddPlaylistFragment playlistSearchAndAddPlaylistFragment0) {
        FragmentActivity fragmentActivity0 = playlistSearchAndAddPlaylistFragment0.requireActivity();
        q.f(fragmentActivity0, "requireActivity(...)");
        q0 q00 = fragmentActivity0.getViewModelStore();
        o0 o00 = fragmentActivity0.getDefaultViewModelProviderFactory();
        c c0 = fragmentActivity0.getDefaultViewModelCreationExtras();
        q.g(q00, "store");
        q.g(o00, "factory");
        b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
        De.d d0 = df.d.y(PlaylistSearchViewModel.class);
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (PlaylistSearchViewModel)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
    }
}

