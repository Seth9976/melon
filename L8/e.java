package l8;

import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.net.HttpResponse.Notification.Buttons;
import we.a;

public final class e implements a {
    public final int a;
    public final BaseActivity b;
    public final Buttons c;

    public e(BaseActivity baseActivity0, Buttons httpResponse$Notification$Buttons0, int v) {
        this.a = v;
        this.b = baseActivity0;
        this.c = httpResponse$Notification$Buttons0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return BaseActivity.showEventNotificationDialog$lambda$4(this.b, this.c);
            }
            case 1: {
                return BaseActivity.showEventNotificationDialog$lambda$5(this.b, this.c);
            }
            default: {
                return BaseActivity.showEventNotificationDialog$lambda$6(this.b, this.c);
            }
        }
    }
}

