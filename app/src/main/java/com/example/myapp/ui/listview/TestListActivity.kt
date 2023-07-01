package com.example.myapp.ui.listview

import android.os.Bundle
import android.widget.AdapterView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.R
import com.example.myapp.databinding.ListviewBinding


/* изучение ListView + Adapter для передачи списка */
class TestListActivity : AppCompatActivity() {

    lateinit var binding: ListviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListView()
    }

    private fun setupListView() {

        val data = listOf(
            mapOf(
                KEY_TITLE to "First title 111",
                KEY_DESCRIPTION to "First  some description"
            ),
            mapOf(
                KEY_TITLE to "The second title 2",
                KEY_DESCRIPTION to "The second some description",
            ),
            mapOf(
                KEY_TITLE to "Third title 3",
                KEY_DESCRIPTION to "Third some description"
            ),
        )

        val adapter = SimpleAdapter(
            this,
            data, android.R.layout.simple_list_item_2,
            arrayOf(KEY_TITLE, KEY_DESCRIPTION),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItemTitle = data[position][KEY_TITLE]
                val selectedItemDescription = data[position][KEY_DESCRIPTION]

                var dialog = AlertDialog.Builder(this)
                    .setTitle(selectedItemTitle)
                    .setMessage(
                        getString(
                            R.string.selected_item_description,
                            selectedItemDescription
                        )
                    )
                    .setPositiveButton("OK") { dialog, which -> }
                    .create()
                dialog.show()
            }


    }

    companion object {
        @JvmStatic
        val KEY_TITLE = "title"

        @JvmStatic
        val KEY_DESCRIPTION = "description"
    }

}