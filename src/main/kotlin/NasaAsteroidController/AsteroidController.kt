package NasaAsteroidController

import NasaAsteroidService.AsteroidService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/asteroids")
@CrossOrigin(origins = ["http://localhost:3001"])
class AsteroidController {

    @Autowired
    //TODO: How can I initialise it as AsteroidService and not nullable?
    private val asteroidService: AsteroidService ?= null

    @Autowired
    @GetMapping("/fetchAllAsteroidsForPeriod")
    fun fetchAllAsteroidsForPeriod(
        @RequestParam startDate: String,
        @RequestParam endDate: String
    ): ResponseEntity<String?>? {
        return try {
            val asteroids: String? = asteroidService?.getAsteroidsListData(startDate, endDate) //TODO: asteroidService not nullable
            //TODO: handle null string
            ResponseEntity<String?>(asteroids, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity<String?>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/fetchAsteroidInformationById")
    fun fetchAsteroidInformationById(@RequestParam asteroidId: String): ResponseEntity<String?>? {
        return try {
            val asteroidInformation: String? = asteroidService?.getAsteroidDetailsData(asteroidId)//TODO: asteroidService not nullable
            //TODO: handle null string
            ResponseEntity<String?>(asteroidInformation, HttpStatus.OK)

        } catch (e: Exception) {
            ResponseEntity<String?>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


}