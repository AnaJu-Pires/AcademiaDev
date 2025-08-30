package Repository.impl;

import java.util.Map;
import java.util.TreeMap;
import Repository.AdminRepository;
import Model.User.Admin;

public class AdminRepositoryImpl implements AdminRepository {

    private final Map<String, Admin> admins = new TreeMap<>();

    @Override
    public void addAdmin(Admin admin) {
        admins.put(admin.getEmail(), admin);
        System.out.println("Admin saved.");
    }

    @Override
    public Admin findByEmail(String email) {
        return admins.get(email);
    }
    
}
