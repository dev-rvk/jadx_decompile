package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGridLaneInfo.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0002J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u000fJ\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "", "()V", "anchor", "", "lanes", "", "spannedItems", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$SpannedItem;", "assignedToLane", "", "itemIndex", "targetLane", "ensureCapacity", "", "capacity", "newOffset", "ensureValidIndex", "requestedIndex", "findNextItemIndex", "findPreviousItemIndex", "getGaps", "getLane", "lowerBound", "reset", "setGaps", "gaps", "setLane", "lane", "upperBound", "Companion", "SpannedItem", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridLaneInfo {
    public static final int FullSpan = -2;
    private static final int MaxCapacity = 131072;
    public static final int Unset = -1;
    private int anchor;
    private int[] lanes = new int[16];
    private final ArrayDeque<SpannedItem> spannedItems = new ArrayDeque<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyStaggeredGridLaneInfo.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$SpannedItem;", "", "index", "", "gaps", "", "(I[I)V", "getGaps", "()[I", "setGaps", "([I)V", "getIndex", "()I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class SpannedItem {
        private int[] gaps;
        private final int index;

        public SpannedItem(int index, int[] gaps) {
            Intrinsics.checkNotNullParameter(gaps, "gaps");
            this.index = index;
            this.gaps = gaps;
        }

        public final int[] getGaps() {
            return this.gaps;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setGaps(int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.gaps = iArr;
        }
    }

    public final void setLane(int itemIndex, int lane) {
        if (!(itemIndex >= 0)) {
            throw new IllegalArgumentException("Negative lanes are not supported".toString());
        }
        ensureValidIndex(itemIndex);
        this.lanes[itemIndex - this.anchor] = lane + 1;
    }

    public final int getLane(int itemIndex) {
        if (itemIndex < getAnchor() || itemIndex >= upperBound()) {
            return -1;
        }
        return this.lanes[itemIndex - this.anchor] - 1;
    }

    public final boolean assignedToLane(int itemIndex, int targetLane) {
        int lane = getLane(itemIndex);
        return lane == targetLane || lane == -1 || lane == -2;
    }

    public final int upperBound() {
        return this.anchor + this.lanes.length;
    }

    /* renamed from: lowerBound, reason: from getter */
    public final int getAnchor() {
        return this.anchor;
    }

    public final void reset() {
        ArraysKt.fill$default(this.lanes, 0, 0, 0, 6, (Object) null);
        this.spannedItems.clear();
    }

    public final int findPreviousItemIndex(int itemIndex, int targetLane) {
        for (int i = itemIndex - 1; -1 < i; i--) {
            if (assignedToLane(i, targetLane)) {
                return i;
            }
        }
        return -1;
    }

    public final int findNextItemIndex(int itemIndex, int targetLane) {
        int upperBound = upperBound();
        for (int i = itemIndex + 1; i < upperBound; i++) {
            if (assignedToLane(i, targetLane)) {
                return i;
            }
        }
        int i2 = upperBound();
        return i2;
    }

    public final void ensureValidIndex(int requestedIndex) {
        int requestedCapacity = requestedIndex - this.anchor;
        if (requestedCapacity >= 0 && requestedCapacity < 131072) {
            ensureCapacity$default(this, requestedCapacity + 1, 0, 2, null);
        } else {
            int oldAnchor = this.anchor;
            this.anchor = Math.max(requestedIndex - (this.lanes.length / 2), 0);
            int delta = this.anchor - oldAnchor;
            if (delta >= 0) {
                if (delta < this.lanes.length) {
                    ArraysKt.copyInto(this.lanes, this.lanes, 0, delta, this.lanes.length);
                }
                ArraysKt.fill(this.lanes, 0, Math.max(0, this.lanes.length - delta), this.lanes.length);
            } else {
                int delta2 = -delta;
                if (this.lanes.length + delta2 < 131072) {
                    ensureCapacity(this.lanes.length + delta2 + 1, delta2);
                } else {
                    if (delta2 < this.lanes.length) {
                        ArraysKt.copyInto(this.lanes, this.lanes, delta2, 0, this.lanes.length - delta2);
                    }
                    ArraysKt.fill(this.lanes, 0, 0, Math.min(this.lanes.length, delta2));
                }
            }
        }
        while ((!this.spannedItems.isEmpty()) && this.spannedItems.first().getIndex() < getAnchor()) {
            this.spannedItems.removeFirst();
        }
        while ((!this.spannedItems.isEmpty()) && this.spannedItems.last().getIndex() > upperBound()) {
            this.spannedItems.removeLast();
        }
    }

    public final void setGaps(int itemIndex, int[] gaps) {
        List $this$binarySearchBy_u24default$iv = this.spannedItems;
        final Comparable key$iv = Integer.valueOf(itemIndex);
        int toIndex$iv = $this$binarySearchBy_u24default$iv.size();
        int foundIndex = CollectionsKt.binarySearch($this$binarySearchBy_u24default$iv, 0, toIndex$iv, new Function1<SpannedItem, Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo$setGaps$$inlined$binarySearchBy$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(LazyStaggeredGridLaneInfo.SpannedItem spannedItem) {
                LazyStaggeredGridLaneInfo.SpannedItem it = spannedItem;
                return Integer.valueOf(ComparisonsKt.compareValues(Integer.valueOf(it.getIndex()), key$iv));
            }
        });
        if (foundIndex < 0) {
            if (gaps == null) {
                return;
            }
            int insertionIndex = -(foundIndex + 1);
            this.spannedItems.add(insertionIndex, new SpannedItem(itemIndex, gaps));
            return;
        }
        if (gaps == null) {
            this.spannedItems.remove(foundIndex);
        } else {
            this.spannedItems.get(foundIndex).setGaps(gaps);
        }
    }

    public final int[] getGaps(int itemIndex) {
        List $this$binarySearchBy_u24default$iv = this.spannedItems;
        final Comparable key$iv = Integer.valueOf(itemIndex);
        int toIndex$iv = $this$binarySearchBy_u24default$iv.size();
        int foundIndex = CollectionsKt.binarySearch($this$binarySearchBy_u24default$iv, 0, toIndex$iv, new Function1<SpannedItem, Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo$getGaps$$inlined$binarySearchBy$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(LazyStaggeredGridLaneInfo.SpannedItem spannedItem) {
                LazyStaggeredGridLaneInfo.SpannedItem it = spannedItem;
                return Integer.valueOf(ComparisonsKt.compareValues(Integer.valueOf(it.getIndex()), key$iv));
            }
        });
        SpannedItem spannedItem = (SpannedItem) CollectionsKt.getOrNull(this.spannedItems, foundIndex);
        if (spannedItem != null) {
            return spannedItem.getGaps();
        }
        return null;
    }

    static /* synthetic */ void ensureCapacity$default(LazyStaggeredGridLaneInfo lazyStaggeredGridLaneInfo, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        lazyStaggeredGridLaneInfo.ensureCapacity(i, i2);
    }

    private final void ensureCapacity(int capacity, int newOffset) {
        if (!(capacity <= 131072)) {
            throw new IllegalArgumentException(("Requested item capacity " + capacity + " is larger than max supported: 131072!").toString());
        }
        if (this.lanes.length < capacity) {
            int newSize = this.lanes.length;
            while (newSize < capacity) {
                newSize *= 2;
            }
            this.lanes = ArraysKt.copyInto$default(this.lanes, new int[newSize], newOffset, 0, 0, 12, (Object) null);
        }
    }
}
