package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties ();
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyid);
    PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyid);
    void deleteProperty(Long propertyid);
}
