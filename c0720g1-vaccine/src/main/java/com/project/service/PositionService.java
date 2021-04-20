package com.project.service;

import com.project.entity.Position;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionService {
    /** LuyenNT code
     * @return
     */
    List<Position> getAllPosition();
}
