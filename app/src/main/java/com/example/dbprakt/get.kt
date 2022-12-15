package com.example.dbprakt

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class get : Fragment() {

    companion object {
        fun newInstance() = get()
    }

    private lateinit var viewModel: GetViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root =  inflater.inflate(R.layout.fragment_get, container, false)

        var db = AppDatabase.getDatabase(root.context)

        var rViewAdapter: recyclerAdapter
            var listOfArticles:List<Article> = db.articleDao().getAll();
            println(db.articleDao().getAll())
            rViewAdapter = recyclerAdapter(root.context,listOfArticles)
            var recycler = root.findViewById<RecyclerView>(R.id.recyclerView)
            recycler.adapter = rViewAdapter
            recycler.layoutManager = LinearLayoutManager(root.context)



        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(GetViewModel::class.java)
        // TODO: Use the ViewModel
    }

}