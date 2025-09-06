package com.iloen.melon.fragments.melonchart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.MelonBigButton;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.FOOTBUTTON;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fR\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u001C\u0010\u0010\u001A\n \u000F*\u0004\u0018\u00010\u000E0\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0012\u001A\n \u000F*\u0004\u0018\u00010\u000E0\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/FootButtonHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "Lcom/iloen/melon/fragments/melonchart/ChartReportActionListener;", "actionListener", "<init>", "(Landroid/view/View;Lcom/iloen/melon/fragments/melonchart/ChartReportActionListener;)V", "Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$FOOTBUTTON;", "data", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$FOOTBUTTON;)V", "Lcom/iloen/melon/fragments/melonchart/ChartReportActionListener;", "Lcom/iloen/melon/custom/MelonBigButton;", "kotlin.jvm.PlatformType", "firstBtn", "Lcom/iloen/melon/custom/MelonBigButton;", "secondBtn", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FootButtonHolder extends O0 {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/FootButtonHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/melonchart/FootButtonHolder;", "parent", "Landroid/view/ViewGroup;", "listener", "Lcom/iloen/melon/fragments/melonchart/ChartReportActionListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final FootButtonHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull ChartReportActionListener chartReportActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(chartReportActionListener0, "listener");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D046D, viewGroup0, false);  // layout:listitem_chart_report_foot_button
            q.d(view0);
            return new FootButtonHolder(view0, chartReportActionListener0);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final ChartReportActionListener actionListener;
    private final MelonBigButton firstBtn;
    private final MelonBigButton secondBtn;

    static {
        FootButtonHolder.Companion = new Companion(null);
        FootButtonHolder.$stable = 8;
    }

    public FootButtonHolder(@NotNull View view0, @Nullable ChartReportActionListener chartReportActionListener0) {
        q.g(view0, "itemView");
        super(view0);
        this.actionListener = chartReportActionListener0;
        this.firstBtn = (MelonBigButton)view0.findViewById(0x7F0A0161);  // id:btn_first
        this.secondBtn = (MelonBigButton)view0.findViewById(0x7F0A01A8);  // id:btn_second
    }

    public final void bind(@NotNull FOOTBUTTON chartReportRes$Response$FOOTBUTTON0) {
        q.g(chartReportRes$Response$FOOTBUTTON0, "data");
        if(chartReportRes$Response$FOOTBUTTON0.prevButton == null) {
            this.firstBtn.setVisibility(8);
        }
        else {
            this.firstBtn.setVisibility(0);
            this.firstBtn.setText(chartReportRes$Response$FOOTBUTTON0.prevButton.label);
            a a0 = new a(0, this, chartReportRes$Response$FOOTBUTTON0);
            this.firstBtn.setOnClickListener(a0);
        }
        if(chartReportRes$Response$FOOTBUTTON0.nextButton != null) {
            this.secondBtn.setVisibility(0);
            this.secondBtn.setText(chartReportRes$Response$FOOTBUTTON0.nextButton.label);
            a a1 = new a(1, this, chartReportRes$Response$FOOTBUTTON0);
            this.secondBtn.setOnClickListener(a1);
            return;
        }
        this.secondBtn.setVisibility(8);
    }

    private static final void bind$lambda$0(FootButtonHolder footButtonHolder0, FOOTBUTTON chartReportRes$Response$FOOTBUTTON0, View view0) {
        ChartReportActionListener chartReportActionListener0 = footButtonHolder0.actionListener;
        if(chartReportActionListener0 != null) {
            String s = chartReportRes$Response$FOOTBUTTON0.prevButton.songId;
            q.f(s, "songId");
            chartReportActionListener0.loadNewSong(s, false);
        }
    }

    private static final void bind$lambda$1(FootButtonHolder footButtonHolder0, FOOTBUTTON chartReportRes$Response$FOOTBUTTON0, View view0) {
        ChartReportActionListener chartReportActionListener0 = footButtonHolder0.actionListener;
        if(chartReportActionListener0 != null) {
            String s = chartReportRes$Response$FOOTBUTTON0.nextButton.songId;
            q.f(s, "songId");
            chartReportActionListener0.loadNewSong(s, true);
        }
    }
}

