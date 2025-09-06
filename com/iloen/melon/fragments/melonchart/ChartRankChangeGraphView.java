package com.iloen.melon.fragments.melonchart;

import A7.d;
import U4.x;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.CHARTBASE.DATA;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.CHARTBASE.XLABEL;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.RANKCHART;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import d5.f;
import java.util.List;
import je.n;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 i2\u00020\u0001:\u0002ijB\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0012J/\u0010\u001A\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\'\u0010\u001C\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001E\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u001E\u0010\u0012J\'\u0010\u001F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\b\u001F\u0010\u001DJ\'\u0010 \u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\b \u0010!J\u0017\u0010\"\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\n\u00A2\u0006\u0004\b\"\u0010\u000EJ/\u0010\'\u001A\u00020\f2\u0006\u0010#\u001A\u00020\u00062\u0006\u0010$\u001A\u00020\u00062\u0006\u0010%\u001A\u00020\u00062\u0006\u0010&\u001A\u00020\u0006H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010)\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b)\u0010\u0012R*\u0010,\u001A\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b,\u0010-\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00103\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b3\u00104\u001A\u0004\b5\u00106\"\u0004\b7\u00108R\u0014\u00109\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b;\u0010:R\u0016\u0010<\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010=\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010:R\u0016\u0010>\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u0010:R\u0016\u0010?\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010:R\u0014\u0010@\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b@\u0010:R\u0014\u0010A\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bC\u0010BR\u0014\u0010E\u001A\u00020D8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bG\u0010:R\u0014\u0010H\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bH\u0010:R\u0014\u0010I\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bI\u0010:R\u0014\u0010K\u001A\u00020J8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001A\u00020D8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bM\u0010FR\u0014\u0010O\u001A\u00020N8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010Q\u001A\u00020D8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bQ\u0010FR\u0014\u0010R\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bR\u0010BR\u0014\u0010S\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bS\u0010BR\u0014\u0010U\u001A\u00020T8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010W\u001A\u00020T8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bW\u0010VR\u001C\u0010Z\u001A\n Y*\u0004\u0018\u00010X0X8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010\\\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\\\u0010:R\u0014\u0010]\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b]\u0010:R\u0014\u0010^\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b^\u0010:R\u0014\u0010_\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b_\u0010:R\u0014\u0010`\u001A\u00020D8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b`\u0010FR\u0014\u0010a\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\ba\u0010:R\u0014\u0010b\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bb\u0010:R\u0014\u0010c\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bc\u0010:R\u0014\u0010d\u001A\u00020D8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bd\u0010FR\u0014\u0010e\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\be\u0010:R\u0014\u0010f\u001A\u00020D8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bf\u0010FR\u0014\u0010g\u001A\u00020\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bg\u0010:R\u0014\u0010h\u001A\u00020D8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bh\u0010F\u00A8\u0006k"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/ChartRankChangeGraphView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$RANKCHART;", "dataSet", "Lie/H;", "preCalcData", "(Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$RANKCHART;)V", "Landroid/graphics/Canvas;", "canvas", "drawBg", "(Landroid/graphics/Canvas;)V", "drawHorizontalGuideLine", "drawDataLines", "index", "Lcom/iloen/melon/fragments/melonchart/ChartRankChangeGraphView$YData;", "yData", "", "x", "drawLineOrDot", "(Landroid/graphics/Canvas;ILcom/iloen/melon/fragments/melonchart/ChartRankChangeGraphView$YData;F)V", "drawVerticalGuideLine", "(Landroid/graphics/Canvas;Lcom/iloen/melon/fragments/melonchart/ChartRankChangeGraphView$YData;F)V", "drawLabels", "drawYLabelBalloon", "drawXLabel", "(Landroid/graphics/Canvas;IF)V", "setData", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "onDraw", "", "Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response$CHARTBASE$XLABEL;", "xDataList", "Ljava/util/List;", "getXDataList", "()Ljava/util/List;", "setXDataList", "(Ljava/util/List;)V", "", "yDataArray", "[Lcom/iloen/melon/fragments/melonchart/ChartRankChangeGraphView$YData;", "getYDataArray", "()[Lcom/iloen/melon/fragments/melonchart/ChartRankChangeGraphView$YData;", "setYDataArray", "([Lcom/iloen/melon/fragments/melonchart/ChartRankChangeGraphView$YData;)V", "yTopPadding", "F", "graphYRange", "ww", "hh", "paddingVertical", "interval", "radius", "defaultColor", "I", "highlightColor", "Landroid/graphics/Paint;", "bgPaint", "Landroid/graphics/Paint;", "dotRadius", "dashOffPx", "dashOnPx", "Landroid/graphics/DashPathEffect;", "dashEffect", "Landroid/graphics/DashPathEffect;", "graphPaint", "Landroid/graphics/Rect;", "rect", "Landroid/graphics/Rect;", "bitmapPaint", "defaultBalloonColor", "highlightBalloonColor", "Landroid/graphics/PorterDuffColorFilter;", "defaultBalloonColorFilter", "Landroid/graphics/PorterDuffColorFilter;", "highlightBalloonColorFilter", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "balloonBottomBitmap", "Landroid/graphics/Bitmap;", "balloonBottomXOffset", "balloonBottomYOffset", "balloonMinHalfWidth", "balloonHorizontalPadding", "balloonPaint", "balloonYOffset", "balloonHeight", "balloonTextYOffset", "balloonTextPaint", "horizontalLineY", "guideLinePaint", "bottomTextY", "bottomTextPaint", "Companion", "YData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ChartRankChangeGraphView extends View {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/ChartRankChangeGraphView$Companion;", "", "<init>", "()V", "TAG", "", "GRID_X", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0019\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u0018\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0007HÆ\u0003J\t\u0010\u001B\u001A\u00020\tHÆ\u0003J1\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tHÆ\u0001J\u0013\u0010\u001D\u001A\u00020\t2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020\u0007HÖ\u0001J\t\u0010 \u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/iloen/melon/fragments/melonchart/ChartRankChangeGraphView$YData;", "", "calculatedPxValue", "", "label", "", "type", "", "highlighting", "", "<init>", "(FLjava/lang/String;IZ)V", "getCalculatedPxValue", "()F", "getLabel", "()Ljava/lang/String;", "getType", "()I", "setType", "(I)V", "getHighlighting", "()Z", "setHighlighting", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class YData {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/ChartRankChangeGraphView$YData$Companion;", "", "<init>", "()V", "TYPE_NONE", "", "TYPE_DOT", "TYPE_LINE", "TYPE_DOTTED_LINE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.fragments.melonchart.ChartRankChangeGraphView.YData.Companion {
            private com.iloen.melon.fragments.melonchart.ChartRankChangeGraphView.YData.Companion() {
            }

            public com.iloen.melon.fragments.melonchart.ChartRankChangeGraphView.YData.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.fragments.melonchart.ChartRankChangeGraphView.YData.Companion Companion = null;
        public static final int TYPE_DOT = 1;
        public static final int TYPE_DOTTED_LINE = 3;
        public static final int TYPE_LINE = 2;
        public static final int TYPE_NONE;
        private final float calculatedPxValue;
        private boolean highlighting;
        @NotNull
        private final String label;
        private int type;

        static {
            YData.Companion = new com.iloen.melon.fragments.melonchart.ChartRankChangeGraphView.YData.Companion(null);
            YData.$stable = 8;
        }

        public YData(float f, @NotNull String s, int v, boolean z) {
            q.g(s, "label");
            super();
            this.calculatedPxValue = f;
            this.label = s;
            this.type = v;
            this.highlighting = z;
        }

        public YData(float f, String s, int v, boolean z, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v1 & 4) != 0) {
                v = 0;
            }
            if((v1 & 8) != 0) {
                z = false;
            }
            this(f, s, v, z);
        }

        public final float component1() {
            return this.calculatedPxValue;
        }

        @NotNull
        public final String component2() {
            return this.label;
        }

        public final int component3() {
            return this.type;
        }

        public final boolean component4() {
            return this.highlighting;
        }

        @NotNull
        public final YData copy(float f, @NotNull String s, int v, boolean z) {
            q.g(s, "label");
            return new YData(f, s, v, z);
        }

        public static YData copy$default(YData chartRankChangeGraphView$YData0, float f, String s, int v, boolean z, int v1, Object object0) {
            if((v1 & 1) != 0) {
                f = chartRankChangeGraphView$YData0.calculatedPxValue;
            }
            if((v1 & 2) != 0) {
                s = chartRankChangeGraphView$YData0.label;
            }
            if((v1 & 4) != 0) {
                v = chartRankChangeGraphView$YData0.type;
            }
            if((v1 & 8) != 0) {
                z = chartRankChangeGraphView$YData0.highlighting;
            }
            return chartRankChangeGraphView$YData0.copy(f, s, v, z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof YData)) {
                return false;
            }
            if(Float.compare(this.calculatedPxValue, ((YData)object0).calculatedPxValue) != 0) {
                return false;
            }
            if(!q.b(this.label, ((YData)object0).label)) {
                return false;
            }
            return this.type == ((YData)object0).type ? this.highlighting == ((YData)object0).highlighting : false;
        }

        public final float getCalculatedPxValue() {
            return this.calculatedPxValue;
        }

        public final boolean getHighlighting() {
            return this.highlighting;
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        public final int getType() {
            return this.type;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.highlighting) + d.b(this.type, x.b(Float.hashCode(this.calculatedPxValue) * 0x1F, 0x1F, this.label), 0x1F);
        }

        public final void setHighlighting(boolean z) {
            this.highlighting = z;
        }

        public final void setType(int v) {
            this.type = v;
        }

        @Override
        @NotNull
        public String toString() {
            return "YData(calculatedPxValue=" + this.calculatedPxValue + ", label=" + this.label + ", type=" + this.type + ", highlighting=" + this.highlighting + ")";
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int GRID_X = 8;
    @NotNull
    private static final String TAG = "ChartRankChangeGraphView";
    private final Bitmap balloonBottomBitmap;
    private final float balloonBottomXOffset;
    private final float balloonBottomYOffset;
    private final float balloonHeight;
    private final float balloonHorizontalPadding;
    private final float balloonMinHalfWidth;
    @NotNull
    private final Paint balloonPaint;
    @NotNull
    private final Paint balloonTextPaint;
    private final float balloonTextYOffset;
    private final float balloonYOffset;
    @NotNull
    private final Paint bgPaint;
    @NotNull
    private final Paint bitmapPaint;
    @NotNull
    private final Paint bottomTextPaint;
    private final float bottomTextY;
    @NotNull
    private final DashPathEffect dashEffect;
    private final float dashOffPx;
    private final float dashOnPx;
    private final int defaultBalloonColor;
    @NotNull
    private final PorterDuffColorFilter defaultBalloonColorFilter;
    private final int defaultColor;
    private final float dotRadius;
    @NotNull
    private final Paint graphPaint;
    private final float graphYRange;
    @NotNull
    private final Paint guideLinePaint;
    private float hh;
    private final int highlightBalloonColor;
    @NotNull
    private final PorterDuffColorFilter highlightBalloonColorFilter;
    private final int highlightColor;
    private final float horizontalLineY;
    private float interval;
    private float paddingVertical;
    private final float radius;
    @NotNull
    private final Rect rect;
    private float ww;
    @Nullable
    private List xDataList;
    @NotNull
    private YData[] yDataArray;
    private final float yTopPadding;

    static {
        ChartRankChangeGraphView.Companion = new Companion(null);
        ChartRankChangeGraphView.$stable = 8;
    }

    public ChartRankChangeGraphView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 0, 6, null);
    }

    public ChartRankChangeGraphView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 0, 4, null);
    }

    public ChartRankChangeGraphView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        this.yDataArray = new YData[8];
        this.yTopPadding = (float)ScreenUtils.dipToPixel(context0, 49.0f);
        this.graphYRange = (float)ScreenUtils.dipToPixel(context0, 120.0f);
        this.radius = (float)ScreenUtils.dipToPixel(context0, 4.0f);
        this.defaultColor = ColorUtils.getColor(context0, 0x7F060159);  // color:gray400s_support_high_contrast
        this.highlightColor = ColorUtils.getColor(context0, 0x7F06017C);  // color:green500s_support_high_contrast
        Paint paint0 = new Paint(1);
        paint0.setColor(ColorUtils.getColor(context0, 0x7F060143));  // color:gray031s
        this.bgPaint = paint0;
        this.dotRadius = (float)ScreenUtils.dipToPixel(context0, 1.5f);
        float f = (float)ScreenUtils.dipToPixel(context0, 2.0f);
        this.dashOffPx = f;
        float f1 = (float)ScreenUtils.dipToPixel(context0, 4.0f);
        this.dashOnPx = f1;
        this.dashEffect = new DashPathEffect(new float[]{f1, f}, 0.0f);
        Paint paint1 = new Paint(1);
        paint1.setStrokeWidth(((float)ScreenUtils.dipToPixel(context0, 1.0f)));
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);
        this.graphPaint = paint1;
        this.rect = new Rect();
        this.bitmapPaint = new Paint(1);
        int v1 = ColorUtils.getColor(context0, 0x7F060159);  // color:gray400s_support_high_contrast
        this.defaultBalloonColor = v1;
        int v2 = ColorUtils.getColor(context0, 0x7F06017A);  // color:green500e_support_high_contrast
        this.highlightBalloonColor = v2;
        PorterDuff.Mode porterDuff$Mode0 = PorterDuff.Mode.SRC_IN;
        this.defaultBalloonColorFilter = new PorterDuffColorFilter(v1, porterDuff$Mode0);
        this.highlightBalloonColorFilter = new PorterDuffColorFilter(v2, porterDuff$Mode0);
        this.balloonBottomBitmap = BitmapFactory.decodeResource(this.getResources(), 0x7F080617);  // drawable:img_bg_chart_number_bottom
        this.balloonBottomXOffset = (float)ScreenUtils.dipToPixel(context0, -4.5f);
        this.balloonBottomYOffset = (float)ScreenUtils.dipToPixel(context0, -8.0f);
        this.balloonMinHalfWidth = (float)ScreenUtils.dipToPixel(context0, 11.5f);
        this.balloonHorizontalPadding = (float)ScreenUtils.dipToPixel(context0, 5.0f);
        this.balloonPaint = new Paint(1);
        this.balloonYOffset = (float)ScreenUtils.dipToPixel(context0, -27.0f);
        this.balloonHeight = (float)ScreenUtils.dipToPixel(context0, 20.0f);
        this.balloonTextYOffset = (float)ScreenUtils.dipToPixel(context0, -13.0f);
        Paint paint2 = new Paint(1);
        paint2.setColor(ColorUtils.getColor(context0, 0x7F0604A1));  // color:white000e
        paint2.setTextSize(((float)ScreenUtils.dipToPixel(context0, 11.0f)));
        Paint.Align paint$Align0 = Paint.Align.CENTER;
        paint2.setTextAlign(paint$Align0);
        paint2.setTypeface(f.F(this.getContext()));
        this.balloonTextPaint = paint2;
        this.horizontalLineY = (float)ScreenUtils.dipToPixel(context0, 169.0f);
        Paint paint3 = new Paint(1);
        paint3.setColor(ColorUtils.getColor(context0, 0x7F06014A));  // color:gray100a
        paint3.setStrokeWidth(((float)ScreenUtils.dipToPixel(context0, 0.5f)));
        this.guideLinePaint = paint3;
        this.bottomTextY = (float)ScreenUtils.dipToPixel(context0, 187.0f);
        Paint paint4 = new Paint(1);
        paint4.setTextSize(((float)ScreenUtils.dipToPixel(context0, 11.0f)));
        paint4.setTextAlign(paint$Align0);
        paint4.setTypeface(f.G(context0));
        this.bottomTextPaint = paint4;
    }

    public ChartRankChangeGraphView(Context context0, AttributeSet attributeSet0, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            attributeSet0 = null;
        }
        if((v1 & 4) != 0) {
            v = 0;
        }
        this(context0, attributeSet0, v);
    }

    private final void drawBg(Canvas canvas0) {
        canvas0.drawRoundRect(0.0f, 0.0f, this.ww, this.hh, this.radius, this.radius, this.bgPaint);
    }

    private final void drawDataLines(Canvas canvas0) {
        float f = this.paddingVertical;
        for(int v = 0; v < 8; ++v) {
            YData chartRankChangeGraphView$YData0 = (YData)n.n0(v, this.yDataArray);
            if(chartRankChangeGraphView$YData0 != null) {
                this.drawLineOrDot(canvas0, v, chartRankChangeGraphView$YData0, f);
                this.drawVerticalGuideLine(canvas0, chartRankChangeGraphView$YData0, f);
            }
            f += this.interval;
        }
    }

    private final void drawHorizontalGuideLine(Canvas canvas0) {
        canvas0.drawLine(0.0f, this.horizontalLineY, this.ww, this.horizontalLineY, this.guideLinePaint);
    }

    private final void drawLabels(Canvas canvas0) {
        float f = this.paddingVertical;
        for(int v = 0; v < 8; ++v) {
            YData chartRankChangeGraphView$YData0 = (YData)n.n0(v, this.yDataArray);
            if(chartRankChangeGraphView$YData0 != null) {
                this.drawYLabelBalloon(canvas0, chartRankChangeGraphView$YData0, f);
            }
            this.drawXLabel(canvas0, v, f);
            f += this.interval;
        }
    }

    private final void drawLineOrDot(Canvas canvas0, int v, YData chartRankChangeGraphView$YData0, float f) {
        DashPathEffect dashPathEffect0 = null;
        switch(chartRankChangeGraphView$YData0.getType()) {
            case 1: {
                this.graphPaint.setColor((chartRankChangeGraphView$YData0.getHighlighting() ? this.highlightColor : this.defaultColor));
                this.graphPaint.setPathEffect(null);
                canvas0.drawCircle(f, chartRankChangeGraphView$YData0.getCalculatedPxValue(), this.dotRadius, this.graphPaint);
                return;
            }
            case 2: 
            case 3: {
                YData chartRankChangeGraphView$YData1 = (YData)n.n0(v - 1, this.yDataArray);
                if(chartRankChangeGraphView$YData1 != null) {
                    this.graphPaint.setColor((chartRankChangeGraphView$YData0.getHighlighting() ? this.highlightColor : this.defaultColor));
                    Paint paint0 = this.graphPaint;
                    if(chartRankChangeGraphView$YData0.getType() == 3) {
                        dashPathEffect0 = this.dashEffect;
                    }
                    paint0.setPathEffect(dashPathEffect0);
                    canvas0.drawLine(f - this.interval, chartRankChangeGraphView$YData1.getCalculatedPxValue(), f, chartRankChangeGraphView$YData0.getCalculatedPxValue(), this.graphPaint);
                }
            }
        }
    }

    private final void drawVerticalGuideLine(Canvas canvas0, YData chartRankChangeGraphView$YData0, float f) {
        canvas0.drawLine(f, chartRankChangeGraphView$YData0.getCalculatedPxValue(), f, this.horizontalLineY, this.guideLinePaint);
    }

    private final void drawXLabel(Canvas canvas0, int v, float f) {
        List list0 = this.xDataList;
        if(list0 != null) {
            XLABEL chartReportRes$Response$CHARTBASE$XLABEL0 = (XLABEL)p.n0(v, list0);
            if(chartReportRes$Response$CHARTBASE$XLABEL0 != null) {
                this.bottomTextPaint.setColor((chartReportRes$Response$CHARTBASE$XLABEL0.highlighting ? this.highlightColor : this.defaultColor));
                canvas0.drawText(chartReportRes$Response$CHARTBASE$XLABEL0.xLabel, f, this.bottomTextY, this.bottomTextPaint);
            }
        }
    }

    private final void drawYLabelBalloon(Canvas canvas0, YData chartRankChangeGraphView$YData0, float f) {
        this.bitmapPaint.setColorFilter((chartRankChangeGraphView$YData0.getHighlighting() ? this.highlightBalloonColorFilter : this.defaultBalloonColorFilter));
        canvas0.drawBitmap(this.balloonBottomBitmap, this.balloonBottomXOffset + f, chartRankChangeGraphView$YData0.getCalculatedPxValue() + this.balloonBottomYOffset, this.bitmapPaint);
        this.balloonTextPaint.getTextBounds(chartRankChangeGraphView$YData0.getLabel(), 0, chartRankChangeGraphView$YData0.getLabel().length(), this.rect);
        float f1 = Math.max(((float)(this.rect.width() / 2)) + this.balloonHorizontalPadding, this.balloonMinHalfWidth);
        float f2 = chartRankChangeGraphView$YData0.getCalculatedPxValue() + this.balloonYOffset;
        this.balloonPaint.setColor((chartRankChangeGraphView$YData0.getHighlighting() ? this.highlightBalloonColor : this.defaultBalloonColor));
        canvas0.drawRoundRect(f + -f1, f2, f - -f1, f2 + this.balloonHeight, this.radius, this.radius, this.balloonPaint);
        canvas0.drawText(chartRankChangeGraphView$YData0.getLabel(), f, chartRankChangeGraphView$YData0.getCalculatedPxValue() + this.balloonTextYOffset, this.balloonTextPaint);
    }

    @Nullable
    public final List getXDataList() {
        return this.xDataList;
    }

    @NotNull
    public final YData[] getYDataArray() {
        return this.yDataArray;
    }

    @Override  // android.view.View
    public void onDraw(@NotNull Canvas canvas0) {
        q.g(canvas0, "canvas");
        super.onDraw(canvas0);
        this.drawBg(canvas0);
        this.drawHorizontalGuideLine(canvas0);
        this.drawDataLines(canvas0);
        this.drawLabels(canvas0);
    }

    @Override  // android.view.View
    public void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        this.ww = (float)v;
        this.hh = (float)v1;
        this.paddingVertical = 0.075f * ((float)v);
        this.interval = (((float)v) - 2.0f * (0.075f * ((float)v))) / 7.0f;
    }

    private final void preCalcData(RANKCHART chartReportRes$Response$RANKCHART0) {
        List list0;
        for(int v = 0; true; ++v) {
            list0 = null;
            if(v >= 8) {
                break;
            }
            this.yDataArray[v] = null;
        }
        if(chartReportRes$Response$RANKCHART0 != null) {
            list0 = chartReportRes$Response$RANKCHART0.xLabels;
        }
        this.xDataList = list0;
        if(chartReportRes$Response$RANKCHART0 != null) {
            float f = (float)(chartReportRes$Response$RANKCHART0.yMaximum - chartReportRes$Response$RANKCHART0.yMinimum);
            List list1 = chartReportRes$Response$RANKCHART0.predictedData;
            if(list1 != null) {
                for(Object object0: list1) {
                    float f1 = ((float)(((DATA)object0).value - chartReportRes$Response$RANKCHART0.yMinimum)) / f * this.graphYRange + this.yTopPadding;
                    String s = ((DATA)object0).label;
                    q.f(s, "label");
                    this.yDataArray[((DATA)object0).xIndex] = new YData(f1, s, 3, ((DATA)object0).highlighting);
                }
            }
            List list2 = chartReportRes$Response$RANKCHART0.data;
            if(list2 != null) {
                for(Object object1: list2) {
                    float f2 = ((float)(((DATA)object1).value - chartReportRes$Response$RANKCHART0.yMinimum)) / f * this.graphYRange + this.yTopPadding;
                    String s1 = ((DATA)object1).label;
                    q.f(s1, "label");
                    this.yDataArray[((DATA)object1).xIndex] = new YData(f2, s1, 2, ((DATA)object1).highlighting);
                }
            }
            YData[] arr_chartRankChangeGraphView$YData = this.yDataArray;
            int v1 = 0;
            for(int v2 = 0; v1 < arr_chartRankChangeGraphView$YData.length; ++v2) {
                YData chartRankChangeGraphView$YData0 = arr_chartRankChangeGraphView$YData[v1];
                if(chartRankChangeGraphView$YData0 != null) {
                    YData chartRankChangeGraphView$YData1 = (YData)n.n0(v2 - 1, this.yDataArray);
                    if(chartRankChangeGraphView$YData1 == null && ((YData)n.n0(v2 + 1, this.yDataArray)) == null) {
                        chartRankChangeGraphView$YData0.setType(1);
                    }
                    else if(chartRankChangeGraphView$YData1 == null) {
                        chartRankChangeGraphView$YData0.setType(0);
                    }
                }
                ++v1;
            }
        }
    }

    public final void setData(@Nullable RANKCHART chartReportRes$Response$RANKCHART0) {
        this.preCalcData(chartReportRes$Response$RANKCHART0);
        this.invalidate();
    }

    public final void setXDataList(@Nullable List list0) {
        this.xDataList = list0;
    }

    public final void setYDataArray(@NotNull YData[] arr_chartRankChangeGraphView$YData) {
        q.g(arr_chartRankChangeGraphView$YData, "<set-?>");
        this.yDataArray = arr_chartRankChangeGraphView$YData;
    }
}

