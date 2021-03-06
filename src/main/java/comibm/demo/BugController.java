package comibm.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BugController {
	
	@PostMapping("/bug")
	String createBug() {
		return "success";
	}
	@GetMapping("/bug")
	String getBug() {
		return "bug created";
	}
	
	@PutMapping("/bug/{id}")
	String updateBug(@PathVariable("id") int bugId) {
		System.out.println(bugId);
		return "bug information updated";
		
	}
	@DeleteMapping("/bug/{id}")
	String deleteBug(@PathVariable("id") int bugId) {
		//System.out.println(httpRequest.getHeaders());
		System.out.println(bugId);
		return "bug deleted";
		
	}
	

}
