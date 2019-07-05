package com.Test.has_A_RelationShip.oneToOne.Annotation.uniDirectional;

import com.Dao.UserDao;
import com.modal.has_A_RelationShip.oneToOne.Annotation.uniDirectional.Same_Pk.Profile;
import com.modal.has_A_RelationShip.oneToOne.Annotation.uniDirectional.Same_Pk.User;

public class Same_PK_Demo {

    public static void main(String[] args) {
        User state=new User("Vikash", "Singh", new Profile("New Delhi"));
        UserDao.save(state);
        System.out.println("Save sucessfully");

    }

}
