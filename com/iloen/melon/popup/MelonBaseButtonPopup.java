package com.iloen.melon.popup;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class MelonBaseButtonPopup extends MelonBasePopup implements View.OnClickListener {
    private static final String TAG = "MelonBaseButtonPopup";
    public static final int TYPE_ONE_BUTTON = 1;
    public static final int TYPE_TWO_BUTTON = 2;
    private boolean blockDismiss;
    private boolean centFlag;
    private View.OnClickListener goLinkClickListener;
    private String goLinkText;
    private boolean isFromNotification;
    protected ViewGroup mBodyContainer;
    private int mButtonType;
    protected View mContainer;
    protected View mSubTitleContainer;
    protected View mTitleContainer;
    protected TextView mTvSubTitle;
    protected TextView mTvTitle;
    protected TextView tvGoLink;

    public MelonBaseButtonPopup(Activity activity0) {
        super(activity0, 0x7F0D012C);  // layout:button_popup_layout
        this.mTitleContainer = null;
        this.mTvTitle = null;
        this.mTvSubTitle = null;
        this.mSubTitleContainer = null;
        this.mContainer = null;
        this.mBodyContainer = null;
        this.tvGoLink = null;
        this.centFlag = false;
        this.blockDismiss = false;
        this.isFromNotification = false;
        this.goLinkText = null;
        this.goLinkClickListener = null;
        this.mButtonType = 2;
    }

    public MelonBaseButtonPopup(Activity activity0, int v) {
        this(activity0);
        this.setButtonType(v);
    }

    public final void a(boolean z) {
        Context context0 = this.getContext();
        if(context0 != null) {
            View view0 = this.mContainer;
            if(view0 != null) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                viewGroup$LayoutParams0.width = ScreenUtils.dipToPixel(context0, 280.0f);
                viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(context0, (z ? 420.0f : 295.0f));
                this.mContainer.setLayoutParams(viewGroup$LayoutParams0);
                this.mContainer.requestLayout();
            }
        }
    }

    public void addBodyView(View view0) {
        ViewGroup viewGroup0 = this.mBodyContainer;
        if(viewGroup0 != null) {
            viewGroup0.addView(view0);
        }
    }

    public void initLayout() {
        this.mContainer = this.findViewById(0x7F0A0950);  // id:popup_container
        this.mTitleContainer = this.findViewById(0x7F0A095A);  // id:popup_top
        this.mTvTitle = (TextView)this.findViewById(0x7F0A0CEA);  // id:tv_popup_title
        this.mTvSubTitle = (TextView)this.findViewById(0x7F0A0CE9);  // id:tv_popup_sub_title
        this.mSubTitleContainer = this.findViewById(0x7F0A0959);  // id:popup_sub_title_container
        this.mLeftButton = (TextView)this.findViewById(0x7F0A0194);  // id:btn_popup_negative
        TextView textView0 = (TextView)this.findViewById(0x7F0A0195);  // id:btn_popup_positive
        this.mRightButton = textView0;
        if(this.mButtonType == 1) {
            this.mCenterButton = textView0;
        }
        this.mBodyContainer = (ViewGroup)this.findViewById(0x7F0A093F);  // id:popup_body
        if(this.getTitleName() == null || this.getTitleName().isEmpty()) {
            this.setNoTitleLayout();
        }
        ViewUtils.showWhen(this.mLeftButton, this.mLeftButton != null && this.mButtonType != 1);
        ViewUtils.showWhen(this.mRightButton, this.mRightButton != null);
        if(this.isFromNotification) {
            if(this.mButtonType == 1) {
                TextView textView1 = this.mCenterButton;
                if(textView1 == null) {
                    this.mLeftButton.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060163));  // color:gray700s
                }
                else {
                    textView1.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F06017C));  // color:green500s_support_high_contrast
                }
            }
            else {
                this.mLeftButton.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060163));  // color:gray700s
            }
        }
        TextView textView2 = (TextView)this.findViewById(0x7F0A0C87);  // id:tv_go_link
        this.tvGoLink = textView2;
        String s = this.goLinkText;
        if(s != null && this.goLinkClickListener != null) {
            textView2.setText(s);
            this.tvGoLink.setVisibility(0);
            this.tvGoLink.setOnClickListener(this.goLinkClickListener);
        }
        this.a(ScreenUtils.isPortrait(this.getContext()));
    }

    public boolean isCentFlag() {
        return this.centFlag;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == this.mLeftButton) {
            DialogInterface.OnClickListener dialogInterface$OnClickListener0 = this.mPopupListener;
            if(dialogInterface$OnClickListener0 != null) {
                dialogInterface$OnClickListener0.onClick(this, -2);
            }
            if(!this.blockDismiss) {
                this.dismiss();
            }
        }
        else if(view0 == this.mRightButton) {
            DialogInterface.OnClickListener dialogInterface$OnClickListener1 = this.mPopupListener;
            if(dialogInterface$OnClickListener1 != null) {
                dialogInterface$OnClickListener1.onClick(this, -1);
            }
            if(!this.blockDismiss) {
                this.dismiss();
            }
        }
        else if(view0 == this.mCenterButton) {
            DialogInterface.OnClickListener dialogInterface$OnClickListener2 = this.mPopupListener;
            if(dialogInterface$OnClickListener2 != null) {
                dialogInterface$OnClickListener2.onClick(this, -1);
            }
            if(!this.blockDismiss) {
                this.dismiss();
            }
        }
    }

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.initLayout();
        if(!TextUtils.isEmpty(this.getTitleName())) {
            this.mTvTitle.setText(this.getTitleName());
        }
        if(!TextUtils.isEmpty(this.getDefaultSubTitle())) {
            this.mTvSubTitle.setText(this.getDefaultSubTitle());
        }
        switch(this.mButtonType) {
            case 1: {
                if(!TextUtils.isEmpty(this.mCenterBtnName)) {
                    this.mCenterButton.setText(this.mCenterBtnName);
                }
                else if(!TextUtils.isEmpty(this.mRightBtnName)) {
                    this.mCenterButton.setText(this.mRightBtnName);
                }
                else if(!TextUtils.isEmpty(this.mLeftBtnName)) {
                    this.mCenterButton.setText(this.mLeftBtnName);
                }
                ViewUtils.setOnClickListener(this.mCenterButton, this);
                ViewUtils.setContentDescriptionWithButtonClassName(this.mCenterButton, this.mCenterButton.getText());
                return;
            }
            case 2: {
                if(!TextUtils.isEmpty(this.mLeftBtnName)) {
                    this.mLeftButton.setText(this.mLeftBtnName);
                }
                if(!TextUtils.isEmpty(this.mRightBtnName)) {
                    this.mRightButton.setText(this.mRightBtnName);
                }
                ViewUtils.setOnClickListener(this.mLeftButton, this);
                ViewUtils.setOnClickListener(this.mRightButton, this);
                ViewUtils.setContentDescriptionWithButtonClassName(this.mLeftButton, this.mLeftButton.getText());
                ViewUtils.setContentDescriptionWithButtonClassName(this.mRightButton, this.mRightButton.getText());
                return;
            }
            default: {
                LogU.d("MelonBaseButtonPopup", "onCreate() invalid button type.");
            }
        }
    }

    public void setBlockDismiss(boolean z) {
        this.blockDismiss = z;
    }

    public void setButtonType(int v) {
        this.mButtonType = v;
    }

    public void setCentFlag(boolean z) {
        this.centFlag = z;
    }

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void setConfigurationChanged(int v) {
        this.a(v == 1);
    }

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void setDefaultSubTitle(String s) {
        this.mDefaultSubTitle = s;
        ViewUtils.setText(this.mTvSubTitle, s);
    }

    public void setGoLink(String s, View.OnClickListener view$OnClickListener0) {
        this.goLinkText = s;
        this.goLinkClickListener = view$OnClickListener0;
    }

    public void setIsFromNotification(boolean z) {
        this.isFromNotification = z;
    }

    public void setNoTitleLayout() {
        ViewUtils.hideWhen(this.mTitleContainer, true);
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)this.mBodyContainer.getLayoutParams();
        viewGroup$MarginLayoutParams0.topMargin = ScreenUtils.dipToPixel(this.getContext(), 28.0f);
        this.mBodyContainer.setLayoutParams(viewGroup$MarginLayoutParams0);
    }

    @Override  // android.app.Dialog
    public void setTitle(int v) {
        this.setTitleName(this.getContext().getString(v));
    }

    @Override  // android.app.Dialog
    public void setTitle(CharSequence charSequence0) {
        this.setTitleName(((String)charSequence0));
    }

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void setTitleName(String s) {
        this.mTitleName = s;
        ViewUtils.setText(this.mTvTitle, s);
    }

    @Override  // android.app.Dialog
    public void show() {
        ViewUtils.showWhen(this.mTvTitle, !TextUtils.isEmpty(this.getTitleName()));
        super.show();
    }
}

