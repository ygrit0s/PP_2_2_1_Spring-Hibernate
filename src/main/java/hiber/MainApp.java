package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService userService = context.getBean(UserService.class);
		
		String carModel = "KIA-Morning";
		int carSeries = 2018;
		
		User user1 = new User("Donald", "Duck", "DonyTheDuck@disney.com");
		User user2 = new User("Mickey", "Mouse", "MickTheMouse@disney.com");
		
		Car car1 = new Car("Hyundai-Casper", 2020);
		Car car2 = new Car("KIA-Morning", 2018);
		
		userService.add(user1.setCar(car1).setUser(user1));
		userService.add(user2.setCar(car2).setUser(user2));
		
		userService.listUsers();
		
		System.out.println("Input Car 'model' and 'series' seperated by Tab key");
		
		userService.userByCar(carModel, carSeries);
		context.close();
	}
}
