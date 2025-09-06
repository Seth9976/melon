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
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.CHARTBASE.INFO.INFODATA;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.CHARTBASE.INFO;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.CHARTBASE.TITLE;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.LISTENERCHART;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.SONGINFO;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u001C\u0010\r\u001A\n \f*\u0004\u0018\u00010\u000B0\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000ER\u001C\u0010\u000F\u001A\n \f*\u0004\u0018\u00010\u000B0\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u000ER\u001C\u0010\u0011\u001A\n \f*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0013\u001A\n \f*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/TopListenerHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Lcom/iloen/melon/fragments/melonchart/TopListenerHolder$ListenerChartData;", "data", "Lie/H;", "bind", "(Lcom/iloen/melon/fragments/melonchart/TopListenerHolder$ListenerChartData;)V", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "albumIv", "Landroid/widget/ImageView;", "infoTitleIv", "Landroid/widget/TextView;", "infoTitleTv", "Landroid/widget/TextView;", "titleTv", "Companion", "ListenerChartData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TopListenerHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/TopListenerHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/melonchart/TopListenerHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TopListenerHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D0470, viewGroup0, false);  // layout:listitem_chart_report_top_listener
            q.d(view0);
            return new TopListenerHolder(view0);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000B\u0010\f\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\r\u001A\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000E\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/TopListenerHolder$ListenerChartData;", "", "chartData", "Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$LISTENERCHART;", "song", "Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$SONGINFO;", "<init>", "(Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$LISTENERCHART;Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$SONGINFO;)V", "getChartData", "()Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$LISTENERCHART;", "getSong", "()Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$SONGINFO;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ListenerChartData {
        public static final int $stable = 8;
        @Nullable
        private final LISTENERCHART chartData;
        @Nullable
        private final SONGINFO song;

        public ListenerChartData(@Nullable LISTENERCHART chartReportRes$Response$LISTENERCHART0, @Nullable SONGINFO chartReportRes$Response$SONGINFO0) {
            this.chartData = chartReportRes$Response$LISTENERCHART0;
            this.song = chartReportRes$Response$SONGINFO0;
        }

        @Nullable
        public final LISTENERCHART component1() {
            return this.chartData;
        }

        @Nullable
        public final SONGINFO component2() {
            return this.song;
        }

        @NotNull
        public final ListenerChartData copy(@Nullable LISTENERCHART chartReportRes$Response$LISTENERCHART0, @Nullable SONGINFO chartReportRes$Response$SONGINFO0) {
            return new ListenerChartData(chartReportRes$Response$LISTENERCHART0, chartReportRes$Response$SONGINFO0);
        }

        public static ListenerChartData copy$default(ListenerChartData topListenerHolder$ListenerChartData0, LISTENERCHART chartReportRes$Response$LISTENERCHART0, SONGINFO chartReportRes$Response$SONGINFO0, int v, Object object0) {
            if((v & 1) != 0) {
                chartReportRes$Response$LISTENERCHART0 = topListenerHolder$ListenerChartData0.chartData;
            }
            if((v & 2) != 0) {
                chartReportRes$Response$SONGINFO0 = topListenerHolder$ListenerChartData0.song;
            }
            return topListenerHolder$ListenerChartData0.copy(chartReportRes$Response$LISTENERCHART0, chartReportRes$Response$SONGINFO0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ListenerChartData)) {
                return false;
            }
            return q.b(this.chartData, ((ListenerChartData)object0).chartData) ? q.b(this.song, ((ListenerChartData)object0).song) : false;
        }

        @Nullable
        public final LISTENERCHART getChartData() {
            return this.chartData;
        }

        @Nullable
        public final SONGINFO getSong() {
            return this.song;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.chartData == null ? 0 : this.chartData.hashCode();
            SONGINFO chartReportRes$Response$SONGINFO0 = this.song;
            if(chartReportRes$Response$SONGINFO0 != null) {
                v = chartReportRes$Response$SONGINFO0.hashCode();
            }
            return v1 * 0x1F + v;
        }

        @Override
        @NotNull
        public String toString() {
            return "ListenerChartData(chartData=" + this.chartData + ", song=" + this.song + ")";
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    private final ImageView albumIv;
    private final ImageView infoTitleIv;
    private final TextView infoTitleTv;
    private final TextView titleTv;

    static {
        TopListenerHolder.Companion = new Companion(null);
        TopListenerHolder.$stable = 8;
    }

    public TopListenerHolder(@NotNull View view0) {
        q.g(view0, "itemView");
        super(view0);
        this.albumIv = (ImageView)view0.findViewById(0x7F0A0089);  // id:album_iv
        this.infoTitleIv = (ImageView)view0.findViewById(0x7F0A057B);  // id:info_title_iv
        this.infoTitleTv = (TextView)view0.findViewById(0x7F0A057D);  // id:info_title_tv
        this.titleTv = (TextView)view0.findViewById(0x7F0A0BAA);  // id:title_tv
    }

    public static void a(ImageView imageView0, INFO chartReportRes$Response$CHARTBASE$INFO0, View view0) {
        TopListenerHolder.bind$lambda$4$lambda$2$lambda$1(imageView0, chartReportRes$Response$CHARTBASE$INFO0, view0);
    }

    public final void bind(@Nullable ListenerChartData topListenerHolder$ListenerChartData0) {
        String s;
        RequestManager requestManager0 = Glide.with(this.albumIv.getContext());
        CharSequence charSequence0 = null;
        if(topListenerHolder$ListenerChartData0 == null) {
            s = null;
        }
        else {
            SONGINFO chartReportRes$Response$SONGINFO0 = topListenerHolder$ListenerChartData0.getSong();
            s = chartReportRes$Response$SONGINFO0 == null ? null : chartReportRes$Response$SONGINFO0.albumImgLarge;
        }
        requestManager0.load(s).into(this.albumIv);
        if(topListenerHolder$ListenerChartData0 == null) {
            this.infoTitleIv.setVisibility(8);
            this.infoTitleTv.setVisibility(8);
        }
        else {
            LISTENERCHART chartReportRes$Response$LISTENERCHART0 = topListenerHolder$ListenerChartData0.getChartData();
            if(chartReportRes$Response$LISTENERCHART0 == null) {
                this.infoTitleIv.setVisibility(8);
                this.infoTitleTv.setVisibility(8);
            }
            else {
                INFO chartReportRes$Response$CHARTBASE$INFO0 = chartReportRes$Response$LISTENERCHART0.info;
                if(chartReportRes$Response$CHARTBASE$INFO0 == null) {
                    this.infoTitleIv.setVisibility(8);
                    this.infoTitleTv.setVisibility(8);
                }
                else {
                    ImageView imageView0 = this.infoTitleIv;
                    if(imageView0 != null) {
                        imageView0.setVisibility(0);
                        imageView0.setContentDescription(chartReportRes$Response$CHARTBASE$INFO0.title);
                        imageView0.setOnClickListener(new L(imageView0, chartReportRes$Response$CHARTBASE$INFO0, 1));
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
        }
        TextView textView1 = this.titleTv;
        if(topListenerHolder$ListenerChartData0 != null) {
            LISTENERCHART chartReportRes$Response$LISTENERCHART1 = topListenerHolder$ListenerChartData0.getChartData();
            if(chartReportRes$Response$LISTENERCHART1 != null) {
                TITLE chartReportRes$Response$CHARTBASE$TITLE0 = chartReportRes$Response$LISTENERCHART1.title;
                if(chartReportRes$Response$CHARTBASE$TITLE0 != null) {
                    Context context0 = this.titleTv.getContext();
                    q.f(context0, "getContext(...)");
                    charSequence0 = MelonChartReportViewHoldersKt.getText$default(chartReportRes$Response$CHARTBASE$TITLE0, context0, 0x7F06016D, 0, 4, null);  // color:gray900s
                }
            }
        }
        textView1.setText(charSequence0);
    }

    private static final void bind$lambda$4$lambda$2$lambda$1(ImageView imageView0, INFO chartReportRes$Response$CHARTBASE$INFO0, View view0) {
        Context context0 = i.b(imageView0.getContext());
        AppCompatActivity appCompatActivity0 = context0 instanceof AppCompatActivity ? ((AppCompatActivity)context0) : null;
        l0 l00 = appCompatActivity0 == null ? null : appCompatActivity0.getSupportFragmentManager();
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

