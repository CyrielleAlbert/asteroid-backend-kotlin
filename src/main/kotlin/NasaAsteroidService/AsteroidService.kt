package NasaAsteroidService

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class AsteroidService {
    // Implement methods to fetch data from the NASA API

    @Value("\${NASA_API_ASTEROID_LIST_URL}")
    private val nasaAsteroidListApiUrl: String? = null

    @Value("\${NASA_API_ASTEROID_DETAILS_URL}")
    private val nasaAsteroidDetailsApiUrl: String? = null

    @Value("\${NASA_DEV_API_KEY}")
    private val nasaApiKey: String? = null

    fun getAsteroidsListData(startDate: String?, endDate: String?): String? {
        val apiUrl = String.format(
            "%s?start_date=%s&end_date=%s&api_key=%s",
            nasaAsteroidListApiUrl,
            startDate,
            endDate,
            nasaApiKey
        )
        val restTemplate = RestTemplate()
        return restTemplate.getForObject(apiUrl, String::class.java)
    }

    fun getAsteroidDetailsData(asteroidID: String?): String? {
        val apiUrl =
            String.format("%s/%s?api_key=%s", nasaAsteroidDetailsApiUrl, asteroidID, nasaApiKey)
        val restTemplate = RestTemplate()
        return restTemplate.getForObject(apiUrl, String::class.java)
    }
}