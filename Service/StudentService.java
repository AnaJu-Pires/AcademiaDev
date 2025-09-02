package Service;

import Controller.dto.StudentDto;
import Model.Policy.BasicPlan;
import Model.Policy.PremiumPlan;
import Model.Policy.SubscriptionPlan;
import Model.User.Student;
import Repository.impl.StudentRepositoryImpl;
import java.util.List;
import Util.GenericCsvExporter;

public class StudentService {
    private final StudentRepositoryImpl studentRepositoryImpl;

    public StudentService(StudentRepositoryImpl studentRepositoryImpl) {
        this.studentRepositoryImpl = studentRepositoryImpl;
    }

    public void createStudent( StudentDto studentDto) {
        String planName = studentDto.getSubscriptionPlanDto();

        SubscriptionPlan plan = null;
        if(planName.equals("Basic")) {
            plan = new BasicPlan();
        } else if(planName.equals("Premium")) {
            plan = new PremiumPlan();
        }else{
        throw new IllegalArgumentException("Tipo de plano inválido: " + planName);
        }

        Student student = new Student(studentDto.getName(), studentDto.getEmail(), plan);
        studentRepositoryImpl.saveStudent(student);
    }

    public StudentDto loginStudent(String email) {
        Student student = studentRepositoryImpl.findByEmail(email);
        if (student != null) {
            return new StudentDto(student.getName(), student.getEmail(), student.getSubscriptionPlan().getPlanName());
            
        }
        return null;
    }

    public void exportAllStudents(List<String> fieldsToInclude) {
        List<Student> students = studentRepositoryImpl.exportAllStudents();
        String csv = GenericCsvExporter.export(students, fieldsToInclude);
        System.out.println(csv);
    }

    public void changeSubscriptionPlan(String email, String planName) {
        Student student = studentRepositoryImpl.findByEmail(email);
        if (student != null) {
            SubscriptionPlan plan = null;
            if (planName.equals("Basic")) {
                plan = new BasicPlan();
            } else if (planName.equals("Premium")) {
                plan = new PremiumPlan();
            } else {
                throw new IllegalArgumentException("Plan not found: " + planName);
            }
            student.changeSubscriptionPlan(plan);
            System.out.println("Subscription plan changed successfully!\n\n");
            
        }
    }

    
}
