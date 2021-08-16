package org.example.cinema.repos;

import org.example.cinema.domain.Screening;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ScreeningRepo extends JpaRepository<Screening, Long> {
    Page<Screening> findAllByOrderByScreeningDateTime(Pageable page);
    void deleteById(Long id);
    @Query("select a from Screening a where a.screeningDateTime >= :screeningDateTime")
    Page<Screening> findAllWithScreeningDateTimeAfterByOrderByScreeningDateTime(Pageable pageable,
            @Param("screeningDateTime") LocalDateTime screeningDateTime);

}
