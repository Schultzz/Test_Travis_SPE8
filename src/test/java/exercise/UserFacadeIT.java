package exercise;

import exercise.realdatabase.UserFacadeRealDB;

/**
 * Created by ms on 06-06-17.
 */
public class UserFacadeIT extends UserFacadeTest {
    @Override
    public IUserFacade makeUserFacade() {
        return new UserFacadeRealDB("pu_localDB");
    }
}

