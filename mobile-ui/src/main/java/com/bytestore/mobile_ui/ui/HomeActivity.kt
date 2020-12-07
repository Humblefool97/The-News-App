package com.bytestore.mobile_ui.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.bytestore.mobile_ui.R
import com.bytestore.mobile_ui.ViewModelFactory
import com.bytestore.mobile_ui.mapper.ArticleUiViewMapper
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_home)

        AndroidInjection.inject(this)

    }
}