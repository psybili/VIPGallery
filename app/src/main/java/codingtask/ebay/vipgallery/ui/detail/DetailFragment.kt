package codingtask.ebay.vipgallery.ui.detail

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codingtask.ebay.vipgallery.R
import codingtask.ebay.vipgallery.databinding.DetailFragmentBinding
import codingtask.ebay.vipgallery.di.Injectable
import codingtask.ebay.vipgallery.ui.gallery.GalleryViewModel
import com.bumptech.glide.Glide
import javax.inject.Inject

class DetailFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: GalleryViewModel
    private lateinit var binding: DetailFragmentBinding

    companion object {
        fun newInstance() = DetailFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<DetailFragmentBinding>(inflater, R.layout.detail_fragment, container, false)
                    .also {
                        binding = it
                    }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(GalleryViewModel::class.java)

        val uri = activity!!.intent.extras.getString(EXTRA_IMAGE_URI)

        Glide.with(context)
                .load(uri)
                .into(binding.detailImageView)

    }

}
