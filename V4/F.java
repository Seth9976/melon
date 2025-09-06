package v4;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import d5.n;
import java.util.ArrayList;
import je.w;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class f {
    public f(TopicsManager topicsManager0) {
    }

    public GetTopicsRequest a() {
        q.g(null, "request");
        throw null;
    }

    public c b(GetTopicsResponse getTopicsResponse0) {
        q.g(getTopicsResponse0, "response");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: getTopicsResponse0.getTopics()) {
            arrayList0.add(new d(((Topic)object0).getTaxonomyVersion(), ((Topic)object0).getModelVersion(), ((Topic)object0).getTopicId()));
        }
        return new c(w.a, arrayList0);
    }

    @Nullable
    public Object c(@NotNull b b0, @NotNull Continuation continuation0) {
        return f.d(this, b0, continuation0);
    }

    public static Object d(f f0, b b0, Continuation continuation0) {
        e e0;
        if(continuation0 instanceof e) {
            e0 = (e)continuation0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new e(f0, continuation0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new e(f0, continuation0);
        }
        Object object0 = e0.r;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                f0.a();
                throw null;
            }
            case 1: {
                n.D(object0);
                GetTopicsResponse getTopicsResponse0 = (GetTopicsResponse)object0;
                throw null;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

