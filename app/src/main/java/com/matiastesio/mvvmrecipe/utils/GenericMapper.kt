package com.matiastesio.mvvmrecipe.utils

interface GenericMapper <NetworkDto, BusinessModel> {

    fun mapToDomainModel(dto: NetworkDto) : BusinessModel
    fun mapFromDomainModel(model: BusinessModel) : NetworkDto
    fun mapToDomainModelList(initial: List<NetworkDto>) : List<BusinessModel>
    fun mapFromDomainModelList(initial: List<BusinessModel>) : List<NetworkDto>
}
