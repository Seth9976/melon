package com.iloen.melon.fragments.artistchannel.viewholder;

import De.I;
import J8.V;
import J8.x1;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.artistchannel.ArtistDetailContentsArtistNoteFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.response.DetailBaseRes.ARTISTNOTE;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import e.k;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import p8.f;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\b\u0017\u0018\u0000 \u001C2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001\u001CB\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000B\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0015\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0018\u001A\u00020\u00112\u0012\u0010\u0017\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001A\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistArtistNoteHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ARTISTNOTE;", "LJ8/V;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/V;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "item", "", "index", "LJ8/x1;", "bindItem", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ARTISTNOTE;I)LJ8/x1;", "Lie/H;", "trackTiaraArtistNoteClick", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ARTISTNOTE;I)V", "", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "holderBind", "LJ8/V;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistArtistNoteHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistArtistNoteHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistArtistNoteHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistArtistNoteHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D020E, viewGroup0, false);  // layout:detail_item_artist_artist_note
            int v = 0x7F0A05A7;  // id:item_container
            LinearLayout linearLayout0 = (LinearLayout)I.C(view0, 0x7F0A05A7);  // id:item_container
            if(linearLayout0 != null) {
                v = 0x7F0A07CA;  // id:main_contents_title
                MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                if(mainTabTitleView0 != null) {
                    return new ArtistArtistNoteHolder(new V(((LinearLayout)view0), linearLayout0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "ArtistArtistNoteHolder";
    @NotNull
    private V holderBind;

    static {
        ArtistArtistNoteHolder.Companion = new Companion(null);
        ArtistArtistNoteHolder.$stable = 8;
    }

    public ArtistArtistNoteHolder(@NotNull V v0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(v0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(v0, onViewHolderActionBaseListener0);
        this.holderBind = v0;
        this.setTitleView(v0.c);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    public static void a(ArtistArtistNoteHolder artistArtistNoteHolder0, ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v, View view0) {
        ArtistArtistNoteHolder.bindItem$lambda$4(detailBaseRes$ARTISTNOTE0, artistArtistNoteHolder0, v, view0);
    }

    public static void b(ArtistArtistNoteHolder artistArtistNoteHolder0, ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v, View view0) {
        ArtistArtistNoteHolder.bindItem$lambda$6(detailBaseRes$ARTISTNOTE0, artistArtistNoteHolder0, v, view0);
    }

    private final x1 bindItem(ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v) {
        x1 x10 = x1.a(LayoutInflater.from(this.getContext()), null);
        int v1 = ScreenUtils.dipToPixel(this.getContext(), 96.0f);
        ViewUtils.setDefaultImage(x10.c.c, v1);
        Glide.with(x10.c.b).load(detailBaseRes$ARTISTNOTE0.albumImg).into(x10.c.b);
        b b0 = new b(this, detailBaseRes$ARTISTNOTE0, v);
        x10.e.setOnClickListener(b0);
        x10.f.setText(detailBaseRes$ARTISTNOTE0.albumName);
        x10.b.setText(detailBaseRes$ARTISTNOTE0.artistNote);
        b b1 = new b(detailBaseRes$ARTISTNOTE0, this, v, 1);
        x10.c.a.setOnClickListener(b1);
        b b2 = new b(detailBaseRes$ARTISTNOTE0, this, v, 2);
        x10.f.setOnClickListener(b2);
        b b3 = new b(detailBaseRes$ARTISTNOTE0, this, v, 3);
        x10.b.setOnClickListener(b3);
        return x10;
    }

    private static final void bindItem$lambda$3(ArtistArtistNoteHolder artistArtistNoteHolder0, ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v, View view0) {
        artistArtistNoteHolder0.getOnViewHolderActionListener().onPlayAlbumListener(detailBaseRes$ARTISTNOTE0.albumId);
        f f0 = artistArtistNoteHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistArtistNoteHolder0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = artistArtistNoteHolder0.getString(0x7F130DE4);  // string:tiara_common_layer1_artist_note "아티스트노트"
            f0.c(v + 1);
            f0.e = detailBaseRes$ARTISTNOTE0.albumId;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            f0.g = detailBaseRes$ARTISTNOTE0.albumName;
            f0.a().track();
        }
    }

    private static final void bindItem$lambda$4(ARTISTNOTE detailBaseRes$ARTISTNOTE0, ArtistArtistNoteHolder artistArtistNoteHolder0, int v, View view0) {
        Navigator.openAlbumInfo(detailBaseRes$ARTISTNOTE0.albumId);
        artistArtistNoteHolder0.trackTiaraArtistNoteClick(detailBaseRes$ARTISTNOTE0, v);
    }

    private static final void bindItem$lambda$5(ARTISTNOTE detailBaseRes$ARTISTNOTE0, ArtistArtistNoteHolder artistArtistNoteHolder0, int v, View view0) {
        Navigator.openAlbumInfo(detailBaseRes$ARTISTNOTE0.albumId);
        artistArtistNoteHolder0.trackTiaraArtistNoteClick(detailBaseRes$ARTISTNOTE0, v);
    }

    private static final void bindItem$lambda$6(ARTISTNOTE detailBaseRes$ARTISTNOTE0, ArtistArtistNoteHolder artistArtistNoteHolder0, int v, View view0) {
        Navigator.openAlbumInfo(detailBaseRes$ARTISTNOTE0.albumId);
        artistArtistNoteHolder0.trackTiaraArtistNoteClick(detailBaseRes$ARTISTNOTE0, v);
    }

    public static void c(ArtistArtistNoteHolder artistArtistNoteHolder0, ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v, View view0) {
        ArtistArtistNoteHolder.bindItem$lambda$5(detailBaseRes$ARTISTNOTE0, artistArtistNoteHolder0, v, view0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130128);  // string:artist_detail_contents_artist_note_title "아티스트 노트"
    }

    @NotNull
    public static final ArtistArtistNoteHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistArtistNoteHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
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
                    Navigator.open(ArtistDetailContentsArtistNoteFragment.Companion.newInstance(this.getContentId(), this.getContentOwner()));
                    f f0 = ArtistArtistNoteHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = ArtistArtistNoteHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = ArtistArtistNoteHolder.this.getString(0x7F130DE4);  // string:tiara_common_layer1_artist_note "아티스트노트"
                        f0.F = ArtistArtistNoteHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f0.a().track();
                    }
                }
            });
        }
        if(this.holderBind.b.getChildCount() <= 0 && list0 != null) {
            int v = 0;
            for(Object object0: list0) {
                if(v >= 0) {
                    x1 x10 = this.bindItem(((ARTISTNOTE)object0), v);
                    this.holderBind.b.addView(x10.a);
                    ++v;
                    continue;
                }
                k.O();
                throw null;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private final void trackTiaraArtistNoteClick(ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F130DE4);  // string:tiara_common_layer1_artist_note "아티스트노트"
            f0.c(v + 1);
            f0.e = detailBaseRes$ARTISTNOTE0.albumId;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            f0.g = detailBaseRes$ARTISTNOTE0.albumName;
            f0.a().track();
        }
    }
}

