package Q9;

import android.webkit.ValueCallback;
import com.kakaoent.trevi.ad.ui.fragment.CashFriendsWebViewFragment;

public final class e implements ValueCallback {
    @Override  // android.webkit.ValueCallback
    public final void onReceiveValue(Object object0) {
        CashFriendsWebViewFragment.l(((String)object0));
    }
}

