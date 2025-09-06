package u6;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.v;
import com.kakao.sdk.common.util.a;
import java.util.Objects;

public class c {
    public OnBackInvokedCallback a;

    public OnBackInvokedCallback a(b b0) {
        Objects.requireNonNull(b0);
        return new v(b0, 3);
    }

    public void b(b b0, View view0, boolean z) {
        if(this.a == null) {
            OnBackInvokedDispatcher onBackInvokedDispatcher0 = a.g(view0);
            if(onBackInvokedDispatcher0 != null) {
                OnBackInvokedCallback onBackInvokedCallback0 = this.a(b0);
                this.a = onBackInvokedCallback0;
                a.l(onBackInvokedDispatcher0, (z ? 1000000 : 0), onBackInvokedCallback0);
            }
        }
    }

    public void c(View view0) {
        OnBackInvokedDispatcher onBackInvokedDispatcher0 = a.g(view0);
        if(onBackInvokedDispatcher0 == null) {
            return;
        }
        onBackInvokedDispatcher0.unregisterOnBackInvokedCallback(this.a);
        this.a = null;
    }
}

