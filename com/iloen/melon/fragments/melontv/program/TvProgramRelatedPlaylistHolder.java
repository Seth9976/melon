package com.iloen.melon.fragments.melontv.program;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.o;
import com.iloen.melon.custom.O;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.fragments.main.common.TabItemViewHolder;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE.PLAYLISTINFO.PLAYLIST;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE.PLAYLISTINFO;
import com.iloen.melon.utils.TalkbackUtilKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001F2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0003\u001F !B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001D\u0010\u0014\u001A\u00020\u00102\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u001C\u0010\u001D\u001A\b\u0018\u00010\u001CR\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001E¨\u0006\""}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder;", "Lcom/iloen/melon/fragments/main/common/TabItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/ProgramHomeRes$RESPONSE$PLAYLISTINFO;", "Landroid/view/View;", "itemView", "Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "listner", "<init>", "(Landroid/view/View;Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;)V", "Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder$ViewHolder;", "viewHolder", "Lcom/iloen/melon/net/v6x/response/ProgramHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST;", "item", "", "position", "Lie/H;", "bindItem", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder$ViewHolder;Lcom/iloen/melon/net/v6x/response/ProgramHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST;I)V", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "getListner", "()Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder$InnerRecyclerAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder$InnerRecyclerAdapter;", "Companion", "InnerRecyclerAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TvProgramRelatedPlaylistHolder extends TabItemViewHolder {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder$Companion;", "", "<init>", "()V", "TAG", "", "TALKBACK_ACTION_DEFAULT", "", "TALKBACK_ACTION_SHOW_PLAYLIST_DETAIL", "TALKBACK_ACTION_PLAY_PLAYLIST", "newInstance", "Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder;", "parent", "Landroid/view/ViewGroup;", "onActionListener", "Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TvProgramRelatedPlaylistHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull TvProgramItemClickListener tvProgramHomeFragment$TvProgramItemClickListener0) {
            q.g(viewGroup0, "parent");
            q.g(tvProgramHomeFragment$TvProgramItemClickListener0, "onActionListener");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D08C9, viewGroup0, false);  // layout:tvprogram_home_related_playlist_layout
            q.d(view0);
            return new TvProgramRelatedPlaylistHolder(view0, tvProgramHomeFragment$TvProgramItemClickListener0);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001B\u0010\u0011\u001A\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001B\u001A\u00020\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder$InnerRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/o;", "Lcom/iloen/melon/net/v6x/response/ProgramHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST;", "Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder$ViewHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder;Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder$ViewHolder;", "Lie/H;", "setItems", "(Ljava/util/List;)V", "viewHolder", "initViewHolder", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder$ViewHolder;)V", "rawPosition", "position", "onBindViewHolder", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder$ViewHolder;II)V", "Landroid/view/LayoutInflater;", "mInflater", "Landroid/view/LayoutInflater;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerRecyclerAdapter extends o {
        @NotNull
        private final LayoutInflater mInflater;

        public InnerRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            LayoutInflater layoutInflater0 = LayoutInflater.from(context0);
            q.f(layoutInflater0, "from(...)");
            this.mInflater = layoutInflater0;
        }

        public void initViewHolder(O0 o00) {
            this.initViewHolder(((ViewHolder)o00));
        }

        public void initViewHolder(@NotNull ViewHolder tvProgramRelatedPlaylistHolder$ViewHolder0) {
            q.g(tvProgramRelatedPlaylistHolder$ViewHolder0, "viewHolder");
            tvProgramRelatedPlaylistHolder$ViewHolder0.getThumbnail().setImageDrawable(null);
            tvProgramRelatedPlaylistHolder$ViewHolder0.getTitle().setText("");
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((ViewHolder)o00), v, v1);
        }

        public void onBindViewHolder(@NotNull ViewHolder tvProgramRelatedPlaylistHolder$ViewHolder0, int v, int v1) {
            q.g(tvProgramRelatedPlaylistHolder$ViewHolder0, "viewHolder");
            this.initViewHolder(tvProgramRelatedPlaylistHolder$ViewHolder0);
            PLAYLIST programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0 = (PLAYLIST)this.getItem(v1);
            TvProgramRelatedPlaylistHolder.this.bindItem(tvProgramRelatedPlaylistHolder$ViewHolder0, programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0, v1);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = this.mInflater.inflate(0x7F0D0477, viewGroup0, false);  // layout:listitem_detail_artist_album
            q.f(view0, "inflate(...)");
            return new ViewHolder(view0);
        }

        public final void setItems(@NotNull List list0) {
            q.g(list0, "list");
            this.clear(false);
            this.addAll(list0);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001A\u0004\b\u0011\u0010\u000FR\u0017\u0010\u0012\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramRelatedPlaylistHolder$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "thumbnail", "Landroid/widget/ImageView;", "getThumbnail", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "artist", "getArtist", "playBtn", "Landroid/view/View;", "getPlayBtn", "()Landroid/view/View;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ViewHolder extends O0 {
        @NotNull
        private final TextView artist;
        @NotNull
        private final View playBtn;
        @NotNull
        private final ImageView thumbnail;
        @NotNull
        private final TextView title;

        public ViewHolder(@NotNull View view0) {
            q.g(view0, "itemView");
            super(view0);
            View view1 = view0.findViewById(0x7F0A069A);  // id:iv_thumb
            q.f(view1, "findViewById(...)");
            this.thumbnail = (ImageView)view1;
            View view2 = view0.findViewById(0x7F0A0B8D);  // id:title
            q.f(view2, "findViewById(...)");
            this.title = (TextView)view2;
            View view3 = view0.findViewById(0x7F0A00B8);  // id:artist_name
            q.f(view3, "findViewById(...)");
            this.artist = (TextView)view3;
            View view4 = view0.findViewById(0x7F0A091D);  // id:play_button
            q.f(view4, "findViewById(...)");
            this.playBtn = view4;
        }

        @NotNull
        public final TextView getArtist() {
            return this.artist;
        }

        @NotNull
        public final View getPlayBtn() {
            return this.playBtn;
        }

        @NotNull
        public final ImageView getThumbnail() {
            return this.thumbnail;
        }

        @NotNull
        public final TextView getTitle() {
            return this.title;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "TvProgramRelatedPlaylistHolder";
    private static final int TALKBACK_ACTION_DEFAULT = 200000000;
    private static final int TALKBACK_ACTION_PLAY_PLAYLIST = 200000002;
    private static final int TALKBACK_ACTION_SHOW_PLAYLIST_DETAIL = 200000001;
    @Nullable
    private InnerRecyclerAdapter innerAdapter;
    @NotNull
    private final TvProgramItemClickListener listner;
    @Nullable
    private RecyclerView recyclerView;

    static {
        TvProgramRelatedPlaylistHolder.Companion = new Companion(null);
        TvProgramRelatedPlaylistHolder.$stable = 8;
    }

    public TvProgramRelatedPlaylistHolder(@NotNull View view0, @NotNull TvProgramItemClickListener tvProgramHomeFragment$TvProgramItemClickListener0) {
        q.g(view0, "itemView");
        q.g(tvProgramHomeFragment$TvProgramItemClickListener0, "listner");
        super(view0);
        this.listner = tvProgramHomeFragment$TvProgramItemClickListener0;
        RecyclerView recyclerView0 = (RecyclerView)view0.findViewById(0x7F0A09CF);  // id:recycler_horizontal
        this.recyclerView = recyclerView0;
        if(recyclerView0 != null) {
            recyclerView0.setHasFixedSize(true);
        }
        RecyclerView recyclerView1 = this.recyclerView;
        if(recyclerView1 != null) {
            recyclerView1.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if(recyclerView2 != null) {
            recyclerView2.addItemDecoration(new O());  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        RecyclerView recyclerView3 = this.recyclerView;
        if(recyclerView3 != null) {
            recyclerView3.setLayoutManager(new LinearLayoutManager(0, false));
        }
        view0.addOnAttachStateChangeListener(this);
        this.innerAdapter = new InnerRecyclerAdapter(this, this.getContext(), null);
    }

    private final void bindItem(ViewHolder tvProgramRelatedPlaylistHolder$ViewHolder0, PLAYLIST programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0, int v) {
        Context context0 = this.getContext();
        if(context0 != null && programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0 != null) {
            Glide.with(context0).load(programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0.thumbimg).into(tvProgramRelatedPlaylistHolder$ViewHolder0.getThumbnail());
            tvProgramRelatedPlaylistHolder$ViewHolder0.getTitle().setText(programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0.plylsttitle);
            tvProgramRelatedPlaylistHolder$ViewHolder0.getArtist().setText(programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0.ownernickname);
            u u0 = new u(this, programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0, v, 0);
            tvProgramRelatedPlaylistHolder$ViewHolder0.itemView.setOnClickListener(u0);
            tvProgramRelatedPlaylistHolder$ViewHolder0.getPlayBtn().setOnClickListener(new u(this, programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0, v, 1));
            com.iloen.melon.fragments.melontv.program.TvProgramRelatedPlaylistHolder.bindItem.1.1.3 tvProgramRelatedPlaylistHolder$bindItem$1$1$30 = new View.AccessibilityDelegate() {
                @Override  // android.view.View$AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                    q.g(view0, "host");
                    q.g(accessibilityNodeInfo0, "info");
                    super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                    String s = null;
                    accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(200000001, (programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0.getContext() == null ? null : "플레이리스트 상세보기")));
                    accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(200000002, (programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0.getContext() == null ? null : "플레이리스트 재생하기")));
                    Context context0 = programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0.getContext();
                    String s1 = TalkbackUtilKt.getTalkbackInfo(v, context0);
                    if(programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0.getContext() != null) {
                        s = "상세보기";
                    }
                    accessibilityNodeInfo0.setContentDescription(s1 + ", " + s);
                    accessibilityNodeInfo0.setClassName("android.widget.Button");
                }

                @Override  // android.view.View$AccessibilityDelegate
                public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                    q.g(view0, "host");
                    switch(v) {
                        case 200000001: {
                            programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0.getListner().onClickRelatedPlaylistItemView(v, this.$position);
                            return true;
                        }
                        case 200000002: {
                            programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0.getListner().onPlayRelatedPlaylist(v, this.$position);
                            return true;
                        }
                        default: {
                            return super.performAccessibilityAction(view0, v, bundle0);
                        }
                    }
                }
            };
            tvProgramRelatedPlaylistHolder$ViewHolder0.itemView.setAccessibilityDelegate(tvProgramRelatedPlaylistHolder$bindItem$1$1$30);
        }
    }

    private static final void bindItem$lambda$4$lambda$3$lambda$1(TvProgramRelatedPlaylistHolder tvProgramRelatedPlaylistHolder0, PLAYLIST programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0, int v, View view0) {
        tvProgramRelatedPlaylistHolder0.listner.onClickRelatedPlaylistItemView(programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0, v);
    }

    private static final void bindItem$lambda$4$lambda$3$lambda$2(TvProgramRelatedPlaylistHolder tvProgramRelatedPlaylistHolder0, PLAYLIST programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0, int v, View view0) {
        tvProgramRelatedPlaylistHolder0.listner.onPlayRelatedPlaylist(programHomeRes$RESPONSE$PLAYLISTINFO$PLAYLIST0, v);
    }

    @NotNull
    public final TvProgramItemClickListener getListner() {
        return this.listner;
    }

    @NotNull
    public static final TvProgramRelatedPlaylistHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull TvProgramItemClickListener tvProgramHomeFragment$TvProgramItemClickListener0) {
        return TvProgramRelatedPlaylistHolder.Companion.newInstance(viewGroup0, tvProgramHomeFragment$TvProgramItemClickListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        String s;
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        PLAYLISTINFO programHomeRes$RESPONSE$PLAYLISTINFO0 = (PLAYLISTINFO)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            if(programHomeRes$RESPONSE$PLAYLISTINFO0 == null) {
                s = "";
            }
            else {
                s = programHomeRes$RESPONSE$PLAYLISTINFO0.title;
                if(s == null) {
                    s = "";
                }
            }
            mainTabTitleView0.setTitle(s);
        }
        if(programHomeRes$RESPONSE$PLAYLISTINFO0 != null) {
            ArrayList arrayList0 = programHomeRes$RESPONSE$PLAYLISTINFO0.list;
            if(arrayList0 != null && !q.b((this.innerAdapter == null ? null : this.innerAdapter.getList()), arrayList0)) {
                RecyclerView recyclerView0 = this.recyclerView;
                if(recyclerView0 != null) {
                    recyclerView0.setAdapter(this.innerAdapter);
                }
                InnerRecyclerAdapter tvProgramRelatedPlaylistHolder$InnerRecyclerAdapter0 = this.innerAdapter;
                if(tvProgramRelatedPlaylistHolder$InnerRecyclerAdapter0 != null) {
                    tvProgramRelatedPlaylistHolder$InnerRecyclerAdapter0.setItems(arrayList0);
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.main.common.TabItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

