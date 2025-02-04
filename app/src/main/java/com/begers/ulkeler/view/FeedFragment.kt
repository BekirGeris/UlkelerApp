package com.begers.ulkeler.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.begers.ulkeler.R
import com.begers.ulkeler.adapter.CountryAdapter
import com.begers.ulkeler.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)

        viewModel.refreshData()

        countryList.layoutManager = LinearLayoutManager(context)
        countryList.adapter = countryAdapter

        swipRefreshLayout.setOnRefreshListener {
            countryList.visibility = View.GONE
            countryError.visibility = View.GONE
            countryLoading.visibility = View.VISIBLE

            viewModel.refreshData()

            swipRefreshLayout.isRefreshing = false
        }

        observeLiveData()
    }


    fun observeLiveData(){

        viewModel.countries.observe(viewLifecycleOwner, Observer { countries ->
            countries?.let {
                countryList.visibility = View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }
        })

        viewModel.countryError.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                if (it){
                    //hata mesajı varsa göster
                    countryError.visibility = View.VISIBLE
                    countryLoading.visibility = View.GONE
                    countryList.visibility = View.GONE
                }else{
                    //hata mesajı yok gösterme
                    countryError.visibility = View.GONE
                }
            }
        })

        viewModel.countryLoading.observe(viewLifecycleOwner, Observer { loading ->
            loading?.let {
                if (it){
                    //hata mesajı varsa göster
                    countryLoading.visibility = View.VISIBLE
                    countryList.visibility = View.GONE
                    countryError.visibility = View.GONE
                }else{
                    //hata mesajı yok gösterme
                    countryLoading.visibility = View.GONE
                }
            }
        })
    }
}