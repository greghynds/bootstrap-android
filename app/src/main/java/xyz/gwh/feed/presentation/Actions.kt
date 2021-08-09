package xyz.gwh.feed.presentation

import xyz.gwh.arch.presentation.Action

const val LOAD_FEED = "LOAD_FEED"

fun createLoadFeedAction() = Action(LOAD_FEED)