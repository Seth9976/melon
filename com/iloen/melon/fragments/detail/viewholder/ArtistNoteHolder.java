package com.iloen.melon.fragments.detail.viewholder;

import A7.d;
import J8.I;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.AlbumDetailContentsArtistNoteFragment;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v6x.response.AlbumInfoRes.RESPONSE.ARTISTNOTEINFO;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import p8.f;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\f\u001A\u00020\u000B2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0011\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/ArtistNoteHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/AlbumInfoRes$RESPONSE$ARTISTNOTEINFO;", "LJ8/I;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/I;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "", "getTitleName", "()Ljava/lang/String;", "holderBind", "LJ8/I;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistNoteHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/ArtistNoteHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/ArtistNoteHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistNoteHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new ArtistNoteHolder(I.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "ArtistNoteHolder";
    @NotNull
    private I holderBind;

    static {
        ArtistNoteHolder.Companion = new Companion(null);
        ArtistNoteHolder.$stable = 8;
    }

    public ArtistNoteHolder(@NotNull I i0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(i0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(i0, onViewHolderActionBaseListener0);
        this.holderBind = i0;
        this.setTitleView(i0.c);
        ViewUtils.setDefaultImage(this.holderBind.d.c, ScreenUtils.dipToPixel(this.getContext(), 85.0f), true);
        this.holderBind.d.b.setBorderWidth(ScreenUtils.dipToPixel(this.getContext(), 0.5f));
        this.holderBind.d.b.setBorderColor(ColorUtils.getColor(this.getContext(), 0x7F06014A));  // color:gray100a
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130056);  // string:album_detail_artist_note "아티스트 노트"
    }

    @NotNull
    public static final ArtistNoteHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistNoteHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        ARTISTNOTEINFO albumInfoRes$RESPONSE$ARTISTNOTEINFO0 = (ARTISTNOTEINFO)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(adapterInViewHolder$Row0.isViewAll());
        }
        MainTabTitleView mainTabTitleView2 = this.getTitleView();
        if(mainTabTitleView2 != null) {
            mainTabTitleView2.setOnEventListener(new SimpleEventListener() {
                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onViewAllButtonClick(View view0) {
                    q.g(view0, "view");
                    Navigator.open(AlbumDetailContentsArtistNoteFragment.Companion.newInstance(this.getContentId()));
                    f f0 = ArtistNoteHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = ArtistNoteHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = ArtistNoteHolder.this.getString(0x7F130DE4);  // string:tiara_common_layer1_artist_note "아티스트노트"
                        f0.F = ArtistNoteHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f0.a().track();
                    }
                }
            });
        }
        Glide.with(this.holderBind.d.b).load(albumInfoRes$RESPONSE$ARTISTNOTEINFO0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(this.holderBind.d.b);
        this.holderBind.e.setText(albumInfoRes$RESPONSE$ARTISTNOTEINFO0.getArtistName());
        this.holderBind.f.setText(albumInfoRes$RESPONSE$ARTISTNOTEINFO0.issueDate);
        this.holderBind.g.setText(albumInfoRes$RESPONSE$ARTISTNOTEINFO0.artistNote);
        String s = this.getString(0x7F130AD2);  // string:talkback_artist "아티스트"
        String s1 = this.getString(0x7F130C85);  // string:talkback_written_date "작성일"
        String s2 = albumInfoRes$RESPONSE$ARTISTNOTEINFO0.issueDate;
        String s3 = albumInfoRes$RESPONSE$ARTISTNOTEINFO0.artistNote;
        String s4 = d.n(a.o(s, " ", albumInfoRes$RESPONSE$ARTISTNOTEINFO0.getArtistName(), " ", s1), " ", s2, " ", s3);
        ViewUtils.setContentDescriptionWithClassName(this.holderBind.b, s4, null, null);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

