package com.iloen.melon.fragments.artistchannel.viewholder;

import Cb.j;
import De.I;
import J8.J1;
import J8.Y;
import Tf.v;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.upstream.cache.a;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.c;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.O;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.artistchannel.ArtistDetailContentsSongFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.ArtistMusicRecmtrackSongListReq;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.RECMTRACKLIST.SONGINFO;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.RECMTRACKLIST;
import com.iloen.melon.net.v6x.response.ArtistMusicRecmtrackSongListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.template.TemplateData.ArtistMixDataBuilder;
import com.iloen.melon.utils.template.TemplateImageLoader;
import com.kakao.tiara.data.ActionKind;
import e.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import va.e;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 $2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0003$%&B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001A\u00020\u00102\u0012\u0010\u0016\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u001C\u0010\u001D\u001A\b\u0018\u00010\u001CR\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0016\u0010\u001F\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0016\u0010!\u001A\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001A\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006\'"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$RECMTRACKLIST;", "LJ8/Y;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/Y;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder$ViewHolder;", "vh", "item", "", "position", "Lie/H;", "bindItem", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder$ViewHolder;Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$RECMTRACKLIST;I)V", "", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder$InnerRecyclerAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder$InnerRecyclerAdapter;", "holderBind", "LJ8/Y;", "artistId", "Ljava/lang/String;", "artistName", "Companion", "InnerRecyclerAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistRecommendTrackHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder$Companion;", "", "<init>", "()V", "TAG", "", "TALKBACK_ACTION_DEFAULT", "", "TALKBACK_ACTION_MOVE_DETAIL", "TALKBACK_ACTION_PLAYBACK", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistRecommendTrackHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0215, viewGroup0, false);  // layout:detail_item_artist_recommend_track
            int v = 0x7F0A07CA;  // id:main_contents_title
            MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
            if(mainTabTitleView0 != null) {
                v = 0x7F0A09CF;  // id:recycler_horizontal
                RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09CF);  // id:recycler_horizontal
                if(recyclerView0 != null) {
                    return new ArtistRecommendTrackHolder(new Y(((LinearLayout)view0), recyclerView0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001B\u0010\u0011\u001A\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder$InnerRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/c;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$RECMTRACKLIST;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder$ViewHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder;Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder$ViewHolder;", "Lie/H;", "setItems", "(Ljava/util/List;)V", "vh", "initViewHolder", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder$ViewHolder;)V", "rawPosition", "position", "onBindViewHolder", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder$ViewHolder;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerRecyclerAdapter extends c {
        public InnerRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        public void initViewHolder(O0 o00) {
            this.initViewHolder(((ViewHolder)o00));
        }

        public void initViewHolder(@NotNull ViewHolder artistRecommendTrackHolder$ViewHolder0) {
            q.g(artistRecommendTrackHolder$ViewHolder0, "vh");
            artistRecommendTrackHolder$ViewHolder0.getBind().b.setImageBitmap(null);
            artistRecommendTrackHolder$ViewHolder0.getBind().c.setText("");
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((ViewHolder)o00), v, v1);
        }

        public void onBindViewHolder(@NotNull ViewHolder artistRecommendTrackHolder$ViewHolder0, int v, int v1) {
            q.g(artistRecommendTrackHolder$ViewHolder0, "vh");
            this.initViewHolder(artistRecommendTrackHolder$ViewHolder0);
            RECMTRACKLIST artistHomeContentsRes$RESPONSE$RECMTRACKLIST0 = (RECMTRACKLIST)this.getItem(v1);
            ArtistRecommendTrackHolder.this.bindItem(artistRecommendTrackHolder$ViewHolder0, artistHomeContentsRes$RESPONSE$RECMTRACKLIST0, v1);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = o.e(viewGroup0, 0x7F0D0479, viewGroup0, false);  // layout:listitem_detail_artist_recommend_track
            int v1 = 0x7F0A0355;  // id:cover_view
            CoverView coverView0 = (CoverView)I.C(view0, 0x7F0A0355);  // id:cover_view
            if(coverView0 != null) {
                v1 = 0x7F0A0D34;  // id:tv_title
                MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0D34);  // id:tv_title
                if(melonTextView0 != null) {
                    return new ViewHolder(new J1(((RelativeLayout)view0), coverView0, melonTextView0));
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
        }

        public final void setItems(@NotNull List list0) {
            q.g(list0, "list");
            this.clear(false);
            this.addAll(list0);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistRecommendTrackHolder$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/J1;", "listitemDetailArtistRecommendTrackBinding", "<init>", "(LJ8/J1;)V", "bind", "LJ8/J1;", "getBind", "()LJ8/J1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ViewHolder extends O0 {
        @NotNull
        private final J1 bind;

        public ViewHolder(@NotNull J1 j10) {
            q.g(j10, "listitemDetailArtistRecommendTrackBinding");
            super(j10.a);
            this.bind = j10;
        }

        @NotNull
        public final J1 getBind() {
            return this.bind;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ArtistRecommendTrackHolder";
    private static final int TALKBACK_ACTION_DEFAULT = 100000000;
    private static final int TALKBACK_ACTION_MOVE_DETAIL = 100000001;
    private static final int TALKBACK_ACTION_PLAYBACK = 100000002;
    private String artistId;
    private String artistName;
    @NotNull
    private Y holderBind;
    @Nullable
    private InnerRecyclerAdapter innerAdapter;
    @Nullable
    private RecyclerView recyclerView;

    static {
        ArtistRecommendTrackHolder.Companion = new Companion(null);
        ArtistRecommendTrackHolder.$stable = 8;
    }

    public ArtistRecommendTrackHolder(@NotNull Y y0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(y0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(y0, onViewHolderActionBaseListener0);
        this.holderBind = y0;
        this.setTitleView(y0.b);
        this.recyclerView = this.holderBind.c;
        this.holderBind.c.setHasFixedSize(true);
        RecyclerView recyclerView0 = this.recyclerView;
        if(recyclerView0 != null) {
            recyclerView0.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView1 = this.recyclerView;
        if(recyclerView1 != null) {
            recyclerView1.addItemDecoration(new O(11.0f));
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if(recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(0, false));
        }
        this.innerAdapter = new InnerRecyclerAdapter(this, this.getContext(), null);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final void bindItem(ViewHolder artistRecommendTrackHolder$ViewHolder0, RECMTRACKLIST artistHomeContentsRes$RESPONSE$RECMTRACKLIST0, int v) {
        String s2;
        String s = null;
        SONGINFO artistHomeContentsRes$RESPONSE$RECMTRACKLIST$SONGINFO0 = artistHomeContentsRes$RESPONSE$RECMTRACKLIST0 == null ? null : artistHomeContentsRes$RESPONSE$RECMTRACKLIST0.songInfo;
        CoverView coverView0 = artistRecommendTrackHolder$ViewHolder0.getBind().b;
        String s1 = "";
        if("A003".equals((artistHomeContentsRes$RESPONSE$RECMTRACKLIST0 == null ? null : artistHomeContentsRes$RESPONSE$RECMTRACKLIST0.categoryCode))) {
            if(artistHomeContentsRes$RESPONSE$RECMTRACKLIST$SONGINFO0 == null) {
                s2 = "";
            }
            else {
                s2 = artistHomeContentsRes$RESPONSE$RECMTRACKLIST$SONGINFO0.mainArtistName;
                if(s2 == null) {
                    s2 = "";
                }
            }
            if(artistHomeContentsRes$RESPONSE$RECMTRACKLIST$SONGINFO0 != null) {
                String s3 = artistHomeContentsRes$RESPONSE$RECMTRACKLIST$SONGINFO0.mainArtistImg;
                if(s3 != null) {
                    s1 = s3;
                }
            }
            new TemplateImageLoader(new ArtistMixDataBuilder(coverView0, s2, k.e(new String[]{s1}), (artistHomeContentsRes$RESPONSE$RECMTRACKLIST$SONGINFO0 == null ? null : artistHomeContentsRes$RESPONSE$RECMTRACKLIST$SONGINFO0.coverImgPath), "32", false, null, 0x60, null).build()).load(new l(artistRecommendTrackHolder$ViewHolder0));
        }
        else {
            coverView0.b(false);
            q.d(Glide.with(coverView0).load((artistHomeContentsRes$RESPONSE$RECMTRACKLIST$SONGINFO0 == null ? null : artistHomeContentsRes$RESPONSE$RECMTRACKLIST$SONGINFO0.albumImgPath)).into(coverView0.getThumbnailView()));
        }
        MelonTextView melonTextView0 = artistRecommendTrackHolder$ViewHolder0.getBind().c;
        if(artistHomeContentsRes$RESPONSE$RECMTRACKLIST0 != null) {
            s = artistHomeContentsRes$RESPONSE$RECMTRACKLIST0.categoryName;
        }
        melonTextView0.setText(s);
        m m0 = new m(this, artistHomeContentsRes$RESPONSE$RECMTRACKLIST0, v, 0);
        artistRecommendTrackHolder$ViewHolder0.getBind().a.setOnClickListener(m0);
        m m1 = new m(this, artistHomeContentsRes$RESPONSE$RECMTRACKLIST0, v, 1);
        artistRecommendTrackHolder$ViewHolder0.getBind().b.getPlayButtonView().setOnClickListener(m1);
        com.iloen.melon.fragments.artistchannel.viewholder.ArtistRecommendTrackHolder.bindItem.4 artistRecommendTrackHolder$bindItem$40 = new View.AccessibilityDelegate() {
            @Override  // android.view.View$AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                q.g(view0, "host");
                q.g(accessibilityNodeInfo0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, e.c(artistRecommendTrackHolder$ViewHolder0.getString(0x7F130B04), " ", artistRecommendTrackHolder$ViewHolder0.getString(0x7F130C82))));  // string:talkback_content_type_song "곡"
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, artistRecommendTrackHolder$ViewHolder0.getString(0x7F130C59)));  // string:talkback_songlist_song_play "재생"
                accessibilityNodeInfo0.setContentDescription(this.$vh.getBind().c.getText());
                accessibilityNodeInfo0.setClassName("android.widget.Button");
            }

            @Override  // android.view.View$AccessibilityDelegate
            public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                q.g(view0, "host");
                switch(v) {
                    case 100000001: {
                        this.$vh.getBind().a.performClick();
                        return true;
                    }
                    case 100000002: {
                        this.$vh.getBind().b.getPlayButtonView().performClick();
                        return true;
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        };
        artistRecommendTrackHolder$ViewHolder0.getBind().a.setAccessibilityDelegate(artistRecommendTrackHolder$bindItem$40);
    }

    private static final void bindItem$lambda$2$lambda$1(ViewHolder artistRecommendTrackHolder$ViewHolder0, Bitmap bitmap0) {
        q.g(bitmap0, "it");
        artistRecommendTrackHolder$ViewHolder0.getBind().b.setImageBitmap(bitmap0);
    }

    private static final void bindItem$lambda$4(ArtistRecommendTrackHolder artistRecommendTrackHolder0, RECMTRACKLIST artistHomeContentsRes$RESPONSE$RECMTRACKLIST0, int v, View view0) {
        com.iloen.melon.fragments.artistchannel.ArtistDetailContentsSongFragment.Companion artistDetailContentsSongFragment$Companion0 = ArtistDetailContentsSongFragment.Companion;
        String s = artistRecommendTrackHolder0.artistId;
        String s1 = null;
        if(s != null) {
            String s2 = artistRecommendTrackHolder0.artistName;
            if(s2 != null) {
                Navigator.open(artistDetailContentsSongFragment$Companion0.newInstance(s, s2, "TR", (artistHomeContentsRes$RESPONSE$RECMTRACKLIST0 == null ? null : artistHomeContentsRes$RESPONSE$RECMTRACKLIST0.categoryCode)));
                f f0 = artistRecommendTrackHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
                if(f0 != null) {
                    f0.a = artistRecommendTrackHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.y = artistRecommendTrackHolder0.getString(0x7F130CDD);  // string:tiara_artist_layer1_recommend_track "추천트랙"
                    if(artistHomeContentsRes$RESPONSE$RECMTRACKLIST0 != null) {
                        s1 = artistHomeContentsRes$RESPONSE$RECMTRACKLIST0.categoryName;
                    }
                    f0.F = s1;
                    f0.c(v + 1);
                    f0.a().track();
                }
                return;
            }
            q.m("artistName");
            throw null;
        }
        q.m("artistId");
        throw null;
    }

    private static final void bindItem$lambda$9(ArtistRecommendTrackHolder artistRecommendTrackHolder0, RECMTRACKLIST artistHomeContentsRes$RESPONSE$RECMTRACKLIST0, int v, View view0) {
        Context context0 = artistRecommendTrackHolder0.getContext();
        String s = artistRecommendTrackHolder0.artistId;
        String s1 = null;
        if(s != null) {
            RequestBuilder.newInstance(new ArtistMusicRecmtrackSongListReq(context0, s, (artistHomeContentsRes$RESPONSE$RECMTRACKLIST0 == null ? null : artistHomeContentsRes$RESPONSE$RECMTRACKLIST0.categoryCode))).tag("ArtistRecommendTrackHolder").listener(new l(artistRecommendTrackHolder0)).errorListener(new a(12)).request();
            f f0 = artistRecommendTrackHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
            if(f0 != null) {
                f0.a = artistRecommendTrackHolder0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                f0.d = ActionKind.PlayMusic;
                f0.y = artistRecommendTrackHolder0.getString(0x7F130CDD);  // string:tiara_artist_layer1_recommend_track "추천트랙"
                if(artistHomeContentsRes$RESPONSE$RECMTRACKLIST0 != null) {
                    String s2 = artistHomeContentsRes$RESPONSE$RECMTRACKLIST0.categoryName;
                    if(s2 != null) {
                        s1 = v.p0(s2, " ", "");
                    }
                }
                f0.F = s1;
                f0.c(v + 1);
                f0.a().track();
            }
            return;
        }
        q.m("artistId");
        throw null;
    }

    private static final void bindItem$lambda$9$lambda$6(ArtistRecommendTrackHolder artistRecommendTrackHolder0, ArtistMusicRecmtrackSongListRes artistMusicRecmtrackSongListRes0) {
        j.b(artistMusicRecmtrackSongListRes0.notification, false, 3);
        if(j.d(artistMusicRecmtrackSongListRes0)) {
            ArrayList arrayList0 = artistMusicRecmtrackSongListRes0.response == null ? null : artistMusicRecmtrackSongListRes0.response.songList;
            if(arrayList0 != null && !arrayList0.isEmpty() == 1) {
                ArrayList arrayList1 = Playable.getListFromSongBaseArrayOnlyCanService(arrayList0, artistRecommendTrackHolder0.getMenuId(), null);
                q.d(arrayList1);
                artistRecommendTrackHolder0.getOnViewHolderActionListener().onPlaySongsListener(arrayList1, true);
            }
        }
    }

    private static final void bindItem$lambda$9$lambda$7(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    public static void d(VolleyError volleyError0) {
        ArtistRecommendTrackHolder.bindItem$lambda$9$lambda$7(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130132);  // string:artist_detail_recommend_track "추천 트랙"
    }

    @NotNull
    public static final ArtistRecommendTrackHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistRecommendTrackHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        String s = adapterInViewHolder$Row0.getContentId();
        q.f(s, "getContentId(...)");
        this.artistId = s;
        String s1 = adapterInViewHolder$Row0.getContentOwner();
        q.f(s1, "getContentOwner(...)");
        this.artistName = s1;
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(false);
        }
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        if(list0 != null && !q.b((this.innerAdapter == null ? null : this.innerAdapter.getList()), list0)) {
            RecyclerView recyclerView0 = this.recyclerView;
            if(recyclerView0 != null) {
                recyclerView0.setAdapter(this.innerAdapter);
            }
            InnerRecyclerAdapter artistRecommendTrackHolder$InnerRecyclerAdapter0 = this.innerAdapter;
            if(artistRecommendTrackHolder$InnerRecyclerAdapter0 != null) {
                artistRecommendTrackHolder$InnerRecyclerAdapter0.setItems(list0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

