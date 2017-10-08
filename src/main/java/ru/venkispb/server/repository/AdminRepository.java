package ru.venkispb.server.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.venkispb.server.entity.AdminsEntity;

public interface AdminRepository extends PagingAndSortingRepository<AdminsEntity, Integer> {
}
