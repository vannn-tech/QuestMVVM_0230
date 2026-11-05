package com.example.questmvvm_0230.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.questmvvm_0230.model.Siswa

class SiswaViewModel : ViewModel() {
    private val _statusUI = MutableStateFlow(Siswa())
    val statusUI: StateFlow<Siswa> = _statusUI.asStateFlow()

    fun setSiswa(list: MutableList<String>) {
        _statusUI.update { state ->
            state.copy(
                nama = list[0],
                gender = list[1],
                alamat = list[2]
            )
        }
    }
}