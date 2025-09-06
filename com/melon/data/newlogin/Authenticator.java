package com.melon.data.newlogin;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.content.Context;
import android.os.Bundle;

public class Authenticator extends AbstractAccountAuthenticator {
    public Authenticator(Context context0) {
        super(context0);
    }

    @Override  // android.accounts.AbstractAccountAuthenticator
    public final Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse0, String s, String s1, String[] arr_s, Bundle bundle0) {
        return bundle0;
    }

    @Override  // android.accounts.AbstractAccountAuthenticator
    public final Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse0, Account account0, Bundle bundle0) {
        return null;
    }

    @Override  // android.accounts.AbstractAccountAuthenticator
    public final Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse0, String s) {
        throw new UnsupportedOperationException();
    }

    @Override  // android.accounts.AbstractAccountAuthenticator
    public final Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse0, Account account0, String s, Bundle bundle0) {
        return bundle0;
    }

    @Override  // android.accounts.AbstractAccountAuthenticator
    public final String getAuthTokenLabel(String s) {
        return null;
    }

    @Override  // android.accounts.AbstractAccountAuthenticator
    public final Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse0, Account account0, String[] arr_s) {
        Bundle bundle0 = new Bundle();
        bundle0.putBoolean("booleanResult", false);
        return bundle0;
    }

    @Override  // android.accounts.AbstractAccountAuthenticator
    public final Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse0, Account account0, String s, Bundle bundle0) {
        return null;
    }
}

