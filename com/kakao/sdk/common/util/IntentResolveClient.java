package com.kakao.sdk.common.util;

import Gd.e;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build.VERSION;
import android.os.Parcelable;
import com.kakao.sdk.v2.common.R.string;
import d3.g;
import ie.j;
import java.util.ArrayList;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0002J\u001A\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u000FH\u0016J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\b\u001A\u00020\tH\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/kakao/sdk/common/util/IntentResolveClient;", "", "()V", "allowedPackages", "", "", "[Ljava/lang/String;", "allowedSignatures", "packageInfo", "Landroid/content/pm/PackageInfo;", "pm", "Landroid/content/pm/PackageManager;", "info", "Landroid/content/pm/ResolveInfo;", "resolveTalkIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "intent", "validateTalkSignature", "", "Companion", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class IntentResolveClient {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\t\u001A\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000E\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000E\u0010\fR\u0014\u0010\u000F\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000F\u0010\fR\u0014\u0010\u0010\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/kakao/sdk/common/util/IntentResolveClient$Companion;", "", "<init>", "()V", "Lcom/kakao/sdk/common/util/IntentResolveClient;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/kakao/sdk/common/util/IntentResolveClient;", "instance", "", "ALPHA_TALK_PACKAGE_NAME", "Ljava/lang/String;", "DEBUG_SIGNATURE", "ONE_RELEASE_SIGNATURE", "ONE_TALK_PACKAGE_NAME", "RELEASE_SIGNATURE", "SANDBOX_TALK_PACKAGE_NAME", "TALK_PACKAGE_NAME", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final IntentResolveClient getInstance() {
            return (IntentResolveClient)IntentResolveClient.instance$delegate.getValue();
        }
    }

    @NotNull
    private static final String ALPHA_TALK_PACKAGE_NAME = "com.kakao.talk.alpha";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String DEBUG_SIGNATURE = "308201e53082014ea00302010202044f4ae542300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3132303232373032303635385a170d3432303231393032303635385a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d0030818902818100c0b41c25ef21a39a13ce89c82dc3a14bf9ef0c3094aa2ac1bf755c9699535e79119e8b980c0ecdcc51f259eb0d8b2077d41de8fcfdeaac3f386c05e2a684ecb5504b660ad7d5a01cce35899f96bcbd099c9dcb274c6eb41fef861616a12fb45bc57a19683a8a97ab1a33d9c70128878b67dd1b3a388ad5121d1d66ff04c065ff0203010001300d06092a864886f70d0101050500038181000418a7dacb6d13eb61c8270fe1fdd006eb66d0ff9f58f475defd8dc1fb11c41e34ce924531d1fd8ad26d9479d64f54851bf57b8dfe3a5d6f0a01dcad5b8c36ac4ac48caeff37888c36483c26b09aaa9689dbb896938d5afe40135bf7d9f12643046301867165d28be0baa3513a5084e182f7f9c044d5baa58bdce55fa1845241";
    @NotNull
    private static final String ONE_RELEASE_SIGNATURE = "30820303308201eba003020102020452441f49300d06092a864886f70d01010b05003031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d3020170d3137303631393039353135315a180f33303135313032313039353135315a3031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d30820122300d06092a864886f70d01010105000382010f003082010a0282010100c2867a4e6fb76eaa00d5ecac63c897ebd924bb40d3f7dd90f73599a2049ae40abc4c7b1dce10dafbfdabbebf3653d7c6a18a3ade469dbe5bd0590748aae4151491001eadd8b02f7469646530595c028ed70feeacd7184fc5b0fd0ceb95addd03b7d18097a32a4afc830e209e25c65656587d891282c610429965cc44f3d63ea249d4df41453ac30ca1b3eaf4b1f8fc5cf41af4964f66f611b799f6246fcb1d6b42fff8cff202a433a90ccd25385c4d015ac770dedf8914d86c53b0eebdd4c5c5e3a509e360785fc38ee075b6d7faad19f7c876ff3949a85f601158f99c67ee14c20ff759d3057dc258146f579a5e3d90457d9996f004808f4aa625ab9a67dfc30203010001a321301f301d0603551d0e041604141487897f76c0e76161888c86336325b6e58fce5d300d06092a864886f70d01010b050003820101007bf867fa1b4ef0ea4d6de127238319c84dcae79398e60f960ab71a8bdf488b0aa07888e994bba531f4419037cd006b7d9a64860a6591b96534967444b8854bef6a6eff3161dbcbebfe5e6c979650c9d51f76676b217b8285992f4a172d4a857775c42dc3875796434b13b78d6cfb174bfaa0c59976fb7a1cd4d26527881cfd39a61cd35843dd2cd49afd7d3966947b2662fc44dbff3704094687ce70ccabeb8a9d93f39974bd11fdb1dcb9404d8a6408cae45c315ced013f088c5264ce9c8738715ecf83bc991d4e3971e4a2cc39bcd11be426d793638981455d083cfd7bfd3b88ecd11e581260ae7fbf27b8c9cdf0da49a467e375f4273d6e01d7114ac7126f";
    @NotNull
    private static final String ONE_TALK_PACKAGE_NAME = "com.kakao.onetalk";
    @NotNull
    private static final String RELEASE_SIGNATURE = "308201db30820144a00302010202044c707197300d06092a864886f70d01010505003031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d3020170d3130303832323030333834375a180f32313130303732393030333834375a3031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d30819f300d06092a864886f70d010101050003818d0030818902818100aef387bc86e022a87e66b8c42153284f18e0c468cf9c87a241b989729dfdad3dd9e1847546d01a2819ba77f3974a47b473c926acae173fd90c7e635000721feeef6705da7ae949a35b82900a0f67d9464d73ed8a98c37f4ac70729494a17469bc40d4ee06d043b09147ebadc55fa1020968d7036c5fb9b8c148cba1d8e9d9fc10203010001300d06092a864886f70d0101050500038181005569be704c68cff6221c1e04dd8a131110f9f5cd2138042286337fd6014a1b1d2d3eeb266ae1630afe56bf63c07dd0b5c8fad46dcb9f802f9a7802fb89eb3b4777b9665bb1ed9feaf1dc7cac4f91abedfc81187ff6d2f471dbd12335d2c0ef0e2ee719df6e763f814b9ac91f8be37fd11d40686700d66be6de22a1836f060f01";
    @NotNull
    private static final String SANDBOX_TALK_PACKAGE_NAME = "com.kakao.talk.sandbox";
    @NotNull
    private static final String TALK_PACKAGE_NAME = "com.kakao.talk";
    @NotNull
    private final String[] allowedPackages;
    @NotNull
    private final String[] allowedSignatures;
    @NotNull
    private static final j instance$delegate;

    static {
        IntentResolveClient.Companion = new Companion(null);
        IntentResolveClient.instance$delegate = g.Q(IntentResolveClient.Companion.instance.2.INSTANCE);
    }

    public IntentResolveClient() {
        this.allowedSignatures = new String[]{"308201db30820144a00302010202044c707197300d06092a864886f70d01010505003031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d3020170d3130303832323030333834375a180f32313130303732393030333834375a3031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d30819f300d06092a864886f70d010101050003818d0030818902818100aef387bc86e022a87e66b8c42153284f18e0c468cf9c87a241b989729dfdad3dd9e1847546d01a2819ba77f3974a47b473c926acae173fd90c7e635000721feeef6705da7ae949a35b82900a0f67d9464d73ed8a98c37f4ac70729494a17469bc40d4ee06d043b09147ebadc55fa1020968d7036c5fb9b8c148cba1d8e9d9fc10203010001300d06092a864886f70d0101050500038181005569be704c68cff6221c1e04dd8a131110f9f5cd2138042286337fd6014a1b1d2d3eeb266ae1630afe56bf63c07dd0b5c8fad46dcb9f802f9a7802fb89eb3b4777b9665bb1ed9feaf1dc7cac4f91abedfc81187ff6d2f471dbd12335d2c0ef0e2ee719df6e763f814b9ac91f8be37fd11d40686700d66be6de22a1836f060f01", "308201e53082014ea00302010202044f4ae542300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3132303232373032303635385a170d3432303231393032303635385a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d0030818902818100c0b41c25ef21a39a13ce89c82dc3a14bf9ef0c3094aa2ac1bf755c9699535e79119e8b980c0ecdcc51f259eb0d8b2077d41de8fcfdeaac3f386c05e2a684ecb5504b660ad7d5a01cce35899f96bcbd099c9dcb274c6eb41fef861616a12fb45bc57a19683a8a97ab1a33d9c70128878b67dd1b3a388ad5121d1d66ff04c065ff0203010001300d06092a864886f70d0101050500038181000418a7dacb6d13eb61c8270fe1fdd006eb66d0ff9f58f475defd8dc1fb11c41e34ce924531d1fd8ad26d9479d64f54851bf57b8dfe3a5d6f0a01dcad5b8c36ac4ac48caeff37888c36483c26b09aaa9689dbb896938d5afe40135bf7d9f12643046301867165d28be0baa3513a5084e182f7f9c044d5baa58bdce55fa1845241", "30820303308201eba003020102020452441f49300d06092a864886f70d01010b05003031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d3020170d3137303631393039353135315a180f33303135313032313039353135315a3031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d30820122300d06092a864886f70d01010105000382010f003082010a0282010100c2867a4e6fb76eaa00d5ecac63c897ebd924bb40d3f7dd90f73599a2049ae40abc4c7b1dce10dafbfdabbebf3653d7c6a18a3ade469dbe5bd0590748aae4151491001eadd8b02f7469646530595c028ed70feeacd7184fc5b0fd0ceb95addd03b7d18097a32a4afc830e209e25c65656587d891282c610429965cc44f3d63ea249d4df41453ac30ca1b3eaf4b1f8fc5cf41af4964f66f611b799f6246fcb1d6b42fff8cff202a433a90ccd25385c4d015ac770dedf8914d86c53b0eebdd4c5c5e3a509e360785fc38ee075b6d7faad19f7c876ff3949a85f601158f99c67ee14c20ff759d3057dc258146f579a5e3d90457d9996f004808f4aa625ab9a67dfc30203010001a321301f301d0603551d0e041604141487897f76c0e76161888c86336325b6e58fce5d300d06092a864886f70d01010b050003820101007bf867fa1b4ef0ea4d6de127238319c84dcae79398e60f960ab71a8bdf488b0aa07888e994bba531f4419037cd006b7d9a64860a6591b96534967444b8854bef6a6eff3161dbcbebfe5e6c979650c9d51f76676b217b8285992f4a172d4a857775c42dc3875796434b13b78d6cfb174bfaa0c59976fb7a1cd4d26527881cfd39a61cd35843dd2cd49afd7d3966947b2662fc44dbff3704094687ce70ccabeb8a9d93f39974bd11fdb1dcb9404d8a6408cae45c315ced013f088c5264ce9c8738715ecf83bc991d4e3971e4a2cc39bcd11be426d793638981455d083cfd7bfd3b88ecd11e581260ae7fbf27b8c9cdf0da49a467e375f4273d6e01d7114ac7126f"};
        this.allowedPackages = new String[]{"com.kakao.talk", "com.kakao.onetalk", "com.kakao.talk.sandbox", "com.kakao.talk.alpha"};
    }

    private final PackageInfo packageInfo(PackageManager packageManager0, ResolveInfo resolveInfo0) {
        int v = Build.VERSION.SDK_INT;
        if(v >= 33) {
            PackageInfo packageInfo0 = e.a(packageManager0, resolveInfo0.activityInfo.applicationInfo.packageName, e.B());
            q.f(packageInfo0, "{\n            pm.getPack…)\n            )\n        }");
            return packageInfo0;
        }
        PackageInfo packageInfo1 = packageManager0.getPackageInfo(resolveInfo0.activityInfo.applicationInfo.packageName, (v < 28 ? 0x40 : 0x8000000));
        q.f(packageInfo1, "{\n            val flag =…kageName, flag)\n        }");
        return packageInfo1;
    }

    @Nullable
    public Intent resolveTalkIntent(@NotNull Context context0, @NotNull Intent intent0) {
        q.g(context0, "context");
        q.g(intent0, "intent");
        PackageManager packageManager0 = context0.getPackageManager();
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        String[] arr_s = this.allowedPackages;
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            Object object0 = intent0.clone();
            q.e(object0, "null cannot be cast to non-null type android.content.Intent");
            Intent intent1 = (Intent)object0;
            intent1.setPackage(s);
            ResolveInfo resolveInfo0 = Build.VERSION.SDK_INT < 33 ? packageManager0.resolveActivity(intent1, 0x10000) : a.e(packageManager0, intent1, a.d());
            if(resolveInfo0 != null) {
                q.f(packageManager0, "pm");
                if(this.validateTalkSignature(this.packageInfo(packageManager0, resolveInfo0))) {
                    arrayList0.add(intent1);
                    arrayList1.add(new LabeledIntent(intent0, resolveInfo0.activityInfo.applicationInfo.packageName, resolveInfo0.activityInfo.applicationInfo.labelRes, resolveInfo0.activityInfo.applicationInfo.icon));
                }
            }
        }
        switch(arrayList0.size()) {
            case 0: {
                return null;
            }
            case 1: {
                return (Intent)arrayList0.get(0);
            }
            default: {
                Intent intent2 = Intent.createChooser(((Intent)arrayList1.remove(0)), context0.getString(string.com_kakao_talk_chooser_text));
                if(arrayList1.size() > 0) {
                    intent2.putExtra("android.intent.extra.INITIAL_INTENTS", ((Parcelable[])arrayList1.toArray(new Parcelable[0])));
                }
                return intent2;
            }
        }
    }

    private final boolean validateTalkSignature(PackageInfo packageInfo0) {
        Signature[] arr_signature;
        if(Build.VERSION.SDK_INT >= 28) {
            SigningInfo signingInfo0 = packageInfo0.signingInfo;
            arr_signature = signingInfo0 == null ? null : signingInfo0.getApkContentsSigners();
        }
        else {
            arr_signature = packageInfo0.signatures;
        }
        if(arr_signature != null) {
            for(int v = 0; v < arr_signature.length; ++v) {
                String s = arr_signature[v].toCharsString();
                if(n.Q(this.allowedSignatures, s)) {
                    return true;
                }
            }
        }
        return false;
    }
}

