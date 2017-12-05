package com.prarthana.auctionapp.LoginService;
import com.prarthana.auctionapp.LoginService.model.Userdetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  UserRepository extends MongoRepository<Userdetails, String> {
    public Userdetails findByUsername(String username);

}
