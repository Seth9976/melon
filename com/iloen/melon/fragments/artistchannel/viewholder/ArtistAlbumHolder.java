package com.iloen.melon.fragments.artistchannel.viewholder;

import De.I;
import J8.H1;
import J8.U;
import J8.f3;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.c;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.O;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.artistchannel.ArtistDetailContentsAlbumFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.ALBUMLIST;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import va.e;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 $2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0003$%&B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001A\u00020\u00102\u0012\u0010\u0016\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u0019\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0018\u0010\u001D\u001A\u0004\u0018\u00010\u001C8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u001C\u0010 \u001A\b\u0018\u00010\u001FR\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006\'"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$ALBUMLIST;", "LJ8/U;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/U;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder$ViewHolder;", "vh", "item", "", "position", "Lie/H;", "bindItem", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder$ViewHolder;Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$ALBUMLIST;I)V", "", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "clickLog", "itemClickLog", "(Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder$InnerRecyclerAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder$InnerRecyclerAdapter;", "holderBind", "LJ8/U;", "Companion", "InnerRecyclerAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistAlbumHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder$Companion;", "", "<init>", "()V", "TAG", "", "TALKBACK_ACTION_DEFAULT", "", "TALKBACK_ACTION_ALBUM_DETAIL", "TALKBACK_ACTION_PLAYBACK", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistAlbumHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new ArtistAlbumHolder(U.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001B\u0010\u0011\u001A\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder$InnerRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/c;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$ALBUMLIST;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder$ViewHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder;Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder$ViewHolder;", "Lie/H;", "setItems", "(Ljava/util/List;)V", "vh", "initViewHolder", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder$ViewHolder;)V", "rawPosition", "position", "onBindViewHolder", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder$ViewHolder;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerRecyclerAdapter extends c {
        public InnerRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        public void initViewHolder(O0 o00) {
            this.initViewHolder(((ViewHolder)o00));
        }

        public void initViewHolder(@NotNull ViewHolder artistAlbumHolder$ViewHolder0) {
            q.g(artistAlbumHolder$ViewHolder0, "vh");
            artistAlbumHolder$ViewHolder0.getBind().d.b.setImageDrawable(null);
            artistAlbumHolder$ViewHolder0.getBind().g.setText("");
            artistAlbumHolder$ViewHolder0.getBind().b.setText("");
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((ViewHolder)o00), v, v1);
        }

        public void onBindViewHolder(@NotNull ViewHolder artistAlbumHolder$ViewHolder0, int v, int v1) {
            q.g(artistAlbumHolder$ViewHolder0, "vh");
            this.initViewHolder(artistAlbumHolder$ViewHolder0);
            ALBUMLIST artistHomeContentsRes$RESPONSE$ALBUMLIST0 = (ALBUMLIST)this.getItem(v1);
            ArtistAlbumHolder.this.bindItem(artistAlbumHolder$ViewHolder0, artistHomeContentsRes$RESPONSE$ALBUMLIST0, v1);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = o.e(viewGroup0, 0x7F0D0477, viewGroup0, false);  // layout:listitem_detail_artist_album
            int v1 = 0x7F0A00B8;  // id:artist_name
            View view1 = I.C(view0, 0x7F0A00B8);  // id:artist_name
            if(((MelonTextView)view1) != null) {
                v1 = 0x7F0A048C;  // id:famous_album_iv
                View view2 = I.C(view0, 0x7F0A048C);  // id:famous_album_iv
                if(((ImageView)view2) != null) {
                    v1 = 0x7F0A056B;  // id:include_thumbnail_layout
                    View view3 = I.C(view0, 0x7F0A056B);  // id:include_thumbnail_layout
                    if(view3 != null) {
                        f3 f30 = f3.a(view3);
                        v1 = 0x7F0A05B7;  // id:item_layout
                        View view4 = I.C(view0, 0x7F0A05B7);  // id:item_layout
                        if(((RelativeLayout)view4) != null) {
                            v1 = 0x7F0A091D;  // id:play_button
                            View view5 = I.C(view0, 0x7F0A091D);  // id:play_button
                            if(((ImageView)view5) != null) {
                                v1 = 0x7F0A0B8D;  // id:title
                                View view6 = I.C(view0, 0x7F0A0B8D);  // id:title
                                if(((MelonTextView)view6) != null) {
                                    return new ViewHolder(new H1(((FrameLayout)view0), ((MelonTextView)view1), ((ImageView)view2), f30, ((RelativeLayout)view4), ((ImageView)view5), ((MelonTextView)view6)));
                                }
                            }
                        }
                    }
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/H1;", "listitemDetailArtistAlbumBinding", "<init>", "(LJ8/H1;)V", "bind", "LJ8/H1;", "getBind", "()LJ8/H1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ViewHolder extends O0 {
        @NotNull
        private final H1 bind;

        public ViewHolder(@NotNull H1 h10) {
            q.g(h10, "listitemDetailArtistAlbumBinding");
            super(h10.a);
            this.bind = h10;
        }

        @NotNull
        public final H1 getBind() {
            return this.bind;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "ArtistAlbumHolder";
    private static final int TALKBACK_ACTION_ALBUM_DETAIL = 100000001;
    private static final int TALKBACK_ACTION_DEFAULT = 100000000;
    private static final int TALKBACK_ACTION_PLAYBACK = 100000002;
    @NotNull
    private U holderBind;
    @Nullable
    private InnerRecyclerAdapter innerAdapter;
    @Nullable
    private RecyclerView recyclerView;

    static {
        ArtistAlbumHolder.Companion = new Companion(null);
        ArtistAlbumHolder.$stable = 8;
    }

    public ArtistAlbumHolder(@NotNull U u0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(u0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(u0, onViewHolderActionBaseListener0);
        this.holderBind = u0;
        this.setTitleView(u0.b);
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

    public static void b(ArtistAlbumHolder artistAlbumHolder0, ALBUMLIST artistHomeContentsRes$RESPONSE$ALBUMLIST0, int v, View view0) {
        ArtistAlbumHolder.bindItem$lambda$3(artistHomeContentsRes$RESPONSE$ALBUMLIST0, artistAlbumHolder0, v, view0);
    }

    private final void bindItem(ViewHolder artistAlbumHolder$ViewHolder0, ALBUMLIST artistHomeContentsRes$RESPONSE$ALBUMLIST0, int v) {
        boolean z1;
        MelonImageView melonImageView0 = artistAlbumHolder$ViewHolder0.getBind().d.b;
        String s = null;
        Glide.with(melonImageView0).load((artistHomeContentsRes$RESPONSE$ALBUMLIST0 == null ? null : artistHomeContentsRes$RESPONSE$ALBUMLIST0.albumImg)).into(melonImageView0);
        boolean z = false;
        if(artistHomeContentsRes$RESPONSE$ALBUMLIST0 == null) {
            z1 = false;
        }
        else {
            Boolean boolean0 = artistHomeContentsRes$RESPONSE$ALBUMLIST0.isMasterPiece;
            z1 = boolean0 == null ? false : boolean0.booleanValue();
        }
        ViewUtils.showWhen(artistAlbumHolder$ViewHolder0.getBind().c, z1);
        artistAlbumHolder$ViewHolder0.getBind().g.setText((artistHomeContentsRes$RESPONSE$ALBUMLIST0 == null ? null : artistHomeContentsRes$RESPONSE$ALBUMLIST0.albumName));
        MelonTextView melonTextView0 = artistAlbumHolder$ViewHolder0.getBind().b;
        if(artistHomeContentsRes$RESPONSE$ALBUMLIST0 != null) {
            s = artistHomeContentsRes$RESPONSE$ALBUMLIST0.getArtistNames();
        }
        melonTextView0.setText(s);
        if(artistHomeContentsRes$RESPONSE$ALBUMLIST0 != null) {
            z = artistHomeContentsRes$RESPONSE$ALBUMLIST0.canService;
        }
        ViewUtils.setEnable(artistAlbumHolder$ViewHolder0.getBind().e, z);
        ViewUtils.showWhen(artistAlbumHolder$ViewHolder0.getBind().f, z);
        a a0 = new a(artistHomeContentsRes$RESPONSE$ALBUMLIST0, this, v);
        artistAlbumHolder$ViewHolder0.getBind().a.setOnClickListener(a0);
        a a1 = new a(this, artistHomeContentsRes$RESPONSE$ALBUMLIST0, v);
        artistAlbumHolder$ViewHolder0.getBind().f.setOnClickListener(a1);
        com.iloen.melon.fragments.artistchannel.viewholder.ArtistAlbumHolder.bindItem.4 artistAlbumHolder$bindItem$40 = new View.AccessibilityDelegate() {
            @Override  // android.view.View$AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                q.g(view0, "host");
                q.g(accessibilityNodeInfo0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, artistHomeContentsRes$RESPONSE$ALBUMLIST0.getString(0x7F130C54)));  // string:talkback_songlist_album_info "앨범 정보"
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, artistHomeContentsRes$RESPONSE$ALBUMLIST0.getString(0x7F130C59)));  // string:talkback_songlist_song_play "재생"
                String s = (artistAlbumHolder$ViewHolder0 == null ? false : q.b(artistAlbumHolder$ViewHolder0.isMasterPiece, Boolean.TRUE)) ? e.h(artistHomeContentsRes$RESPONSE$ALBUMLIST0.getString(0x7F130B77), ", ") : "";  // string:talkback_masterpiece "명반"
                String s1 = null;
                String s2 = artistAlbumHolder$ViewHolder0 == null ? null : artistAlbumHolder$ViewHolder0.albumName;
                String s3 = artistHomeContentsRes$RESPONSE$ALBUMLIST0.getString(0x7F1300FC);  // string:artist "아티스트"
                ALBUMLIST artistHomeContentsRes$RESPONSE$ALBUMLIST0 = artistAlbumHolder$ViewHolder0;
                if(artistHomeContentsRes$RESPONSE$ALBUMLIST0 != null) {
                    s1 = artistHomeContentsRes$RESPONSE$ALBUMLIST0.getArtistNames();
                }
                StringBuilder stringBuilder0 = com.iloen.melon.utils.a.o(s, s2, ", ", s3, " : ");
                stringBuilder0.append(s1);
                accessibilityNodeInfo0.setContentDescription(stringBuilder0.toString());
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
                        this.$vh.getBind().f.performClick();
                        return true;
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        };
        artistAlbumHolder$ViewHolder0.getBind().a.setAccessibilityDelegate(artistAlbumHolder$bindItem$40);
        com.iloen.melon.fragments.artistchannel.viewholder.ArtistAlbumHolder.bindItem.5 artistAlbumHolder$bindItem$50 = new View.AccessibilityDelegate() {
            @Override  // android.view.View$AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                q.g(view0, "host");
                q.g(accessibilityNodeInfo0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, artistHomeContentsRes$RESPONSE$ALBUMLIST0.getString(0x7F130C54)));  // string:talkback_songlist_album_info "앨범 정보"
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, artistHomeContentsRes$RESPONSE$ALBUMLIST0.getString(0x7F130C59)));  // string:talkback_songlist_song_play "재생"
                String s = (artistAlbumHolder$ViewHolder0 == null ? false : q.b(artistAlbumHolder$ViewHolder0.isMasterPiece, Boolean.TRUE)) ? e.h(artistHomeContentsRes$RESPONSE$ALBUMLIST0.getString(0x7F130B77), ", ") : "";  // string:talkback_masterpiece "명반"
                String s1 = null;
                String s2 = artistAlbumHolder$ViewHolder0 == null ? null : artistAlbumHolder$ViewHolder0.albumName;
                String s3 = artistHomeContentsRes$RESPONSE$ALBUMLIST0.getString(0x7F1300FC);  // string:artist "아티스트"
                ALBUMLIST artistHomeContentsRes$RESPONSE$ALBUMLIST0 = artistAlbumHolder$ViewHolder0;
                if(artistHomeContentsRes$RESPONSE$ALBUMLIST0 != null) {
                    s1 = artistHomeContentsRes$RESPONSE$ALBUMLIST0.getArtistNames();
                }
                StringBuilder stringBuilder0 = com.iloen.melon.utils.a.o(s, s2, ", ", s3, " : ");
                stringBuilder0.append(s1);
                accessibilityNodeInfo0.setContentDescription(stringBuilder0.toString());
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
                        this.$vh.getBind().f.performClick();
                        return true;
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        };
        artistAlbumHolder$ViewHolder0.getBind().a.setAccessibilityDelegate(artistAlbumHolder$bindItem$50);
    }

    private static final void bindItem$lambda$3(ALBUMLIST artistHomeContentsRes$RESPONSE$ALBUMLIST0, ArtistAlbumHolder artistAlbumHolder0, int v, View view0) {
        String s = null;
        Navigator.openAlbumInfo((artistHomeContentsRes$RESPONSE$ALBUMLIST0 == null ? null : artistHomeContentsRes$RESPONSE$ALBUMLIST0.albumId));
        f f0 = artistAlbumHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistAlbumHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = artistAlbumHolder0.getString(0x7F130DD5);  // string:tiara_common_layer1_album "앨범"
            f0.c(v + 1);
            f0.e = artistHomeContentsRes$RESPONSE$ALBUMLIST0 == null ? null : artistHomeContentsRes$RESPONSE$ALBUMLIST0.albumId;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            if(artistHomeContentsRes$RESPONSE$ALBUMLIST0 != null) {
                s = artistHomeContentsRes$RESPONSE$ALBUMLIST0.albumName;
            }
            f0.g = s;
            f0.a().track();
        }
    }

    private static final void bindItem$lambda$5(ArtistAlbumHolder artistAlbumHolder0, ALBUMLIST artistHomeContentsRes$RESPONSE$ALBUMLIST0, int v, View view0) {
        String s = null;
        artistAlbumHolder0.getOnViewHolderActionListener().onPlayAlbumListener((artistHomeContentsRes$RESPONSE$ALBUMLIST0 == null ? null : artistHomeContentsRes$RESPONSE$ALBUMLIST0.albumId));
        f f0 = artistAlbumHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistAlbumHolder0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = artistAlbumHolder0.getString(0x7F130DD5);  // string:tiara_common_layer1_album "앨범"
            f0.c(v + 1);
            f0.e = artistHomeContentsRes$RESPONSE$ALBUMLIST0 == null ? null : artistHomeContentsRes$RESPONSE$ALBUMLIST0.albumId;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            if(artistHomeContentsRes$RESPONSE$ALBUMLIST0 != null) {
                s = artistHomeContentsRes$RESPONSE$ALBUMLIST0.albumName;
            }
            f0.g = s;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130053);  // string:album "앨범"
    }

    public void itemClickLog(@NotNull String s) {
        q.g(s, "clickLog");
    }

    @NotNull
    public static final ArtistAlbumHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistAlbumHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(true);
        }
        MainTabTitleView mainTabTitleView2 = this.getTitleView();
        if(mainTabTitleView2 != null) {
            mainTabTitleView2.setOnEventListener(new SimpleEventListener() {
                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onViewAllButtonClick(View view0) {
                    q.g(view0, "view");
                    String s = this.getContentId();
                    q.f(s, "getContentId(...)");
                    String s1 = this.getContentOwner();
                    q.f(s1, "getContentOwner(...)");
                    Navigator.open(ArtistDetailContentsAlbumFragment.Companion.newInstance(s, s1));
                    f f0 = ArtistAlbumHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = ArtistAlbumHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = ArtistAlbumHolder.this.getString(0x7F130DD5);  // string:tiara_common_layer1_album "앨범"
                        f0.F = ArtistAlbumHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f0.a().track();
                    }
                }
            });
        }
        if(list0 != null && !q.b((this.innerAdapter == null ? null : this.innerAdapter.getList()), list0)) {
            RecyclerView recyclerView0 = this.recyclerView;
            if(recyclerView0 != null) {
                recyclerView0.setAdapter(this.innerAdapter);
            }
            InnerRecyclerAdapter artistAlbumHolder$InnerRecyclerAdapter0 = this.innerAdapter;
            if(artistAlbumHolder$InnerRecyclerAdapter0 != null) {
                artistAlbumHolder$InnerRecyclerAdapter0.setItems(list0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

