package Controller.dto;

import java.util.List;

import Model.Enrollment.Enrollment;
import Model.Policy.SubscriptionPlan;

public class StudentDto extends UserDto {

    private SubscriptionPlan subscriptionPlan;
    private List<Enrollment> enrollments;

    public StudentDto(String name, String email, SubscriptionPlan subscriptionPlan) {
        super(name, email);
        this.subscriptionPlan = subscriptionPlan;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }


    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
    
}
