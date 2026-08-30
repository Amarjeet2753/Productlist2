//package com.example.product.services;
//
//import com.example.product.entity.User;
//import com.example.product.repository.UserRepository;
//import com.example.product.security.UserPrincipal;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public User creatUser(User user){
//        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
//         return  userRepository.save(user);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUsername(username);
//
//        if(user.isEmpty()) throw  new UsernameNotFoundException("User not found!");
//        return new UserPrincipal(user.get());
//    }
//}
