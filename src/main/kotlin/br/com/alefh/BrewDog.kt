package br.com.alefh

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client
import java.util.*

@Client("\${http.services.brewdog.url}")
interface BrewDog {

    @Get("/beers")
    fun listAllBeers(@QueryValue params : Optional<Map<String, Any>>) : List<BeerResponse>

    @Get("/beers/{id}")
    fun findById(@PathVariable id: Int);

}


data class BeerResponse(
        val name: String,
        @JsonProperty("image_url")
        val image: String,
        val ph: Double,
        val id: Int,
        val volume: BeerVolume,
        val ingredients: List<Map<String, Any>>
)

data class BeerVolume(
        val value: Int,
        val unit: String
)

data class Hop(
        val name: String,
        val add: String,
        val attribute: String,
        val amount: Amount
)

data class Amount(
        val value: Double,
        val unit: String
)