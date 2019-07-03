package com.Test.has_A_RelationShip.configuration.oneToOne.uniDirectional;

import com.Dao.UserDao;
import com.modal.has_A_RelationShip.configuration.oneToOne.uniDirectional.Capital;
import com.modal.has_A_RelationShip.configuration.oneToOne.uniDirectional.State;

public class PrimaryKey_ForeignKey_Demo {

    public static void main(String[] args) {
        State state=new State("Punjab", new Capital("Chandigarh"));
        UserDao.save(state);
        System.out.println("Save sucessfully");
    }
}
