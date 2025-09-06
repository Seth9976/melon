package com.iloen.melon.popup;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.activity.ComponentDialog;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.utils.ui.ViewUtils;

public class FullscreenProgressDialog extends ComponentDialog {
    public interface OnBackKeyListener {
        void onBackKeyPressed();
    }

    public OnBackKeyListener d;
    public final MelonBaseFragment e;

    public FullscreenProgressDialog(Context context0) {
        super(context0);
        this.d = null;
        this.e = null;
        this.requestWindowFeature(1);
        this.setContentView(0x7F0D02D6);  // layout:fullscreen_progress_dialog
        this.getWindow().setBackgroundDrawableResource(0x106000D);
        this.setDimAmount(0.3f);
        ViewUtils.showWhen(this.findViewById(0x7F0A097E), true);  // id:progress
    }

    public FullscreenProgressDialog(MelonBaseFragment melonBaseFragment0, boolean z) {
        this(melonBaseFragment0.getActivity());
        if(z) {
            this.e = melonBaseFragment0;
        }
    }

    @Override  // androidx.activity.ComponentDialog
    public void onBackPressed() {
        super.onBackPressed();
        OnBackKeyListener fullscreenProgressDialog$OnBackKeyListener0 = this.d;
        if(fullscreenProgressDialog$OnBackKeyListener0 != null) {
            fullscreenProgressDialog$OnBackKeyListener0.onBackKeyPressed();
        }
        MelonBaseFragment melonBaseFragment0 = this.e;
        if(melonBaseFragment0 != null && melonBaseFragment0.isAdded()) {
            melonBaseFragment0.performBackPress();
        }
    }

    @Override  // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
    }

    public final void setDialogPaddingTop(int v) {
        View view0 = this.findViewById(0x7F0A0985);  // id:progress_dialog_container
        if(view0 != null) {
            view0.setPadding(0, v, 0, 0);
        }
    }

    public void setDim(boolean z) {
        Window window0 = this.getWindow();
        if(window0 == null) {
            return;
        }
        if(z) {
            window0.addFlags(2);
            return;
        }
        window0.clearFlags(2);
    }

    public void setDimAmount(float f) {
        Window window0 = this.getWindow();
        WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
        windowManager$LayoutParams0.dimAmount = f;
        window0.setAttributes(windowManager$LayoutParams0);
    }

    public void setOnBackKeyListener(OnBackKeyListener fullscreenProgressDialog$OnBackKeyListener0) {
        this.d = fullscreenProgressDialog$OnBackKeyListener0;
    }

    public void setText(String s) {
        TextView textView0 = (TextView)this.findViewById(0x7F0A0988);  // id:progress_text
        if(textView0 != null) {
            textView0.setText(s);
            ViewUtils.showWhen(textView0, !TextUtils.isEmpty(s));
        }
    }
}

