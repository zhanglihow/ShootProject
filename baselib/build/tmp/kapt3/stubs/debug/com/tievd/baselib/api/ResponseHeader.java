package com.tievd.baselib.api;

import java.lang.System;

/**
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tievd/baselib/api/ResponseHeader;", "", "requestNo", "", "execStatus", "retCode", "retMsg", "requestAppName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExecStatus", "()Ljava/lang/String;", "setExecStatus", "(Ljava/lang/String;)V", "getRequestAppName", "setRequestAppName", "getRequestNo", "setRequestNo", "getRetCode", "setRetCode", "getRetMsg", "setRetMsg", "baselib_debug"})
public final class ResponseHeader {
    
    /**
     * 请求流⽔号，回带
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String requestNo;
    
    /**
     * ocr识别状态，success：成功，failed：失败
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String execStatus;
    
    /**
     * 返回信息
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String retCode;
    
    /**
     * 反馈信息
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String retMsg;
    
    /**
     * 请求⽅⾃定义应⽤名称
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String requestAppName;
    
    public ResponseHeader() {
        super();
    }
    
    public ResponseHeader(@org.jetbrains.annotations.NotNull()
    java.lang.String requestNo, @org.jetbrains.annotations.NotNull()
    java.lang.String execStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String retCode, @org.jetbrains.annotations.NotNull()
    java.lang.String retMsg, @org.jetbrains.annotations.NotNull()
    java.lang.String requestAppName) {
        super();
    }
    
    /**
     * 请求流⽔号，回带
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRequestNo() {
        return null;
    }
    
    /**
     * 请求流⽔号，回带
     */
    public final void setRequestNo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * ocr识别状态，success：成功，failed：失败
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExecStatus() {
        return null;
    }
    
    /**
     * ocr识别状态，success：成功，failed：失败
     */
    public final void setExecStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 返回信息
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRetCode() {
        return null;
    }
    
    /**
     * 返回信息
     */
    public final void setRetCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 反馈信息
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRetMsg() {
        return null;
    }
    
    /**
     * 反馈信息
     */
    public final void setRetMsg(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 请求⽅⾃定义应⽤名称
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRequestAppName() {
        return null;
    }
    
    /**
     * 请求⽅⾃定义应⽤名称
     */
    public final void setRequestAppName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
}