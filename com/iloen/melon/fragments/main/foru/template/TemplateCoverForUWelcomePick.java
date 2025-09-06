package com.iloen.melon.fragments.main.foru.template;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.template.TemplateCoverBase;
import com.iloen.melon.utils.template.TemplateData;
import com.iloen.melon.utils.template.TemplateImageLoader.DownloadStateListener;
import com.iloen.melon.utils.ui.ViewUtils;
import he.e;
import java.util.ArrayList;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import x1.a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0013\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\u0011j\b\u0012\u0004\u0012\u00020\u000B`\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0015\u0010\nR\u0016\u0010\u0016\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0016\u0010\u001B\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001A¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/template/TemplateCoverForUWelcomePick;", "Lcom/iloen/melon/utils/template/TemplateCoverBase;", "Lcom/iloen/melon/utils/template/TemplateData;", "templateData", "<init>", "(Lcom/iloen/melon/utils/template/TemplateData;)V", "Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;", "listener", "Lie/H;", "load", "(Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;)V", "", "getLayoutResId", "()I", "", "getTemplateCacheKey", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getViewIds", "()Ljava/util/ArrayList;", "checkDownloadCompleted", "downCnt", "I", "", "loadFailed", "Z", "enableCache", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TemplateCoverForUWelcomePick extends TemplateCoverBase {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/template/TemplateCoverForUWelcomePick$Companion;", "", "<init>", "()V", "TAG", "", "STANDARD_SIZE_144_MIN", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int STANDARD_SIZE_144_MIN = 0x90;
    @NotNull
    private static final String TAG = "TemplateCoverForUWelcomePick";
    private int downCnt;
    private boolean enableCache;
    private boolean loadFailed;

    static {
        TemplateCoverForUWelcomePick.Companion = new Companion(null);
        TemplateCoverForUWelcomePick.$stable = 8;
    }

    public TemplateCoverForUWelcomePick(@NotNull TemplateData templateData0) {
        q.g(templateData0, "templateData");
        super(templateData0);
        this.enableCache = true;
    }

    public final void checkDownloadCompleted(@NotNull DownloadStateListener templateImageLoader$DownloadStateListener0) {
        q.g(templateImageLoader$DownloadStateListener0, "listener");
        if(!this.loadFailed) {
            int v = this.downCnt + 1;
            this.downCnt = v;
            if(v >= this.getImageListSize() + 1 || this.downCnt >= this.viewResId.size() + 1) {
                if(!TextUtils.isEmpty(this.getTitleLine1())) {
                    TextView textView0 = (TextView)this.templateView.findViewById(0x7F0A0D35);  // id:tv_title1
                    ViewUtils.showWhen(textView0, true);
                    ViewUtils.setText(textView0, this.getTitleLine1());
                }
                if(!TextUtils.isEmpty(this.getTitleLine2())) {
                    TextView textView1 = (TextView)this.templateView.findViewById(0x7F0A0D36);  // id:tv_title2
                    ViewUtils.showWhen(textView1, true);
                    ViewUtils.setText(textView1, this.getTitleLine2());
                }
                templateImageLoader$DownloadStateListener0.onDownloadCompleted(this.templateView, this.enableCache);
            }
        }
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public int getLayoutResId() {
        return this.standardSizeDp > 144.0f ? 0x7F0D01D7 : 0x7F0D01D6;  // layout:cover_template_foru_welcome_pick_200
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    @NotNull
    public String getTemplateCacheKey() {
        StringBuilder stringBuilder0 = new StringBuilder("TemplateCoverForUWelcomePick");
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
        return new ArrayList();
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public void load(@NotNull DownloadStateListener templateImageLoader$DownloadStateListener0) {
        q.g(templateImageLoader$DownloadStateListener0, "listener");
        ViewUtils.hideWhen(this.templateView.findViewById(0x7F0A0656), true);  // id:iv_noimage
        String s = this.getAnimationImgUrl();
        if(!TextUtils.isEmpty(s)) {
            View view0 = this.getTargetCoverView();
            if(view0 instanceof CoverView) {
                RequestBuilder requestBuilder0 = Glide.with(this.context).load(s);
                RequestOptions requestOptions0 = new RequestOptions();
                WebpDrawableTransformation webpDrawableTransformation0 = new WebpDrawableTransformation(new e(0, RoundedCornersTransformation.CornerType.ALL));
                ((RequestBuilder)requestBuilder0.apply(requestOptions0.optionalTransform(WebpDrawable.class, webpDrawableTransformation0)).override(500)).into(new CustomTarget() {
                    @Override  // com.bumptech.glide.request.target.Target
                    public void onLoadCleared(Drawable drawable0) {
                    }

                    @Override  // com.bumptech.glide.request.target.CustomTarget
                    public void onLoadFailed(Drawable drawable0) {
                        super.onLoadFailed(drawable0);
                        view0.loadFailed = true;
                    }

                    public void onResourceReady(Drawable drawable0, Transition transition0) {
                        q.g(drawable0, "resource");
                        if(drawable0 instanceof Animatable) {
                            view0.enableCache = false;
                            ((CoverView)templateImageLoader$DownloadStateListener0).getAnimationView().setImageDrawable(drawable0);
                            a.l(((Animatable)drawable0));
                        }
                        else {
                            ((ImageView)view0.templateView.findViewById(0x7F0A0617)).setImageDrawable(drawable0);  // id:iv_cover
                        }
                        view0.checkDownloadCompleted(this.$listener);
                    }

                    @Override  // com.bumptech.glide.request.target.Target
                    public void onResourceReady(Object object0, Transition transition0) {
                        this.onResourceReady(((Drawable)object0), transition0);
                    }
                });
            }
        }
    }
}

