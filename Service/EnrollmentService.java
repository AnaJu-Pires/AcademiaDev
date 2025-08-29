package Service;


import java.util.Optional;


import Repository.impl.CourseRepositoryImpl;
import Repository.impl.EnrollmentRepositoryImpl;

import Model.Course.Course;
import Controller.dto.StudentDto;
import Model.Enrollment.Enrollment;

import Model.User.Student;
import Model.Policy.PremiumPlan;

public class EnrollmentService {
    private final EnrollmentRepositoryImpl enrollmentRepositoryImpl;
    private final CourseRepositoryImpl courseRepository;

    public EnrollmentService(EnrollmentRepositoryImpl enrollmentRepositoryImpl, CourseRepositoryImpl courseRepository) {
        this.enrollmentRepositoryImpl = enrollmentRepositoryImpl;
        this.courseRepository = courseRepository;
    }
    

    public void enrollInCourse(String courseName, StudentDto studentDto) {
        int id = enrollmentRepositoryImpl.getEnrollments().size() + 1;
        int count = 0;
        if(studentDto.getSubscriptionPlanDto().equals("Basic")){ 
            
            Enrollment[] enrollments = enrollmentRepositoryImpl.getEnrollments().values().toArray(new Enrollment[0]);
            for (Enrollment enrollment : enrollments) {
                if (enrollment.getStudent().getName().equals(studentDto.getName())) {
                    count++;
                }
            }
            if(count >= 3) {
                System.out.println("You have already enrolled in 3 courses.");
                return;
            }
            
        }
        Student student = new Student(studentDto.getName(), studentDto.getEmail(), new PremiumPlan());
        Optional<Course> course = courseRepository.searchByName(courseName);

        if (course.isPresent()) {
            Course courseObj = course.get();
            Enrollment enrollment = new Enrollment(id, student, courseObj);
            enrollmentRepositoryImpl.saveEnrollment(enrollment);
            System.out.println("Enrollment successful com id: " + id + ".");
        } else {
            System.out.println("Course not found.");
        }
        }
}
