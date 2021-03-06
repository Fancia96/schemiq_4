package project.schemiq.Service;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import project.schemiq.SchemiqApplication;
import project.schemiq.model.UserModel;
import project.schemiq.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static UserRepository userRepository;

    public static UserModel createUser(UserModel userModel) {
        UserModel newBoardRepository = userModel;
        return userRepository.save(newBoardRepository);
    }

//    private static boolean checkIfYouCanCreateUser(String name){
//        for(String bad : SchemiqApplication.badWords){
//            if(name.toLowerCase().contains(bad.toLowerCase())){
//                return false;
//            }
//        }
//        return true;
//    }

    public void deleteUserByID(Long ID){
        userRepository.deleteById(ID);
    }

    public UserModel findUserByID(Long ID){
        Optional<UserModel> user = userRepository.findById(ID);
        if(user.isPresent()){
            return user.get();
        }
        throw new ObjectNotFoundException(UserService.class, SchemiqApplication.userNotFound);
    }

    public UserModel findUserByName(UserModel userModelFind){
        Optional<UserModel> user = userRepository.findUserByName(userModelFind.getName());
        if(user.isPresent()){
            return user.get();
        }
        throw new ObjectNotFoundException(UserService.class, SchemiqApplication.userNotFound);
    }

    public List<UserModel> getEverything(){
        return userRepository.findAll();
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    public UserModel findOne(UserModel userModel) {
        Optional<UserModel> user = userRepository.findById(userModel.getId());
        if(user.isPresent()){

            return user.get();
        }
        return null;
    }

}
