package com.iloen.melon.net.v4x.common;

import java.lang.reflect.Field;
import java.util.List;

public class ToStringUtil {
    public static String toStringFields(Object object0) {
        if(object0 == null) {
            return "";
        }
        Field[] arr_field = object0.getClass().getFields();
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(object0.getClass().getSimpleName());
        stringBuilder0.append(":");
        for(int v = 0; v < arr_field.length; ++v) {
            Field field0 = arr_field[v];
            try {
                Object object1 = field0.get(object0);
                if(object1 != null) {
                    if(List.class.isInstance(object1)) {
                        for(Object object2: ((List)object1)) {
                            stringBuilder0.append("\n");
                            stringBuilder0.append(object2.toString());
                        }
                    }
                    else if(Boolean.TYPE.isInstance(object1) || (Boolean.class.isInstance(object1) || Integer.TYPE.isInstance(object1) || Integer.class.isInstance(object1) || Long.TYPE.isInstance(object1) || Long.class.isInstance(object1) || Double.TYPE.isInstance(object1) || Double.class.isInstance(object1))) {
                        stringBuilder0.append(" ");
                        stringBuilder0.append(field0.getName());
                        stringBuilder0.append("[");
                        stringBuilder0.append(object1);
                        stringBuilder0.append("]");
                    }
                    else if(String.class.isInstance(object1)) {
                        stringBuilder0.append(" ");
                        stringBuilder0.append(field0.getName());
                        stringBuilder0.append("[");
                        stringBuilder0.append(object1);
                        stringBuilder0.append("]");
                    }
                    else {
                        stringBuilder0.append("\n");
                        stringBuilder0.append(object1.toString());
                    }
                }
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
            }
        }
        return stringBuilder0.toString();
    }
}

