package com.gg.givemepass.snaphelperdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = mAdapter
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recycler_view)
    }

    private fun initData() {
        val listItem = ArrayList<Int>()
        listItem.add(R.drawable.p01)
        listItem.add(R.drawable.p02)
        listItem.add(R.drawable.p03)
        listItem.add(R.drawable.p04)
        listItem.add(R.drawable.p05)
        listItem.add(R.drawable.p06)
        listItem.add(R.drawable.p07)
        mAdapter = MyAdapter(listItem)
    }
}

class MyAdapter(private val mData: List<Int>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(mData[position]).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    var imageView: ImageView = v.findViewById(R.id.img)
}
