package com.mzaimilzam.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_entity")
data class UsersEntity(

	@ColumnInfo(name ="website")
	val website: String? = null,

	@ColumnInfo(name ="address")
	val address: String? = null,

	@ColumnInfo(name ="phone")
	val phone: String? = null,

	@ColumnInfo(name ="name")
	val name: String? = null,

	@ColumnInfo(name ="company_name")
	val companyName: String? = null,

	@PrimaryKey
	@ColumnInfo(name ="id")
	val id: Int? = null,

	@ColumnInfo(name ="email")
	val email: String? = null,

	@ColumnInfo(name ="username")
	val username: String? = null
)