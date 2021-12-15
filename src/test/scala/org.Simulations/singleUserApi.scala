package  org.Simulations


import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.scenario.Simulation

class api extends Simulation{



  var httpconf = http
    .baseUrl("https://reqres.in/")
    .header("Accept","application/type=json")

  var scn = scenario("Get-User")
    .exec(http("Single-user")
      .get("api/users/2")
      .check(status.is(200),status.not(404))
    )

   setUp(
     scn.inject(atOnceUsers(1)).protocols(httpconf)
   )









}

