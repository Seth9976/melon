package com.iloen.melon.net;

import S7.b;
import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.utils.log.LogU;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class ResponseParser {
    private static boolean DEBUG_ERROR = false;
    private static boolean DEBUG_PARSER = false;
    private static final String TAG = "ResponseParser";
    private final Map mCache;

    public ResponseParser() {
        this.mCache = new HashMap();
    }

    private void clearCachedFieldMap() {
        for(Object object0: this.mCache.entrySet()) {
            Object object1 = ((Map.Entry)object0).getKey();
            ((Map)this.mCache.get(object1)).clear();
        }
        this.mCache.clear();
    }

    public Object fromJson(String s, Class class0) {
        if(class0 != null && !TextUtils.isEmpty(s)) {
            try {
                return class0.cast(this.parse(class0, new JSONObject(s)));
            }
            finally {
                this.clearCachedFieldMap();
            }
        }
        LogU.e("ResponseParser", "fromJson() invalid parameter");
        return null;
    }

    private Object getBooleanValue(Object object0) {
        if(object0 == null) {
            return null;
        }
        if(!Boolean.TYPE.isInstance(object0) && !Boolean.class.isInstance(object0)) {
            if(String.class.isInstance(object0)) {
                return Boolean.valueOf(ProtocolUtils.parseBoolean(((String)object0)));
            }
            LogU.w("ResponseParser", "getBooleanValue() unrecognized value: " + object0);
            return false;
        }
        return object0;
    }

    private Field getCachedField(String s, String s1) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("ResponseParser", "getCachedField() invalid cache key :" + s);
            return null;
        }
        if(TextUtils.isEmpty(s1)) {
            LogU.w("ResponseParser", "getCachedField() invalid field key :" + s1);
            return null;
        }
        if(this.mCache.containsKey(s)) {
            Map map0 = (Map)this.mCache.get(s);
            return map0.containsKey(s1) ? ((Field)map0.get(s1)) : null;
        }
        return null;
    }

    private String getClassName(Class class0, String s, Object object0) {
        String s1 = this.makeCachedFieldMap(class0);
        String s2 = null;
        if(TextUtils.isEmpty(s1)) {
            LogU.w("ResponseParser", "getClassName() failed to find cache key > key:" + s + ", value:" + object0 + " [" + class0 + "]");
            return null;
        }
        Field field0 = this.getCachedField(s1, s);
        if(field0 != null) {
            if(JSONArray.class.isInstance(object0)) {
                String s3 = field0.getGenericType().toString();
                s2 = s3.substring(s3.indexOf("<") + 1, s3.indexOf(">"));
            }
            else {
                s2 = field0.getType().getName();
            }
        }
        if(s2 == null) {
            LogU.w("ResponseParser", "getClassName() failed to find class name > key:" + s + ", value:" + object0 + " [" + class0 + "]");
        }
        return s2;
    }

    private Object getDoubleValue(Object object0) {
        if(object0 == null) {
            return null;
        }
        if(!Double.TYPE.isInstance(object0) && !Double.class.isInstance(object0)) {
            if(String.class.isInstance(object0)) {
                String s = (String)object0;
                try {
                    return Double.valueOf(s);
                }
                catch(NumberFormatException numberFormatException0) {
                    LogU.w("ResponseParser", "getDoubleValue() unrecognized value: " + numberFormatException0.toString());
                }
            }
            return 4.900000E-324;
        }
        return object0;
    }

    private Object getIntValue(Object object0) {
        if(object0 == null) {
            return null;
        }
        if(!Integer.TYPE.isInstance(object0) && !Integer.class.isInstance(object0)) {
            if(String.class.isInstance(object0)) {
                String s = (String)object0;
                try {
                    return Integer.valueOf(s);
                }
                catch(NumberFormatException numberFormatException0) {
                    LogU.w("ResponseParser", "getIntValue() unrecognized value: " + numberFormatException0.toString());
                }
            }
            return 0x80000000;
        }
        return object0;
    }

    private Object getLongValue(Object object0) {
        if(object0 == null) {
            return null;
        }
        if(!Long.TYPE.isInstance(object0) && !Long.class.isInstance(object0)) {
            if(String.class.isInstance(object0)) {
                String s = (String)object0;
                try {
                    return Long.valueOf(s);
                }
                catch(NumberFormatException numberFormatException0) {
                    LogU.w("ResponseParser", "getLongValue() unrecognized value: " + numberFormatException0.toString());
                }
            }
            return 0x8000000000000000L;
        }
        return object0;
    }

    private String makeCachedFieldMap(Class class0) {
        if(class0 == null) {
            LogU.e("ResponseParser", "makeCachedFieldMap() invalid class");
            return null;
        }
        String s = class0.getName();
        if(!this.mCache.containsKey(s)) {
            HashMap hashMap0 = new HashMap();
            Field[] arr_field = class0.getFields();
            for(int v = 0; v < arr_field.length; ++v) {
                Field field0 = arr_field[v];
                hashMap0.put((field0.isAnnotationPresent(b.class) ? ((b)field0.getAnnotation(b.class)).value() : field0.getName()), field0);
            }
            this.mCache.put(s, hashMap0);
        }
        return s;
    }

    private Object parse(Class class0, JSONObject jSONObject0) {
        Class class3;
        Object object0;
        if(class0 != null && jSONObject0 != null) {
            try {
                object0 = class0.newInstance();
                if(ResponseParser.DEBUG_PARSER) {
                    LogU.v("ResponseParser", "parse() CLASS :" + class0.getName());
                }
            }
            catch(InstantiationException instantiationException0) {
                LogU.e("ResponseParser", "parse() " + instantiationException0.toString());
                return null;
            }
            catch(IllegalAccessException illegalAccessException0) {
                LogU.e("ResponseParser", "parse() " + illegalAccessException0.toString());
                return null;
            }
            if(jSONObject0.length() == 0) {
                LogU.w("ResponseParser", "parse() JSONObject is empty [" + class0 + "]");
                return object0;
            }
            Iterator iterator0 = jSONObject0.keys();
            if(iterator0 != null) {
                while(iterator0.hasNext()) {
                    Object object1 = iterator0.next();
                    String s = (String)object1;
                    if(jSONObject0.isNull(s)) {
                        this.setJSONNull(object0, s);
                    }
                    else {
                        Object object2 = jSONObject0.opt(s);
                        if(object2 == null) {
                            LogU.w("ResponseParser", "parse() value is null > key:" + s);
                        }
                        else {
                            if(!Integer.class.isInstance(object2) && !Long.class.isInstance(object2) && !Double.class.isInstance(object2) && !Boolean.class.isInstance(object2) && !String.class.isInstance(object2)) {
                                Class class1 = JSONObject.class;
                                Class class2 = JSONArray.class;
                                if(!class1.isInstance(object2) && !class2.isInstance(object2)) {
                                    continue;
                                }
                                String s1 = this.getClassName(class0, s, object2);
                                if(s1 == null) {
                                    continue;
                                    try {
                                    label_32:
                                        class3 = Class.forName(s1);
                                    }
                                    catch(ClassNotFoundException classNotFoundException0) {
                                        LogU.e("ResponseParser", "parse() " + classNotFoundException0.toString());
                                        continue;
                                    }
                                    if(class1.isInstance(object2)) {
                                        this.setJSONValue(object0, s, this.parseJSONObject(class3, object2));
                                    }
                                    else {
                                        if(!class2.isInstance(object2)) {
                                            continue;
                                        }
                                        this.setJSONValue(object0, s, this.parseJSONArray(class3, object2));
                                    }
                                    continue;
                                }
                                else {
                                    goto label_32;
                                }
                            }
                            this.setJSONValue(object0, s, object2);
                        }
                    }
                }
            }
            return object0;
        }
        LogU.w("ResponseParser", "parse() invalid parameter");
        return null;
    }

    private List parseJSONArray(Class class0, Object object0) {
        if(class0 == null) {
            LogU.e("ResponseParser", "parseJSONArray() invalid class instance");
            return null;
        }
        if(object0 == null) {
            LogU.d("ResponseParser", "parseJSONArray() empty value");
            return null;
        }
        if(ResponseParser.DEBUG_PARSER) {
            LogU.v("ResponseParser", "parseJSONArray() CLASS NAME :" + class0);
        }
        JSONArray jSONArray0 = (JSONArray)object0;
        List list0 = new ArrayList();
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            try {
                Object object1 = this.parse(class0, jSONArray0.getJSONObject(v1));
                if(object1 == null) {
                    LogU.e("ResponseParser", "parseJSONArray() invalid object");
                }
                else {
                    ((ArrayList)list0).add(object1);
                }
            }
            catch(Exception exception0) {
                Z.v(exception0, new StringBuilder("parseJSONArray() "), "ResponseParser");
            }
        }
        return list0;
    }

    private Object parseJSONObject(Class class0, Object object0) {
        if(class0 == null) {
            LogU.e("ResponseParser", "parseJSONObject() invalid class instance");
            return null;
        }
        if(object0 == null) {
            LogU.d("ResponseParser", "parseJSONObject() empty value");
            return null;
        }
        try {
            if(ResponseParser.DEBUG_PARSER) {
                LogU.v("ResponseParser", "parseJSONObject() CLASS :" + class0);
            }
            return this.parse(class0, ((JSONObject)object0));
        }
        catch(Exception exception0) {
        }
        Z.v(exception0, new StringBuilder("parseJSONObject() "), "ResponseParser");
        return null;
    }

    private void setFieldJSONValue(Object object0, String s, Object object1) {
        try {
            this.setValue(object0, s, object1);
        }
        catch(Exception exception0) {
            LogU.w("ResponseParser", "setFieldJSONValue() " + exception0.toString() + " [" + object0.getClass() + "] (key:" + s + ", value:" + object1 + ")");
        }
    }

    private void setJSONNull(Object object0, String s) {
        if(object0 != null && s != null) {
            try {
                this.setValue(object0, s, null);
            }
            catch(NoSuchFieldException noSuchFieldException0) {
                if(ResponseParser.DEBUG_ERROR) {
                    LogU.w("ResponseParser", "setJSONNull() " + noSuchFieldException0.toString());
                }
                this.setFieldJSONValue(object0, s, "");
            }
            catch(Exception exception0) {
                Z.v(exception0, new StringBuilder("setJSONNull() "), "ResponseParser");
            }
            return;
        }
        LogU.w("ResponseParser", "setJSONNull() invalid parameter");
    }

    private void setJSONValue(Object object0, String s, Object object1) {
        if(object0 != null && s != null) {
            if(object1 == null) {
                LogU.d("ResponseParser", "setJSONValue() empty value > key:" + s);
                return;
            }
            try {
                this.setValue(object0, s, object1);
            }
            catch(NoSuchFieldException noSuchFieldException0) {
                if(ResponseParser.DEBUG_ERROR) {
                    LogU.w("ResponseParser", "setJSONValue() " + noSuchFieldException0.toString() + " [" + object0.getClass() + "] (key:" + s + ", value:" + object1 + ")");
                }
                this.setFieldJSONValue(object0, s, object1);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                if(ResponseParser.DEBUG_ERROR) {
                    LogU.w("ResponseParser", "setJSONValue() " + illegalArgumentException0.toString() + " [" + object0.getClass() + "] (key:" + s + ", value:" + object1 + ")");
                }
                if(!Boolean.TYPE.isInstance(object1) && !Boolean.class.isInstance(object1)) {
                    if(!Integer.TYPE.isInstance(object1) && !Integer.class.isInstance(object1)) {
                        if(!Long.TYPE.isInstance(object1) && !Long.class.isInstance(object1)) {
                            if(!Double.TYPE.isInstance(object1) && !Double.class.isInstance(object1)) {
                                if(JSONObject.class.isInstance(object1)) {
                                    LogU.w("ResponseParser", "setJSONValue() JSONObject > key:" + s + ", value:" + object1);
                                    String s1 = object1.toString();
                                    this.setFieldJSONValue(object0, s, (TextUtils.isEmpty(s1) ? "" : String.valueOf(s1)));
                                    return;
                                }
                                return;
                            }
                            this.setFieldJSONValue(object0, s, String.valueOf(((double)(((Double)object1)))));
                            return;
                        }
                        this.setFieldJSONValue(object0, s, String.valueOf(((long)(((Long)object1)))));
                        return;
                    }
                    this.setFieldJSONValue(object0, s, String.valueOf(((int)(((Integer)object1)))));
                    return;
                }
                this.setFieldJSONValue(object0, s, String.valueOf(((Boolean)object1).booleanValue()));
            }
            catch(Exception exception0) {
                Z.v(exception0, new StringBuilder("setJSONValue() "), "ResponseParser");
            }
            return;
        }
        LogU.w("ResponseParser", "setJSONValue() invalid parameter");
    }

    private void setValue(Object object0, String s, Object object1) {
        Class class0;
        String s1 = this.makeCachedFieldMap(object0.getClass());
        if(TextUtils.isEmpty(s1)) {
            LogU.w("ResponseParser", "setValue() failed to find cache key > key:" + s + ", value:" + object1 + " [" + object0.getClass() + "]");
            return;
        }
        Field field0 = this.getCachedField(s1, s);
        if(field0 == null) {
            class0 = null;
        }
        else {
            field0.setAccessible(true);
            class0 = field0.getType();
        }
        if(class0 != null && field0 != null) {
            if(ResponseParser.DEBUG_PARSER) {
                LogU.d("ResponseParser", "setValue() fieldType:" + class0 + " >> key:" + s + ", value:" + object1 + " [" + object0.getClass() + "]");
            }
            Class class1 = Double.class;
            Class class2 = Double.TYPE;
            Class class3 = Long.class;
            Class class4 = Long.TYPE;
            Class class5 = Integer.class;
            Class class6 = Integer.TYPE;
            Class class7 = Boolean.class;
            Class class8 = Boolean.TYPE;
            if(String.class.isAssignableFrom(class0)) {
                if(!class8.isInstance(object1) && !class7.isInstance(object1)) {
                    if(!class6.isInstance(object1) && !class5.isInstance(object1)) {
                        if(!class4.isInstance(object1) && !class3.isInstance(object1)) {
                            if(!class2.isInstance(object1) && !class1.isInstance(object1)) {
                                field0.set(object0, object1);
                                return;
                            }
                            field0.set(object0, String.valueOf(((double)(((Double)object1)))));
                            return;
                        }
                        field0.set(object0, String.valueOf(((long)(((Long)object1)))));
                        return;
                    }
                    field0.set(object0, String.valueOf(((int)(((Integer)object1)))));
                    return;
                }
                field0.set(object0, String.valueOf(((Boolean)object1).booleanValue()));
                return;
            }
            if(!class8.isAssignableFrom(class0) && !class7.isAssignableFrom(class0)) {
                if(!class6.isAssignableFrom(class0) && !class5.isAssignableFrom(class0)) {
                    if(!class4.isAssignableFrom(class0) && !class3.isAssignableFrom(class0)) {
                        if(!class2.isAssignableFrom(class0) && !class1.isAssignableFrom(class0)) {
                            field0.set(object0, object1);
                            return;
                        }
                        field0.set(object0, this.getDoubleValue(object1));
                        return;
                    }
                    field0.set(object0, this.getLongValue(object1));
                    return;
                }
                field0.set(object0, this.getIntValue(object1));
                return;
            }
            field0.set(object0, this.getBooleanValue(object1));
            return;
        }
        LogU.w("ResponseParser", "setValue() failed to find field > key:" + s + ", value:" + object1 + " [" + object0.getClass() + "]");
    }
}

