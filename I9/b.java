package i9;

import java.util.HashMap;
import java.util.Iterator;

public abstract class b {
    public static final HashMap a;

    static {
        HashMap hashMap0 = new HashMap();
        b.a = hashMap0;
        HashMap hashMap1 = new HashMap();
        hashMap0.put("DCF", new a());  // 初始化器: Ljava/lang/Object;-><init>()V
        hashMap1.put("audio/x-mp3", 1);
        StringBuilder stringBuilder0 = new StringBuilder();
        Iterator iterator0 = hashMap0.keySet().iterator();
        while(iterator0.hasNext()) {
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append(',');
            }
            Object object0 = iterator0.next();
            stringBuilder0.append(((String)object0));
        }
    }
}

