package com.iloen.melon.popup;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.WindowManager;
import android.widget.TextView;
import com.iloen.melon.custom.MelonButton;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.VolumeUtils;

public class MelonBasePopup extends Dialog {
    private static final String TAG = "MelonBasePopup";
    protected Activity mActivity;
    protected String mBodyMsg;
    protected MelonButton mCenterBt;
    protected String mCenterBtnName;
    protected TextView mCenterButton;
    protected String mDefaultSubTitle;
    protected MelonButton mLeftBt;
    protected String mLeftBtnName;
    protected TextView mLeftButton;
    protected DialogInterface.OnClickListener mPopupListener;
    protected int mResourceId;
    protected MelonButton mRightBt;
    protected String mRightBtnName;
    protected TextView mRightButton;
    protected String mSubTitleName;
    protected String mTitleName;

    public MelonBasePopup(Activity activity0, int v) {
        this(activity0, v, 0);
    }

    public MelonBasePopup(Activity activity0, int v, int v1) {
        super(activity0, v1);
        this.requestWindowFeature(1);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.mActivity = activity0;
        this.mResourceId = v;
    }

    @Override  // android.app.Dialog
    public void cancel() {
        DialogInterface.OnClickListener dialogInterface$OnClickListener0 = this.mPopupListener;
        if(dialogInterface$OnClickListener0 != null) {
            dialogInterface$OnClickListener0.onClick(this, -2);
        }
        super.cancel();
    }

    public String getBodyMsg() {
        return this.mBodyMsg;
    }

    public String getCenterBtnName() {
        return this.mCenterBtnName;
    }

    public String getDefaultSubTitle() {
        return this.mDefaultSubTitle;
    }

    public String getLeftBtnName() {
        return this.mLeftBtnName;
    }

    public DialogInterface.OnClickListener getPopupOnClickListener() {
        return this.mPopupListener;
    }

    public String getRightBtnName() {
        return this.mRightBtnName;
    }

    public String getSubTitleName() {
        return this.mSubTitleName;
    }

    public String getTitleName() {
        return this.mTitleName;
    }

    @Override  // android.app.Dialog
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.setContentView(this.mResourceId);
    }

    // 去混淆评级： 低(20)
    @Override  // android.app.Dialog
    public boolean onKeyDown(int v, KeyEvent keyEvent0) {
        return VolumeUtils.onVolumeKeyDown(this.getContext(), v) ? true : super.onKeyDown(v, keyEvent0);
    }

    @Override  // android.app.Dialog
    public void onStart() {
        super.onStart();
    }

    @Override  // android.app.Dialog
    public void onStop() {
        super.onStop();
    }

    public void setBodyMsg(String s) {
        this.mBodyMsg = s;
    }

    public void setCenterBtnName(String s) {
        this.mCenterBtnName = s;
    }

    public void setConfigurationChanged(int v) {
    }

    public void setDefaultSubTitle(String s) {
        this.mDefaultSubTitle = s;
    }

    public void setLeftBtnName(String s) {
        this.mLeftBtnName = s;
    }

    public void setPopupOnClickListener(DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this.mPopupListener = dialogInterface$OnClickListener0;
    }

    public void setPopupSize(int v, int v1) {
        Window window0 = this.getWindow();
        int v2 = -1;
        int v3 = v == -1 ? -1 : ScreenUtils.dipToPixel(this.getContext(), ((float)v));
        if(v1 != -1) {
            v2 = ScreenUtils.dipToPixel(this.getContext(), ((float)v1));
        }
        window0.setLayout(v3, v2);
    }

    public void setRightBtnName(String s) {
        this.mRightBtnName = s;
    }

    public void setSubTitleName(String s) {
        this.mSubTitleName = s;
    }

    public void setTitleName(String s) {
        this.mTitleName = s;
    }

    public void updateLayout(int v) {
        LogU.d("MelonBasePopup", "updateLayout() orientation:" + v);
        Display display0 = ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay();
        Rect rect0 = new Rect();
        display0.getRectSize(rect0);
        int v1 = (int)(((float)rect0.height()) * 0.7f);
        if(v1 > 0) {
            WindowManager.LayoutParams windowManager$LayoutParams0 = this.getWindow().getAttributes();
            if(windowManager$LayoutParams0 != null) {
                windowManager$LayoutParams0.height = v1;
                this.getWindow().setAttributes(windowManager$LayoutParams0);
            }
        }
    }
}

