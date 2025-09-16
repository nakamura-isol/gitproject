package javadrill.exercise019.question028;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserLoginProgramRunner implements CommandLineRunner {

	// コンストラクタDI
	private final UserLoginProgramService userLoginProgramService;

	@Override
	public void run(String... args) throws Exception {
		try {
			userLoginProgramService.takeLogin("erika", "erika0722");
			// 目的の例外だけをまず捕捉
		} catch (InvalidCredentialsException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

	}

}
