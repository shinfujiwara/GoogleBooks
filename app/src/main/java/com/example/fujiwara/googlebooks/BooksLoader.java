package com.example.fujiwara.googlebooks;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;


public class BooksLoader extends AsyncTaskLoader<List<Book>> {

    private static final String LOG_TAG = BooksLoader.class.getName();

    private String mUrl;

    public BooksLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Book> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<Book> books = QueryUtils.fetchBookData(mUrl);
        return books;
    }
}
