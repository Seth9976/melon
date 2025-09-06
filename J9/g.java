package J9;

import U4.x;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class g {
    public final String a;
    public final String b;

    public g(String s, String s1) {
        q.g(s, "serviceToken");
        q.g(s1, "chatId");
        super();
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof g) {
                ((g)object0).getClass();
                return q.b(this.a, ((g)object0).a) && q.b(this.b, ((g)object0).b);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + x.b(0x3886ADF3, 0xE1781, this.a);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("LeonChatConnectInfo(channelId=melon, contentId=null, serviceToken=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", profileUrl=null, iconUrl=null, metaData=null, chatId=");
        return o.r(stringBuilder0, this.b, ')');
    }
}

