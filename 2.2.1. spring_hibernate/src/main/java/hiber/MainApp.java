package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Alexandr", "Bolotov", "user1@mail.ru");
        User user2 = new User("German", "Sevostianov", "user2@mail.ru");
        User user3 = new User("Sergey", "Kadushkin", "user3@mail.ru");


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        Car car1 = new Car("Mersedes Benz", 3);
        Car car2 = new Car("BMW", 5);
        Car car3 = new Car("Cadillac Escalade", 6);

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());

        System.out.println(userService.getUserByCarNumber("Mersedes Benz", 3));

        context.close();
    }
}
