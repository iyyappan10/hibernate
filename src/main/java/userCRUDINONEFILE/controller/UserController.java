package userCRUDINONEFILE.controller;

import java.util.Scanner;

import userCRUDINONEFILE.dao.UserDao;
import userCRUDINONEFILE.dto.User;

public class UserController {
	// write my main method

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("welcome to User Application");

		System.out.println("Enter 1 to Save the data");
		System.out.println("Enter 2 to Update the data");
		System.out.println("Enter 3 to Find the data");
		System.out.println("Enter 4 Delete the data");
		System.out.println("Enter 5 to Exit");
		int choice = scanner.nextInt();
		UserDao dao = new UserDao();
		switch (choice) {

		case 1: {
			System.out.println("enter id:");
			int id = scanner.nextInt();
			System.out.println("Enter name");
			String name = scanner.next();
			System.out.println("Enter address");
			String address = scanner.next();

			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setAddress(address);

			dao.saveUser(user);

			System.out.println("Thank you user saved successfully");

		}
			break;
		case 2: {
			System.out.println("enter id to updated:");
			int id = scanner.nextInt();
			System.out.println("Enter name");
			String name = scanner.next();
			System.out.println("Enter address");
			String address = scanner.next();

			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setAddress(address);
			dao.UpdateUser(id, user);

			System.out.println("Thank you user updated successfully");

		}
			break;
		case 3: {
			System.out.println("enter id to be selected");
			int id = scanner.nextInt();
			dao.findUser(id);
			System.out.println("Thankyou user data Fetched successfully");
		}
			break;
		case 4: {
			System.out.println("Enter id to be deleted");
			int id = scanner.nextInt();
			dao.deleteUser(id);
			System.out.println("Thank you user deleted successfully");
		}
			break;
			
		case 5: {
			System.out.println("Thank you");
		}
			break;
		}
	}

}
