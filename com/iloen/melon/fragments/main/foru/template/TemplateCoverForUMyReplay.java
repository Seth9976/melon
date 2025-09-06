package com.iloen.melon.fragments.main.foru.template;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.template.TemplateCoverBase;
import com.iloen.melon.utils.template.TemplateData;
import com.iloen.melon.utils.template.TemplateImageLoader.DownloadStateListener;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000B\u0010\nJ\u000F\u0010\r\u001A\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u0012\u0012\u0004\u0012\u00020\f0\u000Fj\b\u0012\u0004\u0012\u00020\f`\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001A\u00020\u00158\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/template/TemplateCoverForUMyReplay;", "Lcom/iloen/melon/utils/template/TemplateCoverBase;", "Lcom/iloen/melon/utils/template/TemplateData;", "templateData", "<init>", "(Lcom/iloen/melon/utils/template/TemplateData;)V", "Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;", "listener", "Lie/H;", "checkDownloadCompleted", "(Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;)V", "load", "", "getLayoutResId", "()I", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getViewIds", "()Ljava/util/ArrayList;", "downCnt", "I", "", "enableCache", "Z", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TemplateCoverForUMyReplay extends TemplateCoverBase {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/template/TemplateCoverForUMyReplay$Companion;", "", "<init>", "()V", "TAG", "", "STANDARD_SIZE_144_MIN", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final Companion Companion = null;
    private static final int STANDARD_SIZE_144_MIN = 0x90;
    @NotNull
    private static final String TAG = "TemplateCoverForUMyReplay";
    private int downCnt;
    private boolean enableCache;

    static {
        TemplateCoverForUMyReplay.Companion = new Companion(null);
        TemplateCoverForUMyReplay.$stable = 8;
    }

    public TemplateCoverForUMyReplay(@NotNull TemplateData templateData0) {
        q.g(templateData0, "templateData");
        super(templateData0);
        this.enableCache = true;
    }

    private final void checkDownloadCompleted(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        if(this.getImageListSize() < this.viewResId.size()) {
            this.enableCache = false;
        }
        int v = this.downCnt + 1;
        this.downCnt = v;
        if(v < this.getImageListSize() && this.downCnt < this.viewResId.size()) {
            return;
        }
        int v1 = ColorUtils.getColorFromHexStr(this.context, this.getTextShadowColor(), 0x7F06048A);  // color:transparent
        if(!TextUtils.isEmpty(this.getTitleLine1())) {
            TextView textView0 = (TextView)this.templateView.findViewById(0x7F0A0D35);  // id:tv_title1
            ViewUtils.setText(textView0, this.getTitleLine1());
            ViewUtils.showWhen(textView0, true);
            ViewUtils.setBackgroundColor(textView0, v1);
        }
        if(!TextUtils.isEmpty(this.getTitleLine2())) {
            TextView textView1 = (TextView)this.templateView.findViewById(0x7F0A0D36);  // id:tv_title2
            ViewUtils.setText(textView1, this.getTitleLine2());
            ViewUtils.showWhen(textView1, true);
            ViewUtils.setBackgroundColor(textView1, v1);
        }
        if(!TextUtils.isEmpty(this.getSubTitle())) {
            ViewUtils.setText(((TextView)this.templateView.findViewById(0x7F0A0D1F)), this.getSubTitle());  // id:tv_subtitle
        }
        templateImageLoader$DownloadStateListener0.onDownloadCompleted(this.templateView, this.enableCache);
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public int getLayoutResId() {
        return this.standardSizeDp > 144.0f ? 0x7F0D01C7 : 0x7F0D01C6;  // layout:cover_template_foru_my_replay_200
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    @NotNull
    public ArrayList getViewIds() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(0x7F0A0617);  // id:iv_cover
        if(this.standardSizeDp > 144.0f) {
            arrayList0.add(0x7F0A05ED);  // id:iv_album_thumb
        }
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
                ImageView imageView0 = (ImageView)view0.findViewById(((Number)object0).intValue());
                if(imageView0 != null) {
                    Glide.with(this.context).load(this.getImageData(v)).into(new CustomTarget() {
                        @Override  // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable drawable0) {
                        }

                        @Override  // com.bumptech.glide.request.target.CustomTarget
                        public void onLoadFailed(Drawable drawable0) {
                            super.onLoadFailed(drawable0);
                            templateImageLoader$DownloadStateListener0.enableCache = false;
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
            return;
        }
        this.enableCache = false;
        this.checkDownloadCompleted(templateImageLoader$DownloadStateListener0);
    }
}

