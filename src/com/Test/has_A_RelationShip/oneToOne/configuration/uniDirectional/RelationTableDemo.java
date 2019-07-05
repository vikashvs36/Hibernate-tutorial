package com.Test.has_A_RelationShip.oneToOne.configuration.uniDirectional;

import com.Dao.UserDao;
import com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional.Capital;
import com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional.State;

public class RelationTableDemo {

    public static void main(String[] args) {
        State state=new State("Punjab", new Capital("Chandigarh"));
        UserDao.save(state);
        System.out.println("Save sucessfully");
    }
}
