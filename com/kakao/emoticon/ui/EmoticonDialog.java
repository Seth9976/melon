package com.kakao.emoticon.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public class EmoticonDialog extends Dialog implements View.OnClickListener {
    private Button btnNegative;
    private Button btnPositive;
    private CheckBox checkBox;
    private ImageView ivMsgIcon;
    private View.OnClickListener negativeClickListener;
    private View.OnClickListener positiveClickListener;
    private TextView tvMessage;
    private TextView tvTitle;

    public EmoticonDialog(Context context0) {
        super(context0, 0x1030010);
        this.setContentView(layout.emoticon_alert);
        this.initView();
    }

    private void initView() {
        this.checkBox = (CheckBox)this.findViewById(id.cb_emoticon_dialog);
        this.tvMessage = (TextView)this.findViewById(id.tv_msg);
        this.tvTitle = (TextView)this.findViewById(id.tv_title);
        this.btnNegative = (Button)this.findViewById(id.btn_negative);
        this.btnPositive = (Button)this.findViewById(id.btn_positive);
        this.ivMsgIcon = (ImageView)this.findViewById(id.iv_msg_img);
        this.btnNegative.setOnClickListener(this);
        this.btnPositive.setOnClickListener(this);
        this.findViewById(id.rl_dialog_bg).setOnClickListener(this);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0.getId() == id.btn_negative) {
            View.OnClickListener view$OnClickListener0 = this.negativeClickListener;
            if(view$OnClickListener0 != null) {
                view$OnClickListener0.onClick(this.btnNegative);
            }
        }
        else if(view0.getId() == id.btn_positive) {
            View.OnClickListener view$OnClickListener1 = this.positiveClickListener;
            if(view$OnClickListener1 != null) {
                view$OnClickListener1.onClick(this.btnPositive);
            }
        }
        this.dismiss();
    }

    public void setCheckBox(int v, CompoundButton.OnCheckedChangeListener compoundButton$OnCheckedChangeListener0) {
        this.checkBox.setVisibility(0);
        this.checkBox.setText(v);
        this.checkBox.setOnCheckedChangeListener(compoundButton$OnCheckedChangeListener0);
    }

    public void setMessage(int v) {
        this.tvMessage.setText(v);
    }

    public void setMessage(String s) {
        this.tvMessage.setText(s);
    }

    public void setMsgIcon(int v, int v1, int v2) {
        this.ivMsgIcon.setVisibility(0);
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)this.ivMsgIcon.getLayoutParams();
        linearLayout$LayoutParams0.width = v1;
        linearLayout$LayoutParams0.height = v2;
        this.ivMsgIcon.setLayoutParams(linearLayout$LayoutParams0);
        this.ivMsgIcon.setImageResource(v);
    }

    public void setNegativeButton(int v, View.OnClickListener view$OnClickListener0) {
        this.negativeClickListener = view$OnClickListener0;
        this.btnNegative.setText(v);
    }

    public void setPositiveButton(int v, View.OnClickListener view$OnClickListener0) {
        this.positiveClickListener = view$OnClickListener0;
        this.btnPositive.setText(v);
    }

    @Override  // android.app.Dialog
    public void setTitle(int v) {
        this.tvTitle.setText(v);
    }

    public void setTitle(String s) {
        this.tvTitle.setText(s);
    }
}

