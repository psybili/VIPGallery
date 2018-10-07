package codingtask.ebay.vipgallery.ui.gallery

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import codingtask.ebay.vipgallery.R
import codingtask.ebay.vipgallery.data.model.Image
import codingtask.ebay.vipgallery.databinding.ImageItemBinding
import com.bumptech.glide.Glide

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    val items = ArrayList<Image>()

    lateinit var itemClickListener: ItemClickListener

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position]) {
            itemClickListener.onItemClick(it.getBigUri())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.image_item,
                parent,
                false
        ))
    }

    interface ItemClickListener {
        fun onItemClick(uri: String)
    }

    inner class ViewHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
                currentItem: Image,
                listener: (Image) -> Unit
        ) = with(binding) {
            Glide.with(imageView.context)
                    .load(currentItem.getThumbUri())
                    .into(binding.imageView)
            binding.imageView.setOnClickListener { listener(currentItem) }
        }
    }
}
