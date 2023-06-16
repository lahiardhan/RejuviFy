package com.dicoding.submission1.skin.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006J\"\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ*\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\n0\u00062\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\n0\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/dicoding/submission1/skin/data/AnalysisRepository;", "", "apiService", "Lcom/dicoding/submission1/skin/data/remote/network/ApiService;", "(Lcom/dicoding/submission1/skin/data/remote/network/ApiService;)V", "getStories", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagingData;", "error/NonExistentClass", "getStoriesWithLocation", "Lcom/dicoding/submission1/skin/data/Result;", "Lcom/dicoding/submission1/skin/data/remote/response/analysis/AnalysisResponse;", "postLogin", "Lcom/dicoding/submission1/skin/data/remote/response/login/LoginResponse;", "email", "", "password", "postSignUp", "Lcom/dicoding/submission1/skin/data/remote/response/signup/SignUpResponse;", "name", "postStory", "Lcom/dicoding/submission1/skin/data/remote/response/analysis/PostAnalysisResponse;", "file", "Lokhttp3/MultipartBody$Part;", "description", "Lokhttp3/RequestBody;", "app_debug"})
public final class AnalysisRepository {
    private final com.dicoding.submission1.skin.data.remote.network.ApiService apiService = null;
    
    public AnalysisRepository(@org.jetbrains.annotations.NotNull()
    com.dicoding.submission1.skin.data.remote.network.ApiService apiService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<error.NonExistentClass>> getStories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.dicoding.submission1.skin.data.Result<com.dicoding.submission1.skin.data.remote.response.analysis.AnalysisResponse>> getStoriesWithLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.dicoding.submission1.skin.data.Result<com.dicoding.submission1.skin.data.remote.response.analysis.PostAnalysisResponse>> postStory(@org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody description) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.dicoding.submission1.skin.data.Result<com.dicoding.submission1.skin.data.remote.response.signup.SignUpResponse>> postSignUp(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.dicoding.submission1.skin.data.Result<com.dicoding.submission1.skin.data.remote.response.login.LoginResponse>> postLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
}