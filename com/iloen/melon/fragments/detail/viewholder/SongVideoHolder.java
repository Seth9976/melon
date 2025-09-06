package com.iloen.melon.fragments.detail.viewholder;

import J8.k0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.SongDetailContentsMvFragment;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.response.DetailBaseRes.VIDEO;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0010\u001A\u00020\u000F2\u0012\u0010\u000E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000BH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001A\u00020\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongVideoHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/VideoHolder;", "LJ8/k0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/k0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "getTitleName", "()Ljava/lang/String;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$VIDEO;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "item", "", "index", "itemClickLog", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$VIDEO;I)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongVideoHolder extends VideoHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongVideoHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/SongVideoHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SongVideoHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new SongVideoHolder(k0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "SongVideoHolder";

    static {
        SongVideoHolder.Companion = new Companion(null);
        SongVideoHolder.$stable = 8;
    }

    public SongVideoHolder(@NotNull k0 k00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(k00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(k00, onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.VideoHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130A8D);  // string:song_detail_title_video "이 곡의 비디오"
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.VideoHolder
    public void itemClickLog(@Nullable VIDEO detailBaseRes$VIDEO0, int v) {
        String s1;
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DCC);  // string:tiara_common_action_name_play_video "영상재생"
            f0.d = ActionKind.PlayVideo;
            f0.y = this.getString(0x7F130E19);  // string:tiara_common_layer1_song_video "이곡의비디오"
            f0.c(v + 1);
            String s = "";
            if(detailBaseRes$VIDEO0 == null) {
                s1 = "";
            }
            else {
                s1 = detailBaseRes$VIDEO0.mvId;
                if(s1 == null) {
                    s1 = "";
                }
            }
            f0.e = s1;
            f0.f = Y.i(ContsTypeCode.VIDEO, "code(...)");
            if(detailBaseRes$VIDEO0 != null) {
                String s2 = detailBaseRes$VIDEO0.mvName;
                if(s2 != null) {
                    s = s2;
                }
            }
            f0.g = s;
            f0.a().track();
        }
    }

    @NotNull
    public static final SongVideoHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return SongVideoHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.VideoHolder
    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
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
                    Navigator.open(SongDetailContentsMvFragment.Companion.newInstance(this.getContentId()));
                    f f0 = SongVideoHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = SongVideoHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = SongVideoHolder.this.getString(0x7F130E19);  // string:tiara_common_layer1_song_video "이곡의비디오"
                        f0.F = SongVideoHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f0.a().track();
                    }
                }
            });
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.VideoHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

