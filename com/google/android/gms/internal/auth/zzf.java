package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import javax.annotation.Nullable;

public interface zzf extends IInterface {
    Bundle zzd(String arg1, Bundle arg2);

    @Nullable
    Bundle zze(Account arg1, String arg2, Bundle arg3);

    @Nullable
    Bundle zzf(Account arg1);

    Bundle zzg(String arg1);

    AccountChangeEventsResponse zzh(AccountChangeEventsRequest arg1);
}

