package com.vrajatcreations.tvshows

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vrajatcreations.tvshows.adapter.TVShowAdapter
import com.vrajatcreations.tvshows.databinding.ActivityMainBinding
import com.vrajatcreations.tvshows.viewmodel.TVShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tvShowAdapter: TVShowAdapter
    private val viewModel: TVShowViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setupRV()
    }

    private fun setupRV() {
        tvShowAdapter = TVShowAdapter()
        binding.recyclerView.apply {
            adapter = tvShowAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        viewModel.responseTVShow.observe(this, { tvShowsList ->
            tvShowAdapter.tvShows = tvShowsList

        })
    }
}