package com.iloen.melon.fragments.main.foru.template;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.utils.template.TemplateCoverBase;
import com.iloen.melon.utils.template.TemplateData;
import com.iloen.melon.utils.template.TemplateImageLoader.DownloadStateListener;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;

public class TemplateCoverForUHourMix extends TemplateCoverBase {
    protected static final int STANDARD_SIZE_144_MIN = 0x90;
    private static final String TAG = "TemplateCoverForUHourMix";
    int downCnt;
    private boolean enableCache;

    public TemplateCoverForUHourMix(TemplateData templateData0) {
        super(templateData0);
        this.downCnt = 0;
        this.enableCache = true;
    }

    public static void a(TemplateCoverForUHourMix templateCoverForUHourMix0) {
        templateCoverForUHourMix0.enableCache = false;
    }

    public void checkDownloadCompleted(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        if(this.getImageListSize() < this.viewResId.size()) {
            this.enableCache = false;
        }
        int v = this.downCnt + 1;
        this.downCnt = v;
        if((v >= this.getImageListSize() || this.downCnt >= this.viewResId.size()) && this.templateView != null) {
            String s = this.getTitleLine1();
            String s1 = this.getTitleLine2();
            if(!TextUtils.isEmpty(s)) {
                TextView textView0 = (TextView)this.templateView.findViewById(0x7F0A0D35);  // id:tv_title1
                ViewUtils.showWhen(textView0, true);
                ViewUtils.setText(textView0, s);
            }
            if(!TextUtils.isEmpty(s1)) {
                TextView textView1 = (TextView)this.templateView.findViewById(0x7F0A0D36);  // id:tv_title2
                ViewUtils.showWhen(textView1, true);
                ViewUtils.setText(textView1, s1);
            }
            String s2 = this.getSubTitle();
            if(!TextUtils.isEmpty(s2)) {
                ViewUtils.setText(((TextView)this.templateView.findViewById(0x7F0A0D1F)), s2);  // id:tv_subtitle
            }
            templateImageLoader$DownloadStateListener0.onDownloadCompleted(this.templateView, this.enableCache);
        }
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public int getLayoutResId() {
        return this.standardSizeDp > 144.0f ? 0x7F0D01C2 : 0x7F0D01C1;  // layout:cover_template_foru_hour_200
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public ArrayList getViewIds() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(0x7F0A0617);  // id:iv_cover
        if(this.standardSizeDp > 144.0f) {
            arrayList0.add(0x7F0A05ED);  // id:iv_album_thumb
        }
        return arrayList0;
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public void load(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        if(this.getImageListSize() > 0) {
            int v1 = this.viewResId.size();
            for(int v = 0; v < v1; ++v) {
                ImageView imageView0 = (ImageView)this.templateView.findViewById(((int)(((Integer)this.viewResId.get(v)))));
                if(imageView0 != null) {
                    Glide.with(this.context).load(this.getImageData(v)).into(new CustomTarget() {
                        @Override  // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable drawable0) {
                        }

                        @Override  // com.bumptech.glide.request.target.CustomTarget
                        public void onLoadFailed(Drawable drawable0) {
                            super.onLoadFailed(drawable0);
                            TemplateCoverForUHourMix.a(TemplateCoverForUHourMix.this);
                            TemplateCoverForUHourMix.this.checkDownloadCompleted(templateImageLoader$DownloadStateListener0);
                        }

                        public void onResourceReady(Drawable drawable0, Transition transition0) {
                            imageView0.setImageDrawable(drawable0);
                            TemplateCoverForUHourMix.this.checkDownloadCompleted(templateImageLoader$DownloadStateListener0);
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

