package com.example.contentprovider.views

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.app.AppCompatActivity
import com.example.contentprovider.databinding.ActivitySettingsBinding
import com.example.contentprovider.utils.alarm.AlarmReceiver
import com.example.contentprovider.utils.alarm.ReminderPrefs
import com.example.contentprovider.utils.alarm.Reminders

class SettingsActivity : AppCompatActivity() {
    val binding: ActivitySettingsBinding by viewBinding()
    private lateinit var reminder: Reminders
    private lateinit var alarmReceiver: AlarmReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val reminderPrefs = ReminderPrefs(this)
        binding.switchReminder.isChecked = reminderPrefs.getReminder().isReminded

        alarmReceiver = AlarmReceiver()
        binding.switchReminder.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                saveReminder(true)
                alarmReceiver.setRepeatingAlarm(
                    this,
                    "RepeatingAlarm",
                    "09:00",
                    "Github Search Reminder"
                )
            } else {
                saveReminder(false)
                alarmReceiver.cancelAlarm(this)
            }
        }

        binding.btnLanguage.setOnClickListener {
            startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
        }
    }


    private fun saveReminder(state: Boolean) {
        val remind = ReminderPrefs(this)
        reminder = Reminders()
        reminder.isReminded = state
        remind.setReminder(reminder)
    }


}