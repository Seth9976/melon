package com.iloen.melon.popup;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventNotificationScheme;
import com.iloen.melon.utils.ui.ViewUtils;

public class MelonTextNCheckPopup extends MelonBasePopup implements View.OnClickListener {
    public boolean a;
    public boolean b;
    public View c;
    protected CheckBox cbCheckBox;
    protected String mCheckMsg;
    protected String mGoLinkMsg;
    protected String mGoLinkUrl;
    protected TextView tvBodyMsg;
    protected TextView tvCheckMsg;
    protected TextView tvGoLink;
    protected TextView tvTitleMsg;

    public MelonTextNCheckPopup(Activity activity0, int v) {
        super(activity0, v);
        this.tvTitleMsg = null;
        this.tvBodyMsg = null;
        this.tvCheckMsg = null;
        this.tvGoLink = null;
        this.cbCheckBox = null;
        this.a = false;
        this.b = false;
        this.c = null;
    }

    public String getCheckMsg() {
        return this.mCheckMsg;
    }

    public boolean isCentFlag() {
        return this.a;
    }

    public boolean isCheckState() {
        return this.b;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == this.mRightButton) {
            DialogInterface.OnClickListener dialogInterface$OnClickListener0 = this.mPopupListener;
            if(dialogInterface$OnClickListener0 != null) {
                dialogInterface$OnClickListener0.onClick(this, -1);
            }
            this.dismiss();
        }
    }

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        TextView textView0 = (TextView)this.findViewById(0x7F0A0CEA);  // id:tv_popup_title
        this.tvTitleMsg = textView0;
        textView0.setText(this.getTitleName());
        TextView textView1 = (TextView)this.findViewById(0x7F0A0CE6);  // id:tv_popup_body
        this.tvBodyMsg = textView1;
        textView1.setText(this.getBodyMsg());
        TextView textView2 = (TextView)this.findViewById(0x7F0A0CE7);  // id:tv_popup_checkbox
        this.tvCheckMsg = textView2;
        textView2.setText(this.getCheckMsg());
        this.tvGoLink = (TextView)this.findViewById(0x7F0A0C87);  // id:tv_go_link
        if(!TextUtils.isEmpty(this.mGoLinkMsg)) {
            ViewUtils.showWhen(this.tvGoLink, true);
            this.tvGoLink.setText(this.mGoLinkMsg);
            ViewUtils.setOnClickListener(this.tvGoLink, new View.OnClickListener() {
                public final MelonTextNCheckPopup a;

                {
                    this.a = melonTextNCheckPopup0;
                }

                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    MelonTextNCheckPopup melonTextNCheckPopup0 = this.a;
                    if(!TextUtils.isEmpty(melonTextNCheckPopup0.mGoLinkUrl)) {
                        EventNotificationScheme eventNotificationScheme0 = new EventNotificationScheme();
                        eventNotificationScheme0.scheme = melonTextNCheckPopup0.mGoLinkUrl;
                        EventBusHelper.post(eventNotificationScheme0);
                    }
                    melonTextNCheckPopup0.dismiss();
                }
            });
        }
        if(this.isCentFlag()) {
            this.tvBodyMsg.setGravity(17);
            this.tvCheckMsg.setGravity(17);
        }
        View view0 = this.findViewById(0x7F0A0192);  // id:btn_popup_close
        if(view0 != null) {
            this.mRightButton = (TextView)view0;
            ((TextView)view0).setOnClickListener(this);
        }
        View view1 = this.findViewById(0x7F0A0191);  // id:btn_popup_check
        this.c = view1;
        this.cbCheckBox = (CheckBox)view1.findViewById(0x7F0A094C);  // id:popup_checkbox
        this.c.setOnClickListener(new View.OnClickListener() {
            public final MelonTextNCheckPopup a;

            {
                this.a = melonTextNCheckPopup0;
            }

            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                int v = !this.a.b;
                this.a.b = v;
                this.a.cbCheckBox.setChecked(((boolean)v));
            }
        });
    }

    public void setCentFlag(boolean z) {
        this.a = z;
    }

    public void setCheckMsg(String s) {
        this.mCheckMsg = s;
    }

    public void setCheckState(boolean z) {
        this.b = z;
    }

    public void setGoLinkMsg(String s) {
        this.mGoLinkMsg = s;
    }

    public void setGoLinkUrl(String s) {
        this.mGoLinkUrl = s;
    }
}

