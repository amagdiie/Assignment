package com.valu.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.valu.assignment.const.Constants.Fragments.PRODUCTS_FRAGMENT
import com.valu.assignment.databinding.ActivityMainBinding
import com.valu.assignment.fragments.ProductsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addFragment(ProductsFragment(), false, PRODUCTS_FRAGMENT, true)
    }

    fun addFragment(
        fragment: Fragment?,
        addToBackStack: Boolean,
        tag: String,
        isAnimate: Boolean
    ) {
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()
        if (isAnimate) {
            ft.setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left, R.anim.slide_in_left,
                R.anim.slide_out_right
            )
        }
        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        ft.replace(R.id.content_frame, fragment!!, tag)
        ft.commitAllowingStateLoss()
    }
}