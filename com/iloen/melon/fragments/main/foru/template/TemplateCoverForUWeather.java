package com.iloen.melon.fragments.main.foru.template;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.template.TemplateCoverBase;
import com.iloen.melon.utils.template.TemplateData;
import com.iloen.melon.utils.template.TemplateImageLoader.DownloadStateListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import x1.a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000B\u0010\nJ\u000F\u0010\r\u001A\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0014\u001A\u0012\u0012\u0004\u0012\u00020\f0\u0012j\b\u0012\u0004\u0012\u00020\f`\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0016\u0010\u001B\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001A¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/template/TemplateCoverForUWeather;", "Lcom/iloen/melon/utils/template/TemplateCoverBase;", "Lcom/iloen/melon/utils/template/TemplateData;", "templateData", "<init>", "(Lcom/iloen/melon/utils/template/TemplateData;)V", "Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;", "listener", "Lie/H;", "checkDownloadCompleted", "(Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;)V", "load", "", "getLayoutResId", "()I", "", "getTemplateCacheKey", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getViewIds", "()Ljava/util/ArrayList;", "downCnt", "I", "", "enableCache", "Z", "loadFailed", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TemplateCoverForUWeather extends TemplateCoverBase {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/template/TemplateCoverForUWeather$Companion;", "", "<init>", "()V", "STANDARD_SIZE_144_MIN", "", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final Companion Companion = null;
    @Deprecated
    public static final int STANDARD_SIZE_144_MIN = 0x90;
    @Deprecated
    @NotNull
    public static final String TAG = "TemplateCoverForUImage";
    private int downCnt;
    private boolean enableCache;
    private boolean loadFailed;

    static {
        TemplateCoverForUWeather.Companion = new Companion(null);
        TemplateCoverForUWeather.$stable = 8;
    }

    public TemplateCoverForUWeather(@NotNull TemplateData templateData0) {
        q.g(templateData0, "templateData");
        super(templateData0);
        this.enableCache = true;
    }

    private final void checkDownloadCompleted(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        if(!this.loadFailed) {
            int v = this.downCnt + 1;
            this.downCnt = v;
            if(v >= this.getImageListSize() || this.downCnt >= this.viewResId.size()) {
                templateImageLoader$DownloadStateListener0.onDownloadCompleted(this.templateView, this.enableCache);
            }
        }
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public int getLayoutResId() {
        return this.standardSizeDp > 144.0f ? 0x7F0D01D3 : 0x7F0D01D2;  // layout:cover_template_foru_weather_200
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    @NotNull
    public String getTemplateCacheKey() {
        StringBuilder stringBuilder0 = new StringBuilder("TemplateCoverForUImage");
        int v = this.viewResId.size();
        for(int v1 = 0; v1 < v; ++v1) {
            stringBuilder0.append("_");
            stringBuilder0.append(this.getImageData(v1));
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        String s1 = FileUtils.INSTANCE.makeSafeFileNameByMD5(s) + "_" + this.standardSizeDp;
        q.f(s1, "toString(...)");
        return s1;
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    @NotNull
    public ArrayList getViewIds() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(0x7F0A0617);  // id:iv_cover
        return arrayList0;
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public void load(@NotNull DownloadStateListener templateImageLoader$DownloadStateListener0) {
        q.g(templateImageLoader$DownloadStateListener0, "listener");
        if(this.getImageListSize() > 0) {
            int v1 = this.viewResId.size();
            for(int v = 0; v < v1; ++v) {
                View view0 = this.templateView;
                Object object0 = this.viewResId.get(v);
                q.f(object0, "get(...)");
                if(((ImageView)view0.findViewById(((Number)object0).intValue())) != null) {
                    ((RequestBuilder)Glide.with(this.context).load(this.getImageData(v)).override(200)).into(new CustomTarget() {
                        @Override  // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable drawable0) {
                        }

                        @Override  // com.bumptech.glide.request.target.CustomTarget
                        public void onLoadFailed(Drawable drawable0) {
                            super.onLoadFailed(drawable0);
                            templateImageLoader$DownloadStateListener0.loadFailed = true;
                            templateImageLoader$DownloadStateListener0.checkDownloadCompleted(this.$listener);
                        }

                        public void onResourceReady(Drawable drawable0, Transition transition0) {
                            q.g(drawable0, "resource");
                            if(drawable0 instanceof Animatable) {
                                templateImageLoader$DownloadStateListener0.enableCache = false;
                                View view0 = templateImageLoader$DownloadStateListener0.getTargetCoverView();
                                q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.CoverView");
                                ((CoverView)view0).getAnimationView().setImageDrawable(drawable0);
                                a.l(((Animatable)drawable0));
                            }
                            else {
                                ((ImageView)templateImageLoader$DownloadStateListener0.templateView.findViewById(0x7F0A0617)).setImageDrawable(drawable0);  // id:iv_cover
                            }
                            templateImageLoader$DownloadStateListener0.checkDownloadCompleted(this.$listener);
                        }

                        @Override  // com.bumptech.glide.request.target.Target
                        public void onResourceReady(Object object0, Transition transition0) {
                            this.onResourceReady(((Drawable)object0), transition0);
                        }
                    });
                }
            }
            return;
        }
        this.enableCache = false;
        this.checkDownloadCompleted(templateImageLoader$DownloadStateListener0);
    }
}

