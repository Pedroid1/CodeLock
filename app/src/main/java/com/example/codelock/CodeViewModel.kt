package com.example.codelock

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class CodeViewModel : ViewModel() {

    private val codeList: MutableList<Int> = mutableListOf()

    private var currentGeneratedCode: Int? = null
    private var currentCodeTyped: String? = null

    private fun generateCode() {
        val tempCode = Random.nextInt(0, 10000)
        if (codeList.contains(tempCode)) {
            generateCode()
        } else {
            codeList.add(tempCode)
            currentGeneratedCode = tempCode
            Log.d("GeneratedValue", currentGeneratedCode.toString())
        }
    }

    private fun formatGeneratedCode(): String {
        if (currentGeneratedCode!! < 10) {
            return "000" + currentGeneratedCode!!.toString()
        } else if (currentGeneratedCode!! >= 10 && currentGeneratedCode!! < 100) {
            return "00" + currentGeneratedCode!!.toString()
        } else if (currentGeneratedCode!! >= 100 && currentGeneratedCode!! < 1000) {
            return "0" + currentGeneratedCode!!.toString()
        } else {
            return currentGeneratedCode!!.toString()
        }
    }

    fun getGenerateCode(): String {
        currentCodeTyped = null
        generateCode()
        return formatGeneratedCode()
    }

    fun numberClicked(number: Int): String {
        currentGeneratedCode = null
        if (currentCodeTyped == null) {
            currentCodeTyped = number.toString()
            return currentCodeTyped!!
        } else {
            if (currentCodeTyped!!.length == 4) {
                return currentCodeTyped!!
            } else {
                currentCodeTyped += number.toString()
                return currentCodeTyped!!
            }
        }
    }

    fun getCurrentCode(): String {
        if (currentGeneratedCode == null && currentCodeTyped == null) {
            return ""
        } else if (currentGeneratedCode == null) {
            return currentCodeTyped!!
        } else {
            return formatGeneratedCode()
        }
    }

    fun clean() {
        currentCodeTyped = null
        currentGeneratedCode = null
    }
}