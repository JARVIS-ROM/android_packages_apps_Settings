/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.accessibility;

import static com.android.settings.accessibility.TextReadingPreferenceFragment.RESET_KEY;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import com.android.settings.R;
import com.android.settingslib.widget.LayoutPreference;

import com.google.android.setupdesign.GlifPreferenceLayout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

/**
 * Tests for {@link TextReadingPreferenceFragmentForSetupWizard}.
 */
@RunWith(RobolectricTestRunner.class)
public class TextReadingPreferenceFragmentForSetupWizardTest {

    private final Context mContext = spy(ApplicationProvider.getApplicationContext());
    @Mock
    private GlifPreferenceLayout mGlifLayoutView;
    private TextReadingPreferenceFragmentForSetupWizard mFragment;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mFragment = spy(new TextReadingPreferenceFragmentForSetupWizard());
        final LayoutPreference resetPreference =
                new LayoutPreference(mContext, R.layout.accessibility_text_reading_reset_button);
        doReturn(resetPreference).when(mFragment).findPreference(RESET_KEY);
    }

    @Test
    public void setHeaderText_onViewCreated_verifyAction() {
        final String title = "title";
        doReturn(mContext).when(mFragment).getContext();
        doReturn(title).when(mContext).getString(
                R.string.accessibility_text_reading_options_title);

        mFragment.onViewCreated(mGlifLayoutView, null);

        verify(mGlifLayoutView).setHeaderText(title);
    }
}
