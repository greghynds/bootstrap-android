package xyz.gwh.feed.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import xyz.gwh.feed.domain.entity.Item


@Composable
fun ItemList(items: List<Item>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        items.forEach { item ->
            item {
                Text(item.text)
            }
        }
    }
}