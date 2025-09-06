package com.iloen.melon.popup;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class MelonDcfMoreInfoPopup extends Dialog {
    public static final int BUTTON_CONFIRM = -10;
    public static final int BUTTON_INFO_LINK = -12;
    public DialogInterface.OnClickListener a;

    public MelonDcfMoreInfoPopup(Context context0, String s) {
        super(context0);
        this.requestWindowFeature(1);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.setContentView(0x7F0D05A6);  // layout:popup_dcf_info
        ((TextView)this.findViewById(0x7F0A0C67)).setText(s);  // id:tv_dlg_message
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A0777), new View.OnClickListener() {  // id:link_dcf_info
            public final MelonDcfMoreInfoPopup a;

            {
                this.a = melonDcfMoreInfoPopup0;
            }

            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                MelonDcfMoreInfoPopup melonDcfMoreInfoPopup0 = this.a;
                DialogInterface.OnClickListener dialogInterface$OnClickListener0 = melonDcfMoreInfoPopup0.a;
                if(dialogInterface$OnClickListener0 != null) {
                    dialogInterface$OnClickListener0.onClick(melonDcfMoreInfoPopup0, -12);
                }
                melonDcfMoreInfoPopup0.dismiss();
            }
        });
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A0150), new View.OnClickListener() {  // id:btn_confirm
            public final MelonDcfMoreInfoPopup a;

            {
                this.a = melonDcfMoreInfoPopup0;
            }

            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                MelonDcfMoreInfoPopup melonDcfMoreInfoPopup0 = this.a;
                DialogInterface.OnClickListener dialogInterface$OnClickListener0 = melonDcfMoreInfoPopup0.a;
                if(dialogInterface$OnClickListener0 != null) {
                    dialogInterface$OnClickListener0.onClick(melonDcfMoreInfoPopup0, -10);
                }
                melonDcfMoreInfoPopup0.dismiss();
            }
        });
        CheckBox checkBox0 = (CheckBox)this.findViewById(0x7F0A01BA);  // id:btn_show_once
        checkBox0.setPadding(ScreenUtils.dipToPixel(this.getContext(), 8.0f), 0, 0, 0);
        checkBox0.setOnCheckedChangeListener(new com.iloen.melon.popup.MelonDcfMoreInfoPopup.3());  // 初始化器: Ljava/lang/Object;-><init>()V

        class com.iloen.melon.popup.MelonDcfMoreInfoPopup.3 implements CompoundButton.OnCheckedChangeListener {
            @Override  // android.widget.CompoundButton$OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
                MelonPrefs.getInstance().setBoolean("AGAIN_NEVER_SHOW_DCF_INFO_POPUP", z);
            }
        }

    }

    public void setPopupOnClickListener(DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this.a = dialogInterface$OnClickListener0;
    }
}

