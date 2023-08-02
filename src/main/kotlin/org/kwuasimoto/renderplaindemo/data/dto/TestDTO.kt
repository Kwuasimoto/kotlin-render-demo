package org.kwuasimoto.renderplaindemo.data.dto

data class TestDTO (
    private val id: String,
    private val someData: String
) {
    fun getId() = id
    fun getSomeData() = someData
}