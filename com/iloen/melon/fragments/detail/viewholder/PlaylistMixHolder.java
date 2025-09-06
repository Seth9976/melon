package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.U1;
import J8.f0;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.media3.session.a0;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.ForUDetailParam;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.fragments.main.foru.ForUUtils;
import com.iloen.melon.net.v6x.response.ForUDetailRes.RESPONSE.MIX;
import com.iloen.melon.net.v6x.response.ForUMixInfoBase;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.template.TemplateData.Builder.BUILD_TYPE;
import com.iloen.melon.utils.template.TemplateData.Builder;
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

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 )2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000F\u001A\u00020\u000E2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u001B\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0019\u001A\u00020\u00132\u001A\u0010\u0018\u001A\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ#\u0010\u001F\u001A\u00020\u001E2\u0012\u0010\u001D\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u001F\u0010 J7\u0010%\u001A\u00020\u001E2\u0006\u0010\"\u001A\u00020!2\u0006\u0010#\u001A\u00020\u00132\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\u0006\u0010$\u001A\u00020\u0013¢\u0006\u0004\b%\u0010&R\u0016\u0010\'\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\'\u0010(¨\u0006*"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistMixHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v6x/response/ForUDetailRes$RESPONSE$MIX;", "LJ8/f0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/f0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "item", "", "position", "LJ8/U1;", "bindItem", "(Lcom/iloen/melon/net/v6x/response/ForUDetailRes$RESPONSE$MIX;I)LJ8/U1;", "Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase;", "coverInfo", "", "saveTemplateCoverToCache", "(Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase;)Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "imgList", "getFirstUrlInList", "(Ljava/util/ArrayList;)Ljava/lang/String;", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "actionName", "title", "itemClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;ILcom/iloen/melon/net/v6x/response/ForUDetailRes$RESPONSE$MIX;Ljava/lang/String;)V", "holderBind", "LJ8/f0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class PlaylistMixHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistMixHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistMixHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistMixHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D021D, viewGroup0, false);  // layout:detail_item_playlist_mix
            int v = 0x7F0A05A7;  // id:item_container
            LinearLayout linearLayout0 = (LinearLayout)I.C(view0, 0x7F0A05A7);  // id:item_container
            if(linearLayout0 != null) {
                v = 0x7F0A07CA;  // id:main_contents_title
                MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                if(mainTabTitleView0 != null) {
                    return new PlaylistMixHolder(new f0(((LinearLayout)view0), linearLayout0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "PlaylistMixHolder";
    @NotNull
    private f0 holderBind;

    static {
        PlaylistMixHolder.Companion = new Companion(null);
        PlaylistMixHolder.$stable = 8;
    }

    public PlaylistMixHolder(@NotNull f0 f00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(f00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(f00, onViewHolderActionBaseListener0);
        this.holderBind = f00;
        this.setTitleView(f00.c);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    public static void b(U1 u10, Bitmap bitmap0) {
        PlaylistMixHolder.bindItem$lambda$3$lambda$2$lambda$1(u10, bitmap0);
    }

    private final U1 bindItem(MIX forUDetailRes$RESPONSE$MIX0, int v) {
        String s = null;
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0484, null, false);  // layout:listitem_detail_playlist_mix
        int v1 = 0x7F0A0355;  // id:cover_view
        View view1 = I.C(view0, 0x7F0A0355);  // id:cover_view
        if(((CoverView)view1) != null) {
            v1 = 0x7F0A05B7;  // id:item_layout
            View view2 = I.C(view0, 0x7F0A05B7);  // id:item_layout
            if(((RelativeLayout)view2) != null && ((MelonTextView)I.C(view0, 0x7F0A0765)) != null) {  // id:like_count
                v1 = 0x7F0A091D;  // id:play_button
                View view3 = I.C(view0, 0x7F0A091D);  // id:play_button
                if(((ImageView)view3) != null) {
                    v1 = 0x7F0A0AFD;  // id:sub_title
                    View view4 = I.C(view0, 0x7F0A0AFD);  // id:sub_title
                    if(((MelonTextView)view4) != null) {
                        v1 = 0x7F0A0B8D;  // id:title
                        View view5 = I.C(view0, 0x7F0A0B8D);  // id:title
                        if(((MelonTextView)view5) != null) {
                            U1 u10 = new U1(((FrameLayout)view0), ((CoverView)view1), ((RelativeLayout)view2), ((ImageView)view3), ((MelonTextView)view4), ((MelonTextView)view5));
                            if(forUDetailRes$RESPONSE$MIX0 != null) {
                                s = "";
                            }
                            String s1 = ForUUtils.replaceNicknameWithMarkup((forUDetailRes$RESPONSE$MIX0 == null ? null : ""), "<b>MAINREPLACE</b>", s, 15);
                            ((MelonTextView)view5).setText(s1);
                            if(forUDetailRes$RESPONSE$MIX0 != null) {
                                ((MelonTextView)view4).setText("");
                                new TemplateImageLoader(new Builder(((CoverView)view1), forUDetailRes$RESPONSE$MIX0, BUILD_TYPE.MAIN).build()).load(new a0(u10, 27));
                            }
                            if(forUDetailRes$RESPONSE$MIX0 != null) {
                                ((FrameLayout)view0).setOnClickListener(new u(forUDetailRes$RESPONSE$MIX0, forUDetailRes$RESPONSE$MIX0, this, v, s1));
                                ((ImageView)view3).setOnClickListener(new v(this, forUDetailRes$RESPONSE$MIX0, v, s1));
                            }
                            return u10;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
    }

    private static final void bindItem$lambda$3$lambda$2$lambda$1(U1 u10, Bitmap bitmap0) {
        q.g(bitmap0, "bitmap");
        u10.b.setImageBitmap(bitmap0);
    }

    // 去混淆评级： 中等(64)
    private static final void bindItem$lambda$6$lambda$4(MIX forUDetailRes$RESPONSE$MIX0, MIX forUDetailRes$RESPONSE$MIX1, PlaylistMixHolder playlistMixHolder0, int v, String s, View view0) {
        Navigator.INSTANCE.openMixPlaylist(new ForUDetailParam().title("").desc("").detailText("").detailReplace("").updateDate("").templateCoverCacheKey(playlistMixHolder0.saveTemplateCoverToCache(forUDetailRes$RESPONSE$MIX1)).coverImgUrl(playlistMixHolder0.getFirstUrlInList(forUDetailRes$RESPONSE$MIX0.getDetailImgUrls())).contsId("").seedContsId("").contsTypeCode("").songIds("").tagList(forUDetailRes$RESPONSE$MIX0.getTags()).statsElements(forUDetailRes$RESPONSE$MIX0.getStatsElements()));
        String s1 = playlistMixHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        q.d(s);
        playlistMixHolder0.itemClickLog(ActionKind.ClickContent, s1, v, forUDetailRes$RESPONSE$MIX1, s);
    }

    private static final void bindItem$lambda$6$lambda$5(PlaylistMixHolder playlistMixHolder0, MIX forUDetailRes$RESPONSE$MIX0, int v, String s, View view0) {
        playlistMixHolder0.getOnViewHolderActionListener().onPlayForUSongListener("", "", forUDetailRes$RESPONSE$MIX0.getStatsElements());
        String s1 = playlistMixHolder0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        q.d(s);
        playlistMixHolder0.itemClickLog(ActionKind.PlayMusic, s1, v, forUDetailRes$RESPONSE$MIX0, s);
    }

    private final String getFirstUrlInList(ArrayList arrayList0) {
        if(arrayList0 != null && arrayList0.size() > 0) {
            Object object0 = arrayList0.get(0);
            q.f(object0, "get(...)");
            return (String)object0;
        }
        return "";
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130349);  // string:dj_playlist_title_relation_mix "연관 MIX 플레이리스트"
    }

    public final void itemClickLog(@NotNull ActionKind actionKind0, @NotNull String s, int v, @Nullable MIX forUDetailRes$RESPONSE$MIX0, @NotNull String s1) {
        q.g(actionKind0, "actionKind");
        q.g(s, "actionName");
        q.g(s1, "title");
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.d = actionKind0;
            f0.a = s;
            f0.y = this.getString(0x7F130E67);  // string:tiara_djplaylist_layer1_relation_playlist "연관플레이리스트"
            f0.c(v + 1);
            f0.e = forUDetailRes$RESPONSE$MIX0 == null ? null : "";
            f0.f = this.getString(0x7F130F08);  // string:tiara_mixplaylist_meta_type "Mix플레이리스트"
            f0.g = s1;
            f0.a().track();
        }
    }

    @NotNull
    public static final PlaylistMixHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return PlaylistMixHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
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
            mainTabTitleView1.setTitleClickable(adapterInViewHolder$Row0.isViewAll());
        }
        int v = 0;
        if(this.holderBind.b.getChildCount() <= 0) {
            int v1 = list0 == null ? 0 : list0.size();
            if(list0 != null) {
                for(Object object0: list0) {
                    FrameLayout.LayoutParams frameLayout$LayoutParams0 = null;
                    if(v >= 0) {
                        if(q.b("", "N10078")) {
                            U1 u10 = this.bindItem(((MIX)object0), v);
                            if(v == v1 - 1) {
                                ViewGroup.LayoutParams viewGroup$LayoutParams0 = u10.c.getLayoutParams();
                                if(viewGroup$LayoutParams0 instanceof FrameLayout.LayoutParams) {
                                    frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)viewGroup$LayoutParams0;
                                }
                                if(frameLayout$LayoutParams0 != null) {
                                    frameLayout$LayoutParams0.bottomMargin = ScreenUtils.dipToPixel(this.getContext(), 1.0f);
                                }
                            }
                            this.holderBind.b.addView(u10.a);
                        }
                        ++v;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private final String saveTemplateCoverToCache(ForUMixInfoBase forUMixInfoBase0) {
        return ForUUtils.saveTemplateCoverToCache(this.getContext(), forUMixInfoBase0);
    }
}

