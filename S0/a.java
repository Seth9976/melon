package s0;

import Q0.u;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import k8.Y;

public final class a implements g {
    public final u a;
    public final k b;
    public final AutofillManager c;
    public final AutofillId d;

    public a(u u0, k k0) {
        this.a = u0;
        this.b = k0;
        AutofillManager autofillManager0 = (AutofillManager)u0.getContext().getSystemService(AutofillManager.class);
        if(autofillManager0 == null) {
            throw new IllegalStateException("Autofill service could not be located.");
        }
        this.c = autofillManager0;
        u0.setImportantForAutofill(1);
        AutofillId autofillId0 = u0.getAutofillId();
        if(autofillId0 == null) {
            throw Y.d("Required value was null.");
        }
        this.d = autofillId0;
    }
}

