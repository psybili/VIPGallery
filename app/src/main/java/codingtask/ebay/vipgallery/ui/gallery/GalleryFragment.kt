package codingtask.ebay.vipgallery.ui.gallery

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import codingtask.ebay.vipgallery.R
import codingtask.ebay.vipgallery.databinding.GalleryFragmentBinding
import codingtask.ebay.vipgallery.di.Injectable
import codingtask.ebay.vipgallery.ui.detail.DetailActivity
import codingtask.ebay.vipgallery.ui.detail.EXTRA_IMAGE_URI
import codingtask.ebay.vipgallery.util.observe
import javax.inject.Inject

class GalleryFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: GalleryViewModel
    private lateinit var binding: GalleryFragmentBinding

    private val adapter = ImageAdapter()

    companion object {
        fun newInstance() = GalleryFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<GalleryFragmentBinding>(inflater, R.layout.gallery_fragment, container, false)
                    .also {
                        binding = it
                    }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(GalleryViewModel::class.java)

        adapter.itemClickListener =
                object : ImageAdapter.ItemClickListener {
                    override fun onItemClick(uri: String) {
                        this@GalleryFragment.onItemClick(uri)
                    }
                }

        binding.galleryRecyclerView.adapter = adapter
        binding.galleryRecyclerView.layoutManager = GridLayoutManager(activity, 2, GridLayout.VERTICAL, false)

        viewModel.vipUrl.postValue("252488346")

        viewModel.apiResponse.observe(this) {
            it ?: return@observe
            adapter.run {
                if (it.body != null) {
                    items.clear()
                    items.addAll(it.body.images)
                    notifyDataSetChanged()
                }
            }
        }

    }

    private fun onItemClick(uri: String) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(EXTRA_IMAGE_URI, uri)
        startActivity(intent)
    }

}
