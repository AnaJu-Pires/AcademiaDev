package Model.User;

import java.util.ArrayList;
import java.util.List;

import Model.Enrollment.Enrollment;
import Model.Policy.SubscriptionPlan;

public class Student extends User {

    private SubscriptionPlan subscriptionPlan;
    private List<Enrollment> enrollments;

    public Student(String name, String email, SubscriptionPlan subscriptionPlan, List<Enrollment> enrollments) {
        super(name, email);
        this.subscriptionPlan = subscriptionPlan;
        this.enrollments = enrollments;
    }

    public Student(String name, String email, SubscriptionPlan subscriptionPlan) {
        super(name, email);
        this.subscriptionPlan = subscriptionPlan;
        this.enrollments = new ArrayList<>();
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    

    

    
}
