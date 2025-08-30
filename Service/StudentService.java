package Service;

import Controller.dto.StudentDto;
import Model.Policy.BasicPlan;
import Model.Policy.PremiumPlan;
import Model.Policy.SubscriptionPlan;
import Model.User.Student;
import Repository.impl.StudentRepositoryImpl;

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

    
}
