package com.example.myhouse_aos.data.repository

import com.example.myhouse_aos.data.datasource.DummyDatasource
import com.example.myhouse_aos.domain.repository.DummyRepository

class DummyRepositoryImpl(private val dummyDatasource: DummyDatasource) : DummyRepository {
}