package com.kakao.emoticon.util;

import H0.b;
import Tf.a;
import android.app.Application;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.text.TextUtils;
import b3.Z;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.db.model.EmoticonLog;
import com.kakao.emoticon.db.model.EmoticonLogDAO;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.net.EmoticonApiLauncher;
import com.kakao.emoticon.net.EmoticonApiService;
import com.kakao.emoticon.net.EmoticonApiServiceImpl;
import h7.u0;
import ie.H;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001F\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\t\b\u00C6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\u0003J\u0019\u0010\f\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\f\u0010\rJ+\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\n2\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0007\u00A2\u0006\u0004\b\u0007\u0010\u0012J+\u0010\u0013\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\n2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\n2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0002\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0003J\u000F\u0010\u0018\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0003J\u000F\u0010\u0019\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u0003J\r\u0010\u001A\u001A\u00020\u0006\u00A2\u0006\u0004\b\u001A\u0010\u0003J+\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u001C\u001A\u00020\u001B2\u0014\u0010\u001E\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001D\u00A2\u0006\u0004\b\u0007\u0010\u001FR\u0014\u0010!\u001A\u00020 8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010&\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010\'\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\'\u0010$R\u0014\u0010(\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b(\u0010$R\u0014\u0010)\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b)\u0010$R\u0014\u0010*\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b*\u0010$R\u0014\u0010+\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b+\u0010$R\u0014\u0010,\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b,\u0010$R\u0014\u0010-\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b-\u0010$R\u0014\u0010.\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b.\u0010$R\u0014\u0010/\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b/\u0010$R\u0014\u00100\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b0\u0010$R\u0014\u00101\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b1\u0010$R\u0014\u00102\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b2\u0010$R\u0014\u00103\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b3\u0010$R\u0014\u00104\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b4\u0010$R\u0014\u00105\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b5\u0010$R\u0014\u00106\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b6\u0010$R\u0014\u00107\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b7\u0010$R\u0014\u00108\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b8\u0010$R\u0014\u00109\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b9\u0010$R\u0014\u0010:\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b:\u0010$R\u0014\u0010;\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b;\u0010$R\u0014\u0010<\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b<\u0010$R\u0014\u0010=\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b=\u0010$R\u0014\u0010>\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b>\u0010$R\u0014\u0010?\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b?\u0010$R\u0014\u0010A\u001A\u00020@8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001A\u00020C8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001A\u00020F8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010I\u001A\u00020F8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bI\u0010HR\u0014\u0010J\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bJ\u0010$R\u0014\u0010K\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bK\u0010$R\u0014\u0010L\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bL\u0010$R\u0016\u0010N\u001A\u00020M8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010R\u001A\u00020\u00108BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bP\u0010QR\u0016\u0010U\u001A\u0004\u0018\u00010\n8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bS\u0010T\u00A8\u0006V"}, d2 = {"Lcom/kakao/emoticon/util/ActionTracker;", "", "<init>", "()V", "Lcom/kakao/emoticon/db/model/EmoticonLog;", "emoticonLog", "Lie/H;", "pushLog", "(Lcom/kakao/emoticon/db/model/EmoticonLog;)V", "saveSendTime", "", "str", "convertSHA256", "(Ljava/lang/String;)Ljava/lang/String;", "pid", "aid", "Lorg/json/JSONObject;", "value", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "convertLog", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/kakao/emoticon/db/model/EmoticonLog;", "makeLogJson", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;", "clearCount", "incrementContentCount", "incrementTabCount", "sendLog", "Lcom/kakao/emoticon/model/EmoticonViewParam;", "emoticonViewParam", "", "extraMeta", "(Lcom/kakao/emoticon/model/EmoticonViewParam;Ljava/util/Map;)V", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "P001", "Ljava/lang/String;", "P002", "P003", "A001", "A002", "A003", "A004", "A005", "A006", "A007", "A008", "A009", "A010", "A011", "A012", "A013", "A014", "A015", "A016", "str_date", "str_pid", "str_aid", "str_value", "str_header", "str_id", "str_os", "str_pName", "str_logs", "", "LOG_TIME_LIMIT", "J", "", "LOG_COUNT_LIMIT", "I", "Ljava/util/concurrent/atomic/AtomicInteger;", "tabCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "contentCount", "PREF_NAME", "PREF_ACTION_LATEST_TIME", "PREF_ACTION_UUID", "", "sendLock", "Z", "getHeader", "()Lorg/json/JSONObject;", "header", "getUuid", "()Ljava/lang/String;", "uuid", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class ActionTracker {
    @NotNull
    public static final String A001 = "01";
    @NotNull
    public static final String A002 = "02";
    @NotNull
    public static final String A003 = "03";
    @NotNull
    public static final String A004 = "04";
    @NotNull
    public static final String A005 = "05";
    @NotNull
    public static final String A006 = "06";
    @NotNull
    public static final String A007 = "07";
    @NotNull
    public static final String A008 = "08";
    @NotNull
    public static final String A009 = "09";
    @NotNull
    public static final String A010 = "10";
    @NotNull
    public static final String A011 = "11";
    @NotNull
    public static final String A012 = "12";
    @NotNull
    public static final String A013 = "13";
    @NotNull
    public static final String A014 = "14";
    @NotNull
    public static final String A015 = "15";
    @NotNull
    public static final String A016 = "16";
    public static final ActionTracker INSTANCE = null;
    private static final int LOG_COUNT_LIMIT = 2;
    private static final long LOG_TIME_LIMIT = 900000L;
    @NotNull
    public static final String P001 = "A001";
    @NotNull
    public static final String P002 = "A002";
    @NotNull
    public static final String P003 = "A003";
    private static final String PREF_ACTION_LATEST_TIME = "pref_action_latest_time";
    private static final String PREF_ACTION_UUID = "pref_action_uuid";
    private static final String PREF_NAME = "ActionTrackerPref";
    private static final AtomicInteger contentCount = null;
    private static volatile boolean sendLock = false;
    private static final SharedPreferences sharedPreferences = null;
    private static final String str_aid = "aid";
    private static final String str_date = "date";
    private static final String str_header = "header";
    private static final String str_id = "id";
    private static final String str_logs = "logs";
    private static final String str_os = "os";
    private static final String str_pName = "pname";
    private static final String str_pid = "pid";
    private static final String str_value = "value";
    private static final AtomicInteger tabCount;

    static {
        ActionTracker.INSTANCE = new ActionTracker();
        ActionTracker.tabCount = new AtomicInteger(0);
        ActionTracker.contentCount = new AtomicInteger(0);
        Application application0 = KakaoEmoticon.getApplication();
        q.d(application0);
        SharedPreferences sharedPreferences0 = application0.getSharedPreferences("ActionTrackerPref", 0);
        q.f(sharedPreferences0, "application!!.getSharedP…ME, Context.MODE_PRIVATE)");
        ActionTracker.sharedPreferences = sharedPreferences0;
    }

    public static final boolean access$getSendLock$p(ActionTracker actionTracker0) {
        return ActionTracker.sendLock;
    }

    public static final void access$setSendLock$p(ActionTracker actionTracker0, boolean z) {
        ActionTracker.sendLock = z;
    }

    private final void clearCount() {
        ActionTracker.contentCount.set(0);
        ActionTracker.tabCount.set(0);
    }

    private final EmoticonLog convertLog(String s, String s1, JSONObject jSONObject0) {
        try {
            if(q.b(s, "A001") && q.b(s1, "02")) {
                this.clearCount();
            }
            else if(q.b(s, "A001") && q.b(s1, "01")) {
                this.clearCount();
                JSONObject jSONObject1 = new JSONObject();
                jSONObject1.put("m", (ScreenUtils.INSTANCE.isLandscape() ? "l" : "p"));
                return new EmoticonLog(this.makeLogJson(s, s1, jSONObject1).toString());
            }
            return new EmoticonLog(this.makeLogJson(s, s1, jSONObject0).toString());
        }
        catch(Exception unused_ex) {
        }
        return null;
    }

    private final String convertSHA256(String s) {
        try {
            MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-256");
            Charset charset0 = a.a;
            if(s == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] arr_b = s.getBytes(charset0);
            q.f(arr_b, "(this as java.lang.String).getBytes(charset)");
            messageDigest0.update(arr_b);
            byte[] arr_b1 = messageDigest0.digest();
            StringBuilder stringBuilder0 = new StringBuilder();
            for(int v = 0; v < arr_b1.length; ++v) {
                int v1 = Util.and(arr_b1[v], ((byte)0xFF));
                u0.l(16);
                String s1 = Integer.toString(v1 + 0x100, 16);
                q.f(s1, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                String s2 = s1.substring(1);
                q.f(s2, "(this as java.lang.String).substring(startIndex)");
                stringBuilder0.append(s2);
            }
            return stringBuilder0.toString();
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
        }
        noSuchAlgorithmException0.printStackTrace();
        return null;
    }

    private final JSONObject getHeader() {
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("id", this.getUuid());
        jSONObject0.put("os", "aos");
        q.d(KakaoEmoticon.getApplication());
        jSONObject0.put("pname", "com.iloen.melon");
        return jSONObject0;
    }

    private final String getUuid() {
        SharedPreferences sharedPreferences0 = ActionTracker.sharedPreferences;
        String s = sharedPreferences0.getString("pref_action_uuid", "");
        if(TextUtils.isEmpty(s)) {
            s = this.convertSHA256("49059726-58b7-40b8-8537-faac9d4be9cc" + System.currentTimeMillis());
            SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
            sharedPreferences$Editor0.putString("pref_action_uuid", s);
            sharedPreferences$Editor0.apply();
        }
        return s;
    }

    public static final void incrementContentCount() {
        ActionTracker.contentCount.incrementAndGet();
    }

    public static final void incrementTabCount() {
        ActionTracker.tabCount.incrementAndGet();
    }

    private final JSONObject makeLogJson(String s, String s1, JSONObject jSONObject0) {
        JSONObject jSONObject1 = new JSONObject();
        jSONObject1.put("date", "1757129633487");
        jSONObject1.put("pid", s);
        jSONObject1.put("aid", s1);
        if(jSONObject0 != null) {
            jSONObject1.put("value", jSONObject0);
        }
        return jSONObject1;
    }

    private final void pushLog(EmoticonLog emoticonLog0) {
        if(emoticonLog0 != null) {
            stringBuilder0.toString();
            EmoticonLogDAO.instance().insertOrUpdate(emoticonLog0);
        }
        SharedPreferences sharedPreferences0 = ActionTracker.sharedPreferences;
        if(sharedPreferences0.getLong("pref_action_latest_time", -1L) == -1L) {
            this.saveSendTime();
            return;
        }
        if(System.currentTimeMillis() - sharedPreferences0.getLong("pref_action_latest_time", System.currentTimeMillis()) < 900000L) {
            EmoticonLogDAO emoticonLogDAO0 = EmoticonLogDAO.instance();
            q.f(emoticonLogDAO0, "EmoticonLogDAO.instance()");
            if(emoticonLogDAO0.getRowCount() < 2) {
                return;
            }
        }
        this.sendLog();
    }

    public static final void pushLog(@NotNull String s, @NotNull String s1, @Nullable JSONObject jSONObject0) {
        q.g(s, "pid");
        q.g(s1, "aid");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(s, s1, jSONObject0, null) {
            final String $aid;
            final String $pid;
            final JSONObject $value;
            int label;
            private CoroutineScope p$;

            {
                this.$pid = s;
                this.$aid = s1;
                this.$value = jSONObject0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.util.ActionTracker.pushLog.1(this.$pid, this.$aid, this.$value, continuation0);
                continuation1.p$ = (CoroutineScope)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.util.ActionTracker.pushLog.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                EmoticonLog emoticonLog0 = ActionTracker.INSTANCE.convertLog(this.$pid, this.$aid, this.$value);
                ActionTracker.INSTANCE.pushLog(emoticonLog0);
                return H.a;
            }
        }, 3, null);
    }

    public final void pushLog(@NotNull EmoticonViewParam emoticonViewParam0, @Nullable Map map0) {
        q.g(emoticonViewParam0, "emoticonViewParam");
        try {
            JSONObject jSONObject0 = new JSONObject();
            jSONObject0.put("id", String.format(Locale.US, "%s_%03d", Arrays.copyOf(new Object[]{emoticonViewParam0.getEmoticonId(), emoticonViewParam0.getResourceId()}, 2)));
            jSONObject0.put("t", ActionTracker.tabCount.get());
            jSONObject0.put("c", ActionTracker.contentCount.get());
            jSONObject0.put("m", (ScreenUtils.INSTANCE.isLandscape() ? "l" : "p"));
            if(map0 != null) {
                jSONObject0.put("ex", new JSONObject(map0));
            }
            ActionTracker.pushLog("A001", "02", jSONObject0);
        }
        catch(Exception unused_ex) {
        }
    }

    public static void pushLog$default(String s, String s1, JSONObject jSONObject0, int v, Object object0) {
        if((v & 4) != 0) {
            jSONObject0 = null;
        }
        ActionTracker.pushLog(s, s1, jSONObject0);
    }

    private final void saveSendTime() {
        SharedPreferences.Editor sharedPreferences$Editor0 = ActionTracker.sharedPreferences.edit();
        sharedPreferences$Editor0.putLong("pref_action_latest_time", System.currentTimeMillis());
        sharedPreferences$Editor0.apply();
    }

    public final void sendLog() {
        if(ActionTracker.sendLock) {
            return;
        }
        ActionTracker.sendLock = true;
        com.kakao.emoticon.util.ActionTracker.sendLog.1 actionTracker$sendLog$10 = new k() {
            Object L$0;
            int label;

            {
                super(1, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                return new com.kakao.emoticon.util.ActionTracker.sendLog.1(continuation0);
            }

            @Override  // we.k
            public final Object invoke(Object object0) {
                return ((com.kakao.emoticon.util.ActionTracker.sendLog.1)this.create(((Continuation)object0))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                kotlin.jvm.internal.H h1;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        kotlin.jvm.internal.H h0 = b.p(object0);
                        h0.a = null;
                        com.kakao.emoticon.util.ActionTracker.sendLog.1.1 actionTracker$sendLog$1$10 = new n(null) {
                            final kotlin.jvm.internal.H $emoticonLogList;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            int label;
                            private CoroutineScope p$;

                            {
                                this.$emoticonLogList = h0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            @NotNull
                            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                                q.g(continuation0, "completion");
                                Continuation continuation1 = new com.kakao.emoticon.util.ActionTracker.sendLog.1.1(this.$emoticonLogList, continuation0);
                                continuation1.p$ = (CoroutineScope)object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public final Object invoke(Object object0, Object object1) {
                                return ((com.kakao.emoticon.util.ActionTracker.sendLog.1.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        CoroutineScope coroutineScope0 = this.p$;
                                        JSONObject jSONObject0 = new JSONObject();
                                        JSONArray jSONArray0 = new JSONArray();
                                        jSONObject0.put("header", ActionTracker.INSTANCE.getHeader());
                                        EmoticonLogDAO emoticonLogDAO0 = EmoticonLogDAO.instance();
                                        q.f(emoticonLogDAO0, "EmoticonLogDAO.instance()");
                                        this.$emoticonLogList.a = emoticonLogDAO0.getAll();
                                        List list0 = (List)this.$emoticonLogList.a;
                                        if(list0 != null && !list0.isEmpty() == 1) {
                                            List list1 = (List)this.$emoticonLogList.a;
                                            if(list1 != null) {
                                                for(Object object1: list1) {
                                                    jSONArray0.put(new JSONObject(((EmoticonLog)object1).getLog()));
                                                }
                                            }
                                            jSONObject0.put("logs", jSONArray0);
                                            EmoticonApiService emoticonApiService0 = EmoticonApiServiceImpl.INSTANCE.getApiClass();
                                            String s = jSONObject0.toString();
                                            q.f(s, "logObject.toString()");
                                            this.L$0 = coroutineScope0;
                                            this.L$1 = jSONObject0;
                                            this.L$2 = jSONArray0;
                                            this.label = 1;
                                            if(emoticonApiService0.sendEmoticonLog(s, this) == a0) {
                                                return a0;
                                            }
                                        }
                                        return H.a;
                                    }
                                    case 1: {
                                        JSONArray jSONArray1 = (JSONArray)this.L$2;
                                        JSONObject jSONObject1 = (JSONObject)this.L$1;
                                        CoroutineScope coroutineScope1 = (CoroutineScope)this.L$0;
                                        d5.n.D(object0);
                                        return H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        this.L$0 = h0;
                        this.label = 1;
                        if(BuildersKt.withContext(Dispatchers.getIO(), actionTracker$sendLog$1$10, this) == a0) {
                            return a0;
                        }
                        h1 = h0;
                        break;
                    }
                    case 1: {
                        h1 = (kotlin.jvm.internal.H)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                List list0 = (List)h1.a;
                q.d(list0);
                return list0;
            }
        };
        com.kakao.emoticon.util.ActionTracker.sendLog.2 actionTracker$sendLog$20 = new n() {
            int label;
            private List p$0;

            {
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.util.ActionTracker.sendLog.2(continuation0);
                continuation1.p$0 = (List)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.util.ActionTracker.sendLog.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                List list0 = this.p$0;
                EmoticonLogDAO.instance().removeRange(((EmoticonLog)list0.get(0)).getId(), ((EmoticonLog)Z.h(1, list0)).getId());
                ActionTracker.INSTANCE.saveSendTime();
                return H.a;
            }
        };
        com.kakao.emoticon.util.ActionTracker.sendLog.3 actionTracker$sendLog$30 = new k() {
            int label;

            {
                super(1, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                return new com.kakao.emoticon.util.ActionTracker.sendLog.3(continuation0);
            }

            @Override  // we.k
            public final Object invoke(Object object0) {
                return ((com.kakao.emoticon.util.ActionTracker.sendLog.3)this.create(((Continuation)object0))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                ActionTracker.access$setSendLock$p(ActionTracker.INSTANCE, false);
                return H.a;
            }
        };
        EmoticonApiLauncher.launchMain$default(EmoticonApiLauncher.INSTANCE, actionTracker$sendLog$10, actionTracker$sendLog$20, null, actionTracker$sendLog$30, 4, null);
    }
}

