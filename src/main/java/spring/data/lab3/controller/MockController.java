package spring.data.lab3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.data.lab3.service.MockService;

@RestController
@RequestMapping("/mock")
@RequiredArgsConstructor
public class MockController {

	private final MockService mockService;


	@GetMapping("/all")
	public ResponseEntity<?> mockUser(
			@RequestParam int numsUser,
			@RequestParam int numsProducts,
			@RequestParam int numsReviews
	) {
		try {
			mockService.mockAll(numsUser, numsProducts, numsReviews);
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
