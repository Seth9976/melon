package com.iloen.melon.fragments.melonchart;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.CHARTBASE.TITLE;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A&\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\b\b\u0003\u0010\u0005\u001A\u00020\u00062\b\b\u0003\u0010\u0007\u001A\u00020\u0006¨\u0006\b"}, d2 = {"getText", "", "Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$CHARTBASE$TITLE;", "context", "Landroid/content/Context;", "textColor", "", "highlightColor", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class MelonChartReportViewHoldersKt {
    @NotNull
    public static final CharSequence getText(@NotNull TITLE chartReportRes$Response$CHARTBASE$TITLE0, @NotNull Context context0, int v, int v1) {
        q.g(chartReportRes$Response$CHARTBASE$TITLE0, "<this>");
        q.g(context0, "context");
        SpannableString spannableString0 = new SpannableString(chartReportRes$Response$CHARTBASE$TITLE0.text);
        spannableString0.setSpan(new ForegroundColorSpan(ColorUtils.getColor(context0, v)), 0, spannableString0.length(), 33);
        SpannableString spannableString1 = new SpannableString(chartReportRes$Response$CHARTBASE$TITLE0.value);
        spannableString1.setSpan(new ForegroundColorSpan(ColorUtils.getColor(context0, v1)), 0, spannableString1.length(), 33);
        CharSequence charSequence0 = TextUtils.replace(spannableString0, new String[]{chartReportRes$Response$CHARTBASE$TITLE0.valuePlaceholder}, new SpannableString[]{spannableString1});
        q.f(charSequence0, "replace(...)");
        return charSequence0;
    }

    public static CharSequence getText$default(TITLE chartReportRes$Response$CHARTBASE$TITLE0, Context context0, int v, int v1, int v2, Object object0) {
        if((v2 & 2) != 0) {
            v = 0x7F06016D;  // color:gray900s
        }
        if((v2 & 4) != 0) {
            v1 = 0x7F06017C;  // color:green500s_support_high_contrast
        }
        return MelonChartReportViewHoldersKt.getText(chartReportRes$Response$CHARTBASE$TITLE0, context0, v, v1);
    }
}

