package com.thigpen.login_reg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.thigpen.login_reg.models.LoginUser;
import com.thigpen.login_reg.models.User;
import com.thigpen.login_reg.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {

//		creates the users and validates
		if(this.userRepo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "This email is already in use!");
		}
    
//		this validation is to make sure the password and confirm password match
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
    
		if(result.hasErrors()) {	
			return null;
		} else {
//	if filled out correctly will hash password and set that to user to go in db hashed
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        
       		return userRepo.save(newUser); //save the user object to database
		}
	}
	
	
	
	public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        
        //checking to find a user in the database who has the given email
        Optional<User> potentialUser = this.userRepo.findByEmail(newLogin.getEmail());
        
        //if email does not exist, give error message
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        //get the user object that was found from the db who has that email from the login form
        User user = potentialUser.get();
        
        //use bcrypt to check if the user object from db has a password that matched the one from the form
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
        //if the password does not match, create another validation error message 	
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
	
	
	 public User findUser(Long id) {
 		return this.userRepo.findById(id).orElse(null);
	 }
	

}
