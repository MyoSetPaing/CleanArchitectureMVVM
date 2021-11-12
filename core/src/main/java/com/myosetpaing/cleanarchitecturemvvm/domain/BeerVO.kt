package com.myosetpaing.cleanarchitecturemvvm.domain

import IngredientsVO


class BeerVO (
    val id: Int = 0,
    val name: String? = null,
    val first_brewed: String? = null,
    val description: String? = null,
    val image_url: String? = null,
    val abv: Double = 0.0,
    val ibu: Double = 0.0,
    val target_fg: Double = 0.0,
    val target_og: Double = 0.0,
    val ebc: Double = 0.0,
    val srm: Double = 0.0,
    val ph: Double = 0.0,
    val attenuation_level: Double = 0.0,
    val volume: VolumeVO? = null,
    val boil_volume: VolumeVO? = null,
    val method: MethodVO? = null,
    val ingredients: IngredientsVO? = null,
    val food_pairing: List<String>? = null,
    val brewers_tips: String? = null,
    val contributed_by: String? = null
)