package l8;

import b.n;
import com.iloen.melon.activity.PermissionSupportActivity;

public final class w extends n {
    public final PermissionSupportActivity a;

    public w(PermissionSupportActivity permissionSupportActivity0) {
        this.a = permissionSupportActivity0;
        super(true);
    }

    @Override  // b.n
    public final void handleOnBackPressed() {
        this.a.onBackPressedCallback();
    }
}

