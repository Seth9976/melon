package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.e2;
import J8.y0;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.o;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.O;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.ProgramDetailFragment;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.CastList;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.OtherCastInfo;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001D2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0003\u001D\u001E\u001FB\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0011\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0013\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000F\u0010\u0015\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001D\u0010\u0018\u001A\u00020\n2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001B\u001A\u0004\u0018\u00010\u001A8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/OtherCastHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$OtherCastInfo;", "LJ8/y0;", "binding", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/y0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lie/H;", "showAllClickLog", "()V", "Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$CastList;", "cast", "", "position", "castClickLog", "(Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$CastList;I)V", "castPlayClickLog", "", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "InnerRecyclerAdapter", "ItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class OtherCastHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/OtherCastHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/OtherCastHolder;", "parent", "Landroid/view/ViewGroup;", "actionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final OtherCastHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "actionListener");
            View view0 = o.e(viewGroup0, 0x7F0D0237, viewGroup0, false);  // layout:detail_station_episode_other_cast
            int v = 0x7F0A07CA;  // id:main_contents_title
            MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
            if(mainTabTitleView0 != null) {
                v = 0x7F0A09CF;  // id:recycler_horizontal
                RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09CF);  // id:recycler_horizontal
                if(recyclerView0 != null) {
                    return new OtherCastHolder(new y0(((LinearLayout)view0), recyclerView0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00040\u0001B!\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000F\u001A\u00060\u0003R\u00020\u00042\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J-\u0010\u0015\u001A\u00020\u00142\f\u0010\u0011\u001A\b\u0018\u00010\u0003R\u00020\u00042\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/OtherCastHolder$InnerRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/y;", "Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$CastList;", "Lcom/iloen/melon/fragments/detail/viewholder/OtherCastHolder$ItemViewHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/OtherCastHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/detail/viewholder/OtherCastHolder;Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/detail/viewholder/OtherCastHolder$ItemViewHolder;", "viewHolder", "rawPosition", "position", "Lie/H;", "onBindViewHolder", "(Lcom/iloen/melon/fragments/detail/viewholder/OtherCastHolder$ItemViewHolder;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerRecyclerAdapter extends y {
        public InnerRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((ItemViewHolder)o00), v, v1);
        }

        public void onBindViewHolder(@Nullable ItemViewHolder otherCastHolder$ItemViewHolder0, int v, int v1) {
            if(otherCastHolder$ItemViewHolder0 != null) {
                e2 e20 = otherCastHolder$ItemViewHolder0.getBinding();
                if(e20 != null) {
                    CastList castEpsdDetailRes$Response$CastList0 = (CastList)this.getItem(v1);
                    e20.d.setText(castEpsdDetailRes$Response$CastList0.castTitle);
                    Glide.with(this.getContext()).load(castEpsdDetailRes$Response$CastList0.verticalImgUrl).into(e20.c);
                    t t0 = new t(OtherCastHolder.this, castEpsdDetailRes$Response$CastList0, v1, 0);
                    ViewUtils.setOnClickListener(e20.b, t0);
                    t t1 = new t(OtherCastHolder.this, castEpsdDetailRes$Response$CastList0, v1, 1);
                    ViewUtils.setOnClickListener(e20.a, t1);
                }
            }
        }

        private static final void onBindViewHolder$lambda$2$lambda$0(OtherCastHolder otherCastHolder0, CastList castEpsdDetailRes$Response$CastList0, int v, View view0) {
            otherCastHolder0.getOnViewHolderActionListener().onPlayRadioCast(castEpsdDetailRes$Response$CastList0.castSeq);
            otherCastHolder0.castPlayClickLog(castEpsdDetailRes$Response$CastList0, v);
        }

        private static final void onBindViewHolder$lambda$2$lambda$1(OtherCastHolder otherCastHolder0, CastList castEpsdDetailRes$Response$CastList0, int v, View view0) {
            otherCastHolder0.getOnViewHolderActionListener().onOpenCastEpisodeDetailView(castEpsdDetailRes$Response$CastList0.castSeq);
            otherCastHolder0.castClickLog(castEpsdDetailRes$Response$CastList0, v);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public ItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            OtherCastHolder otherCastHolder0 = OtherCastHolder.this;
            View view0 = o.e(viewGroup0, 0x7F0D04A3, viewGroup0, false);  // layout:listitem_radio_cast_vertical
            int v1 = 0x7F0A065F;  // id:iv_play
            ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A065F);  // id:iv_play
            if(imageView0 != null && ((ImageView)I.C(view0, 0x7F0A0694)) != null) {  // id:iv_station_logo
                v1 = 0x7F0A069A;  // id:iv_thumb
                MelonImageView melonImageView0 = (MelonImageView)I.C(view0, 0x7F0A069A);  // id:iv_thumb
                if(melonImageView0 != null && ((ImageView)I.C(view0, 0x7F0A069E)) != null) {  // id:iv_thumb_default
                    v1 = 0x7F0A0D34;  // id:tv_title
                    MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0D34);  // id:tv_title
                    if(melonTextView0 != null) {
                        return new ItemViewHolder(otherCastHolder0, new e2(((ConstraintLayout)view0), imageView0, melonImageView0, melonTextView0));
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/OtherCastHolder$ItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/e2;", "binding", "<init>", "(Lcom/iloen/melon/fragments/detail/viewholder/OtherCastHolder;LJ8/e2;)V", "LJ8/e2;", "getBinding", "()LJ8/e2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ItemViewHolder extends O0 {
        @NotNull
        private final e2 binding;

        public ItemViewHolder(@NotNull e2 e20) {
            q.g(e20, "binding");
            OtherCastHolder.this = otherCastHolder0;
            super(e20.a);
            this.binding = e20;
        }

        @NotNull
        public final e2 getBinding() {
            return this.binding;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private RecyclerView recyclerView;

    static {
        OtherCastHolder.Companion = new Companion(null);
        OtherCastHolder.$stable = 8;
    }

    public OtherCastHolder(@NotNull y0 y00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(y00, "binding");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(y00, onViewHolderActionBaseListener0);
        this.setTitleView(y00.b);
        this.recyclerView = y00.c;
        y00.c.setHasFixedSize(true);
        y00.c.setNestedScrollingEnabled(false);
        O o0 = new O(12.0f);
        y00.c.addItemDecoration(o0);
        y00.c.getContext();
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(0, false);
        y00.c.setLayoutManager(linearLayoutManager0);
    }

    private final void castClickLog(CastList castEpsdDetailRes$Response$CastList0, int v) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F131004);  // string:tiara_station_layer1_other_cast "다른회차듣기"
            f0.c(v + 1);
            f0.E = castEpsdDetailRes$Response$CastList0.verticalImgUrl;
            f0.e = castEpsdDetailRes$Response$CastList0.castSeq;
            f0.f = "N10082";
            f0.g = castEpsdDetailRes$Response$CastList0.castTitle;
            f0.k = castEpsdDetailRes$Response$CastList0.progTitle;
            f0.l = castEpsdDetailRes$Response$CastList0.progSeq;
            f0.a().track();
        }
    }

    private final void castPlayClickLog(CastList castEpsdDetailRes$Response$CastList0, int v) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = this.getString(0x7F131004);  // string:tiara_station_layer1_other_cast "다른회차듣기"
            f0.c(v + 1);
            f0.E = castEpsdDetailRes$Response$CastList0.verticalImgUrl;
            f0.e = castEpsdDetailRes$Response$CastList0.castSeq;
            f0.f = "N10082";
            f0.g = castEpsdDetailRes$Response$CastList0.castTitle;
            f0.k = castEpsdDetailRes$Response$CastList0.progTitle;
            f0.l = castEpsdDetailRes$Response$CastList0.progSeq;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        OtherCastInfo castEpsdDetailRes$Response$OtherCastInfo0 = (OtherCastInfo)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(castEpsdDetailRes$Response$OtherCastInfo0.title);
            mainTabTitleView0.setTitleClickable(adapterInViewHolder$Row0.isViewAll());
            mainTabTitleView0.setOnEventListener(new SimpleEventListener() {
                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onViewAllButtonClick(View view0) {
                    q.g(view0, "view");
                    String s = this.getContentId();
                    q.f(s, "getContentId(...)");
                    Navigator.open(ProgramDetailFragment.Companion.newInstance(s));
                    OtherCastHolder.this.showAllClickLog();
                }
            });
        }
        ArrayList arrayList0 = castEpsdDetailRes$Response$OtherCastInfo0.castList;
        if(arrayList0 != null) {
            RecyclerView recyclerView0 = this.recyclerView;
            if(recyclerView0 != null) {
                recyclerView0.setAdapter(new InnerRecyclerAdapter(this, this.getContext(), arrayList0));
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private final void showAllClickLog() {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F131004);  // string:tiara_station_layer1_other_cast "다른회차듣기"
            f0.F = this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
            f0.a().track();
        }
    }
}

