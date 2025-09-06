package com.iloen.melon.fragments.detail.viewholder;

import J8.e0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.SongDetailContentsDjPlaylistFragment;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PLAYLIST;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0010\u001A\u00020\u000F2\u0012\u0010\u000E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000BH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongPlaylistHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistHolder;", "LJ8/e0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/e0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "getTitleName", "()Ljava/lang/String;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PLAYLIST;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "actionName", "", "position", "item", "itemClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;ILcom/iloen/melon/net/v5x/response/DetailBaseRes$PLAYLIST;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongPlaylistHolder extends PlaylistHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongPlaylistHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/SongPlaylistHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SongPlaylistHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new SongPlaylistHolder(e0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "SongPlaylistHolder";

    static {
        SongPlaylistHolder.Companion = new Companion(null);
        SongPlaylistHolder.$stable = 8;
    }

    public SongPlaylistHolder(@NotNull e0 e00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(e00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(e00, onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.PlaylistHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130A75);  // string:song_detail_title_djplaylist "이 곡의 DJ플레이리스트"
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.PlaylistHolder
    public void itemClickLog(@NotNull ActionKind actionKind0, @NotNull String s, int v, @Nullable PLAYLIST detailBaseRes$PLAYLIST0) {
        String s2;
        q.g(actionKind0, "actionKind");
        q.g(s, "actionName");
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.d = actionKind0;
            f0.a = s;
            f0.y = this.getString(0x7F130E11);  // string:tiara_common_layer1_song_djplaylist "이곡의DJ플레이리스트"
            f0.c(v + 1);
            String s1 = "";
            if(detailBaseRes$PLAYLIST0 == null) {
                s2 = "";
            }
            else {
                s2 = detailBaseRes$PLAYLIST0.plylstseq;
                if(s2 == null) {
                    s2 = "";
                }
            }
            f0.e = s2;
            f0.f = this.getString(0x7F130EF6);  // string:tiara_meta_type_djplaylist "DJ플레이리스트"
            if(detailBaseRes$PLAYLIST0 != null) {
                String s3 = detailBaseRes$PLAYLIST0.plylsttitle;
                if(s3 != null) {
                    s1 = s3;
                }
            }
            f0.g = s1;
            f0.a().track();
        }
    }

    @NotNull
    public static final SongPlaylistHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return SongPlaylistHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.PlaylistHolder
    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setOnEventListener(new SimpleEventListener() {
                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onViewAllButtonClick(View view0) {
                    q.g(view0, "view");
                    Navigator.open(SongDetailContentsDjPlaylistFragment.Companion.newInstance(this.getContentId()));
                    f f0 = SongPlaylistHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = SongPlaylistHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = SongPlaylistHolder.this.getString(0x7F130E11);  // string:tiara_common_layer1_song_djplaylist "이곡의DJ플레이리스트"
                        f0.F = SongPlaylistHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f0.a().track();
                    }
                }
            });
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.PlaylistHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

