package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity covertDTOtoEntity(UserDTO userDTO  ){
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setPassword(userDTO.getPassword());
        return userEntity;
    }

    public UserDTO covertEntityToDTO(UserEntity userEntity  ){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setPhone(userEntity.getPhone());
        return userDTO;
    }
}
