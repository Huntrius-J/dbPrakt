package com.example.dbprakt

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class insert : Fragment() {

    companion object {
        fun newInstance() = insert()
    }

    private lateinit var viewModel: InsertViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_insert, container, false)

        var db = AppDatabase.getDatabase(root.context);

        var button = root.findViewById<Button>(R.id.addButton)
        var titleText = root.findViewById<EditText>(R.id.titleEditText)
        var contextText = root.findViewById<EditText>(R.id.contentEditText);

        button.setOnClickListener(){

                lifecycleScope.launch(Dispatchers.IO)
                {
                    var article = Article(title = titleText.text.toString(), content = contextText.text.toString())
                    db.articleDao().insertAll(article)
                    println("Данные сохранены")
                }
        }

        return root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(InsertViewModel::class.java)
        // TODO: Use the ViewModel
    }

}