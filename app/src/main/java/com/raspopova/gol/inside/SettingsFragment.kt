package com.raspopova.gol.inside

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import com.raspopova.gol.R


class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val darkTheme = findPreference<SwitchPreferenceCompat>("dark")

        darkTheme?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener{pref, newValue ->

            if (pref is SwitchPreferenceCompat) {
                val value = newValue as Boolean
                if (value) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }

            true
        }

    }
}