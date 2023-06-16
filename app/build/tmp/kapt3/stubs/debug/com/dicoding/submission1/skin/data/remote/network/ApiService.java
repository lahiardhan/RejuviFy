package com.dicoding.submission1.skin.data.remote.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\t\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J/\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J%\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/dicoding/submission1/skin/data/remote/network/ApiService;", "", "getStories", "Lcom/dicoding/submission1/skin/data/remote/response/analysis/AnalysisResponse;", "page", "", "size", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStoriesWithLocation", "location", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postLogin", "Lcom/dicoding/submission1/skin/data/remote/response/login/LoginResponse;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postSignUp", "Lcom/dicoding/submission1/skin/data/remote/response/signup/SignUpResponse;", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postStory", "Lcom/dicoding/submission1/skin/data/remote/response/analysis/PostAnalysisResponse;", "file", "Lokhttp3/MultipartBody$Part;", "description", "Lokhttp3/RequestBody;", "(Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "register")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object postSignUp(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "name")
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "email")
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "password")
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dicoding.submission1.skin.data.remote.response.signup.SignUpResponse> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "login")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object postLogin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "email")
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "password")
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dicoding.submission1.skin.data.remote.response.login.LoginResponse> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "stories")
    public abstract java.lang.Object getStories(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dicoding.submission1.skin.data.remote.response.analysis.AnalysisResponse> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "stories")
    public abstract java.lang.Object getStoriesWithLocation(@retrofit2.http.Query(value = "location")
    int location, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dicoding.submission1.skin.data.remote.response.analysis.AnalysisResponse> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "stories")
    @retrofit2.http.Multipart()
    public abstract java.lang.Object postStory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "description")
    okhttp3.RequestBody description, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dicoding.submission1.skin.data.remote.response.analysis.PostAnalysisResponse> continuation);
}