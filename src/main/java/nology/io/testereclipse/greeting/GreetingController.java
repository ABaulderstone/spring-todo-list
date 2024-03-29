package nology.io.testereclipse.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

	@GetMapping
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/{name}")
	public String helloWithName(@PathVariable String name) {
		return String.format("Hello %s", name);
	}

	@GetMapping("/goodbye")
	public String goodBye() {
		return "Goodbye World";
	}
}
