package com.iloen.melon.fragments.main.foru.template;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.utils.template.TemplateCoverBase;
import com.iloen.melon.utils.template.TemplateData;
import com.iloen.melon.utils.template.TemplateImageLoader.DownloadStateListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0010\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\u000Ej\b\u0012\u0004\u0012\u00020\u000B`\u000FH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001A\u00020\u00158\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/template/TemplateCoverForUMonthSuperLike;", "Lcom/iloen/melon/utils/template/TemplateCoverBase;", "Lcom/iloen/melon/utils/template/TemplateData;", "templateData", "<init>", "(Lcom/iloen/melon/utils/template/TemplateData;)V", "Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;", "listener", "Lie/H;", "load", "(Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;)V", "", "getLayoutResId", "()I", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getViewIds", "()Ljava/util/ArrayList;", "checkDownloadCompleted", "downCnt", "I", "", "loadFailed", "Z", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TemplateCoverForUMonthSuperLike extends TemplateCoverBase {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/template/TemplateCoverForUMonthSuperLike$Companion;", "", "<init>", "()V", "TAG", "", "STANDARD_SIZE_144_MIN", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
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
    private static final String TAG = "TemplateCoverForUMonthSuperLike";
    private int downCnt;
    private boolean loadFailed;

    static {
        TemplateCoverForUMonthSuperLike.Companion = new Companion(null);
        TemplateCoverForUMonthSuperLike.$stable = 8;
    }

    public TemplateCoverForUMonthSuperLike(@NotNull TemplateData templateData0) {
        q.g(templateData0, "templateData");
        super(templateData0);
    }

    public final void checkDownloadCompleted(@NotNull DownloadStateListener templateImageLoader$DownloadStateListener0) {
        q.g(templateImageLoader$DownloadStateListener0, "listener");
        if(!this.loadFailed) {
            int v = this.downCnt + 1;
            this.downCnt = v;
            if(v >= this.getImageListSize() || this.downCnt >= this.viewResId.size()) {
                templateImageLoader$DownloadStateListener0.onDownloadCompleted(this.templateView, true);
            }
        }
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public int getLayoutResId() {
        return this.standardSizeDp > 144.0f ? 0x7F0D01C5 : 0x7F0D01C4;  // layout:cover_template_foru_month_super_like_200
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
            int v = this.viewResId.size();
            for(int v1 = 0; v1 < v; ++v1) {
                View view0 = this.templateView;
                Object object0 = this.viewResId.get(v1);
                q.f(object0, "get(...)");
                ImageView imageView0 = (ImageView)view0.findViewById(((Number)object0).intValue());
                if(imageView0 != null) {
                    Glide.with(this.context).load(this.getImageData(v1)).into(new CustomTarget() {
                        @Override  // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable drawable0) {
                        }

                        @Override  // com.bumptech.glide.request.target.CustomTarget
                        public void onLoadFailed(Drawable drawable0) {
                            super.onLoadFailed(drawable0);
                            templateImageLoader$DownloadStateListener0.loadFailed = true;
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
}

