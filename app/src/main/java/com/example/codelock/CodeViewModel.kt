package com.example.codelock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class CodeViewModel : ViewModel() {

    private val codeList = mutableListOf<Int>()

    private var currentGeneratedCode = MutableLiveData("")
    private var currentCodeTyped = MutableLiveData("")
    var finalCode: LiveData<String> = currentGeneratedCode

    fun generateCode() {
        currentCodeTyped.value = ""
        val tempCode = Random.nextInt(0, 10000)
        if (codeList.contains(tempCode)) {
            generateCode()
        } else {
            codeList.add(tempCode)
            currentGeneratedCode.value = formatGeneratedCode(tempCode)
            finalCode = currentGeneratedCode
        }
    }

    private fun formatGeneratedCode(code: Int): String {
        if (code < 10) {
            return "000" + code.toString()
        } else if (code >= 10 && code < 100) {
            return "00" + code.toString()
        } else if (code >= 100 && code < 1000) {
            return "0" + code.toString()
        } else {
            return code.toString()
        }
    }

    fun numberClicked(number: Int) {
        currentGeneratedCode.value = ""
        if (currentCodeTyped.value!!.length >= 4) {
        } else {
            currentCodeTyped.value += number.toString()
        }
        finalCode = currentCodeTyped
    }

    fun clean() {
        currentCodeTyped.value = ""
        currentGeneratedCode.value = ""
    }
}