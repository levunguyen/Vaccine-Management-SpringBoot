package com.project.service.impl;

import com.project.entity.Location;
import com.project.repository.LocationRepository;
import com.project.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    /**TrungTQ code lấy danh sách location*/
    @Override
    public List<Location> findAllLocation() {
        return locationRepository.findAllLocation();
    }
}
