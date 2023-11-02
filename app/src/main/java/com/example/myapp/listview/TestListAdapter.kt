package com.example.myapp.listview

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class TestListAdapter() : BaseAdapter(), View.OnClickListener {
    override fun getCount(): Int {
        // получить элемент по его позиции
        return 0
    }

    override fun getItem(position: Int): Any {

        // получить айди элемента по его позиции
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        // получить общее количество элементов списка
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // преобразовать элемент данных а элемент списка
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}