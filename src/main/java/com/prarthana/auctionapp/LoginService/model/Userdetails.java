package com.prarthana.auctionapp.LoginService.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")



public class Userdetails {

    @Id
    private String id;

    private String Username;

    private String Password;



    public String getId() {

        return id;
    }

    public String Username() {

        return Username;
    }

    public String Password() {

        return Password;
    }


}
