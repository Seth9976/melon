package com.iloen.melon.fragments.artistchannel.viewholder;

import De.I;
import J8.B1;
import J8.n;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.GridLayout.LayoutParams;
import android.widget.GridLayout.Spec;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.artistchannel.ArtistDetailContentsPhotoFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PHOTO;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
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

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u00172\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001A\u00020\u000F2\u0012\u0010\u000E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001A\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoGridHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;", "LJ8/n;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/n;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Landroid/widget/GridLayout;", "gridLayout", "Landroid/widget/GridLayout;", "holderBind", "LJ8/n;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistPhotoGridHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoGridHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoGridHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistPhotoGridHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D003C, viewGroup0, false);  // layout:artist_detail_photo_grid
            int v = 0x7F0A05A7;  // id:item_container
            GridLayout gridLayout0 = (GridLayout)I.C(view0, 0x7F0A05A7);  // id:item_container
            if(gridLayout0 != null) {
                v = 0x7F0A07CA;  // id:main_contents_title
                MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                if(mainTabTitleView0 != null) {
                    return new ArtistPhotoGridHolder(new n(((LinearLayout)view0), gridLayout0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "ArtistPhotoLinearHolder";
    @Nullable
    private GridLayout gridLayout;
    @NotNull
    private n holderBind;

    static {
        ArtistPhotoGridHolder.Companion = new Companion(null);
        ArtistPhotoGridHolder.$stable = 8;
    }

    public ArtistPhotoGridHolder(@NotNull n n0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(n0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(n0, onViewHolderActionBaseListener0);
        this.holderBind = n0;
        this.setTitleView(n0.c);
        GridLayout gridLayout0 = this.holderBind.b;
        gridLayout0.removeAllViews();
        this.gridLayout = gridLayout0;
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F1302F9);  // string:detail_common_title_photo "포토"
    }

    @NotNull
    public static final ArtistPhotoGridHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistPhotoGridHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
            mainTabTitleView0.setTitleClickable(true);
            mainTabTitleView0.setOnEventListener(new SimpleEventListener() {
                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onViewAllButtonClick(View view0) {
                    q.g(view0, "view");
                    Navigator.open(ArtistDetailContentsPhotoFragment.Companion.newInstance(this.getContentId()));
                    f f0 = ArtistPhotoGridHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = ArtistPhotoGridHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = ArtistPhotoGridHolder.this.getString(0x7F130E03);  // string:tiara_common_layer1_photo "포토"
                        f0.F = ArtistPhotoGridHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f0.a().track();
                    }
                }
            });
        }
        int v = (ScreenUtils.getScreenWidth(this.getContext()) - ScreenUtils.dipToPixel(this.getContext(), 48.0f)) / 3;
        int v1 = ScreenUtils.isPortrait(this.getContext()) ? v : ScreenUtils.dipToPixel(this.getContext(), 104.0f);
        int v2 = ScreenUtils.dipToPixel(this.getContext(), 4.0f);
        GridLayout gridLayout0 = this.gridLayout;
        if(gridLayout0 != null) {
            gridLayout0.removeAllViews();
        }
        for(int v3 = 0; v3 < 6; ++v3) {
            B1 b10 = B1.a(LayoutInflater.from(this.getContext()), this.gridLayout);
            ConstraintLayout constraintLayout0 = b10.a;
            ImageView imageView0 = b10.b.c;
            MelonImageView melonImageView0 = b10.b.b;
            Context context0 = this.getContext();
            if(context0 != null) {
                Glide.with(context0).load(((PHOTO)list0.get(v3)).photoImg).into(melonImageView0);
            }
            melonImageView0.setOnClickListener(new Ad.n(list0, v3, this, 9));
            melonImageView0.setContentDescription(melonImageView0.getContext().getString(0x7F130BB3, new Object[]{((PHOTO)list0.get(v3)).photoName}));  // string:talkback_photo_item "%1$s, 포토, 상세보기"
            GridLayout.Spec gridLayout$Spec0 = GridLayout.spec(0x80000000, 1);
            GridLayout.Spec gridLayout$Spec1 = GridLayout.spec(0x80000000, 2);
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = constraintLayout0.getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.widget.GridLayout.LayoutParams");
            GridLayout.LayoutParams gridLayout$LayoutParams0 = (GridLayout.LayoutParams)viewGroup$LayoutParams0;
            if(v3 == 0) {
                gridLayout$LayoutParams0.columnSpec = gridLayout$Spec1;
                gridLayout$LayoutParams0.rowSpec = gridLayout$Spec1;
                int v4 = v * 2 + v2;
                gridLayout$LayoutParams0.width = v4;
                gridLayout$LayoutParams0.height = v1 * 2 + v2;
                ViewUtils.setDefaultImage(imageView0, v4);
            }
            else {
                gridLayout$LayoutParams0.columnSpec = gridLayout$Spec0;
                gridLayout$LayoutParams0.rowSpec = gridLayout$Spec0;
                gridLayout$LayoutParams0.width = v;
                gridLayout$LayoutParams0.height = v1;
                ViewUtils.setDefaultImage(imageView0, v);
            }
            switch(v3) {
                case 0: {
                    gridLayout$LayoutParams0.setMarginEnd(v2);
                    gridLayout$LayoutParams0.bottomMargin = v2;
                    break;
                }
                case 1: 
                case 2: {
                    gridLayout$LayoutParams0.bottomMargin = v2;
                    break;
                }
                case 3: {
                    gridLayout$LayoutParams0.setMarginEnd(v2);
                    break;
                }
                default: {
                    if(v3 == 4) {
                        gridLayout$LayoutParams0.setMarginEnd(v2);
                    }
                }
            }
            GridLayout gridLayout1 = this.gridLayout;
            if(gridLayout1 != null) {
                gridLayout1.addView(constraintLayout0, gridLayout$LayoutParams0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final void onBindView$lambda$5$lambda$4(List list0, int v, ArtistPhotoGridHolder artistPhotoGridHolder0, View view0) {
        String s = ((PHOTO)list0.get(v)).photoId;
        Navigator.INSTANCE.openPhotoInfo(s);
        f f0 = artistPhotoGridHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistPhotoGridHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = artistPhotoGridHolder0.getString(0x7F130E03);  // string:tiara_common_layer1_photo "포토"
            f0.c(v + 1);
            f0.e = ((PHOTO)list0.get(v)).photoId;
            f0.f = Y.i(ContsTypeCode.PHOTO, "code(...)");
            f0.g = ((PHOTO)list0.get(v)).photoName;
            f0.a().track();
        }
    }
}

