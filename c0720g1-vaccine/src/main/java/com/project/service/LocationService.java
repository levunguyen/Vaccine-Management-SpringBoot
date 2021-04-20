package com.project.service;

import com.project.entity.Location;

import java.util.List;

public interface LocationService {
    /**
     * TrungTQ code: Lấy danh sách địa điểm
     * */
    List<Location> findAllLocation();
}
