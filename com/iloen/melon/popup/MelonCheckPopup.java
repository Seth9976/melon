package com.iloen.melon.popup;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.utils.ui.ViewUtils;

public class MelonCheckPopup extends MelonBasePopup implements View.OnClickListener {
    public static class Builder {
        public int a;
        public int b;
        public int c;
        public int d;
        public String e;
        public String f;
        public DialogInterface.OnClickListener g;

        public Builder bodyHint(int v) {
            MelonAppBase.instance.getContext().getString(v);
            return this;
        }

        public Builder bodyHint(String s) {
            return this;
        }

        public Builder bodyText(int v) {
            this.f = MelonAppBase.instance.getContext().getString(v);
            return this;
        }

        public Builder bodyText(String s) {
            this.f = s;
            return this;
        }

        public Builder bodyView(int v) {
            this.b = v;
            return this;
        }

        public MelonCheckPopup build(Activity activity0, int v) {
            return new MelonCheckPopup(activity0, v, this);
        }

        public Builder clickListener(DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
            this.g = dialogInterface$OnClickListener0;
            return this;
        }

        public Builder inputCountView(int v) {
            return this;
        }

        public Builder textLimit(MelonLimits.TextLimit melonLimits$TextLimit0) {
            return this;
        }

        public Builder titleText(int v) {
            this.e = MelonAppBase.instance.getContext().getString(v);
            return this;
        }

        public Builder titleText(String s) {
            this.e = s;
            return this;
        }

        public Builder titleView(int v) {
            this.a = v;
            return this;
        }
    }

    public boolean a;
    public final Builder b;
    protected boolean blockDismiss;
    protected ViewGroup mBodyContainer;
    protected CheckBox mCheckBox;
    protected View mCheckBoxContainer;
    protected TextView tvBodyMsg;
    protected TextView tvTitleMsg;

    public MelonCheckPopup(Activity activity0, int v) {
        super(activity0, v);
        this.tvTitleMsg = null;
        this.tvBodyMsg = null;
        this.mCheckBox = null;
        this.mCheckBoxContainer = null;
        this.a = false;
        this.blockDismiss = false;
        this.mBodyContainer = null;
    }

    public MelonCheckPopup(Activity activity0, int v, Builder melonCheckPopup$Builder0) {
        this(activity0, v);
        this.setTitleName(melonCheckPopup$Builder0.e);
        this.setBodyMsg(melonCheckPopup$Builder0.f);
        this.setPopupOnClickListener(melonCheckPopup$Builder0.g);
        this.b = melonCheckPopup$Builder0;
    }

    public boolean isCentFlag() {
        return this.a;
    }

    public boolean isChecked() {
        return this.mCheckBox.isChecked();
    }

    public static Builder newBuilder() {
        Builder melonCheckPopup$Builder0 = new Builder();  // 初始化器: Ljava/lang/Object;-><init>()V
        melonCheckPopup$Builder0.a = 0x7F0A0CEA;  // id:tv_popup_title
        melonCheckPopup$Builder0.b = 0x7F0A0CE6;  // id:tv_popup_body
        melonCheckPopup$Builder0.c = 0x7F0A094C;  // id:popup_checkbox
        melonCheckPopup$Builder0.d = 0x7F0A0191;  // id:btn_popup_check
        return melonCheckPopup$Builder0;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == this.mRightButton) {
            DialogInterface.OnClickListener dialogInterface$OnClickListener0 = this.mPopupListener;
            if(dialogInterface$OnClickListener0 != null) {
                dialogInterface$OnClickListener0.onClick(this, -1);
            }
            if(!this.blockDismiss) {
                this.dismiss();
            }
        }
        else if(view0 == this.mCheckBoxContainer) {
            this.mCheckBox.setChecked(!this.mCheckBox.isChecked());
        }
    }

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.mBodyContainer = (ViewGroup)this.findViewById(0x7F0A093F);  // id:popup_body
        Builder melonCheckPopup$Builder0 = this.b;
        if(melonCheckPopup$Builder0 != null) {
            TextView textView0 = (TextView)this.findViewById(melonCheckPopup$Builder0.a);
            this.tvTitleMsg = textView0;
            textView0.setText(this.getTitleName());
            TextView textView1 = (TextView)this.findViewById(melonCheckPopup$Builder0.b);
            this.tvBodyMsg = textView1;
            textView1.setText(this.getBodyMsg());
            View view0 = this.findViewById(melonCheckPopup$Builder0.d);
            this.mCheckBoxContainer = view0;
            this.mCheckBox = (CheckBox)view0.findViewById(melonCheckPopup$Builder0.c);
            this.mCheckBoxContainer.setOnClickListener(this);
        }
        if(this.isCentFlag()) {
            this.tvTitleMsg.setGravity(17);
            this.tvBodyMsg.setGravity(17);
        }
        this.mRightButton = (TextView)this.findViewById(0x7F0A0192);  // id:btn_popup_close
        if(!TextUtils.isEmpty(this.mRightBtnName)) {
            ViewUtils.setText(this.mRightButton, this.mRightBtnName);
        }
        this.mRightButton.setOnClickListener(this);
    }

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void onStart() {
        super.onStart();
    }

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void onStop() {
        super.onStop();
    }

    public void setBlockDismiss(boolean z) {
        this.blockDismiss = z;
    }

    public void setCentFlag(boolean z) {
        this.a = z;
    }

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void setTitleName(String s) {
        super.setTitleName(s);
        TextView textView0 = this.tvTitleMsg;
        if(textView0 != null) {
            textView0.setText(this.getTitleName());
        }
    }
}

