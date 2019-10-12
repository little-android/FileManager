package com.codve.filemanager.fragment;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.codve.filemanager.R;
import com.codve.filemanager.activity.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class MainFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void whenButtonBackClicked() {
        onView(withId(R.id.navigation_button_back))
                .perform(click());
    }

    @Test
    public void whenActivityInit() {
        onView(withId(R.id.navigation_title))
                .check(matches(withText(R.string.navigation_title)));

        onView(withId(R.id.navigation_button_edit))
                .check(matches(withText(R.string.navigation_button_edit)));

    }
}