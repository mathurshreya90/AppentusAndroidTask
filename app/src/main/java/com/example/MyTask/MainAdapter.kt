package com.example.MyTask


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.MyTask.databinding.AdapterImageBinding

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var Urls = mutableListOf<GetUrl>()

    fun setUrlList(Urls: List<GetUrl>) {
        this.Urls = Urls.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterImageBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val circularProgressDrawable = CircularProgressDrawable(holder.itemView.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        val url = Urls[position]
        Glide.with(holder.itemView.context).load(url.download_url).diskCacheStrategy(
            DiskCacheStrategy.DATA).skipMemoryCache(false) .placeholder(circularProgressDrawable).into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {
        return Urls.size
    }
}

class MainViewHolder(val binding: AdapterImageBinding) : RecyclerView.ViewHolder(binding.root) {

}
