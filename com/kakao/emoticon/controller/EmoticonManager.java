package com.kakao.emoticon.controller;

import Tf.o;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.db.model.EmoticonDAO;
import com.kakao.emoticon.interfaces.EmoticonAuthListener;
import com.kakao.emoticon.interfaces.EmoticonUpdateListener;
import com.kakao.emoticon.net.EmoticonApiError;
import com.kakao.emoticon.net.EmoticonApiLauncher;
import com.kakao.emoticon.net.EmoticonApiService;
import com.kakao.emoticon.net.EmoticonApiServiceImpl;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.net.response.EmoticonConfig;
import com.kakao.emoticon.net.response.EmoticonResourceAuth;
import com.kakao.emoticon.net.response.Keyboard;
import com.kakao.emoticon.net.response.MyItems;
import com.kakao.emoticon.ui.tab.EmoticonTabItem;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0001HB\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\b\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u000E\u00A2\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0015\u001A\u00020\u00072\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013\u00A2\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0003J\u0013\u0010\u0018\u001A\u00020\u0007H\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001B\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00050\u001C2\u0006\u0010\u001B\u001A\u00020\u001A\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001B\u0010!\u001A\u00020\u00072\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u001F0\u0004\u00A2\u0006\u0004\b!\u0010\tJ\u001F\u0010$\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010#\u001A\u00020\"\u00A2\u0006\u0004\b$\u0010%J\u0013\u0010&\u001A\u00020\u0007H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b&\u0010\u0019R\u0014\u0010\'\u001A\u00020\"8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\'\u0010(R\u0014\u0010)\u001A\u00020\"8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b*\u0010+R\"\u0010,\u001A\u00020\u001A8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b,\u0010-\u001A\u0004\b,\u0010.\"\u0004\b/\u00100R\"\u00101\u001A\u00020\u001A8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b1\u0010-\u001A\u0004\b1\u0010.\"\u0004\b2\u00100R\u0018\u00103\u001A\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00104R\u001A\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u0005058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u00106R\u001A\u00107\u001A\b\u0012\u0004\u0012\u00020\u0005058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b7\u00106R$\u00109\u001A\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b9\u0010:\u001A\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010?\u001A\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b?\u0010(\u001A\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0011\u0010D\u001A\u00020\u001A8F\u00A2\u0006\u0006\u001A\u0004\bD\u0010.R\u0017\u0010G\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048F\u00A2\u0006\u0006\u001A\u0004\bE\u0010F\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006I"}, d2 = {"Lcom/kakao/emoticon/controller/EmoticonManager;", "", "<init>", "()V", "", "Lcom/kakao/emoticon/net/response/Emoticon;", "emoticons", "Lie/H;", "emoticonClearAndAddAll", "(Ljava/util/List;)V", "", "updatedAt", "saveLastUpdatedAt", "(J)V", "Lcom/kakao/emoticon/controller/EmoticonManager$EmoticonCallback;", "callback", "init", "(Lcom/kakao/emoticon/controller/EmoticonManager$EmoticonCallback;)V", "updateSessionState", "Lcom/kakao/emoticon/interfaces/EmoticonUpdateListener;", "updateListener", "setEmoticonUpdateListener", "(Lcom/kakao/emoticon/interfaces/EmoticonUpdateListener;)V", "removeSessionListener", "reloadLocalEmoticons", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isShow", "", "getEmoticonList", "(Z)Ljava/util/List;", "Lcom/kakao/emoticon/ui/tab/EmoticonTabItem;", "tabItems", "updateEmoticonTab", "", "option", "requestSyncEmoticons", "(Lcom/kakao/emoticon/controller/EmoticonManager$EmoticonCallback;Ljava/lang/String;)V", "removeExpiredItems", "EMOTICON_ITEM_NORMAL", "Ljava/lang/String;", "EMOTICON_ITEM_KEYBOARD", "EMOTICON_SYNC_INTERVAL", "J", "isNeedRefreshKeyboard", "Z", "()Z", "setNeedRefreshKeyboard", "(Z)V", "isNeedSyncKeyboard", "setNeedSyncKeyboard", "emoticonUpdateListener", "Lcom/kakao/emoticon/interfaces/EmoticonUpdateListener;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "logoutEmoticons", "Lcom/kakao/emoticon/net/response/EmoticonConfig;", "emoticonConfig", "Lcom/kakao/emoticon/net/response/EmoticonConfig;", "getEmoticonConfig", "()Lcom/kakao/emoticon/net/response/EmoticonConfig;", "setEmoticonConfig", "(Lcom/kakao/emoticon/net/response/EmoticonConfig;)V", "settingBannerImageUrl", "getSettingBannerImageUrl", "()Ljava/lang/String;", "setSettingBannerImageUrl", "(Ljava/lang/String;)V", "isValidEmoticonConfig", "getAllEmoticonList", "()Ljava/util/List;", "allEmoticonList", "EmoticonCallback", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonManager {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/kakao/emoticon/controller/EmoticonManager$EmoticonCallback;", "", "Lie/H;", "onSuccess", "()V", "Lcom/kakao/emoticon/net/EmoticonApiError;", "errorResult", "onFailure", "(Lcom/kakao/emoticon/net/EmoticonApiError;)V", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
    public interface EmoticonCallback {
        void onFailure(@NotNull EmoticonApiError arg1);

        void onSuccess();
    }

    private static final String EMOTICON_ITEM_KEYBOARD = "keyboard";
    private static final String EMOTICON_ITEM_NORMAL = "normal";
    private static final long EMOTICON_SYNC_INTERVAL = 900000L;
    public static final EmoticonManager INSTANCE;
    @Nullable
    private static EmoticonConfig emoticonConfig;
    private static EmoticonUpdateListener emoticonUpdateListener;
    private static final ConcurrentLinkedQueue emoticons;
    private static boolean isNeedRefreshKeyboard;
    private static boolean isNeedSyncKeyboard;
    private static final ConcurrentLinkedQueue logoutEmoticons;
    @Nullable
    private static String settingBannerImageUrl;

    static {
        EmoticonManager.INSTANCE = new EmoticonManager();
        EmoticonManager.emoticons = new ConcurrentLinkedQueue();
        EmoticonManager.logoutEmoticons = new ConcurrentLinkedQueue();
        if(KakaoEmoticon.getApplication() == null) {
            throw new RuntimeException("KakaoEmoticon Can\'t be init!");
        }
    }

    public static final ConcurrentLinkedQueue access$getEmoticons$p(EmoticonManager emoticonManager0) {
        return EmoticonManager.emoticons;
    }

    private final void emoticonClearAndAddAll(List list0) {
        EmoticonManager.emoticons.clear();
        EmoticonManager.emoticons.addAll(list0);
        EmoticonManager.logoutEmoticons.clear();
        EmoticonManager.logoutEmoticons.addAll(list0);
    }

    @NotNull
    public final List getAllEmoticonList() {
        return p.Q0(EmoticonManager.emoticons);
    }

    @Nullable
    public final EmoticonConfig getEmoticonConfig() {
        return EmoticonManager.emoticonConfig;
    }

    @NotNull
    public final List getEmoticonList(boolean z) {
        stringBuilder0.toString();
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: EmoticonManager.emoticons) {
            if(((Emoticon)object0).isShow() == z) {
                arrayList0.add(object0);
            }
        }
        return p.Q0(arrayList0);
    }

    @Nullable
    public final String getSettingBannerImageUrl() {
        return EmoticonManager.settingBannerImageUrl;
    }

    public final void init(@NotNull EmoticonCallback emoticonManager$EmoticonCallback0) {
        q.g(emoticonManager$EmoticonCallback0, "callback");
        if(!EmoticonManager.isNeedSyncKeyboard && !EmoticonManager.emoticons.isEmpty()) {
            EmoticonPreference emoticonPreference0 = EmoticonPreference.getInstance();
            q.f(emoticonPreference0, "EmoticonPreference.getInstance()");
            if(System.currentTimeMillis() - emoticonPreference0.getLastUpdatedAt() <= 900000L && (KakaoEmoticon.isConnectedAccount() || !EmoticonManager.logoutEmoticons.isEmpty())) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(null) {
                    final EmoticonCallback $callback;
                    Object L$0;
                    int label;
                    private CoroutineScope p$;

                    {
                        this.$callback = emoticonManager$EmoticonCallback0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    @NotNull
                    public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                        q.g(continuation0, "completion");
                        Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonManager.init.1(this.$callback, continuation0);
                        continuation1.p$ = (CoroutineScope)object0;
                        return continuation1;
                    }

                    @Override  // we.n
                    public final Object invoke(Object object0, Object object1) {
                        return ((com.kakao.emoticon.controller.EmoticonManager.init.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                this.L$0 = this.p$;
                                this.label = 1;
                                if(EmoticonManager.INSTANCE.reloadLocalEmoticons(this) == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                d5.n.D(object0);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        this.$callback.onSuccess();
                        return H.a;
                    }
                }, 3, null);
                return;
            }
        }
        EmoticonManager.isNeedSyncKeyboard = false;
        EmoticonManager.isNeedRefreshKeyboard = false;
        EmoticonManager.requestSyncEmoticons$default(this, emoticonManager$EmoticonCallback0, null, 2, null);
    }

    public final boolean isNeedRefreshKeyboard() [...] // 潜在的解密器

    public final boolean isNeedSyncKeyboard() [...] // 潜在的解密器

    public final boolean isValidEmoticonConfig() {
        EmoticonConfig emoticonConfig0 = EmoticonManager.emoticonConfig;
        if(emoticonConfig0 != null) {
            EmoticonResourceAuth emoticonResourceAuth0 = emoticonConfig0.getResourceAuth();
            return emoticonResourceAuth0 == null ? 0L > System.currentTimeMillis() / 1000L + 180L : emoticonResourceAuth0.getExpires() > System.currentTimeMillis() / 1000L + 180L;
        }
        return 0L > System.currentTimeMillis() / 1000L + 180L;
    }

    @Nullable
    public final Object reloadLocalEmoticons(@NotNull Continuation continuation0) {
        com.kakao.emoticon.controller.EmoticonManager.reloadLocalEmoticons.1 emoticonManager$reloadLocalEmoticons$10;
        synchronized(this) {
            if(continuation0 instanceof com.kakao.emoticon.controller.EmoticonManager.reloadLocalEmoticons.1) {
                emoticonManager$reloadLocalEmoticons$10 = (com.kakao.emoticon.controller.EmoticonManager.reloadLocalEmoticons.1)continuation0;
                int v1 = emoticonManager$reloadLocalEmoticons$10.label;
                if((v1 & 0x80000000) == 0) {
                    emoticonManager$reloadLocalEmoticons$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.reloadLocalEmoticons(this);
                        }
                    };
                }
                else {
                    emoticonManager$reloadLocalEmoticons$10.label = v1 ^ 0x80000000;
                }
            }
            else {
                emoticonManager$reloadLocalEmoticons$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.reloadLocalEmoticons(this);
                    }
                };
            }
            Object object0 = emoticonManager$reloadLocalEmoticons$10.result;
            a a0 = a.a;
            switch(emoticonManager$reloadLocalEmoticons$10.label) {
                case 0: {
                    d5.n.D(object0);
                    ConcurrentLinkedQueue concurrentLinkedQueue0 = EmoticonManager.emoticons;
                    concurrentLinkedQueue0.clear();
                    if(KakaoEmoticon.isConnectedAccount()) {
                        com.kakao.emoticon.controller.EmoticonManager.reloadLocalEmoticons.2 emoticonManager$reloadLocalEmoticons$20 = new n() {
                            int label;
                            private CoroutineScope p$;

                            {
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            @NotNull
                            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                                q.g(continuation0, "completion");
                                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonManager.reloadLocalEmoticons.2(continuation0);
                                continuation1.p$ = (CoroutineScope)object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public final Object invoke(Object object0, Object object1) {
                                return ((com.kakao.emoticon.controller.EmoticonManager.reloadLocalEmoticons.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                EmoticonDAO emoticonDAO0 = EmoticonDAO.instance();
                                q.f(emoticonDAO0, "EmoticonDAO.instance()");
                                return Boolean.valueOf(EmoticonManager.access$getEmoticons$p(EmoticonManager.INSTANCE).addAll(emoticonDAO0.getAll()));
                            }
                        };
                        emoticonManager$reloadLocalEmoticons$10.L$0 = this;
                        emoticonManager$reloadLocalEmoticons$10.label = 1;
                        if(BuildersKt.withContext(Dispatchers.getIO(), emoticonManager$reloadLocalEmoticons$20, emoticonManager$reloadLocalEmoticons$10) == a0) {
                            return a0;
                        }
                    }
                    else {
                        concurrentLinkedQueue0.addAll(p.Q0(EmoticonManager.logoutEmoticons));
                    }
                    break;
                }
                case 1: {
                    EmoticonManager emoticonManager0 = (EmoticonManager)emoticonManager$reloadLocalEmoticons$10.L$0;
                    d5.n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            stringBuilder0.toString();
            return H.a;
        }
    }

    @Nullable
    public final Object removeExpiredItems(@NotNull Continuation continuation0) {
        com.kakao.emoticon.controller.EmoticonManager.removeExpiredItems.1 emoticonManager$removeExpiredItems$10;
        if(continuation0 instanceof com.kakao.emoticon.controller.EmoticonManager.removeExpiredItems.1) {
            emoticonManager$removeExpiredItems$10 = (com.kakao.emoticon.controller.EmoticonManager.removeExpiredItems.1)continuation0;
            int v = emoticonManager$removeExpiredItems$10.label;
            if((v & 0x80000000) == 0) {
                emoticonManager$removeExpiredItems$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.removeExpiredItems(this);
                    }
                };
            }
            else {
                emoticonManager$removeExpiredItems$10.label = v ^ 0x80000000;
            }
        }
        else {
            emoticonManager$removeExpiredItems$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.removeExpiredItems(this);
                }
            };
        }
        Object object0 = emoticonManager$removeExpiredItems$10.result;
        a a0 = a.a;
        switch(emoticonManager$removeExpiredItems$10.label) {
            case 0: {
                d5.n.D(object0);
                if(KakaoEmoticon.isConnectedAccount()) {
                    com.kakao.emoticon.controller.EmoticonManager.removeExpiredItems.2 emoticonManager$removeExpiredItems$20 = new n() {
                        int label;
                        private CoroutineScope p$;

                        {
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        @NotNull
                        public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                            q.g(continuation0, "completion");
                            Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonManager.removeExpiredItems.2(continuation0);
                            continuation1.p$ = (CoroutineScope)object0;
                            return continuation1;
                        }

                        @Override  // we.n
                        public final Object invoke(Object object0, Object object1) {
                            return ((com.kakao.emoticon.controller.EmoticonManager.removeExpiredItems.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            EmoticonDAO emoticonDAO0 = EmoticonDAO.instance();
                            q.f(emoticonDAO0, "EmoticonDAO.instance()");
                            List list0 = emoticonDAO0.getAll();
                            q.f(list0, "EmoticonDAO.instance().all");
                            ArrayList arrayList0 = new ArrayList();
                            for(Object object1: list0) {
                                Emoticon emoticon0 = (Emoticon)object1;
                                if(!emoticon0.isEventItem() && emoticon0.getExpiredAt() > 0L && emoticon0.getExpiredAt() * 1000L < System.currentTimeMillis()) {
                                    arrayList0.add(object1);
                                }
                            }
                            for(Object object2: arrayList0) {
                                EmoticonDAO.instance().remove(((Emoticon)object2).getId());
                            }
                            return H.a;
                        }
                    };
                    emoticonManager$removeExpiredItems$10.L$0 = this;
                    emoticonManager$removeExpiredItems$10.label = 1;
                    if(BuildersKt.withContext(Dispatchers.getIO(), emoticonManager$removeExpiredItems$20, emoticonManager$removeExpiredItems$10) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
            case 1: {
                EmoticonManager emoticonManager0 = (EmoticonManager)emoticonManager$removeExpiredItems$10.L$0;
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final void removeSessionListener() {
        EmoticonManager.emoticonUpdateListener = null;
    }

    public final void requestSyncEmoticons(@NotNull EmoticonCallback emoticonManager$EmoticonCallback0, @NotNull String s) {
        q.g(emoticonManager$EmoticonCallback0, "callback");
        q.g(s, "option");
        "++ requestSyncEmoticons() - ".concat(s);
        com.kakao.emoticon.controller.EmoticonManager.requestSyncEmoticons.1 emoticonManager$requestSyncEmoticons$10 = new k(null) {
            final String $option;
            int label;

            {
                this.$option = s;
                super(1, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                return new com.kakao.emoticon.controller.EmoticonManager.requestSyncEmoticons.1(this.$option, continuation0);
            }

            @Override  // we.k
            public final Object invoke(Object object0) {
                return ((com.kakao.emoticon.controller.EmoticonManager.requestSyncEmoticons.1)this.create(((Continuation)object0))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        EmoticonApiService emoticonApiService0 = EmoticonApiServiceImpl.INSTANCE.getApiClass();
                        this.label = 1;
                        Object object1 = emoticonApiService0.getMyItem(this.$option, this);
                        return object1 == a0 ? a0 : object1;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return object0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        };
        com.kakao.emoticon.controller.EmoticonManager.requestSyncEmoticons.2 emoticonManager$requestSyncEmoticons$20 = new n(emoticonManager$EmoticonCallback0, null) {
            final EmoticonCallback $callback;
            final String $option;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            private MyItems p$0;

            {
                this.$option = s;
                this.$callback = emoticonManager$EmoticonCallback0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonManager.requestSyncEmoticons.2(this.$option, this.$callback, continuation0);
                continuation1.p$0 = (MyItems)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonManager.requestSyncEmoticons.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                MyItems myItems0;
                a a0 = a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        myItems0 = this.p$0;
                        if(KakaoEmoticon.isConnectedAccount()) {
                            kotlin.jvm.internal.H h1 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                            EmoticonPreference emoticonPreference0 = EmoticonPreference.getInstance();
                            q.f(emoticonPreference0, "EmoticonPreference.getInstance()");
                            h1.a = emoticonPreference0.getUID();
                            kotlin.jvm.internal.H h2 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                            h2.a = myItems0.getUid();
                            stringBuilder0.toString();
                            String s = (String)h1.a;
                            if(s != null && s.length() != 0 && !q.b(((String)h1.a), ((String)h2.a)) && q.b(this.$option, "normal")) {
                                EmoticonManager.INSTANCE.requestSyncEmoticons(this.$callback, "keyboard");
                                return h0;
                            }
                            com.kakao.emoticon.controller.EmoticonManager.requestSyncEmoticons.2.1 emoticonManager$requestSyncEmoticons$2$10 = new n(h2, myItems0, null) {
                                final MyItems $response;
                                final kotlin.jvm.internal.H $responseUid;
                                final kotlin.jvm.internal.H $savedUid;
                                Object L$0;
                                int label;
                                private CoroutineScope p$;

                                {
                                    this.$savedUid = h0;
                                    this.$responseUid = h1;
                                    this.$response = myItems0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                @NotNull
                                public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                                    q.g(continuation0, "completion");
                                    Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonManager.requestSyncEmoticons.2.1(this.$savedUid, this.$responseUid, this.$response, continuation0);
                                    continuation1.p$ = (CoroutineScope)object0;
                                    return continuation1;
                                }

                                @Override  // we.n
                                public final Object invoke(Object object0, Object object1) {
                                    return ((com.kakao.emoticon.controller.EmoticonManager.requestSyncEmoticons.2.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                @Nullable
                                public final Object invokeSuspend(@NotNull Object object0) {
                                    a a0 = a.a;
                                    switch(this.label) {
                                        case 0: {
                                            d5.n.D(object0);
                                            CoroutineScope coroutineScope0 = this.p$;
                                            String s = (String)this.$savedUid.a;
                                            int v = 0;
                                            if(s == null || s.length() == 0 || !q.b(((String)this.$savedUid.a), ((String)this.$responseUid.a))) {
                                                EmoticonPreference.getInstance().resetTabIndex();
                                                EmoticonDAO emoticonDAO2 = EmoticonDAO.instance();
                                                q.f(emoticonDAO2, "EmoticonDAO.instance()");
                                                List list2 = emoticonDAO2.getAll();
                                                q.f(list2, "EmoticonDAO.instance().all");
                                                for(Object object8: list2) {
                                                    EmoticonDAO.instance().remove(((Emoticon)object8).getId());
                                                }
                                                Keyboard keyboard0 = this.$response.getKeyboard();
                                                if(keyboard0 != null) {
                                                    Set set0 = keyboard0.getTabItemIds();
                                                    if(set0 != null) {
                                                        ArrayList arrayList3 = new ArrayList();
                                                        for(Object object9: this.$response.getItems()) {
                                                            if(set0.contains(((Emoticon)object9).getId())) {
                                                                arrayList3.add(object9);
                                                            }
                                                        }
                                                        int v2 = 0;
                                                        for(Object object10: arrayList3) {
                                                            if(v2 >= 0) {
                                                                ((Emoticon)object10).setOrderIndex(new Integer(v2).intValue());
                                                                ((Emoticon)object10).setShow(true);
                                                                ++v2;
                                                                continue;
                                                            }
                                                            e.k.O();
                                                            throw null;
                                                        }
                                                        ArrayList arrayList4 = new ArrayList();
                                                        for(Object object11: this.$response.getItems()) {
                                                            if(!set0.contains(((Emoticon)object11).getId())) {
                                                                arrayList4.add(object11);
                                                            }
                                                        }
                                                        int v3 = 0;
                                                        for(Object object12: arrayList4) {
                                                            if(v3 >= 0) {
                                                                ((Emoticon)object12).setOrderIndex(new Integer(v3).intValue());
                                                                ((Emoticon)object12).setShow(false);
                                                                ++v3;
                                                                continue;
                                                            }
                                                            e.k.O();
                                                            throw null;
                                                        }
                                                    }
                                                }
                                            }
                                            else {
                                                EmoticonDAO emoticonDAO0 = EmoticonDAO.instance();
                                                q.f(emoticonDAO0, "EmoticonDAO.instance()");
                                                List list0 = emoticonDAO0.getAll();
                                                q.f(list0, "EmoticonDAO.instance().all");
                                                ArrayList arrayList0 = new ArrayList();
                                                for(Object object1: list0) {
                                                    if(!this.$response.getItems().contains(((Emoticon)object1))) {
                                                        arrayList0.add(object1);
                                                    }
                                                }
                                                for(Object object2: arrayList0) {
                                                    EmoticonDAO.instance().remove(((Emoticon)object2).getId());
                                                }
                                                EmoticonDAO emoticonDAO1 = EmoticonDAO.instance();
                                                q.f(emoticonDAO1, "EmoticonDAO.instance()");
                                                List list1 = emoticonDAO1.getAll();
                                                int v1 = this.$response.getItems().size() <= list1.size() ? 0 : this.$response.getItems().size() - list1.size();
                                                ArrayList arrayList1 = new ArrayList();
                                                for(Object object3: this.$response.getItems()) {
                                                    if(!list1.contains(((Emoticon)object3))) {
                                                        arrayList1.add(object3);
                                                    }
                                                }
                                                for(Object object4: arrayList1) {
                                                    if(v >= 0) {
                                                        ((Emoticon)object4).setShow(true);
                                                        ((Emoticon)object4).setOrderIndex(new Integer(v).intValue());
                                                        ++v;
                                                        continue;
                                                    }
                                                    e.k.O();
                                                    throw null;
                                                }
                                                ArrayList arrayList2 = new ArrayList();
                                                for(Object object5: this.$response.getItems()) {
                                                    if(list1.contains(((Emoticon)object5))) {
                                                        arrayList2.add(object5);
                                                    }
                                                }
                                                for(Object object6: arrayList2) {
                                                    Emoticon emoticon0 = (Emoticon)object6;
                                                    for(Object object7: list1) {
                                                        if(!q.b(((Emoticon)object7).getId(), emoticon0.getId())) {
                                                            continue;
                                                        }
                                                        goto label_62;
                                                    }
                                                    object7 = null;
                                                label_62:
                                                    if(((Emoticon)object7) != null) {
                                                        emoticon0.setShow(((Emoticon)object7).isShow());
                                                        emoticon0.setOrderIndex(((Emoticon)object7).getOrderIndex() + v1);
                                                    }
                                                }
                                            }
                                            EmoticonDAO.instance().insertOrUpdate(this.$response.getItems());
                                            EmoticonPreference emoticonPreference0 = EmoticonPreference.getInstance();
                                            q.f(emoticonPreference0, "EmoticonPreference.getInstance()");
                                            emoticonPreference0.setUID(((String)this.$responseUid.a));
                                            this.L$0 = coroutineScope0;
                                            this.label = 1;
                                            return EmoticonManager.INSTANCE.reloadLocalEmoticons(this) == a0 ? a0 : H.a;
                                        }
                                        case 1: {
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
                            this.L$0 = myItems0;
                            this.L$1 = h1;
                            this.L$2 = h2;
                            this.label = 1;
                            if(BuildersKt.withContext(Dispatchers.getIO(), emoticonManager$requestSyncEmoticons$2$10, this) == a0) {
                                return a0;
                            }
                        }
                        else {
                            for(Object object1: myItems0.getItems()) {
                                ((Emoticon)object1).setShow(true);
                            }
                            EmoticonManager.INSTANCE.emoticonClearAndAddAll(myItems0.getItems());
                        }
                        break;
                    }
                    case 1: {
                        kotlin.jvm.internal.H h3 = (kotlin.jvm.internal.H)this.L$2;
                        kotlin.jvm.internal.H h4 = (kotlin.jvm.internal.H)this.L$1;
                        MyItems myItems1 = (MyItems)this.L$0;
                        d5.n.D(object0);
                        myItems0 = myItems1;
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                EmoticonManager.INSTANCE.setSettingBannerImageUrl(myItems0.getSettingBannerUrl());
                EmoticonManager.INSTANCE.saveLastUpdatedAt(System.currentTimeMillis());
                this.$callback.onSuccess();
                return h0;
            }
        };
        com.kakao.emoticon.controller.EmoticonManager.requestSyncEmoticons.3 emoticonManager$requestSyncEmoticons$30 = new n(null) {
            final EmoticonCallback $callback;
            Object L$0;
            int label;
            private EmoticonApiError p$0;

            {
                this.$callback = emoticonManager$EmoticonCallback0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonManager.requestSyncEmoticons.3(this.$callback, continuation0);
                continuation1.p$0 = (EmoticonApiError)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonManager.requestSyncEmoticons.3)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                EmoticonApiError emoticonApiError1;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        EmoticonApiError emoticonApiError0 = this.p$0;
                        this.L$0 = emoticonApiError0;
                        this.label = 1;
                        if(EmoticonManager.INSTANCE.removeExpiredItems(this) == a0) {
                            return a0;
                        }
                        emoticonApiError1 = emoticonApiError0;
                        break;
                    }
                    case 1: {
                        emoticonApiError1 = (EmoticonApiError)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                EmoticonManager.access$getEmoticons$p(EmoticonManager.INSTANCE).clear();
                EmoticonManager.INSTANCE.saveLastUpdatedAt(0L);
                this.$callback.onFailure(emoticonApiError1);
                EmoticonAuthListener emoticonAuthListener0 = KakaoEmoticon.getAuthListener();
                if(emoticonAuthListener0 != null) {
                    emoticonAuthListener0.onFail(emoticonApiError1);
                }
                return H.a;
            }
        };
        EmoticonApiLauncher.launchMain$default(EmoticonApiLauncher.INSTANCE, emoticonManager$requestSyncEmoticons$10, emoticonManager$requestSyncEmoticons$20, emoticonManager$requestSyncEmoticons$30, null, 8, null);
    }

    public static void requestSyncEmoticons$default(EmoticonManager emoticonManager0, EmoticonCallback emoticonManager$EmoticonCallback0, String s, int v, Object object0) {
        if((v & 2) != 0) {
            if(KakaoEmoticon.isConnectedAccount()) {
                EmoticonPreference emoticonPreference0 = EmoticonPreference.getInstance();
                q.f(emoticonPreference0, "EmoticonPreference.getInstance()");
                String s1 = emoticonPreference0.getUID();
                s = s1 != null && !o.H0(s1) ? "normal" : "keyboard";
            }
            else {
                s = "normal";
            }
        }
        emoticonManager0.requestSyncEmoticons(emoticonManager$EmoticonCallback0, s);
    }

    private final void saveLastUpdatedAt(long v) {
        EmoticonPreference emoticonPreference0 = EmoticonPreference.getInstance();
        q.f(emoticonPreference0, "EmoticonPreference.getInstance()");
        emoticonPreference0.setLastUpdatedAt(v);
    }

    public final void setEmoticonConfig(@Nullable EmoticonConfig emoticonConfig0) {
        EmoticonManager.emoticonConfig = emoticonConfig0;
    }

    public final void setEmoticonUpdateListener(@Nullable EmoticonUpdateListener emoticonUpdateListener0) {
        EmoticonManager.emoticonUpdateListener = emoticonUpdateListener0;
    }

    public final void setNeedRefreshKeyboard(boolean z) {
        EmoticonManager.isNeedRefreshKeyboard = z;
    }

    public final void setNeedSyncKeyboard(boolean z) {
        EmoticonManager.isNeedSyncKeyboard = z;
    }

    public final void setSettingBannerImageUrl(@Nullable String s) {
        EmoticonManager.settingBannerImageUrl = s;
    }

    public final void updateEmoticonTab(@NotNull List list0) {
        q.g(list0, "tabItems");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(null) {
            final List $tabItems;
            Object L$0;
            Object L$1;
            int label;
            private CoroutineScope p$;

            {
                this.$tabItems = list0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonManager.updateEmoticonTab.1(this.$tabItems, continuation0);
                continuation1.p$ = (CoroutineScope)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonManager.updateEmoticonTab.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        CoroutineScope coroutineScope0 = this.p$;
                        List list0 = EmoticonManager.INSTANCE.getAllEmoticonList();
                        for(Object object1: list0) {
                            Emoticon emoticon0 = (Emoticon)object1;
                            int v = this.$tabItems.size();
                            boolean z = false;
                            for(int v1 = 0; v1 < v; ++v1) {
                                if(q.b(emoticon0.getId(), ((EmoticonTabItem)this.$tabItems.get(v1)).getItemId())) {
                                    emoticon0.setOrderIndex(v1);
                                    z = true;
                                    break;
                                }
                            }
                            emoticon0.setShow(z);
                        }
                        EmoticonDAO.instance().insertOrUpdate(list0);
                        this.L$0 = coroutineScope0;
                        this.L$1 = list0;
                        this.label = 1;
                        return EmoticonManager.INSTANCE.reloadLocalEmoticons(this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        List list1 = (List)this.L$1;
                        CoroutineScope coroutineScope1 = (CoroutineScope)this.L$0;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    public final void updateSessionState() {
        if(EmoticonManager.emoticonUpdateListener != null) {
            EmoticonUpdateListener emoticonUpdateListener0 = EmoticonManager.emoticonUpdateListener;
            q.d(emoticonUpdateListener0);
            emoticonUpdateListener0.onSessionUpdated();
            return;
        }
        EmoticonManager.isNeedSyncKeyboard = true;
    }
}

