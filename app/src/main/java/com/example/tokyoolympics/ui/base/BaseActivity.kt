package com.example.tokyoolympics.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    abstract fun setup()
    abstract fun callback()
    abstract val theme: Int
    abstract val inflate: (LayoutInflater) -> VB
    private lateinit var _binding: VB
    protected val binding: VB
        get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(theme)
        _binding = inflate(layoutInflater)
        setContentView(_binding.root)
        setup()
    }
}