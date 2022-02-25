package com.example.sqllite_bbdd_formulario;

import android.provider.BaseColumns;

public class Users {
    public static abstract class UsersEntry implements BaseColumns{
        public  static  final String TABLE_NAME = "user";

        public static final String ID = "id";
        public static final String FULL_NAME = "fullName";
        public static final String AGE = "age";
        public static final String EMAIL = "email";
        public static final String ADDRESS = "address";
        public static final String PHONE = "phone";
    }
}
