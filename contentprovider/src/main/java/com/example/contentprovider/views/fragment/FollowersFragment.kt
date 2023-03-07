package com.example.contentprovider.views.fragment

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.example.contentprovider.R
import com.example.contentprovider.adapter.followers.FollowerAdapter
import com.example.contentprovider.databinding.FollowersFragmentLayoutBinding
import com.example.contentprovider.viewmodel.DetailViewModel
import com.example.contentprovider.views.DetailActivity

class FollowersFragment : Fragment(R.layout.followers_fragment_layout) {

    private val binding by viewBinding<FollowersFragmentLayoutBinding>()
    private val followersViewModel by activityViewModels<DetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val argument = arguments
        val username = argument?.getString(DetailActivity.DETAIL_KEY).toString()
        if (username.isNotEmpty()){
            followersViewModel.getFollowers(username)
        }

        followersViewModel.dataFollowers.observe(viewLifecycleOwner) { followers ->
            if (followers != null) {
                binding.rvFollowers.apply {
                    layoutManager =
                        LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
                    adapter = FollowerAdapter(arrayListOf()) {
                        Snackbar.make(view, "hello ${it.login}", Snackbar.LENGTH_SHORT).show()
                    }.also { adapter ->
                        adapter.setData(followers)
                        val item = adapter.itemCount
                        if (item == 0 || item < -1) {
                            binding.rvFollowers.visibility = View.INVISIBLE
                            binding.lottieStateFollowers.visibility = View.VISIBLE
                        } else
                            binding.rvFollowers.visibility = View.VISIBLE
                            binding.lottieStateFollowers.visibility = View.GONE
                    }
                }
            }
        }
    }
}



