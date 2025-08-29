package Repository.impl;

import Model.Enrollment.Enrollment;
import Repository.EnrollmentRepository;

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
}
