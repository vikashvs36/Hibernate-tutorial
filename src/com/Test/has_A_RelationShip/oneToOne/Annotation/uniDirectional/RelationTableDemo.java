package com.Test.has_A_RelationShip.oneToOne.Annotation.uniDirectional;

import com.Dao.UserDao;
import com.modal.has_A_RelationShip.oneToOne.Annotation.uniDirectional.RelationTable.Profile;
import com.modal.has_A_RelationShip.oneToOne.Annotation.uniDirectional.RelationTable.User;

public class RelationTableDemo {

    public static void main(String[] args) {
        User user=new User("Vikash", "Singh", new Profile("New Delhi")) ;
        UserDao.save(user);
        System.out.println("User Details Saved.");
    }
}
