package com.iloen.melon.fragments.searchandadd;

import Ad.n;
import Gd.f;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.net.res.common.SongInfoBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000F\b\'\u0018\u0000 #2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002#$B+\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\u000F\u001A\u00020\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\'\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\"\u0010\t\u001A\u00020\b8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\t\u0010\u001E\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/net/res/common/SongInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "playlistSearchViewModel", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;)V", "Lcom/iloen/melon/playback/Playable;", "playable", "Lie/H;", "onInstantPlayShow", "(Lcom/iloen/melon/playback/Playable;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "getPlaylistSearchViewModel", "()Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "setPlaylistSearchViewModel", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;)V", "Companion", "SearchSongHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class PlaylistSearchAndAddAdapter extends p {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddAdapter$Companion;", "", "<init>", "()V", "TAG", "", "VIEW_TYPE_SORTBAR", "", "VIEW_TYPE_ITEM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddAdapter$SearchSongHolder;", "Lcom/iloen/melon/viewholders/SongHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddAdapter;Landroid/view/View;)V", "ivAddBtn", "Landroid/widget/ImageView;", "getIvAddBtn", "()Landroid/widget/ImageView;", "setIvAddBtn", "(Landroid/widget/ImageView;)V", "ivPlayHighlight", "getIvPlayHighlight", "()Landroid/view/View;", "setIvPlayHighlight", "(Landroid/view/View;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class SearchSongHolder extends SongHolder {
        @NotNull
        private ImageView ivAddBtn;
        @NotNull
        private View ivPlayHighlight;

        public SearchSongHolder(@NotNull View view0) {
            q.g(view0, "view");
            PlaylistSearchAndAddAdapter.this = playlistSearchAndAddAdapter0;
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

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SongLikeSearchAndAddFragment";
    public static final int VIEW_TYPE_ITEM = 1;
    public static final int VIEW_TYPE_SORTBAR;
    @NotNull
    private PlaylistSearchViewModel playlistSearchViewModel;

    static {
        PlaylistSearchAndAddAdapter.Companion = new Companion(null);
        PlaylistSearchAndAddAdapter.$stable = 8;
    }

    public PlaylistSearchAndAddAdapter(@Nullable Context context0, @Nullable List list0, @NotNull PlaylistSearchViewModel playlistSearchViewModel0) {
        q.g(playlistSearchViewModel0, "playlistSearchViewModel");
        super(context0, list0);
        this.playlistSearchViewModel = playlistSearchViewModel0;
        this.setListContentType(1);
    }

    public static void a(View view0) {
    }

    public static void d(View view0) {
    }

    @Override  // com.iloen.melon.adapters.common.p
    public int getItemViewTypeImpl(int v, int v1) {
        return 1;
    }

    @NotNull
    public final PlaylistSearchViewModel getPlaylistSearchViewModel() {
        return this.playlistSearchViewModel;
    }

    @Override  // com.iloen.melon.adapters.common.p
    public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
        q.g(o00, "viewHolder");
        if(o00.getItemViewType() == 1 && o00 instanceof SearchSongHolder) {
            SongInfoBase songInfoBase0 = (SongInfoBase)this.getItem(v1);
            ViewUtils.setEnable(o00.itemView, (songInfoBase0 == null ? false : songInfoBase0.canService));
            ((SearchSongHolder)o00).getIvAddBtn().setImageResource((this.playlistSearchViewModel.containsSongId((songInfoBase0.songId == null ? "" : songInfoBase0.songId)) ? 0x7F0800E0 : 0x7F0800DF));  // drawable:btn_add_24_on
            if(songInfoBase0.canService) {
                ViewUtils.setOnClickListener(((SearchSongHolder)o00).getIvAddBtn(), new n(this, songInfoBase0, v1, 14));
            }
            else {
                f f0 = new f(8);
                ViewUtils.setOnClickListener(o00.itemView, f0);
                ViewUtils.setOnClickListener(((SearchSongHolder)o00).getIvAddBtn(), new f(9));
                int v2 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                o00.itemView.setBackgroundColor(v2);
            }
            ImageView imageView0 = ((SearchSongHolder)o00).thumbnailIv;
            if(imageView0 != null) {
                Glide.with(imageView0.getContext()).load(songInfoBase0.albumImg).into(((SearchSongHolder)o00).thumbnailIv);
            }
            ViewUtils.setOnClickListener(((SearchSongHolder)o00).getIvPlayHighlight(), new com.iloen.melon.fragments.searchandadd.f(3, this, songInfoBase0));
            ((SearchSongHolder)o00).titleTv.setText(songInfoBase0.songName);
            ((SearchSongHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(songInfoBase0.artistList));
            ViewUtils.showWhen(((SearchSongHolder)o00).list19Iv, songInfoBase0.isAdult);
            ViewUtils.showWhen(((SearchSongHolder)o00).listFreeIv, songInfoBase0.isFree);
            ViewUtils.showWhen(((SearchSongHolder)o00).listHoldbackIv, songInfoBase0.isHoldback);
        }
    }

    private static final void onBindViewImpl$lambda$0(PlaylistSearchAndAddAdapter playlistSearchAndAddAdapter0, SongInfoBase songInfoBase0, int v, View view0) {
        PlaylistSearchViewModel playlistSearchViewModel0 = playlistSearchAndAddAdapter0.playlistSearchViewModel;
        String s = songInfoBase0.songId;
        String s1 = "";
        if(s == null) {
            s = "";
        }
        if(playlistSearchViewModel0.containsSongId(s)) {
            PlaylistSearchViewModel playlistSearchViewModel1 = playlistSearchAndAddAdapter0.playlistSearchViewModel;
            String s2 = songInfoBase0.songId;
            if(s2 != null) {
                s1 = s2;
            }
            playlistSearchViewModel1.removeSong(s1);
        }
        else {
            PlaylistSearchViewModel playlistSearchViewModel2 = playlistSearchAndAddAdapter0.playlistSearchViewModel;
            String s3 = songInfoBase0.songId;
            if(s3 != null) {
                s1 = s3;
            }
            if(!playlistSearchViewModel2.addSong(s1)) {
                ToastManager.show(playlistSearchAndAddAdapter0.playlistSearchViewModel.getOverSelectMessage());
            }
        }
        playlistSearchAndAddAdapter0.notifyItemChanged(v);
    }

    private static final void onBindViewImpl$lambda$1(View view0) {
    }

    private static final void onBindViewImpl$lambda$2(View view0) {
    }

    private static final void onBindViewImpl$lambda$3(PlaylistSearchAndAddAdapter playlistSearchAndAddAdapter0, SongInfoBase songInfoBase0, View view0) {
        playlistSearchAndAddAdapter0.onInstantPlayShow(Playable.from(songInfoBase0, playlistSearchAndAddAdapter0.getMenuId(), null));
    }

    @Override  // com.iloen.melon.adapters.common.p
    @NotNull
    public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "parent");
        View view0 = this.mInflater.inflate(0x7F0D04A9, viewGroup0, false);  // layout:listitem_song_dj_search
        q.f(view0, "inflate(...)");
        return new SearchSongHolder(this, view0);
    }

    public abstract void onInstantPlayShow(@Nullable Playable arg1);

    public final void setPlaylistSearchViewModel(@NotNull PlaylistSearchViewModel playlistSearchViewModel0) {
        q.g(playlistSearchViewModel0, "<set-?>");
        this.playlistSearchViewModel = playlistSearchViewModel0;
    }
}

