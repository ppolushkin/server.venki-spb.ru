package ru.venkispb.server.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.venkispb.server.entity.Admin;

public interface AdminRepository extends PagingAndSortingRepository<Admin, Long> {
}
