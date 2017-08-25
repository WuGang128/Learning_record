package com.wugang.learning_record.api;

import com.wugang.learning_record.api.response.BookSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wugang on 2017/8/16.
 */

public interface BlueService  {
    @GET("book/search")
    Call<BookSearchResponse> getSearchBooks(@Query("q") String name,
                                            @Query("tag") String tag, @Query("start") int start, @Query("count") int count);
}
