package com.sp.shared.utils;

import java.util.ArrayList;

public final class CustomUtils<T> {
    public ArrayList<T> iterableToArrayList(Iterable<T> iterator){
        ArrayList<T> arrayList = new ArrayList<>();
        iterator.forEach(arrayList::add);
        return arrayList;
    }
}
