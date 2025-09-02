package Service;


import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import Repository.EnrollmentRepository;
import Repository.impl.CourseRepositoryImpl;
import Repository.impl.EnrollmentRepositoryImpl;

import Model.Course.Course;
import Controller.dto.StudentDto;
import Exception.BusinessException;
import Exception.CourseNotFoundException;
import Exception.EnrollmentNotFoundException;
import Model.Enrollment.Enrollment;
import Controller.dto.CourseDto;
import Controller.dto.EnrollmentDto;
import Util.GenericCsvExporter;

import Model.User.Student;
import Model.Policy.PremiumPlan;

public class EnrollmentService {
    private final EnrollmentRepositoryImpl enrollmentRepositoryImpl;
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepositoryImpl courseRepository;

    public EnrollmentService(EnrollmentRepositoryImpl enrollmentRepositoryImpl, CourseRepositoryImpl courseRepository, EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepositoryImpl = enrollmentRepositoryImpl;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
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


        public List<EnrollmentDto> viewEnrolledCourses(StudentDto studentDto) {
            Map<Integer, Enrollment> enrollments = enrollmentRepositoryImpl.getEnrollments();

            List<EnrollmentDto> enrolledCourses = new ArrayList<>();
            for (Enrollment enrollment : enrollments.values()) {
                if (enrollment.getStudent().getName().equals(studentDto.getName())) {
                    CourseDto courseDto = new CourseDto(enrollment.getCourse().getTitle(), enrollment.getCourse().getDescription(), enrollment.getCourse().getInstructorName(), enrollment.getCourse().getDurationHours(), enrollment.getCourse().getDifficultyLevel(), enrollment.getCourse().getStatus()); 
                    enrolledCourses.add(new EnrollmentDto(enrollment.getId(), studentDto, courseDto, enrollment.getProgress()));
                }
            }

            return enrolledCourses;
        }

        public int getCourseProgress(StudentDto studentDto, String courseName) {
            courseRepository.searchByName(courseName)
                .orElseThrow(() -> new CourseNotFoundException("The course '" + courseName + "' does not exist."));

            Enrollment enrollment = enrollmentRepository.findByStudentEmailAndCourseName(studentDto.getEmail(), courseName);
            if (enrollment == null) {
                throw new EnrollmentNotFoundException("You are not enrolled in the course '" + courseName + "'.");
            }
            return enrollment.getProgress();
        }

        public void updateProgress(StudentDto studentDto, String courseName, int newProgress) {
            courseRepository.searchByName(courseName)
                    .orElseThrow(() -> new CourseNotFoundException("The course '" + courseName + "' does not exist."));

            Enrollment enrollment = enrollmentRepository.findByStudentEmailAndCourseName(studentDto.getEmail(), courseName);
            if (enrollment == null) {
                throw new EnrollmentNotFoundException("You are not enrolled in the course '" + courseName + "'.");
            }

            if (newProgress <= enrollment.getProgress()) {
                throw new BusinessException("The new progress (" + newProgress + "%) must be greater than the current progress (" + enrollment.getProgress() + "%).");
            }
            enrollment.setProgress(newProgress);
        }

        public void exportAllEnrollments(List<String> fieldsToInclude) {
            List<Enrollment> enrollments = enrollmentRepository.exportAEnrollments();

            String csv = GenericCsvExporter.export(enrollments, fieldsToInclude);
            System.out.println(csv);
        }

        public void deleteEnrollment(StudentDto studentDto, String courseName) {
            courseRepository.searchByName(courseName)
                    .orElseThrow(() -> new CourseNotFoundException("The course '" + courseName + "' does not exist."));

            Enrollment enrollment = enrollmentRepository.findByStudentEmailAndCourseName(studentDto.getEmail(), courseName);
            if (enrollment == null) {
                throw new EnrollmentNotFoundException("You are not enrolled in the course '" + courseName + "'.");
            }
            enrollmentRepository.delete(enrollment);
            System.out.println("Enrollment deleted successfully.");
        }


    
}
