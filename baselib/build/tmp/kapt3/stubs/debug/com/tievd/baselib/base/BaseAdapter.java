package com.tievd.baselib.base;

import java.lang.System;

/**
 * 通过传入ViewBinding，不再需要写具体xml资源，省略onBindViewHolder中findviewById
 * 注意点：item的最外层布局高度要设为wrap_content，
 * 如果item有需求要设置为固定宽高，可以在子类的convert方法里，通过代码设置
 *
 * isHorizontal 横向传true
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B/\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00028\u00010\tj\b\u0012\u0004\u0012\u00028\u0001`\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ%\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\u0011H&\u00a2\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0011H\u0016J\u001a\u0010\u000f\u001a\u00020\u00122\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u0011H\u0016R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000eR\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00028\u00010\tj\b\u0012\u0004\u0012\u00028\u0001`\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006("}, d2 = {"Lcom/tievd/baselib/base/BaseAdapter;", "VB", "Landroidx/viewbinding/ViewBinding;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tievd/baselib/base/BaseViewHolder;", "mContext", "Landroid/app/Activity;", "listDatas", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isHorizontal", "", "(Landroid/app/Activity;Ljava/util/ArrayList;Z)V", "()Z", "itemClick", "Lkotlin/Function1;", "", "", "itemLongClick", "getListDatas", "()Ljava/util/ArrayList;", "setListDatas", "(Ljava/util/ArrayList;)V", "getMContext", "()Landroid/app/Activity;", "setMContext", "(Landroid/app/Activity;)V", "convert", "v", "t", "position", "(Landroidx/viewbinding/ViewBinding;Ljava/lang/Object;I)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "baselib_debug"})
public abstract class BaseAdapter<VB extends androidx.viewbinding.ViewBinding, T extends java.lang.Object> extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tievd.baselib.base.BaseViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private android.app.Activity mContext;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<T> listDatas;
    private final boolean isHorizontal = false;
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> itemClick;
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> itemLongClick;
    
    public BaseAdapter(@org.jetbrains.annotations.NotNull()
    android.app.Activity mContext, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<T> listDatas, boolean isHorizontal) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.app.Activity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<T> getListDatas() {
        return null;
    }
    
    public final void setListDatas(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<T> p0) {
    }
    
    public final boolean isHorizontal() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.tievd.baselib.base.BaseViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.tievd.baselib.base.BaseViewHolder holder, int position) {
    }
    
    public abstract void convert(@org.jetbrains.annotations.NotNull()
    VB v, T t, int position);
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void itemClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> itemClick) {
    }
    
    public final void itemLongClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> itemLongClick) {
    }
}