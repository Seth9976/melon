package com.iloen.melon.fragments.artistchannel.viewholder;

import Ad.n;
import De.I;
import J8.W;
import J8.f3;
import J8.y1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE.ARTISTDAILYREPORT.TOPSONGLIST;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u001F2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001\u001FB\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001B\u001A\u00020\u001A2\u0012\u0010\u0019\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001D\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001E¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistDailyReportHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST;", "LJ8/W;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/W;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "index", "item", "LJ8/y1;", "bindItem", "(ILcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST;)LJ8/y1;", "gap", "getGapColor", "(I)I", "", "getGapString", "(I)Ljava/lang/String;", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "holderBind", "LJ8/W;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistDailyReportHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistDailyReportHolder$Companion;", "", "<init>", "()V", "TAG", "", "DRAWABLE_LEFT", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistDailyReportHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDailyReportHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0213, viewGroup0, false);  // layout:detail_item_artist_daily_report
            int v = 0x7F0A05A7;  // id:item_container
            LinearLayout linearLayout0 = (LinearLayout)I.C(view0, 0x7F0A05A7);  // id:item_container
            if(linearLayout0 != null) {
                v = 0x7F0A07CA;  // id:main_contents_title
                MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                if(mainTabTitleView0 != null) {
                    return new ArtistDailyReportHolder(new W(((LinearLayout)view0), linearLayout0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int DRAWABLE_LEFT = 0;
    @NotNull
    private static final String TAG = "ArtistDailyReportHolder";
    @NotNull
    private W holderBind;

    static {
        ArtistDailyReportHolder.Companion = new Companion(null);
        ArtistDailyReportHolder.$stable = 8;
    }

    public ArtistDailyReportHolder(@NotNull W w0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(w0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(w0, onViewHolderActionBaseListener0);
        this.holderBind = w0;
        this.setTitleView(w0.c);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final y1 bindItem(int v, TOPSONGLIST artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0) {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0458, null, false);  // layout:listitem_artist_daily_report
        int v1 = 0x7F0A056B;  // id:include_thumbnail_layout
        View view1 = I.C(view0, 0x7F0A056B);  // id:include_thumbnail_layout
        if(view1 != null) {
            f3 f30 = f3.a(view1);
            v1 = 0x7F0A0766;  // id:like_gap_tv
            View view2 = I.C(view0, 0x7F0A0766);  // id:like_gap_tv
            if(((MelonTextView)view2) != null) {
                v1 = 0x7F0A09B4;  // id:rank_tv
                View view3 = I.C(view0, 0x7F0A09B4);  // id:rank_tv
                if(((MelonTextView)view3) != null) {
                    v1 = 0x7F0A0AED;  // id:stream_gap_tv
                    View view4 = I.C(view0, 0x7F0A0AED);  // id:stream_gap_tv
                    if(((MelonTextView)view4) != null) {
                        v1 = 0x7F0A0BAA;  // id:title_tv
                        View view5 = I.C(view0, 0x7F0A0BAA);  // id:title_tv
                        if(((MelonTextView)view5) != null) {
                            y1 y10 = new y1(f30, ((FrameLayout)view0), ((MelonTextView)view2), ((MelonTextView)view3), ((MelonTextView)view4), ((MelonTextView)view5));
                            int v2 = ScreenUtils.dipToPixel(this.getContext(), 44.0f);
                            ViewUtils.setDefaultImage(f30.c, v2);
                            Glide.with(f30.b).load(artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0.albumImg).into(f30.b);
                            ((MelonTextView)view3).setText(String.valueOf(v + 1));
                            ((MelonTextView)view5).setText(artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0.songName);
                            int v3 = this.getGapColor(artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0.streamUserCntGap);
                            int v4 = this.getGapColor(artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0.likeCntGap);
                            ((MelonTextView)view4).setText(this.getGapString(artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0.streamUserCntGap));
                            ((MelonTextView)view4).setTextColor(v3);
                            ((MelonTextView)view4).getCompoundDrawables()[0].setTint(v3);
                            ((MelonTextView)view2).setText(this.getGapString(artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0.likeCntGap));
                            ((MelonTextView)view2).setTextColor(v4);
                            ((MelonTextView)view2).getCompoundDrawables()[0].setTint(v4);
                            n n0 = new n(artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0, this, v, 7);
                            f30.a.setOnClickListener(n0);
                            return y10;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
    }

    private static final void bindItem$lambda$3(TOPSONGLIST artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0, ArtistDailyReportHolder artistDailyReportHolder0, int v, View view0) {
        Navigator.openSongInfo((artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0.songId == null ? "" : artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0.songId));
        f f0 = artistDailyReportHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistDailyReportHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = artistDailyReportHolder0.getString(0x7F130CD9);  // string:tiara_artist_layer1_daily_report "데일리리포트"
            f0.c(v + 1);
            f0.e = artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0.songId;
            f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            f0.g = artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT$TOPSONGLIST0.songName;
            f0.a().track();
        }
    }

    private final int getGapColor(int v) {
        Context context0 = this.getContext();
        if(v > 0) {
            return ColorUtils.getColor(context0, 0x7F060447);  // color:pink600s
        }
        return v == 0 ? ColorUtils.getColor(context0, 0x7F060160) : ColorUtils.getColor(context0, 0x7F060046);  // color:gray600s_support_high_contrast
    }

    private final String getGapString(int v) {
        String s;
        int v1 = Math.abs(v);
        int v2 = 0x5F5E0FF;
        if(v1 > 0x5F5E0FF) {
            int v3 = ScreenUtils.getScreenWidth(this.getContext());
            int v4 = ScreenUtils.getScreenHeight(this.getContext());
            if(v3 > v4) {
                v3 = v4;
            }
            if(v3 >= 360) {
                v2 = 0x3B9AC9FF;
            }
            s = StringUtils.INSTANCE.getCountStringWithoutPlus(String.valueOf(v1), v2);
        }
        else {
            s = StringUtils.getCountFormattedString(v1);
        }
        if(v == 0) {
            return "-";
        }
        return v <= 0 ? "-" + s : "+" + s;
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130127);  // string:artist_detail_contents_artist_daily_report "데일리 리포트"
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
        int v = 0;
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(false);
        }
        if(this.holderBind.b.getChildCount() <= 0 && list0 != null) {
            for(Object object0: list0) {
                if(v >= 0) {
                    y1 y10 = this.bindItem(v, ((TOPSONGLIST)object0));
                    this.holderBind.b.addView(y10.a);
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
}

