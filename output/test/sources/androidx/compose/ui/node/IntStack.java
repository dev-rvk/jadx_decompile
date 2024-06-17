package androidx.compose.ui.node;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyersDiff.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010\u0011\u001a\u00020\fJ \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0006\u0010\u0016\u001a\u00020\u0003J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J&\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003J \u0010 \u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0006\u0010!\u001a\u00020\u0018J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/ui/node/IntStack;", "", "initialCapacity", "", "(I)V", "lastIndex", "size", "getSize", "()I", "stack", "", "compareDiagonal", "", "a", "b", "get", "index", "isNotEmpty", "partition", "start", "end", "elSize", "pop", "pushDiagonal", "", "x", "y", "pushRange", "oldStart", "oldEnd", "newStart", "newEnd", "quickSort", "sortDiagonals", "swapDiagonal", "i", "j", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IntStack {
    private int lastIndex;
    private int[] stack;

    public IntStack(int initialCapacity) {
        this.stack = new int[initialCapacity];
    }

    public final int get(int index) {
        return this.stack[index];
    }

    /* renamed from: getSize, reason: from getter */
    public final int getLastIndex() {
        return this.lastIndex;
    }

    public final void pushRange(int oldStart, int oldEnd, int newStart, int newEnd) {
        int i = this.lastIndex;
        if (i + 4 >= this.stack.length) {
            int[] copyOf = Arrays.copyOf(this.stack, this.stack.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.stack = copyOf;
        }
        int[] stack = this.stack;
        stack[i + 0] = oldStart;
        stack[i + 1] = oldEnd;
        stack[i + 2] = newStart;
        stack[i + 3] = newEnd;
        this.lastIndex = i + 4;
    }

    public final void pushDiagonal(int x, int y, int size) {
        int i = this.lastIndex;
        if (i + 3 >= this.stack.length) {
            int[] copyOf = Arrays.copyOf(this.stack, this.stack.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.stack = copyOf;
        }
        int[] stack = this.stack;
        stack[i + 0] = x + size;
        stack[i + 1] = y + size;
        stack[i + 2] = size;
        this.lastIndex = i + 3;
    }

    public final int pop() {
        this.lastIndex--;
        return this.stack[this.lastIndex];
    }

    public final boolean isNotEmpty() {
        return this.lastIndex != 0;
    }

    public final void sortDiagonals() {
        int i = this.lastIndex;
        if (!(i % 3 == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (i > 3) {
            quickSort(0, i - 3, 3);
        }
    }

    private final void quickSort(int start, int end, int elSize) {
        if (start < end) {
            int i = partition(start, end, elSize);
            quickSort(start, i - elSize, elSize);
            quickSort(i + elSize, end, elSize);
        }
    }

    private final int partition(int start, int end, int elSize) {
        int i = start - elSize;
        int j = start;
        while (j < end) {
            if (compareDiagonal(j, end)) {
                i += elSize;
                swapDiagonal(i, j);
            }
            j += elSize;
        }
        swapDiagonal(i + elSize, end);
        return i + elSize;
    }

    private final void swapDiagonal(int i, int j) {
        int[] stack = this.stack;
        MyersDiffKt.swap(stack, i, j);
        MyersDiffKt.swap(stack, i + 1, j + 1);
        MyersDiffKt.swap(stack, i + 2, j + 2);
    }

    private final boolean compareDiagonal(int a, int b) {
        int[] stack = this.stack;
        int a0 = stack[a];
        int b0 = stack[b];
        return a0 < b0 || (a0 == b0 && stack[a + 1] <= stack[b + 1]);
    }
}
