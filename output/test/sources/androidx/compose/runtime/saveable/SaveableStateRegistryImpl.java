package androidx.compose.runtime.saveable;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SaveableStateRegistry.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u001c\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0003H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eH\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/saveable/SaveableStateRegistryImpl;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "restored", "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "", "valueProviders", "", "Lkotlin/Function0;", "value", "consumeRestored", "key", "performSave", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class SaveableStateRegistryImpl implements SaveableStateRegistry {
    private final Function1<Object, Boolean> canBeSaved;
    private final Map<String, List<Object>> restored;
    private final Map<String, List<Function0<Object>>> valueProviders;

    public SaveableStateRegistryImpl(Map<String, ? extends List<? extends Object>> map, Function1<Object, Boolean> canBeSaved) {
        LinkedHashMap mutableMap;
        Intrinsics.checkNotNullParameter(canBeSaved, "canBeSaved");
        this.canBeSaved = canBeSaved;
        this.restored = (map == null || (mutableMap = MapsKt.toMutableMap(map)) == null) ? new LinkedHashMap() : mutableMap;
        this.valueProviders = new LinkedHashMap();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.canBeSaved.invoke(value).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object consumeRestored(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        List list = this.restored.remove(key);
        if (list != null && (!list.isEmpty())) {
            if (list.size() > 1) {
                this.restored.put(key, list.subList(1, list.size()));
            }
            return list.get(0);
        }
        return null;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public SaveableStateRegistry.Entry registerProvider(final String key, final Function0<? extends Object> valueProvider) {
        List<Function0<Object>> list;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(valueProvider, "valueProvider");
        if (!(!StringsKt.isBlank(key))) {
            throw new IllegalArgumentException("Registered key is empty or blank".toString());
        }
        Map $this$getOrPut$iv = this.valueProviders;
        List<Function0<Object>> list2 = $this$getOrPut$iv.get(key);
        if (list2 == null) {
            list = new ArrayList();
            $this$getOrPut$iv.put(key, list);
        } else {
            list = list2;
        }
        list.add(valueProvider);
        return new SaveableStateRegistry.Entry() { // from class: androidx.compose.runtime.saveable.SaveableStateRegistryImpl$registerProvider$3
            @Override // androidx.compose.runtime.saveable.SaveableStateRegistry.Entry
            public void unregister() {
                Map map;
                Map map2;
                map = SaveableStateRegistryImpl.this.valueProviders;
                List list3 = (List) map.remove(key);
                if (list3 != null) {
                    list3.remove(valueProvider);
                }
                if (list3 != null && (!list3.isEmpty())) {
                    map2 = SaveableStateRegistryImpl.this.valueProviders;
                    map2.put(key, list3);
                }
            }
        };
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Map<String, List<Object>> performSave() {
        Map map = MapsKt.toMutableMap(this.restored);
        Map $this$forEach$iv = this.valueProviders;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            String key = element$iv.getKey();
            List<Function0<Object>> list = element$iv.getValue();
            if (list.size() == 1) {
                Object value = list.get(0).invoke();
                if (value == null) {
                    continue;
                } else {
                    if (!canBeSaved(value)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    map.put(key, CollectionsKt.arrayListOf(value));
                }
            } else {
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    int index = i;
                    Object value2 = list.get(index).invoke();
                    if (value2 != null && !canBeSaved(value2)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    arrayList.add(value2);
                }
                map.put(key, arrayList);
            }
        }
        return map;
    }
}
