package com.tievd.baselib.db;

import java.lang.System;

/**
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 *
 * https://www.jianshu.com/p/df805b6c2531
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\'\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H%J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H%J\u0017\u0010\u0015\u001a\u00028\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H%\u00a2\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H%J\u001a\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H%J;\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00182\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001b\"\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r\u00a2\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H%J;\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00182\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001b\"\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r\u00a2\u0006\u0002\u0010\u001eJ\u0015\u0010 \u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\"\u00a2\u0006\u0002\u0010#J\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018J\u001d\u0010%\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\u0002\u0010&J\u0015\u0010\'\u001a\u00020\"2\u0006\u0010\n\u001a\u00028\u0000H\'\u00a2\u0006\u0002\u0010(J#\u0010\'\u001a\u0004\u0018\u00010)2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001b\"\u00028\u0000H\'\u00a2\u0006\u0002\u0010+J\u001c\u0010\'\u001a\b\u0012\u0004\u0012\u00020\"0\u00182\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\'J\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005J!\u0010/\u001a\u00020\r2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001b\"\u00028\u0000H\'\u00a2\u0006\u0002\u00100R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u00061"}, d2 = {"Lcom/tievd/baselib/db/BaseDao;", "T", "", "()V", "tableName", "", "getTableName", "()Ljava/lang/String;", "delete", "", "obj", "(Ljava/lang/Object;)V", "deleteAll", "", "deleteByParams", "params", "value", "doDeleteAll", "query", "Landroidx/sqlite/db/SupportSQLiteQuery;", "doDeleteByParams", "doFind", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Ljava/lang/Object;", "doFindAll", "", "doQueryByLimit", "string", "", "limit", "offset", "([Ljava/lang/String;II)Ljava/util/List;", "doQueryByOrder", "find", "id", "", "(J)Ljava/lang/Object;", "findAll", "findByParams", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "insert", "(Ljava/lang/Object;)J", "", "objs", "([Ljava/lang/Object;)[J", "list", "queryLikeParams", "searchMsg", "update", "([Ljava/lang/Object;)I", "baselib_debug"})
public abstract class BaseDao<T extends java.lang.Object> {
    
    public BaseDao() {
        super();
    }
    
    /**
     * 添加单个对象
     */
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract long insert(T obj);
    
    /**
     * 添加数组对象数据
     */
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract long[] insert(@org.jetbrains.annotations.NotNull()
    T... objs);
    
    /**
     * 添加对象集合
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.util.List<java.lang.Long> insert(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> list);
    
    /**
     * 根据对象中的主键删除（主键是自动增长的，无需手动赋值）
     */
    @androidx.room.Delete()
    public abstract void delete(T obj);
    
    /**
     * 根据对象中的主键更新（主键是自动增长的，无需手动赋值）
     */
    @androidx.room.Update()
    public abstract int update(@org.jetbrains.annotations.NotNull()
    T... obj);
    
    public final int deleteAll() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<T> findAll() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final T find(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final T findByParams(@org.jetbrains.annotations.NotNull()
    java.lang.String params, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    /**
     * 模糊查询
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<T> queryLikeParams(@org.jetbrains.annotations.NotNull()
    java.lang.String params, @org.jetbrains.annotations.NotNull()
    java.lang.String searchMsg) {
        return null;
    }
    
    /**
     * [params] 列名
     * [value] 列的值
     */
    public final int deleteByParams(@org.jetbrains.annotations.NotNull()
    java.lang.String params, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return 0;
    }
    
    /**
     * 分页查询，支持传入多个字段，但必须要按照顺序传入
     * key = value，key = value 的形式，一一对应（可以使用 stringbuilder 去构造一下，这里就不演示了）
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<T> doQueryByLimit(@org.jetbrains.annotations.NotNull()
    java.lang.String[] string, int limit, int offset) {
        return null;
    }
    
    /**
     * 降序分页查询
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<T> doQueryByOrder(@org.jetbrains.annotations.NotNull()
    java.lang.String[] string, int limit, int offset) {
        return null;
    }
    
    private final java.lang.String getTableName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.RawQuery()
    protected abstract java.util.List<T> doFindAll(@org.jetbrains.annotations.Nullable()
    androidx.sqlite.db.SupportSQLiteQuery query);
    
    @androidx.room.RawQuery()
    protected abstract T doFind(@org.jetbrains.annotations.Nullable()
    androidx.sqlite.db.SupportSQLiteQuery query);
    
    @androidx.room.RawQuery()
    protected abstract int doDeleteAll(@org.jetbrains.annotations.Nullable()
    androidx.sqlite.db.SupportSQLiteQuery query);
    
    @androidx.room.RawQuery()
    protected abstract int doDeleteByParams(@org.jetbrains.annotations.Nullable()
    androidx.sqlite.db.SupportSQLiteQuery query);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.RawQuery()
    protected abstract java.util.List<T> doQueryByLimit(@org.jetbrains.annotations.Nullable()
    androidx.sqlite.db.SupportSQLiteQuery query);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.RawQuery()
    protected abstract java.util.List<T> doQueryByOrder(@org.jetbrains.annotations.Nullable()
    androidx.sqlite.db.SupportSQLiteQuery query);
}