package Service;

import Controller.dto.AdminDto;
import Model.User.Admin;
import Repository.impl.AdminRepositoryImpl;

public class AdminService {

    private final AdminRepositoryImpl adminRepositoryImpl;

    public AdminService(AdminRepositoryImpl adminRepositoryImpl) {
        this.adminRepositoryImpl = adminRepositoryImpl;
    }

    public void addAdmin(AdminDto adminDto) {
        Admin admin = new Admin(adminDto.getName(), adminDto.getEmail());
        adminRepositoryImpl.addAdmin(admin);
    }

    public AdminDto loginAdmin(String email) {
        Admin admin = adminRepositoryImpl.findByEmail(email);
        if (admin != null) {
            return new AdminDto(admin.getName(), admin.getEmail());
        }
        return null;
    }
    
}
