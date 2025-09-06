package w0;

import r0.p;

public final class r extends p implements q {
    public w0.p a;

    @Override  // r0.p
    public final void onAttach() {
        super.onAttach();
        this.a.a.b(this);
    }

    @Override  // r0.p
    public final void onDetach() {
        this.a.a.j(this);
        super.onDetach();
    }
}

