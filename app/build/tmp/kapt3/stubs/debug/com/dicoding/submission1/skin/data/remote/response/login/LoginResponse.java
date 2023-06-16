package com.dicoding.submission1.skin.data.remote.response.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0007H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/dicoding/submission1/skin/data/remote/response/login/LoginResponse;", "", "error", "", "loginResult", "Lcom/dicoding/submission1/skin/data/remote/response/login/LoginResult;", "message", "", "(ZLcom/dicoding/submission1/skin/data/remote/response/login/LoginResult;Ljava/lang/String;)V", "getError", "()Z", "getLoginResult", "()Lcom/dicoding/submission1/skin/data/remote/response/login/LoginResult;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class LoginResponse {
    @com.google.gson.annotations.SerializedName(value = "error")
    private final boolean error = false;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "loginResult")
    private final com.dicoding.submission1.skin.data.remote.response.login.LoginResult loginResult = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "message")
    private final java.lang.String message = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.dicoding.submission1.skin.data.remote.response.login.LoginResponse copy(boolean error, @org.jetbrains.annotations.NotNull()
    com.dicoding.submission1.skin.data.remote.response.login.LoginResult loginResult, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public LoginResponse(boolean error, @org.jetbrains.annotations.NotNull()
    com.dicoding.submission1.skin.data.remote.response.login.LoginResult loginResult, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getError() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dicoding.submission1.skin.data.remote.response.login.LoginResult component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dicoding.submission1.skin.data.remote.response.login.LoginResult getLoginResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessage() {
        return null;
    }
}