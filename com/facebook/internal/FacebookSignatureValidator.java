package com.facebook.internal;

import Tf.v;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import java.util.HashSet;
import je.I;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0004H\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001E\u0010\u000B\u001A\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/FacebookSignatureValidator;", "", "()V", "FBF_HASH", "", "FBI_HASH", "FBL_HASH", "FBR2_HASH", "FBR_HASH", "IGR_HASH", "MSR_HASH", "validAppSignatureHashes", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "validateSignature", "", "context", "Landroid/content/Context;", "packageName", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookSignatureValidator {
    @NotNull
    private static final String FBF_HASH = "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3";
    @NotNull
    private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
    @NotNull
    private static final String FBL_HASH = "df6b721c8b4d3b6eb44c861d4415007e5a35fc95";
    @NotNull
    private static final String FBR2_HASH = "cc2751449a350f668590264ed76692694a80308a";
    @NotNull
    private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
    @NotNull
    private static final String IGR_HASH = "c56fb7d591ba6704df047fd98f535372fea00211";
    @NotNull
    public static final FacebookSignatureValidator INSTANCE = null;
    @NotNull
    private static final String MSR_HASH = "9b8f518b086098de3d77736f9458a3d2f6f95a37";
    @NotNull
    private static final HashSet validAppSignatureHashes;

    static {
        FacebookSignatureValidator.INSTANCE = new FacebookSignatureValidator();
        FacebookSignatureValidator.validAppSignatureHashes = I.H(new String[]{"8a3c4b262d721acd49a4bf97d5213199c86fa2b9", "cc2751449a350f668590264ed76692694a80308a", "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc", "df6b721c8b4d3b6eb44c861d4415007e5a35fc95", "9b8f518b086098de3d77736f9458a3d2f6f95a37", "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3", "c56fb7d591ba6704df047fd98f535372fea00211"});
    }

    public static final boolean validateSignature(@NotNull Context context0, @NotNull String s) {
        q.g(context0, "context");
        q.g(s, "packageName");
        String s1 = Build.BRAND;
        int v = context0.getApplicationInfo().flags;
        q.f(s1, "brand");
        if(v.r0(s1, "generic", false) && (v & 2) != 0) {
            return true;
        }
        try {
            Signature[] arr_signature = context0.getPackageManager().getPackageInfo(s, 0x40).signatures;
            if(arr_signature != null && arr_signature.length != 0) {
                q.f(arr_signature, "packageInfo.signatures");
                for(int v1 = 0; v1 < arr_signature.length; ++v1) {
                    byte[] arr_b = arr_signature[v1].toByteArray();
                    q.f(arr_b, "it.toByteArray()");
                    String s2 = Utility.sha1hash(arr_b);
                    if(!p.d0(FacebookSignatureValidator.validAppSignatureHashes, s2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    }
}

