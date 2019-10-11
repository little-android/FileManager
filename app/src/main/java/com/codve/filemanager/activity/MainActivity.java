package com.codve.filemanager.activity;

import androidx.fragment.app.Fragment;

import com.codve.filemanager.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return MainFragment.newInstance();
    }
}
