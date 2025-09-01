package Repository.impl;

import Model.Enrollment.Enrollment;
import Repository.EnrollmentRepository;

import java.util.stream.Collectors;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EnrollmentRepositoryImpl implements EnrollmentRepository {
    private final Map<Integer, Enrollment> enrollments = new TreeMap<>();

    @Override
    public void saveEnrollment(Enrollment enrollment) {
        this.enrollments.put(enrollment.getId(), enrollment); //devo criar o id aqui?

    }

    @Override
    public Map<Integer, Enrollment> getEnrollments() {  //teste para a matricula, depois ve se mantem
        return this.enrollments;
    }


    @Override
    public Enrollment findByStudentEmailAndCourseName(String studentEmail, String courseName) {
    for (Enrollment enrollment : enrollments.values()) {
        if (enrollment.getStudent().getEmail().equals(studentEmail)
                && enrollment.getCourse().getTitle().equals(courseName)) {
            return enrollment;
        }
    }
    return null;
    }

    @Override
    public List<Enrollment> exportAEnrollments() {
        return this.enrollments.values().stream().collect(Collectors.toList());
    }

}
