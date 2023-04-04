package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController  {
    @Autowired
    private PropertyService propertyService;

    @PostMapping("/properties")
    public ResponseEntity saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.saveProperty(propertyDTO);

        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        List<PropertyDTO> propertyList = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
       return responseEntity;
    }

    @PutMapping("/properties/{propertyid}")
    public ResponseEntity updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyid){
        propertyDTO = propertyService.updateProperty(propertyDTO, propertyid);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping ("/properties/update-description/{propertyid}")
    public ResponseEntity updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyid){
        propertyDTO = propertyService.updatePropertyDescription(propertyDTO, propertyid);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/properties/{propertyid}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyid){
        propertyService.deleteProperty(propertyid);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
