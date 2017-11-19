package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.presenter.BasePresenter
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.presenter.BaseView
import com.hydraz.trungnam1992.mvpdaggerretrofit.utils.AppLog

/**
 * Created by trungnam1992 on 11/4/17.
 */
public abstract class BaseActivity : AppCompatActivity(), BaseView {

    protected lateinit var presenter: BasePresenter<BaseView>

    abstract val layoutId: Int

    protected abstract fun initializeDagger()

    protected abstract fun initializePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initializeDagger()
        initializePresenter()

        AppLog.e("", "Hello" )
    }

    override fun onStart() {
        super.onStart()
        //presenter.start()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        if (true) {
            //presenter.finalizeView()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
