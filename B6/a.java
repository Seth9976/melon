package B6;

import android.os.Handler.Callback;
import android.os.Message;

public final class a implements Handler.Callback {
    public final int a;

    public a(int v) {
        this.a = v;
        super();
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        if(this.a != 0) {
            message0.obj.getClass();
            throw new ClassCastException();
        }
        switch(message0.what) {
            case 0: {
                message0.obj.getClass();
                throw new ClassCastException();
            }
            case 1: {
                message0.obj.getClass();
                throw new ClassCastException();
            }
            default: {
                return false;
            }
        }
    }
}

