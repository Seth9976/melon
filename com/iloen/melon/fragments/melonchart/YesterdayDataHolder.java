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
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.YESTERCHARTINFO.RECORD;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.YESTERCHARTINFO;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import ee.i;
import java.util.ArrayList;
import java.util.List;
import je.p;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import vd.f;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u001C\u0010\r\u001A\n \f*\u0004\u0018\u00010\u000B0\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000ER\u001C\u0010\u0010\u001A\n \f*\u0004\u0018\u00010\u000F0\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0012\u001A\n \f*\u0004\u0018\u00010\u000F0\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u001C\u0010\u0013\u001A\n \f*\u0004\u0018\u00010\u000F0\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001C\u0010\u0014\u001A\n \f*\u0004\u0018\u00010\u000F0\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u001C\u0010\u0015\u001A\n \f*\u0004\u0018\u00010\u000F0\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u001C\u0010\u0016\u001A\n \f*\u0004\u0018\u00010\u000F0\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u001C\u0010\u0017\u001A\n \f*\u0004\u0018\u00010\u000F0\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/YesterdayDataHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$YESTERCHARTINFO;", "data", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$YESTERCHARTINFO;)V", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "infoTitleIv", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "infoTitleTv", "Landroid/widget/TextView;", "titleTv", "firstInfoTitleTv", "firstInfoValueTv", "secondInfoTitleTv", "secondInfoValueTv", "recordTv", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class YesterdayDataHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/YesterdayDataHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/melonchart/YesterdayDataHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final YesterdayDataHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D0471, viewGroup0, false);  // layout:listitem_chart_report_yesterday
            q.d(view0);
            return new YesterdayDataHolder(view0);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    private final TextView firstInfoTitleTv;
    private final TextView firstInfoValueTv;
    private final ImageView infoTitleIv;
    private final TextView infoTitleTv;
    private final TextView recordTv;
    private final TextView secondInfoTitleTv;
    private final TextView secondInfoValueTv;
    private final TextView titleTv;

    static {
        YesterdayDataHolder.Companion = new Companion(null);
        YesterdayDataHolder.$stable = 8;
    }

    public YesterdayDataHolder(@NotNull View view0) {
        q.g(view0, "itemView");
        super(view0);
        this.infoTitleIv = (ImageView)view0.findViewById(0x7F0A057B);  // id:info_title_iv
        this.infoTitleTv = (TextView)view0.findViewById(0x7F0A057D);  // id:info_title_tv
        this.titleTv = (TextView)view0.findViewById(0x7F0A0BAA);  // id:title_tv
        this.firstInfoTitleTv = (TextView)view0.findViewById(0x7F0A0C77);  // id:tv_first_info_title
        this.firstInfoValueTv = (TextView)view0.findViewById(0x7F0A0C78);  // id:tv_first_info_value
        this.secondInfoTitleTv = (TextView)view0.findViewById(0x7F0A0D03);  // id:tv_second_info_title
        this.secondInfoValueTv = (TextView)view0.findViewById(0x7F0A0D04);  // id:tv_second_info_value
        this.recordTv = (TextView)view0.findViewById(0x7F0A0CF9);  // id:tv_record
    }

    public static void a(ImageView imageView0, INFO chartReportRes$Response$CHARTBASE$INFO0, View view0) {
        YesterdayDataHolder.bind$lambda$4$lambda$2$lambda$1(imageView0, chartReportRes$Response$CHARTBASE$INFO0, view0);
    }

    public final void bind(@NotNull YESTERCHARTINFO chartReportRes$Response$YESTERCHARTINFO0) {
        CharSequence charSequence1;
        q.g(chartReportRes$Response$YESTERCHARTINFO0, "data");
        INFO chartReportRes$Response$CHARTBASE$INFO0 = chartReportRes$Response$YESTERCHARTINFO0.info;
        CharSequence charSequence0 = null;
        if(chartReportRes$Response$CHARTBASE$INFO0 == null) {
            this.infoTitleIv.setVisibility(8);
            this.infoTitleTv.setVisibility(8);
        }
        else {
            ImageView imageView0 = this.infoTitleIv;
            if(imageView0 != null) {
                imageView0.setVisibility(0);
                imageView0.setContentDescription(chartReportRes$Response$CHARTBASE$INFO0.title);
                imageView0.setOnClickListener(new L(imageView0, chartReportRes$Response$CHARTBASE$INFO0, 2));
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
        TextView textView1 = this.titleTv;
        TITLE chartReportRes$Response$CHARTBASE$TITLE0 = chartReportRes$Response$YESTERCHARTINFO0.title;
        if(chartReportRes$Response$CHARTBASE$TITLE0 == null) {
            charSequence1 = "";
        }
        else {
            Context context0 = textView1.getContext();
            q.f(context0, "getContext(...)");
            charSequence1 = MelonChartReportViewHoldersKt.getText$default(chartReportRes$Response$CHARTBASE$TITLE0, context0, 0, 0, 6, null);
            if(charSequence1 == null) {
                charSequence1 = "";
            }
        }
        boolean z = true;
        textView1.setText(charSequence1);
        this.firstInfoTitleTv.setText(chartReportRes$Response$YESTERCHARTINFO0.firstInfoLabel);
        this.firstInfoValueTv.setText(chartReportRes$Response$YESTERCHARTINFO0.firstInfoValue);
        this.secondInfoTitleTv.setText(chartReportRes$Response$YESTERCHARTINFO0.secondInfoLabel);
        this.secondInfoValueTv.setText(chartReportRes$Response$YESTERCHARTINFO0.secondInfoValue);
        TextView textView2 = this.recordTv;
        if(chartReportRes$Response$YESTERCHARTINFO0.recordList == null || !chartReportRes$Response$YESTERCHARTINFO0.recordList.isEmpty() != 1) {
            z = false;
        }
        ViewUtils.showWhen(textView2, z);
        TextView textView3 = this.recordTv;
        List list0 = chartReportRes$Response$YESTERCHARTINFO0.recordList;
        if(list0 != null) {
            RECORD chartReportRes$Response$YESTERCHARTINFO$RECORD0 = (RECORD)p.n0(0, list0);
            if(chartReportRes$Response$YESTERCHARTINFO$RECORD0 != null) {
                charSequence0 = chartReportRes$Response$YESTERCHARTINFO$RECORD0.record;
            }
        }
        textView3.setText(charSequence0);
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

