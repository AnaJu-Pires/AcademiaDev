package Repository;

import java.util.TreeSet;

import Model.User.Admin;

public interface AdminRepository {

    TreeSet<Admin> admins = new TreeSet<>();
    
    void addAdmin(Admin admin);
    
}
