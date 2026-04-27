package klu.model;

import klu.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UsersManager
{
    @Autowired
     UsersRepository UR;
    @Autowired
    EmailManager EM;

    public String addUser(Users U)
    {    
        if (UR.validateEmail(U.getEmail()) > 0)
            return "401::Email already exists";    
        UR.save(U);
        return "200::User Registered Successfully";
    }
    public String recoverPassword(String email)
    {
      Users U = UR.findById(email).get();
      String message = String.format("Dear %s, \n \n Your Password is : %s",U.getFullname(),U.getPassword());
      return EM.sendEmail(U.getEmail(), "JobPortal : Password Recovery", message);
    }
}
