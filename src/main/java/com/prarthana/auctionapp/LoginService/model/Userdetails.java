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
    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {

        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {

        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }




    }



