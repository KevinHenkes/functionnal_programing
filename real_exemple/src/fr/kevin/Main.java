package fr.kevin;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import fr.kevin.entity.User;

public class Main {
	private static final Logger LOGGER = Logger.getGlobal();

	public static void main(String[] args) {

		Collection<User> users = Arrays.asList(new User("test", "test", 20), new User("test", "test", 20),
				new User("test", "test", 20), new User("test", "test", 20), new User("test", "test", 20),
				new User("test", "test", 15), new User("test", "test", 20), new User("test", "test", 44),
				new User("test", "test", 20), new User("test", "test", 5), new User("test", "test", 20),
				new User("test", "test", 8), new User("test", "test", 20), new User("test", "test", 33),
				new User("test", "test", 20));

		// Count user with age lower than 10
		Long nb = users.parallelStream().filter(u -> {
			return (u.getAge() < 10) ? true : false;
		}).collect(Collectors.counting());

		Long totalAge = users.parallelStream().reduce(0L, (sum, u) -> {
			return sum += u.getAge();
		}, (sum1, sum2) -> {
			return sum1 + sum2;
		});

		LOGGER.log(Level.INFO, String.valueOf(totalAge));
	}
}
