package com.iloen.melon.friend;

import A7.d;
import Ac.X3;
import X8.c;
import X8.e;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MyMusicFriendInsertInviteFriendReq;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import e1.u;
import k8.Y;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t9.F;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\b\u0007\u0018\u0000 \u000F2\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001A\u00020\u00062\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\u000B\u001A\u0004\u0018\u00010\t2\u0006\u0010\f\u001A\u00020\t¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/friend/FriendAddTaskController;", "", "<init>", "()V", "Lcom/iloen/melon/friend/FriendAddTaskController$AddFriendListener;", "listener", "Lie/H;", "setOnResultListener", "(Lcom/iloen/melon/friend/FriendAddTaskController$AddFriendListener;)V", "", "mkey", "fkey", "mode", "request", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "X8/c", "AddFriendListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FriendAddTaskController {
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/friend/FriendAddTaskController$AddFriendListener;", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface AddFriendListener {
        void a(String arg1);
    }

    public static final int $stable = 8;
    @NotNull
    public static final String ADDRESS = "P";
    @NotNull
    public static final c Companion = null;
    @NotNull
    public static final String FACEBOOK = "F";
    @NotNull
    public static final String KAKAOTALK = "K";
    @NotNull
    public static final String MELON = "M";
    public AddFriendListener a;
    public String b;
    public String c;
    public String d;
    public Job e;

    static {
        FriendAddTaskController.Companion = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public FriendAddTaskController() {
        MelonAppBase.Companion.getClass();
        t.a().getContext();
        this.b();
    }

    public final void a() {
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("FriendAddTaskController", "addFriend()");
        String s = u.v(((e0)o.a()).j());
        if("K".equalsIgnoreCase(this.d)) {
            if(F.a.B(SnsManager.SnsType.d).b()) {
                if(q.b(this.c, s)) {
                    ToastManager.show(0x7F1304C9);  // string:kakaotalk_errormsg_request_friend_myself "나를 친구로 추가할 수 없습니다."
                    this.b = null;
                    this.c = null;
                    this.d = null;
                    logU$Companion0.d("FriendAddTaskController", "unregisterLoginStatusFlow()");
                    Job job0 = this.e;
                    if(job0 == null) {
                        return;
                    }
                    DefaultImpls.cancel$default(job0, null, 1, null);
                    return;
                }
                this.c(this.c, null, "K");
                return;
            }
            ToastManager.show(0x7F13106E);  // string:toast_message_kakaotalk_need_install "카카오톡이 설치되어 있지 않습니다."
            this.b = null;
            this.c = null;
            this.d = null;
            logU$Companion0.d("FriendAddTaskController", "unregisterLoginStatusFlow()");
            Job job1 = this.e;
            if(job1 == null) {
                return;
            }
            DefaultImpls.cancel$default(job1, null, 1, null);
            return;
        }
        if("P".equalsIgnoreCase(this.d)) {
            if(q.b(this.b, s)) {
                ToastManager.show(0x7F1304C9);  // string:kakaotalk_errormsg_request_friend_myself "나를 친구로 추가할 수 없습니다."
                this.b = null;
                this.c = null;
                this.d = null;
                logU$Companion0.d("FriendAddTaskController", "unregisterLoginStatusFlow()");
                Job job2 = this.e;
                if(job2 != null) {
                    DefaultImpls.cancel$default(job2, null, 1, null);
                }
                return;
            }
            this.c(this.b, this.c, this.d);
            return;
        }
        this.c(this.b, this.c, this.d);
    }

    public static final void access$addFriend(FriendAddTaskController friendAddTaskController0) {
        friendAddTaskController0.a();
    }

    public static final String access$getMMode$p(FriendAddTaskController friendAddTaskController0) {
        return friendAddTaskController0.d;
    }

    public final void b() {
        LogU.Companion.d("FriendAddTaskController", "registerIsLoginFlow()");
        this.e = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new e(this, null), 3, null);
    }

    public final void c(String s, String s1, String s2) {
        RequestBuilder.newInstance(new MyMusicFriendInsertInviteFriendReq(Y.a(MelonAppBase.Companion), s, s1, s2)).tag("FriendAddTaskController").listener(new X3(this, 17)).request();
    }

    public final void request(@Nullable String s, @Nullable String s1, @NotNull String s2) {
        q.g(s2, "mode");
        StringBuilder stringBuilder0 = d.o("request : ", s, ", ", s1, ", ");
        stringBuilder0.append(s2);
        LogU.Companion.d("FriendAddTaskController", stringBuilder0.toString());
        this.b = s;
        this.c = s1;
        this.d = s2;
        boolean z = "F".equalsIgnoreCase(s2) ? F.a.B(SnsManager.SnsType.a).b() : ((e0)o.a()).m();
        LogU.Companion.d("FriendAddTaskController", "isMelonLogin(" + s2 + ")-" + z);
        if(z) {
            this.a();
            return;
        }
        this.b();
    }

    public final void setOnResultListener(@NotNull AddFriendListener friendAddTaskController$AddFriendListener0) {
        q.g(friendAddTaskController$AddFriendListener0, "listener");
        this.a = friendAddTaskController$AddFriendListener0;
    }
}

