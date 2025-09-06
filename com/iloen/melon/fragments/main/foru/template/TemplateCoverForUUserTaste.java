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

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001E2\u00020\u0001:\u0001\u001EB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0010\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\u000Ej\b\u0012\u0004\u0012\u00020\u000B`\u000FH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0012\u0010\nR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0016\u0010\u001B\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001AR\u0014\u0010\u001C\u001A\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/template/TemplateCoverForUUserTaste;", "Lcom/iloen/melon/utils/template/TemplateCoverBase;", "Lcom/iloen/melon/utils/template/TemplateData;", "templateData", "<init>", "(Lcom/iloen/melon/utils/template/TemplateData;)V", "Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;", "listener", "Lie/H;", "load", "(Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;)V", "", "getLayoutResId", "()I", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getViewIds", "()Ljava/util/ArrayList;", "checkDownloadCompleted", "Lcom/iloen/melon/utils/template/TemplateData;", "getTemplateData", "()Lcom/iloen/melon/utils/template/TemplateData;", "downCnt", "I", "", "loadFailed", "Z", "enableCache", "isShortCutType", "()Z", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TemplateCoverForUUserTaste extends TemplateCoverBase {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/template/TemplateCoverForUUserTaste$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TemplateCoverForUUserTaste";
    private int downCnt;
    private boolean enableCache;
    private boolean loadFailed;
    @NotNull
    private final TemplateData templateData;

    static {
        TemplateCoverForUUserTaste.Companion = new Companion(null);
        TemplateCoverForUUserTaste.$stable = 8;
    }

    public TemplateCoverForUUserTaste(@NotNull TemplateData templateData0) {
        q.g(templateData0, "templateData");
        super(templateData0);
        this.templateData = templateData0;
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
                    ViewUtils.setText(textView0, this.getTitleLine1());
                    ViewUtils.showWhen(textView0, true);
                }
                if(!TextUtils.isEmpty(this.getTitleLine2())) {
                    TextView textView1 = (TextView)this.templateView.findViewById(0x7F0A0D36);  // id:tv_title2
                    ViewUtils.showWhen(textView1, true);
                    ViewUtils.setText(textView1, this.getTitleLine2());
                }
                if(!TextUtils.isEmpty(this.getSubTitle())) {
                    TextView textView2 = (TextView)this.templateView.findViewById(0x7F0A0D1F);  // id:tv_subtitle
                    ViewUtils.showWhen(textView2, true);
                    ViewUtils.setText(textView2, this.getSubTitle());
                }
                templateImageLoader$DownloadStateListener0.onDownloadCompleted(this.templateView, this.enableCache);
            }
        }
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public int getLayoutResId() {
        return 0x7F0D01D1;  // layout:cover_template_foru_user_taste_200
    }

    @NotNull
    public final TemplateData getTemplateData() {
        return this.templateData;
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    @NotNull
    public ArrayList getViewIds() {
        ArrayList arrayList0 = new ArrayList();
        if(!this.isShortCutType()) {
            arrayList0.add(0x7F0A05ED);  // id:iv_album_thumb
        }
        return arrayList0;
    }

    private final boolean isShortCutType() {
        return this.getImageListSize() == 0;
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public void load(@NotNull DownloadStateListener templateImageLoader$DownloadStateListener0) {
        q.g(templateImageLoader$DownloadStateListener0, "listener");
        int v = this.getImageListSize();
        ViewUtils.hideWhen(this.templateView.findViewById(0x7F0A036B), this.isShortCutType());  // id:ctl_album_info
        ViewUtils.showWhen(this.templateView.findViewById(0x7F0A0373), this.isShortCutType());  // id:ctl_shortcut_land
        String s = this.getAnimationImgUrl();
        if(!TextUtils.isEmpty(s)) {
            View view0 = this.getTargetCoverView();
            if(view0 instanceof CoverView) {
                RequestBuilder requestBuilder0 = Glide.with(this.context).load(s);
                RequestOptions requestOptions0 = new RequestOptions();
                WebpDrawableTransformation webpDrawableTransformation0 = new WebpDrawableTransformation(new e(0, RoundedCornersTransformation.CornerType.ALL));
                ((RequestBuilder)requestBuilder0.apply(requestOptions0.optionalTransform(WebpDrawable.class, webpDrawableTransformation0)).override(200)).into(new CustomTarget() {
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
        int v2 = Math.min(this.viewResId.size(), v);
        for(int v1 = 0; v1 < v2; ++v1) {
            View view1 = this.templateView;
            Object object0 = this.viewResId.get(v1);
            q.f(object0, "get(...)");
            ImageView imageView0 = (ImageView)view1.findViewById(((Number)object0).intValue());
            if(imageView0 != null) {
                Glide.with(this.context).load(this.getImageData(v1)).into(new CustomTarget() {
                    @Override  // com.bumptech.glide.request.target.Target
                    public void onLoadCleared(Drawable drawable0) {
                    }

                    @Override  // com.bumptech.glide.request.target.CustomTarget
                    public void onLoadFailed(Drawable drawable0) {
                        super.onLoadFailed(drawable0);
                        templateImageLoader$DownloadStateListener0.checkDownloadCompleted(this.$listener);
                    }

                    public void onResourceReady(Drawable drawable0, Transition transition0) {
                        q.g(drawable0, "resource");
                        this.setImageDrawable(drawable0);
                        templateImageLoader$DownloadStateListener0.checkDownloadCompleted(this.$listener);
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

