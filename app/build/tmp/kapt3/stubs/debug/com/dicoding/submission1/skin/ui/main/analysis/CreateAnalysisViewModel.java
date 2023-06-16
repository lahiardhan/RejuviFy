package com.dicoding.submission1.skin.ui.main.analysis;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/dicoding/submission1/skin/ui/main/analysis/CreateAnalysisViewModel;", "Landroidx/lifecycle/ViewModel;", "storyRepository", "Lcom/dicoding/submission1/skin/data/AnalysisRepository;", "(Lcom/dicoding/submission1/skin/data/AnalysisRepository;)V", "postStory", "Landroidx/lifecycle/LiveData;", "Lcom/dicoding/submission1/skin/data/Result;", "Lcom/dicoding/submission1/skin/data/remote/response/analysis/PostAnalysisResponse;", "file", "Lokhttp3/MultipartBody$Part;", "description", "Lokhttp3/RequestBody;", "app_debug"})
public final class CreateAnalysisViewModel extends androidx.lifecycle.ViewModel {
    private final com.dicoding.submission1.skin.data.AnalysisRepository storyRepository = null;
    
    public CreateAnalysisViewModel(@org.jetbrains.annotations.NotNull()
    com.dicoding.submission1.skin.data.AnalysisRepository storyRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.dicoding.submission1.skin.data.Result<com.dicoding.submission1.skin.data.remote.response.analysis.PostAnalysisResponse>> postStory(@org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody description) {
        return null;
    }
}