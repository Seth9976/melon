package com.iloen.melon.push.fcm;

import A6.e;
import Tf.v;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Build;
import com.google.firebase.messaging.FirebaseMessaging;
import com.iloen.melon.push.PushAlertReceiver;
import com.iloen.melon.push.dto.DvcTokenDTO;
import com.iloen.melon.push.dto.RegDTO;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import d5.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u001D\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u000F¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/push/fcm/FcmHelper;", "", "Landroid/content/Context;", "context", "", "registrationId", "Lie/H;", "sendRegistrationToServer", "(Landroid/content/Context;Ljava/lang/String;)V", "Lcom/iloen/melon/push/dto/RegDTO;", "regDTO", "", "callFrom", "reqRegister", "(Landroid/content/Context;Lcom/iloen/melon/push/dto/RegDTO;I)V", "", "result", "setRegRslt", "(Landroid/content/Context;Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FcmHelper {
    public static final int $stable;
    @NotNull
    public static final FcmHelper INSTANCE;

    static {
        FcmHelper.INSTANCE = new FcmHelper();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final void reqRegister(@NotNull Context context0, @NotNull RegDTO regDTO0, int v) {
        q.g(context0, "context");
        q.g(regDTO0, "regDTO");
        try {
            boolean z = context0.getSharedPreferences("pushinfo", 0).getBoolean("REG_YN", false);
            String s = context0.getSharedPreferences("pushinfo", 0).getString("MEMBER_ID", null);
            String s1 = context0.getSharedPreferences("pushinfo", 0).getString("APP_VER", "");
            String s2 = context0.getSharedPreferences("pushinfo", 0).getString("DEVICE_OS_VER", "");
            String s3 = context0.getSharedPreferences("pushinfo", 0).getString("NOTIFY_YN", "");
            String s4 = context0.getSharedPreferences("pushinfo", 0).getString("MKT_RECV_AGREE_YN", "");
            String s5 = context0.getSharedPreferences("pushinfo", 0).getString("MANNER_YN", "");
            String s6 = context0.getSharedPreferences("pushinfo", 0).getString("MANNER_START", "");
            String s7 = context0.getSharedPreferences("pushinfo", 0).getString("MANNER_END", "");
            Companion logU$Companion0 = LogU.Companion;
            logU$Companion0.i("FcmHelper", "reqRegister() regYN:" + z);
            n.C(context0, z);
            if(!q.b("", s)) {
                logU$Companion0.w("FcmHelper", "reqRegister() memberId:" + s);
                n.C(context0, false);
                SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("pushinfo", 0).edit();
                sharedPreferences$Editor0.putString("MEMBER_ID", "");
                sharedPreferences$Editor0.apply();
            }
            if(!q.b("", s1)) {
                logU$Companion0.w("FcmHelper", "reqRegister() appVer:" + s1);
                n.C(context0, false);
                SharedPreferences.Editor sharedPreferences$Editor1 = context0.getSharedPreferences("pushinfo", 0).edit();
                sharedPreferences$Editor1.putString("APP_VER", "");
                sharedPreferences$Editor1.apply();
            }
            String s8 = Build.VERSION.RELEASE;
            if(!q.b(s8, s2)) {
                logU$Companion0.w("FcmHelper", "reqRegister() osVer:" + s2);
                n.C(context0, false);
                SharedPreferences.Editor sharedPreferences$Editor2 = context0.getSharedPreferences("pushinfo", 0).edit();
                sharedPreferences$Editor2.putString("DEVICE_OS_VER", s8);
                sharedPreferences$Editor2.apply();
            }
            if(!v.j0("", s3, true)) {
                logU$Companion0.w("FcmHelper", "reqRegister() notifyYN:" + s3);
                n.C(context0, false);
                SharedPreferences.Editor sharedPreferences$Editor3 = context0.getSharedPreferences("pushinfo", 0).edit();
                sharedPreferences$Editor3.putString("NOTIFY_YN", "");
                sharedPreferences$Editor3.apply();
            }
            if(!v.j0("", s4, true)) {
                logU$Companion0.w("FcmHelper", "reqRegister() mktRecvAgreeYn:" + s4);
                n.C(context0, false);
                SharedPreferences.Editor sharedPreferences$Editor4 = context0.getSharedPreferences("pushinfo", 0).edit();
                sharedPreferences$Editor4.putString("MKT_RECV_AGREE_YN", "");
                sharedPreferences$Editor4.apply();
            }
            if(!q.b("", s5) || !q.b("", s6) || !q.b("", s7)) {
                logU$Companion0.w("FcmHelper", "reqRegister() mannerYN:" + s5);
                logU$Companion0.w("FcmHelper", "reqRegister() mannerStart:" + s6);
                logU$Companion0.w("FcmHelper", "reqRegister() mannerEnd:" + s7);
                n.C(context0, false);
                SharedPreferences.Editor sharedPreferences$Editor5 = context0.getSharedPreferences("pushinfo", 0).edit();
                sharedPreferences$Editor5.putString("MANNER_YN", "");
                sharedPreferences$Editor5.apply();
                SharedPreferences.Editor sharedPreferences$Editor6 = context0.getSharedPreferences("pushinfo", 0).edit();
                sharedPreferences$Editor6.putString("MANNER_START", "");
                sharedPreferences$Editor6.apply();
                SharedPreferences.Editor sharedPreferences$Editor7 = context0.getSharedPreferences("pushinfo", 0).edit();
                sharedPreferences$Editor7.putString("MANNER_END", "");
                sharedPreferences$Editor7.apply();
            }
            logU$Companion0.w("FcmHelper", "reqRegister() pushType: ");
            SharedPreferences.Editor sharedPreferences$Editor8 = context0.getSharedPreferences("pushinfo", 0).edit();
            sharedPreferences$Editor8.putString("PUSH_TYPE_NM", "");
            sharedPreferences$Editor8.apply();
            logU$Companion0.w("FcmHelper", "reqRegister() callFrom: " + v);
            SharedPreferences.Editor sharedPreferences$Editor9 = context0.getSharedPreferences("pushinfo", 0).edit();
            sharedPreferences$Editor9.putInt("CALL_FROM", v);
            sharedPreferences$Editor9.apply();
            q.d(FirebaseMessaging.c().e().addOnCompleteListener(new e(context0, v, 6)));
        }
        catch(Exception unused_ex) {
            LogU.Companion.e("FcmHelper", "reqRegister() reqRegister Exception");
        }
        catch(Error unused_ex) {
            LogU.Companion.e("FcmHelper", "reqRegister() reqRegister error");
        }
    }

    public static final void sendRegistrationToServer(@NotNull Context context0, @Nullable String s) {
        q.g(context0, "context");
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("FcmHelper", "sendRegistrationToServer() entered in");
        if(!MelonPrefs.getInstance().getBoolean("MarketingAcceptShown", false)) {
            return;
        }
        String s1 = "";
        String s2 = context0.getSharedPreferences("pushinfo", 0).getString("DEVICE_TOKEN", "");
        boolean z = context0.getSharedPreferences("pushinfo", 0).getBoolean("REG_ON_SERVER", false);
        if(z && System.currentTimeMillis() > context0.getSharedPreferences("pushinfo", 0).getLong("SEVER_EXPIRE_TIME", -1L)) {
            z = false;
        }
        if(!q.b(s, s2)) {
            a.v("sendRegistrationToServer() deviceToken: ", s2, logU$Companion0, "FcmHelper");
            SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("pushinfo", 0).edit();
            sharedPreferences$Editor0.putBoolean("REG_ON_SERVER", false);
            sharedPreferences$Editor0.putLong("SEVER_EXPIRE_TIME", System.currentTimeMillis() + 604800000L);
            sharedPreferences$Editor0.apply();
            SharedPreferences.Editor sharedPreferences$Editor1 = context0.getSharedPreferences("pushinfo", 0).edit();
            sharedPreferences$Editor1.putString("DEVICE_TOKEN", s);
            sharedPreferences$Editor1.apply();
        }
        if(!z) {
            logU$Companion0.i("FcmHelper", "sendRegistrationToServer() registeredOnServer:" + false);
            Intent intent0 = new Intent(context0, PushAlertReceiver.class);
            intent0.setAction("com.iloen.android.push.intent.REGISTRATION");
            intent0.addCategory("com.iloen.melon");
            DvcTokenDTO dvcTokenDTO0 = new DvcTokenDTO(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0x3FFF, null);
            SharedPreferences sharedPreferences0 = context0.getSharedPreferences("pushinfo", 0);
            String s3 = sharedPreferences0.getString("DEVICE_TOKEN", "");
            if(s3 == null) {
                s3 = "";
            }
            dvcTokenDTO0.setDeviceToken(s3);
            String s4 = sharedPreferences0.getString("MEMBER_ID", "");
            if(s4 == null) {
                s4 = "";
            }
            dvcTokenDTO0.setMemberId(s4);
            String s5 = sharedPreferences0.getString("APP_VER", "");
            if(s5 == null) {
                s5 = "";
            }
            dvcTokenDTO0.setAppVer(s5);
            String s6 = sharedPreferences0.getString("DEVICE_OS_VER", "");
            if(s6 == null) {
                s6 = "";
            }
            dvcTokenDTO0.setDeviceOsVer(s6);
            String s7 = sharedPreferences0.getString("NOTIFY_YN", "");
            if(s7 == null) {
                s7 = "";
            }
            dvcTokenDTO0.setNotifyYN(s7);
            String s8 = sharedPreferences0.getString("MANNER_YN", "");
            if(s8 == null) {
                s8 = "";
            }
            dvcTokenDTO0.setMannerYN(s8);
            String s9 = sharedPreferences0.getString("MANNER_START", "");
            if(s9 == null) {
                s9 = "";
            }
            dvcTokenDTO0.setMannerStart(s9);
            String s10 = sharedPreferences0.getString("MANNER_END", "");
            if(s10 == null) {
                s10 = "";
            }
            dvcTokenDTO0.setMannerEnd(s10);
            dvcTokenDTO0.setCallFrom(sharedPreferences0.getInt("CALL_FROM", -1));
            String s11 = sharedPreferences0.getString("MKT_RECV_AGREE_YN", "");
            if(s11 == null) {
                s11 = "";
            }
            dvcTokenDTO0.setMktRecvAgreeYn(s11);
            String s12 = sharedPreferences0.getString("PUSH_TYPE_NM", "");
            if(s12 != null) {
                s1 = s12;
            }
            dvcTokenDTO0.setPushType(s1);
            String s13 = Build.MODEL;
            q.f(s13, "MODEL");
            dvcTokenDTO0.setDeviceModelName(s13);
            intent0.putExtra("sendTypeCode", "P20002");
            intent0.putExtra("appTypeCode", "P10002");
            intent0.putExtra("deviceToken", "");
            intent0.putExtra("memberKey", "");
            intent0.putExtra("appVer", "");
            intent0.putExtra("deviceOsVer", "");
            intent0.putExtra("deviceModelName", s13);
            intent0.putExtra("pushNotifyYn", "");
            intent0.putExtra("mannerModeYn", "");
            intent0.putExtra("mannerModeStartTime", "");
            intent0.putExtra("mannerModeEndTime", "");
            intent0.putExtra("callFrom", dvcTokenDTO0.getCallFrom());
            intent0.putExtra("mktRecvAgreeYn", "");
            intent0.putExtra("pushType", "");
            context0.sendBroadcast(intent0);
            return;
        }
        logU$Companion0.i("FcmHelper", "sendRegistrationToServer() FcmRegistrar.isRegisteredOnServer is true!");
    }

    public final void setRegRslt(@NotNull Context context0, boolean z) {
        q.g(context0, "context");
        try {
            SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("pushinfo", 0).edit();
            sharedPreferences$Editor0.putBoolean("REG_ON_SERVER", z);
            sharedPreferences$Editor0.putLong("SEVER_EXPIRE_TIME", System.currentTimeMillis() + 604800000L);
            sharedPreferences$Editor0.apply();
            SharedPreferences.Editor sharedPreferences$Editor1 = context0.getSharedPreferences("pushinfo", 0).edit();
            sharedPreferences$Editor1.putBoolean("REG_YN", z);
            sharedPreferences$Editor1.apply();
        }
        catch(Exception | Error unused_ex) {
        }
    }
}

