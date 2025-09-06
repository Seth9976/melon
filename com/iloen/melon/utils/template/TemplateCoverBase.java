package com.iloen.melon.utils.template;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import m4.e;
import m4.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\"\b\'\u0018\u0000 T2\u00020\u0001:\u0001TB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH$\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0013\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\u0011j\b\u0012\u0004\u0012\u00020\u000B`\u0012H$\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001A\u0004\u0018\u00010\u000EH\u0004\u00A2\u0006\u0004\b\u0015\u0010\u0010J\u0017\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u000BH\u0004\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0015\u0010\u001D\u001A\u00020\u000B2\u0006\u0010\u001C\u001A\u00020\u000B\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0019\u0010!\u001A\u00020\u000B2\b\u0010 \u001A\u0004\u0018\u00010\u001FH\u0004\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b#\u0010\rR\u0017\u0010%\u001A\u00020$8\u0006\u00A2\u0006\f\n\u0004\b%\u0010&\u001A\u0004\b\'\u0010(R\u0016\u0010*\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001A\u00020$8\u0004@\u0004X\u0085\u000E\u00A2\u0006\u0006\n\u0004\b,\u0010&R\u0016\u0010.\u001A\u00020-8\u0004@\u0004X\u0085\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001A\u0002008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b1\u00102R\"\u00104\u001A\u0002038\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b4\u00105\u001A\u0004\b4\u00106\"\u0004\b7\u00108R$\u00109\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b9\u0010:\u001A\u0004\b;\u0010\u0010\"\u0004\b<\u0010=R\u0019\u0010>\u001A\u0004\u0018\u00010\u000E8\u0006\u00A2\u0006\f\n\u0004\b>\u0010:\u001A\u0004\b?\u0010\u0010R*\u0010@\u001A\u0016\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u000E\u0018\u0001`\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010AR&\u0010B\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\u0011j\b\u0012\u0004\u0012\u00020\u000B`\u00128\u0004@\u0004X\u0085\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010AR\u0014\u0010D\u001A\u00020\u000B8DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\bC\u0010\rR\u0011\u0010F\u001A\u00020\u000E8F\u00A2\u0006\u0006\u001A\u0004\bE\u0010\u0010R\u0011\u0010H\u001A\u00020\u000E8F\u00A2\u0006\u0006\u001A\u0004\bG\u0010\u0010R\u0011\u0010J\u001A\u00020\u000E8F\u00A2\u0006\u0006\u001A\u0004\bI\u0010\u0010R\u0011\u0010L\u001A\u00020\u000E8F\u00A2\u0006\u0006\u001A\u0004\bK\u0010\u0010R\u0011\u0010N\u001A\u00020\u000E8F\u00A2\u0006\u0006\u001A\u0004\bM\u0010\u0010R\u0011\u0010O\u001A\u0002038F\u00A2\u0006\u0006\u001A\u0004\bO\u00106R\u0019\u0010Q\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u00118F\u00A2\u0006\u0006\u001A\u0004\bP\u0010\u0014R\u0016\u0010S\u001A\u0004\u0018\u00010\u000E8DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\bR\u0010\u0010\u00A8\u0006U"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateCoverBase;", "", "Lcom/iloen/melon/utils/template/TemplateData;", "templateData", "<init>", "(Lcom/iloen/melon/utils/template/TemplateData;)V", "Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;", "listener", "Lie/H;", "load", "(Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;)V", "", "getLayoutResId", "()I", "", "getTemplateCacheKey", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getViewIds", "()Ljava/util/ArrayList;", "getSubType", "index", "getImageData", "(I)Ljava/lang/String;", "Landroid/graphics/drawable/GradientDrawable;", "getBgColorDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "defaultColor", "getTitleColor", "(I)I", "Landroid/graphics/Bitmap;", "bitmap", "getRepresentativeColor", "(Landroid/graphics/Bitmap;)I", "getDefalutShadowColor", "Landroid/view/View;", "targetCoverView", "Landroid/view/View;", "getTargetCoverView", "()Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "templateView", "", "standardSizeDp", "F", "Lcom/iloen/melon/utils/template/TemplateCoverInfo;", "coverInfo", "Lcom/iloen/melon/utils/template/TemplateCoverInfo;", "", "isShowTitle", "Z", "()Z", "setShowTitle", "(Z)V", "debugCoverName", "Ljava/lang/String;", "getDebugCoverName", "setDebugCoverName", "(Ljava/lang/String;)V", "animationImgUrl", "getAnimationImgUrl", "imageList", "Ljava/util/ArrayList;", "viewResId", "getImageListSize", "imageListSize", "getTitle", "title", "getTitleLine1", "titleLine1", "getTitleLine2", "titleLine2", "getSubTitle", "subTitle", "getArtistName", "artistName", "isShowMelonLogo", "getBgColors", "bgColors", "getTextShadowColor", "textShadowColor", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class TemplateCoverBase {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateCoverBase$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "STANDARD_SIZE_150_MIN", "I", "STANDARD_SIZE_96_MIN", "STANDARD_SIZE_50_MIN", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int STANDARD_SIZE_150_MIN = 0x90;
    private static final int STANDARD_SIZE_50_MIN = 0;
    private static final int STANDARD_SIZE_96_MIN = 85;
    @NotNull
    private static final String TAG = "TemplateCoverBase";
    @Nullable
    private final String animationImgUrl;
    @NotNull
    public Context context;
    @NotNull
    private final TemplateCoverInfo coverInfo;
    @Nullable
    private String debugCoverName;
    @Nullable
    private ArrayList imageList;
    private boolean isShowTitle;
    protected float standardSizeDp;
    @NotNull
    private final View targetCoverView;
    @NotNull
    protected View templateView;
    @NotNull
    protected ArrayList viewResId;

    static {
        TemplateCoverBase.Companion = new Companion(null);
        TemplateCoverBase.$stable = 8;
    }

    public TemplateCoverBase(@NotNull TemplateData templateData0) {
        q.g(templateData0, "templateData");
        super();
        this.standardSizeDp = -1.0f;
        this.isShowTitle = true;
        View view0 = templateData0.getTargetView();
        this.targetCoverView = view0;
        Context context0 = view0.getContext();
        q.f(context0, "getContext(...)");
        this.context = context0;
        if(view0 instanceof CoverView) {
            this.standardSizeDp = ((CoverView)view0).getStandardSize();
        }
        else if(view0 instanceof ImageView) {
            this.standardSizeDp = (float)templateData0.standardSizeDp;
        }
        TemplateCoverInfo templateCoverInfo0 = templateData0.getTemplateCoverInfo();
        this.coverInfo = templateCoverInfo0;
        this.isShowTitle = templateData0.getShowTitle();
        this.animationImgUrl = templateData0.getAnimationImgUrl();
        this.imageList = templateCoverInfo0.getImages();
        this.viewResId = this.getViewIds();
        View view1 = LayoutInflater.from(view0.getContext()).inflate(this.getLayoutResId(), null, false);
        q.f(view1, "inflate(...)");
        this.templateView = view1;
        LogU.Companion.d("TemplateCoverBase", "Constructor() - standardSizeDp: " + this.standardSizeDp);
    }

    @Nullable
    public final String getAnimationImgUrl() {
        return this.animationImgUrl;
    }

    @NotNull
    public final String getArtistName() {
        String s = this.coverInfo.getArtistName();
        return s == null ? "" : s;
    }

    @Nullable
    public GradientDrawable getBgColorDrawable() {
        ArrayList arrayList0 = this.coverInfo.getBgColors();
        int v = ColorUtils.getColor(this.context, 0x7F06048A);  // color:transparent
        if(arrayList0 != null) {
            if(arrayList0.size() > 1) {
                v = ColorUtils.getColorFromHexStr(((String)arrayList0.get(0)));
                int v1 = ColorUtils.getColorFromHexStr(((String)arrayList0.get(1)));
                return new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{v, v1});
            }
            if(arrayList0.size() > 0) {
                v = ColorUtils.getColorFromHexStr(((String)arrayList0.get(0)));
            }
        }
        return new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{v, v});
    }

    @Nullable
    public final ArrayList getBgColors() {
        return this.coverInfo.getBgColors();
    }

    @Nullable
    public final String getDebugCoverName() {
        return this.debugCoverName;
    }

    // 去混淆评级： 低(20)
    public int getDefalutShadowColor() {
        return ScreenUtils.isDarkMode(this.context) ? ColorUtils.getColor(this.context, 0x7F060082) : ColorUtils.getColor(this.context, 0x7F060096);  // color:color_303030
    }

    @NotNull
    public final String getImageData(int v) {
        ArrayList arrayList0 = this.imageList;
        if(arrayList0 != null && v < arrayList0.size()) {
            Object object0 = arrayList0.get(v);
            q.f(object0, "get(...)");
            return (String)object0;
        }
        return "";
    }

    public final int getImageListSize() {
        return this.imageList == null ? 0 : this.imageList.size();
    }

    public abstract int getLayoutResId();

    public final int getRepresentativeColor(@Nullable Bitmap bitmap0) {
        if(bitmap0 != null) {
            e e0 = new e(bitmap0);
            e0.a = 24;
            g g0 = e0.a().e;
            return g0 == null ? ColorUtils.getColor(this.context, 0x7F06048A) : g0.d;  // color:transparent
        }
        return ColorUtils.getColor(this.context, 0x7F06048A);  // color:transparent
    }

    @NotNull
    public final String getSubTitle() {
        String s = this.coverInfo.getSubTitle();
        return s == null ? "" : s;
    }

    @Nullable
    public final String getSubType() {
        return this.coverInfo.getSubType();
    }

    @NotNull
    public final View getTargetCoverView() {
        return this.targetCoverView;
    }

    @NotNull
    public String getTemplateCacheKey() {
        StringBuilder stringBuilder0 = new StringBuilder(this.getClass().getSimpleName());
        int v = this.viewResId.size();
        for(int v1 = 0; v1 < v; ++v1) {
            stringBuilder0.append("_");
            stringBuilder0.append(this.getImageData(v1));
        }
        ArrayList arrayList0 = this.getBgColors();
        if(arrayList0 != null) {
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                stringBuilder0.append("_");
                stringBuilder0.append(((String)object0));
            }
        }
        if(!TextUtils.isEmpty(this.getTitle())) {
            stringBuilder0.append("_");
            stringBuilder0.append(this.getTitle());
        }
        if(!TextUtils.isEmpty(this.getSubTitle())) {
            stringBuilder0.append("_");
            stringBuilder0.append(this.getSubTitle());
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        String s1 = FileUtils.INSTANCE.makeSafeFileNameByMD5(s) + "_" + this.standardSizeDp;
        q.f(s1, "toString(...)");
        return s1;
    }

    @Nullable
    public final String getTextShadowColor() {
        return this.coverInfo.getTextShadowColor();
    }

    @NotNull
    public final String getTitle() {
        String s = this.coverInfo.getTitle();
        return s == null ? "" : s;
    }

    // 去混淆评级： 低(20)
    public final int getTitleColor(int v) {
        return TextUtils.isEmpty(this.coverInfo.getTitleColor()) ? v : ColorUtils.getColorFromHexStr(this.coverInfo.getTitleColor());
    }

    @NotNull
    public final String getTitleLine1() {
        String s = this.coverInfo.getTitleLine1();
        return s == null ? "" : s;
    }

    @NotNull
    public final String getTitleLine2() {
        String s = this.coverInfo.getTitleLine2();
        return s == null ? "" : s;
    }

    @NotNull
    public abstract ArrayList getViewIds();

    public final boolean isShowMelonLogo() {
        return this.coverInfo.isShowMelonLogo();
    }

    public final boolean isShowTitle() {
        return this.isShowTitle;
    }

    public abstract void load(@NotNull DownloadStateListener arg1);

    public final void setDebugCoverName(@Nullable String s) {
        this.debugCoverName = s;
    }

    public final void setShowTitle(boolean z) {
        this.isShowTitle = z;
    }
}

