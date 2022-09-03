package me.shockyng.mybalance.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.shockyng.mybalance.R

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _homeOptions = MutableLiveData<List<HomeItem>>().apply {
        value = arrayListOf(
            HomeItem(0, "Send", R.drawable.ic_arrow_send),
            HomeItem(1, "Top Up", R.drawable.ic_wallet),
            HomeItem(2, "Pay", R.drawable.ic_pay),
            HomeItem(3, "More", R.drawable.ic_more)
        )
    }
    val homeOptions: LiveData<List<HomeItem>> = _homeOptions


}