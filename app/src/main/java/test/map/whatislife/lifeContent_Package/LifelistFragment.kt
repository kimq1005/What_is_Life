package test.map.whatislife.lifeContent_Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import test.map.whatislife.R
import test.map.whatislife.databinding.ActivityLifelistFragmentBinding

class LifelistFragment : Fragment() {

    private lateinit var binding: ActivityLifelistFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityLifelistFragmentBinding.inflate(inflater , container , false)
        return binding.root
    }

}