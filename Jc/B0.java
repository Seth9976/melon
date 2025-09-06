package Jc;

import java.util.ArrayList;

public final class b0 extends e0 {
    public final ArrayList a;

    public b0(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof b0) {
                ((b0)object0).getClass();
                return this.a.equals(((b0)object0).a);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() + 0x95CB;
    }

    @Override
    public final String toString() {
        return "TicketUiState(isViewAll=false, ticketList=" + this.a + ")";
    }
}

