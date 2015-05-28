import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._


class HelloServiceActor extends Actor with HelloService {
	def actorRefFactory = context
	def receive = runRoute(rootRoute)
}

trait HelloService extends HttpService {
	val rootRoute = path("") { 
		get {
			respondWithMediaType(`text/html`) {
				complete {
					<html><body><h1>Hello, world!</h1></body></html>
				}
			}
		}	
	}
}
