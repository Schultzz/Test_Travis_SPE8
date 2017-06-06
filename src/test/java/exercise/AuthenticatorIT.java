package exercise;

import Utils.Mailer;
import exercise.realdatabase.UserFacadeRealDB;

import static org.mockito.Mockito.mock;

/**
 * Created by ms on 06-06-17.
 */
public class AuthenticatorIT extends AuthenticatorTest {

    @Override
    public Authenticator makeAuthenticator() {
        Mailer mailer = mock(Mailer.class);
        if (System.getenv("TRAVIS") != null) {
            return new Authenticator(new UserFacadeRealDB("pu_mySql_travis_Integration"), mailer);
        }
        return new Authenticator(new UserFacadeRealDB("pu_localDB"), mailer);
    }

}
