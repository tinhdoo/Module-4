package c0525g1_spring_boot.repository;


import c0525g1_spring_boot.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassroomRepository extends JpaRepository<Classroom, Integer> {
}
