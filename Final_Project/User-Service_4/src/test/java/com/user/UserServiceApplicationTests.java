//package com.user;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.user.entity.Role;
//import com.user.entity.User;
//import com.user.repo.IUserRepo;
//import com.user.service.IUserService;
//
//@SpringBootTest
//class UserServiceApplicationTests {
//	
//	@Autowired
//	private IUserService iUserService;
//	
//	@MockBean
//	private IUserRepo iUserRepo;
//
//	@Test
//	void contextLoads() {
//	}
//	
//	@Test
//	public void signupTest() {
//		User userobj = new User(1L,"rahul","kumar","rahul@gmail.com","rahul","rahul@123",Rol);
//		when(this.iUserRepo.save(userobj)).thenReturn(userobj);
//		assertEquals(userobj,iUserService.signup(userobj));
//	}
//	
//	
//	@Test
//	public void getAllUserTest() {
//		User userobj1 = new User(1L,"Pavitra","kumar","Pavitra@gmail.com","Pavitra","Pavitra@123",Role.manager);
//		User userobj2 = new User(2L,"rahul","kumar","rahul@gmail.com","rahul","rahul@123",Role.manager);
//		User userobj3 = new User(3L,"Rohit","rani","Rohit@gmail.com","Rohit","Rohit@123",Role.manager);
//		User userobj4 = new User(4L,"honey","sri","honey@gmail.com","honey","honey@123",Role.manager);
//		List<User> listofusers = List.of(userobj1,userobj2,userobj3,userobj4);
//		when(this.iUserRepo.findAll()).thenReturn(listofusers);
//		assertEquals(4,iUserService.getAllUsers().size());
//	}
//	
//	@Test
//	public void getUserByNameTest() {
//		User userobj = new User(1L,"rahul","kumar","rahul@gmail.com","rahul","rahul@123",Role.manager);
//		String user = "rahul";
//		when(this.iUserRepo.findByUsername(user)).thenReturn(userobj);
//		assertEquals(userobj,iUserRepo.findByUsername(user));
//	}
//
//	@Test
//	public void deleteTest() {
//		Long id =1L;
//		iUserService.deleteUserDetail(id);
//		verify(iUserRepo,times(1)).deleteById(id);
//	}
//	
//	@Test
//	public void updateTest() {
//		User user = new User(1L,"rahul","kumar","rahul@gmail.com","rahul","rahul@123",Role.manager);
//		when(this.iUserRepo.findById(1L)).thenReturn(Optional.of(user));
//		assertEquals(1L, user.getId());
//		when(this.iUserRepo.save(user)).thenReturn(user);
//		assertEquals(user, iUserService.updateUserDetail(user, user.getId()));	
//	}
//
//}	