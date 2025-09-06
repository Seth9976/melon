package com.gaa.sdk.auth;

import android.content.Intent;
import android.os.Bundle;
import com.gaa.sdk.base.GlobalStoreBaseActivity;
import y5.a;

public final class SignInActivity extends GlobalStoreBaseActivity {
    public static final String EXTRA_SIGN_IN_INTENT = "sign_in_intent";
    private final String a;

    public SignInActivity() {
        this.a = "SignInActivity";
    }

    @Override  // android.app.Activity
    public void onActivityResult(int v, int v1, Intent intent0) {
        int v2 = 6;
        super.onActivityResult(v, v1, intent0);
        if(v == 101) {
            if(intent0 == null) {
                a.Y("SignInActivity", "Got null intent!");
            }
            else {
                Bundle bundle0 = intent0.getExtras();
                if(bundle0 == null) {
                    a.Y("SignInActivity", "Unexpected null bundle received!");
                }
                else {
                    Object object0 = bundle0.get("responseCode");
                    if(object0 == null) {
                        a.X("SignInActivity", "getResponseCodeFromBundle() got null response code, assuming OK");
                        v2 = 0;
                    }
                    else if(object0 instanceof Integer) {
                        v2 = (int)(((Integer)object0));
                    }
                    else {
                        a.Y("SignInActivity", "Unexpected type for bundle response code: " + object0.getClass().getName());
                    }
                }
            }
            if(v2 != 0) {
                a.Y("SignInActivity", "Activity finished with resultCode " + v1 + " and Auth\'s responseCode: " + v2);
            }
            if(!this.isFinishing()) {
                this.sendResultReceiver(v2, (intent0 == null ? null : intent0.getExtras()));
            }
        }
        else {
            a.Y("SignInActivity", "Got onActivityResult with wrong requestCode: " + v + "; skipping...");
        }
        this.finish();
    }

    @Override  // com.gaa.sdk.base.GlobalStoreBaseActivity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if("com.gaa.sdk.ACTION_DOWNLOAD".equals(this.getIntent().getAction())) {
            this.showDialogForUpdateOrInstall();
            return;
        }
        this.startActivityForResult(((Intent)this.getIntent().getParcelableExtra("sign_in_intent")), 101);
    }
}

