package info.chirikualii.simplemvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import info.chirikualii.simplemvvm.R
import info.chirikualii.simplemvvm.data.local.ArticleEntity
import info.chirikualii.simplemvvm.ui.adapter.HeadlineListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val mViewModel: MainViewModel by viewModels(
        factoryProducer = {MainViewModelFactory()}
    )

    lateinit var headlineListAdapter: HeadlineListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()

    }

    private fun setupView() {
        headlineListAdapter = HeadlineListAdapter()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = headlineListAdapter

        mViewModel.doLoadHeadline()

        mViewModel.listArticle.observe(this, Observer {listData ->
            headlineListAdapter.addList(listData)
            headlineListAdapter.notifyDataSetChanged()
            Log.d(MainActivity::class.java.simpleName,"load article ${Gson().toJsonTree(listData)}")
        })
    }
}