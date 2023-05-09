package com.fwhyn.fragmentmatter.ui.fragmentation

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fwhyn.fragmentmatter.R

class FragmentationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentation)

        findViewById<Button>(R.id.button1).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentationFragment.newInstance())
                .commitNow()
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, OthersFragment.newInstance())
                .commitNow()
        }
    }
}