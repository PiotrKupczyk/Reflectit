package com.example.reflectit.ui.device.available.details.settings

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reflectit.R
import com.example.reflectit.ui.data.models.RemoteWidgets
import kotlinx.android.synthetic.main.widgets_fragment.*

class WidgetsView : Fragment() {

    var clocks = ArrayList<RemoteWidgets>()
    var calendars = ArrayList<RemoteWidgets>()
    var weather = ArrayList<RemoteWidgets>()
    var music = ArrayList<RemoteWidgets>()

    var clocksAdapter = WidgetAdapter(clocks)
    var calendarsAdapter = WidgetAdapter(calendars)
    var weatherAdapter = WidgetAdapter(weather)
    var musicAdapter = WidgetAdapter(music)


    companion object {
        fun newInstance() = WidgetsView()
    }

    private lateinit var viewModel: DeviceSettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.widgets_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DeviceSettingsViewModel::class.java)
        // TODO: Use the ViewModel
        bindRecyclerView()
        setupOkButton()

    }

    private fun setupOkButton() {
        ok_button.setOnClickListener{
            Navigation.findNavController(it).navigateUp()
        }
    }

    private fun bindRecyclerView() {
        val clockRecycler = clocksList as RecyclerView
        val calendarRecycler = calendarsList as RecyclerView
        val weatherRecycler = weatherList as RecyclerView
        val musicRecycler = musicList as RecyclerView

        clockRecycler.layoutManager= LinearLayoutManager(this.context, LinearLayout.HORIZONTAL, false)
        clockRecycler.adapter=clocksAdapter

        calendarRecycler.layoutManager= LinearLayoutManager(this.context, LinearLayout.HORIZONTAL, false)
        calendarRecycler.adapter=calendarsAdapter

        weatherRecycler.layoutManager= LinearLayoutManager(this.context, LinearLayout.HORIZONTAL, false)
        weatherRecycler.adapter=weatherAdapter

        musicRecycler.layoutManager= LinearLayoutManager(this.context, LinearLayout.HORIZONTAL, false)
        musicRecycler.adapter=musicAdapter

    }

}