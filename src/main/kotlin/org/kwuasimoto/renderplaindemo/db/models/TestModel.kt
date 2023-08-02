package org.kwuasimoto.renderplaindemo.db.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "test_models")
data class TestModel (
    @Id
    @Column(name = "id")
    private val id: String,

    @Column(name = "some_data")
    private val someData: String
) {
    fun getId() = id
    fun getSomeData() = someData
}