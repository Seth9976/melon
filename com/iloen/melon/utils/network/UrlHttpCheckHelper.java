package com.iloen.melon.utils.network;

import Tf.v;
import a7.c;
import android.util.Log;
import b3.Z;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.task.ReportService.Reporter;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;
import we.n;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/utils/network/UrlHttpCheckHelper;", "", "", "url", "Lie/H;", "checkUrl", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class UrlHttpCheckHelper {
    public static final int $stable;
    @NotNull
    public static final UrlHttpCheckHelper INSTANCE;
    public static final LogU a;
    public static final CoroutineScope b;

    static {
        UrlHttpCheckHelper.INSTANCE = new UrlHttpCheckHelper();  // 初始化器: Ljava/lang/Object;-><init>()V
        LogU logU0 = Z.g("UrlHttpCheckHelper", false);
        logU0.setCategory(Category.Http);
        UrlHttpCheckHelper.a = logU0;
        UrlHttpCheckHelper.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        UrlHttpCheckHelper.$stable = 8;
    }

    public final void checkUrl(@Nullable String s) {
        if(s != null) {
            Log.d("UrlHttpCheckHelper", "checkUrl: " + s);
            if(v.r0(s, "http://", false) && !ServerPhase.isSandBox) {
                String s1 = e.c(ServerPhase.INSTANCE.getDomainPrefix(), "_url_is_started_with_http://:", s);
                LogU.info$default(UrlHttpCheckHelper.a, s1, null, false, 6, null);
                com.iloen.melon.utils.network.UrlHttpCheckHelper.checkUrl.1 urlHttpCheckHelper$checkUrl$10 = new n(null) {
                    public final String r;

                    {
                        this.r = s;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.utils.network.UrlHttpCheckHelper.checkUrl.1(this.r, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.network.UrlHttpCheckHelper.checkUrl.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        String s = this.r;
                        d5.n.D(object0);
                        try {
                            throw new Exception(s);
                        }
                        catch(Exception exception0) {
                            c.a().c(exception0);
                            Reporter.createReporter(Type.HTTP, LogLevel.INFO).setMessage(s).report();
                            return H.a;
                        }
                    }
                };
                BuildersKt__Builders_commonKt.launch$default(UrlHttpCheckHelper.b, null, null, urlHttpCheckHelper$checkUrl$10, 3, null);
            }
        }
    }
}

