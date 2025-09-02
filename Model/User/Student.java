package Model.User;


import Model.Policy.SubscriptionPlan;

public class Student extends User {

    private SubscriptionPlan subscriptionPlan;
    //private List<Enrollment> enrollments;

    public Student(String name, String email, SubscriptionPlan subscriptionPlan) {
        super(name, email);
        this.subscriptionPlan = subscriptionPlan;

    }
    
    public Student(String name, String email) {
        super(name, email);
    }
    
    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public String getRole(){
        return "Student";
    }
    
}
