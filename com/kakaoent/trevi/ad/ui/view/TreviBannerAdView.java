package com.kakaoent.trevi.ad.ui.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.kakaoent.trevi.ad.R.styleable;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\u0018\u0000 \u001E2\u00020\u0001:\u0002\u001F\u001EB\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\fH\u0014¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0013\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0016\u0010\u001B\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001AR\u0016\u0010\u001C\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001AR\u0016\u0010\u001D\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001A¨\u0006 "}, d2 = {"Lcom/kakaoent/trevi/ad/ui/view/TreviBannerAdView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/content/res/Configuration;", "newConfig", "Lie/H;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDetachedFromWindow", "()V", "destroyTimer", "", "isDarkStatic", "Z", "Ljava/util/Timer;", "vImpTimer", "Ljava/util/Timer;", "", "askVImp", "Ljava/lang/String;", "askClick", "vimpUrl", "clickUrl", "Companion", "AssetValueType", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviBannerAdView extends FrameLayout {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\r¨\u0006\u000E"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/view/TreviBannerAdView$AssetValueType;", "", "(Ljava/lang/String;I)V", "MAIN_IMAGE", "LOGO_IMAGE", "TEXT_IMAGE", "THUMBNAIL_IMAGE", "PRE_IMAGE", "POST_IMAGE", "MAIN_VIDEO", "DESCRIPTION", "CTA_TEXT", "MAIN_TITLE", "SUB_TITLE", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static enum AssetValueType {
        MAIN_IMAGE,
        LOGO_IMAGE,
        TEXT_IMAGE,
        THUMBNAIL_IMAGE,
        PRE_IMAGE,
        POST_IMAGE,
        MAIN_VIDEO,
        DESCRIPTION,
        CTA_TEXT,
        MAIN_TITLE,
        SUB_TITLE;

        private static final a $ENTRIES;
        private static final AssetValueType[] $VALUES;

        private static final AssetValueType[] $values() [...] // Inlined contents

        static {
            AssetValueType.$VALUES = arr_treviBannerAdView$AssetValueType;
            q.g(arr_treviBannerAdView$AssetValueType, "entries");
            AssetValueType.$ENTRIES = new b(arr_treviBannerAdView$AssetValueType);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/view/TreviBannerAdView$Companion;", "", "()V", "IMPRESSION_CHECK_INTERVAL", "", "IMPRESSION_SEND_TIME", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private String askClick;
    @NotNull
    private String askVImp;
    @NotNull
    private String clickUrl;
    private boolean isDarkStatic;
    @Nullable
    private Timer vImpTimer;
    @NotNull
    private String vimpUrl;

    static {
        TreviBannerAdView.Companion = new Companion(null);
    }

    public TreviBannerAdView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 0, 6, null);
    }

    public TreviBannerAdView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 0, 4, null);
    }

    public TreviBannerAdView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        this.askVImp = "";
        this.askClick = "";
        this.vimpUrl = "";
        this.clickUrl = "";
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, R.styleable.TreviBannerAdView);
        this.isDarkStatic = typedArray0.getBoolean(R.styleable.TreviBannerAdView_isDarkStatic, false);
        typedArray0.recycle();
    }

    public TreviBannerAdView(Context context0, AttributeSet attributeSet0, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            attributeSet0 = null;
        }
        if((v1 & 4) != 0) {
            v = 0;
        }
        this(context0, attributeSet0, v);
    }

    private final void destroyTimer() {
        Timer timer0 = this.vImpTimer;
        if(timer0 != null) {
            timer0.cancel();
        }
        this.vImpTimer = null;
    }

    @Override  // android.view.View
    public void onConfigurationChanged(@Nullable Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
    }

    @Override  // android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.destroyTimer();
    }
}

