package com.jv.example.springbootdtotutorial.service;

import com.jv.example.springbootdtotutorial.dto.UserLocationDTO;
import com.jv.example.springbootdtotutorial.model.User;
import com.jv.example.springbootdtotutorial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserLocationDTO> getAllUsersLocations(){
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

//    private UserLocationDTO convertEntityToDto(User user){
//        UserLocationDTO userLocationDTO = new UserLocationDTO();
//
//        userLocationDTO.setUserId(user.getId());
//        userLocationDTO.setEmail(user.getEmail());
//        userLocationDTO.setPlace(user.getLocation().getPlace());
//        userLocationDTO.setLongitude(user.getLocation().getLongitude());
//        userLocationDTO.setLatitude(user.getLocation().getLatitude());
//
//        return  userLocationDTO;
//    }
    private UserLocationDTO convertEntityToDto(User user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO = modelMapper.map(user, UserLocationDTO.class);
        return  userLocationDTO;
    }

    private User convertDtoToEntity(UserLocationDTO userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User user = new User();
        user = modelMapper.map(userLocationDTO, User.class);
        return user;
    }
}
