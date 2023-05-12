package com.bluehabit.bpjs.android.featureXml.programInformation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluehabit.bpjs.data.domain.data.GetProgramUseCase
import com.bluehabit.bpjs.data.model.Program
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProgramInformationViewModel @Inject constructor(
    private val getProgramUseCase: GetProgramUseCase
) : ViewModel() {

    init {
        getListProgram()
    }

    private val _program: MutableStateFlow<List<Program>> = MutableStateFlow(listOf())

    /**
     * 5000 ms just tricky way to avoid reset state while screen rotate
     * **/
    val program
        get() = _program.asStateFlow()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = listOf()
            )

    private fun getListProgram() = viewModelScope.launch {
        getProgramUseCase().collect {
            _program.tryEmit(it)
        }
    }
}