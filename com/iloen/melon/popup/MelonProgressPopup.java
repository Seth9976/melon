package com.iloen.melon.popup;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MelonProgressPopup extends MelonBasePopup implements View.OnClickListener {
    public int a;
    protected TextView mMessageView;
    protected ProgressBar mProgressBar;
    protected TextView mProgressTextView;
    protected TextView mTitleView;

    public MelonProgressPopup(Activity activity0) {
        super(activity0, 0x7F0D05A7);  // layout:popup_drm
        this.a = 100;
        this.setTitleName("안내");
    }

    public TextView getNoticeTextView() {
        return this.mMessageView;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public TextView getProgressTextView() {
        return this.mProgressTextView;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == this.mLeftBt) {
            DialogInterface.OnClickListener dialogInterface$OnClickListener0 = this.mPopupListener;
            if(dialogInterface$OnClickListener0 != null) {
                dialogInterface$OnClickListener0.onClick(this, -1);
            }
            this.dismiss();
            return;
        }
        if(view0 == this.mRightBt) {
            DialogInterface.OnClickListener dialogInterface$OnClickListener1 = this.mPopupListener;
            if(dialogInterface$OnClickListener1 != null) {
                dialogInterface$OnClickListener1.onClick(this, -2);
            }
            this.dismiss();
        }
    }

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        TextView textView0 = (TextView)this.findViewById(0x7F0A0782);  // id:list_title
        this.mTitleView = textView0;
        textView0.setText(this.getTitleName());
        ProgressBar progressBar0 = (ProgressBar)this.findViewById(0x7F0A097E);  // id:progress
        this.mProgressBar = progressBar0;
        progressBar0.setMax(this.a);
        TextView textView1 = (TextView)this.findViewById(0x7F0A08C0);  // id:notice
        this.mMessageView = textView1;
        textView1.setText(this.mBodyMsg);
        TextView textView2 = (TextView)this.findViewById(0x7F0A0988);  // id:progress_text
        this.mProgressTextView = textView2;
        textView2.setText("0%");
    }

    public void setMax(int v) {
        this.a = v;
        ProgressBar progressBar0 = this.mProgressBar;
        if(progressBar0 != null) {
            progressBar0.setMax(v);
        }
    }

    public void setProgress(int v) {
        ProgressBar progressBar0 = this.mProgressBar;
        if(progressBar0 != null) {
            progressBar0.setProgress(v);
        }
        this.mProgressTextView.setText(v * 100 / this.a + "%");
    }
}

