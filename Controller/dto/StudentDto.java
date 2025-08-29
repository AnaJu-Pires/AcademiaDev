package Controller.dto;

import java.util.List;

import Model.Enrollment.Enrollment;
public class StudentDto extends UserDto {

    private String subscriptionPlanDto;
    private List<Enrollment> enrollments;

    public StudentDto(String name, String email, String subscriptionPlanDto) {
        super(name, email);
        this.subscriptionPlanDto = subscriptionPlanDto;
    }



    public String getSubscriptionPlanDto() {
        return subscriptionPlanDto;
    }


    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
    
}
