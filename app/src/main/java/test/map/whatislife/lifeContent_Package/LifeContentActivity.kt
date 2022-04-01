package test.map.whatislife.lifeContent_Package

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import test.map.whatislife.databinding.ActivityLifeContentBinding

class LifeContentActivity: AppCompatActivity() {
    private var lifeContentBinding : ActivityLifeContentBinding?=null
    private val binding get() = lifeContentBinding!!

    private val tabTitleArray = arrayOf(
        "Tab1",
        "Tab2",
        "Tab3"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifeContentBinding = ActivityLifeContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewpager = binding.pager
        val tabLayout = binding.lifetablayout

        viewpager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout , viewpager) {tab, position->
            tab.text = tabTitleArray[position]
        }.attach()

    }
}