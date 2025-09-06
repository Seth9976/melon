package R8;

import R6.c;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.MelonError;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.DeviceInformDeviceCheckReq.CallerType;
import com.iloen.melon.net.v4x.request.DeviceInformDeviceCheckReq;
import com.iloen.melon.net.v4x.response.DeviceInformDeviceCheckRes.Response;
import com.iloen.melon.net.v4x.response.DeviceInformDeviceCheckRes;
import com.iloen.melon.utils.log.DcfLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import k8.t;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import va.e0;
import va.o;
import x8.b;

public class y extends b {
    public final List a;
    public final CallerType b;
    public ArrayList c;
    public int d;
    public boolean e;
    public Exception f;

    public y(List list0, CallerType deviceInformDeviceCheckReq$CallerType0) {
        q.g(list0, "listFiles");
        q.g(deviceInformDeviceCheckReq$CallerType0, "callerType");
        super();
        this.a = list0;
        this.b = deviceInformDeviceCheckReq$CallerType0;
    }

    @Override  // x8.f
    public Object backgroundWork(Object object0, Continuation continuation0) {
        return this.backgroundWork(((Void)object0), continuation0);
    }

    public Object backgroundWork(Void void0, Continuation continuation0) {
        LogU.Companion.d("TaskExtendDueDate", "runDeviceInformDeviceInformDeviceCheck()");
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        DeviceInformDeviceCheckReq deviceInformDeviceCheckReq0 = new DeviceInformDeviceCheckReq(Y.a(MelonAppBase.Companion), this.b);
        try {
            HttpResponse httpResponse0 = RequestBuilder.newInstance(deviceInformDeviceCheckReq0).tag("TaskExtendDueDate").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
            q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.DeviceInformDeviceCheckRes");
            if(((DeviceInformDeviceCheckRes)httpResponse0).isSuccessful()) {
                Response deviceInformDeviceCheckRes$Response0 = ((DeviceInformDeviceCheckRes)httpResponse0).response;
                if(deviceInformDeviceCheckRes$Response0 == null) {
                    this.f = new p(MelonError.from(((DeviceInformDeviceCheckRes)httpResponse0)).getMessage());
                }
                else {
                    boolean z = ProtocolUtils.parseBoolean(deviceInformDeviceCheckRes$Response0.deviceYn);
                    this.e = z;
                    ((e0)o.a()).A(z);
                }
            }
            else {
                this.f = new p(MelonError.from(((DeviceInformDeviceCheckRes)httpResponse0)).getMessage());
            }
        }
        catch(VolleyError volleyError0) {
            this.f = new p(volleyError0.getMessage());
            DcfLog.w("TaskExtendDueDate", volleyError0.getMessage());
        }
        if(this.e) {
            goto label_24;
        }
        MelonAppBase.Companion.getClass();
        if(!t.a().isAppForeground()) {
            ToastManager.show(0x7F1302DC);  // string:dcf_need_register_for_toast "DCF 파일 기간 연장을 위해서 기기등록 후 이용해주세요."
            return H.a;
        label_24:
            this.c = u.a(this.a, this);
            try {
                l l0 = c.g();
                ArrayList arrayList0 = this.c;
                l0.getClass();
                int v = l.e(arrayList0);
                this.d = v;
                LogU.Companion.d("TaskExtendDueDate", "backgroundWork() count of deduct : " + v);
                return H.a;
            }
            catch(VolleyError volleyError1) {
                this.f = volleyError1;
                DcfLog.w("TaskExtendDueDate", volleyError1.toString());
            }
        }
        return H.a;
    }
}

