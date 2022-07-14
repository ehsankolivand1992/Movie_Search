package com.sprout.data.entities

data class Meta(
    val display_message: String,
    val operation_result: String,
    val operation_result_code: Int,
    val remaining_items_count: Int,
    val server_date_time: String,
    val total_items_count: Int
)