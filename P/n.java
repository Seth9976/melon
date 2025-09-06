package p;

import android.os.Bundle;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService.Stub;

public final class n extends Stub {
    @Override  // android.support.customtabs.IPostMessageService
    public final void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback0, Bundle bundle0) {
        iCustomTabsCallback0.onMessageChannelReady(bundle0);
    }

    @Override  // android.support.customtabs.IPostMessageService
    public final void onPostMessage(ICustomTabsCallback iCustomTabsCallback0, String s, Bundle bundle0) {
        iCustomTabsCallback0.onPostMessage(s, bundle0);
    }
}

