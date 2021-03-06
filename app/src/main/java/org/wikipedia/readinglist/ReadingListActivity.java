package org.wikipedia.readinglist;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import org.wikipedia.activity.SingleFragmentActivity;

public class ReadingListActivity extends SingleFragmentActivity<ReadingListFragment> {
    protected static final String EXTRA_READING_LIST_TITLE = "readingListTitle";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public static Intent newIntent(@NonNull Context context, @NonNull ReadingList list) {
        return new Intent(context, ReadingListActivity.class)
                .putExtra(EXTRA_READING_LIST_TITLE, list.getTitle());
    }

    @Override
    public ReadingListFragment createFragment() {
        return ReadingListFragment
                .newInstance(getIntent().getStringExtra(EXTRA_READING_LIST_TITLE));
    }
}
