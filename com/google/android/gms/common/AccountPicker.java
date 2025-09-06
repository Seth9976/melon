package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class AccountPicker {
    public static class AccountChooserOptions {
        public static class Builder {
            private Account zza;
            private ArrayList zzb;
            private ArrayList zzc;
            private boolean zzd;
            private String zze;
            private Bundle zzf;

            public Builder() {
                this.zzd = false;
            }

            public AccountChooserOptions build() {
                Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
                Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
                AccountChooserOptions accountPicker$AccountChooserOptions0 = new AccountChooserOptions();
                accountPicker$AccountChooserOptions0.zzf(this.zzc);
                accountPicker$AccountChooserOptions0.zzd(this.zzb);
                accountPicker$AccountChooserOptions0.zzh(this.zzd);
                accountPicker$AccountChooserOptions0.zzl(this.zzf);
                accountPicker$AccountChooserOptions0.zzb(this.zza);
                accountPicker$AccountChooserOptions0.zzj(this.zze);
                return accountPicker$AccountChooserOptions0;
            }

            public Builder setAllowableAccounts(List list0) {
                this.zzb = list0 == null ? null : new ArrayList(list0);
                return this;
            }

            public Builder setAllowableAccountsTypes(List list0) {
                this.zzc = list0 == null ? null : new ArrayList(list0);
                return this;
            }

            public Builder setAlwaysShowAccountPicker(boolean z) {
                this.zzd = z;
                return this;
            }

            public Builder setOptionsForAddingAccount(Bundle bundle0) {
                this.zzf = bundle0;
                return this;
            }

            public Builder setSelectedAccount(Account account0) {
                this.zza = account0;
                return this;
            }

            public Builder setTitleOverrideText(String s) {
                this.zze = s;
                return this;
            }
        }

        private Account zza;
        private ArrayList zzb;
        private ArrayList zzc;
        private boolean zzd;
        private String zze;
        private Bundle zzf;

        public final Account zza() {
            return this.zza;
        }

        public final void zzb(Account account0) {
            this.zza = account0;
        }

        public final ArrayList zzc() {
            return this.zzb;
        }

        public final void zzd(ArrayList arrayList0) {
            this.zzb = arrayList0;
        }

        public final ArrayList zze() {
            return this.zzc;
        }

        public final void zzf(ArrayList arrayList0) {
            this.zzc = arrayList0;
        }

        public final boolean zzg() {
            return this.zzd;
        }

        public final void zzh(boolean z) {
            this.zzd = z;
        }

        public final String zzi() {
            return this.zze;
        }

        public final void zzj(String s) {
            this.zze = s;
        }

        public final Bundle zzk() {
            return this.zzf;
        }

        public final void zzl(Bundle bundle0) {
            this.zzf = bundle0;
        }
    }

    @Deprecated
    public static Intent newChooseAccountIntent(Account account0, ArrayList arrayList0, String[] arr_s, boolean z, String s, String s1, String[] arr_s1, Bundle bundle0) {
        Intent intent0 = new Intent();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        intent0.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent0.setPackage("com.google.android.gms");
        intent0.putExtra("allowableAccounts", arrayList0);
        intent0.putExtra("allowableAccountTypes", arr_s);
        intent0.putExtra("addAccountOptions", bundle0);
        intent0.putExtra("selectedAccount", account0);
        intent0.putExtra("alwaysPromptForAccount", z);
        intent0.putExtra("descriptionTextOverride", s);
        intent0.putExtra("authTokenType", s1);
        intent0.putExtra("addAccountRequiredFeatures", arr_s1);
        intent0.putExtra("setGmsCoreAccount", false);
        intent0.putExtra("overrideTheme", 0);
        intent0.putExtra("overrideCustomTheme", 0);
        intent0.putExtra("hostedDomainFilter", null);
        return intent0;
    }

    public static Intent newChooseAccountIntent(AccountChooserOptions accountPicker$AccountChooserOptions0) {
        Intent intent0 = new Intent();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
        Preconditions.checkArgument(true, "Making the selected account non-clickable is only supported for the THEME_DAY_NIGHT_GOOGLE_MATERIAL2, THEME_LIGHT_GOOGLE_MATERIAL3, THEME_DARK_GOOGLE_MATERIAL3 or THEME_DAY_NIGHT_GOOGLE_MATERIAL3 themes");
        intent0.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent0.setPackage("com.google.android.gms");
        intent0.putExtra("allowableAccounts", accountPicker$AccountChooserOptions0.zzc());
        if(accountPicker$AccountChooserOptions0.zze() != null) {
            intent0.putExtra("allowableAccountTypes", ((String[])accountPicker$AccountChooserOptions0.zze().toArray(new String[0])));
        }
        intent0.putExtra("addAccountOptions", accountPicker$AccountChooserOptions0.zzk());
        intent0.putExtra("selectedAccount", accountPicker$AccountChooserOptions0.zza());
        intent0.putExtra("selectedAccountIsNotClickable", false);
        intent0.putExtra("alwaysPromptForAccount", accountPicker$AccountChooserOptions0.zzg());
        intent0.putExtra("descriptionTextOverride", accountPicker$AccountChooserOptions0.zzi());
        intent0.putExtra("setGmsCoreAccount", false);
        intent0.putExtra("realClientPackage", null);
        intent0.putExtra("overrideTheme", 0);
        intent0.putExtra("overrideCustomTheme", 0);
        intent0.putExtra("hostedDomainFilter", null);
        Bundle bundle0 = new Bundle();
        if(!bundle0.isEmpty()) {
            intent0.putExtra("first_party_options_bundle", bundle0);
        }
        return intent0;
    }
}

