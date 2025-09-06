package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.u0;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.SongDetailContentsOtherVerFragment;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import e.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 #2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0002#$B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJc\u0010\u0017\u001A\u00020\u00162\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\u000F\u001A\u00020\u000B2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u000BH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001A\u001A\u00020\u00162\u0012\u0010\u0019\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001F\u001A\u00060\u001ER\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0016\u0010!\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/OtherSongHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/melon/net/res/common/SongInfoBase;", "LJ8/u0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/u0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "actionName", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "layer1", "clickCopy", "", "orderNum", "metaId", "metaType", "metaName", "Lie/H;", "itemClickLog", "(Ljava/lang/String;Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "getTitleName", "()Ljava/lang/String;", "Lcom/iloen/melon/fragments/detail/viewholder/OtherSongHolder$InnerSongAdapter;", "innerSongAdapter", "Lcom/iloen/melon/fragments/detail/viewholder/OtherSongHolder$InnerSongAdapter;", "holderBind", "LJ8/u0;", "Companion", "InnerSongAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class OtherSongHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/OtherSongHolder$Companion;", "", "<init>", "()V", "TAG", "", "OTHER_SONG_MAX", "", "SIMILAR_SONG_MAX", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/OtherSongHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final OtherSongHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0233, viewGroup0, false);  // layout:detail_song_other_list
            int v = 0x7F0A07CA;  // id:main_contents_title
            MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
            if(mainTabTitleView0 != null) {
                v = 0x7F0A09D1;  // id:recycler_view
                RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09D1);  // id:recycler_view
                if(recyclerView0 != null) {
                    return new OtherSongHolder(new u0(((ConstraintLayout)view0), mainTabTitleView0, recyclerView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001A\u00020\u00032\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0019\u001A\u00020\f2\b\u0010\u0018\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0016\u0010\u000B\u001A\u00020\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/OtherSongHolder$InnerSongAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/net/res/common/SongInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/detail/viewholder/OtherSongHolder;Landroid/content/Context;Ljava/util/List;)V", "", "originSongIndex", "Lie/H;", "setOriginSongIndex", "(I)V", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_SONG", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerSongAdapter extends p {
        private final int VIEW_TYPE_SONG;
        private int originSongIndex;

        public InnerSongAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.originSongIndex = -1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_SONG;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof SongHolder) {
                OtherSongHolder otherSongHolder0 = OtherSongHolder.this;
                Object object0 = this.getItem(v1);
                boolean z = ((SongInfoBase)object0).canService;
                ViewUtils.setEnable(((SongHolder)o00).wrapperLayout, z);
                Glide.with(this.getContext()).load(((SongInfoBase)object0).albumImg).into(((SongHolder)o00).thumbnailIv);
                if(z) {
                    int v2 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                    ((SongHolder)o00).itemView.setBackgroundColor(v2);
                }
                else {
                    int v3 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                    ((SongHolder)o00).itemView.setBackgroundColor(v3);
                }
                ViewUtils.showWhen(((SongHolder)o00).btnPlay, z);
                ViewUtils.setOnClickListener(((SongHolder)o00).btnPlay, new u(otherSongHolder0, ((SongInfoBase)object0), this, ((SongHolder)o00), v1));
                boolean z1 = false;
                ViewUtils.showWhen(((SongHolder)o00).btnInfo, false);
                ViewUtils.setOnClickListener(((SongHolder)o00).thumbContainer, new v(((SongInfoBase)object0), ((SongHolder)o00), otherSongHolder0, v1));
                ViewUtils.setTextViewMarquee(((SongHolder)o00).titleTv, this.isMarqueeNeeded(v1));
                ((SongHolder)o00).titleTv.setText(((SongInfoBase)object0).songName);
                ((SongHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(((SongInfoBase)object0).artistList));
                ViewUtils.showWhen(((SongHolder)o00).list19Iv, ((SongInfoBase)object0).isAdult);
                ViewUtils.showWhen(((SongHolder)o00).listFreeIv, ((SongInfoBase)object0).isFree);
                ViewUtils.showWhen(((SongHolder)o00).listHoldbackIv, ((SongInfoBase)object0).isHoldback);
                View view0 = ((SongHolder)o00).originSongContainer;
                if(this.originSongIndex == v1) {
                    z1 = true;
                }
                ViewUtils.showWhen(view0, z1);
            }
        }

        private static final void onBindViewImpl$lambda$3$lambda$2$lambda$0(OtherSongHolder otherSongHolder0, SongInfoBase songInfoBase0, InnerSongAdapter otherSongHolder$InnerSongAdapter0, SongHolder songHolder0, int v, View view0) {
            otherSongHolder0.getOnViewHolderActionListener().onPlayBtnListener(Playable.from(songInfoBase0, otherSongHolder$InnerSongAdapter0.getMenuId(), null));
            String s = songHolder0.getItemViewType() == 0x2F ? otherSongHolder0.getString(0x7F130E15) : otherSongHolder0.getString(0x7F130E16);  // string:tiara_common_layer1_song_other_version "이곡의다른버전"
            String s1 = otherSongHolder0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            String s2 = songInfoBase0.songId;
            String s3 = otherSongHolder0.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            otherSongHolder0.itemClickLog(s1, ActionKind.PlayMusic, s, null, v, s2, s3, songInfoBase0.songName);
        }

        private static final void onBindViewImpl$lambda$3$lambda$2$lambda$1(SongInfoBase songInfoBase0, SongHolder songHolder0, OtherSongHolder otherSongHolder0, int v, View view0) {
            Navigator.openSongInfo((songInfoBase0.songId == null ? "" : songInfoBase0.songId));
            String s = songHolder0.getItemViewType() == 0x2F ? otherSongHolder0.getString(0x7F130E15) : otherSongHolder0.getString(0x7F130E16);  // string:tiara_common_layer1_song_other_version "이곡의다른버전"
            String s1 = otherSongHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            String s2 = songInfoBase0.songId;
            String s3 = otherSongHolder0.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            otherSongHolder0.itemClickLog(s1, ActionKind.ClickContent, s, null, v, s2, s3, songInfoBase0.songName);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            return new SongHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04AE, viewGroup0, false));  // layout:listitem_song_new
        }

        public final void setOriginSongIndex(int v) {
            this.originSongIndex = v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int OTHER_SONG_MAX = 3;
    private static final int SIMILAR_SONG_MAX = 5;
    @NotNull
    public static final String TAG = "OtherSongHolder";
    @NotNull
    private u0 holderBind;
    @NotNull
    private InnerSongAdapter innerSongAdapter;

    static {
        OtherSongHolder.Companion = new Companion(null);
        OtherSongHolder.$stable = 8;
    }

    public OtherSongHolder(@NotNull u0 u00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(u00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(u00, onViewHolderActionBaseListener0);
        this.innerSongAdapter = new InnerSongAdapter(this, this.getContext(), null);
        this.holderBind = u00;
        this.setTitleView(u00.b);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
        this.holderBind.c.setLayoutManager(new LinearLayoutManager(1, false));
        this.holderBind.c.setNestedScrollingEnabled(false);
        this.holderBind.c.setHasFixedSize(true);
        this.innerSongAdapter.setMarkedMode(false);
        this.innerSongAdapter.setListContentType(1);
        this.holderBind.c.setAdapter(this.innerSongAdapter);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() [...] // Inlined contents

    private final void itemClickLog(String s, ActionKind actionKind0, String s1, String s2, Integer integer0, String s3, String s4, String s5) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = s;
            if(actionKind0 != null) {
                f0.d = actionKind0;
            }
            f0.y = s1;
            if(s2 != null && s2.length() != 0) {
                f0.F = s2;
            }
            if(integer0 != null) {
                f0.c(((int)integer0) + 1);
            }
            if(s3 != null && s3.length() != 0) {
                f0.e = s3;
            }
            if(s4 != null && s4.length() != 0) {
                f0.f = s4;
            }
            if(s5 != null && s5.length() != 0) {
                f0.g = s5;
            }
            f0.a().track();
        }
    }

    public static void itemClickLog$default(OtherSongHolder otherSongHolder0, String s, ActionKind actionKind0, String s1, String s2, Integer integer0, String s3, String s4, String s5, int v, Object object0) {
        if((v & 16) != 0) {
            integer0 = null;
        }
        if((v & 0x20) != 0) {
            s3 = null;
        }
        if((v & 0x40) != 0) {
            s4 = null;
        }
        if((v & 0x80) != 0) {
            s5 = null;
        }
        otherSongHolder0.itemClickLog(s, actionKind0, s1, s2, integer0, s3, s4, s5);
    }

    @NotNull
    public static final OtherSongHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return OtherSongHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        int v = adapterInViewHolder$Row0.getItemViewType();
        String s = this.getString((v == 46 ? 0x7F130A86 : 0x7F130A83));  // string:song_detail_title_similar_song "유사한 곡"
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle("");
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(adapterInViewHolder$Row0.isViewAll());
        }
        MainTabTitleView mainTabTitleView2 = this.getTitleView();
        if(mainTabTitleView2 != null) {
            mainTabTitleView2.setTitle(s);
        }
        MainTabTitleView mainTabTitleView3 = this.getTitleView();
        if(mainTabTitleView3 != null) {
            mainTabTitleView3.setOnEventListener(new SimpleEventListener() {
                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onViewAllButtonClick(View view0) {
                    q.g(view0, "view");
                    String s = v.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    String s1 = v.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                    if(adapterInViewHolder$Row0 == 46) {
                        Navigator.openSimilarSongList(this.$row.getContentId(), "N10001");
                        String s2 = v.getString(0x7F130E16);  // string:tiara_common_layer1_song_similar_version "유사한곡"
                        OtherSongHolder.itemClickLog$default(v, s, null, s2, s1, null, null, null, null, 0xF0, null);
                        return;
                    }
                    Navigator.open(SongDetailContentsOtherVerFragment.Companion.newInstance(this.$row.getContentId()));
                    String s3 = v.getString(0x7F130E15);  // string:tiara_common_layer1_song_other_version "이곡의다른버전"
                    OtherSongHolder.itemClickLog$default(v, s, null, s3, s1, null, null, null, null, 0xF0, null);
                }
            });
        }
        int v1 = 0;
        if(this.innerSongAdapter.getCount() <= 0) {
            if(v == 0x2F) {
                List list0 = (List)adapterInViewHolder$Row0.getItem();
                if(list0 != null) {
                    boolean z = true;
                    int v2 = 0;
                    for(Object object0: list0) {
                        if(v2 >= 0) {
                            if(v2 == 3) {
                                break;
                            }
                            if(z && ((SongInfoBase)object0).isOrigin()) {
                                this.innerSongAdapter.setOriginSongIndex(v2);
                                z = false;
                            }
                            this.innerSongAdapter.add(((SongInfoBase)object0));
                            ++v2;
                            continue;
                        }
                        k.O();
                        throw null;
                    }
                }
            }
            else {
                List list1 = (List)adapterInViewHolder$Row0.getItem();
                if(list1 != null) {
                    for(Object object1: list1) {
                        if(v1 >= 0) {
                            if(v1 == 5) {
                                break;
                            }
                            this.innerSongAdapter.add(((SongInfoBase)object1));
                            ++v1;
                            continue;
                        }
                        k.O();
                        throw null;
                    }
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

