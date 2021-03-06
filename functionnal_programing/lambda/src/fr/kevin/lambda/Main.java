package fr.kevin.lambda;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.kevin.lambda.entity.User;

public class Main {
	private static final Logger LOGGER = Logger.getGlobal();

	public static void main(String[] args) {
		Stream<User> users = Stream.of(new User("test", "test", 20), new User("test", "test", 20),
				new User("test", "test", 20), new User("test", "test", 20), new User("test", "test", 20),
				new User("test", "test", 15), new User("test", "test", 20), new User("test", "test", 44),
				new User("test", "test", 20), new User("test", "test", 5), new User("test", "test", 20),
				new User("test", "test", 8), new User("test", "test", 20), new User("test", "test", 33),
				new User("test", "test", 20));

		Set<User> result = (users.filter(u -> {
			return (u.getAge() < 10) ? true : false;
		}).collect(Collectors.toSet()));
		
		LOGGER.log(Level.INFO, String.valueOf(result.size()));
	}

	private static Integer resizeArray(Object[] array, Integer length) {
		try {
			final Field arrayLength = array.getClass().getDeclaredField("length");
			arrayLength.setAccessible(true);
			arrayLength.setInt(array, length);

			return 0;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());

			return 1;
		}

	}

}
