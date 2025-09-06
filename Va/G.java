package va;

import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.model.AccessTokenInfo;
import com.kakao.sdk.user.model.User;
import ie.H;
import ie.p;
import kotlinx.coroutines.CancellableContinuationImpl;
import we.n;

public final class g implements n {
    public final int a;
    public final CancellableContinuationImpl b;

    public g(CancellableContinuationImpl cancellableContinuationImpl0, int v) {
        this.a = v;
        this.b = cancellableContinuationImpl0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                CancellableContinuationImpl cancellableContinuationImpl1 = this.b;
                if(((Throwable)object1) != null) {
                    cancellableContinuationImpl1.resumeWith(d5.n.t(((Throwable)object1)));
                    return H.a;
                }
                if(((AccessTokenInfo)object0) == null) {
                    cancellableContinuationImpl1.resumeWith(d5.n.t(new Exception("tokenInfo is null")));
                    return H.a;
                }
                cancellableContinuationImpl1.resumeWith(new p(((AccessTokenInfo)object0)));
                return H.a;
            }
            case 1: {
                CancellableContinuationImpl cancellableContinuationImpl2 = this.b;
                if(((Throwable)object1) != null) {
                    cancellableContinuationImpl2.resumeWith(d5.n.t(((Throwable)object1)));
                    return H.a;
                }
                if(((OAuthToken)object0) == null) {
                    cancellableContinuationImpl2.resumeWith(d5.n.t(new Exception("token is null")));
                    return H.a;
                }
                cancellableContinuationImpl2.resumeWith(((OAuthToken)object0));
                return H.a;
            }
            case 2: {
                Long long1 = ((User)object0) == null ? null : ((User)object0).getId();
                CancellableContinuationImpl cancellableContinuationImpl3 = this.b;
                if(((Throwable)object1) != null) {
                    cancellableContinuationImpl3.resumeWith(d5.n.t(((Throwable)object1)));
                    return H.a;
                }
                if(long1 == null) {
                    cancellableContinuationImpl3.resumeWith(d5.n.t(new Exception("userId is null")));
                    return H.a;
                }
                cancellableContinuationImpl3.resumeWith(long1);
                return H.a;
            }
            case 3: {
                CancellableContinuationImpl cancellableContinuationImpl4 = this.b;
                if(((Throwable)object1) != null) {
                    cancellableContinuationImpl4.resumeWith(d5.n.t(((Throwable)object1)));
                    return H.a;
                }
                if(((OAuthToken)object0) == null) {
                    cancellableContinuationImpl4.resumeWith(d5.n.t(new Exception("token is null")));
                    return H.a;
                }
                cancellableContinuationImpl4.resumeWith(((OAuthToken)object0));
                return H.a;
            }
            default: {
                Long long0 = ((User)object0) == null ? null : ((User)object0).getId();
                CancellableContinuationImpl cancellableContinuationImpl0 = this.b;
                if(((Throwable)object1) != null) {
                    cancellableContinuationImpl0.resumeWith(d5.n.t(((Throwable)object1)));
                    return H.a;
                }
                if(long0 == null) {
                    cancellableContinuationImpl0.resumeWith(d5.n.t(new Exception("userId is null")));
                    return H.a;
                }
                cancellableContinuationImpl0.resumeWith(long0);
                return H.a;
            }
        }
    }
}

