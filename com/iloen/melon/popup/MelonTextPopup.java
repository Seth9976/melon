package com.iloen.melon.popup;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.iloen.melon.custom.BottomDetectableScrollView;
import com.iloen.melon.custom.j;
import com.iloen.melon.utils.ui.ViewUtils;

public class MelonTextPopup extends MelonBaseButtonPopup {
    private static final String TAG = "MelonTextPopup";
    private Boolean isHtmlText;
    protected BottomDetectableScrollView mBodyScrollView;
    protected ImageView mBottomShadow;
    protected TextView mTvBody;

    public MelonTextPopup(Activity activity0) {
        super(activity0);
        this.mTvBody = null;
        this.mBodyScrollView = null;
        this.mBottomShadow = null;
        this.isHtmlText = Boolean.FALSE;
    }

    public MelonTextPopup(Activity activity0, int v) {
        super(activity0, v);
        this.mTvBody = null;
        this.mBodyScrollView = null;
        this.mBottomShadow = null;
        this.isHtmlText = Boolean.FALSE;
    }

    @Override  // com.iloen.melon.popup.MelonBaseButtonPopup
    public void initLayout() {
        super.initLayout();
        LayoutInflater.from(this.getContext()).inflate(0x7F0D086F, this.mBodyContainer);  // layout:text_popup_body_layout
        this.mBodyScrollView = (BottomDetectableScrollView)this.findViewById(0x7F0A0110);  // id:body_text_container
        this.mBottomShadow = (ImageView)this.findViewById(0x7F0A066E);  // id:iv_popup_bottom_shadow
        this.mTvBody = (TextView)this.mBodyScrollView.findViewById(0x7F0A0CE6);  // id:tv_popup_body
        this.mBodyScrollView.postDelayed(new Runnable() {
            public final MelonTextPopup a;

            {
                this.a = melonTextPopup0;
            }

            @Override
            public void run() {
                ViewUtils.showWhen(this.a.mBottomShadow, this.a.mBodyScrollView.getHeight() < this.a.mTvBody.getHeight());
            }
        }, 50L);
    }

    @Override  // com.iloen.melon.popup.MelonBaseButtonPopup
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        String s = this.getBodyMsg();
        if(!TextUtils.isEmpty(s)) {
            if(this.isHtmlText.booleanValue()) {
                this.mTvBody.setText(Html.fromHtml(s, 0));
            }
            else {
                this.mTvBody.setText(s);
            }
        }
        ViewUtils.showWhen(this.mSubTitleContainer, !TextUtils.isEmpty(this.getDefaultSubTitle()));
        if(this.isCentFlag()) {
            this.mTvBody.setGravity(17);
        }
        this.mBodyScrollView.setOnScrollListener(new j() {
            public final MelonTextPopup a;

            {
                this.a = melonTextPopup0;
            }

            @Override  // com.iloen.melon.custom.j
            public void onScrollChanged() {
                MelonTextPopup melonTextPopup0 = this.a;
                if(melonTextPopup0.mBottomShadow.getVisibility() == 8) {
                    ViewUtils.showWhen(melonTextPopup0.mBottomShadow, true);
                }
            }

            @Override  // com.iloen.melon.custom.j
            public void onScrollReachedBottom() {
                ViewUtils.hideWhen(this.a.mBottomShadow, true);
            }
        });
    }

    public void setHtmlTextFlag(Boolean boolean0) {
        this.isHtmlText = boolean0;
    }

    public void updateShadowDelayed(Long long0) {
        this.mBottomShadow.postDelayed(new J(this, 0), ((long)long0));
    }
}

