package exercise;

import exercise.fakedatabase.UserFacadeFake;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserFacadeTest {

  IUserFacade facade;
  
  //Override in a derived class to provide an alternative Facade for these tests
  public IUserFacade makeUserFacade(){
    return new UserFacadeFake();
  }

  @Before
  public void setup() {
     facade = makeUserFacade();
  }
  
  @Test
  public void authenticateOK(){
    //Given (in setup)
    //When
    LoginStatus res = facade.verifyUser("Jan", "abcde");
    //Then
    assertThat(res,is(LoginStatus.OK));
  }
  
  @Test
  public void authenticateValidUserWrongPW(){
    //Given (in setup)
    //When
    LoginStatus res = facade.verifyUser("Jan", "kfjdlsjaf");
    //Then
    assertThat(res,is(LoginStatus.INVALID_PASSWORD));
  }
  
  @Test
  public void authenticateNonExistingUser(){
    //Given (in setup)

    //When
    LoginStatus res = facade.verifyUser("xxxx", "kfjdlsjaf");
    
//Then
    assertThat(res,is(LoginStatus.UNKNOWN_USER));
  }

}
