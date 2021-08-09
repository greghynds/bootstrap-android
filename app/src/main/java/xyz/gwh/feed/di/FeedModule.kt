package xyz.gwh.feed.di

import xyz.gwh.arch.data.createApiClient
import xyz.gwh.feed.data.FeedApi
import xyz.gwh.feed.data.FeedClient
import xyz.gwh.feed.domain.FeedRepo
import xyz.gwh.feed.domain.FetchFeed
import xyz.gwh.feed.presentation.FeedModel
import org.koin.dsl.module

val feedModule = module {
    single<FeedClient> { createApiClient(get()) }
    single<FeedRepo> { FeedApi(get()) }
    single { FetchFeed(get()) }
    factory { FeedModel(get(), get()) }
}