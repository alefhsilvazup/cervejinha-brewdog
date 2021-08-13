package br.com.alefh

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import java.util.*


@Controller("cervejinha")
class CervejinhaController(val beerClient : BrewDog) {

    @Get
    fun all(@QueryValue params : Optional<Map<String, Any>>) : HttpResponse<List<BeerResponse>> {
        return HttpResponse.ok(beerClient.listAllBeers(params))
    }
}