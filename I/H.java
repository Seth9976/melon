package I;

import R.d;
import h7.u0;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineName;

public final class h {
    public final d a;
    public final CancellableContinuationImpl b;

    public h(d d0, CancellableContinuationImpl cancellableContinuationImpl0) {
        this.a = d0;
        this.b = cancellableContinuationImpl0;
    }

    @Override
    public final String toString() {
        String s2;
        CancellableContinuationImpl cancellableContinuationImpl0 = this.b;
        CoroutineName coroutineName0 = (CoroutineName)cancellableContinuationImpl0.getContext().get(CoroutineName.Key);
        String s = coroutineName0 == null ? null : coroutineName0.getName();
        StringBuilder stringBuilder0 = new StringBuilder("Request@");
        u0.l(16);
        String s1 = Integer.toString(this.hashCode(), 16);
        q.f(s1, "toString(...)");
        stringBuilder0.append(s1);
        if(s == null) {
            s2 = "(";
        }
        else {
            s2 = "[" + s + "](";
            if(s2 == null) {
                s2 = "(";
            }
        }
        stringBuilder0.append(s2);
        stringBuilder0.append("currentBounds()=");
        stringBuilder0.append(this.a.invoke());
        stringBuilder0.append(", continuation=");
        stringBuilder0.append(cancellableContinuationImpl0);
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

