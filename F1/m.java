package f1;

import B0.b;
import W.x;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;

public class m implements InputConnection {
    public final b a;
    public x b;

    public m(x x0, b b0) {
        this.a = b0;
        this.b = x0;
    }

    public final void a(x x0) {
        x0.closeConnection();
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        return this.b == null ? false : this.b.beginBatchEdit();
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean clearMetaKeyStates(int v) {
        return this.b == null ? false : this.b.clearMetaKeyStates(v);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final void closeConnection() {
        x x0 = this.b;
        if(x0 != null) {
            this.a(x0);
            this.b = null;
            this.a.invoke(this);
        }
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean commitCompletion(CompletionInfo completionInfo0) {
        return this.b == null ? false : this.b.commitCompletion(completionInfo0);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo0, int v, Bundle bundle0) {
        return this.b == null ? false : this.b.commitContent(inputContentInfo0, v, bundle0);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean commitCorrection(CorrectionInfo correctionInfo0) {
        return this.b == null ? false : this.b.commitCorrection(correctionInfo0);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence0, int v) {
        return this.b == null ? false : this.b.commitText(charSequence0, v);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int v, int v1) {
        return this.b == null ? false : this.b.deleteSurroundingText(v, v1);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int v, int v1) {
        return this.b == null ? false : this.b.deleteSurroundingTextInCodePoints(v, v1);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean endBatchEdit() {
        return this.b == null ? false : this.b.b();
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean finishComposingText() {
        return this.b == null ? false : this.b.finishComposingText();
    }

    @Override  // android.view.inputmethod.InputConnection
    public final int getCursorCapsMode(int v) {
        return this.b == null ? 0 : this.b.getCursorCapsMode(v);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest0, int v) {
        return this.b == null ? null : this.b.getExtractedText(extractedTextRequest0, v);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        return null;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final CharSequence getSelectedText(int v) {
        return this.b == null ? null : this.b.getSelectedText(v);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final CharSequence getTextAfterCursor(int v, int v1) {
        return this.b == null ? null : this.b.getTextAfterCursor(v, v1);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final CharSequence getTextBeforeCursor(int v, int v1) {
        return this.b == null ? null : this.b.getTextBeforeCursor(v, v1);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean performContextMenuAction(int v) {
        return this.b == null ? false : this.b.performContextMenuAction(v);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int v) {
        return this.b == null ? false : this.b.performEditorAction(v);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String s, Bundle bundle0) {
        return this.b == null ? false : this.b.performPrivateCommand(s, bundle0);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean reportFullscreenMode(boolean z) {
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean requestCursorUpdates(int v) {
        return this.b == null ? false : this.b.requestCursorUpdates(v);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent keyEvent0) {
        return this.b == null ? false : this.b.sendKeyEvent(keyEvent0);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int v, int v1) {
        return this.b == null ? false : this.b.setComposingRegion(v, v1);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence0, int v) {
        return this.b == null ? false : this.b.setComposingText(charSequence0, v);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean setSelection(int v, int v1) {
        return this.b == null ? false : this.b.setSelection(v, v1);
    }
}

