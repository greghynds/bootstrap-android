package xyz.gwh.arch.presentation

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatchers {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}