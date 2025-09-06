package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;

public class ShareCompat.IntentBuilder {
    public final Intent a;

    public ShareCompat.IntentBuilder(Context context0) {
        context0.getClass();
        Activity activity0;
        Intent intent0 = new Intent().setAction("android.intent.action.SEND");
        this.a = intent0;
        intent0.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", "com.iloen.melon");
        intent0.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", "com.iloen.melon");
        intent0.addFlags(0x80000);
        while(true) {
            activity0 = null;
            if(!(context0 instanceof ContextWrapper)) {
                break;
            }
            if(context0 instanceof Activity) {
                activity0 = (Activity)context0;
                break;
            }
            context0 = ((ContextWrapper)context0).getBaseContext();
        }
        if(activity0 != null) {
            ComponentName componentName0 = activity0.getComponentName();
            this.a.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", componentName0);
            this.a.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", componentName0);
        }
    }
}

