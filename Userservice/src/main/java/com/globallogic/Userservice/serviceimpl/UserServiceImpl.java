package com.globallogic.Userservice.serviceimpl;

import com.globallogic.Userservice.dto.UserDto;
import com.globallogic.Userservice.exception.UserAlreadyExistException;
import com.globallogic.Userservice.exception.UserNotFoundException;
import com.globallogic.Userservice.model.Address;
import com.globallogic.Userservice.model.Company;
import com.globallogic.Userservice.model.Geo;
import com.globallogic.Userservice.model.User;
import com.globallogic.Userservice.repository.AddressRepository;
import com.globallogic.Userservice.repository.CompanyRepository;
import com.globallogic.Userservice.repository.GeoRepository;
import com.globallogic.Userservice.repository.UserRepository;
import com.globallogic.Userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    GeoRepository geoRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public UserDto addUser(UserDto userDto) throws UserAlreadyExistException {
        User userDetails = new User();
        userDetails.setEmail(userDto.getEmail());
        userDetails.setName(userDto.getName());
        userDetails.setPhone(userDto.getPhone());
        userDetails.setUserName(userDto.getUserName());
        Address address = new Address();
        address.setCity(userDto.getAddress().getCity());
        address.setStreet(userDto.getAddress().getStreet());
        address.setAddressId(userDto.getUserId());
        Address savedAddress = addressRepository.save(address);
        Geo geo = new Geo();
        geo.setLatitude(userDto.getGeo().getLatitude());
        geo.setLongitude(userDto.getGeo().getLongitude());
        geo.setGeoId(userDto.getUserId());
        Geo savedGeo = geoRepository.save(geo);
        Company company = new Company();
        company.setLocation(userDto.getCompany().getName());
        company.setName(userDto.getCompany().getLocation());
        company.setCompanyId(userDto.getUserId());
        Company savedCompany = companyRepository.save(company);
        userDetails.setAddress(savedAddress);
        userDetails.setGeo(savedGeo);
        userDetails.setCompany(savedCompany);
        userRepository.save(userDetails);
        return  userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) throws UserNotFoundException {
        Optional<User> optUser=userRepository.findById(userDto.getUserId());
        if(optUser.isPresent()) {
            User userDetails =optUser.get();
            userDetails.setEmail(userDto.getEmail());
            userDetails.setName(userDto.getName());
            userDetails.setPhone(userDto.getPhone());
            userDetails.setUserName(userDto.getUserName());
            Address address = new Address();
            address.setCity(userDto.getAddress().getCity());
            address.setStreet(userDto.getAddress().getStreet());
            address.setAddressId(userDto.getUserId());
            Address savedAddress = addressRepository.save(address);
            Geo geo = new Geo();
            geo.setLatitude(userDto.getGeo().getLatitude());
            geo.setLongitude(userDto.getGeo().getLongitude());
            geo.setGeoId(userDto.getUserId());
            Geo savedGeo = geoRepository.save(geo);
            Company company = new Company();
            company.setLocation(userDto.getCompany().getName());
            company.setName(userDto.getCompany().getLocation());
            company.setCompanyId(userDto.getUserId());
            Company savedCompany = companyRepository.save(company);
            userDetails.setAddress(savedAddress);
            userDetails.setGeo(savedGeo);
            userDetails.setCompany(savedCompany);
            userRepository.save(userDetails);
            return  userDto;
        }
        else
        {
            log.error("User not found to update");
            throw new UserNotFoundException("User not found to update");
        }

    }

    @Override
    public User findUserById(int userId) throws UserNotFoundException {
        Optional<User> optUser=userRepository.findById(userId);
        if(optUser.isPresent())
        {
            log.info("user is found to be returned");
            return optUser.get();
        }
        else
        {
            log.error("user is not present to be returned");
            throw new UserNotFoundException("User is not found");
        }
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int userId) throws UserNotFoundException {
        Optional<User> optUser=userRepository.findById(userId);
        if(optUser.isPresent())
        {
            log.info("user is found to be deleted");
            userRepository.deleteById(userId);
        }
        else
        {
            log.error("user is not present to be deleted");
            throw new UserNotFoundException("User is not found");
        }

    }
}
