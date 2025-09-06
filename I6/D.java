package i6;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.F;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class d extends F {
    private boolean waitingForDismissAllowingStateLoss;

    public static void access$100(d d0) {
        if(d0.waitingForDismissAllowingStateLoss) {
            d0.super.dismissAllowingStateLoss();
            return;
        }
        d0.super.dismiss();
    }

    @Override  // androidx.fragment.app.w
    public void dismiss() {
        Dialog dialog0 = this.getDialog();
        if(dialog0 instanceof BottomSheetDialog) {
            ((BottomSheetDialog)dialog0).e();
        }
        super.dismiss();
    }

    @Override  // androidx.fragment.app.w
    public void dismissAllowingStateLoss() {
        Dialog dialog0 = this.getDialog();
        if(dialog0 instanceof BottomSheetDialog) {
            ((BottomSheetDialog)dialog0).e();
        }
        super.dismissAllowingStateLoss();
    }

    @Override  // androidx.appcompat.app.F
    public Dialog onCreateDialog(Bundle bundle0) {
        return new BottomSheetDialog(this.getContext(), this.getTheme());
    }
}

