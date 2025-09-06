package com.iloen.melon.fragments.mymusic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.request.MyMusicRecentListSongRecntReq;
import com.iloen.melon.net.v5x.request.RecentListSongRecntBaseReq.Params;
import com.iloen.melon.net.v5x.response.MyMusicRecentListSongRecntRes;
import com.iloen.melon.net.v5x.response.RecentListSongRecntResBase.RESPONSE;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 92\u00020\u0001:\u00029:B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0012\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0019\u001A\u00020\u00042\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\rH\u0014\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u00062\u0006\u0010\u001B\u001A\u00020\u0010H\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001F\u001A\u00020\u00062\u0006\u0010\u001E\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u001F\u0010\u001DJ\u000F\u0010 \u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b \u0010\u0003J\u000F\u0010!\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010&\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010%J\u000F\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b(\u0010)J\u001B\u0010-\u001A\u0006\u0012\u0002\b\u00030,2\u0006\u0010+\u001A\u00020*H\u0014\u00A2\u0006\u0004\b-\u0010.J\u0011\u00100\u001A\u0004\u0018\u00010/H\u0014\u00A2\u0006\u0004\b0\u00101R\u0016\u00103\u001A\u0002028\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001A\u00020\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108\u00A8\u0006;"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedSongFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "", "isVisible", "Lie/H;", "setAllCheckButtonVisibility", "(Z)V", "Landroid/view/View;", "view", "initHeaderView", "(Landroid/view/View;)V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onPause", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/SortingBarView;", "headerView", "Lcom/iloen/melon/custom/SortingBarView;", "memberKey", "Ljava/lang/String;", "isItemEmpty", "Z", "Companion", "ListenedSongAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicListenedSongFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedSongFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicListenedSongFragment;", "targetMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicListenedSongFragment newInstance(@NotNull String s) {
            q.g(s, "targetMemberKey");
            MyMusicListenedSongFragment myMusicListenedSongFragment0 = new MyMusicListenedSongFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            myMusicListenedSongFragment0.setArguments(bundle0);
            return myMusicListenedSongFragment0;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001A\u001A\u00020\u00032\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ)\u0010\u001D\u001A\u00020\r2\b\u0010\u001C\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedSongFragment$ListenedSongAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/net/res/common/SongInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicListenedSongFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "guide", "Lie/H;", "setGuideText", "(Ljava/lang/String;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "getFooterViewItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_SONG", "I", "VIEW_TYPE_FOOTER", "tvGuide", "Ljava/lang/String;", "FooterViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ListenedSongAdapter extends p {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedSongFragment$ListenedSongAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicListenedSongFragment$ListenedSongAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/MelonTextView;", "tvTitle", "Lcom/iloen/melon/custom/MelonTextView;", "getTvTitle", "()Lcom/iloen/melon/custom/MelonTextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class FooterViewHolder extends O0 {
            @NotNull
            private final MelonTextView tvTitle;

            public FooterViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ListenedSongAdapter.this = myMusicListenedSongFragment$ListenedSongAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
                q.f(view1, "findViewById(...)");
                this.tvTitle = (MelonTextView)view1;
            }

            @NotNull
            public final MelonTextView getTvTitle() {
                return this.tvTitle;
            }
        }

        private final int VIEW_TYPE_FOOTER;
        private final int VIEW_TYPE_SONG;
        @NotNull
        private String tvGuide;

        public ListenedSongAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicListenedSongFragment.this = myMusicListenedSongFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_SONG = 1;
            this.VIEW_TYPE_FOOTER = 2;
            this.tvGuide = "";
        }

        public static boolean a(MyMusicListenedSongFragment myMusicListenedSongFragment0, SongInfoBase songInfoBase0, ListenedSongAdapter myMusicListenedSongFragment$ListenedSongAdapter0, View view0) {
            return ListenedSongAdapter.onBindViewImpl$lambda$1(myMusicListenedSongFragment0, songInfoBase0, myMusicListenedSongFragment$ListenedSongAdapter0, view0);
        }

        public static void e(MyMusicListenedSongFragment myMusicListenedSongFragment0, int v, View view0) {
            ListenedSongAdapter.onBindViewImpl$lambda$0(myMusicListenedSongFragment0, v, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getFooterViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getFooterCount() <= 0 || v != this.getAvailableFooterPosition() ? this.VIEW_TYPE_SONG : this.VIEW_TYPE_FOOTER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            SongInfoBase songInfoBase0 = (SongInfoBase)this.getItem(v1);
            if(o00 instanceof SongHolder) {
                if(songInfoBase0 != null) {
                    SongHolder songHolder0 = (SongHolder)o00;
                    ViewUtils.setEnable(songHolder0.wrapperLayout, songInfoBase0.canService);
                    if(songInfoBase0.canService) {
                        ViewUtils.setOnClickListener(songHolder0.rootView, new J(MyMusicListenedSongFragment.this, v, 1));
                        if(this.isMarked(v1)) {
                            songHolder0.rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                        }
                        else {
                            songHolder0.rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                        }
                    }
                    else {
                        ViewUtils.setOnClickListener(songHolder0.rootView, null);
                        songHolder0.rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                    }
                    ViewUtils.setOnLongClickListener(songHolder0.rootView, new A(MyMusicListenedSongFragment.this, songInfoBase0, this, 3));
                    ImageView imageView0 = songHolder0.thumbnailIv;
                    if(imageView0 != null) {
                        Glide.with(imageView0.getContext()).load(songInfoBase0.albumImg).into(songHolder0.thumbnailIv);
                    }
                    ViewUtils.showWhen(songHolder0.btnPlay, songInfoBase0.canService);
                    ViewUtils.setOnClickListener(songHolder0.btnPlay, new Q(MyMusicListenedSongFragment.this, songInfoBase0, this, 0));
                    ViewUtils.showWhen(songHolder0.btnInfo, true);
                    ViewUtils.setOnClickListener(songHolder0.btnInfo, new Q(MyMusicListenedSongFragment.this, songInfoBase0, this, 1));
                    ViewUtils.setOnClickListener(songHolder0.thumbContainer, new e(4, songInfoBase0, MyMusicListenedSongFragment.this));
                    ViewUtils.setTextViewMarquee(songHolder0.titleTv, this.isMarqueeNeeded(v1));
                    songHolder0.titleTv.setText(songInfoBase0.songName);
                    songHolder0.artistTv.setText(ProtocolUtils.getArtistNames(songInfoBase0.artistList));
                    ViewUtils.showWhen(songHolder0.list19Iv, songInfoBase0.isAdult);
                    ViewUtils.showWhen(songHolder0.listFreeIv, songInfoBase0.isFree);
                    ViewUtils.showWhen(songHolder0.listHoldbackIv, songInfoBase0.isHoldback);
                }
            }
            else if(o00 instanceof FooterViewHolder) {
                if(!TextUtils.isEmpty(this.tvGuide)) {
                    ViewUtils.showWhen(((FooterViewHolder)o00).getTvTitle(), true);
                    ViewUtils.setText(((FooterViewHolder)o00).getTvTitle(), this.tvGuide);
                    return;
                }
                ViewUtils.hideWhen(((FooterViewHolder)o00).getTvTitle(), true);
            }
        }

        private static final void onBindViewImpl$lambda$0(MyMusicListenedSongFragment myMusicListenedSongFragment0, int v, View view0) {
            myMusicListenedSongFragment0.onItemClick(view0, v);
        }

        private static final boolean onBindViewImpl$lambda$1(MyMusicListenedSongFragment myMusicListenedSongFragment0, SongInfoBase songInfoBase0, ListenedSongAdapter myMusicListenedSongFragment$ListenedSongAdapter0, View view0) {
            myMusicListenedSongFragment0.showContextPopupSongOrInstantPlay(Playable.from(songInfoBase0, myMusicListenedSongFragment$ListenedSongAdapter0.getMenuId(), null));
            return true;
        }

        private static final void onBindViewImpl$lambda$2(MyMusicListenedSongFragment myMusicListenedSongFragment0, SongInfoBase songInfoBase0, ListenedSongAdapter myMusicListenedSongFragment$ListenedSongAdapter0, View view0) {
            myMusicListenedSongFragment0.playSong(Playable.from(songInfoBase0, myMusicListenedSongFragment$ListenedSongAdapter0.getMenuId(), null), true);
        }

        private static final void onBindViewImpl$lambda$3(MyMusicListenedSongFragment myMusicListenedSongFragment0, SongInfoBase songInfoBase0, ListenedSongAdapter myMusicListenedSongFragment$ListenedSongAdapter0, View view0) {
            myMusicListenedSongFragment0.showContextPopupSong(Playable.from(songInfoBase0, myMusicListenedSongFragment$ListenedSongAdapter0.getMenuId(), null));
        }

        private static final void onBindViewImpl$lambda$4(SongInfoBase songInfoBase0, MyMusicListenedSongFragment myMusicListenedSongFragment0, View view0) {
            if(!TextUtils.isEmpty(songInfoBase0.albumId)) {
                myMusicListenedSongFragment0.showAlbumInfoPage(songInfoBase0.albumId);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_FOOTER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D056F, viewGroup0, false);  // layout:mymusic_recent_last
                q.f(view0, "inflate(...)");
                return new FooterViewHolder(this, view0);
            }
            return new SongHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false));  // layout:listitem_song
        }

        public final void setGuideText(@NotNull String s) {
            q.g(s, "guide");
            this.tvGuide = s;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MyMusicListendSongFragment";
    private SortingBarView headerView;
    private boolean isItemEmpty;
    @NotNull
    private String memberKey;

    static {
        MyMusicListenedSongFragment.Companion = new Companion(null);
        MyMusicListenedSongFragment.$stable = 8;
    }

    public MyMusicListenedSongFragment() {
        this.memberKey = "";
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @NotNull
    public View buildParallaxHeaderView() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D085C, null, false);  // layout:sortbar_standalone
        q.f(view0, "inflate(...)");
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        return ToolBar.f(((ToolBar)view0), 1000);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new ListenedSongAdapter(this, context0, null);
        ((j)j00).setMarkedMode(true);
        ((j)j00).setListContentType(1);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.V.buildUpon().appendPath("song"), "targetMemberKey", this.memberKey, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 57.0f);
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        return this.isItemEmpty ? 0 : ScreenUtils.dipToPixel(this.getContext(), 57.0f);
    }

    private final void initHeaderView(View view0) {
        View view1 = view0.findViewById(0x7F0A0AB8);  // id:sort_bar
        q.f(view1, "findViewById(...)");
        this.headerView = (SortingBarView)view1;
        ((SortingBarView)view1).setSortBarStyle(0);
    }

    @NotNull
    public static final MyMusicListenedSongFragment newInstance(@NotNull String s) {
        return MyMusicListenedSongFragment.Companion.newInstance(s);
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

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        Params recentListSongRecntBaseReq$Params0 = new Params();
        recentListSongRecntBaseReq$Params0.targetMemberKey = this.memberKey;
        RequestBuilder.newInstance(new MyMusicRecentListSongRecntReq(this.getContext(), recentListSongRecntBaseReq$Params0)).tag("MyMusicListendSongFragment").listener(new g(this, i0, 19)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$4(MyMusicListenedSongFragment myMusicListenedSongFragment0, i i0, MyMusicRecentListSongRecntRes myMusicRecentListSongRecntRes0) {
        if(!myMusicListenedSongFragment0.prepareFetchComplete(myMusicRecentListSongRecntRes0)) {
            myMusicListenedSongFragment0.isItemEmpty = true;
            myMusicListenedSongFragment0.updateParallaxHeaderView();
            return;
        }
        RESPONSE recentListSongRecntResBase$RESPONSE0 = myMusicRecentListSongRecntRes0.response;
        if(recentListSongRecntResBase$RESPONSE0 != null) {
            myMusicListenedSongFragment0.mMelonTiaraProperty = new s(recentListSongRecntResBase$RESPONSE0.section, recentListSongRecntResBase$RESPONSE0.page, recentListSongRecntResBase$RESPONSE0.menuId, null);
            if((recentListSongRecntResBase$RESPONSE0.songlist == null ? 0 : recentListSongRecntResBase$RESPONSE0.songlist.size()) > 0) {
                myMusicListenedSongFragment0.isItemEmpty = false;
                j0 j00 = myMusicListenedSongFragment0.mAdapter;
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicListenedSongFragment.ListenedSongAdapter");
                String s = myMusicRecentListSongRecntRes0.response.guidetext;
                q.f(s, "guidetext");
                ((ListenedSongAdapter)j00).setGuideText(s);
                myMusicListenedSongFragment0.setAllCheckButtonVisibility(true);
            }
        }
        myMusicListenedSongFragment0.performFetchComplete(i0, myMusicRecentListSongRecntRes0);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.setSelectAllWithToolbar(false);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argMemberKey");
        if(s == null) {
            s = "";
        }
        this.memberKey = s;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argMemberKey", this.memberKey);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.getTitleBar().setVisibility(8);
        this.initHeaderView(view0);
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        boolean z = false;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
        if(this.getItemCount() > 0) {
            z = true;
        }
        this.setAllCheckButtonVisibility(z);
    }

    private final void setAllCheckButtonVisibility(boolean z) {
        if(z) {
            SortingBarView sortingBarView0 = this.headerView;
            if(sortingBarView0 != null) {
                sortingBarView0.setOnCheckedListener(new P(this));
                SortingBarView sortingBarView1 = this.headerView;
                if(sortingBarView1 != null) {
                    P p0 = new P(this);
                    sortingBarView1.c(L.b, p0);
                    return;
                }
                q.m("headerView");
                throw null;
            }
            q.m("headerView");
            throw null;
        }
        SortingBarView sortingBarView2 = this.headerView;
        if(sortingBarView2 != null) {
            sortingBarView2.setOnCheckedListener(null);
            SortingBarView sortingBarView3 = this.headerView;
            if(sortingBarView3 != null) {
                sortingBarView3.setLeftButton(null);
                SortingBarView sortingBarView4 = this.headerView;
                if(sortingBarView4 != null) {
                    sortingBarView4.setRightLayout(null);
                    return;
                }
                q.m("headerView");
                throw null;
            }
            q.m("headerView");
            throw null;
        }
        q.m("headerView");
        throw null;
    }

    private static final void setAllCheckButtonVisibility$lambda$5(MyMusicListenedSongFragment myMusicListenedSongFragment0, S s0, boolean z) {
        myMusicListenedSongFragment0.toggleSelectAll();
    }

    private static final void setAllCheckButtonVisibility$lambda$6(MyMusicListenedSongFragment myMusicListenedSongFragment0, View view0) {
        myMusicListenedSongFragment0.playAll();
    }
}

