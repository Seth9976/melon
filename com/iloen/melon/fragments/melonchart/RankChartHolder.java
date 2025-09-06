package com.iloen.melon.fragments.melonchart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.CHARTBASE.INFO.INFODATA;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.CHARTBASE.INFO;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.CHARTBASE.TITLE;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.RANKCHART;
import com.melon.ui.popup.b;
import ee.i;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vd.f;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u001C\u0010\r\u001A\n \f*\u0004\u0018\u00010\u000B0\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000ER\u001C\u0010\u0010\u001A\n \f*\u0004\u0018\u00010\u000F0\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0012\u001A\n \f*\u0004\u0018\u00010\u000F0\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u001C\u0010\u0014\u001A\n \f*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/RankChartHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$RANKCHART;", "data", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$RANKCHART;)V", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "infoTitleIv", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "infoTitleTv", "Landroid/widget/TextView;", "titleTv", "Lcom/iloen/melon/fragments/melonchart/ChartRankChangeGraphView;", "graph", "Lcom/iloen/melon/fragments/melonchart/ChartRankChangeGraphView;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RankChartHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/RankChartHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/melonchart/RankChartHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final RankChartHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D046F, viewGroup0, false);  // layout:listitem_chart_report_rank_chart
            q.d(view0);
            return new RankChartHolder(view0);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    private final ChartRankChangeGraphView graph;
    private final ImageView infoTitleIv;
    private final TextView infoTitleTv;
    private final TextView titleTv;

    static {
        RankChartHolder.Companion = new Companion(null);
        RankChartHolder.$stable = 8;
    }

    public RankChartHolder(@NotNull View view0) {
        q.g(view0, "itemView");
        super(view0);
        this.infoTitleIv = (ImageView)view0.findViewById(0x7F0A057B);  // id:info_title_iv
        this.infoTitleTv = (TextView)view0.findViewById(0x7F0A057D);  // id:info_title_tv
        this.titleTv = (TextView)view0.findViewById(0x7F0A0BAA);  // id:title_tv
        this.graph = (ChartRankChangeGraphView)view0.findViewById(0x7F0A09AD);  // id:rank_change_graph
    }

    public static void a(ImageView imageView0, INFO chartReportRes$Response$CHARTBASE$INFO0, View view0) {
        RankChartHolder.bind$lambda$4$lambda$2$lambda$1(imageView0, chartReportRes$Response$CHARTBASE$INFO0, view0);
    }

    public final void bind(@Nullable RANKCHART chartReportRes$Response$RANKCHART0) {
        CharSequence charSequence0;
        if(chartReportRes$Response$RANKCHART0 == null) {
            this.infoTitleIv.setVisibility(8);
            this.infoTitleTv.setVisibility(8);
        }
        else {
            INFO chartReportRes$Response$CHARTBASE$INFO0 = chartReportRes$Response$RANKCHART0.info;
            if(chartReportRes$Response$CHARTBASE$INFO0 == null) {
                this.infoTitleIv.setVisibility(8);
                this.infoTitleTv.setVisibility(8);
            }
            else {
                ImageView imageView0 = this.infoTitleIv;
                if(imageView0 != null) {
                    imageView0.setVisibility(0);
                    imageView0.setContentDescription(chartReportRes$Response$CHARTBASE$INFO0.title);
                    imageView0.setOnClickListener(new L(imageView0, chartReportRes$Response$CHARTBASE$INFO0, 0));
                }
                TextView textView0 = this.infoTitleTv;
                if(textView0 == null) {
                    textView0 = null;
                }
                else {
                    textView0.setVisibility(0);
                    textView0.setText(chartReportRes$Response$CHARTBASE$INFO0.title);
                }
                if(textView0 == null) {
                    this.infoTitleIv.setVisibility(8);
                    this.infoTitleTv.setVisibility(8);
                }
            }
        }
        TextView textView1 = this.titleTv;
        if(chartReportRes$Response$RANKCHART0 == null) {
            charSequence0 = "";
        }
        else {
            TITLE chartReportRes$Response$CHARTBASE$TITLE0 = chartReportRes$Response$RANKCHART0.title;
            if(chartReportRes$Response$CHARTBASE$TITLE0 == null) {
                charSequence0 = "";
            }
            else {
                Context context0 = textView1.getContext();
                q.f(context0, "getContext(...)");
                charSequence0 = MelonChartReportViewHoldersKt.getText$default(chartReportRes$Response$CHARTBASE$TITLE0, context0, 0, 0, 6, null);
                if(charSequence0 == null) {
                    charSequence0 = "";
                }
            }
        }
        textView1.setText(charSequence0);
        this.graph.setData(chartReportRes$Response$RANKCHART0);
    }

    private static final void bind$lambda$4$lambda$2$lambda$1(ImageView imageView0, INFO chartReportRes$Response$CHARTBASE$INFO0, View view0) {
        Context context0 = i.b(imageView0.getContext());
        AppCompatActivity appCompatActivity0 = context0 instanceof AppCompatActivity ? ((AppCompatActivity)context0) : null;
        if(appCompatActivity0 != null) {
            l0 l00 = appCompatActivity0.getSupportFragmentManager();
            String s = chartReportRes$Response$CHARTBASE$INFO0.title;
            String s1 = chartReportRes$Response$CHARTBASE$INFO0.desc;
            List list0 = chartReportRes$Response$CHARTBASE$INFO0.infoList;
            q.f(list0, "infoList");
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
            for(Object object0: list0) {
                arrayList0.add(((INFODATA)object0).title + " : " + ((INFODATA)object0).text);
            }
            String s2 = chartReportRes$Response$CHARTBASE$INFO0.foot;
            if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
                l00.C();
                if(b.b(l00, "showChartInfoPopup", null, null, 12) == null) {
                    f f0 = new f();
                    f0.e = s;
                    f0.f = s1;
                    f0.h = arrayList0;
                    f0.g = s2;
                    f0.show(l00, "showChartInfoPopup");
                }
            }
        }
    }
}

