package com.fwhyn.fragmentmatter.ui.fragmentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fwhyn.fragmentmatter.R

class FragmentationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentation)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentationFragment.newInstance())
                .commitNow()
        }
    }
}