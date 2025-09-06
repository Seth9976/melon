package com.iloen.melon.fragments.settings.login;

import android.accounts.Account;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.K4;
import com.melon.ui.n0;
import ie.H;
import java.util.List;
import javax.inject.Inject;
import k8.Y;
import k8.a;
import k8.b;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mb.k;
import mb.n;
import mb.o;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.h0;
import va.i0;
import va.q1;
import va.t1;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u0018\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\fH\u0086@¢\u0006\u0004\b\u000F\u0010\u0010J\u0018\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\fH\u0086@¢\u0006\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0014\u0010\u0017\u001A\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountViewModel;", "Lcom/melon/ui/n0;", "Lmb/o;", "simpleAccountUseCase", "Lmb/k;", "loginUseCase", "Lmb/n;", "simpleAccountRemoveExplicitlyUseCase", "Lk8/a;", "dialogManage", "<init>", "(Lmb/o;Lmb/k;Lmb/n;Lk8/a;)V", "", "userId", "Lie/H;", "loginBySimpleAccount", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeSimpleAccount", "Lmb/o;", "Lmb/k;", "Lmb/n;", "Lk8/a;", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LoginSimpleAccountViewModel extends n0 {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountViewModel$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "LoginSimpleAccountViewModel";
    @NotNull
    private final a dialogManage;
    @NotNull
    private final LogU log;
    @NotNull
    private final k loginUseCase;
    @NotNull
    private final n simpleAccountRemoveExplicitlyUseCase;
    @NotNull
    private final o simpleAccountUseCase;

    static {
        LoginSimpleAccountViewModel.Companion = new Companion(null);
        LoginSimpleAccountViewModel.$stable = 8;
    }

    @Inject
    public LoginSimpleAccountViewModel(@NotNull o o0, @NotNull k k0, @NotNull n n0, @NotNull a a0) {
        q.g(o0, "simpleAccountUseCase");
        q.g(k0, "loginUseCase");
        q.g(n0, "simpleAccountRemoveExplicitlyUseCase");
        q.g(a0, "dialogManage");
        super();
        this.simpleAccountUseCase = o0;
        this.loginUseCase = k0;
        this.simpleAccountRemoveExplicitlyUseCase = n0;
        this.dialogManage = a0;
        this.log = LogU.Companion.create("LoginSimpleAccountViewModel", true, Category.Login);
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(null) {
            int label;

            {
                LoginSimpleAccountViewModel.this = loginSimpleAccountViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel.1(LoginSimpleAccountViewModel.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = LoginSimpleAccountViewModel.access$getSimpleAccountUseCase$p(LoginSimpleAccountViewModel.this).a();
                        com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel.1.1 loginSimpleAccountViewModel$1$10 = new we.n(null) {
                            Object L$0;
                            int label;

                            {
                                LoginSimpleAccountViewModel.this = loginSimpleAccountViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel.1.1(LoginSimpleAccountViewModel.this, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((List)object0), ((Continuation)object1));
                            }

                            public final Object invoke(List list0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel.1.1)this.create(list0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                List list0 = (List)this.L$0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                e e0 = new e(list0);
                                LoginSimpleAccountViewModel.access$updateUiState(LoginSimpleAccountViewModel.this, e0);
                                return H.a;
                            }

                            private static final K4 invokeSuspend$lambda$0(List list0, K4 k40) {
                                return new Screen(list0);
                            }
                        };
                        this.label = 1;
                        return FlowKt.collectLatest(flow0, loginSimpleAccountViewModel$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
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

    public static final o access$getSimpleAccountUseCase$p(LoginSimpleAccountViewModel loginSimpleAccountViewModel0) {
        return loginSimpleAccountViewModel0.simpleAccountUseCase;
    }

    public static final void access$updateUiState(LoginSimpleAccountViewModel loginSimpleAccountViewModel0, we.k k0) {
        loginSimpleAccountViewModel0.updateUiState(k0);
    }

    @Nullable
    public final Object loginBySimpleAccount(@NotNull String s, @NotNull Continuation continuation0) {
        com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel.loginBySimpleAccount.1 loginSimpleAccountViewModel$loginBySimpleAccount$10;
        if(continuation0 instanceof com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel.loginBySimpleAccount.1) {
            loginSimpleAccountViewModel$loginBySimpleAccount$10 = (com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel.loginBySimpleAccount.1)continuation0;
            int v = loginSimpleAccountViewModel$loginBySimpleAccount$10.label;
            if((v & 0x80000000) == 0) {
                loginSimpleAccountViewModel$loginBySimpleAccount$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.loginBySimpleAccount(null, this);
                    }
                };
            }
            else {
                loginSimpleAccountViewModel$loginBySimpleAccount$10.label = v ^ 0x80000000;
            }
        }
        else {
            loginSimpleAccountViewModel$loginBySimpleAccount$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.loginBySimpleAccount(null, this);
                }
            };
        }
        Object object0 = loginSimpleAccountViewModel$loginBySimpleAccount$10.result;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(loginSimpleAccountViewModel$loginBySimpleAccount$10.label) {
            case 0: {
                d5.n.D(object0);
                if(((e0)this.loginUseCase).m()) {
                    this.sendUiEvent(ClosePage.INSTANCE);
                    return h0;
                }
                loginSimpleAccountViewModel$loginBySimpleAccount$10.L$0 = s;
                loginSimpleAccountViewModel$loginBySimpleAccount$10.label = 1;
                t1 t10 = this.simpleAccountUseCase.a.a;
                Account account0 = t10.b(s);
                if(account0 == null) {
                    object0 = null;
                }
                else {
                    q1 q10 = new q1(t10, account0, null);
                    object0 = BuildersKt.withContext(t10.a, q10, loginSimpleAccountViewModel$loginBySimpleAccount$10);
                }
                if(object0 == a0) {
                    return a0;
                }
                goto label_31;
            }
            case 1: {
                s = (String)loginSimpleAccountViewModel$loginBySimpleAccount$10.L$0;
                d5.n.D(object0);
            label_31:
                if(((String)object0) != null) {
                    loginSimpleAccountViewModel$loginBySimpleAccount$10.L$0 = null;
                    loginSimpleAccountViewModel$loginBySimpleAccount$10.L$1 = null;
                    loginSimpleAccountViewModel$loginBySimpleAccount$10.label = 2;
                    object0 = ((e0)this.loginUseCase).y(s, ((String)object0), loginSimpleAccountViewModel$loginBySimpleAccount$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_41;
                }
                break;
            }
            case 2: {
                String s1 = (String)loginSimpleAccountViewModel$loginBySimpleAccount$10.L$1;
                String s2 = (String)loginSimpleAccountViewModel$loginBySimpleAccount$10.L$0;
                d5.n.D(object0);
            label_41:
                if(((i0)object0) instanceof h0) {
                    ToastManager.showShort(0x7F13060F);  // string:melon_login_ok "멜론 로그인되었습니다."
                    this.sendUiEvent(ExecuteReturnUri.INSTANCE);
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }

    @Nullable
    public final Object removeSimpleAccount(@NotNull String s, @NotNull Continuation continuation0) {
        String s1;
        Object object1;
        L0 l00;
        com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel.removeSimpleAccount.1 loginSimpleAccountViewModel$removeSimpleAccount$10;
        if(continuation0 instanceof com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel.removeSimpleAccount.1) {
            loginSimpleAccountViewModel$removeSimpleAccount$10 = (com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel.removeSimpleAccount.1)continuation0;
            int v = loginSimpleAccountViewModel$removeSimpleAccount$10.label;
            if((v & 0x80000000) == 0) {
                loginSimpleAccountViewModel$removeSimpleAccount$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.removeSimpleAccount(null, this);
                    }
                };
            }
            else {
                loginSimpleAccountViewModel$removeSimpleAccount$10.label = v ^ 0x80000000;
            }
        }
        else {
            loginSimpleAccountViewModel$removeSimpleAccount$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.removeSimpleAccount(null, this);
                }
            };
        }
        Object object0 = loginSimpleAccountViewModel$removeSimpleAccount$10.result;
        ne.a a0 = ne.a.a;
        switch(loginSimpleAccountViewModel$removeSimpleAccount$10.label) {
            case 0: {
                d5.n.D(object0);
                l00 = this.dialogManage;
                if(l00 == null) {
                    loginSimpleAccountViewModel$removeSimpleAccount$10.L$0 = null;
                    loginSimpleAccountViewModel$removeSimpleAccount$10.L$1 = null;
                    loginSimpleAccountViewModel$removeSimpleAccount$10.L$2 = null;
                    loginSimpleAccountViewModel$removeSimpleAccount$10.I$0 = 0;
                    loginSimpleAccountViewModel$removeSimpleAccount$10.I$1 = 0;
                    loginSimpleAccountViewModel$removeSimpleAccount$10.label = 1;
                    object0 = this.simpleAccountRemoveExplicitlyUseCase.a(s, loginSimpleAccountViewModel$removeSimpleAccount$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    LogU.debug$default(this.log, androidx.appcompat.app.o.p("removeSimpleAccount useCase result=", ((Boolean)object0).booleanValue()), null, false, 6, null);
                }
                else {
                    ((b)l00).a("LoginSimpleAccountViewModel true", true);
                    try {
                        loginSimpleAccountViewModel$removeSimpleAccount$10.L$0 = null;
                        loginSimpleAccountViewModel$removeSimpleAccount$10.L$1 = l00;
                        loginSimpleAccountViewModel$removeSimpleAccount$10.L$2 = "LoginSimpleAccountViewModel";
                        loginSimpleAccountViewModel$removeSimpleAccount$10.I$0 = 0;
                        loginSimpleAccountViewModel$removeSimpleAccount$10.I$1 = 0;
                        loginSimpleAccountViewModel$removeSimpleAccount$10.label = 2;
                        object1 = this.simpleAccountRemoveExplicitlyUseCase.a(s, loginSimpleAccountViewModel$removeSimpleAccount$10);
                    }
                    catch(Throwable throwable0) {
                        s1 = "LoginSimpleAccountViewModel";
                        Y.v(s1, " false", l00, false);
                        throw throwable0;
                    }
                    if(object1 == a0) {
                        return a0;
                    }
                    try {
                        s1 = "LoginSimpleAccountViewModel";
                        LogU.debug$default(this.log, "removeSimpleAccount useCase result=" + ((Boolean)object1).booleanValue(), null, false, 6, null);
                        ((Boolean)object1).getClass();
                    }
                    catch(Throwable throwable0) {
                        Y.v(s1, " false", l00, false);
                        throw throwable0;
                    }
                    Y.v("LoginSimpleAccountViewModel", " false", l00, false);
                }
                break;
            }
            case 1: {
                String s2 = (String)loginSimpleAccountViewModel$removeSimpleAccount$10.L$2;
                L0 l01 = (L0)loginSimpleAccountViewModel$removeSimpleAccount$10.L$1;
                String s3 = (String)loginSimpleAccountViewModel$removeSimpleAccount$10.L$0;
                d5.n.D(object0);
                LogU.debug$default(this.log, androidx.appcompat.app.o.p("removeSimpleAccount useCase result=", ((Boolean)object0).booleanValue()), null, false, 6, null);
                break;
            }
            case 2: {
                s1 = (String)loginSimpleAccountViewModel$removeSimpleAccount$10.L$2;
                l00 = (L0)loginSimpleAccountViewModel$removeSimpleAccount$10.L$1;
                String s4 = (String)loginSimpleAccountViewModel$removeSimpleAccount$10.L$0;
                try {
                    d5.n.D(object0);
                    LogU.debug$default(this.log, "removeSimpleAccount useCase result=" + ((Boolean)object0).booleanValue(), null, false, 6, null);
                    ((Boolean)object0).getClass();
                }
                catch(Throwable throwable0) {
                    Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                Y.v(s1, " false", l00, false);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        int v1 = this.simpleAccountUseCase.a.a.a().size();
        LogU.debug$default(this.log, "removeSimpleAccount accountCountAfterRemove=" + v1, null, false, 6, null);
        if(v1 == 0) {
            this.sendUiEvent(ClosePage.INSTANCE);
        }
        return H.a;
    }
}

