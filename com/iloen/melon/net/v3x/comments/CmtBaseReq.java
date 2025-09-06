package com.iloen.melon.net.v3x.comments;

import A8.M;
import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.utils.log.LogU;
import java.lang.reflect.Field;
import java.util.List;

public abstract class CmtBaseReq extends HttpRequest {
    public interface Params {
        public interface InnerParams {
        }

    }

    private static final boolean DEBUG = false;
    private static final String TAG = "CmtBaseReq";

    static {
        CmtBaseReq.DEBUG = false;
    }

    public CmtBaseReq(Context context0, int v, Class class0, Params cmtBaseReq$Params0) {
        super(context0, v, class0);
        this.addParam("pocId", MelonAppBase.instance.getMelonCpId());
        this.addParam("cmtPocType", "m.app");
        this.addParamInfoValue(cmtBaseReq$Params0);
    }

    public void addArrayListValue(String s, List list0) {
        if(TextUtils.isEmpty(s)) {
            LogU.e("CmtBaseReq", "addArrayListValue() invalid key");
            return;
        }
        if(list0 == null) {
            LogU.w("CmtBaseReq", "addArrayListValue() invalid values");
            return;
        }
        int v = 0;
        for(Object object0: list0) {
            if(String.class.isInstance(object0)) {
                this.addParam(s + "[" + v + "]", ((String)object0));
            }
            else if(InnerParams.class.isInstance(object0)) {
                Field[] arr_field = object0.getClass().getDeclaredFields();
                if(arr_field != null) {
                    int v1 = arr_field.length;
                    int v2 = 0;
                    while(v2 < v1) {
                        Field field0 = arr_field[v2];
                        String s1 = field0.getName();
                        StringBuilder stringBuilder0 = new StringBuilder(s);
                        stringBuilder0.append("[");
                        stringBuilder0.append(v);
                        stringBuilder0.append("][");
                        stringBuilder0.append(field0.getName());
                        stringBuilder0.append("]");
                        try {
                            Object object1 = field0.get(object0);
                            if(CmtBaseReq.DEBUG) {
                                LogU.d("CmtBaseReq", "addArrayListValue() name:" + s1 + " ,value:" + object1);
                            }
                            this.addParam(stringBuilder0.toString(), object1);
                            goto label_38;
                        }
                        catch(IllegalArgumentException illegalArgumentException0) {
                        }
                        catch(IllegalAccessException illegalAccessException0) {
                            goto label_37;
                        }
                        LogU.e("CmtBaseReq", "addArrayListValue() " + illegalArgumentException0.toString());
                        goto label_38;
                    label_37:
                        LogU.e("CmtBaseReq", "addArrayListValue() " + illegalAccessException0.toString());
                    label_38:
                        ++v2;
                    }
                }
            }
            else {
                LogU.e("CmtBaseReq", "addArrayListValue() unknown value");
            }
            ++v;
        }
    }

    public void addParam(String s, Object object0) {
        if(object0 != null) {
            if(List.class.isInstance(object0)) {
                this.addArrayListValue(s, ((List)object0));
                return;
            }
            if(String.class.isInstance(object0)) {
                if(!TextUtils.isEmpty(((String)object0))) {
                    this.addParam(s, ((String)object0));
                }
            }
            else if(Integer.class.isInstance(object0)) {
                int v = (int)(((Integer)object0));
                if(v != -1) {
                    this.addParam(s, String.valueOf(v));
                }
            }
            else {
                if(!Long.class.isInstance(object0)) {
                    goto label_18;
                }
                long v1 = (long)(((Long)object0));
                if(v1 != -1L) {
                    this.addParam(s, String.valueOf(v1));
                    return;
                label_18:
                    if(Boolean.class.isInstance(object0)) {
                        this.addParam(s, String.valueOf(((Boolean)object0).booleanValue()));
                        return;
                    }
                    LogU.e("CmtBaseReq", "addParam() unknown value:" + object0.toString());
                }
            }
        }
    }

    public void addParamInfoValue(Params cmtBaseReq$Params0) {
        if(cmtBaseReq$Params0 == null) {
            LogU.w("CmtBaseReq", "addParamInfoValue() invalid params");
            return;
        }
        Field[] arr_field = cmtBaseReq$Params0.getClass().getDeclaredFields();
        if(arr_field != null) {
            for(int v = 0; v < arr_field.length; ++v) {
                Field field0 = arr_field[v];
                try {
                    this.addParam(field0.getName(), field0.get(cmtBaseReq$Params0));
                }
                catch(IllegalArgumentException illegalArgumentException0) {
                    LogU.e("CmtBaseReq", "addParamInfoValue() IllegalArgumentException:" + illegalArgumentException0.toString());
                }
                catch(IllegalAccessException illegalAccessException0) {
                    LogU.e("CmtBaseReq", "addParamInfoValue() IllegalAccessException:" + illegalAccessException0.toString());
                }
            }
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.m;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

