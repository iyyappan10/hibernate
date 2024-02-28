package userCRUDINONEFILE.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import userCRUDINONEFILE.dto.User;

public class UserDao {
	// all the crud operation method accessing the database

	// 1.saveUser
	public void saveUser(User user) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

	}

	// 2updateuser
	public void UpdateUser(int id, User user) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		User dbUser = entityManager.find(User.class, id);
		if (dbUser != null) {
			// that id is present so i can upadate the data
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			// why set a id
			user.setId(id);
			entityManager.merge(user);
			entityTransaction.commit();
		} else {

			System.out.println("sorry is is not present in the database");
		}

	}

	// 3finduser
	public void findUser(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		User dbUser = entityManager.find(User.class, id);
		if (dbUser != null) {
			System.out.println(dbUser);
		} else {

			System.out.println("sorry is is not present in the database");
		}

	}

	// 4 delete user dind id
	public void deleteUser(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		User dbUser = entityManager.find(User.class, id);
		if (dbUser != null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbUser);
			entityTransaction.commit();
		
		} else {

			System.out.println("sorry is is not present in the database");
		}

	}

}
