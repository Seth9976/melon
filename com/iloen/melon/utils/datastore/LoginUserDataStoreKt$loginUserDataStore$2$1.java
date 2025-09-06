package com.iloen.melon.utils.datastore;

import com.iloen.melon.LoginUser;
import com.iloen.melon.utils.cipher.SimpleCrypto;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import k8.s;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import o2.f;
import oe.e;
import oe.i;
import we.o;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lo2/f;", "sharedPrefs", "Lcom/iloen/melon/LoginUser;", "currentData", "<anonymous>", "(Lo2/f;Lcom/iloen/melon/LoginUser;)Lcom/iloen/melon/LoginUser;"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.utils.datastore.LoginUserDataStoreKt$loginUserDataStore$2$1", f = "LoginUserDataStore.kt", l = {}, m = "invokeSuspend")
final class LoginUserDataStoreKt.loginUserDataStore.2.1 extends i implements o {
    public f r;
    public LoginUser w;

    @Override  // we.o
    public Object invoke(Object object0, Object object1, Object object2) {
        return this.invoke(((f)object0), ((LoginUser)object1), ((Continuation)object2));
    }

    public final Object invoke(f f0, LoginUser loginUser0, Continuation continuation0) {
        LoginUserDataStoreKt.loginUserDataStore.2.1 loginUserDataStoreKt$loginUserDataStore$2$10 = new LoginUserDataStoreKt.loginUserDataStore.2.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        loginUserDataStoreKt$loginUserDataStore$2$10.r = f0;
        loginUserDataStoreKt$loginUserDataStore$2$10.w = loginUser0;
        return loginUserDataStoreKt$loginUserDataStore$2$10.invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        LoginUser loginUser1;
        f f0 = this.r;
        LoginUser loginUser0 = this.w;
        n.D(object0);
        LogU.Companion.d("loginUserDataStore", "SharedPreferencesMigration() " + f0);
        f0.a("MelonId");
        String s = f0.a.getString("MelonId", "");
        f0.a("AuthTokenV2");
        String s1 = null;
        String s2 = f0.a.getString("AuthTokenV2", null);
        if(s2 != null) {
            if(s2.length() <= 0) {
                s2 = null;
            }
            if(s2 != null) {
                s1 = SimpleCrypto.decrypt(s2);
            }
        }
        if(s == null || s.length() == 0 || s1 == null || s1.length() == 0) {
            loginUser1 = LoginUserPreferencesSerializer.INSTANCE.createDefaultValue();
        }
        else {
            s s3 = (s)loginUser0.toBuilder();
            s3.d();
            ((LoginUser)s3.b).setUserId(s);
            s3.d();
            ((LoginUser)s3.b).setToken(s1);
            loginUser1 = (LoginUser)s3.a();
        }
        q.d(loginUser1);
        return loginUser1;
    }
}

