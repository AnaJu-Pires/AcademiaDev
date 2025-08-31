package Repository;

import Model.Enrollment.Enrollment;

import java.util.Map;

public interface EnrollmentRepository {
    void saveEnrollment(Enrollment enrollment);

    Map<Integer, Enrollment> getEnrollments();

    Enrollment findByStudentEmailAndCourseName(String studentEmail, String courseName);
}
