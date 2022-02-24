package com.example.sqllite_bbdd_formulario;

import android.provider.BaseColumns;

public class Users {
    public static abstract class UsersEntry implements BaseColumns{
        public  static  final String TABLE_NAME = "users";

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String SURNAME = "surname";
        public static final String AGE = "age";
    }
}
