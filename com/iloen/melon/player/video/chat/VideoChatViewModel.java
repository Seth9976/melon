package com.iloen.melon.player.video.chat;

import Cb.h;
import De.I;
import I9.a;
import J9.c;
import J9.e;
import Tf.o;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.K;
import androidx.lifecycle.L;
import androidx.lifecycle.f0;
import androidx.lifecycle.m0;
import com.iloen.melon.custom.e1;
import com.iloen.melon.fragments.mymusic.dna.d;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response.CHATSDKINFO.Message.WELCOME;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response.CHATSDKINFO.Message;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response.CHATSDKINFO.USER;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response.CHATSDKINFO;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response;
import com.iloen.melon.net.v6x.response.LiveChatRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.kakaoent.leonchat.data.messages.ArtistMessageEntity;
import com.kakaoent.leonchat.data.messages.BlockUserMessageEntity;
import com.kakaoent.leonchat.data.messages.FreezeChatMessageEntity;
import com.kakaoent.leonchat.data.messages.InitMessageEntity;
import com.kakaoent.leonchat.data.messages.LeonUserInfo;
import com.kakaoent.leonchat.data.messages.MessageEntity;
import com.kakaoent.leonchat.data.messages.MessageFactory;
import com.kakaoent.leonchat.data.messages.NoticeMessageEntity;
import com.kakaoent.leonchat.data.messages.UserJoinAndLeftRoomMessageEntity;
import com.kakaoent.leonchat.data.messages.UserMessageEntity;
import d3.g;
import e0.b;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.m;
import ie.r;
import java.util.ArrayList;
import java.util.Map;
import je.D;
import je.p;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.WebSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0005H\u0086@\u00A2\u0006\u0004\b\b\u0010\tJ\r\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0014J\r\u0010\u0017\u001A\u00020\n\u00A2\u0006\u0004\b\u0017\u0010\fJ\r\u0010\u0018\u001A\u00020\n\u00A2\u0006\u0004\b\u0018\u0010\fJ\r\u0010\u0019\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0019\u0010\u0004J\r\u0010\u001A\u001A\u00020\u0007\u00A2\u0006\u0004\b\u001A\u0010\u0004J\r\u0010\u001B\u001A\u00020\u0007\u00A2\u0006\u0004\b\u001B\u0010\u0004J\u0015\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\n\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0015\u0010\u001F\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\n\u00A2\u0006\u0004\b\u001F\u0010\u001ER2\u0010(\u001A\u0012\u0012\u0004\u0012\u00020\u00110 j\b\u0012\u0004\u0012\u00020\u0011`!8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R\"\u0010/\u001A\u00020\u00058\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b)\u0010*\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001D\u00106\u001A\b\u0012\u0004\u0012\u000201008\u0006\u00A2\u0006\f\n\u0004\b2\u00103\u001A\u0004\b4\u00105R\u001D\u00109\u001A\b\u0012\u0004\u0012\u00020\n008\u0006\u00A2\u0006\f\n\u0004\b7\u00103\u001A\u0004\b8\u00105R\u001D\u0010<\u001A\b\u0012\u0004\u0012\u00020\n008\u0006\u00A2\u0006\f\n\u0004\b:\u00103\u001A\u0004\b;\u00105R\u001D\u0010?\u001A\b\u0012\u0004\u0012\u00020\u0005008\u0006\u00A2\u0006\f\n\u0004\b=\u00103\u001A\u0004\b>\u00105R\u001D\u0010C\u001A\b\u0012\u0004\u0012\u00020@008\u0006\u00A2\u0006\f\n\u0004\bA\u00103\u001A\u0004\bB\u00105R\'\u0010G\u001A\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110 j\b\u0012\u0004\u0012\u00020\u0011`!0D8F\u00A2\u0006\u0006\u001A\u0004\bE\u0010FR\u0017\u0010I\u001A\b\u0012\u0004\u0012\u00020\u00070D8F\u00A2\u0006\u0006\u001A\u0004\bH\u0010FR\u0019\u0010L\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010J0D8F\u00A2\u0006\u0006\u001A\u0004\bK\u0010F\u00A8\u0006N"}, d2 = {"Lcom/iloen/melon/player/video/chat/VideoChatViewModel;", "Landroidx/lifecycle/m0;", "LI9/a;", "<init>", "()V", "", "liveSeq", "Lie/H;", "joinChatRoom", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isConnected", "()Z", "LJ9/d;", "event", "onChangeState", "(LJ9/d;)V", "Lcom/kakaoent/leonchat/data/messages/MessageEntity;", "messageItem", "onMessage", "(Lcom/kakaoent/leonchat/data/messages/MessageEntity;)V", "message", "onCommandMessage", "isEnableSendMessage", "hasMessage", "sendMessage", "clearMessage", "disconnect", "immediately", "clearMessageList", "(Z)V", "clearNewMessageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getMessageList", "()Ljava/util/ArrayList;", "setMessageList", "(Ljava/util/ArrayList;)V", "messageList", "g", "Ljava/lang/String;", "getInputMessage", "()Ljava/lang/String;", "setInputMessage", "(Ljava/lang/String;)V", "inputMessage", "Lkotlinx/coroutines/flow/StateFlow;", "LJ9/e;", "i", "Lkotlinx/coroutines/flow/StateFlow;", "getFreezeType", "()Lkotlinx/coroutines/flow/StateFlow;", "freezeType", "k", "getUseChatSdkInfo", "useChatSdkInfo", "m", "getUserBan", "userBan", "o", "getChatState", "chatState", "Lcom/iloen/melon/player/video/chat/ChatUi;", "p", "getUpdateChatOrErrorFlow", "updateChatOrErrorFlow", "Landroidx/lifecycle/K;", "getNewMessageList", "()Landroidx/lifecycle/K;", "newMessageList", "getEventClear", "eventClear", "Lcom/iloen/melon/net/v6x/response/LiveChatRes$Response;", "getResponse", "response", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoChatViewModel extends m0 implements a {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/player/video/chat/VideoChatViewModel$Companion;", "", "", "TAG", "Ljava/lang/String;", "MELON_USER", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[b.c(3).length];
            try {
                arr_v[1] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[2] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[0] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String MELON_USER = "melonUser";
    @NotNull
    public static final String TAG = "VideoChatViewModel";
    public final L a;
    public ArrayList b;
    public final e1 c;
    public final L d;
    public final MutableStateFlow e;
    public final r f;
    public String g;
    public final MutableStateFlow h;
    public final MutableStateFlow i;
    public final MutableStateFlow j;
    public final MutableStateFlow k;
    public final MutableStateFlow l;
    public final MutableStateFlow m;
    public final MutableStateFlow n;
    public final MutableStateFlow o;
    public final StateFlow p;

    static {
        VideoChatViewModel.Companion = new Companion(null);
        VideoChatViewModel.$stable = 8;
    }

    public VideoChatViewModel() {
        boolean z;
        this.a = new L(new ArrayList());  // 初始化器: Landroidx/lifecycle/K;-><init>(Ljava/lang/Object;)V
        this.b = new ArrayList();
        this.c = new e1();
        L l0 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.d = l0;
        Response liveChatRes$Response0 = (Response)l0.getValue();
        if(liveChatRes$Response0 == null) {
            z = false;
        }
        else {
            CHATSDKINFO liveChatRes$Response$CHATSDKINFO0 = liveChatRes$Response0.chatSdkInfo;
            if(liveChatRes$Response$CHATSDKINFO0 == null) {
                z = false;
            }
            else {
                Boolean boolean0 = liveChatRes$Response$CHATSDKINFO0.isChatAuthority;
                z = boolean0 == null ? false : boolean0.booleanValue();
            }
        }
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(Boolean.valueOf(z));
        this.e = mutableStateFlow0;
        this.f = g.Q(new d(this));
        this.g = "";
        MutableStateFlow mutableStateFlow1 = StateFlowKt.MutableStateFlow(e.b);
        this.h = mutableStateFlow1;
        this.i = mutableStateFlow1;
        MutableStateFlow mutableStateFlow2 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.j = mutableStateFlow2;
        this.k = mutableStateFlow2;
        MutableStateFlow mutableStateFlow3 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.l = mutableStateFlow3;
        this.m = mutableStateFlow3;
        MutableStateFlow mutableStateFlow4 = StateFlowKt.MutableStateFlow("CLOSED");
        this.n = mutableStateFlow4;
        this.o = mutableStateFlow4;
        this.p = h.e(mutableStateFlow2, mutableStateFlow0, mutableStateFlow4, mutableStateFlow3, mutableStateFlow1, f0.h(this), new com.iloen.melon.player.video.b(3));
    }

    public static final void access$connect(VideoChatViewModel videoChatViewModel0) {
        String s2;
        videoChatViewModel0.getClass();
        Log.d("VideoChatViewModel", "connect()");
        Response liveChatRes$Response0 = (Response)videoChatViewModel0.d.getValue();
        if(liveChatRes$Response0 != null) {
            CHATSDKINFO liveChatRes$Response$CHATSDKINFO0 = liveChatRes$Response0.chatSdkInfo;
            if(liveChatRes$Response$CHATSDKINFO0 != null) {
                int v = liveChatRes$Response$CHATSDKINFO0.user.isArtist ? 2 : 1;
                Map map0 = D.O(new m("melonUser", liveChatRes$Response$CHATSDKINFO0.user));
                String s = liveChatRes$Response$CHATSDKINFO0.user.id;
                q.f(s, "id");
                String s1 = liveChatRes$Response$CHATSDKINFO0.user.name;
                q.f(s1, "name");
                switch(v) {
                    case 1: {
                        s2 = "MELON_NORMAL";
                        break;
                    }
                    case 2: {
                        s2 = "MELON_ARTIST";
                        break;
                    }
                    default: {
                        throw null;
                    }
                }
                LeonUserInfo leonUserInfo0 = new LeonUserInfo(s, s1, s2, map0);
                String s3 = liveChatRes$Response$CHATSDKINFO0.authToken;
                q.f(s3, "authToken");
                String s4 = liveChatRes$Response$CHATSDKINFO0.chat.id;
                q.f(s4, "id");
                J9.g g0 = new J9.g(s3, s4);
                I9.g g1 = (I9.g)videoChatViewModel0.f.getValue();
                g1.getClass();
                g1.e = g0;
                g1.f = leonUserInfo0;
                g1.g = s4;
                g1.j = videoChatViewModel0;
                g1.p = new Handler(Looper.getMainLooper());
                g1.e();
            }
        }
    }

    public static final Deferred access$requestRoomInfoAsync(VideoChatViewModel videoChatViewModel0, CoroutineScope coroutineScope0, String s) {
        videoChatViewModel0.getClass();
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new VideoChatViewModel.requestRoomInfoAsync.1(s, null), 3, null);
    }

    public final NoticeMessageEntity b(boolean z) {
        Response liveChatRes$Response0 = (Response)this.getResponse().getValue();
        if(liveChatRes$Response0 != null) {
            CHATSDKINFO liveChatRes$Response$CHATSDKINFO0 = liveChatRes$Response0.chatSdkInfo;
            if(liveChatRes$Response$CHATSDKINFO0 != null) {
                String s = z ? liveChatRes$Response$CHATSDKINFO0.message.banOn : liveChatRes$Response$CHATSDKINFO0.message.banOff;
                q.d(s);
                return new NoticeMessageEntity(s);
            }
        }
        return null;
    }

    public final NoticeMessageEntity c() {
        Response liveChatRes$Response0 = (Response)this.getResponse().getValue();
        if(liveChatRes$Response0 != null) {
            CHATSDKINFO liveChatRes$Response$CHATSDKINFO0 = liveChatRes$Response0.chatSdkInfo;
            if(liveChatRes$Response$CHATSDKINFO0 != null) {
                Message liveChatRes$Response$CHATSDKINFO$Message0 = liveChatRes$Response$CHATSDKINFO0.message;
                if(liveChatRes$Response$CHATSDKINFO$Message0 != null) {
                    return liveChatRes$Response$CHATSDKINFO$Message0.forbiddenWord == null ? new NoticeMessageEntity("") : new NoticeMessageEntity(liveChatRes$Response$CHATSDKINFO$Message0.forbiddenWord);
                }
                return new NoticeMessageEntity("");
            }
        }
        return null;
    }

    public final void clearMessage() {
        this.g = "";
    }

    public final void clearMessageList(boolean z) {
        this.clearNewMessageList(z);
        this.b = new ArrayList();
        e1 e10 = this.c;
        if(z) {
            e10.setValue(null);
            return;
        }
        e10.postValue(H.a);
    }

    public final void clearNewMessageList(boolean z) {
        L l0 = this.a;
        if(z) {
            l0.setValue(new ArrayList());
            return;
        }
        l0.postValue(new ArrayList());
    }

    public final void disconnect() {
        Log.i("VideoChatViewModel", "disconnect()");
        ((I9.g)this.f.getValue()).b(1000);
    }

    @NotNull
    public final StateFlow getChatState() {
        return this.o;
    }

    @NotNull
    public final K getEventClear() {
        return this.c;
    }

    @NotNull
    public final StateFlow getFreezeType() {
        return this.i;
    }

    @NotNull
    public final String getInputMessage() {
        return this.g;
    }

    @NotNull
    public final ArrayList getMessageList() {
        return this.b;
    }

    @NotNull
    public final K getNewMessageList() {
        return this.a;
    }

    @NotNull
    public final K getResponse() {
        return this.d;
    }

    @NotNull
    public final StateFlow getUpdateChatOrErrorFlow() {
        return this.p;
    }

    @NotNull
    public final StateFlow getUseChatSdkInfo() {
        return this.k;
    }

    @NotNull
    public final StateFlow getUserBan() {
        return this.m;
    }

    public final boolean hasMessage() {
        return this.g.length() == 0 ? 0 : 1;
    }

    public final boolean isConnected() {
        return q.b(this.n.getValue(), "OPENED");
    }

    public final boolean isEnableSendMessage() {
        if(!((Boolean)this.l.getValue()).booleanValue() && ((Boolean)this.j.getValue()).booleanValue() && this.h.getValue() == e.b) {
            Response liveChatRes$Response0 = (Response)this.getResponse().getValue();
            if(liveChatRes$Response0 != null) {
                CHATSDKINFO liveChatRes$Response$CHATSDKINFO0 = liveChatRes$Response0.chatSdkInfo;
                if(liveChatRes$Response$CHATSDKINFO0 != null) {
                    return liveChatRes$Response$CHATSDKINFO0.isChatAuthority == null ? false : liveChatRes$Response$CHATSDKINFO0.isChatAuthority.booleanValue();
                }
            }
            return false;
        }
        return false;
    }

    @Nullable
    public final Object joinChatRoom(@NotNull String s, @NotNull Continuation continuation0) {
        LogU.Companion.i("VideoChatViewModel", "joinChatRoom()");
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(s, null) {
            public final VideoChatViewModel B;
            public final String D;
            public int r;
            public Object w;

            {
                this.B = videoChatViewModel0;
                this.D = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.video.chat.VideoChatViewModel.joinChatRoom.2(this.B, this.D, continuation0);
                continuation1.w = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.chat.VideoChatViewModel.joinChatRoom.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                boolean z3;
                boolean z2;
                boolean z1;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                ne.a a0 = ne.a.a;
                Response liveChatRes$Response0 = null;
                VideoChatViewModel videoChatViewModel0 = this.B;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        Deferred deferred0 = VideoChatViewModel.access$requestRoomInfoAsync(videoChatViewModel0, coroutineScope0, this.D);
                        this.w = null;
                        this.r = 1;
                        object0 = deferred0.await(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                HttpResponse httpResponse0 = ((u8.d)object0).b;
                LogU.Companion.d("VideoChatViewModel", "joinChatRoom() response - " + ((u8.d)object0) + " \n " + (((LiveChatRes)httpResponse0) == null ? null : ((LiveChatRes)httpResponse0).response));
                if(((u8.d)object0).a == u8.e.a) {
                    L l0 = videoChatViewModel0.d;
                    if(((LiveChatRes)httpResponse0) != null) {
                        liveChatRes$Response0 = ((LiveChatRes)httpResponse0).response;
                    }
                    l0.setValue(liveChatRes$Response0);
                    MutableStateFlow mutableStateFlow0 = videoChatViewModel0.e;
                    boolean z = false;
                    if(((LiveChatRes)httpResponse0) == null) {
                        z1 = false;
                    }
                    else {
                        Response liveChatRes$Response1 = ((LiveChatRes)httpResponse0).response;
                        if(liveChatRes$Response1 == null) {
                            z1 = false;
                        }
                        else {
                            CHATSDKINFO liveChatRes$Response$CHATSDKINFO0 = liveChatRes$Response1.chatSdkInfo;
                            if(liveChatRes$Response$CHATSDKINFO0 == null) {
                                z1 = false;
                            }
                            else {
                                Boolean boolean0 = liveChatRes$Response$CHATSDKINFO0.isChatAuthority;
                                z1 = boolean0 == null ? false : boolean0.booleanValue();
                            }
                        }
                    }
                    mutableStateFlow0.setValue(Boolean.valueOf(z1));
                    MutableStateFlow mutableStateFlow1 = videoChatViewModel0.l;
                    if(((LiveChatRes)httpResponse0) == null) {
                        z2 = false;
                    }
                    else {
                        Response liveChatRes$Response2 = ((LiveChatRes)httpResponse0).response;
                        if(liveChatRes$Response2 == null) {
                            z2 = false;
                        }
                        else {
                            CHATSDKINFO liveChatRes$Response$CHATSDKINFO1 = liveChatRes$Response2.chatSdkInfo;
                            if(liveChatRes$Response$CHATSDKINFO1 == null) {
                                z2 = false;
                            }
                            else {
                                Boolean boolean1 = liveChatRes$Response$CHATSDKINFO1.isBan;
                                z2 = boolean1 == null ? false : boolean1.booleanValue();
                            }
                        }
                    }
                    mutableStateFlow1.setValue(Boolean.valueOf(z2));
                    MutableStateFlow mutableStateFlow2 = videoChatViewModel0.h;
                    if(((LiveChatRes)httpResponse0) == null) {
                        z3 = false;
                    }
                    else {
                        Response liveChatRes$Response3 = ((LiveChatRes)httpResponse0).response;
                        if(liveChatRes$Response3 == null) {
                            z3 = false;
                        }
                        else {
                            CHATSDKINFO liveChatRes$Response$CHATSDKINFO2 = liveChatRes$Response3.chatSdkInfo;
                            z3 = liveChatRes$Response$CHATSDKINFO2 == null ? false : q.b(liveChatRes$Response$CHATSDKINFO2.isFreeze, Boolean.TRUE);
                        }
                    }
                    mutableStateFlow2.setValue((z3 ? e.a : e.b));
                    if(((LiveChatRes)httpResponse0) != null) {
                        Response liveChatRes$Response4 = ((LiveChatRes)httpResponse0).response;
                        if(liveChatRes$Response4 != null) {
                            z = liveChatRes$Response4.useChatSdkInfo;
                        }
                    }
                    videoChatViewModel0.j.setValue(Boolean.valueOf(z));
                    if(z) {
                        VideoChatViewModel.access$connect(videoChatViewModel0);
                        return H.a;
                    }
                }
                else {
                    videoChatViewModel0.n.setValue("FAILED");
                }
                return H.a;
            }
        }, 3, null);
        return H.a;
    }

    @Override  // I9.a
    public void onChangeState(@NotNull J9.d d0) {
        q.g(d0, "event");
        Log.i("VideoChatViewModel", "onChangeState : " + d0);
        this.n.setValue(d0.a);
        if(d0 instanceof c) {
            this.clearMessageList(false);
            LogU.Companion.d("VideoChatViewModel", "onChangeState() - connected");
            return;
        }
        if(d0 instanceof J9.a) {
            ToastManager.debug("onChangeState() - socket closed");
            return;
        }
        if(d0 instanceof J9.b) {
            ToastManager.debug("onChangeState() - socket failed");
            Y.w("ChatState.Failed : ", ((J9.b)d0).b.getMessage(), LogU.Companion, "VideoChatViewModel");
        }
    }

    @Override  // I9.a
    public void onCommandMessage(@NotNull MessageEntity messageEntity0) {
        NoticeMessageEntity noticeMessageEntity0;
        int v;
        q.g(messageEntity0, "message");
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("VideoChatViewModel", "onCommandMessage() - " + messageEntity0);
        ArrayList arrayList0 = new ArrayList();
        Object object0 = null;
        boolean z = false;
        if(messageEntity0 instanceof FreezeChatMessageEntity) {
            e e0 = e.valueOf(((FreezeChatMessageEntity)messageEntity0).b());
            logU$Companion0.d("VideoChatViewModel", "onCommandMessage() - freezeType : " + e0);
            if(e.a == e0) {
                z = true;
            }
            Response liveChatRes$Response0 = (Response)this.getResponse().getValue();
            if(liveChatRes$Response0 != null) {
                CHATSDKINFO liveChatRes$Response$CHATSDKINFO0 = liveChatRes$Response0.chatSdkInfo;
                if(liveChatRes$Response$CHATSDKINFO0 != null) {
                    String s = z ? liveChatRes$Response$CHATSDKINFO0.message.freezeOn : liveChatRes$Response$CHATSDKINFO0.message.freezeOff;
                    q.d(s);
                    object0 = new NoticeMessageEntity(s);
                }
            }
            if(object0 != null) {
                arrayList0.add(object0);
            }
            this.h.setValue(e0);
        }
        else if(messageEntity0 instanceof BlockUserMessageEntity) {
            Response liveChatRes$Response1 = (Response)this.getResponse().getValue();
            if(liveChatRes$Response1 != null) {
                CHATSDKINFO liveChatRes$Response$CHATSDKINFO1 = liveChatRes$Response1.chatSdkInfo;
                if(liveChatRes$Response$CHATSDKINFO1 != null) {
                    USER liveChatRes$Response$CHATSDKINFO$USER0 = liveChatRes$Response$CHATSDKINFO1.user;
                    if(liveChatRes$Response$CHATSDKINFO$USER0 != null) {
                        object0 = liveChatRes$Response$CHATSDKINFO$USER0.id;
                    }
                }
            }
            ArrayList arrayList1 = ((BlockUserMessageEntity)messageEntity0).c();
            if(arrayList1 != null && p.d0(arrayList1, object0)) {
                String s1 = ((BlockUserMessageEntity)messageEntity0).b();
                if(s1 == null) {
                    throw new NullPointerException("Name is null");
                }
                if(s1.equals("UNBLOCK")) {
                    v = 1;
                }
                else if(s1.equals("NO_CHAT")) {
                    v = 2;
                }
                else {
                    if(!s1.equals("EXPULSION")) {
                        throw new IllegalArgumentException("No enum constant com.kakaoent.leonchat.data.BlockType." + s1);
                    }
                    v = 3;
                }
                int v1 = b.b(v);
                MutableStateFlow mutableStateFlow0 = this.l;
                switch(v1) {
                    case 0: {
                        mutableStateFlow0.setValue(Boolean.FALSE);
                        noticeMessageEntity0 = this.b(false);
                        break;
                    }
                    case 1: {
                        mutableStateFlow0.setValue(Boolean.TRUE);
                        noticeMessageEntity0 = this.b(true);
                        break;
                    }
                    default: {
                        if(v1 != 2) {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        mutableStateFlow0.setValue(Boolean.TRUE);
                        noticeMessageEntity0 = this.b(true);
                    }
                }
                if(noticeMessageEntity0 != null) {
                    arrayList0.add(noticeMessageEntity0);
                }
            }
        }
        if(!arrayList0.isEmpty()) {
            this.a.postValue(arrayList0);
            this.b.addAll(arrayList0);
            VideoChatHelper.INSTANCE.handleOverMessageCount(this.b);
        }
    }

    @Override  // I9.a
    public void onMessage(@NotNull MessageEntity messageEntity0) {
        NoticeMessageEntity noticeMessageEntity2;
        q.g(messageEntity0, "messageItem");
        ArrayList arrayList0 = new ArrayList();
        if(messageEntity0 instanceof InitMessageEntity) {
            ArrayList arrayList1 = ((InitMessageEntity)messageEntity0).d();
            if(arrayList1 != null) {
                for(Object object0: arrayList1) {
                    String s = new com.google.gson.n().k(object0);
                    q.d(s);
                    MessageFactory.INSTANCE.getClass();
                    MessageEntity messageEntity1 = MessageFactory.a(s);
                    if(messageEntity1 instanceof UserMessageEntity) {
                        if(VideoChatHelperKt.isIncludeBlockWord(((UserMessageEntity)messageEntity1).f())) {
                            if(!VideoChatHelperKt.isMyMessage(((UserMessageEntity)messageEntity1))) {
                                continue;
                            }
                            NoticeMessageEntity noticeMessageEntity0 = this.c();
                            if(noticeMessageEntity0 == null) {
                                continue;
                            }
                            arrayList0.add(noticeMessageEntity0);
                        }
                        else {
                            arrayList0.add(messageEntity1);
                        }
                    }
                    else if(!(messageEntity1 instanceof ArtistMessageEntity)) {
                        arrayList0.add(messageEntity1);
                    }
                    else if(!VideoChatHelperKt.isIncludeBlockWord(((ArtistMessageEntity)messageEntity1).f())) {
                        arrayList0.add(messageEntity1);
                    }
                    else if(VideoChatHelperKt.isMyMessage(((ArtistMessageEntity)messageEntity1))) {
                        NoticeMessageEntity noticeMessageEntity1 = this.c();
                        if(noticeMessageEntity1 == null) {
                            continue;
                        }
                        arrayList0.add(noticeMessageEntity1);
                    }
                }
            }
            Response liveChatRes$Response0 = (Response)this.getResponse().getValue();
            Object object1 = null;
            if(liveChatRes$Response0 == null) {
                noticeMessageEntity2 = null;
            }
            else {
                CHATSDKINFO liveChatRes$Response$CHATSDKINFO0 = liveChatRes$Response0.chatSdkInfo;
                if(liveChatRes$Response$CHATSDKINFO0 == null) {
                    noticeMessageEntity2 = null;
                }
                else {
                    String s1 = liveChatRes$Response$CHATSDKINFO0.message.notice;
                    q.f(s1, "notice");
                    noticeMessageEntity2 = new NoticeMessageEntity(s1);
                }
            }
            if(noticeMessageEntity2 != null) {
                arrayList0.add(noticeMessageEntity2);
            }
            Response liveChatRes$Response1 = (Response)this.getResponse().getValue();
            if(liveChatRes$Response1 != null) {
                CHATSDKINFO liveChatRes$Response$CHATSDKINFO1 = liveChatRes$Response1.chatSdkInfo;
                if(liveChatRes$Response$CHATSDKINFO1 != null) {
                    WELCOME liveChatRes$Response$CHATSDKINFO$Message$WELCOME0 = liveChatRes$Response$CHATSDKINFO1.message.welcome;
                    USER liveChatRes$Response$CHATSDKINFO$USER0 = new USER();
                    liveChatRes$Response$CHATSDKINFO$USER0.id = "Welcome Message";
                    liveChatRes$Response$CHATSDKINFO$USER0.name = liveChatRes$Response$CHATSDKINFO$Message$WELCOME0.name;
                    liveChatRes$Response$CHATSDKINFO$USER0.isArtist = liveChatRes$Response$CHATSDKINFO1.user.isArtist;
                    liveChatRes$Response$CHATSDKINFO$USER0.imgUrl = liveChatRes$Response$CHATSDKINFO$Message$WELCOME0.imgUrl;
                    Map map0 = D.O(new m("melonUser", liveChatRes$Response$CHATSDKINFO$USER0));
                    String s2 = liveChatRes$Response$CHATSDKINFO$Message$WELCOME0.name;
                    q.f(s2, "name");
                    LeonUserInfo leonUserInfo0 = new LeonUserInfo("Welcome Message", s2, (liveChatRes$Response$CHATSDKINFO1.user.isArtist ? "MELON_ARTIST" : "MELON_NORMAL"), map0);
                    if(liveChatRes$Response$CHATSDKINFO1.message.welcome.isArtist) {
                        String s3 = liveChatRes$Response$CHATSDKINFO$Message$WELCOME0.text;
                        q.f(s3, "text");
                        object1 = new ArtistMessageEntity(s3, leonUserInfo0);
                    }
                    else {
                        String s4 = liveChatRes$Response$CHATSDKINFO$Message$WELCOME0.text;
                        q.f(s4, "text");
                        object1 = new UserMessageEntity(s4, s4, leonUserInfo0);
                    }
                }
            }
            if(object1 != null) {
                arrayList0.add(object1);
            }
            Object object2 = this.h.getValue();
            L l0 = this.d;
            if(object2 == e.a) {
                Response liveChatRes$Response2 = (Response)l0.getValue();
                if(liveChatRes$Response2 != null) {
                    CHATSDKINFO liveChatRes$Response$CHATSDKINFO2 = liveChatRes$Response2.chatSdkInfo;
                    if(liveChatRes$Response$CHATSDKINFO2 != null) {
                        Message liveChatRes$Response$CHATSDKINFO$Message0 = liveChatRes$Response$CHATSDKINFO2.message;
                        if(liveChatRes$Response$CHATSDKINFO$Message0 != null) {
                            String s5 = liveChatRes$Response$CHATSDKINFO$Message0.freezeOn;
                            if(s5 != null) {
                                arrayList0.add(new NoticeMessageEntity(s5));
                            }
                        }
                    }
                }
            }
            if(((Boolean)this.l.getValue()).booleanValue()) {
                Response liveChatRes$Response3 = (Response)l0.getValue();
                if(liveChatRes$Response3 != null) {
                    CHATSDKINFO liveChatRes$Response$CHATSDKINFO3 = liveChatRes$Response3.chatSdkInfo;
                    if(liveChatRes$Response$CHATSDKINFO3 != null) {
                        Message liveChatRes$Response$CHATSDKINFO$Message1 = liveChatRes$Response$CHATSDKINFO3.message;
                        if(liveChatRes$Response$CHATSDKINFO$Message1 != null) {
                            String s6 = liveChatRes$Response$CHATSDKINFO$Message1.banOn;
                            if(s6 != null) {
                                arrayList0.add(new NoticeMessageEntity(s6));
                            }
                        }
                    }
                }
            }
            LogU.Companion.d("VideoChatViewModel", "onMessage() - init");
        }
        else if(!(messageEntity0 instanceof UserJoinAndLeftRoomMessageEntity)) {
            if(!(messageEntity0 instanceof UserMessageEntity)) {
                if(!(messageEntity0 instanceof ArtistMessageEntity)) {
                    arrayList0.add(messageEntity0);
                }
                else if(!VideoChatHelperKt.isIncludeBlockWord(((ArtistMessageEntity)messageEntity0).f())) {
                    arrayList0.add(messageEntity0);
                }
                else if(VideoChatHelperKt.isMyMessage(((ArtistMessageEntity)messageEntity0))) {
                    NoticeMessageEntity noticeMessageEntity4 = this.c();
                    if(noticeMessageEntity4 != null) {
                        arrayList0.add(noticeMessageEntity4);
                    }
                }
            }
            else if(!VideoChatHelperKt.isIncludeBlockWord(((UserMessageEntity)messageEntity0).f())) {
                arrayList0.add(messageEntity0);
            }
            else if(VideoChatHelperKt.isMyMessage(((UserMessageEntity)messageEntity0))) {
                NoticeMessageEntity noticeMessageEntity3 = this.c();
                if(noticeMessageEntity3 != null) {
                    arrayList0.add(noticeMessageEntity3);
                }
            }
        }
        if(!arrayList0.isEmpty()) {
            this.a.postValue(arrayList0);
            this.b.addAll(arrayList0);
            VideoChatHelper.INSTANCE.handleOverMessageCount(this.b);
        }
    }

    public final void sendMessage() {
        VideoChatViewModel videoChatViewModel0;
        String s = o.e1(this.g).toString();
        if(s.length() > 0) {
            I9.g g0 = (I9.g)this.f.getValue();
            g0.getClass();
            Class class0 = I9.g.class;
            if(I.d) {
                Log.i(class0.getSimpleName(), "send() - message : " + s);
            }
            if(g0.i == e.a) {
                String s1 = "send() - currentState : " + g0.i;
                if(I.d) {
                    Log.d(class0.getSimpleName(), s1);
                }
            }
            else {
                try {
                    if(g0.d == null) {
                        if(I.d) {
                            Log.w(class0.getSimpleName(), "webSocket is null");
                        }
                        throw new NullPointerException("webSocket is null");
                    }
                    String s2 = g0.c(s);
                    if(I.d) {
                        Log.d(class0.getSimpleName(), "sendEntityString : " + s2);
                    }
                    WebSocket webSocket0 = g0.d;
                    if(webSocket0 != null) {
                        webSocket0.send(s2);
                        this.g = "";
                        return;
                    label_26:
                        videoChatViewModel0 = g0.j;
                        if(videoChatViewModel0 != null) {
                            goto label_28;
                        }
                    }
                    this.g = "";
                    return;
                }
                catch(IllegalArgumentException illegalArgumentException0) {
                    goto label_26;
                }
                catch(NullPointerException nullPointerException0) {
                    goto label_30;
                }
            label_28:
                videoChatViewModel0.onChangeState(new J9.b(illegalArgumentException0));
                this.g = "";
                return;
            label_30:
                VideoChatViewModel videoChatViewModel1 = g0.j;
                if(videoChatViewModel1 != null) {
                    videoChatViewModel1.onChangeState(new J9.b(nullPointerException0));
                }
            }
            this.g = "";
        }
    }

    public final void setInputMessage(@NotNull String s) {
        q.g(s, "<set-?>");
        this.g = s;
    }

    public final void setMessageList(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "<set-?>");
        this.b = arrayList0;
    }
}

