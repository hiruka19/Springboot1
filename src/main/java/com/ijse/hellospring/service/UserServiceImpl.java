

// package com.ijse.hellospring.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.ijse.hellospring.entity.User;
// import com.ijse.hellospring.repository.UserRepository;
// import com.ijse.hellospring.service.UserServiceImpl;

// @Service
// public class UserServiceImpl implements UserService {

//   @Autowired
//   private UserRepository userRepository;

//   @Override // Added annotation
//   public List<User> getAllUsers() {
//     return userRepository.findAll();
//   }

//   @Override
//   public User getUserById(Long id) {
//     return userRepository.findById(id).orElse(null);
//   }

//   @Override
//   public User createUser(User user) {
//     return userRepository.save(user);
//   }

//   @Override
//   public User updateUser(Long id, User user) {
//     User existingUser = userRepository.findById(id).orElse(null);

//     if (existingUser != null) {
//       existingUser.setUsername(user.getUsername());
//       existingUser.setEmail(user.getEmail());
//       existingUser.setPassword(user.getPassword());
//       return userRepository.save(existingUser);
//     } else {
//       return null;
//     }
//   }
// }

package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.User;
import com.ijse.hellospring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override // Added annotation
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User updateUser(Long id, User user) {
    User existingUser = userRepository.findById(id).orElse(null);

    if (existingUser != null) {
      existingUser.setUsername(user.getUsername());
      existingUser.setEmail(user.getEmail());
      existingUser.setPassword(user.getPassword());
      return userRepository.save(existingUser);
    } else {
      return null;
    }
  }

  @Override
  public void deleteUser(Long id){
    userRepository.deleteById(id);
  }
}
