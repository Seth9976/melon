package s0;

import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager.AutofillCallback;

public final class h extends AutofillManager.AutofillCallback {
    public static final h a;

    static {
        h.a = new h();  // 初始化器: Landroid/view/autofill/AutofillManager$AutofillCallback;-><init>()V
    }

    @Override  // android.view.autofill.AutofillManager$AutofillCallback
    public final void onAutofillEvent(View view0, int v, int v1) {
        String s;
        super.onAutofillEvent(view0, v, v1);
        switch(v1) {
            case 1: {
                s = "Autofill popup was shown.";
                break;
            }
            case 2: {
                s = "Autofill popup was hidden.";
                break;
            }
            case 3: {
                s = "Autofill popup isn\'t shown because autofill is not available.\n\nDid you set up autofill?\n1. Go to Settings > System > Languages&input > Advanced > Autofill Service\n2. Pick a service\n\nDid you add an account?\n1. Go to Settings > System > Languages&input > Advanced\n2. Click on the settings icon next to the Autofill Service\n3. Add your account";
                break;
            }
            default: {
                s = "Unknown status event.";
            }
        }
        Log.d("Autofill Status", s);
    }
}

