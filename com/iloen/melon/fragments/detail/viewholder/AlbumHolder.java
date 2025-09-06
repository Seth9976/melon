package com.iloen.melon.fragments.detail.viewholder;

import A7.d;
import J8.G1;
import J8.T;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.AlbumDetailContentsOtherVerFragment;
import com.iloen.melon.fragments.detail.AlbumDetailContentsSeriesFragment;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v5x.response.DetailBaseRes.ALBUM;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import e.k;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0017\u0018\u0000 #2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000F\u001A\u00020\u000E2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J9\u0010\u0017\u001A\u00020\u00162\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001A\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u001B\u0010\u001AJ#\u0010\u001D\u001A\u00020\u00162\u0012\u0010\u001C\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u001D\u0010\u001ER\u0016\u0010\u001F\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0016\u0010!\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/AlbumHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ALBUM;", "LJ8/T;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/T;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "item", "", "index", "LJ8/G1;", "bindItem", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ALBUM;I)LJ8/G1;", "", "actionName", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "layer1", "Lie/H;", "itemClickLog", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ALBUM;Ljava/lang/String;Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;I)V", "getTitleTiaraLogName", "()Ljava/lang/String;", "getTitleName", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "holderBind", "LJ8/T;", "total", "I", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class AlbumHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/AlbumHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/AlbumHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final AlbumHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new AlbumHolder(T.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "AlbumHolder";
    @NotNull
    private T holderBind;
    private int total;

    static {
        AlbumHolder.Companion = new Companion(null);
        AlbumHolder.$stable = 8;
    }

    public AlbumHolder(@NotNull T t0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(t0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(t0, onViewHolderActionBaseListener0);
        this.holderBind = t0;
        this.setTitleView(t0.c);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    public static void a(AlbumHolder albumHolder0, ALBUM detailBaseRes$ALBUM0, int v, View view0) {
        AlbumHolder.bindItem$lambda$2(detailBaseRes$ALBUM0, albumHolder0, v, view0);
    }

    private final G1 bindItem(ALBUM detailBaseRes$ALBUM0, int v) {
        String s = null;
        G1 g10 = G1.a(LayoutInflater.from(this.getContext()), null);
        FrameLayout frameLayout0 = g10.a;
        Glide.with(g10.e.b).load((detailBaseRes$ALBUM0 == null ? null : detailBaseRes$ALBUM0.albumImg)).into(g10.e.b);
        g10.h.setText((detailBaseRes$ALBUM0 == null ? null : detailBaseRes$ALBUM0.albumName));
        String s1 = detailBaseRes$ALBUM0 == null ? null : detailBaseRes$ALBUM0.getArtistNames();
        g10.b.setText(s1);
        g10.c.setText((detailBaseRes$ALBUM0 == null ? null : detailBaseRes$ALBUM0.issueDate));
        frameLayout0.setOnClickListener(new a(detailBaseRes$ALBUM0, this, v));
        a a0 = new a(this, detailBaseRes$ALBUM0, v);
        g10.g.setOnClickListener(a0);
        String s2 = detailBaseRes$ALBUM0 == null ? null : detailBaseRes$ALBUM0.albumName;
        String s3 = this.getString(0x7F130AD2);  // string:talkback_artist "아티스트"
        String s4 = detailBaseRes$ALBUM0 == null ? null : detailBaseRes$ALBUM0.getArtistNames();
        String s5 = this.getString(0x7F130B56);  // string:talkback_issue_date "발매일"
        if(detailBaseRes$ALBUM0 != null) {
            s = detailBaseRes$ALBUM0.issueDate;
        }
        ViewUtils.setContentDescriptionWithButtonClassName(frameLayout0, d.n(com.iloen.melon.utils.a.o(s2, " ", s3, " ", s4), " ", s5, " ", s), String.format(this.getString(0x7F130BA8), Arrays.copyOf(new Object[]{this.total, ((int)(v + 1))}, 2)));  // string:talkback_number_out_of_number "%1$d개중 %2$d번째"
        return g10;
    }

    private static final void bindItem$lambda$2(ALBUM detailBaseRes$ALBUM0, AlbumHolder albumHolder0, int v, View view0) {
        Navigator.openAlbumInfo((detailBaseRes$ALBUM0 == null ? null : detailBaseRes$ALBUM0.albumId));
        String s = albumHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        String s1 = albumHolder0.getItemViewType() == 23 ? albumHolder0.getString(0x7F130DDB) : albumHolder0.getString(0x7F130DDD);  // string:tiara_common_layer1_album_other_version "이앨범의다른버전"
        albumHolder0.itemClickLog(detailBaseRes$ALBUM0, s, ActionKind.ClickContent, s1, v);
    }

    private static final void bindItem$lambda$3(AlbumHolder albumHolder0, ALBUM detailBaseRes$ALBUM0, int v, View view0) {
        albumHolder0.getOnViewHolderActionListener().onPlayAlbumListener((detailBaseRes$ALBUM0 == null ? null : detailBaseRes$ALBUM0.albumId));
        String s = albumHolder0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        String s1 = albumHolder0.getItemViewType() == 23 ? albumHolder0.getString(0x7F130DDB) : albumHolder0.getString(0x7F130DDD);  // string:tiara_common_layer1_album_other_version "이앨범의다른버전"
        albumHolder0.itemClickLog(detailBaseRes$ALBUM0, s, ActionKind.PlayMusic, s1, v);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130053);  // string:album "앨범"
    }

    @Nullable
    public String getTitleTiaraLogName() {
        return this.getString(0x7F130053);  // string:album "앨범"
    }

    private final void itemClickLog(ALBUM detailBaseRes$ALBUM0, String s, ActionKind actionKind0, String s1, int v) {
        String s3;
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = s;
            f0.d = actionKind0;
            f0.y = s1;
            f0.c(v + 1);
            String s2 = "";
            if(detailBaseRes$ALBUM0 == null) {
                s3 = "";
            }
            else {
                s3 = detailBaseRes$ALBUM0.albumId;
                if(s3 == null) {
                    s3 = "";
                }
            }
            f0.e = s3;
            f0.f = this.getString(0x7F130EF0);  // string:tiara_meta_type_album "앨범"
            if(detailBaseRes$ALBUM0 != null) {
                String s4 = detailBaseRes$ALBUM0.albumName;
                if(s4 != null) {
                    s2 = s4;
                }
            }
            f0.g = s2;
            f0.a().track();
        }
    }

    @NotNull
    public static final AlbumHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return AlbumHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        String s;
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        this.total = list0.size();
        int v = adapterInViewHolder$Row0.getItemViewType();
        switch(v) {
            case 22: {
                s = this.getString(0x7F130061);  // string:album_detail_related_list_title_series "이 앨범의 시리즈"
                break;
            }
            case 23: {
                s = this.getString(0x7F130060);  // string:album_detail_related_list_title_other "이 앨범의 다른 버전"
                break;
            }
            default: {
                s = this.getString(0x7F130053);  // string:album "앨범"
            }
        }
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(s);
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
                    switch(adapterInViewHolder$Row0) {
                        case 22: {
                            Navigator.open(AlbumDetailContentsSeriesFragment.Companion.newInstance(this.getContentId()));
                            f f0 = AlbumHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                            if(f0 != null) {
                                f0.a = AlbumHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                                f0.y = AlbumHolder.this.getString(0x7F130DDD);  // string:tiara_common_layer1_album_series "이앨범의시리즈"
                                f0.F = AlbumHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                                f0.a().track();
                                return;
                            }
                            break;
                        }
                        case 23: {
                            Navigator.open(AlbumDetailContentsOtherVerFragment.Companion.newInstance(this.getContentId()));
                            f f1 = AlbumHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                            if(f1 != null) {
                                f1.a = AlbumHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                                f1.y = AlbumHolder.this.getString(0x7F130DDB);  // string:tiara_common_layer1_album_other_version "이앨범의다른버전"
                                f1.F = AlbumHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                                f1.a().track();
                                return;
                            }
                            break;
                        }
                    }
                }
            });
        }
        if(this.holderBind.b.getChildCount() <= 0) {
            int v1 = 0;
            for(Object object0: list0) {
                if(v1 >= 0) {
                    G1 g10 = this.bindItem(((ALBUM)object0), v1);
                    this.holderBind.b.addView(g10.a);
                    ++v1;
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
}

