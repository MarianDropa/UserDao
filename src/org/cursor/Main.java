package org.cursor;


public class Main {

    public static void main(String[] args) {
   // User marian5 = new User("marian5", "fkрafuffgq");
    //User marian1 = new User("marian1", "fkрafuffgq");
   // User marian2 = new User("marian2", "fkрafuffgq");
    //UserDaoImpl.addUser(new User("marian4", "flalfakkl", true));
     //UserDaoImpl.addUser("marian4", "aofkao");

       UserDaoImpl.lockUser(2, true);
        System.out.println(UserDaoImpl.getAll());
       // System.out.println(UserDaoImpl.getById(2));
    //  System.out.println(UserDaoImpl.getAll());
        //System.out.println(UserDaoImpl.userdb.size());
       // UserDaoImpl.userdb.add(new User("marian", "aifjajfa", false));
       // UserDaoImpl.userdb.add(new User("marian2", "aifjajfa", false));
       // UserDaoImpl.userdb.add(new User("marian3", "aifjajfa", false));
       // System.out.println(UserDaoImpl.userdb);
    }
}
