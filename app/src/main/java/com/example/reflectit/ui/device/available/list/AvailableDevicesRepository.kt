package com.example.reflectit.ui.device.available.list

import android.net.nsd.NsdManager
import androidx.lifecycle.*
import com.example.reflectit.ui.data.models.Mirror
import com.example.reflectit.ui.extensions.append
import com.example.reflectit.ui.data.services.NetworkService
import java.net.InetAddress

class AvailableDevicesRepository(private val manager: NsdManager) {
    fun getAvailableDevices(): LiveData<ArrayList<Mirror>> {
        val availableDevices = MutableLiveData<ArrayList<Mirror>>()

        NetworkService.discoverServices(manager) { inetAddress: InetAddress, port: Int ->
            //TODO: call api to get mirror specific data such as GUID
            availableDevices.append(Mirror(inetAddress, port))
            println("Mirror posted")
        }
        return availableDevices
    }
}




