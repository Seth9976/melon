package com.iloen.melon.activity;

import Td.b;
import android.os.Bundle;
import com.iloen.melon.permission.PermissionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import l8.v;
import l8.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005*\u0001\u0014\b\u0017\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u000E\u0010\u0003J\u0019\u0010\u0011\u001A\u00020\u000B2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0013\u0010\u0003R\u0014\u0010\u0013\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/activity/PermissionSupportActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "", "requestCode", "", "", "permissions", "", "grantResults", "Lie/H;", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onDestroy", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressedCallback", "l8/w", "Ll8/w;", "Companion", "l8/v", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class PermissionSupportActivity extends Hilt_PermissionSupportActivity {
    public static final int $stable = 8;
    @NotNull
    public static final v Companion = null;
    @NotNull
    private static final String TAG = "PermissionSupportActivity";
    @NotNull
    private final w onBackPressedCallback;

    static {
        PermissionSupportActivity.Companion = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public PermissionSupportActivity() {
        this.onBackPressedCallback = new w(this);
    }

    public void onBackPressedCallback() {
        this.finish();
    }

    @Override  // com.iloen.melon.activity.Hilt_PermissionSupportActivity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.getOnBackPressedDispatcher().a(this, this.onBackPressedCallback);
    }

    @Override  // com.iloen.melon.activity.Hilt_PermissionSupportActivity
    public void onDestroy() {
        super.onDestroy();
        b.b = null;
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onRequestPermissionsResult(int v, @NotNull String[] arr_s, @NotNull int[] arr_v) {
        q.g(arr_s, "permissions");
        q.g(arr_v, "grantResults");
        super.onRequestPermissionsResult(v, arr_s, arr_v);
        PermissionListener permissionListener0 = b.b;
        if(permissionListener0 == null) {
            return;
        }
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            if(arr_v[v1] != 0) {
                permissionListener0.a();
                return;
            }
        }
        permissionListener0.b();
    }
}

