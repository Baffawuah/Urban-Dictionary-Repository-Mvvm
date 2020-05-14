package com.example.urbandic.viewmodel.activities;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.urbandic.R;
import com.example.urbandic.view.activities.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest{

    @Test
    public void titleElementInView(){
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.title)).check(matches(isDisplayed()));
    }

    @Test
    public void downVoteElementInView(){
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.btnSortDownVote)).check(matches(isDisplayed()));
    }

    @Test
    public void upVoteElementInView(){
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.btnSortUpVote)).check(matches(isDisplayed()));
    }
}
