package com.Test.has_A_RelationShip.oneToOne.Annotation.uniDirectional;

import com.Dao.UserDao;
import com.modal.has_A_RelationShip.oneToOne.Annotation.uniDirectional.Pk_FK.Profile;
import com.modal.has_A_RelationShip.oneToOne.Annotation.uniDirectional.Pk_FK.User;

public class Pk_Fk_Domo {

    public static void main(String[] args) {
        User state=new User("Vikash", "Singh", new Profile("New Delhi"));
        UserDao.save(state);
        System.out.println("Save sucessfully");
    }
}
