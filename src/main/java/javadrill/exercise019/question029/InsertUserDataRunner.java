package javadrill.exercise019.question029;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InsertUserDataRunner implements CommandLineRunner {

	private final InsertUserDataService insertUserDataService;

	@Override
	public void run(String... args) {
		try {
			insertUserDataService.registerUserData(new User("takema", "takema0326"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

	}

}
