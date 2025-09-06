package com.iloen.melon.fragments.melonchart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.LISTENERDATA;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u001C\u0010\r\u001A\n \f*\u0004\u0018\u00010\u000B0\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000ER\u001C\u0010\u000F\u001A\n \f*\u0004\u0018\u00010\u000B0\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u000E¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/ListenerDataHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$LISTENERDATA;", "data", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$LISTENERDATA;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "hourListenerTv", "Landroid/widget/TextView;", "dailyListenerTv", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ListenerDataHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/ListenerDataHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/melonchart/ListenerDataHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ListenerDataHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D046E, viewGroup0, false);  // layout:listitem_chart_report_listener_data
            q.d(view0);
            return new ListenerDataHolder(view0);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    private final TextView dailyListenerTv;
    private final TextView hourListenerTv;

    static {
        ListenerDataHolder.Companion = new Companion(null);
        ListenerDataHolder.$stable = 8;
    }

    public ListenerDataHolder(@NotNull View view0) {
        q.g(view0, "itemView");
        super(view0);
        this.hourListenerTv = (TextView)view0.findViewById(0x7F0A0C8B);  // id:tv_hour_listener
        this.dailyListenerTv = (TextView)view0.findViewById(0x7F0A0C57);  // id:tv_daily_listener
    }

    public final void bind(@NotNull LISTENERDATA chartReportRes$Response$LISTENERDATA0) {
        q.g(chartReportRes$Response$LISTENERDATA0, "data");
        TextView textView0 = this.hourListenerTv;
        if(textView0 != null) {
            textView0.setText(chartReportRes$Response$LISTENERDATA0.oneHour);
        }
        TextView textView1 = this.dailyListenerTv;
        if(textView1 != null) {
            textView1.setText(chartReportRes$Response$LISTENERDATA0.oneDay);
        }
    }
}

