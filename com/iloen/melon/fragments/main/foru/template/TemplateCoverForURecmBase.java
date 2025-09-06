package com.iloen.melon.fragments.main.foru.template;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.fragments.main.foru.TemplateCoverBlurData;
import com.iloen.melon.fragments.main.foru.TemplateCoverBlurUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.template.TemplateCoverBase;
import com.iloen.melon.utils.template.TemplateData;
import com.iloen.melon.utils.template.TemplateImageLoader.DownloadStateListener;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;

abstract class TemplateCoverForURecmBase extends TemplateCoverBase {
    protected static final int STANDARD_SIZE_144_MIN = 0x90;
    private static final String TAG = "TemplateCoverForURecmBase";
    private int downCnt;
    private boolean enableCache;
    private Bitmap thumbBitmap;

    public TemplateCoverForURecmBase(TemplateData templateData0) {
        super(templateData0);
        this.downCnt = 0;
        this.enableCache = true;
    }

    public static void a(TemplateCoverForURecmBase templateCoverForURecmBase0) {
        templateCoverForURecmBase0.enableCache = false;
    }

    public void checkDownloadCompleted(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        if(this.enableCache || this.standardSizeDp > 144.0f) {
            int v = this.downCnt + 1;
            this.downCnt = v;
            if(v >= this.getImageListSize() || this.downCnt >= this.viewResId.size()) {
                this.drawCover(templateImageLoader$DownloadStateListener0);
            }
        }
    }

    public void drawCover(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        TextView textView0 = (TextView)this.templateView.findViewById(0x7F0A0D34);  // id:tv_title
        TextView textView1 = (TextView)this.templateView.findViewById(0x7F0A0D1F);  // id:tv_subtitle
        ArrayList arrayList0 = this.getBgColors();
        String s = this.getTitle();
        if(!TextUtils.isEmpty(s)) {
            ViewUtils.setText(textView0, s);
        }
        String s1 = this.getSubTitle();
        if(!TextUtils.isEmpty(s1)) {
            ViewUtils.setText(textView1, s1);
        }
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            int v = this.getDefalutShadowColor();
            if(this.enableCache) {
                textView0.setTextColor(ColorUtils.getColor(this.context, 0x7F06009F));  // color:color_fafafa
                textView1.setTextColor(ColorUtils.getColor(this.context, 0x7F0604A1));  // color:white000e
                Bitmap bitmap0 = this.thumbBitmap;
                if(bitmap0 != null) {
                    TemplateCoverBlurData templateCoverBlurData0 = TemplateCoverBlurUtils.getBlurredBackground(bitmap0);
                    v = templateCoverBlurData0.getShadowColor();
                    this.templateView.findViewById(0x7F0A06FE).setBackground(new BitmapDrawable(this.context.getResources(), templateCoverBlurData0.getBgBitmap()));  // id:layout_background
                }
            }
            templateImageLoader$DownloadStateListener0.onDownloadCompleted(this.templateView, this.enableCache, v);
            return;
        }
        textView0.setTextColor(ColorUtils.getColor(this.context, 0x7F060175));  // color:gray_90
        textView1.setTextColor(ColorUtils.getColor(this.context, 0x7F060174));  // color:gray_50
        templateImageLoader$DownloadStateListener0.onDownloadCompleted(this.templateView, false, this.getDefalutShadowColor());
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public int getLayoutResId() {
        return -1;
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public ArrayList getViewIds() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(0x7F0A0617);  // id:iv_cover
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
                            TemplateCoverForURecmBase.a(TemplateCoverForURecmBase.this);
                            TemplateCoverForURecmBase.this.checkDownloadCompleted(templateImageLoader$DownloadStateListener0);
                        }

                        public void onResourceReady(Drawable drawable0, Transition transition0) {
                            imageView0.setImageDrawable(drawable0);
                            if(drawable0 instanceof BitmapDrawable) {
                                Bitmap bitmap0 = ((BitmapDrawable)drawable0).getBitmap();
                                TemplateCoverForURecmBase.this.thumbBitmap = bitmap0;
                            }
                            TemplateCoverForURecmBase.this.checkDownloadCompleted(templateImageLoader$DownloadStateListener0);
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

